/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import conexion.Conexion;
import dao.EmpresaDAO;
import dao.EstadoUsuarioDAO;
import dao.HistorialUsuarioDAO;
import dao.InterfazDAO;
import dao.PersonaDAO;
import dao.PreguntaSecretaDAO;
import dao.TipoUsuarioDAO;
import dao.UsuarioDAO;
import funcion.DatosGenerales;
import funcion.DatosSistema;
import funcion.ManejoSesion;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import modelo.Usuario;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import modelo.Empresa;
import modelo.EstadoUsuario;
import modelo.HistorialUsuario;
import modelo.Interfaz;
import modelo.Persona;
import modelo.PreguntaSecreta;
import modelo.TipoUsuario;
import vista.LoginGUI;


/**
 *
 * @author David
 */
public class Main {

    private Coordinador controlCoordinador;
    private LoginGUI ventanaLogin;
//    public Main() {
//        ventanaLogin = new Iniciar();
//    }
    
     //Creando ArrayList
    
//    public ArrayList<Usuario> lista(){
////        Conexion c=new Conexion();
////        c.conexion();
//        ArrayList<Usuario> listaUsuario =new ArrayList<>();
//        Usuario A=new Usuario("159794466", "david", "villegas", "david@gmailcom", "1234");
//        Usuario B=new Usuario("111111111", "juan", "perez", "david@gmailcom", "1234", "Ingenieria Informatica", "¿Cual es el nombre de mi perro?", "bobi");
//        listaUsuario.add(A);
//        listaUsuario.add(B);
//        return listaUsuario;
//    }

    private void iniciar(){
        controlCoordinador = new Coordinador();
        ventanaLogin = new LoginGUI();
        ventanaLogin.setCoordinador(controlCoordinador);
        
        controlCoordinador.setInterfazLogin(ventanaLogin);
    }
    
    public void inicioBD(){
        InterfazDAO intNuevo=new InterfazDAO();
        intNuevo.create(new Interfaz("1", "Actualizar Clave Temporal","Usuario debera clave al proximo inicio"));
        intNuevo.create(new Interfaz("2", "Mantenedor de Usuario","Mantenedor de los usuario del sistema"));
        intNuevo.create(new Interfaz("3", "Cerrar Session","Usuario podra Cerrar de forma segura la Session"));
        EstadoUsuarioDAO estUsuNuevo=new EstadoUsuarioDAO();
        estUsuNuevo.create(new EstadoUsuario("1", "Activo", "Usuario esta activo en las funciones de Sistema"));
        estUsuNuevo.create(new EstadoUsuario("2", "Bloqueado", "Usuario esta bloqueado por alguna situacion morosa"));
        estUsuNuevo.create(new EstadoUsuario("3", "Eliminado", "Usuario esta eliminado del Sistema"));
        TipoUsuarioDAO tipUsuNuevo=new TipoUsuarioDAO();
        tipUsuNuevo.create(new TipoUsuario("1000", "Root", "Super-Usuario es el Administrador Informatico del Sistema"));
        tipUsuNuevo.create(new TipoUsuario("1001", "Coordinadora", "La Coordinadora es la Jefa del Area"));
        tipUsuNuevo.create(new TipoUsuario("1002", "Bibliotecaria", "Bibliotecaria es la empleada que realiza la mano de obra"));
        tipUsuNuevo.create(new TipoUsuario("1003", "Alumno", "El Alumno es el usuario Final del Sistema"));
        PreguntaSecretaDAO preSecNuevo= new PreguntaSecretaDAO();
        preSecNuevo.create(new PreguntaSecreta("1", "¿Cual es el nombre de su mascota?"));
        preSecNuevo.create(new PreguntaSecreta("2", "¿Cual es el nombre de tu mejor amigo?"));
        preSecNuevo.create(new PreguntaSecreta("3", "¿Cual es la ciudad donde naciste?"));
        preSecNuevo.create(new PreguntaSecreta("4", "¿Cual es el nombre de tu madre?"));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Main controlMain = new Main();
        //controlMain.inicioBD();
        controlMain.iniciar();
        
//        String[] nuevo=ManejoSesion.recuperarSesion();
//        if(nuevo==null){
//            System.out.println("ARCHIVO NO HA SIDO CREADO");
//            
//        }
//            new Main();

            //Login ventana=new LoginGUI();
//        UsuarioDAO l=new UsuarioDAO();
//        l.create(new UsuarioDTO(7,"152","1234","david","villegas","david@gmail.com","bobi"));
//       l.update(new UsuarioDTO(1,"152","1234","moises","villegas","david@gmail.com","bobi"));
//        UsuarioDTO usuarioBuscado=l.read(1);
//       // l.delete(3);
//        System.out.println(usuarioBuscado.getNombre());
////        ArrayList <UsuarioDTO> usuarios= l.readAll();
////        for (int i = 0; i < usuarios.size(); i++) {
////            System.out.println(usuarios.get(i).getCodigo());
//        }


//     
//        EmpresaDAO empNuevo=new EmpresaDAO();
//        empNuevo.create(new Empresa("1", "Biblioteca Santo Tomas", "Heroes de la Concepcion"));
//
//
//        PersonaDAO nuevoPer=new PersonaDAO();
//        nuevoPer.create(new Persona("159794466", "david", "villegas", "aguilar", null, null, null, null, "david.villegas.aguilar@gmail.com"));
//        UsuarioDAO nuevoUsu=new UsuarioDAO();
//        nuevoUsu.create(new Usuario("1000", "100" , "101", "159794466", "11", "davidvillegas4466", "123456", "bobi", "6:34pm", "18-05-2015"));   
//        HistorialUsuarioDAO nuevoHis= new HistorialUsuarioDAO();
//        nuevoHis.create(new HistorialUsuario("2000", "1000", "Creacion del SuperUsuario", "6:34pm", "18-05-2015"));
//        
//        ventana.setLocationRelativeTo(null);
//        ventana.setSize(520, 110);
//        ventana.setVisible(true);
//        ventana.setVisiblePanelAlumno(false);

        
    }
     
}
