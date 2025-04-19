/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;

/**
 *
 * @author chemo
 */
public class Inventario
{
    private int inventario_id;
    private int producto_id;
    private int cantidad;
    private Date fecha_actualizacion;

    public Inventario()
    {
    }

    public Inventario(int producto_id, int cantidad)
    {
        this.producto_id = producto_id;
        this.cantidad = cantidad;
    }

    public Inventario(int inventario_id, int producto_id, int cantidad, Date fecha_actualizacion)
    {
        this.inventario_id = inventario_id;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.fecha_actualizacion = fecha_actualizacion;
    }

    /**
     * @return the inventario_id
     */
    public int getInventario_id()
    {
        return inventario_id;
    }

    /**
     * @param inventario_id the inventario_id to set
     */
    public void setInventario_id(int inventario_id)
    {
        this.inventario_id = inventario_id;
    }

    /**
     * @return the producto_id
     */
    public int getProducto_id()
    {
        return producto_id;
    }

    /**
     * @param producto_id the producto_id to set
     */
    public void setProducto_id(int producto_id)
    {
        this.producto_id = producto_id;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad()
    {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad)
    {
        this.cantidad = cantidad;
    }

    /**
     * @return the fecha_actualizacion
     */
    public Date getFecha_actualizacion()
    {
        return fecha_actualizacion;
    }

    /**
     * @param fecha_actualizacion the fecha_actualizacion to set
     */
    public void setFecha_actualizacion(Date fecha_actualizacion)
    {
        this.fecha_actualizacion = fecha_actualizacion;
    }   
}
