/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import interfaces.ModeloDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.PreguntaSecreta;

/**
 *
 * @author David
 */
public class PreguntaSecretaDAO implements ModeloDAO<PreguntaSecreta>{
    
    private static final String SQL_INSERT=
            "INSERT INTO preguntaSecreta "
            + "(preSecId, preSecDescripcion) "
            + "VALUES (?,?)";
    private static final String SQL_UPDATE=
            "UPDATE preguntaSecreta "
            + "SET preSecDescripcion=?  "
            + "WHERE preSecId=?";
    private static final String SQL_DELETE=
            "DELETE FROM preguntaSecreta "
            + "WHERE preSecId=?";
    
    private static final String SQL_READ=
            "SELECT * FROM preguntaSecreta "
            + "WHERE preSecId=?";
    private static final String SQL_READALL=
            "SELECT * FROM preguntaSecreta";
    
    private static final Conexion cnn=Conexion.estado();

    @Override
    public boolean create(PreguntaSecreta c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_INSERT);
            pst.setString(1, c.getPreSecId());
            pst.setString(2, c.getPreSecDescripcion());
            if(pst.executeUpdate()>0)
            {
                return true;
            }   
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaSecretaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(PreguntaSecreta c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_UPDATE);
            pst.setString(1, c.getPreSecDescripcion());
            pst.setString(2, c.getPreSecId());
            if(pst.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaSecretaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PreguntaSecretaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public PreguntaSecreta read(Object llave) {
        
        PreparedStatement pst;
        ResultSet res;
        PreguntaSecreta preSec = null;
        try {
            pst = cnn.getCnn().prepareStatement(SQL_READ);
            pst.setString(1, llave.toString());
            res = pst.executeQuery();
            while(res.next()){
                preSec=new PreguntaSecreta(res.getString(1), res.getString(2));
            }
            return preSec;    
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaSecretaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return preSec;
    }

    @Override
    public ArrayList<PreguntaSecreta> readAll() {
        
        PreparedStatement pst;
        ResultSet res;
        ArrayList<PreguntaSecreta> preSecretas=new ArrayList();
        try {
            pst=cnn.getCnn().prepareStatement(SQL_READALL);
            res=pst.executeQuery();
            while(res.next()){
                preSecretas.add(new PreguntaSecreta(res.getString(1), res.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PreguntaSecretaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return preSecretas;
    }
    
    
}
