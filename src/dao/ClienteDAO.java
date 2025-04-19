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

    public boolean actualizarCliente(Cliente cliente)
    {
        String sql = "UPDATE cliente SET nombre = ?, apellido = ?, telefono = ?, email = ?, direccion = ?, fecha_nacimiento = ?, password = ?, activo = ? WHERE cliente_id = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getApellido());
            pstmt.setString(3, cliente.getTelefono());
            pstmt.setString(4, cliente.getEmail());
            pstmt.setString(5, cliente.getDireccion());
            pstmt.setDate(6, new java.sql.Date(cliente.getFecha_nacimiento().getTime()));
            pstmt.setString(7, cliente.getPassword());
            pstmt.setBoolean(8, cliente.isActivo());
            pstmt.setLong(9, cliente.getCliente_id());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al actualizar el cliente: " + e.getMessage());
            return false;
        }
    }

    public List<Cliente> obtenerTodosLosClientes()
    {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT cliente_id, nombre, apellido, telefono, email, direccion, fecha_nacimiento, password, activo, fecha_registro FROM cliente";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {

            while (rs.next())
            {
                Cliente cliente = new Cliente();
                cliente.setCliente_id(rs.getInt("cliente_id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setEmail(rs.getString("email"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setFecha_nacimiento(rs.getDate("fecha_nacimiento"));
                cliente.setPassword(rs.getString("password"));
                cliente.setActivo(rs.getBoolean("activo"));
                cliente.setFecha_registro(rs.getTimestamp("fecha_registro"));

                clientes.add(cliente);
            }

        } catch (SQLException e)
        {
            System.err.println("Error al obtener los clientes: " + e.getMessage());
        }

        return clientes;
    }

}
