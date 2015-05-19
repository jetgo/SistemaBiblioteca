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
public class Recurso {
    private String redId;
    private String tipRecId;
    private String recIsbn;
    private String recTitulo;
    private String recFechaAdquisicion;
    private String recAutor;
    private String recEditorial;
    private String recEdicion;
    private String recNumPagina;

    public Recurso() {
    }

    public Recurso(String redId, String tipRecId, String recIsbn, String recTitulo, String recFechaAdquisicion, String recAutor, String recEditorial, String recEdicion, String recNumPagina) {
        this.redId = redId;
        this.tipRecId = tipRecId;
        this.recIsbn = recIsbn;
        this.recTitulo = recTitulo;
        this.recFechaAdquisicion = recFechaAdquisicion;
        this.recAutor = recAutor;
        this.recEditorial = recEditorial;
        this.recEdicion = recEdicion;
        this.recNumPagina = recNumPagina;
    }

    /**
     * @return the redId
     */
    public String getRedId() {
        return redId;
    }

    /**
     * @param redId the redId to set
     */
    public void setRedId(String redId) {
        this.redId = redId;
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
     * @return the recIsbn
     */
    public String getRecIsbn() {
        return recIsbn;
    }

    /**
     * @param recIsbn the recIsbn to set
     */
    public void setRecIsbn(String recIsbn) {
        this.recIsbn = recIsbn;
    }

    /**
     * @return the recTitulo
     */
    public String getRecTitulo() {
        return recTitulo;
    }

    /**
     * @param recTitulo the recTitulo to set
     */
    public void setRecTitulo(String recTitulo) {
        this.recTitulo = recTitulo;
    }

    /**
     * @return the recFechaAdquisicion
     */
    public String getRecFechaAdquisicion() {
        return recFechaAdquisicion;
    }

    /**
     * @param recFechaAdquisicion the recFechaAdquisicion to set
     */
    public void setRecFechaAdquisicion(String recFechaAdquisicion) {
        this.recFechaAdquisicion = recFechaAdquisicion;
    }

    /**
     * @return the recAutor
     */
    public String getRecAutor() {
        return recAutor;
    }

    /**
     * @param recAutor the recAutor to set
     */
    public void setRecAutor(String recAutor) {
        this.recAutor = recAutor;
    }

    /**
     * @return the recEditorial
     */
    public String getRecEditorial() {
        return recEditorial;
    }

    /**
     * @param recEditorial the recEditorial to set
     */
    public void setRecEditorial(String recEditorial) {
        this.recEditorial = recEditorial;
    }

    /**
     * @return the recEdicion
     */
    public String getRecEdicion() {
        return recEdicion;
    }

    /**
     * @param recEdicion the recEdicion to set
     */
    public void setRecEdicion(String recEdicion) {
        this.recEdicion = recEdicion;
    }

    /**
     * @return the recNumPagina
     */
    public String getRecNumPagina() {
        return recNumPagina;
    }

    /**
     * @param recNumPagina the recNumPagina to set
     */
    public void setRecNumPagina(String recNumPagina) {
        this.recNumPagina = recNumPagina;
    }
    
    
}
