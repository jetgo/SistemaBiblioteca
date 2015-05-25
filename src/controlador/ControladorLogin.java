/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.EstadoInterfazDAO;
import dao.EstadoUsuarioDAO;
import funcion.ManejoSesion;
import dao.HistorialUsuarioDAO;
import dao.InterfazDAO;
import dao.PersonaDAO;
import dao.PreguntaSecretaDAO;
import dao.TipoUsuarioDAO;
import dao.UsuarioDAO;
import funcion.DatosSistema;
import funcion.DatosGenerales;
import funcion.DatosPersonales;
import interfaces.Validacion;
import modelo.Usuario;
import vista.LoginGUI;
import funcion.Mensaje;
import interfaces.ModeloDAO;
import interfaces.RegistroAlumno;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.EstadoInterfaz;
import modelo.EstadoUsuario;
import modelo.HistorialUsuario;
import modelo.Interfaz;
import modelo.Persona;
import modelo.PreguntaSecreta;
import modelo.TipoUsuario;
import vista.InterfazRecuperaPassword;

/**
 *
 * @author David
 */
public class ControladorLogin implements Validacion,RegistroAlumno{

    private Usuario usuActual;
    private UsuarioDAO usuDAO;
    private Persona perActual;
    private PersonaDAO perDAO;
    private HistorialUsuarioDAO hisUsuDao;

    private Coordinador controlTotal;

    public ControladorLogin() {
        this.usuActual = new Usuario();
        this.usuDAO = new UsuarioDAO();
        this.perActual = new Persona();
        this.perDAO = new PersonaDAO();
        this.hisUsuDao= new HistorialUsuarioDAO();
    }
    
    public void setCoordinador(Coordinador controlTotal) {
            this.controlTotal = controlTotal;
    }
    
    public ArrayList<PreguntaSecreta> getPreguntaSecreta (){
        PreguntaSecretaDAO pre = null;
        ArrayList<PreguntaSecreta> preguntas = null;
        pre = new PreguntaSecretaDAO();
        preguntas = pre.readAll();
        pre = null;
        return preguntas;
    }
    
    public ArrayList<EstadoUsuario> getEstados(){
        EstadoUsuarioDAO est = null;
        ArrayList<EstadoUsuario> estados = null;
        est = new EstadoUsuarioDAO();
        estados = est.readAll();
        est = null;
        return estados;
    }
    
    public ArrayList<TipoUsuario> getTipos(){
        TipoUsuarioDAO tip = null;
        ArrayList<TipoUsuario> tipos = null;
        tip = new TipoUsuarioDAO();
        tipos = tip.readAll();
        tip = null;
        return tipos;
    }
    
    public String getSession(){
        String miDato = "";
        String[] miSession = ManejoSesion.leerSesion();
        if(miSession != null){
            miDato=miSession[0];
        } else {
            Mensaje.informacionAdvertencia("SU SESSION HA TERMINADO");
        }
        return miDato;
    }
    
    public ArrayList<EstadoInterfaz> getInterfazUsuarios(Object UsuId){
        EstadoInterfazDAO estInt = new EstadoInterfazDAO();
        ArrayList<EstadoInterfaz> estInterfaces = estInt.findByUsuario(String.valueOf(UsuId));
        if(estInterfaces != null){
            Mensaje.informacionAdvertencia("Tiene Interfaces");
        } else {
            Mensaje.informacionAdvertencia("NO existen Interfaces cargadas");
        }
        return estInterfaces;
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
    public boolean iniciarSesion() {
        boolean iniciado = false;
        Usuario usuEncontrado = usuDAO.findByRut(usuActual.getPerRut());
        if(usuEncontrado != null){
            if(usuEncontrado.getUsuClave().equals(usuActual.getUsuClave())){
                System.out.println("DatosPersonales = "+usuEncontrado.getPerRut());
                System.out.println("Clave = "+usuEncontrado.getUsuClave());
                System.out.println("EL ID USUARIO= "+usuEncontrado.getUsuId());
                System.out.println("EL RUT DEL USUARIO ="+usuEncontrado.getPerRut());
                System.out.println("EL ID DE PREGUNTA SECRETA"+usuEncontrado.getPreSecId());
                System.out.println("EL TIPO DE USUARIO "+usuEncontrado.getTipUsuId());
                System.out.println("EL ID DEL USUARIO"+usuEncontrado.getUsuId());
                System.out.println("LA RESPUESTA ES="+usuEncontrado.getUsuRespuesta());
                ManejoSesion.crearSesion(usuEncontrado.getUsuId(), String.valueOf(new Date()));
                
                hisUsuDao.create(new HistorialUsuario(hisUsuDao.nextID(), usuEncontrado.getUsuId(), "Inicio de Sesion al Sistema IP: "+ DatosSistema.ipCliente(), DatosGenerales.horaActual(), DatosGenerales.fechaActual()));

                iniciado = true;
            } else {
            Mensaje.informacionAdvertencia("Error en el usuario o password"); 
            }
        } else {
            Mensaje.informacionAdvertencia("Error en el usuario o password"); 
        }
        return iniciado;
    }

    @Override
    public boolean recibeNombreCompleto(Object nombre, Object apellido) {
        boolean validarNom = false;
        String strNombre = String.valueOf(nombre);
        String strApellido = String.valueOf(apellido);
        if(strNombre.isEmpty() || strApellido.isEmpty()){
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
            strCorreo = strCorreo.toLowerCase();
            perActual.setPerCorreo(strCorreo);
            System.out.println("Correo Ingresado es = " + perActual.getPerCorreo());
            validarCorreo = true;
        } else {
            Mensaje.informacionAdvertencia("Ingrese un correo valido ej: usuario@dominio.com");
        }            
        return validarCorreo;
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
    public boolean registrarAlumno() {
        boolean registrado = false;
        String alias = "";
        Usuario usuEncontrado = new Usuario();

        
        usuEncontrado = usuDAO.findByRut(usuActual.getPerRut());
        if(usuEncontrado==null){
            perActual.setPerRut(usuActual.getPerRut());
            usuActual.setTipUsuId("1003");
            usuActual.setEstUsuId("1");
            alias = perActual.getPerNombre()+perActual.getPerApellidoPaterno()+usuActual.getPerRut();
            usuActual.setUsuAlias(alias);
            usuActual.setUsuId(usuDAO.nextID());
            usuActual.setUsuHoraRegistro(DatosGenerales.horaActual());
            usuActual.setUsuFechaRegistro(DatosGenerales.fechaActual());

            
            if(perDAO.create(perActual)){
                if(usuDAO.create(usuActual)){
                    if(hisUsuDao.create(new HistorialUsuario(hisUsuDao.nextID(), usuActual.getUsuId(), "Registro del Alumno desde la IP: " + DatosSistema.ipCliente(), DatosGenerales.horaActual(), DatosGenerales.fechaActual()))){
                        
                        Mensaje.informacionAdvertencia("Usuario " + String.valueOf(usuActual.getPerRut()) + " ha sido Registrado Exitosamente");
                        
                        this.setInterfazAlumno(usuActual.getUsuId());
                        
                        registrado = true;
                    } else {
                        Mensaje.informacionAdvertencia("Problema en el Sistema no puede registrar su Historial, Intente más Tarde");
                    }
                } else {
                Mensaje.informacionAdvertencia("Problema en el Sistema no puede registrar al Usuario, Intente más Tarde");
                }
            } else {
                Mensaje.informacionAdvertencia("Problema en el Sistema no puede registrar a la Persona, Intente más Tarde");
            }
        }else {
            
            Mensaje.informacionAdvertencia("Usuario = "+usuEncontrado.getPerRut()+" ya Ingresado Anteriormente, Favor Ingrese un Nuevo Usuario");
        }
        return registrado;
    }
    
    public boolean registrarUsuario() {
        boolean registrado = false;
        String alias = "";
        Usuario usuEncontrado = new Usuario();

        
        usuEncontrado = usuDAO.findByRut(usuActual.getPerRut());
        if(usuEncontrado==null){
            perActual.setPerRut(usuActual.getPerRut());
            alias = perActual.getPerNombre()+perActual.getPerApellidoPaterno()+usuActual.getPerRut();
            usuActual.setUsuAlias(alias);
            usuActual.setUsuId(usuDAO.nextID());
            usuActual.setUsuHoraRegistro(DatosGenerales.horaActual());
            usuActual.setUsuFechaRegistro(DatosGenerales.fechaActual());
            
            if(perDAO.create(perActual)){
                if(usuDAO.create(usuActual)){
                    if(hisUsuDao.create(new HistorialUsuario(hisUsuDao.nextID(), usuActual.getUsuId(), "Registro del Alumno desde la IP: " + DatosSistema.ipCliente(), DatosGenerales.horaActual(), DatosGenerales.fechaActual()))){
                        
                        Mensaje.informacionAdvertencia("Usuario " + String.valueOf(usuActual.getPerRut()) + " ha sido Registrado Exitosamente");
                        
                        this.setInterfazAlumno(usuActual.getUsuId());
                        
                        registrado = true;
                    } else {
                        Mensaje.informacionAdvertencia("Problema en el Sistema no puede registrar su Historial, Intente más Tarde");
                    }
                } else {
                Mensaje.informacionAdvertencia("Problema en el Sistema no puede registrar al Usuario, Intente más Tarde");
                }
            } else {
                Mensaje.informacionAdvertencia("Problema en el Sistema no puede registrar a la Persona, Intente más Tarde");
            }
        }else {
            
            Mensaje.informacionAdvertencia("Usuario = "+usuEncontrado.getPerRut()+" ya Ingresado Anteriormente, Favor Ingrese un Nuevo Usuario");
        }
        return registrado;
    }

    @Override
    public boolean validarDatosSecretos() {
        boolean validarDatos = false;
        Usuario usuEncontrado = new Usuario();
        usuEncontrado = usuDAO.findByRut(usuActual.getPerRut());
        if(usuEncontrado != null){
            if(usuEncontrado.getPreSecId().equals(usuActual.getPreSecId()) && usuEncontrado.getUsuRespuesta().equals(usuActual.getUsuRespuesta())){
                hisUsuDao.create(new HistorialUsuario(hisUsuDao.nextID(), usuEncontrado.getUsuId(), "Intento de Cambiar Clase desde IP: "+ DatosSistema.ipCliente(), DatosGenerales.horaActual(), DatosGenerales.fechaActual()));
                validarDatos = true;
            } else {
                Mensaje.informacionAdvertencia("Su Pregunta y/o Respuesta Secreta No son Correctas"); 
            }
        } else {
            Mensaje.informacionAdvertencia("Su Rut No esta Registrado en el Sistema"); 
        }
        usuEncontrado = null;
        return validarDatos;
    }
    
    public boolean actualizarClave(){
        boolean cambioPass = false;
        Usuario usuEncontrado = new Usuario();
        usuEncontrado = usuDAO.findByRut(usuActual.getPerRut());    
        if(usuEncontrado != null){
            usuActual.setUsuId(usuEncontrado.getUsuId());
            usuActual.setTipUsuId(usuEncontrado.getTipUsuId());
            usuActual.setEstUsuId(usuEncontrado.getEstUsuId());
            usuActual.setPreSecId(usuEncontrado.getPreSecId());
            usuActual.setUsuAlias(usuEncontrado.getUsuAlias());
            //usuActual.setpassword
            usuActual.setUsuRespuesta(usuEncontrado.getUsuRespuesta());
            cambioPass= usuDAO.update(usuActual);
        } else {
            Mensaje.informacionAdvertencia("UPPP, paso algo grave, Su Rut No esta Registrado en el Sistema"); 
        }
        usuEncontrado = null;
        return cambioPass;
    }
    
    public void setInterfazAlumno(Object miUsuId){
        EstadoInterfazDAO estIntDao=new EstadoInterfazDAO();
        estIntDao.create(new EstadoInterfaz(estIntDao.nextID(), "3", String.valueOf(miUsuId)));
        estIntDao.create(new EstadoInterfaz(estIntDao.nextID(), "2", String.valueOf(miUsuId)));
        estIntDao=null;
    }
    
    public boolean recibeTipoUsuario(Object tipoUsuario){
        boolean tipo=false;
        switch(String.valueOf(tipoUsuario)){
            case "1": 
                usuActual.setTipUsuId("1000");
                tipo=true;        
                break;
            case "2": 
                usuActual.setTipUsuId("1001");
                tipo=true;   
                break;
            case "3": 
                usuActual.setTipUsuId("1002");
                tipo=true;   
                break;
            case "4": 
                usuActual.setTipUsuId("1003");
                tipo=true;   
                break;
            default:
                Mensaje.informacionAdvertencia("Seleccione un Cargo");
        }
        return tipo;
    }
    
    public boolean recibeEstadoUsuario(Object estadoUsuario){
        boolean estado=false;
        switch(String.valueOf(estadoUsuario)){
            case "1": 
                usuActual.setEstUsuId("1");
                estado=true;        
                break;
            case "2": 
                usuActual.setEstUsuId("2");
                estado=true;   
                break;
            case "3": 
                usuActual.setEstUsuId("3");
                estado=true;   
                break;
            default:
                Mensaje.informacionAdvertencia("Seleccione un Estado");
        }
        return estado;
    }
    
}
