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
import modelo.TipoRecurso;

/**
 *
 * @author David
 */
public class TipoRecursoDAO implements Obligacion<TipoRecurso>{
    
    private static final String SQL_INSERT=
            "INSERT INTO tipoRecurso "
            + "(tipRecId, tipRecNombre, tipRecDescripcion) "
            + "VALUES (?,?,?)";
    private static final String SQL_UPDATE=
            "UPDATE tipoRecurso "
            + "SET tipUsuNombre=?, tipUsuDescripcion=? "
            + "WHERE tipRecId=?";
    private static final String SQL_DELETE=
            "DELETE FROM tipoRecurso "
            + "WHERE tipRecId=?";
    
    private static final String SQL_READ=
            "SELECT * FROM tipoRecurso "
            + "WHERE tipRecId=?";
    private static final String SQL_READALL=
            "SELECT * FROM tipoRecurso";
    
    private static final Conexion cnn=Conexion.estado();

    @Override
    public boolean create(TipoRecurso c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_INSERT);
            pst.setString(1, c.getTipRecId());
            pst.setString(2, c.getTipRecNombre());
            pst.setString(3, c.getTipRecDescripcion());
            if(pst.executeUpdate()>0)
            {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoRecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
 }

    @Override
    public boolean update(TipoRecurso c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_UPDATE);
            pst.setString(1, c.getTipRecNombre());
            pst.setString(2, c.getTipRecDescripcion());
            pst.setString(3, c.getTipRecId());
            if(pst.executeUpdate()>0){
                return true;
            }   
        } catch (SQLException ex) {
            Logger.getLogger(TipoRecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TipoRecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public TipoRecurso read(Object llave) {
        
        PreparedStatement pst;
        ResultSet res;
        TipoRecurso tipRec = null;
        try {
            pst = cnn.getCnn().prepareStatement(SQL_READ);
            pst.setString(1, llave.toString());
            res = pst.executeQuery();
            while(res.next()){
                tipRec=new TipoRecurso(res.getString(1), res.getString(2), res.getString(3));
            }
            return tipRec;    
        } catch (SQLException ex) {
            Logger.getLogger(TipoRecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return tipRec;
    }

    @Override
    public ArrayList<TipoRecurso> readAll() {
        
        PreparedStatement pst;
        ResultSet res;
        ArrayList<TipoRecurso> tipoRecursos=new ArrayList();
        try {
            pst=cnn.getCnn().prepareStatement(SQL_READALL);
            res=pst.executeQuery();
            while(res.next()){
                tipoRecursos.add(new TipoRecurso(res.getString(1), res.getString(2), res.getString(3)));
            }    
        } catch (SQLException ex) {
            Logger.getLogger(TipoRecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return tipoRecursos;
    }
    
}
