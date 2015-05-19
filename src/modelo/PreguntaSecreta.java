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
public class PreguntaSecreta {
    private String preSecId;
    private String preSecDescripcion;

    public PreguntaSecreta() {
    }

    public PreguntaSecreta(String preSecId, String preSecDescripcion) {
        this.preSecId = preSecId;
        this.preSecDescripcion = preSecDescripcion;
    }

    /**
     * @return the preSecId
     */
    public String getPreSecId() {
        return preSecId;
    }

    /**
     * @param preSecId the preSecId to set
     */
    public void setPreSecId(String preSecId) {
        this.preSecId = preSecId;
    }

    /**
     * @return the preSecDescripcion
     */
    public String getPreSecDescripcion() {
        return preSecDescripcion;
    }

    /**
     * @param preSecDescripcion the preSecDescripcion to set
     */
    public void setPreSecDescripcion(String preSecDescripcion) {
        this.preSecDescripcion = preSecDescripcion;
    }
    
    
}
