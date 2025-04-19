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
public class Producto
{
    private int producto_id;
    private String nombre;
    private String descripcion;
    private double precio_compra;
    private double precio_venta;
    private int stock_minimo;
    private int categoria_id;
    private int proveedor_id;
    private boolean activo;
    private Date fecha_creacion;

    public Producto()
    {
    }

    public Producto(int producto_id, String nombre, String descripcion, double precio_compra, double precio_venta, int stock_minimo, int categoria_id, int proveedor_id, boolean activo, Date fecha_creacion)
    {
        this.producto_id = producto_id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.stock_minimo = stock_minimo;
        this.categoria_id = categoria_id;
        this.proveedor_id = proveedor_id;
        this.activo = activo;
        this.fecha_creacion = fecha_creacion;
    }

    public Producto(String nombre, String descripcion, double precio_compra, double precio_venta, int stock_minimo, int categoria_id, int proveedor_id, boolean activo)
    {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.stock_minimo = stock_minimo;
        this.categoria_id = categoria_id;
        this.proveedor_id = proveedor_id;
        this.activo = activo;
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
     * @return the descripcion
     */
    public String getDescripcion()
    {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    /**
     * @return the precio_compra
     */
    public double getPrecio_compra()
    {
        return precio_compra;
    }

    /**
     * @param precio_compra the precio_compra to set
     */
    public void setPrecio_compra(double precio_compra)
    {
        this.precio_compra = precio_compra;
    }

    /**
     * @return the precio_venta
     */
    public double getPrecio_venta()
    {
        return precio_venta;
    }

    /**
     * @param precio_venta the precio_venta to set
     */
    public void setPrecio_venta(double precio_venta)
    {
        this.precio_venta = precio_venta;
    }

    /**
     * @return the stock_minimo
     */
    public int getStock_minimo()
    {
        return stock_minimo;
    }

    /**
     * @param stock_minimo the stock_minimo to set
     */
    public void setStock_minimo(int stock_minimo)
    {
        this.stock_minimo = stock_minimo;
    }

    /**
     * @return the categoria_id
     */
    public int getCategoria_id()
    {
        return categoria_id;
    }

    /**
     * @param categoria_id the categoria_id to set
     */
    public void setCategoria_id(int categoria_id)
    {
        this.categoria_id = categoria_id;
    }

    /**
     * @return the proveedor_id
     */
    public int getProveedor_id()
    {
        return proveedor_id;
    }

    /**
     * @param proveedor_id the proveedor_id to set
     */
    public void setProveedor_id(int proveedor_id)
    {
        this.proveedor_id = proveedor_id;
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
}
