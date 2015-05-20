/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.HistorialUsuarioDAO;
import dao.PersonaDAO;
import dao.UsuarioDAO;
import interfaces.General;
import modelo.Persona;
import modelo.Usuario;
import vista.Login;
import vista.Principal;

/**
 *
 * @author David
 */
public class Contenido implements General{
    private Principal ventanaPrincipal;
    private Usuario usuActual;
    private UsuarioDAO usuDAO;
    private Persona perActual;
    private PersonaDAO perDAO;
    private HistorialUsuarioDAO hisUsuDao;

    public Contenido() {
        this.ventanaPrincipal = new Principal(this);
        this.ventanaPrincipal.setTitle("SISTEMA BIBLIOTECA");
        this.ventanaPrincipal.setVisible(true);
        //this.ventanaPrincipal.borrar();
    }
    
    
}
