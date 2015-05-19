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
import modelo.TipoUsuario;

/**
 *
 * @author David
 */
public class TipoUsuarioDAO implements Obligacion<TipoUsuario>{
    
    private static final String SQL_INSERT=
            "INSERT INTO tipoUsuario "
            + "(tipUsuId, tipUsuNombre, tipUsuDescripcion) "
            + "VALUES (?,?,?)";
    private static final String SQL_UPDATE=
            "UPDATE tipoUsuario "
            + "SET tipUsuNombre=?, tipUsuDescripcion=? "
            + "WHERE tipUsuId=?";
    private static final String SQL_DELETE=
            "DELETE FROM tipoUsuario "
            + "WHERE tipUsuId=?";
    
    private static final String SQL_READ=
            "SELECT * FROM tipoUsuario "
            + "WHERE tipUsuId=?";
    private static final String SQL_READALL=
            "SELECT * FROM tipoUsuario";
    
    private static final Conexion cnn=Conexion.estado();

    @Override
    public boolean create(TipoUsuario c) {
    
        PreparedStatement pst;
        
        try {
            pst=cnn.getCnn().prepareStatement(SQL_INSERT);
            pst.setString(1, c.getTipUsuId());
            pst.setString(2, c.getTipUsuNombre());
            pst.setString(3, c.getTipUsuDescripcion());
            if(pst.executeUpdate()>0)
            {
                return true;
            }   
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(TipoUsuario c) {
    
        PreparedStatement pst;
        
        try {
            pst=cnn.getCnn().prepareStatement(SQL_UPDATE);
            pst.setString(1, c.getTipUsuNombre());
            pst.setString(2, c.getTipUsuDescripcion());
            pst.setString(3, c.getTipUsuId());
            if(pst.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public TipoUsuario read(Object llave) {
    
        PreparedStatement pst;
        ResultSet res;
        TipoUsuario tipUsu = null;
            
        try {
            pst = cnn.getCnn().prepareStatement(SQL_READ);
            pst.setString(1, llave.toString());
            res = pst.executeQuery();
            while(res.next()){
                tipUsu=new TipoUsuario(res.getString(1), res.getString(2), res.getString(3));
            }
            return tipUsu;
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return tipUsu;
    }

    @Override
    public ArrayList<TipoUsuario> readAll() {
    
        PreparedStatement pst;
        ResultSet res;
        ArrayList<TipoUsuario> tipUsuarios=new ArrayList();
            
        try {
            pst=cnn.getCnn().prepareStatement(SQL_READALL);
            res=pst.executeQuery();
            while(res.next()){
                tipUsuarios.add(new TipoUsuario(res.getString(1), res.getString(2), res.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return tipUsuarios;
    }
    
    
}
