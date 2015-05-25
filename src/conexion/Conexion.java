/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
import funcion.Mensaje;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class Conexion {

    private static Conexion instance;
    private Connection cnn;
    
    private Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver"); //definir el Driver
            cnn = DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?zeroDateTimeBehavior=convertToNull", "root", "mysql");
        } catch (ClassNotFoundException | SQLException ex) {
            
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            
        } finally {
            //System.out.println("Conexion Arriba...");
        }
        
    }
    
    public synchronized static Conexion estado(){
        if (instance==null) {
            //System.out.println("Conexion RE-Establecida");
            instance=new Conexion();
        }
        //System.out.println("Conexion Estable...");
        return instance;
    }
    
    public Connection getCnn(){
        //System.out.println("Recojiendo la Conexion");
        return cnn;
    }
    
    public void cerrarConexion(){
        instance=null;
       //System.out.println("Desconexion de la Base de Datos");
    }

}
