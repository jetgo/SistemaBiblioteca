/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author David
 */
public class ManejoSesion {
    
    public static void crearSesion(String usuario, String fechaCreacion){
        File session = new File("session.txt");
        if(!session.exists()){
            try{
                session.createNewFile();
                System.out.println(session.getName()+" ha sido creado");
            } catch (IOException ex){
                ex.printStackTrace();
            }
        }
        try {
            PrintWriter pw;
            BufferedWriter bw;
            FileWriter fw;
            fw=new FileWriter(session);
            bw=new BufferedWriter(fw);
            pw=new PrintWriter(bw);

            pw.println(usuario);
            pw.print(fechaCreacion);
            pw.close();
            bw.close();
            fw.close();
            System.out.println("Archivo ha sido Escrito Correctamente");
        } catch (IOException ex) {
            System.out.println("Algo malo paso en la escritura del Archivo "+ex.toString());
        }
    }
    

    
    
    public static String[] leerSesion(){
        
        File session;
        BufferedReader br;
        FileReader fr;
        String[] miDato=new String[3];
        session=new File("session.txt");
        if(!session.exists()){
//            try{
//                session.createNewFile();
//                System.out.println(session.getName()+" ha sido creado vacio");
//            } catch (IOException ex){
//                ex.printStackTrace();
//            }
            miDato = null;
        }
        try{
            fr = new FileReader(session);
            br = new BufferedReader(fr);
            
            String linea;
            int i=0;
            while ((linea=br.readLine())!=null) {  
                miDato[i]=linea;
                i++;
            }
            
            br.close();
            fr.close();
            System.out.println("Archivo ha sido Leido Correctamente");
        } catch (IOException ex) {
            System.out.println("UN ERROR EN LA LECTURA"+ex.toString());
        }
        return miDato;
    }
}
