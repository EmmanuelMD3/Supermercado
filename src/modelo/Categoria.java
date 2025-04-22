package modelo;

import java.util.Date;

public class Categoria
{

    private int id_categoria;
    private String nombre;
    private String descripccion;
    private int porcentaje;
    private boolean activo;
    private Date fecha_creacion;

    public Categoria()
    {
    }

    public Categoria(String nombre, String descripccion, int porcentaje, boolean activo)
    {
        this.nombre = nombre;
        this.descripccion = descripccion;
        this.porcentaje = porcentaje;
        this.activo = activo;
    }

    public Categoria(int id_categoria, String nombre, String descripccion, int porcentaje, boolean activo, Date fecha_creacion)
    {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
        this.descripccion = descripccion;
        this.porcentaje = porcentaje;
        this.activo = activo;
        this.fecha_creacion = fecha_creacion;
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

    /**
     * @return the activo
     */
    public boolean isActivo()
    {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo)
    {
        this.activo = activo;
    }

    /**
     * @return the fecha_creacion
     */
    public Date getFecha_creacion()
    {
        return fecha_creacion;
    }

    /**
     * @param fecha_creacion the fecha_creacion to set
     */
    public void setFecha_creacion(Date fecha_creacion)
    {
        this.fecha_creacion = fecha_creacion;
    }

    /**
     * @return the porcentaje
     */
    public int getPorcentaje()
    {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(int porcentaje)
    {
        this.porcentaje = porcentaje;
    }
}
