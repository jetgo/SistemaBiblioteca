/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import modelo.Empresa;
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
public class EmpresaDAO implements Obligacion<Empresa>{
    
    private static final String SQL_INSERT=
            "INSERT INTO empresa "
            + "(empRol, empNombre, empDireccion) "
            + "VALUES (?,?,?)";
    private static final String SQL_UPDATE=
            "UPDATE empresa "
            + "SET empNombre=?, empDireccion=? "
            + "WHERE empRol=?";
    private static final String SQL_DELETE=
            "DELETE FROM empresa "
            + "WHERE empRol=?";
    
    private static final String SQL_READ=
            "SELECT * FROM empresa "
            + "WHERE empRol=?";
    private static final String SQL_READALL=
            "SELECT * FROM empresa";
    
    private static final Conexion cnn=Conexion.estado();
    
    @Override
    public boolean create(Empresa c) {
    
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_INSERT);
            pst.setString(1, c.getEmpRol());
            pst.setString(2, c.getEmpNombre());
            pst.setString(3, c.getEmpDireccion());
            if(pst.executeUpdate()>0)
            {
                return true;
            }    
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Empresa c) {
    
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_UPDATE);
            pst.setString(1, c.getEmpNombre());
            pst.setString(2, c.getEmpDireccion());
            pst.setString(3, c.getEmpRol());
            if(pst.executeUpdate()>0){
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public Empresa read(Object llave) {
        
        PreparedStatement pst;
        ResultSet res;
        Empresa emp = null;
        try {
            pst = cnn.getCnn().prepareStatement(SQL_READ);
            pst.setString(1, llave.toString());
            res = pst.executeQuery();
            while(res.next()){
                emp=new Empresa(res.getString(1), res.getString(2), res.getString(3));
            }
            return emp;    
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return emp;
    }

    @Override
    public ArrayList<Empresa> readAll() {
        
        PreparedStatement pst;
        ResultSet res;
        ArrayList<Empresa> empresas=new ArrayList();
        try {
            pst=cnn.getCnn().prepareStatement(SQL_READALL);
            res=pst.executeQuery();
            while(res.next()){
                empresas.add(new Empresa(res.getString(1), res.getString(2), res.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpresaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return empresas;
    }
    
}
