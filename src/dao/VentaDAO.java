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

}
