/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cjb.ci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author MS2
 */
public class Lecturas
{

    private static InputStreamReader isr = new InputStreamReader(System.in);
    private static BufferedReader br = new BufferedReader(isr);

    /**
     * Método que sirve para leer un entero
     *
     * @param jf recibe null si el mensaje es a consola o el objeto ventana en
     * donde se quiera emitir el mensaje de error
     * @return 0 si el dato proporcionado no es un entero o el entero
     * proporcionado
     */
    public static int entero(JFrame jf)
    {
        try
        {
            return Integer.parseInt(br.readLine());
        } catch (Exception ex)
        {
            Mensajes.error(jf, "Error..." + ex.toString());
            return 0;
        }
    }

    /**
     * Método que sirve para leer un entero validando que realmente se ingrese
     * un entero de lo contrario permanece ciclicamente
     *
     * @param jf recibe null si el mensaje es a consola o el objeto ventana en
     * donde se quiera emitir el mensaje de error
     * @param b true si desea garantizar la lectura de un entero
     * @return el entero proporcionado
     */
    public static int enteroD(JFrame jf, boolean b)
    {
        do
        {
            try
            {
                return Integer.parseInt(br.readLine());
            } catch (Exception ex)
            {
                Mensajes.error(jf, "Error...se esperaba un entero, vuelva a intentarlo, o verifique el error " + ex.toString());
            }
        } while (b);
        return 0;
    }

    /**
     * Método que sirve para leer un doble
     *
     * @param jf recibe null si el mensaje es a consola o el objeto ventana en
     * donde se quiera emitir el mensaje de error
     * @return 0.0 si el dato proporcionado no es un doble o el doble
     * proporcionado
     */
    public static double doble(JFrame jf)
    {
        try
        {
            return Double.parseDouble(br.readLine());
        } catch (Exception ex)
        {
            Mensajes.error(jf, "Error..." + ex.toString());
            return 0;
        }
    }

    /**
     * Método que sirve para leer un doble validando que realmente se ingrese un
     * doble de lo contrario permanece ciclicamente
     *
     * @param jf recibe null si el mensaje es a consola o el objeto ventana en
     * donde se quiera emitir el mensaje de error
     * @param b true si desea garantizar la lectura de un doble
     * @return el doble proporcionado
     */
    public static double doble(JFrame jf, boolean b)
    {
        do
        {
            try
            {
                return Double.parseDouble(br.readLine());
            } catch (Exception ex)
            {
                Mensajes.error(jf, "Error...se esperaba un valor flotante, vuelva a intentarlo o verifique el error " + ex.toString());
            }
        } while (b);
        return 0;
    }

    /**
     * Método para leer un caracter del teclado
     *
     * @param jf recibe null si el mensaje es a consola o el objeto ventana en
     * donde se quiera emitir el mensaje de error
     * @return el caracter leido o ' ' en caso de haberse presentado un error
     */
    public static char caracter(JFrame jf)
    {
        char c = ' ';
        try
        {
            c = (char) br.read();
            String s = br.readLine();
        } catch (Exception ex)
        {
            Mensajes.error(jf, "Error..." + ex.toString());
        }
        return c;
    }

    /**
     * Método para leer una cadena del teclado
     *
     * @param jf recibe null si el mensaje es a consola o el objeto ventana en
     * donde se quiera emitir el mensaje de error
     * @return cadena leida o si hubo un error retorna "";
     */
    public static String cadena(JFrame jf)
    {
        try
        {
            return br.readLine();
        } catch (Exception ex)
        {
            Mensajes.error(jf, "Error..." + ex.toString());
            return "";
        }
    }

    /**
     * Método para leer una cadena del teclado validando que lleve datos
     *
     * @param jf recibe null si el mensaje es a consola o el objeto ventana en
     * donde se quiera emitir el mensaje de error
     * @param b valor en true si se quiere repetir la lectura hasta que el 
     * usuario lea una cadena
     * @return cadena leida o si hubo un error retorna "";
     */
    public static String cadena(JFrame jf, boolean b)
    {
        String s = "";
        do
        {
            try
            {
                s = br.readLine();
                if (s.trim().equals(""))
                {
                    Mensajes.error(jf, "El valor esperado no puede ser vacio o nulo");
                }else
                {
                    b = false;
                }
            } catch (Exception ex)
            {
                Mensajes.error(jf, "Error..." + ex.toString());
            }
        } while (b);
        return s;
    }

    /**
     * Método que sirve para leer un entero
     *
     * @param jf recibe null si el mensaje es a consola o el objeto ventana en
     * donde se quiera emitir el mensaje de error
     * @return 0 si el dato proporcionado no es un entero o el entero
     * proporcionado
     */
    public static int enteroD(JDialog jf)
    {
        try
        {
            return Integer.parseInt(br.readLine());
        } catch (Exception ex)
        {
            Mensajes.errorD(jf, "Error..." + ex.toString());
            return 0;
        }
    }

    /**
     * Método que sirve para leer un entero validando que realmente se ingrese
     * un entero de lo contrario permanece ciclicamente
     *
     * @param jf recibe null si el mensaje es a consola o el objeto ventana en
     * donde se quiera emitir el mensaje de error
     * @param b true si desea garantizar la lectura de un entero
     * @return el entero proporcionado
     */
    public static int enteroD(JDialog jf, boolean b)
    {
        do
        {
            try
            {
                return Integer.parseInt(br.readLine());
            } catch (Exception ex)
            {
                Mensajes.errorD(jf, "Error...se esperaba un entero, vuelva a intentarlo, o verifique el error " + ex.toString());
            }
        } while (b);
        return 0;
    }

    /**
     * Método que sirve para leer un doble
     *
     * @param jf recibe null si el mensaje es a consola o el objeto ventana en
     * donde se quiera emitir el mensaje de error
     * @return 0.0 si el dato proporcionado no es un doble o el doble
     * proporcionado
     */
    public static double dobleD(JDialog jf)
    {
        try
        {
            return Double.parseDouble(br.readLine());
        } catch (Exception ex)
        {
            Mensajes.errorD(jf, "Error..." + ex.toString());
            return 0;
        }
    }

    /**
     * Método que sirve para leer un doble validando que realmente se ingrese un
     * doble de lo contrario permanece ciclicamente
     *
     * @param jf recibe null si el mensaje es a consola o el objeto ventana en
     * donde se quiera emitir el mensaje de error
     * @param b true si desea garantizar la lectura de un doble
     * @return el doble proporcionado
     */
    public static double dobleD(JDialog jf, boolean b)
    {
        do
        {
            try
            {
                return Double.parseDouble(br.readLine());
            } catch (Exception ex)
            {
                Mensajes.errorD(jf, "Error...se esperaba un valor flotante, vuelva a intentarlo o verifique el error " + ex.toString());
            }
        } while (b);
        return 0;
    }

    /**
     * Método para leer un caracter del teclado
     *
     * @param jf recibe null si el mensaje es a consola o el objeto ventana en
     * donde se quiera emitir el mensaje de error
     * @return el caracter leido o ' ' en caso de haberse presentado un error
     */
    public static char caracterD(JDialog jf)
    {
        char c = ' ';
        try
        {
            c = (char) br.read();
            String s = br.readLine();
        } catch (Exception ex)
        {
            Mensajes.errorD(jf, "Error..." + ex.toString());
        }
        return c;
    }

    /**
     * Método para leer una cadena del teclado
     *
     * @param jf recibe null si el mensaje es a consola o el objeto ventana en
     * donde se quiera emitir el mensaje de error
     * @return cadena leida o si hubo un error retorna "";
     */
    public static String cadenaD(JDialog jf)
    {
        try
        {
            return br.readLine();
        } catch (Exception ex)
        {
            Mensajes.errorD(jf, "Error..." + ex.toString());
            return "";
        }
    }
}
