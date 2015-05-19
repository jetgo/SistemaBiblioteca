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
public class Usuario {
    private String usuId;
    private String tipUsuId;
    private String estUsuId;
    private String perRut;
    private String preSecId;
    private String usuAlias;
    private String usuClave;
    private String usuRespuesta;
    private String usuFechaRegistro;
    private String usuHoraRegistro;

    public Usuario() {
    }

    public Usuario(String usuId, String tipUsuId, String estUsuId, String perRut, String preSecId, String usuAlias, String usuClave, String usuRespuesta, String usuFechaRegistro, String usuHoraRegistro) {
        this.usuId = usuId;
        this.tipUsuId = tipUsuId;
        this.estUsuId = estUsuId;
        this.perRut = perRut;
        this.preSecId = preSecId;
        this.usuAlias = usuAlias;
        this.usuClave = usuClave;
        this.usuRespuesta = usuRespuesta;
        this.usuFechaRegistro = usuFechaRegistro;
        this.usuHoraRegistro = usuHoraRegistro;
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
     * @return the perRut
     */
    public String getPerRut() {
        return perRut;
    }

    /**
     * @param perRut the perRut to set
     */
    public void setPerRut(String perRut) {
        this.perRut = perRut;
    }

    /**
     * @return the usuAlias
     */
    public String getUsuAlias() {
        return usuAlias;
    }

    /**
     * @param usuAlias the usuAlias to set
     */
    public void setUsuAlias(String usuAlias) {
        this.usuAlias = usuAlias;
    }

    /**
     * @return the usuClave
     */
    public String getUsuClave() {
        return usuClave;
    }

    /**
     * @param usuClave the usuClave to set
     */
    public void setUsuClave(String usuClave) {
        this.usuClave = usuClave;
    }

    /**
     * @return the usuRespuesta
     */
    public String getUsuRespuesta() {
        return usuRespuesta;
    }

    /**
     * @param usuRespuesta the usuRespuesta to set
     */
    public void setUsuRespuesta(String usuRespuesta) {
        this.usuRespuesta = usuRespuesta;
    }

    /**
     * @return the usuFechaRegistro
     */
    public String getUsuFechaRegistro() {
        return usuFechaRegistro;
    }

    /**
     * @param usuFechaRegistro the usuFechaRegistro to set
     */
    public void setUsuFechaRegistro(String usuFechaRegistro) {
        this.usuFechaRegistro = usuFechaRegistro;
    }

    /**
     * @return the usuHoraRegistro
     */
    public String getUsuHoraRegistro() {
        return usuHoraRegistro;
    }

    /**
     * @param usuHoraRegistro the usuHoraRegistro to set
     */
    public void setUsuHoraRegistro(String usuHoraRegistro) {
        this.usuHoraRegistro = usuHoraRegistro;
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
  
}
