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
import modelo.EstadoInterfaz;
import modelo.HistorialUsuario;

/**
 *
 * @author David
 */
public class EstadoInterfazDAO implements ModeloDAO<EstadoInterfaz>{
    private static final String SQL_INSERT=
            "INSERT INTO estadoInterfaz "
            + "(estIntId, intId, usuId) "
            + "VALUES (?,?,?)";
    private static final String SQL_UPDATE=
            "UPDATE estadoInterfaz "
            + "SET intId=?, usuId=? "
            + "WHERE estIntId=?";
    private static final String SQL_DELETE=
            "DELETE FROM estadoInterfaz "
            + "WHERE estIntId=?";
    private static final String SQL_READ=
            "SELECT * FROM estadoInterfaz "
            + "WHERE estIntId=?";
    private static final String SQL_READALL=
            "SELECT * FROM estadoInterfaz";
    
    private static final String SQL_NEXTID=
            "SELECT MAX(estIntId)+1 AS Id "
            + "FROM estadoInterfaz";
    
    private static final String SQL_FINDBYUSUARIO=
        "SELECT * FROM estadoInterfaz "
        + "WHERE usuId=?";
    
    private static final Conexion cnn=Conexion.estado();    

    @Override
    public boolean create(EstadoInterfaz c) {
        PreparedStatement pst;
        try {

            pst = cnn.getCnn().prepareStatement(SQL_INSERT);
            pst.setString(1, c.getEstIntId());
            pst.setString(2, c.getIntId());
            pst.setString(3, c.getUsuId());
            if(pst.executeUpdate() > 0)
            {
                return true;
            }   
        } catch (SQLException ex) {
            Logger.getLogger(EstadoInterfazDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(EstadoInterfaz c) {
        PreparedStatement pst;
        try {
            
            pst=cnn.getCnn().prepareStatement(SQL_UPDATE);
            pst.setString(1, c.getIntId());
            pst.setString(2, c.getUsuId());
            pst.setString(3, c.getEstIntId());
            if(pst.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadoInterfazDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EstadoInterfazDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public EstadoInterfaz read(Object llave) {
        PreparedStatement pst;
        ResultSet res;
        EstadoInterfaz estInt = null;
        try {

            pst = cnn.getCnn().prepareStatement(SQL_READ);
            pst.setString(1, llave.toString());
            res = pst.executeQuery();
            while(res.next()){
                estInt=new EstadoInterfaz(res.getString("estIntId"), res.getString("intId"), res.getString("usuId"));
            }
            return estInt;   
        } catch (SQLException ex) {
            Logger.getLogger(EstadoInterfazDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            cnn.cerrarConexion();
        }
        return estInt;
    }

    @Override
    public ArrayList<EstadoInterfaz> readAll() {
        PreparedStatement pst;
        ResultSet res;
        ArrayList<EstadoInterfaz> estInterfaces=new ArrayList();
        try {
            pst=cnn.getCnn().prepareStatement(SQL_READALL);
            res=pst.executeQuery();
            while(res.next()){
                estInterfaces.add(new EstadoInterfaz(res.getString("estIntId"), res.getString("intId"), res.getString("usuId")));
            }    
        } catch (SQLException ex) {
            Logger.getLogger(EstadoInterfazDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return estInterfaces;
    }
    
    public ArrayList<EstadoInterfaz> findByUsuario(Object llave){
        PreparedStatement pst;
        ResultSet res;
        ArrayList<EstadoInterfaz> estInterfaces=new ArrayList();
        try {

            pst=cnn.getCnn().prepareStatement(SQL_FINDBYUSUARIO);
            pst.setString(1, llave.toString());
            res=pst.executeQuery();
            while(res.next()){
                estInterfaces.add(new EstadoInterfaz(res.getString("estIntId"), res.getString("intId"), res.getString("usuId")));
            }   
        } catch (SQLException ex) {
            Logger.getLogger(EstadoInterfazDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return estInterfaces;
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
                return "2000";
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstadoInterfazDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proximoId;
    }
}
