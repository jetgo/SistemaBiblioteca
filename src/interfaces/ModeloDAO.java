/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author David
 */
public interface ModeloDAO <Algo>{
    public boolean create(Algo c);
    public boolean update(Algo c);
    public boolean delete(Object llave);
    
    public Algo read(Object llave);
    public ArrayList<Algo> readAll();
}
