/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funcion;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author David
 */
public class DatosPersonales {
    
    /**
     * Le da formato a un rut, concatenándole puntos y guión.
     * @param rut DatosPersonales a formatear.
     * @return Un nuevo String, con el rut formateado.
     */
    public static String formatear(String rut){
        int cont=0;
        String format;
        if(rut.length() == 0){
            return "";
        }else{
            rut = rut.replace(".", "");
            rut = rut.replace("-", "");
            format = "-"+rut.substring(rut.length()-1);
            for(int i = rut.length()-2;i>=0;i--){
                format = rut.substring(i, i+1)+format;
                cont++;
                if(cont == 3 && i != 0){
                    format = "."+format;
                    cont = 0;
                }
            }
            return format;
        }
    }

    /**
     * Valida un rut de acuerdo a su dígito verificador.
     * @param rut DatosPersonales a validar
     * @return true si el rut es válido,
     * false en cualquier otro caso.
     */
    public static boolean validarRut(String rut){
        int suma=0;
        String dvR,dvT;
        int[] serie = {2,3,4,5,6,7};
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        dvR = rut.substring(rut.length()-1);
        for(int i = rut.length()-2;i>=0; i--){
            try{
                suma +=  Integer.valueOf(rut.substring(i, i+1))*serie[(rut.length()-2-i)%6];
            } catch (Exception e){
                return false;
            }
        }
        dvT=String.valueOf(11-suma%11);
        if(dvT.compareToIgnoreCase("10") == 0){
            dvT = "K";
        }

        if(dvT.compareToIgnoreCase(dvR) == 0){
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean validoEmail(String email) {
        
        boolean valido = false;
        
        email = email.toLowerCase();
        if (email.matches("^[A-Za-z0-9._%-]+@[A-Za-z0-9.-]+\\.[a-zA-Z]{2,4}$")){
           valido = true;  
        }
        return valido;
    }
    
}
