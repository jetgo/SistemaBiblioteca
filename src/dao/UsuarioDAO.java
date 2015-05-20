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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author David
 */
public class UsuarioDAO implements ModeloDAO<Usuario>{

    private static final String SQL_INSERT=
            "INSERT INTO usuario "
            + "(usuId, perRut, tipUsuId, estUsuId, preSecId, usuAlias, usuClave, usuRespuesta, usuHoraRegistro, usuFechaRegistro) "
            + "VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE=
            "UPDATE usuario "
            + "SET perRut=?, tipUsuId=?, estUsuId=?, preSecId=?, usuAlias=?, usuClave=?, usuRespuesta=?, usuHoraRegistro=?, usuFechaRegistro=?  "
            + "WHERE usuId=?";
    private static final String SQL_DELETE=
            "DELETE FROM usuario "
            + "WHERE usuId=?";
    private static final String SQL_READ=
            "SELECT * FROM usuario "
            + "WHERE usuId=?";
    private static final String SQL_READALL=
            "SELECT * FROM usuario";
    
    private static final String SQL_FINDBYRUT=
            "SELECT * FROM usuario "
            + "WHERE perRut=?";
    
    private static final String SQL_NEXTID=
            "SELECT MAX(usuId)+1 AS Id "
            + "FROM usuario";
    
    
    private static final Conexion cnn=Conexion.estado();
    
    @Override
    public boolean create(Usuario c) {
        
        PreparedStatement pst;
        
        try {       
            pst=cnn.getCnn().prepareStatement(SQL_INSERT);
            pst.setString(1, c.getUsuId());
            pst.setString(2, c.getPerRut());
            pst.setString(3, c.getTipUsuId());
            pst.setString(4, c.getEstUsuId());
            pst.setString(5, c.getPreSecId());
            pst.setString(6, c.getUsuAlias());
            pst.setString(7, c.getUsuClave());
            pst.setString(8, c.getUsuRespuesta());
            pst.setString(9, c.getUsuHoraRegistro());
            pst.setString(10, c.getUsuFechaRegistro());
            if(pst.executeUpdate()>0)
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Usuario c) {
        
        PreparedStatement pst;
        
        try {
            pst=cnn.getCnn().prepareStatement(SQL_UPDATE);
            pst.setString(1, c.getTipUsuId());
            pst.setString(2, c.getEstUsuId());
            pst.setString(3, c.getPerRut());            
            pst.setString(4, c.getPreSecId());
            pst.setString(5, c.getUsuAlias());
            pst.setString(6, c.getUsuClave());
            pst.setString(7, c.getUsuRespuesta());
            pst.setString(8, c.getUsuFechaRegistro());
            pst.setString(9, c.getUsuHoraRegistro());
            pst.setString(10, c.getUsuId());
            if(pst.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean delete(Object llave) {
        
        PreparedStatement pst;
        
        try {
            pst=cnn.getCnn().prepareStatement(SQL_DELETE);
            pst.setString(1, llave.toString());
            
            if(pst.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;        
    }

    @Override
    public Usuario read(Object llave) {
        
        PreparedStatement pst;
        ResultSet res;
        Usuario usu=null;
        
        try {
            pst= cnn.getCnn().prepareStatement(SQL_READ);
            pst.setString(1, llave.toString());
            res=pst.executeQuery();
            while(res.next()){
                usu=new Usuario(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6), res.getString(7), res.getString(8), res.getString(9), res.getString(10));
            }
            return usu;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return usu;        
    }

    @Override
    public ArrayList<Usuario> readAll() {
        
        PreparedStatement pst;
        ResultSet res;
        ArrayList<Usuario> usuarios=new ArrayList();
            
        try {            
            pst=cnn.getCnn().prepareStatement(SQL_READALL);
            res=pst.executeQuery();
            while(res.next()){
                usuarios.add(new Usuario(res.getString("usuId"), res.getString("perRut"), res.getString("tipUsuId"), res.getString("estUsuId"), res.getString("preSecId"), res.getString("usuAlias"), res.getString("usuClave"), res.getString("usuRespuesta"), res.getString("usuHoraRegistro"), res.getString("usuFechaRegistro")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            cnn.cerrarConexion();
        }
        return usuarios;
    }
    
    public Usuario findByRut(Object llave) {
        
        PreparedStatement pst;
        ResultSet res;
        Usuario usu = null;
        
        try {
            pst= cnn.getCnn().prepareStatement(SQL_FINDBYRUT);
            pst.setString(1, llave.toString());
            res=pst.executeQuery();
            while(res.next()){
                usu = new Usuario(res.getString("usuId"), res.getString("perRut"), res.getString("tipUsuId"), res.getString("estUsuId"), res.getString("preSecId"), res.getString("usuAlias"), res.getString("usuClave"), res.getString("usuRespuesta"), res.getString("usuHoraRegistro"), res.getString("usuFechaRegistro"));
            }
            return usu;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return usu;        
    }
    
    
    public String nextID(){
        PreparedStatement pst;
        ResultSet res;
        String proximoId=null;
        
        try {
            pst=cnn.getCnn().prepareStatement(SQL_NEXTID);
            res=pst.executeQuery();
            while (res.next()) { 
                proximoId=res.getString("Id");
            }
            if(proximoId==null){
                return "1000";
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return proximoId;
    }
    
}
