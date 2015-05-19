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
import modelo.Prestamo;

/**
 *
 * @author David
 */
public class PrestamoDAO implements Obligacion<Prestamo> {
    private static final String SQL_INSERT=
            "INSERT INTO prestamo "
            + "(preId, ejeId, usuId, preFechaPrestamo, preHoraPrestamo, preFechaDevolucion, preDescripcion) "
            + "VALUES (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE=
            "UPDATE prestamo "
            + "SET ejeId=?, usuId=?, preFechaPrestamo=?, preHoraPrestamo=?, preFechaDevolucion=?, preDescripcion=? "
            + "WHERE preId=?";
    private static final String SQL_DELETE=
            "DELETE FROM prestamo "
            + "WHERE preId=?";
    
    private static final String SQL_READ=
            "SELECT * FROM prestamo "
            + "WHERE preId=?";
    private static final String SQL_READALL=
            "SELECT * FROM prestamo";
    
    private static final Conexion cnn=Conexion.estado();
    
    @Override
    public boolean create(Prestamo c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_INSERT);
            pst.setString(1, c.getPreId());
            pst.setString(2, c.getEjeId());
            pst.setString(3, c.getUsuId());
            pst.setString(4, c.getPreHoraPrestamo());
            pst.setString(5, c.getPreFechaPrestamo());
            pst.setString(6, c.getPreFechaDevolucion());
            pst.setString(7, c.getPreDescripcion());
            if(pst.executeUpdate()>0)
            {
                return true;
            }   
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Prestamo c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_UPDATE);
            pst.setString(1, c.getEjeId());
            pst.setString(2, c.getUsuId());
            pst.setString(3, c.getPreHoraPrestamo());
            pst.setString(4, c.getPreFechaPrestamo());
            pst.setString(5, c.getPreFechaDevolucion());
            pst.setString(6, c.getPreDescripcion());
            pst.setString(7, c.getPreId());
            if(pst.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public Prestamo read(Object llave) {
        
        PreparedStatement pst;
        ResultSet res;
        Prestamo pre = null;
        try {
            pst = cnn.getCnn().prepareStatement(SQL_READ);
            pst.setString(1, llave.toString());
            res = pst.executeQuery();
            while(res.next()){
                pre=new Prestamo(res.getString(1), res.getString(2), res.getString(3),res.getString(4), res.getString(5), res.getString(6),res.getString(7));
            }
            return pre;    
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return pre;
    }

    @Override
    public ArrayList<Prestamo> readAll() {
        
        PreparedStatement pst;
        ResultSet res;
        ArrayList<Prestamo> prestamos=new ArrayList();
        try {
            pst=cnn.getCnn().prepareStatement(SQL_READALL);
            res=pst.executeQuery();
            while(res.next()){
                prestamos.add(new Prestamo(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7)));
            }   
        } catch (SQLException ex) {
            Logger.getLogger(PrestamoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return prestamos;
    }
    
}
