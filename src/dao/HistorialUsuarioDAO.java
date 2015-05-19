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
import modelo.HistorialUsuario;

/**
 *
 * @author David
 */
public class HistorialUsuarioDAO implements Obligacion<HistorialUsuario>{

    private static final String SQL_INSERT=
            "INSERT INTO historialUsuario "
            + "(hisUsuId, usuId, hisUsuDescripcion, hisUsuHoraRegistro, hisUsuFechaRegistro) "
            + "VALUES (?,?,?,?,?)";
    private static final String SQL_UPDATE=
            "UPDATE historialUsuario "
            + "SET usuId=?, hisUsuDescripcion=?, hisUsuHoraRegistro=?, hisUsuFechaRegistro=? "
            + "WHERE hisUsuId=?";
    private static final String SQL_DELETE=
            "DELETE FROM historialUsuario "
            + "WHERE hisUsuId=?";
    
    private static final String SQL_READ=
            "SELECT * FROM historialUsuario "
            + "WHERE hisUsuId=?";
    private static final String SQL_READALL=
            "SELECT * FROM historialUsuario";
    
    private static final Conexion cnn=Conexion.estado();
    
    
    @Override
    public boolean create(HistorialUsuario c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_INSERT);
            pst.setString(1, c.getHisUsuId());
            pst.setString(2, c.getUsuId());
            pst.setString(3, c.getHisUsuDescripcion());
            pst.setString(4, c.getHisUsuHoraRegistro());
            pst.setString(5, c.getHisUsuFechaRegistro());
            if(pst.executeUpdate()>0)
            {
                return true;
            }    
        } catch (SQLException ex) {
            Logger.getLogger(HistorialUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(HistorialUsuario c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_UPDATE);
            pst.setString(1, c.getUsuId());
            pst.setString(2, c.getHisUsuDescripcion());
            pst.setString(3, c.getHisUsuHoraRegistro());
            pst.setString(4, c.getHisUsuFechaRegistro());
            pst.setString(5, c.getHisUsuId());
            if(pst.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistorialUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object llave) {
        try {
            PreparedStatement pst;
            pst = cnn.getCnn().prepareStatement(SQL_DELETE);
            pst.setString(1, llave.toString());
            
            if(pst.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistorialUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public HistorialUsuario read(Object llave) {
        
        PreparedStatement pst;
        ResultSet res;
        HistorialUsuario hisUsu = null;
        try {
            pst = cnn.getCnn().prepareStatement(SQL_READ);
            pst.setString(1, llave.toString());
            res = pst.executeQuery();
            while(res.next()){
                hisUsu=new HistorialUsuario(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5));
            }
            return hisUsu;   
        } catch (SQLException ex) {
            Logger.getLogger(HistorialUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return hisUsu;
    }

    @Override
    public ArrayList<HistorialUsuario> readAll() {
        PreparedStatement pst;
        ResultSet res;
        ArrayList<HistorialUsuario> hisUsuarios=new ArrayList();
        try {

            pst=cnn.getCnn().prepareStatement(SQL_READALL);
            res=pst.executeQuery();
            while(res.next()){
                hisUsuarios.add(new HistorialUsuario(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5)));
            }    
        } catch (SQLException ex) {
            Logger.getLogger(HistorialUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return hisUsuarios;
    }
    
}
