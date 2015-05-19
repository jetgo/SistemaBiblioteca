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
import modelo.Recurso;

/**
 *
 * @author David
 */
public class RecursoDAO implements Obligacion<Recurso> {
    
    private static final String SQL_INSERT=
            "INSERT INTO recurso "
            + "(recId, tipRecId, recIsbn, recTitulo, recFechaAdquisicion, recAutor, recEditorial, recEdicion, recNumPagina) "
            + "VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE=
            "UPDATE recurso "
            + "SET tipRecId=?, recIsbn=?, recTitulo=?, recFechaAdquisicion=?, recAutor=?, recEditorial=?, recEdicion=?, recNumPagina=?"
            + "WHERE recId=?";
    private static final String SQL_DELETE=
            "DELETE FROM recurso "
            + "WHERE recId=?";
    
    private static final String SQL_READ=
            "SELECT * FROM recurso "
            + "WHERE recId=?";
    private static final String SQL_READALL=
            "SELECT * FROM recurso";
    
    private static final Conexion cnn=Conexion.estado();

    @Override
    public boolean create(Recurso c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_INSERT);
            pst.setString(1, c.getRedId());
            pst.setString(2, c.getTipRecId());
            pst.setString(3, c.getRecIsbn());
            pst.setString(4, c.getRecTitulo());
            pst.setString(5, c.getRecFechaAdquisicion());
            pst.setString(6, c.getRecAutor());
            pst.setString(7, c.getRecEdicion());
            pst.setString(8, c.getRecEditorial());
            pst.setString(9, c.getRecNumPagina());
            if(pst.executeUpdate()>0)
            {
                return true;
            }      
        } catch (SQLException ex) {
            Logger.getLogger(RecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public boolean update(Recurso c) {
        
        PreparedStatement pst;
        try {
            pst=cnn.getCnn().prepareStatement(SQL_UPDATE);
            pst.setString(1, c.getTipRecId());
            pst.setString(2, c.getRecIsbn());
            pst.setString(3, c.getRecTitulo());
            pst.setString(4, c.getRecFechaAdquisicion());
            pst.setString(5, c.getRecAutor());
            pst.setString(6, c.getRecEdicion());
            pst.setString(7, c.getRecEditorial());
            pst.setString(8, c.getRecNumPagina());
            pst.setString(9, c.getRedId());
            if(pst.executeUpdate()>0){
                return true;
            }    
        } catch (SQLException ex) {
            Logger.getLogger(RecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return false;
    }

    @Override
    public Recurso read(Object llave) {
        
        PreparedStatement pst;
        ResultSet res;
        Recurso rec = null;
        try {
            pst = cnn.getCnn().prepareStatement(SQL_READ);
            pst.setString(1, llave.toString());
            res = pst.executeQuery();
            while(res.next()){
                rec=new Recurso(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),res.getString(7), res.getString(8), res.getString(9));
            }
            return rec;    
        } catch (SQLException ex) {
            Logger.getLogger(RecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return rec;
    }

    @Override
    public ArrayList<Recurso> readAll() {

        PreparedStatement pst;
        ResultSet res;
        ArrayList<Recurso> recursos=new ArrayList();
        try {
            pst=cnn.getCnn().prepareStatement(SQL_READALL);
            res=pst.executeQuery();
            while(res.next()){
                recursos.add(new Recurso(res.getString(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5), res.getString(6),res.getString(7), res.getString(8), res.getString(9)));
            }    
        } catch (SQLException ex) {
            Logger.getLogger(RecursoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            cnn.cerrarConexion();
        }
        return recursos;
    }
}
