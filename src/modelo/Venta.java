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
public class Venta
{

    private int venta_id;
    private Date fecha_venta;
    private double total;
    private double descuento;
    private double impuesto;
    private int cliente_id;
    private int empleado_id;
    private int metodo_pago;
    private int estado;

    public Venta()
    {
    }

    public Venta(int venta_id, Date fecha_venta, double total, double descuento, double impuesto, int cliente_id, int empleado_id, int metodo_pago, int estado)
    {
        this.venta_id = venta_id;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.descuento = descuento;
        this.impuesto = impuesto;
        this.cliente_id = cliente_id;
        this.empleado_id = empleado_id;
        this.metodo_pago = metodo_pago;
        this.estado = estado;
    }

    public Venta(double total, double descuento, double impuesto, int cliente_id, int empleado_id, int metodo_pago, int estado)
    {
        this.total = total;
        this.descuento = descuento;
        this.impuesto = impuesto;
        this.cliente_id = cliente_id;
        this.empleado_id = empleado_id;
        this.metodo_pago = metodo_pago;
        this.estado = estado;
    }
    
    
    
    

    /**
     * @return the venta_id
     */
    public int getVenta_id()
    {
        return venta_id;
    }

    /**
     * @param venta_id the venta_id to set
     */
    public void setVenta_id(int venta_id)
    {
        this.venta_id = venta_id;
    }

    /**
     * @return the fecha_venta
     */
    public Date getFecha_venta()
    {
        return fecha_venta;
    }

    /**
     * @param fecha_venta the fecha_venta to set
     */
    public void setFecha_venta(Date fecha_venta)
    {
        this.fecha_venta = fecha_venta;
    }

    /**
     * @return the total
     */
    public double getTotal()
    {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total)
    {
        this.total = total;
    }

    /**
     * @return the descuento
     */
    public double getDescuento()
    {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(double descuento)
    {
        this.descuento = descuento;
    }

    /**
     * @return the impuesto
     */
    public double getImpuesto()
    {
        return impuesto;
    }

    /**
     * @param impuesto the impuesto to set
     */
    public void setImpuesto(double impuesto)
    {
        this.impuesto = impuesto;
    }

    /**
     * @return the cliente_id
     */
    public int getCliente_id()
    {
        return cliente_id;
    }

    /**
     * @param cliente_id the cliente_id to set
     */
    public void setCliente_id(int cliente_id)
    {
        this.cliente_id = cliente_id;
    }

    /**
     * @return the empleado_id
     */
    public int getEmpleado_id()
    {
        return empleado_id;
    }

    /**
     * @param empleado_id the empleado_id to set
     */
    public void setEmpleado_id(int empleado_id)
    {
        this.empleado_id = empleado_id;
    }

    /**
     * @return the metodo_pago
     */
    public int getMetodo_pago()
    {
        return metodo_pago;
    }

    /**
     * @param metodo_pago the metodo_pago to set
     */
    public void setMetodo_pago(int metodo_pago)
    {
        this.metodo_pago = metodo_pago;
    }

    /**
     * @return the estado
     */
    public int getEstado()
    {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado)
    {
        this.estado = estado;
    }
}
