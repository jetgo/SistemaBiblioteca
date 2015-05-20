/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
            pw.println(",");
            pw.print(fechaCreacion);
            pw.close();
            bw.close();
            fw.close();
            
        } catch (IOException ex) {
            System.out.println("Algo malo paso en la escritura del Archivo");
        }
    }
    
    public static void recuperarSesion(String nombre){
        
        File session;
        BufferedReader br;
        FileReader fr;
        try{
            session=new File("session.txt");
            fr = new FileReader(session);
            br = new BufferedReader(fr);
            
            
            br.close();
            fr.close();
        } catch (Exception e) {
            System.out.println("UN ERROR EN LA LECTURA");
        }
    }
}
