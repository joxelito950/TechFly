/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techfly;

import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;

/**
 *
 * @author jose-
 */
public class Vuelos{
    private Vuelo listadoVuelos;
    public Vuelos(){
        listadoVuelos=null;
    }

    public Vuelo getListadoVuelos() {
        return listadoVuelos;
    }
    
    public void agregarVuelo(String id,String origen, String destino, Calendar fecha){
       Vuelo nuevo = new Vuelo(id, origen, destino, fecha);
       if(listadoVuelos==null)
           nuevo.setProximo(listadoVuelos);
       listadoVuelos=nuevo;
    }
    
}


