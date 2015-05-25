/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcion;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author David
 */
public class DatosGenerales {
    public static String horaActual(){
        String hora="";
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("hh:mm:ss:SSS");
        hora=String.valueOf(formateador.format(ahora));
        return hora;
    }
    
    public static String fechaActual(){
        String fecha="";
        Date ahora = new Date();
        SimpleDateFormat formateador = new SimpleDateFormat("EEEE dd 'de' MMMM 'de' yyyy");
        fecha=String.valueOf(formateador.format(ahora));
        return fecha;
    }
    public static String actualHoraFecha(){
        return "NADA";
    }
    
}
