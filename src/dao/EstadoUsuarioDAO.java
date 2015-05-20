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
import modelo.EstadoUsuario;

/**
 *
 * @author David
 */
public class EstadoUsuarioDAO implements ModeloDAO<EstadoUsuario>{

    private static final String SQL_INSERT=
            "INSERT INTO estadoUsuario "
            + "(estUsuId, estUsuNombre, estUsuDescripcion) "
            + "VALUES (?,?,?)";
    private static final String SQL_UPDATE=
            "UPDATE estadoUsuario "
            + "SET estUsuNombre=?, estUsuDescripcion=? "
            + "WHERE estUsuId=?";
    private static final String SQL_DELETE=
            "DELETE FROM estadoUsuario "
            + "WHERE estUsuId=?";
    
    private static final String SQL_READ=
            "SELECT * FROM estadoUsuario "
            + "WHERE estUsuId=?";
    private static final String SQL_READALL=
            "SELECT * FROM estadoUsuario";
    
    private static final Conexion cnn=Conexion.estado();
    
    @Override
    public boolean create(EstadoUsuario c) {
    
        PreparedStatement pst;
        
        try {    
            pst=cnn.getCnn().prepareStatement(SQL_INSERT);
            pst.setString(1, c.getEstUsuId());
            pst.setString(2, c.getEstUsuNombre());
            pst.setString(3, c.getEstUsuDescripcion());
            if(pst.executeUpdate()>0)
            {
                return true;
            }    
        } catch (SQLException ex) {
            Logger.getLogger(EstadoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(EstadoUsuario c) {
        
        PreparedStatement pst;

        try {
            pst=cnn.getCnn().prepareStatement(SQL_UPDATE);
            pst.setString(1, c.getEstUsuNombre());
            pst.setString(2, c.getEstUsuDescripcion());
            pst.setString(3, c.getEstUsuId());
            if(pst.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EstadoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public EstadoUsuario read(Object llave) {
    
        PreparedStatement pst;
        ResultSet res;
        EstadoUsuario estUsu = null;
        
        try {
            pst = cnn.getCnn().prepareStatement(SQL_READ);
            pst.setString(1, llave.toString());
            res = pst.executeQuery();
            while(res.next()){
                estUsu=new EstadoUsuario(res.getString(1), res.getString(2), res.getString(3));
            }
            return estUsu;
        } catch (SQLException ex) {
            Logger.getLogger(EstadoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return estUsu;
    }

    @Override
    public ArrayList<EstadoUsuario> readAll() {
    
        PreparedStatement pst;
        ResultSet res;
        ArrayList<EstadoUsuario> estUsuarios=new ArrayList();
        
        try {
            pst=cnn.getCnn().prepareStatement(SQL_READALL);
            res=pst.executeQuery();
            while(res.next()){
                estUsuarios.add(new EstadoUsuario(res.getString(1), res.getString(2), res.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return estUsuarios;
    }
    
}
