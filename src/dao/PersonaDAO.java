/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import interfaces.Obligacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Persona;

/**
 *
 * @author David
 */
public class PersonaDAO implements Obligacion<Persona>{
    private static final String SQL_INSERT=
            "INSERT INTO persona "
            + "(perRut, perNombre, perApellidoPaterno, perApellidoMaterno, perFechaNacimiento, perSexo, perDireccion, perTelefono, perCorreo) "
            + "VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE=
            "UPDATE persona "
            + "SET perNombre=?, perApellidoPaterno=?, perApellidoMaterno=?, perFechaNacimiento=?, perSexo=?, perDireccion=?, perTelefono=?, perCorreo=? "
            + "WHERE perRut=?";
    private static final String SQL_DELETE=
            "DELETE FROM persona "
            + "WHERE perRut=?";
    
    private static final String SQL_READ=
            "SELECT * FROM persona "
            + "WHERE perRut=?";
    private static final String SQL_READALL=
            "SELECT * FROM persona";
    
    private static final Conexion cnn=Conexion.estado();

    @Override
    public boolean create(Persona c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_INSERT);
            pst.setString(1, c.getPerRut());
            pst.setString(2, c.getPerNombre());
            pst.setString(3, c.getPerApellidoPaterno());
            pst.setString(4, c.getPerApellidoMaterno());
            pst.setString(5, c.getPerFechaNacimiento());
            pst.setString(6, c.getPerSexo());
            pst.setString(7, c.getPerDireccion());
            pst.setString(8, c.getPerTelefono());
            pst.setString(9, c.getPerCorreo());
            if(pst.executeUpdate()>0)
            {
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Persona c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_UPDATE);
            pst.setString(1, c.getPerNombre());
            pst.setString(2, c.getPerApellidoPaterno());
            pst.setString(3, c.getPerApellidoMaterno());
            pst.setString(4, c.getPerFechaNacimiento());
            pst.setString(5, c.getPerSexo());
            pst.setString(6, c.getPerDireccion());
            pst.setString(7, c.getPerTelefono());
            pst.setString(8, c.getPerCorreo());
            pst.setString(9, c.getPerRut());
            if(pst.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object llave) {
        
        PreparedStatement pst;
        try {     
            pst = cnn.getCnn().prepareStatement(SQL_DELETE);
            pst.setString(1, llave.toString());
            
            if(pst.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false; 
    }

    @Override
    public Persona read(Object llave) {
        
        PreparedStatement pst;
        ResultSet res;
        Persona per = null;
            
        try {    
            pst = cnn.getCnn().prepareStatement(SQL_READ);
            pst.setString(1, llave.toString());
            res = pst.executeQuery();
            while(res.next()){
                per=new Persona(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7),res.getString(8), res.getString(9));
            }
            return per;
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return per;
    }

    @Override
    public ArrayList<Persona> readAll() {
    
        PreparedStatement pst;
        ResultSet res;
        ArrayList<Persona> personas = new ArrayList();
            
        try {          
            pst = cnn.getCnn().prepareStatement(SQL_READALL);
            res = pst.executeQuery();
            while(res.next()){
                personas.add(new Persona(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7),res.getString(8), res.getString(9)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return personas; 
    }
}
