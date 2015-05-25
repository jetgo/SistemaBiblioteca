/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import modelo.PreguntaSecreta;

/**
 *
 * @author David
 */
public interface RegistroAlumno {
    public boolean recibeRut(Object rut);
    public boolean recibeNombreCompleto(Object nombre, Object apellido);
    public boolean recibeCorreo(Object correo);
    public boolean recibePassword (Object password);
    public boolean recibeRespuesta (Object pregunta, Object respuesta);
    public boolean registrarAlumno();
}
