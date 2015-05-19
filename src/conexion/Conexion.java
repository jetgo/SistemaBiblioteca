/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;
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
            cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?zeroDateTimeBehavior=convertToNull", "root", "mysql");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public synchronized static Conexion estado(){
        if (instance==null) {
            instance=new Conexion();
        }
        return instance;
    }
    
    public Connection getCnn(){
        return cnn;
    }
    
    public void cerrarConexion(){
        instance=null;
    }
    
//    Statement state;
//    ResultSet res;
//    
//    public Conexion() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/biblioteca?zeroDateTimeBehavior=convertToNull", "root", "mysql");
//        } catch (SQLException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
    
    
    
    
//    public Connection conexion(){
//        try {
//            //cargar driver MySql
//            Class.forName("com.mysql.jdbc.Driver");
//            con=DriverManager.getConnection("jdbc:mysql://localhost/biblioteca","root","mysql");
//            System.out.println("Conexion Establecida");
//            JOptionPane.showMessageDialog(null, "Conexion Establecida");
//        } catch (ClassNotFoundException | SQLException e) {
//            System.out.println("Error de Conexion");
//            JOptionPane.showMessageDialog(null, "Error de Conexion"+e);
//        }
//        return con;
//    }

    

    
}
