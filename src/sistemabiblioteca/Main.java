/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabiblioteca;

import clase.Usuario;
import javax.swing.JFrame;


/**
 *
 * @author David
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterfazLogin ventana=new InterfazLogin();
        ventana.setLocationRelativeTo(null);
        ventana.setSize(520, 110);
        ventana.setVisible(true);
        ventana.setVisiblePanelAlumno(false);
    }
    
}
