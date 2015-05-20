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
import modelo.Ejemplar;

/**
 *
 * @author David
 */
public class EjemplarDAO implements ModeloDAO<Ejemplar> {
    private static final String SQL_INSERT=
            "INSERT INTO ejemplar "
            + "(ejeId, estEje, ejeUbicacion) "
            + "VALUES (?,?,?)";
    private static final String SQL_UPDATE=
            "UPDATE ejemplar "
            + "SET estEje=?, ejeUbicacion=? "
            + "WHERE ejeId=?";
    private static final String SQL_DELETE=
            "DELETE FROM ejemplar "
            + "WHERE ejeId=?";
    
    private static final String SQL_READ=
            "SELECT * FROM ejemplar "
            + "WHERE ejeId=?";
    private static final String SQL_READALL=
            "SELECT * FROM ejemplar";
    
    private static final Conexion cnn=Conexion.estado();
    @Override
    public boolean create(Ejemplar c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_INSERT);
            pst.setString(1, c.getEjeId());
            pst.setString(2, c.getEstEjeId());
            pst.setString(3, c.getEstUbicacion());
            if(pst.executeUpdate()>0)
            {
                return true;
            }    
        } catch (SQLException ex) {
            Logger.getLogger(EjemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Ejemplar c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_UPDATE);
            pst.setString(1, c.getEstEjeId());
            pst.setString(2, c.getEstUbicacion());
            pst.setString(3, c.getEjeId());
            if(pst.executeUpdate()>0){
                return true;
            }   
        } catch (SQLException ex) {
            Logger.getLogger(EjemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EjemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public Ejemplar read(Object llave) {
        
        PreparedStatement pst;
        ResultSet res;
        Ejemplar eje = null;
        try {

            pst = cnn.getCnn().prepareStatement(SQL_READ);
            pst.setString(1, llave.toString());
            res = pst.executeQuery();
            while(res.next()){
                eje=new Ejemplar(res.getString(1), res.getString(2), res.getString(3));
            }
            return eje;    
        } catch (SQLException ex) {
            Logger.getLogger(EjemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return eje;
    }

    @Override
    public ArrayList<Ejemplar> readAll() {
        
        PreparedStatement pst;
        ResultSet res;
        ArrayList<Ejemplar> ejemplares=new ArrayList();
        try {

            pst=cnn.getCnn().prepareStatement(SQL_READALL);
            res=pst.executeQuery();
            while(res.next()){
                ejemplares.add(new Ejemplar(res.getString(1), res.getString(2), res.getString(3)));
            }        
        } catch (SQLException ex) {
            Logger.getLogger(EjemplarDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return ejemplares;
    }
    
}
