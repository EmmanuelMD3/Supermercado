/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author chemo
 */
public class DetallesVenta
{

    private int detalle_id;
    private int venta_id;
    private int producto_id;
    private int cantidad;
    private double precio_unitario;
    private double subtotal;

    public DetallesVenta()
    {
    } 

    public DetallesVenta(int detalle_id, int venta_id, int producto_id, int cantidad, double precio_unitario, double subtotal)
    {
        this.detalle_id = detalle_id;
        this.venta_id = venta_id;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
    }

    public DetallesVenta(int venta_id, int producto_id, int cantidad, double precio_unitario, double subtotal)
    {
        this.venta_id = venta_id;
        this.producto_id = producto_id;
        this.cantidad = cantidad;
        this.precio_unitario = precio_unitario;
        this.subtotal = subtotal;
    }

    /**
     * @return the detalle_venta
     */
    public int getdetalle_id()
    {
        return detalle_id;
    }

    /**
     * @param detalle_id the detalle_venta to set
     */
    public void setdetalle_id(int detalle_id)
    {
        this.detalle_id = detalle_id;
    }

    /**
     * @return the venta
     */
    public int getventa_id()
    {
        return venta_id;
    }

    /**
     * @param venta the venta to set
     */
    public void setventa_id(int venta)
    {
        this.venta_id = venta;
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
     * @return the precio_unitario
     */
    public double getPrecio_unitario()
    {
        return precio_unitario;
    }

    /**
     * @param precio_unitario the precio_unitario to set
     */
    public void setPrecio_unitario(double precio_unitario)
    {
        this.precio_unitario = precio_unitario;
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal()
    {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal)
    {
        this.subtotal = subtotal;
    }

}
