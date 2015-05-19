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
public class EstadoUsuario {
    private String estUsuId;
    private String estUsuNombre;
    private String estUsuDescripcion;

    public EstadoUsuario() {
    }

    public EstadoUsuario(String estUsuId, String estUsuNombre, String estUsuDescripcion) {
        this.estUsuId = estUsuId;
        this.estUsuNombre = estUsuNombre;
        this.estUsuDescripcion = estUsuDescripcion;
    }

    /**
     * @return the estUsuId
     */
    public String getEstUsuId() {
        return estUsuId;
    }

    /**
     * @param estUsuId the estUsuId to set
     */
    public void setEstUsuId(String estUsuId) {
        this.estUsuId = estUsuId;
    }

    /**
     * @return the estUsuNombre
     */
    public String getEstUsuNombre() {
        return estUsuNombre;
    }

    /**
     * @param estUsuNombre the estUsuNombre to set
     */
    public void setEstUsuNombre(String estUsuNombre) {
        this.estUsuNombre = estUsuNombre;
    }

    /**
     * @return the estUsuDescripcion
     */
    public String getEstUsuDescripcion() {
        return estUsuDescripcion;
    }

    /**
     * @param estUsuDescripcion the estUsuDescripcion to set
     */
    public void setEstUsuDescripcion(String estUsuDescripcion) {
        this.estUsuDescripcion = estUsuDescripcion;
    }
    
    
    
}
