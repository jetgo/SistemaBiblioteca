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
public class HistorialUsuario {
    private String hisUsuId;
    private String usuId;
    private String hisUsuDescripcion;
    private String hisUsuHoraRegistro;
    private String hisUsuFechaRegistro;

    public HistorialUsuario() {
    }

    public HistorialUsuario(String hisUsuId, String usuId, String hisUsuDescripcion, String hisUsuHoraRegistro, String hisUsuFechaRegistro) {
        this.hisUsuId = hisUsuId;
        this.usuId = usuId;
        this.hisUsuDescripcion = hisUsuDescripcion;
        this.hisUsuHoraRegistro = hisUsuHoraRegistro;
        this.hisUsuFechaRegistro = hisUsuFechaRegistro;
    }

    /**
     * @return the hisUsuId
     */
    public String getHisUsuId() {
        return hisUsuId;
    }

    /**
     * @param hisUsuId the hisUsuId to set
     */
    public void setHisUsuId(String hisUsuId) {
        this.hisUsuId = hisUsuId;
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
     * @return the hisUsuDescripcion
     */
    public String getHisUsuDescripcion() {
        return hisUsuDescripcion;
    }

    /**
     * @param hisUsuDescripcion the hisUsuDescripcion to set
     */
    public void setHisUsuDescripcion(String hisUsuDescripcion) {
        this.hisUsuDescripcion = hisUsuDescripcion;
    }

    /**
     * @return the hisUsuHoraRegistro
     */
    public String getHisUsuHoraRegistro() {
        return hisUsuHoraRegistro;
    }

    /**
     * @param hisUsuHoraRegistro the hisUsuHoraRegistro to set
     */
    public void setHisUsuHoraRegistro(String hisUsuHoraRegistro) {
        this.hisUsuHoraRegistro = hisUsuHoraRegistro;
    }

    /**
     * @return the hisUsuFechaRegistro
     */
    public String getHisUsuFechaRegistro() {
        return hisUsuFechaRegistro;
    }

    /**
     * @param hisUsuFechaRegistro the hisUsuFechaRegistro to set
     */
    public void setHisUsuFechaRegistro(String hisUsuFechaRegistro) {
        this.hisUsuFechaRegistro = hisUsuFechaRegistro;
    }
    
    
}
