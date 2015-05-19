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
public class TipoUsuario {
    private String tipUsuId;
    private String tipUsuNombre;
    private String tipUsuDescripcion;

    public TipoUsuario() {
    }

    public TipoUsuario(String tipUsuId, String tipUsuNombre, String tipUsuDescripcion) {
        this.tipUsuId = tipUsuId;
        this.tipUsuNombre = tipUsuNombre;
        this.tipUsuDescripcion = tipUsuDescripcion;
    }

    /**
     * @return the tipUsuId
     */
    public String getTipUsuId() {
        return tipUsuId;
    }

    /**
     * @param tipUsuId the tipUsuId to set
     */
    public void setTipUsuId(String tipUsuId) {
        this.tipUsuId = tipUsuId;
    }

    /**
     * @return the tipUsuNombre
     */
    public String getTipUsuNombre() {
        return tipUsuNombre;
    }

    /**
     * @param tipUsuNombre the tipUsuNombre to set
     */
    public void setTipUsuNombre(String tipUsuNombre) {
        this.tipUsuNombre = tipUsuNombre;
    }

    /**
     * @return the tipUsuDescripcion
     */
    public String getTipUsuDescripcion() {
        return tipUsuDescripcion;
    }

    /**
     * @param tipUsuDescripcion the tipUsuDescripcion to set
     */
    public void setTipUsuDescripcion(String tipUsuDescripcion) {
        this.tipUsuDescripcion = tipUsuDescripcion;
    }
    
    
}
