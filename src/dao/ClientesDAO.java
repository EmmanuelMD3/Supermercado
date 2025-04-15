/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import conexion.Conexion;
import java.sql.Connection;
import modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author chemo
 */
public class ClientesDAO
{

    public static boolean agregarCliente(Cliente cliente)
    {
        String sql = "INSERT INTO clientes (nombre, apellido, telefono, email, direccion, fecha_nacimiento, password) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellido());
            pstmt.setString(3, cliente.getTelefono());
            pstmt.setString(4, cliente.getEmail());
            pstmt.setString(5, cliente.getDireccion());
            pstmt.setDate(6, new java.sql.Date(cliente.getFecha_nacimiento().getTime()));
            pstmt.setString(7, cliente.getPassword());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.err.println("Error al agregar el cliente: " + e.getMessage());
            return false;
        }
    }

}
