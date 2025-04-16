/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import modelo.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chemo
 */
public class ClienteDAO
{

    public static boolean agregarCliente(Cliente cliente)
    {
        String sql = "INSERT INTO cliente (nombre, apellido, telefono, email, direccion, fecha_nacimiento, password) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellido());
            pstmt.setString(3, cliente.getTelefono());
            pstmt.setString(4, cliente.getEmail());
            pstmt.setString(5, cliente.getDireccion());
            pstmt.setDate(6, new java.sql.Date(cliente.getFecha_nacimiento().getTime()));
            pstmt.setString(7, cliente.getPassword());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al registrar cliente: " + e.getMessage());
            return false;
        }
    }

    public static List<Cliente> obtenerClientes()
    {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try (Connection conn = Conexion.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery())
        {
            while (rs.next())
            {
                Cliente c = new Cliente(
                        rs.getInt("cliente_id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("direccion"),
                        rs.getDate("fecha_nacimiento"),
                        rs.getString("password"),
                        rs.getDate("fecha_registro"),
                        rs.getBoolean("activo")
                );
                c.setCliente_id(rs.getInt("cliente_id"));
                lista.add(c);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener clientes: " + e.getMessage());
        }

        return lista;
    }

    public boolean eliminarCliente(int idCliente)
    {
        String sql = "DELETE FROM cliente WHERE cliente_id = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, idCliente);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al eliminar el cliente: " + e.getMessage());
            return false;
        }
    }

}
