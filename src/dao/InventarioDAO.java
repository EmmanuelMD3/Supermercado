/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import modelo.Inventario;
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
public class InventarioDAO
{

    public boolean insertarInventario(Inventario inventario)
    {
        String sql = "INSERT INTO inventario (producto_id, cantidad, fecha_actualizacion) VALUES (?, ?, NOW())";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, inventario.getProducto_id());
            pstmt.setInt(2, inventario.getCantidad());

            int filas = pstmt.executeUpdate();
            return filas > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al insertar inventario: " + e.getMessage());
            return false;
        }
    }

    public int obtenerCantidadPorProductoId(int productoId)
    {
        int cantidad = 0;

        String sql = "SELECT cantidad FROM inventario WHERE producto_id = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement ps = conn.prepareStatement(sql))
        {

            ps.setInt(1, productoId);

            try (ResultSet rs = ps.executeQuery())
            {
                if (rs.next())
                {
                    cantidad = rs.getInt("cantidad");
                }
            }

        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return cantidad;
    }

    public boolean actualizarCantidadInventario(int productoId, int nuevaCantidad)
    {
        String sql = "UPDATE inventario SET cantidad = ? WHERE producto_id = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, nuevaCantidad);
            pstmt.setInt(2, productoId);
            int filasAfectadas = pstmt.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al actualizar inventario: " + e.getMessage());
            return false;
        }
    }

}
