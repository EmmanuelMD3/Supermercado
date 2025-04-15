/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cjb.ci;



import java.awt.Panel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * Clase que permite enviar mensajes a consola o pantalla dependiendo del
 * parámetro enviado y con ello evitar la conversión de métodos que envian
 * mensajes a consola o pantalla
 * @author Lenovo
 */
public class Mensaje
{
    /**
     * Método para enviar mensajes de error, si es a consola es mensaje simple 
     * si es a pantalla aparece con el icono de tache (X)
     * @param jf Objeto de tipo JFrame si es nulo el mensaje recibido se 
     *           despliega en consola, sino se despliega en pantalla como 
     *           ventana emergente
     * @param s Cadena con el mensaje a desplegar
     */
    public static void error(JFrame jf, String s)
    {
        if (jf == null)
        {
            System.out.println(s);
        }else
        {
             JOptionPane.showMessageDialog(jf, s,"Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Método para enviar mensajes de error, si es a consola es mensaje simple 
     * si es a pantalla aparece con el icono de tache (X)
     * @param jf Objeto de tipo JDialog si es nulo el mensaje recibido se 
     *           despliega en consola, sino se despliega en pantalla como 
     *           ventana emergente
     * @param s Cadena con el mensaje a desplegar
     */
    public static void errorD(JDialog jf, String s)
    {
        if (jf == null)
        {
            System.out.println(s);
        }else
        {
             JOptionPane.showMessageDialog(jf, s,"Mensaje de Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Método para enviar mensajes de éxito, si es a consola es mensaje simple 
     * si es a pantalla aparece con el icono de información (i)
     * @param jf Objeto de tipo JFrame si es nulo el mensaje recibido se 
     *           despliega en consola, sino se despliega en pantalla como 
     *           ventana emergente
     * @param s Cadena con el mensaje a desplegar
     */
    public static void exito(JFrame jf, String s)
    {
        if (jf==null)
        {
            System.out.println(s);
        }else
        {
            JOptionPane.showMessageDialog(jf, s,"Mensaje de éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    

     /**
     * Método para enviar mensajes de éxito, si es a consola es mensaje simple 
     * si es a pantalla aparece con el icono de información (i)
     * @param jf Objeto de tipo JDialog si es nulo el mensaje recibido se 
     *           despliega en consola, sino se despliega en pantalla como 
     *           ventana emergente
     * @param s Cadena con el mensaje a desplegar
     */
    public static void exitoD(JDialog jf, String s)
    {
        if (jf==null)
        {
            System.out.println(s);
        }else
        {
            JOptionPane.showMessageDialog(jf, s,"Mensaje de éxito", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    /**
     * Método para enviar mensajes de pregunta, si es a consola es mensaje simple 
     * si es a pantalla aparece con el icono de interrrogación (?)
     * @param jf Objeto de tipo JFrame si es nulo el mensaje recibido se 
     *           despliega en consola, sino se despliega en pantalla como 
     *           ventana emergente
     * @param s Cadena con el mensaje a desplegar
     * @return Valor entero, si la respuesta es si regresa 0, sino regresa 1
     */
    public static int pregunta(JFrame jf, String s)
    {
        if (jf==null)
        {
            System.out.println(s);
            return (Lecturas.entero(jf));
        }else
        {
            return JOptionPane.showConfirmDialog(jf, s,"Mensaje de pregunta", JOptionPane.YES_NO_OPTION);
        }
    }
    /**
     * Método para enviar mensajes de pregunta, si es a consola es mensaje simple 
     * si es a pantalla aparece con el icono de interrrogación (?)
     * @param jf Objeto de tipo JDialog si es nulo el mensaje recibido se 
     *           despliega en consola, sino se despliega en pantalla como 
     *           ventana emergente
     * @param s Cadena con el mensaje a desplegar
     * @return Valor entero, si la respuesta es si regresa 0, sino regresa 1
     */
    public static int preguntaD(JDialog jf, String s)
    {
        if (jf==null)
        {
            System.out.println(s);
            return (Lecturas.enteroD(jf));
        }else
        {
            return JOptionPane.showConfirmDialog(jf, s,"Mensaje de pregunta", JOptionPane.YES_NO_OPTION);
        }
    }
}
