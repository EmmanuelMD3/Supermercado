package dao;

import conexion.Conexion;
import java.sql.Connection;
import modelo.Empleado;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 *
 * @author chemo
 */
public class EmpleadoDAO
{

    public static boolean agregarEmpleado(Empleado empleado)
    {
        String sql = "INSERT INTO empleado (nombre, apellido, telefono, email, direccion, fecha_contratacion, salario, rol_id, usuario, password, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setString(3, empleado.getTelefono());
            pstmt.setString(4, empleado.getEmail());
            pstmt.setString(5, empleado.getDireccion());
            pstmt.setDate(6, (java.sql.Date) empleado.getFecha_contratación());
            pstmt.setDouble(7, empleado.getSalario());
            pstmt.setInt(8, empleado.getRol_id());
            pstmt.setString(9, empleado.getUsuario());
            pstmt.setString(10, empleado.getPassword());
            pstmt.setBoolean(11, empleado.isActivo());

            return pstmt.executeUpdate() > 0;
        } catch (Exception e)
        {
            return false;
        }
    }

    public static List<Empleado> obtenerEmpleados()
    {
        List<Empleado> lista = new ArrayList<>();
        String sql = "SELECT * FROM empleado";

        try (Connection conn = Conexion.conectar(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery())
        {
            while (rs.next())
            {
                Empleado e = new Empleado(
                        rs.getInt("empleado_id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("email"),
                        rs.getString("direccion"),
                        rs.getDate("fecha_contratacion"),
                        rs.getDouble("salario"),
                        rs.getInt("rol_id"),
                        rs.getString("usuario"),
                        rs.getString("password"),
                        rs.getBoolean("activo")
                );
                e.setEmpleado_id(rs.getInt("empleado_id"));
                lista.add(e);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener empleados: " + e.getMessage());
        }

        return lista;
    }

    public boolean eliminarEmpleado(int idEmpleado)
    {
        String sql = "DELETE FROM empleado WHERE empleado_id = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, idEmpleado);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al eliminar el cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean actualizarEmpleado(Empleado empleado)
    {
        String sql = "UPDATE empleado SET nombre = ?, apellido = ?, telefono = ?, email = ?, direccion = ?, fecha_contratacion = ?, salario = ?, rol_id = ?, usuario = ?, password = ?, activo = ? WHERE empleado_id = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, empleado.getNombre());
            pstmt.setString(2, empleado.getApellido());
            pstmt.setString(3, empleado.getTelefono());
            pstmt.setString(4, empleado.getEmail());
            pstmt.setString(5, empleado.getDireccion());
            pstmt.setDate(6, (java.sql.Date) empleado.getFecha_contratación());
            pstmt.setDouble(7, empleado.getSalario());
            pstmt.setInt(8, empleado.getRol_id());
            pstmt.setString(9, empleado.getUsuario());
            pstmt.setString(10, empleado.getPassword());
            pstmt.setBoolean(11, empleado.isActivo());
            pstmt.setInt(12, empleado.getEmpleado_id());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al actualizar el empleado: " + e.getMessage());
            return false;
        }
    }

    public List<Empleado> obtenerTodosLosEmpleados()
    {
        List<Empleado> empleados = new ArrayList<>();
        String sql = "SELECT empleado_id, nombre, apellido, telefono, email, direccion, fecha_contratacion, salario, rol_id, usuario, password, activo FROM empleado";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next())
            {
                Empleado empleado = new Empleado();

                empleado.setEmpleado_id(rs.getInt("empleado_id"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setApellido(rs.getString("apellido"));
                empleado.setTelefono(rs.getString("telefono"));
                empleado.setEmail(rs.getString("email"));
                empleado.setDireccion(rs.getString("direccion"));
                empleado.setFecha_contratación(rs.getDate("fecha_contratacion"));
                empleado.setSalario(rs.getDouble("salario")); // Usa setBigDecimal si manejas BigDecimal
                empleado.setRol_id(rs.getInt("rol_id"));
                empleado.setUsuario(rs.getString("usuario"));
                empleado.setPassword(rs.getString("password"));
                empleado.setActivo(rs.getBoolean("activo"));

                empleados.add(empleado);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener los empleados: " + e.getMessage());
        }

        return empleados;
    }

    public Empleado obtenerRolEId(String usuario, String password)
    {
        String sql = "SELECT empleado_id, rol_id, nombre FROM empleado WHERE usuario = ? AND password = ? AND activo = 1";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, usuario);
            pstmt.setString(2, password);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
            {
                Empleado emp = new Empleado();
                emp.setEmpleado_id(rs.getInt("empleado_id"));
                emp.setRol_id(rs.getInt("rol_id"));
                emp.setNombre(rs.getString("nombre"));

                return emp;
            }
        } catch (SQLException e)
        {
            System.err.println("Error al validar credenciales: " + e.getMessage());
        }

        return null; 
    }

}
