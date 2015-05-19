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
public class Persona {
    private String perRut;
    private String perNombre;
    private String perApellidoPaterno;
    private String perApellidoMaterno;
    private String perFechaNacimiento;
    private String perSexo;
    private String perDireccion;
    private String perTelefono;
    private String perCorreo;

    public Persona() {
    }

    public Persona(String perRut, String perNombre, String perApellidoPaterno, String perApellidoMaterno, String perFechaNacimiento, String perSexo, String perDireccion, String perTelefono, String perCorreo) {
        this.perRut = perRut;
        this.perNombre = perNombre;
        this.perApellidoPaterno = perApellidoPaterno;
        this.perApellidoMaterno = perApellidoMaterno;
        this.perFechaNacimiento = perFechaNacimiento;
        this.perSexo = perSexo;
        this.perDireccion = perDireccion;
        this.perTelefono = perTelefono;
        this.perCorreo = perCorreo;
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
     * @return the perNombre
     */
    public String getPerNombre() {
        return perNombre;
    }

    /**
     * @param perNombre the perNombre to set
     */
    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    /**
     * @return the perApellidoPaterno
     */
    public String getPerApellidoPaterno() {
        return perApellidoPaterno;
    }

    /**
     * @param perApellidoPaterno the perApellidoPaterno to set
     */
    public void setPerApellidoPaterno(String perApellidoPaterno) {
        this.perApellidoPaterno = perApellidoPaterno;
    }

    /**
     * @return the perApellidoMaterno
     */
    public String getPerApellidoMaterno() {
        return perApellidoMaterno;
    }

    /**
     * @param perApellidoMaterno the perApellidoMaterno to set
     */
    public void setPerApellidoMaterno(String perApellidoMaterno) {
        this.perApellidoMaterno = perApellidoMaterno;
    }

    /**
     * @return the perFechaNacimiento
     */
    public String getPerFechaNacimiento() {
        return perFechaNacimiento;
    }

    /**
     * @param perFechaNacimiento the perFechaNacimiento to set
     */
    public void setPerFechaNacimiento(String perFechaNacimiento) {
        this.perFechaNacimiento = perFechaNacimiento;
    }

    /**
     * @return the perSexo
     */
    public String getPerSexo() {
        return perSexo;
    }

    /**
     * @param perSexo the perSexo to set
     */
    public void setPerSexo(String perSexo) {
        this.perSexo = perSexo;
    }

    /**
     * @return the perDireccion
     */
    public String getPerDireccion() {
        return perDireccion;
    }

    /**
     * @param perDireccion the perDireccion to set
     */
    public void setPerDireccion(String perDireccion) {
        this.perDireccion = perDireccion;
    }

    /**
     * @return the perTelefono
     */
    public String getPerTelefono() {
        return perTelefono;
    }

    /**
     * @param perTelefono the perTelefono to set
     */
    public void setPerTelefono(String perTelefono) {
        this.perTelefono = perTelefono;
    }

    /**
     * @return the perCorreo
     */
    public String getPerCorreo() {
        return perCorreo;
    }

    /**
     * @param perCorreo the perCorreo to set
     */
    public void setPerCorreo(String perCorreo) {
        this.perCorreo = perCorreo;
    }
    
    
    
}
