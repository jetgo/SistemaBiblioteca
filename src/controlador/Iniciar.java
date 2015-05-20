/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.HistorialUsuarioDAO;
import dao.PersonaDAO;
import dao.UsuarioDAO;
import funcion.DatosSistema;
import funcion.DatosGenerales;
import funcion.DatosPersonales;
import interfaces.Validacion;
import modelo.Usuario;
import vista.Login;
import funcion.Mensaje;
import interfaces.ModeloDAO;
import interfaces.RegistroAlumno;
import java.util.Date;
import modelo.HistorialUsuario;
import modelo.Persona;
import vista.RecuperaPassword;

/**
 *
 * @author David
 */
public class Iniciar implements Validacion,RegistroAlumno{

    private Login ventanaLogin;
    private Usuario usuActual;
    private UsuarioDAO usuDAO;
    private Persona perActual;
    private PersonaDAO perDAO;
    private HistorialUsuarioDAO hisUsuDao;
    private RecuperaPassword ventanaRecuperar;

    public Iniciar() {
        this.usuActual = new Usuario();
        this.usuDAO = new UsuarioDAO();
        this.perActual = new Persona();
        this.perDAO = new PersonaDAO();
        this.hisUsuDao= new HistorialUsuarioDAO();
        this.ventanaLogin = new Login(this);
        this.ventanaLogin.setTitle("SISTEMA BIBLIOTECA");
        
        this.ventanaLogin.setLocationRelativeTo(null);
        this.ventanaLogin.setSize(480, 140);
        this.ventanaLogin.setVisiblePanelAlumno(false);
        this.ventanaLogin.setVisible(true);
    }
    
    public void iniciarRecuperar(){
        ventanaRecuperar=new RecuperaPassword(ventanaLogin,true, this);
        ventanaRecuperar.setLocationRelativeTo(ventanaLogin);
        ventanaRecuperar.setVisible(true);
        ventanaRecuperar.limpia();
                        ventanaRecuperar.setVisiblePanelCambio(false);
                        ventanaRecuperar.setVisiblePanelRecuperar(true);
    }
    
    @Override
    public boolean recibeRut(Object rut) {
        boolean validoRut=false;
        
        String strRut=String.valueOf(rut);
        if(strRut.isEmpty()){
            Mensaje.informacionAdvertencia("Ingrese un Rut");
        }else{
            if(DatosPersonales.validarRut(strRut)){
                strRut = strRut.replace(".", "");
                strRut = strRut.replace("-", "");
                strRut=strRut.toUpperCase();
                usuActual.setPerRut(strRut);
                System.out.println("El usuario ingresado es: "+usuActual.getPerRut());
                validoRut=true;
            }else{
                Mensaje.informacionAdvertencia("Ingrese un Rut valido");
            }
        }
        return validoRut;    
    }

    @Override
    public boolean recibePassword(Object password) {
        boolean validoPass=false;
                
        String strPass=String.valueOf(password);
        if(strPass.isEmpty()){
            Mensaje.informacionAdvertencia("Ingrese su Contraseña");
        } else {
            if(strPass.length()>3){
                usuActual.setUsuClave(strPass);
                System.out.println("El Password ingresado es: "+usuActual.getUsuClave());
                validoPass=true;
            } else {
                Mensaje.informacionAdvertencia("Password no puede ser menor a 4 caracteres");
            }
        }
        return validoPass;      
    }

    @Override
    public void iniciarSesion() {

        Usuario usuEncontrado=usuDAO.findByRut(usuActual.getPerRut());
        if(usuEncontrado!=null){
            if(usuEncontrado.getUsuClave().equals(usuActual.getUsuClave())){
                System.out.println("DatosPersonales = "+usuEncontrado.getPerRut());
                System.out.println("Clave = "+usuEncontrado.getUsuClave());
//                System.out.println("Clave = "+usuActual.getUsuClave());
                System.out.println("EL ID USUARIO= "+usuEncontrado.getUsuId());
                System.out.println("EL RUT DEL USUARIO ="+usuEncontrado.getPerRut());
                System.out.println("EL ID DE PREGUNTA SECRETA"+usuEncontrado.getPreSecId());
                System.out.println("EL TIPO DE USUARIO "+usuEncontrado.getTipUsuId());
                System.out.println("EL ID DEL USUARIO"+usuEncontrado.getUsuId());
                System.out.println("LA RESPUESTA ES="+usuEncontrado.getUsuRespuesta());
                ManejoSesion.crearSesion(usuEncontrado.getPerRut(), new Date().toString());
                
                hisUsuDao.create(new HistorialUsuario(hisUsuDao.nextID(), usuEncontrado.getUsuId(), "Inicio de Sesion al Sistema IP: "+ DatosSistema.ipCliente(), DatosGenerales.horaActual(), DatosGenerales.fechaActual()));

                Mensaje.informacionAdvertencia("Ingreso CORRRECTTOO");
                ventanaLogin.dispose();
                Contenido controlContenido=new Contenido();
                
                return;
           }
        } 
        Mensaje.informacionAdvertencia("Error en el usuario o password"); 
    }

    @Override
    public boolean recibeNombreCompleto(Object nombre, Object apellido) {
        boolean validarNom = false;
        String strNombre = String.valueOf(nombre);
        String strApellido = String.valueOf(apellido);
        if(strNombre.isEmpty()||strApellido.isEmpty()){
            Mensaje.informacionAdvertencia("Ingrese su Nombre y Apellido");
        } else {
            perActual.setPerNombre(strNombre);
            perActual.setPerApellidoPaterno(strApellido);
            System.out.println(perActual.getPerNombre() + " " + perActual.getPerApellidoPaterno());
            validarNom = true;
        }
        return validarNom;
    }

    @Override
    public boolean recibeCorreo(Object correo) {
        boolean validarCorreo = false;
        String strCorreo = String.valueOf(correo);
        if(DatosPersonales.validoEmail(strCorreo)){
            strCorreo=strCorreo.toLowerCase();
            perActual.setPerCorreo(strCorreo);
            System.out.println("Correo Ingresado es = " + perActual.getPerCorreo());
            validarCorreo = true;
        } else {
            Mensaje.informacionAdvertencia("Ingrese un correo valido ej: usuario@dominio.com");
        }            
        return validarCorreo;
    }

    @Override
    public boolean recibePassword(Object password, Object repetirPassword) {
        boolean validarPass = false;
        String strPass = String.valueOf(password);
        String strRepetirPass = String.valueOf(repetirPassword);
        if(strPass.equals(strRepetirPass)){
            if(recibePassword(strPass)){
                usuActual.setUsuClave(strPass);
                System.out.println("Password Ingresada="+usuActual.getUsuClave());
                validarPass = true;
            }
        } else {
            Mensaje.informacionAdvertencia("Repita el mismo Password");
        }
        return validarPass;
    }

    @Override
    public boolean recibeRespuesta(Object pregunta, Object respuesta) {
        boolean validarPregResp = false;
        Integer strPreg = Integer.parseInt(String.valueOf(pregunta));
        String strResp = String.valueOf(respuesta);
        if(strPreg > 0){
            if(strResp.isEmpty()){
                Mensaje.informacionAdvertencia("Ingrese una Respuesta");
            } else {
                if(strResp.length() > 3){
                    usuActual.setPreSecId(String.valueOf(strPreg));
                    usuActual.setUsuRespuesta(strResp);
                    System.out.println("Respuesta Ingresada = "+usuActual.getUsuRespuesta());
                    validarPregResp = true;
                } else {
                    Mensaje.informacionAdvertencia("La respuesta debe ser mayor a 3 caracteres");
                }
            }
        } else {
            Mensaje.informacionAdvertencia("Seleccione una pregunta");
        }
        return validarPregResp;
    }

    @Override
    public void registrarAlumno() {
        String alias="";
        perActual.setPerRut(usuActual.getPerRut());

        usuActual.setTipUsuId("104");
        usuActual.setEstUsuId("101");
        alias = perActual.getPerNombre()+perActual.getPerApellidoPaterno()+usuActual.getPerRut();
        usuActual.setUsuAlias(alias);
        perDAO.create(perActual);
        
        usuActual.setUsuId(usuDAO.nextID());
        usuActual.setUsuHoraRegistro(DatosGenerales.horaActual());
        usuActual.setUsuFechaRegistro(DatosGenerales.fechaActual());
        usuDAO.create(usuActual);
        hisUsuDao.create(new HistorialUsuario(hisUsuDao.nextID(), usuActual.getUsuId(), "Registro del Alumno desde la IP: " + DatosSistema.ipCliente(), DatosGenerales.horaActual(), DatosGenerales.fechaActual()));
  
    }

    @Override
    public void recuperarPassword() {
        Usuario usuEncontrado=usuDAO.findByRut(usuActual.getPerRut());
        if(usuEncontrado!=null){
            if(usuEncontrado.getPreSecId().equals(usuActual.getPreSecId()) && usuEncontrado.getUsuRespuesta().equals(usuActual.getUsuRespuesta())){

                ventanaRecuperar.setVisiblePanelRecuperar(false);
                ventanaRecuperar.setVisiblePanelCambio(true);
                hisUsuDao.create(new HistorialUsuario(hisUsuDao.nextID(), usuEncontrado.getUsuId(), "Cambio de la Contraseña desde IP: "+ DatosSistema.ipCliente(), DatosGenerales.horaActual(), DatosGenerales.fechaActual()));

                Mensaje.informacionAdvertencia("Cambio de CLAVE EXITOSO");
                return;
           }
            System.out.println("ERROR EN PREGUNTA O RESPUESTA");
        } 
        Mensaje.informacionAdvertencia("Su Rut no esta registrado en el Sistema"); 
    }
    
}
