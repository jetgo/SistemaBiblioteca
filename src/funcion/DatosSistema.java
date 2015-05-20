/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcion;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author David
 */
public class DatosSistema {
          
    public static String ipCliente(){
        String sHostName;
        String sIPAddress = "";
        try {
            InetAddress address = InetAddress.getLocalHost();
            sHostName = address.getHostName();
            // Cogemos la IP
            byte[] bIPAddress = address.getAddress();  
            
            for (int x=0; x<bIPAddress.length; x++) {
                if (x > 0) {
                    // A todos los numeros les anteponemos
                    // un punto menos al primero
                    sIPAddress += ".";
                }
                // Jugamos con los bytes y cambiamos el bit del signo
                sIPAddress += bIPAddress[x] & 255;
            }
        } catch (UnknownHostException ex) {
            Logger.getLogger(DatosSistema.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sIPAddress;
    }
}
