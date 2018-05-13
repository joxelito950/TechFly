/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techfly;
import java.util.*;
/**
 *
 * @author jose-
 */
public class TechFly{

    /**
     * @param args the command line arguments
     */
    static Vuelos listaVuelos = new Vuelos();
    static Reservas listaReservas = new Reservas();
    static Ventana panel = new Ventana();
    public static Vuelos getListaVuelos() {
        return listaVuelos;
    }

    public static Reservas getListaReservas() {
        return listaReservas;
    }
    public static void consulta(){
        panel.consulta(listaVuelos);
    }
    
    public static void inicializarVuelos(){
        Calendar fecha=Calendar.getInstance();
        String id,origen,destino;
        for(int i=0;i<fecha.get(Calendar.DAY_OF_YEAR);i++){
            if(i%2!=0)
                id="TNF"+fecha.get(Calendar.DAY_OF_WEEK_IN_MONTH);
            else
                id="RCT"+fecha.get(Calendar.DAY_OF_MONTH);
            switch (fecha.get(Calendar.DAY_OF_WEEK)){
                case 1:
                    origen="Panama";
                    destino="Medellin";
                    id+="PAME";
                    break;
                case 2:
                    origen="Peru";
                    destino="Medellin";
                    id+="PEME";
                    break;
                case 3:
                    origen="Chile";
                    destino="Bogota";
                    id+="CBOG";
                    break;
                case 4:
                    origen="BOGOTA";
                    destino="Medellin";
                    id+="BOGME";
                    break;
                case 5:
                    origen="Madrid";
                    destino="Medellin";
                    id+="MME";
                    break;
                case 6:
                    origen="Cali";
                    destino="Medellin";
                    id+="CAME";
                    break;
                case 7:
                    origen="Mexico";
                    destino="Medellin";
                    id+="MEME";
                    break;
                default:
                    origen="Venezuela";
                    destino="Medellin";
                    id+="VEME";
                    break;
            }
            listaVuelos.agregarVuelo(id, origen, destino, fecha);
        }
    }
    
    public static void main(String args[]) {
        inicializarVuelos();
        consulta();
    }
    
}
