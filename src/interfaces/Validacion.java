/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;
/**
 *
 * @author David
 */
public interface Validacion {
    public boolean recibeRut(Object miUsuario);
    public boolean recibePassword(Object miUsuario);
    public boolean iniciarSesion();
    public boolean validarDatosSecretos();

}
