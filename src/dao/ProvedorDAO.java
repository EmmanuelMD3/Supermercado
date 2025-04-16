/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Provedor;

/**
 *
 * @author chemo
 */
public class ProvedorDAO
{

    public static boolean agregarProveedor(Provedor proveedor)
    {
        String sql = "INSERT INTO provedor (nombre, contacto, telefono, email, direccion, activo) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, proveedor.getNombre());
            pstmt.setString(2, proveedor.getContacto());
            pstmt.setString(3, proveedor.getTelefono());
            pstmt.setString(4, proveedor.getEmail());
            pstmt.setString(5, proveedor.getDireccion());
            pstmt.setBoolean(6, proveedor.isActivo());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.err.println("Error al agregar el proveedor: " + e.getMessage());
            return false;
        }
    }

    public static List<Provedor> listarProveedores()
    {
        List<Provedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM provedor";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                Provedor proveedor = new Provedor(
                        rs.getInt("proveedor_id"),
                        rs.getString("nombre"),
                        rs.getString("contacto"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("direccion"),
                        rs.getBoolean("activo"),
                        rs.getDate("fecha_registro")
                );
                proveedores.add(proveedor);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar los proveedores: " + e.getMessage());
        }

        return proveedores;
    }

    public List<Provedor> obtenerTodosLosProveedores()
    {
        List<Provedor> proveedores = new ArrayList<>();
        String sql = "SELECT proveedor_id, nombre, contacto, telefono, email, direccion, activo, fecha_registro FROM provedor";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next())
            {
                Provedor proveedor = new Provedor();

                proveedor.setProvedor_id(rs.getInt("proveedor_id"));
                proveedor.setNombre(rs.getString("nombre"));
                proveedor.setContacto(rs.getString("contacto"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setEmail(rs.getString("email"));
                proveedor.setDireccion(rs.getString("direccion"));
                proveedor.setActivo(rs.getBoolean("activo"));
                proveedor.setFecha_registro(rs.getDate("fecha_registro"));

                proveedores.add(proveedor);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener los proveedores: " + e.getMessage());
        }

        return proveedores;
    }

    public void eliminarProvedor(long provedorID)
    {
        String sql = "DELETE FROM provedor WHERE proveedor_id = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setLong(1, provedorID);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0)
            {
                System.out.println("Categoría eliminada con éxito.");
            } else
            {
                System.out.println("No se encontró la categoría con el ID especificado.");
            }
        } catch (SQLException e)
        {
            System.err.println("Error al eliminar la categoría: " + e.getMessage());
        }
    }

    public boolean modificarProveedor(Provedor provedor)
    {
        String sql = "UPDATE provedor SET nombre = ?, contacto = ?, telefono = ?, email = ?, direccion = ?, activo = ? WHERE proveedor_id = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, provedor.getNombre());
            pstmt.setString(2, provedor.getContacto());
            pstmt.setString(3, provedor.getTelefono());
            pstmt.setString(4, provedor.getEmail());
            pstmt.setString(5, provedor.getDireccion());
            pstmt.setBoolean(6, provedor.isActivo());
            pstmt.setInt(7, provedor.getProvedor_id());

            return pstmt.executeUpdate() > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al modificar proveedor: " + e.getMessage());
            return false;
        }
    }

}
