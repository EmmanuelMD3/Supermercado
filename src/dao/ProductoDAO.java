/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import modelo.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chemo
 */
public class ProductoDAO
{

    public static boolean agregarProducto(Producto producto)
    {
        String sql = "INSERT INTO producto (nombre, descripcion, precio_compra, precio_venta, stock_minimo, categoria_id, proveedor_id, activo) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, producto.getNombre());
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setDouble(3, producto.getPrecio_compra());
            pstmt.setDouble(4, producto.getPrecio_venta());
            pstmt.setInt(5, producto.getStock_minimo());
            pstmt.setInt(6, producto.getCategoria_id());
            pstmt.setInt(7, producto.getProveedor_id());
            pstmt.setBoolean(8, producto.isActivo());

            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al registrar producto: " + e.getMessage());
            return false;
        }
    }

    public static List<Producto> listarProductos()
    {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                Producto producto = new Producto(
                        rs.getInt("producto_id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getDouble("precio_compra"),
                        rs.getDouble("precio_venta"),
                        rs.getInt("stock_minimo"),
                        rs.getInt("categoria_id"),
                        rs.getInt("proveedor_id"),
                        rs.getBoolean("activo"),
                        rs.getDate("fecha_creacion")
                );
                productos.add(producto);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar los productos: " + e.getMessage());
        }

        return productos;
    }

    public List<Object[]> listarProductosConNombres()
    {
        List<Object[]> productos = new ArrayList<>();

        String sql = "SELECT p.producto_id, p.nombre, p.descripcion, p.precio_compra, p.precio_venta, "
                + "p.stock_minimo, c.nombre AS nombre_categoria, pr.nombre AS nombre_proveedor, "
                + "p.activo, p.fecha_creacion, i.cantidad AS inventario "
                + "FROM producto p "
                + "LEFT JOIN categoria c ON p.categoria_id = c.categoria_id "
                + "LEFT JOIN provedor pr ON p.proveedor_id = pr.proveedor_id "
                + "LEFT JOIN inventario i ON p.producto_id = i.producto_id";

        try (Connection conn = Conexion.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery())
        {
            while (rs.next())
            {
                Object[] fila = new Object[]
                {
                    rs.getInt("producto_id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio_compra"),
                    rs.getDouble("precio_venta"),
                    rs.getInt("stock_minimo"),
                    rs.getString("nombre_categoria"),
                    rs.getString("nombre_proveedor"),
                    rs.getBoolean("activo") ? "Activo" : "Inactivo",
                    rs.getTimestamp("fecha_creacion"),
                    rs.getInt("inventario")
                };
                productos.add(fila);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return productos;
    }

    public boolean actualizarProducto(Producto producto)
    {
        String sql = "UPDATE producto SET nombre = ?, descripcion = ?, precio_compra = ?, precio_venta = ?, "
                + "stock_minimo = ?, categoria_id = ?, proveedor_id = ?, activo = ? "
                + "WHERE producto_id = ?";

        try (Connection con = Conexion.conectar(); PreparedStatement ps = con.prepareStatement(sql))
        {
            ps.setString(1, producto.getNombre());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3, producto.getPrecio_compra());
            ps.setDouble(4, producto.getPrecio_venta());
            ps.setInt(5, producto.getStock_minimo());
            ps.setInt(6, producto.getCategoria_id());
            ps.setInt(7, producto.getProveedor_id());
            ps.setBoolean(8, producto.isActivo());
            ps.setInt(9, producto.getProducto_id());

            return ps.executeUpdate() > 0;

        } catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProducto(int productoId)
    {
        String sql = "DELETE FROM producto WHERE producto_id = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, productoId);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al eliminar el producto: " + e.getMessage());
            return false;
        }
    }

    public int agregarProductoYObtenerId(Producto producto)
    {
        String sql = "INSERT INTO producto (nombre, descripcion, precio_compra, precio_venta, stock_minimo, categoria_id, proveedor_id, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {
            pstmt.setString(1, producto.getNombre());
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setDouble(3, producto.getPrecio_compra());
            pstmt.setDouble(4, producto.getPrecio_venta());
            pstmt.setInt(5, producto.getStock_minimo());
            pstmt.setInt(6, producto.getCategoria_id());
            pstmt.setInt(7, producto.getProveedor_id());
            pstmt.setBoolean(8, producto.isActivo());

            int filas = pstmt.executeUpdate();

            if (filas > 0)
            {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next())
                {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e)
        {
            System.err.println("Error al agregar producto: " + e.getMessage());
        }
        return -1;
    }

    public List<Object[]> listarProductosConNombresYStock()
    {
        List<Object[]> productos = new ArrayList<>();

        String sql = "SELECT p.producto_id, p.nombre, p.descripcion, p.precio_compra, p.precio_venta, "
                + "p.stock_minimo, c.nombre AS nombre_categoria, pr.nombre AS nombre_proveedor, "
                + "p.activo, p.fecha_creacion, IFNULL(i.cantidad, 0) AS cantidad "
                + "FROM producto p "
                + "LEFT JOIN categoria c ON p.categoria_id = c.categoria_id "
                + "LEFT JOIN provedor pr ON p.proveedor_id = pr.proveedor_id "
                + "LEFT JOIN inventario i ON p.producto_id = i.producto_id";

        try (Connection conn = Conexion.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery())
        {
            while (rs.next())
            {
                Object[] fila = new Object[]
                {
                    rs.getInt("producto_id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getDouble("precio_compra"),
                    rs.getDouble("precio_venta"),
                    rs.getInt("stock_minimo"),
                    rs.getString("nombre_categoria"),
                    rs.getString("nombre_proveedor"),
                    rs.getBoolean("activo") ? "Activo" : "Inactivo",
                    rs.getTimestamp("fecha_creacion"),
                    rs.getInt("cantidad")
                };
                productos.add(fila);
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return productos;
    }

}
