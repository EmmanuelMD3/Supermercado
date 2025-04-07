/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Categoria;

/**
 *
 * @author chemo
 */
public class CategoriaDAO
{
    public static boolean agregarCategoria(Categoria categoria)
    {
        String sql = "INSERT INTO categorias (id_categoria, nombre, descripcion) VALUES (?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, categoria.getId_categoria());
            pstmt.setString(2, categoria.getNombre());
            pstmt.setString(3, categoria.getDescripccion());
            
            pstmt.executeUpdate();  
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.err.println("Error al agregar el vendedor: " + e.getMessage());
            return false;
        }
    }
}
