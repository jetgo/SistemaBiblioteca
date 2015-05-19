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
public class TipoRecurso {
    private String tipRecId;
    private String tipRecNombre;
    private String tipRecDescripcion;

    public TipoRecurso() {
    }

    public TipoRecurso(String tipRecId, String tipRecNombre, String tipRecDescripcion) {
        this.tipRecId = tipRecId;
        this.tipRecNombre = tipRecNombre;
        this.tipRecDescripcion = tipRecDescripcion;
    }

    /**
     * @return the tipRecId
     */
    public String getTipRecId() {
        return tipRecId;
    }

    /**
     * @param tipRecId the tipRecId to set
     */
    public void setTipRecId(String tipRecId) {
        this.tipRecId = tipRecId;
    }

    /**
     * @return the tipRecNombre
     */
    public String getTipRecNombre() {
        return tipRecNombre;
    }

    /**
     * @param tipRecNombre the tipRecNombre to set
     */
    public void setTipRecNombre(String tipRecNombre) {
        this.tipRecNombre = tipRecNombre;
    }

    /**
     * @return the tipRecDescripcion
     */
    public String getTipRecDescripcion() {
        return tipRecDescripcion;
    }

    /**
     * @param tipRecDescripcion the tipRecDescripcion to set
     */
    public void setTipRecDescripcion(String tipRecDescripcion) {
        this.tipRecDescripcion = tipRecDescripcion;
    }
    
    
    
}
