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
import modelo.HistorialUsuario;
import modelo.Interfaz;

/**
 *
 * @author David
 */
public class InterfazDAO implements ModeloDAO<Interfaz>{
    private static final String SQL_INSERT=
            "INSERT INTO interfaz "
            + "(intId, intNombre, intDescripcion) "
            + "VALUES (?,?,?)";
    private static final String SQL_UPDATE=
            "UPDATE interfaz "
            + "SET intNombre=?, intDescripcion=? "
            + "WHERE intId=?";
    private static final String SQL_DELETE=
            "DELETE FROM interfaz "
            + "WHERE intId=?";
    private static final String SQL_READ=
            "SELECT * FROM interfaz "
            + "WHERE intId=?";
    private static final String SQL_READALL=
            "SELECT * FROM interfaz";
    
    private static final String SQL_NEXTID=
            "SELECT MAX(intId)+1 AS Id "
            + "FROM interfaz";
    
    
    private static final Conexion cnn=Conexion.estado();

    @Override
    public boolean create(Interfaz c) {
        PreparedStatement pst;
        
        try {
            pst=cnn.getCnn().prepareStatement(SQL_INSERT);
            pst.setString(1, c.getIntId());
            pst.setString(2, c.getIntNombre());
            pst.setString(3, c.getIntDescripcion());
            if(pst.executeUpdate()>0)
            {
                return true;
            }    
        } catch (SQLException ex) {
            Logger.getLogger(InterfazDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Interfaz c) {
        PreparedStatement pst;
        try {
            pst = cnn.getCnn().prepareStatement(SQL_UPDATE);
            pst.setString(1, c.getIntNombre());
            pst.setString(2, c.getIntDescripcion());
            pst.setString(3, c.getIntId());
            if(pst.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InterfazDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public Interfaz read(Object llave) {
        PreparedStatement pst;
        ResultSet res;
        Interfaz inter = null;
        try {
            pst = cnn.getCnn().prepareStatement(SQL_READ);
            pst.setString(1, llave.toString());
            res = pst.executeQuery();
            while(res.next()){
                inter=new Interfaz(res.getString("intId"), res.getString("intNombre"), res.getString("intDescripion"));
            }
            return inter; 
        } catch (SQLException ex) {
            Logger.getLogger(InterfazDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return inter;
    }

    @Override
    public ArrayList<Interfaz> readAll() {
        PreparedStatement pst;
        ResultSet res;
        ArrayList<Interfaz> interfaces=new ArrayList();
        try {

            pst=cnn.getCnn().prepareStatement(SQL_READALL);
            res=pst.executeQuery();
            while(res.next()){
                interfaces.add(new Interfaz(res.getString("intId"), res.getString("intNombre"), res.getString("intDescripcion")));
            }    
        } catch (SQLException ex) {
            Logger.getLogger(InterfazDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return interfaces;
    }
    
    public String nextID(){
        
        PreparedStatement pst;
        ResultSet res;
        String proximoId = null;
        try {
            pst = cnn.getCnn().prepareStatement(SQL_NEXTID);
            res = pst.executeQuery();
            while (res.next()) { 
                proximoId = res.getString("Id");
            }
            if(proximoId == null){
                return "100";
            }
        } catch (SQLException ex) {
            Logger.getLogger(InterfazDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return proximoId;
    }
}
