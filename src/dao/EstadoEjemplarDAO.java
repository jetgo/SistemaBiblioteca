/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import modelo.EstadoEjemplar;
import interfaces.Obligacion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class EstadoEjemplarDAO implements Obligacion<EstadoEjemplar>{
    
    private static final String SQL_INSERT=
            "INSERT INTO estadoEjemplar "
            + "(estEjeId, estEjeNombre, estEjeDescripcion) "
            + "VALUES (?,?,?)";
    private static final String SQL_UPDATE=
            "UPDATE estadoEjemplar "
            + "SET estEjeNombre=?, estEjeDescripcion=? "
            + "WHERE estEjeId=?";
    private static final String SQL_DELETE=
            "DELETE FROM estadoEjemplar "
            + "WHERE estEjeId=?";
    
    private static final String SQL_READ=
            "SELECT * FROM estadoEjemplar "
            + "WHERE estEjeId=?";
    private static final String SQL_READALL=
            "SELECT * FROM estadoEjemplar";
    
    private static final Conexion cnn=Conexion.estado();
    
    @Override
    public boolean create(EstadoEjemplar c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_INSERT);
            pst.setString(1, c.getEstEjeId());
            pst.setString(2, c.getEstEjeNombre());
            pst.setString(3, c.getEstEjeDescripcion());
            if(pst.executeUpdate()>0)
            {
                return true;
            }    
        } catch (SQLException ex) {
            Logger.getLogger(EstadoEjemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(EstadoEjemplar c) {
    
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_UPDATE);
            pst.setString(1, c.getEstEjeNombre());
            pst.setString(2, c.getEstEjeDescripcion());
            pst.setString(3, c.getEstEjeId());
            if(pst.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadoEjemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EstadoEjemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public EstadoEjemplar read(Object llave) {
        
        PreparedStatement pst;
        ResultSet res;
        EstadoEjemplar estEje = null;
        try {
            pst = cnn.getCnn().prepareStatement(SQL_READ);
            pst.setString(1, llave.toString());
            res = pst.executeQuery();
            while(res.next()){
                estEje=new EstadoEjemplar(res.getString(1), res.getString(2), res.getString(3));
            }
            return estEje;
        } catch (SQLException ex) {
            Logger.getLogger(EstadoEjemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return estEje;
    }

    @Override
    public ArrayList<EstadoEjemplar> readAll() {
        
        PreparedStatement pst;
        ResultSet res;
        ArrayList<EstadoEjemplar> estEjemplares=new ArrayList();
        try {
            pst=cnn.getCnn().prepareStatement(SQL_READALL);
            res=pst.executeQuery();
            while(res.next()){
                estEjemplares.add(new EstadoEjemplar(res.getString(1), res.getString(2), res.getString(3)));
            }    
        } catch (SQLException ex) {
            Logger.getLogger(EstadoEjemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return estEjemplares;
    }
    
}
