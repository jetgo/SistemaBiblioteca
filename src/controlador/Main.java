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
import dao.PersonaDAO;
import dao.PreguntaSecretaDAO;
import dao.TipoUsuarioDAO;
import dao.UsuarioDAO;
import modelo.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import modelo.Empresa;
import modelo.EstadoUsuario;
import modelo.HistorialUsuario;
import modelo.Persona;
import modelo.PreguntaSecreta;
import modelo.TipoUsuario;
import vista.Login;


/**
 *
 * @author David
 */
public class Main {

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
    
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Login ventana=new Login();
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

        EstadoUsuarioDAO estUsuNuevo=new EstadoUsuarioDAO();
        estUsuNuevo.create(new EstadoUsuario("101", "Activo", "Usuario esta activo en las funciones de Sistema"));
        estUsuNuevo.create(new EstadoUsuario("102", "Bloqueado", "Usuario esta bloqueado por alguna situacion morosa"));
        estUsuNuevo.create(new EstadoUsuario("103", "Eliminado", "Usuario esta eliminado del Sistema"));
        TipoUsuarioDAO tipUsuNuevo=new TipoUsuarioDAO();
        tipUsuNuevo.create(new TipoUsuario("100", "Root", "Super-Usuario es el Administrador Informatico del Sistema"));
        tipUsuNuevo.create(new TipoUsuario("101", "Coordinadora", "La Coordinadora es la Jefa del Area"));
        tipUsuNuevo.create(new TipoUsuario("102", "Bibliotecaria", "Bibliotecaria es la empleada que realiza la mano de obra"));
        tipUsuNuevo.create(new TipoUsuario("104", "Alumno", "El Alumno es el usuario Final del Sistema"));
        PreguntaSecretaDAO preSecNuevo= new PreguntaSecretaDAO();
        preSecNuevo.create(new PreguntaSecreta("11", "¿Cual es el nombre de su mascota?"));
        preSecNuevo.create(new PreguntaSecreta("12", "¿Cual es el nombre de tu mejor amigo?"));
        preSecNuevo.create(new PreguntaSecreta("13", "¿Cual es la ciudad donde naciste?"));
     
        EmpresaDAO empNuevo=new EmpresaDAO();
        empNuevo.create(new Empresa("1", "Biblioteca Santo Tomas", "Heroes de la Concepcion"));
        

        PersonaDAO nuevoPer=new PersonaDAO();
        nuevoPer.create(new Persona("159794466", "david", "villegas", "aguilar", null, null, null, null, "david.villegas.aguilar@gmail.com"));
        UsuarioDAO nuevoUsu=new UsuarioDAO();
        nuevoUsu.create(new Usuario("1000", "100" , "101", "159794466", "11", "davidvillegas4466", "123456", "bobi", "6:34pm", "18-05-2015"));   
        HistorialUsuarioDAO nuevoHis= new HistorialUsuarioDAO();
        nuevoHis.create(new HistorialUsuario("2000", "1000", "Creacion del SuperUsuario", "6:34pm", "18-05-2015"));
        
        ventana.setLocationRelativeTo(null);
        ventana.setSize(520, 110);
        ventana.setVisible(true);
        ventana.setVisiblePanelAlumno(false);
        
    }
     public void tablasllenas(){

    }
}
