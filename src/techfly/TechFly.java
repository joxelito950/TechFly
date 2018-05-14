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
        for(int i=10;i<30;i++){
            if(i%2!=0)
                id="AV"+fecha.get(Calendar.DAY_OF_WEEK_IN_MONTH);
            else
                id="VC"+fecha.get(Calendar.DAY_OF_MONTH);
            switch (i){
                case 10:
                    origen="Panama";
                    destino="Medellin";
                    id+="PAME";
                    fecha.set(Calendar.DAY_OF_MONTH,(10));
                    break;
                case 12:
                    origen="Peru";
                    destino="Medellin";
                    id+="PEME";
                    fecha.set(Calendar.DAY_OF_MONTH,(12));
                    break;
                case 13:
                    origen="Chile";
                    destino="Bogota";
                    id+="CBOG";
                    fecha.set(Calendar.DAY_OF_MONTH,(13));
                    break;
                case 14:
                    origen="Bogota";
                    destino="Medellin";
                    id+="BOGME";
                    fecha.set(Calendar.DAY_OF_MONTH,(14));
                    break;
                case 15:
                    origen="Madrid";
                    destino="Medellin";
                    id+="MME";
                    fecha.set(Calendar.DAY_OF_MONTH,(15));
                    break;
                case 16:
                    origen="Cali";
                    destino="Medellin";
                    id+="CAME";
                    fecha.set(Calendar.DAY_OF_MONTH,(16));
                    break;
                case 17:
                    origen="Medellin";
                    destino="Mexico";
                    id+="MEME";
                    fecha.set(Calendar.DAY_OF_MONTH,(17));
                    break;
                case 18:
                    origen="Barranquilla";
                    destino="Bogota";
                    id+="BABOG";
                    fecha.set(Calendar.DAY_OF_MONTH,(18));
                    break;
                case 19:
                    origen="Bucaramanga";
                    destino="Cali";
                    id+="BUCA";
                    fecha.set(Calendar.DAY_OF_MONTH,(19));
                    break;
                case 20:
                    origen="Cartagena";
                    destino="Manizales";
                    id+="CARMA";
                    fecha.set(Calendar.DAY_OF_MONTH,(20));
                    break;
                default:
                    origen="Venezuela";
                    destino="Medellin";
                    id+="VEME";
                    fecha.set(Calendar.DAY_OF_MONTH,(i));
                    break;
            }
            System.out.println(fecha.getTime());
            listaVuelos.agregarVuelo(id, origen, destino, fecha);
        }
    }
    
    public static void main(String args[]) {
        inicializarVuelos();
        consultarVuelos();
    }
    
}
