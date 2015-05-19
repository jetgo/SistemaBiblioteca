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
public class Prestamo {
    private String preId;
    private String ejeId;
    private String usuId;
    private String preFechaPrestamo;
    private String preHoraPrestamo;
    private String preFechaDevolucion;
    private String preDescripcion;

    public Prestamo() {
    }

    public Prestamo(String preId, String ejeId, String usuId, String preFechaPrestamo, String preHoraPrestamo, String preFechaDevolucion, String preDescripcion) {
        this.preId = preId;
        this.ejeId = ejeId;
        this.usuId = usuId;
        this.preFechaPrestamo = preFechaPrestamo;
        this.preHoraPrestamo = preHoraPrestamo;
        this.preFechaDevolucion = preFechaDevolucion;
        this.preDescripcion = preDescripcion;
    }

    /**
     * @return the preId
     */
    public String getPreId() {
        return preId;
    }

    /**
     * @param preId the preId to set
     */
    public void setPreId(String preId) {
        this.preId = preId;
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
     * @return the preFechaPrestamo
     */
    public String getPreFechaPrestamo() {
        return preFechaPrestamo;
    }

    /**
     * @param preFechaPrestamo the preFechaPrestamo to set
     */
    public void setPreFechaPrestamo(String preFechaPrestamo) {
        this.preFechaPrestamo = preFechaPrestamo;
    }

    /**
     * @return the preHoraPrestamo
     */
    public String getPreHoraPrestamo() {
        return preHoraPrestamo;
    }

    /**
     * @param preHoraPrestamo the preHoraPrestamo to set
     */
    public void setPreHoraPrestamo(String preHoraPrestamo) {
        this.preHoraPrestamo = preHoraPrestamo;
    }

    /**
     * @return the preFechaDevolucion
     */
    public String getPreFechaDevolucion() {
        return preFechaDevolucion;
    }

    /**
     * @param preFechaDevolucion the preFechaDevolucion to set
     */
    public void setPreFechaDevolucion(String preFechaDevolucion) {
        this.preFechaDevolucion = preFechaDevolucion;
    }

    /**
     * @return the preDescripcion
     */
    public String getPreDescripcion() {
        return preDescripcion;
    }

    /**
     * @param preDescripcion the preDescripcion to set
     */
    public void setPreDescripcion(String preDescripcion) {
        this.preDescripcion = preDescripcion;
    }
    
    
}
