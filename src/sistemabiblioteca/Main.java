/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabiblioteca;

import clase.Usuario;
import java.util.ArrayList;
import javax.swing.JFrame;


/**
 *
 * @author David
 */
public class Main {

     //Creando ArrayList
    
    public ArrayList<Usuario> lista(){
        ArrayList<Usuario> listaUsuario =new ArrayList<>();
        Usuario A=new Usuario("159794466", "david", "villegas", "david@gmailcom", "1234");
        Usuario B=new Usuario("111111111", "juan", "perez", "david@gmailcom", "1234", "Ingenieria Informatica", "¿Cual es el nombre de mi perro?", "bobi");
        listaUsuario.add(A);
        listaUsuario.add(B);
        return listaUsuario;
    }
    
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
