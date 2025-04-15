/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cjb.ci;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 * Clase para llevar a cabo validaciones simples en cajas de texto en un
 * ambiente de pantallas de java
 *
 * @author Lenovo
 */
public class Validaciones
{

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un número
     * entero, de no ser así lo elimina
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     */
    public static void validaEntero(KeyEvent ke)
    {
        if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                && ke.getKeyCode() != 8)
        {
            ke.setKeyChar((char) 8);
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un número
     * entero, de no ser así lo elimina, validando la longitud maxima de la
     * misma
     *
     * @param ke bjeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     * @param len longitud maxima que se le dará a la caja de texto
     * @param s cadena de la caja de texto que se esta validando para ver su
     * longitud
     */
    public static void validaEntero(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                    && ke.getKeyCode() != 8)
            {
                ke.setKeyChar((char) 8);
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un número
     * entero o entero negativo, de no ser así lo elimina
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     */
    public static void validaEnteroNegativo(KeyEvent ke)
    {
        if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                && ke.getKeyCode() != 8 && ke.getKeyChar() != '-')
        {
            ke.setKeyChar((char) 8);
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un número
     * entero o entero negativo, de no ser así lo elimina, validando la longitud
     * maxima de la misma
     *
     * @param ke bjeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     * @param len longitud maxima que se le dará a la caja de texto
     * @param s cadena de la caja de texto que se esta validando para ver su
     * longitud
     */
    public static void validaEnteroNegativo(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                    && ke.getKeyCode() != 8 && ke.getKeyChar() != '-')
            {
                ke.setKeyChar((char) 8);
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un número
     * con uso de punto flotante, de no ser así lo elimina
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     */
    public static void validaFlotantes(KeyEvent ke)
    {
        if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                && ke.getKeyCode() != 8 && ke.getKeyChar() != '.')
        {
            ke.setKeyChar((char) 8);
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un número
     * con uso de punto flotante o flotante negativo, de no ser así lo elimina
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     */
    public static void validaFlotantesNegativos(KeyEvent ke)
    {
        if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                && ke.getKeyCode() != 8 && ke.getKeyChar() != '.'
                && ke.getKeyChar() != '-')
        {
            ke.setKeyChar((char) 8);
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un número
     * con uso de punto flotante, de no ser así lo elimina, validando la
     * longitud maxima de la misma
     *
     * @param ke bjeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     * @param len longitud maxima que se le dará a la caja de texto
     * @param s cadena de la caja de texto que se esta validando para ver su
     * longitud
     */
    public static void validaFlotantes(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                    && ke.getKeyCode() != 8 && ke.getKeyChar() != '.')
            {
                ke.setKeyChar((char) 8);
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un número
     * con uso de punto flotante o flotante negativo, de no ser así lo elimina,
     * validando la longitud maxima de la misma
     *
     * @param ke bjeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     * @param len longitud maxima que se le dará a la caja de texto
     * @param s cadena de la caja de texto que se esta validando para ver su
     * longitud
     */
    public static void validaFlotantesNegativos(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            if ((ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                    && ke.getKeyCode() != 8 && ke.getKeyChar() != '.'
                    && ke.getKeyChar() != '-')
            {
                ke.setKeyChar((char) 8);
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un
     * caracter alfabético, de no ser así lo elimina
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     */
    public static void validaAlfabeticos(KeyEvent ke)
    {
        va(ke);
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un
     * caracter alfabético, de no ser así lo elimina, ademas verifica la logitud
     * máxima permitida en dicha caja de texto
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     * @param len longitud máxima que se permitira capturar en la caja de texto
     * @param s cadena de la caja de texto que se esta validando para ver su
     * longitud
     */
    public static void validaAlfabeticos(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            va(ke);
        }
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un
     * alfanumérico, de no ser así lo elimina
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     */
    public static void validaAlfanumerico(KeyEvent ke)
    {
        van(ke);
    }

    /**
     * Método que se coloca en el evento KeyType de una caja de texto con el fin
     * de que al precionar un caracter del teclado se verifique si es un
     * alfanumérico, de no ser así lo elimina y verifica la longitud maxima de
     * caracteres que se pueden capturar en la caja
     *
     * @param ke Objeto que refiere a la tecla atrapada por el KeyType de una
     * caja de texto de java
     * @param len longitud máxima que se permitira capturar en la caja de texto
     * @param s cadena de la caja de texto que se esta validando para ver su
     * longitud
     */
    public static void validaAlfanumerico(KeyEvent ke, int len, String s)
    {
        if (s.length() == len)
        {
            ke.consume();
        } else
        {
            van(ke);
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de verificar si el contenido de la misma es entero
     *
     * @param jt Caja de texto a evaluar
     * @return verdadero si el contenido de la caja es un entero y false si el
     * contenido de la misma no es un entero
     */
    public static boolean verificaEntero(JTextField jt)
    {
        try
        {
            int x = Integer.parseInt(jt.getText());
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de verificar si el contenido de la misma es un número con punto
     * flotante
     *
     * @param jt Caja de texto a evaluar
     * @return verdadero si el contenido de la caja es un un número con punto
     * flotante y false si el contenido de la misma no lo es
     */
    public static boolean verificaDoble(JTextField jt)
    {
        try
        {
            double x = Double.parseDouble(jt.getText());
            return true;
        } catch (Exception e)
        {
            return false;
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea una cadena y cambia a otro objeto
     *
     * @param jf Nombre del frame donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param obj Objeto al que se desea pasar al momento de dar enter
     */
    public static void enter(JFrame jf, KeyEvent ke, Object obj)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (obj != null)
            {
                CtrlInterfaz.cambia(obj);
            }
        }
    }

    public static boolean enter(JFrame jf, KeyEvent ke)
    {
        return ke.getKeyChar() == '\n';
    }
    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea una cadena y cambia a otro objeto
     *
     * @param jf Nombre del frame donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param obj Objeto al que se desea pasar al momento de dar enter
     * @param s recibe la caja de texto actual que se esta validando
     */
    public static void enterCadenaNoVacia(JFrame jf, KeyEvent ke, JTextField s, Object obj)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (s.getText().length() != 0)
            {
                if (obj != null)
                {
                    CtrlInterfaz.cambia(obj);
                }
            } else
            {
                Mensajes.error(jf, "La caja no puede estar vacia");
                s.requestFocus();
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea una cadena convirtiendo su contenido a
     * mayusculas y cambia a otro objeto
     *
     * @param jf Nombre del frame donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param obj Objeto al que se desea pasar al momento de dar enter
     * @param jt caja de texto que se desea pasar a mayusculas o "" si no desea
     * pasar nada a mayusculas
     */
    public static void enter(JFrame jf, KeyEvent ke, Object obj, JTextField jt)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (jt != null)
            {
                if (!jt.getText().equals(""))
                {
                    jt.setText(jt.getText().toUpperCase());
                }
                if (obj != null)
                {
                    CtrlInterfaz.cambia(obj);
                }
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea una cadena y cambia a otro objeto pero
     * si esta vacia marca error y no permite el cambio
     *
     * @param jf Nombre del frame donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param obj Objeto al que se desea pasar al momento de dar enter
     * @param jt caja de texto que se verifica que no este vacia
     * @param s texto que desea aparezca como mensaje de error
     */
    public static void enter(JFrame jf, KeyEvent ke, Object obj, JTextField jt, String s)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (jt != null)
            {
                if (!jt.getText().equals(""))
                {
                    if (obj != null)
                    {
                        CtrlInterfaz.cambia(obj);
                    }
                } else
                {
                    Mensajes.error(jf, s);
                    CtrlInterfaz.cambia(jt);
                }
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea un entero y cambia a otro objeto
     *
     * @param jf Nombre del frame donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param jt Caja de texto donde se verifica que exista un entero
     * @param obj Objeto al que se desea pasar al momento de dar enter
     */
    public static void enterEntero(JFrame jf, KeyEvent ke,
            JTextField jt, Object obj)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (jt != null)
            {
                if (verificaEntero(jt))
                {
                    if (obj != null)
                    {
                        CtrlInterfaz.cambia(obj);
                    }
                } else
                {
                    Mensajes.error(jf, "Se esperaba un entero");
                    CtrlInterfaz.selecciona(jt);
                }
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea un valor flotante y cambia a otro
     * objeto
     *
     * @param jf Nombre del frame donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param jt Caja de texto donde se verifica que exista un entero
     * @param obj Objeto al que se desea pasar al momento de dar enter
     */
    public static void enterFlotante(JFrame jf, KeyEvent ke,
            JTextField jt, Object obj)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (jt != null)
            {
                if (verificaDoble(jt))
                {
                    if (obj != null)
                    {
                        CtrlInterfaz.cambia(obj);
                    }
                } else
                {
                    Mensajes.error(jf, "Se esperaba un flotante");
                    CtrlInterfaz.selecciona(jt);
                }
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea una cadena y cambia a otro objeto
     *
     * @param jd Nombre del dialog donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param obj Objeto al que se desea pasar al momento de dar enter
     */
    public static void enter(JDialog jd, KeyEvent ke, Object obj)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (obj != null)
            {
                CtrlInterfaz.cambia(obj);
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea una cadena y cambia a otro objeto
     *
     * @param jd Nombre del dialog donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param obj Objeto al que se desea pasar al momento de dar enter
     * @param jt caja de texto que se desea pasar a mayusculas o "" si no desea
     * pasar nada a mayusculas
     */
    public static void enter(JDialog jd, KeyEvent ke, Object obj, JTextField jt)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (jt != null)
            {
                if (!jt.getText().equals(""))
                {
                    jt.setText(jt.getText().toUpperCase());
                }
                if (obj != null)
                {
                    CtrlInterfaz.cambia(obj);
                }
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea un entero y cambia a otro objeto
     *
     * @param jd Nombre del dialog donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param jt Caja de texto donde se verifica que exista un entero
     * @param obj Objeto al que se desea pasar al momento de dar enter
     */
    public static void enterEntero(JDialog jd, KeyEvent ke,
            JTextField jt, Object obj)

    {
        if (ke.getKeyChar() == '\n')
        {
            if (jt != null)
            {
                if (verificaEntero(jt))
                {
                    if (obj != null)
                    {
                        CtrlInterfaz.cambia(obj);
                    }
                } else
                {
                    Mensajes.errorD(jd, "Se esperaba un entero");
                    CtrlInterfaz.selecciona(jt);
                }
            }
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea un valor flotante y cambia a otro
     * objeto
     *
     * @param jd Nombre del dialog donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param jt Caja de texto donde se verifica que exista un entero
     * @param obj Objeto al que se desea pasar al momento de dar enter
     */
    public static void enterFlotante(JDialog jd, KeyEvent ke,
            JTextField jt, Object obj)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (jt != null)
            {
                if (verificaDoble(jt))
                {
                    if (obj != null)
                    {
                        CtrlInterfaz.cambia(obj);
                    }
                } else
                {
                    Mensajes.errorD(jd, "Se esperaba un flotante");
                    CtrlInterfaz.selecciona(jt);
                }
            }
        }
    }

    /**
     * Metodo privado para validar alfabeticos
     *
     * @param ke
     */
    private static void va(KeyEvent ke)
    {
        if ((ke.getKeyChar() < 'a' || ke.getKeyChar() > 'z')
                && (ke.getKeyChar() < 'A' || ke.getKeyChar() > 'Z')
                && ke.getKeyCode() != 8 && ke.getKeyChar() != '.'
                && ke.getKeyChar() != ' ' && ke.getKeyChar() != 'ñ'
                && ke.getKeyChar() != 'Ñ' && ke.getKeyChar() != 'á'
                && ke.getKeyChar() != 'Á' && ke.getKeyChar() != 'é'
                && ke.getKeyChar() != 'É' && ke.getKeyChar() != 'í'
                && ke.getKeyChar() != 'Í' && ke.getKeyChar() != 'ó'
                && ke.getKeyChar() != 'Ó' && ke.getKeyChar() != 'ú'
                && ke.getKeyChar() != 'Ú')
        {
            ke.setKeyChar((char) 8);
        }
    }

    /**
     * Método privado para validar alfanumericos
     *
     * @param ke
     */
    private static void van(KeyEvent ke)
    {
        if ((ke.getKeyChar() < 'a' || ke.getKeyChar() > 'z')
                && (ke.getKeyChar() < 'A' || ke.getKeyChar() > 'Z')
                && (ke.getKeyChar() < '0' || ke.getKeyChar() > '9')
                && ke.getKeyCode() != 8 && ke.getKeyChar() != '.'
                && ke.getKeyChar() != ' ' && ke.getKeyChar() != 'ñ'
                && ke.getKeyChar() != 'Ñ' && ke.getKeyChar() != 'á'
                && ke.getKeyChar() != 'Á' && ke.getKeyChar() != 'é'
                && ke.getKeyChar() != 'É' && ke.getKeyChar() != 'í'
                && ke.getKeyChar() != 'Í' && ke.getKeyChar() != 'ó'
                && ke.getKeyChar() != 'Ó' && ke.getKeyChar() != 'ú'
                && ke.getKeyChar() != 'Ú')
        {
            ke.setKeyChar((char) 8);
        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si el usuario esta queriendo usar el comando ctrl-c,
     * ctrl-v y ctrl-x dentro de la caja de texto
     *
     * @param evt Variable evt del método KeyPress
     * @param jf frame donde se desplegará el mensaje de error
     * @param jt caja de texto que sera limpiada para evitar pegar cortar o
     * copiar inf
     */
    public static void validaCopyPaste(KeyEvent evt, JFrame jf, JTextField jt)
    {
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_C)
        {
            System.out.println("xxxxxxxxx");
            jt.setText("");
            evt.setKeyChar((char) 8);
            evt.setKeyCode(0);
            Mensajes.error(jf, "comando desactivado");
        } else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_X)
        {
            jt.setText("");
            evt.setKeyChar((char) 8);
            evt.setKeyCode(0);
            Mensajes.error(jf, "comando desactivado");
        } else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_V)
        {
            System.out.println("xxxxxxxxx");
            jt.setText("");
            evt.setKeyChar((char) 8);
            evt.setKeyCode(0);
            Mensajes.error(jf, "comando desactivado");

        }
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea un entero retorna true
     *
     * @param jf Nombre del frame donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param jt Caja de texto donde se verifica que exista un entero
     */
    public static boolean enterEnteroBoleano(JFrame jf, KeyEvent ke,
            JTextField jt)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (jt != null)
            {
                if (verificaEntero(jt))
                {
                    return true;
                } else
                {
                    Mensajes.error(jf, "Se esperaba un entero");
                    CtrlInterfaz.selecciona(jt);
                }
            }
        }
        return false;
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea un entero retorna true
     *
     * @param jd Nombre del dialog donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param jt Caja de texto donde se verifica que exista un entero
     */
    public static boolean enterEnteroBoleano(JDialog jd, KeyEvent ke,
            JTextField jt)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (jt != null)
            {
                if (verificaEntero(jt))
                {
                    return true;
                } else
                {
                    Mensajes.errorD(jd, "Se esperaba un entero");
                    CtrlInterfaz.selecciona(jt);
                }
            }
        }
        return false;
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea un flotante retorna true
     *
     * @param jf Nombre del frame donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param jt Caja de texto donde se verifica que exista un entero
     */
    public static boolean enterFlotanteBoleano(JFrame jf, KeyEvent ke,
            JTextField jt)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (jt != null)
            {
                if (verificaDoble(jt))
                {
                    return true;
                } else
                {
                    Mensajes.error(jf, "Se esperaba un flotante");
                    CtrlInterfaz.selecciona(jt);
                }
            }
        }
        return false;
    }

    /**
     * Método que se coloca en el evento KeyPress de una caja de texto con el
     * fin de validar si la tecla presioanada es ENTER siempre y cuando el
     * contenido de la caja de texto sea un flotante retorna true
     *
     * @param jd Nombre del dialog donde se esta haciendo la acción
     * @param ke Variable evt del método KeyPress
     * @param jt Caja de texto donde se verifica que exista un entero
     */
    public static boolean enterFlotanteBoleano(JDialog jd, KeyEvent ke,
            JTextField jt)
    {
        if (ke.getKeyChar() == '\n')
        {
            if (jt != null)
            {
                if (verificaDoble(jt))
                {
                    return true;
                } else
                {
                    Mensajes.errorD(jd, "Se esperaba un flotante");
                    CtrlInterfaz.selecciona(jt);
                }
            }
        }
        return false;
    }
}
