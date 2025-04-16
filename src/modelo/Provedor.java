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
public class Provedor
{
    private int provedor_id;
    private String nombre;
    private String contacto;
    private String telefono;
    private String email;
    private String direccion;
    private boolean activo;
    private Date fecha_registro;

    public Provedor()
    {
    }

    public Provedor(String nombre, String contacto, String telefono, String email, String direccion, boolean activo)
    {
        this.nombre = nombre;
        this.contacto = contacto;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.activo = activo;
    }

    public Provedor(int provedor_id, String nombre, String contacto, String telefono, String email, String direccion, boolean activo, Date fecha_registro)
    {
        this.provedor_id = provedor_id;
        this.nombre = nombre;
        this.contacto = contacto;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.activo = activo;
        this.fecha_registro = fecha_registro;
    }

    /**
     * @return the provedor_id
     */
    public int getProvedor_id()
    {
        return provedor_id;
    }

    /**
     * @param provedor_id the provedor_id to set
     */
    public void setProvedor_id(int provedor_id)
    {
        this.provedor_id = provedor_id;
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
     * @return the contacto
     */
    public String getContacto()
    {
        return contacto;
    }

    /**
     * @param contacto the contacto to set
     */
    public void setContacto(String contacto)
    {
        this.contacto = contacto;
    }

    /**
     * @return the telefono
     */
    public String getTelefono()
    {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    /**
     * @return the email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * @return the direccion
     */
    public String getDireccion()
    {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion)
    {
        this.direccion = direccion;
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
     * @return the fecha_registro
     */
    public Date getFecha_registro()
    {
        return fecha_registro;
    }

    /**
     * @param fecha_registro the fecha_registro to set
     */
    public void setFecha_registro(Date fecha_registro)
    {
        this.fecha_registro = fecha_registro;
    }   
}
