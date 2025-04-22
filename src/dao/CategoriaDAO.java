package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
        String sql = "INSERT INTO Categoria (categoria_id, nombre, descripcion, porcentaje, activo) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, categoria.getId_categoria());
            pstmt.setString(2, categoria.getNombre());
            pstmt.setString(3, categoria.getDescripccion());
            pstmt.setInt(4, categoria.getPorcentaje());
            pstmt.setBoolean(5, categoria.isActivo());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e)
        {
            e.printStackTrace();
            System.err.println("Error al agregar la categoría: " + e.getMessage());
            return false;
        }
    }

    public static List<Categoria> listarCategorias()
    {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        try (Connection conn = Conexion.conectar(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql))
        {
            while (rs.next())
            {
                Categoria categoria = new Categoria(
                        rs.getInt("categoria_id"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getInt("porcentaje"),
                        rs.getBoolean("activo"),
                        rs.getDate("fecha_creacion")
                );
                categorias.add(categoria);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al listar las categorías: " + e.getMessage());
        }

        return categorias;
    }

    public void eliminarCategoria(long categoriaId)
    {
        String sql = "DELETE FROM categoria WHERE categoria_id = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setLong(1, categoriaId);

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

    public List<Categoria> obtenerTodosLasCategorias()
    {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT categoria_id, nombre, descripcion, porcentaje, activo, fecha_creacion FROM categoria";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next())
            {
                Categoria categoria = new Categoria();

                categoria.setId_categoria(rs.getInt("categoria_id"));
                categoria.setNombre(rs.getString("nombre"));
                categoria.setDescripccion(rs.getString("descripcion"));
                categoria.setPorcentaje(rs.getInt("porcentaje"));
                categoria.setActivo(rs.getBoolean("activo"));
                categoria.setFecha_creacion(rs.getDate("fecha_creacion"));

                categorias.add(categoria);
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener los propietarios: " + e.getMessage());
        }
        return categorias;
    }

    public boolean modificarCategoria(Categoria categoria)
    {
        String sql = "UPDATE categoria SET nombre = ?, descripcion = ?, porcentaje = ?, activo = ? WHERE categoria_id = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, categoria.getNombre());
            pstmt.setString(2, categoria.getDescripccion());
            pstmt.setInt(3, categoria.getPorcentaje());
            pstmt.setBoolean(4, categoria.isActivo());
            pstmt.setLong(5, categoria.getId_categoria());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al modificar la categoría: " + e.getMessage());
            return false;
        }
    }

    public int obtenerIdPorNombre(String nombre)
    {
        String sql = "SELECT categoria_id FROM categoria WHERE nombre = ?";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, nombre);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                return rs.getInt("categoria_id");
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener el ID: " + e.getMessage());
        }
        return -1;
    }

    public int obtenerPorcentajePorNombre(String nombreCategoria)
    {
        int porcentaje = -1;
        String sql = "SELECT porcentaje FROM categoria WHERE nombre = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {

            pstmt.setString(1, nombreCategoria);
            try (ResultSet rs = pstmt.executeQuery())
            {
                if (rs.next())
                {
                    porcentaje = rs.getInt("porcentaje");
                }
            }
        } catch (SQLException e)
        {
            System.err.println("Error al obtener el porcentaje por nombre: " + e.getMessage());
        }

        return porcentaje;
    }

}
