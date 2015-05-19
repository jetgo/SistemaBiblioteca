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
public class EstadoEjemplar {
    private String estEjeId;
    private String estEjeNombre;
    private String estEjeDescripcion;

    public EstadoEjemplar() {
    }

    public EstadoEjemplar(String estEjeId, String estEjeNombre, String estEjeDescripcion) {
        this.estEjeId = estEjeId;
        this.estEjeNombre = estEjeNombre;
        this.estEjeDescripcion = estEjeDescripcion;
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
     * @return the estEjeNombre
     */
    public String getEstEjeNombre() {
        return estEjeNombre;
    }

    /**
     * @param estEjeNombre the estEjeNombre to set
     */
    public void setEstEjeNombre(String estEjeNombre) {
        this.estEjeNombre = estEjeNombre;
    }

    /**
     * @return the estEjeDescripcion
     */
    public String getEstEjeDescripcion() {
        return estEjeDescripcion;
    }

    /**
     * @param estEjeDescripcion the estEjeDescripcion to set
     */
    public void setEstEjeDescripcion(String estEjeDescripcion) {
        this.estEjeDescripcion = estEjeDescripcion;
    }
    
    
}
