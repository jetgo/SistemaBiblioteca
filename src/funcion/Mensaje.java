/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcion;

import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class Mensaje {
    
    public static void informacionAdvertencia(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "MENSAJE ADVERTENCIA", 2, null);
    }
    
    public static void informacionError(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "MENSAJE ERROR GRAVE", 8);
    }
    
    public static int confirmacionSimple(String mensaje){
        int respuesta;
        respuesta = JOptionPane.showConfirmDialog(null, "SELECCIONE UNA OPCION",mensaje, JOptionPane.YES_NO_OPTION);
        return respuesta;
    }
}
