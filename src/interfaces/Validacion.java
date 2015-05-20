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
    public boolean recibeRut(Object rut);
    public boolean recibePassword(Object password);
    public void iniciarSesion();
    public void recuperarPassword();

}
