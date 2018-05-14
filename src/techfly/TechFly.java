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
    private static Vuelos listaVuelos = new Vuelos();
    private static Reservas listaReservas = new Reservas();
    private static Principal consultaVuelos = new Principal();
    private static MisReservas consultaReservas = new MisReservas();
    private static ConfirmarReserva reservar =new ConfirmarReserva();
    
    public static Vuelos getListaVuelos() {
        return listaVuelos;
    }

    public static Reservas getListaReservas() {
        return listaReservas;
    }
    
    public static void consultarVuelos(){
        consultaVuelos.consulta(listaVuelos);
    }
    
    public static void consultarReservas(String cedula){
        consultaReservas.ConsultaReservas(listaReservas.buscarReservas(cedula));
    }
    
    public static void reservar(String cedula,Vuelo vuelo){
        reservar.reserva(cedula, vuelo);
    }
    
    public static void inicializarVuelos(){
        Calendar fecha=Calendar.getInstance();
        String id,origen,destino;
        for(int i=0;i<11;i++){
            fecha.set(Calendar.DATE,(Calendar.DATE + i));
            if(i%2!=0)
                id="AV"+fecha.get(Calendar.DAY_OF_WEEK_IN_MONTH);
            else
                id="VC"+fecha.get(Calendar.DAY_OF_MONTH);
            switch (i){
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
                    origen="Bogota";
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
                case 8:
                    origen="Barranquilla";
                    destino="Bogota";
                    id+="BABOG";
                    break;
                case 9:
                    origen="Bucaramanga";
                    destino="Cali";
                    id+="BUCA";
                    break;
                case 10:
                    origen="Cartagena";
                    destino="Manizales";
                    id+="CARMA";
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
        consultarVuelos();
    }
    
}
