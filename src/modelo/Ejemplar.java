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
public class Ejemplar {
    private String ejeId;
    private String estEjeId;
    private String estUbicacion;

    public Ejemplar() {
    }

    public Ejemplar(String ejeId, String estEjeId, String estUbicacion) {
        this.ejeId = ejeId;
        this.estEjeId = estEjeId;
        this.estUbicacion = estUbicacion;
    }

    /**
     * @return the ejeId
     */
    public String getEjeId() {
        return ejeId;
    }

    /**
     * @param ejeId the ejeId to set
     */
    public void setEjeId(String ejeId) {
        this.ejeId = ejeId;
    }

    /**
     * @return the estEjeId
     */
    public String getEstEjeId() {
        return estEjeId;
    }

    /**
     * @param estEjeId the estEjeId to set
     */
    public void setEstEjeId(String estEjeId) {
        this.estEjeId = estEjeId;
    }

    /**
     * @return the estUbicacion
     */
    public String getEstUbicacion() {
        return estUbicacion;
    }

    /**
     * @param estUbicacion the estUbicacion to set
     */
    public void setEstUbicacion(String estUbicacion) {
        this.estUbicacion = estUbicacion;
    }
    
    
}
