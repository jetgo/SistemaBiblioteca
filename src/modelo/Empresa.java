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
public class Empresa {
    private String empRol;
    private String empNombre;
    private String empDireccion;

    public Empresa() {
    }

    public Empresa(String empRol, String empNombre, String empDireccion) {
        this.empRol = empRol;
        this.empNombre = empNombre;
        this.empDireccion = empDireccion;
    }

    /**
     * @return the empRol
     */
    public String getEmpRol() {
        return empRol;
    }

    /**
     * @param empRol the empRol to set
     */
    public void setEmpRol(String empRol) {
        this.empRol = empRol;
    }

    /**
     * @return the empNombre
     */
    public String getEmpNombre() {
        return empNombre;
    }

    /**
     * @param empNombre the empNombre to set
     */
    public void setEmpNombre(String empNombre) {
        this.empNombre = empNombre;
    }

    /**
     * @return the empDireccion
     */
    public String getEmpDireccion() {
        return empDireccion;
    }

    /**
     * @param empDireccion the empDireccion to set
     */
    public void setEmpDireccion(String empDireccion) {
        this.empDireccion = empDireccion;
    }
    
    
}
