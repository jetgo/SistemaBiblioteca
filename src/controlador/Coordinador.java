/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import funcion.ManejoSesion;
import funcion.Mensaje;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JDesktopPane;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AbstractDocument.Content;
import modelo.EstadoInterfaz;
import modelo.Persona;
import modelo.Usuario;
import vista.MantenedorUsuarioGUI;
import vista.LoginGUI;
import vista.PrincipalGUI;
import vista.InterfazRecuperaPassword;

/**
 *
 * @author David
 */
public class Coordinador {
    private ControladorLogin controlLogin;
    private LoginGUI ventanaLogin;
    private InterfazRecuperaPassword ventanaRecuperar;
    private PrincipalGUI ventanaPrincipal;
    private MantenedorUsuarioGUI ventanaUsuario;
    

    public ControladorLogin getControladorLogin() {
        return controlLogin;
    }
    
    public InterfazRecuperaPassword getInterfazRecuperar() {
        return ventanaRecuperar;
    }
    public PrincipalGUI getInterfazPrincipal() {
        return ventanaPrincipal;
    }
    
    public void setControladorLogin(ControladorLogin control) {
        this.controlLogin = control;
    }
 
    public void setInterfazRecuperar(InterfazRecuperaPassword miVentana) {
        ventanaRecuperar = new InterfazRecuperaPassword(ventanaLogin, true);
        ventanaRecuperar.setCoordinador(this);
        this.ventanaRecuperar.setTitle("RECUPERACION DE PASSWORD");
        this.ventanaRecuperar.setLocationRelativeTo(ventanaLogin);
        this.ventanaRecuperar.setVisiblePanelCambio(false);      
        this.ventanaRecuperar.setPreguntaSecreta(controlLogin.getPreguntaSecreta());
        this.ventanaRecuperar.setResizable(false);
        this.ventanaRecuperar.setVisible(true);
    }
//        public LoginGUI getInterfazLogin() {
//		return ventanaLogin;
//	}
    public void setInterfazLogin(LoginGUI miVentana) {
        this.controlLogin = new ControladorLogin();
        this.controlLogin.setCoordinador(this);//???
        this.ventanaLogin = miVentana;
        this.ventanaLogin.setTitle("SISTEMA BIBLIOTECA");
        this.ventanaLogin.setLocationRelativeTo(null);
        this.ventanaLogin.setSize(480, 140);
        this.ventanaLogin.setVisiblePanelAlumno(false);
        this.ventanaLogin.setVisible(true);
        this.ventanaLogin.setPreguntaSecreta(controlLogin.getPreguntaSecreta());
    }
    
    public void setInterfazPrincipal(PrincipalGUI miVentana) {
        this.ventanaPrincipal = new PrincipalGUI();
        this.ventanaPrincipal.setCoordinador(this);
        this.ventanaPrincipal.setTitle("SISTEMA DE BIBLIOTECA");
        //ventanaPrincipal.setDimensionesComponentes();
        this.ventanaPrincipal.setVisibleOpciones();
        String miUsuarioId=controlLogin.getSession();
        this.ventanaPrincipal.setComponentes(controlLogin.getInterfazUsuarios(miUsuarioId));
     
        
        this.ventanaPrincipal.setSize(1200, 680);
        this.ventanaPrincipal.setLocationRelativeTo(ventanaLogin);
        this.ventanaPrincipal.setResizable(false);
        this.ventanaPrincipal.setVisible(true);
    }
    
    public void destroyInterfazUsuario(){
        ventanaUsuario.dispose();        
    }
    public DefaultTableModel setListadoUsuario(){
        DefaultTableModel modeloTabla=new DefaultTableModel();
        modeloTabla.addColumn("Rut");
        modeloTabla.addColumn("Nombre Completo");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Estado");       
        
        
        return modeloTabla;
    }
            


    public void setInterfazUsuario(JLayeredPane miEscritorio){
        this.ventanaUsuario = new MantenedorUsuarioGUI();
        this.ventanaUsuario.setCoordinador(this);
        this.ventanaUsuario.setTitle("Mantenedor Usuario");
        ventanaUsuario.listaUsuario(this.setListadoUsuario());
        this.ventanaUsuario.setPreguntaSecreta(controlLogin.getPreguntaSecreta());
        ventanaUsuario.setEstadoUsuario(controlLogin.getEstados());
        ventanaUsuario.setTipoUsuario(controlLogin.getTipos());
        
        ventanaUsuario.limpiarTodo();

        miEscritorio.add(ventanaUsuario);
        this.ventanaUsuario.show();
    }
    
    public void cargarSession(){
        //controlLogin.
        
    }
    
//    public Persona verificarSession(){
//        Persona per=null;
//        return per;
//    }
    
    public void ingresoSistema(Usuario miUsuario) {
        if(controlLogin.recibeRut(miUsuario.getPerRut())){
            if (controlLogin.recibePassword(miUsuario.getUsuClave())) {
                if(controlLogin.iniciarSesion()){
                    ventanaLogin.dispose();
                    ventanaLogin = null;
                    Mensaje.informacionAdvertencia("Bienvenido al Sistema Biblioteca");
                    setInterfazPrincipal(ventanaPrincipal);
                }
            }
        }   
    }

    public void crearAlumno(Usuario miUsuario,Persona miPersona){
        if(controlLogin.recibeRut(miUsuario.getPerRut())){
            if(controlLogin.recibeNombreCompleto(miPersona.getPerNombre(), miPersona.getPerApellidoPaterno())){
                if(controlLogin.recibeCorreo(miPersona.getPerCorreo())){
                  if(controlLogin.recibePassword(miUsuario.getUsuClave())){
                        if(controlLogin.recibeRespuesta(miUsuario.getPreSecId(), miUsuario.getUsuRespuesta())){
                            controlLogin.registrarAlumno();
                                                      
                        }
                    }
                }
            }
        }   
    }


    

    public void verificarDatosSecretos(Usuario miUsuario){
        if(controlLogin.recibeRut(miUsuario.getPerRut())){
            if(controlLogin.recibeRespuesta(miUsuario.getPreSecId(), miUsuario.getUsuRespuesta())){
                if(controlLogin.validarDatosSecretos()){
                    this.ventanaRecuperar.setVisiblePanelCambio(true);
                } 
            }
        }
    }
        
    public void cambiarClave(Usuario miUsuario) {
        if(controlLogin.recibePassword(miUsuario.getUsuClave())){
            int confirmarCambio = Mensaje.confirmacionSimple( "¿Esta seguro de cambiar su contraseña?");
            if (confirmarCambio == 0) {
                if(controlLogin.actualizarClave()){
                    Mensaje.informacionAdvertencia("Datos del Usuario actualizado correctamente");
                    this.ventanaRecuperar.dispose();
                    this.ventanaRecuperar=null;
                }else{
                    Mensaje.informacionAdvertencia("Problema del Sistema, intente más tarde");
                }
            }            
        }
    }
       
    
    public void crearUsuario(Usuario miUsuario,Persona miPersona){
        if(controlLogin.recibeRut(miUsuario.getPerRut())){
            if(controlLogin.recibeNombreCompleto(miPersona.getPerNombre(), miPersona.getPerApellidoPaterno())){
                if(controlLogin.recibeCorreo(miPersona.getPerCorreo())){
                    if(controlLogin.recibeRespuesta(miUsuario.getPreSecId(), miUsuario.getUsuRespuesta())){
                        if(controlLogin.recibeTipoUsuario(miUsuario.getTipUsuId())){
                            if(controlLogin.recibeEstadoUsuario(miUsuario.getEstUsuId())){
                                controlLogin.registrarUsuario();
                            }
                            
                        }
                        

                    }
                }
            }
        }   
    }
}
