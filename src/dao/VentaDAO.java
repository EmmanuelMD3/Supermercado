/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import modelo.Producto;
import modelo.Inventario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Venta;
import java.text.SimpleDateFormat;
import java.util.Date;
import modelo.DetallesVenta;

/**
 *
 * @author chemo
 */
public class VentaDAO
{

    public List<Inventario> obtenerProductosBasicos()
    {
        List<Inventario> productos = new ArrayList<>();
        String sql = "SELECT p.producto_id, p.nombre, p.precio_venta, i.cantidad AS stock "
                + "FROM producto p "
                + "INNER JOIN inventario i ON p.producto_id = i.producto_id";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next())
            {
                Inventario inv = new Inventario(
                        rs.getInt("stock"),
                        rs.getInt("producto_id"),
                        rs.getString("nombre"),
                        rs.getDouble("precio_venta")
                );

                productos.add(inv);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener los productos: " + e.getMessage());
        }

        return productos;
    }

    public int registrarVenta(Venta venta)
    {
        int idGenerado = -1;
        String sql = "INSERT INTO venta (total, descuento, impuesto, cliente_id, empleado_id, metodo_pago, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            pstmt.setDouble(1, venta.getTotal());
            pstmt.setDouble(2, venta.getDescuento());
            pstmt.setDouble(3, venta.getImpuesto());
            pstmt.setInt(4, venta.getCliente_id());
            pstmt.setInt(5, venta.getEmpleado_id());
            pstmt.setInt(6, venta.getMetodo_pago());
            pstmt.setInt(7, venta.getEstado());

            int filas = pstmt.executeUpdate();

            if (filas > 0)
            {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next())
                {
                    idGenerado = rs.getInt(1);
                }
            }
        } catch (SQLException e)
        {
            System.err.println("Error al registrar venta: " + e.getMessage());
        }

        return idGenerado;
    }

    public List<Object[]> obtenerVentasConDetalles()
    {
        List<Object[]> lista = new ArrayList<>();
        String sql = "SELECT v.venta_id, v.fecha_venta, "
                + "CONCAT(c.nombre, ' ', c.apellido) AS cliente, "
                + "CONCAT(e.nombre, ' ', e.apellido) AS empleado, "
                + "v.total, v.descuento, v.impuesto, "
                + "CASE v.metodo_pago WHEN 0 THEN 'Efectivo' WHEN 1 THEN 'Tarjeta' ELSE 'Otro' END AS metodo_pago, "
                + "CASE v.estado WHEN 1 THEN 'Pagado' ELSE 'Pendiente' END AS estado "
                + "FROM venta v "
                + "JOIN cliente c ON v.cliente_id = c.cliente_id "
                + "JOIN empleado e ON v.empleado_id = e.empleado_id";

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next())
            {
                Object[] fila =
                {
                    rs.getInt("venta_id"),
                    sdf.format(rs.getTimestamp("fecha_venta")),
                    rs.getString("cliente"),
                    rs.getString("empleado"),
                    rs.getDouble("total"),
                    rs.getDouble("descuento"),
                    rs.getDouble("impuesto"),
                    rs.getString("metodo_pago"),
                    rs.getString("estado")
                };
                lista.add(fila);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener ventas: " + e.getMessage());
        }

        return lista;
    }

    public boolean registrarVentaConDetalles(Venta venta, List<DetallesVenta> detalles)
    {
        Connection conn = null;
        PreparedStatement ventaStmt = null;
        PreparedStatement detalleStmt = null;
        PreparedStatement stockStmt = null;

        String ventaSQL = "INSERT INTO venta (total, descuento, impuesto, cliente_id, empleado_id, metodo_pago, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String detalleSQL = "INSERT INTO detalles_venta (venta_id, producto_id, cantidad, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";
        String stockSQL = "UPDATE inventario SET cantidad = cantidad - ? WHERE producto_id = ?";

        try
        {
            conn = Conexion.conectar();
            conn.setAutoCommit(false);

            ventaStmt = conn.prepareStatement(ventaSQL, Statement.RETURN_GENERATED_KEYS);
            ventaStmt.setDouble(1, venta.getTotal());
            ventaStmt.setDouble(2, venta.getDescuento());
            ventaStmt.setDouble(3, venta.getImpuesto());
            ventaStmt.setInt(4, venta.getCliente_id());
            ventaStmt.setInt(5, venta.getEmpleado_id());
            ventaStmt.setInt(6, venta.getMetodo_pago());
            ventaStmt.setInt(7, venta.getEstado());

            int filasVenta = ventaStmt.executeUpdate();
            if (filasVenta == 0)
            {
                conn.rollback();
                return false;
            }

            ResultSet rs = ventaStmt.getGeneratedKeys();
            if (!rs.next())
            {
                conn.rollback();
                return false;
            }

            int ventaId = rs.getInt(1);

            detalleStmt = conn.prepareStatement(detalleSQL);
            stockStmt = conn.prepareStatement(stockSQL);

            for (DetallesVenta d : detalles)
            {
                detalleStmt.setInt(1, ventaId);
                detalleStmt.setInt(2, d.getProducto_id());
                detalleStmt.setInt(3, d.getCantidad());
                detalleStmt.setDouble(4, d.getPrecio_unitario());
                detalleStmt.setDouble(5, d.getSubtotal());
                detalleStmt.executeUpdate();

                stockStmt.setInt(1, d.getCantidad());
                stockStmt.setInt(2, d.getProducto_id());
                stockStmt.executeUpdate();
            }

            conn.commit();
            return true;

        } catch (SQLException e)
        {
            try
            {
                if (conn != null)
                {
                    conn.rollback();
                }
            } catch (SQLException ex2)
            {
                System.err.println("Error en rollback: " + ex2.getMessage());
            }
            System.err.println("Error en transacción de venta: " + e.getMessage());
            return false;

        } finally
        {
            try
            {
                if (ventaStmt != null)
                {
                    ventaStmt.close();
                }
                if (detalleStmt != null)
                {
                    detalleStmt.close();
                }
                if (stockStmt != null)
                {
                    stockStmt.close();
                }
                if (conn != null)
                {
                    conn.setAutoCommit(true);
                }
                conn.close();
            } catch (SQLException e)
            {
                System.err.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }

    public List<Object[]> filtrarVentas(String empleadoNombre, String clienteNombre, Date fecha)
    {
        List<Object[]> lista = new ArrayList<>();
        StringBuilder sql = new StringBuilder(
                "SELECT v.venta_id, v.fecha_venta, CONCAT(c.nombre, ' ', c.apellido), CONCAT(e.nombre, ' ', e.apellido), "
                + "v.total, v.descuento, v.impuesto, v.metodo_pago, v.estado "
                + "FROM venta v "
                + "JOIN cliente c ON v.cliente_id = c.cliente_id "
                + "JOIN empleado e ON v.empleado_id = e.empleado_id WHERE 1=1");

        if (clienteNombre != null && !clienteNombre.equals("Seleccione un Cliente"))
        {
            sql.append(" AND CONCAT(c.nombre, ' ', c.apellido) = ?");
        }

        if (empleadoNombre != null && !empleadoNombre.equals("Seleccione un Empleado"))
        {
            sql.append(" AND CONCAT(e.nombre, ' ', e.apellido) = ?");
        }

        if (fecha != null)
        {
            sql.append(" AND DATE(v.fecha_venta) = ?");
        }

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql.toString()))
        {
            int index = 1;
            if (clienteNombre != null && !clienteNombre.equals("Seleccione un Cliente"))
            {
                pstmt.setString(index++, clienteNombre);
            }

            if (empleadoNombre != null && !empleadoNombre.equals("Seleccione un Empleado"))
            {
                pstmt.setString(index++, empleadoNombre);
            }

            if (fecha != null)
            {
                pstmt.setDate(index, new java.sql.Date(fecha.getTime()));
            }

            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                Object[] fila =
                {
                    rs.getInt(1), 
                    rs.getTimestamp(2), 
                    rs.getString(3), 
                    rs.getString(4), 
                    rs.getDouble(5), 
                    rs.getDouble(6), 
                    rs.getDouble(7), 
                    rs.getInt(8) == 0 ? "Efectivo" : "Tarjeta", // Método pago
                    rs.getInt(9) == 1 ? "Pagado" : "Pendiente"  // Estado
                };
                lista.add(fila);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al filtrar ventas: " + e.getMessage());
        }

        return lista;
    }

}
