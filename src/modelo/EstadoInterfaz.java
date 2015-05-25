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
public class EstadoInterfaz {
    private String estIntId;
    private String intId;
    private String usuId;

    public EstadoInterfaz() {
    }

    public EstadoInterfaz(String estIntId, String intId, String usuId) {
        this.estIntId = estIntId;
        this.intId = intId;
        this.usuId = usuId;
    }

    /**
     * @return the estIntId
     */
    public String getEstIntId() {
        return estIntId;
    }

    /**
     * @param estIntId the estIntId to set
     */
    public void setEstIntId(String estIntId) {
        this.estIntId = estIntId;
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
     * @return the usuId
     */
    public String getUsuId() {
        return usuId;
    }

    /**
     * @param usuId the usuId to set
     */
    public void setUsuId(String usuId) {
        this.usuId = usuId;
    }
    
    
}
