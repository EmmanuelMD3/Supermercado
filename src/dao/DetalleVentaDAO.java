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
import modelo.DetallesVenta;

/**
 *
 * @author chemo
 */
public class DetalleVentaDAO
{

    public boolean registrarDetalleVenta(DetallesVenta detalle)
    {
        String sql = "INSERT INTO detalles_venta (venta_id, producto_id, cantidad, precio_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, detalle.getventa_id());
            pstmt.setInt(2, detalle.getProducto_id());
            pstmt.setInt(3, detalle.getCantidad());
            pstmt.setDouble(4, detalle.getPrecio_unitario());
            pstmt.setDouble(5, detalle.getSubtotal());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al registrar detalle venta: " + e.getMessage());
            return false;
        }
    }

    public List<Object[]> obtenerFilasParaTabla(int ventaId)
    {
        List<Object[]> lista = new ArrayList<>();

        String sql = "SELECT d.detalle_id, d.venta_id, p.nombre AS nombre_producto, d.cantidad, d.precio_unitario, d.subtotal "
                + "FROM detalles_venta d "
                + "JOIN producto p ON d.producto_id = p.producto_id "
                + "WHERE d.venta_id = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, ventaId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next())
            {
                Object[] fila =
                {
                    rs.getInt("detalle_id"),
                    rs.getInt("venta_id"),
                    rs.getString("nombre_producto"),
                    rs.getInt("cantidad"),
                    rs.getDouble("precio_unitario"),
                    rs.getDouble("subtotal")
                };
                lista.add(fila);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al obtener detalles para tabla: " + e.getMessage());
        }

        return lista;
    }

}
