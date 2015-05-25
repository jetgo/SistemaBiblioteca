/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author David
 */
public class Interfaz {
    private String intId;
    private String intNombre;
    private String intDescripcion;

    public Interfaz() {
    }

    public Interfaz(String intId, String intNombre, String intDescripcion) {
        this.intId = intId;
        this.intNombre = intNombre;
        this.intDescripcion = intDescripcion;
    }

    /**
     * @return the intId
     */
    public String getIntId() {
        return intId;
    }

    /**
     * @param intId the intId to set
     */
    public void setIntId(String intId) {
        this.intId = intId;
    }

    /**
     * @return the intNombre
     */
    public String getIntNombre() {
        return intNombre;
    }

    /**
     * @param intNombre the intNombre to set
     */
    public void setIntNombre(String intNombre) {
        this.intNombre = intNombre;
    }

    /**
     * @return the intDescripcion
     */
    public String getIntDescripcion() {
        return intDescripcion;
    }

    /**
     * @param intDescripcion the intDescripcion to set
     */
    public void setIntDescripcion(String intDescripcion) {
        this.intDescripcion = intDescripcion;
    }
    
    
}
