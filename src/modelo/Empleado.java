package modelo;

import java.util.Date;

/**
 *
 * @author chemo
 */
public class Empleado
{
    private int empleado_id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String direccion;
    private Date fecha_contratación;
    private double salario;
    private int rol_id;
    private String usuario;
    private String password;
    private boolean activo;

    public Empleado()
    {
    }

    public Empleado(int empleado_id, String nombre, String apellido, String telefono, String email, String direccion, Date fecha_contratación, double salario, int rol_id, String usuario, String password, boolean activo)
    {
        this.empleado_id = empleado_id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.fecha_contratación = fecha_contratación;
        this.salario = salario;
        this.rol_id = rol_id;
        this.usuario = usuario;
        this.password = password;
        this.activo = activo;
    }

    public Empleado(String nombre, String apellido, String telefono, String email, String direccion, Date fecha_contratación, double salario, int rol_id, String usuario, String password, boolean activo)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        this.fecha_contratación = fecha_contratación;
        this.salario = salario;
        this.rol_id = rol_id;
        this.usuario = usuario;
        this.password = password;
        this.activo = activo;
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
     * @return the apellido
     */
    public String getApellido()
    {
        return apellido;
    }

    /**
     * @param apellido the apellido to set
     */
    public void setApellido(String apellido)
    {
        this.apellido = apellido;
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
     * @return the fecha_contratación
     */
    public Date getFecha_contratación()
    {
        return fecha_contratación;
    }

    /**
     * @param fecha_contratación the fecha_contratación to set
     */
    public void setFecha_contratación(Date fecha_contratación)
    {
        this.fecha_contratación = fecha_contratación;
    }

    /**
     * @return the salario
     */
    public double getSalario()
    {
        return salario;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario)
    {
        this.salario = salario;
    }

    /**
     * @return the rol_id
     */
    public int getRol_id()
    {
        return rol_id;
    }

    /**
     * @param rol_id the rol_id to set
     */
    public void setRol_id(int rol_id)
    {
        this.rol_id = rol_id;
    }

    /**
     * @return the usuario
     */
    public String getUsuario()
    {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password)
    {
        this.password = password;
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
    
    
}
