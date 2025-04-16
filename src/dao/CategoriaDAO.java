package dao;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Categoria;
import java.util.Date;
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
        String sql = "INSERT INTO Categoria (categoria_id, nombre, descripcion, activo) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, categoria.getId_categoria());
            pstmt.setString(2, categoria.getNombre());
            pstmt.setString(3, categoria.getDescripccion());
            pstmt.setBoolean(4, categoria.isActivo());

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
        String sql = "SELECT categoria_id, nombre, descripcion, activo, fecha_creacion FROM categoria";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery())
        {
            while (rs.next())
            {
                Categoria categoria = new Categoria();

                categoria.setId_categoria(rs.getInt("categoria_id"));
                categoria.setNombre(rs.getString("nombre"));
                categoria.setDescripccion(rs.getString("descripcion"));
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
        String sql = "UPDATE categoria SET nombre = ?, descripcion = ?, activo = ? WHERE categoria_id = ?";

        try (Connection conn = Conexion.conectar(); PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, categoria.getNombre());
            pstmt.setString(2, categoria.getDescripccion());
            pstmt.setBoolean(3, categoria.isActivo());
            pstmt.setLong(4, categoria.getId_categoria());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e)
        {
            System.err.println("Error al modificar la categoría: " + e.getMessage());
            return false;
        }
    }

}
