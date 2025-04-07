/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author chemo
 */
public class Categoria
{
    private int id_categoria;
    private String nombre;
    private String descripccion;
    
    public Categoria()
    {
    }

    public Categoria(int id_categoria, String nombre, String descripccion)
    {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.descripccion = descripccion;
    }

    /**
     * @return the id_categoria
     */
    public int getId_categoria()
    {
        return id_categoria;
    }

    /**
     * @param id_categoria the id_categoria to set
     */
    public void setId_categoria(int id_categoria)
    {
        this.id_categoria = id_categoria;
    }

    /**
     * @return the nombre
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @return the descripccion
     */
    public String getDescripccion()
    {
        return descripccion;
    }

    /**
     * @param descripccion the descripccion to set
     */
    public void setDescripccion(String descripccion)
    {
        this.descripccion = descripccion;
    } 
}
