/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techfly;
import java.util.*;
import java.io.*;
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
        consultaReservas.ConsultaReservas(listaReservas,cedula);
    }
    
    public static void reservar(String cedula,Vuelo vuelo){
        reservar.reserva(cedula, vuelo);
    }
    
    public static void inicializarVuelos(){
        Calendar fecha=Calendar.getInstance();
        String id,origen,destino;
        for(int i=0;i<=20;i++){
            fecha.set(Calendar.DAY_OF_MONTH, Calendar.DAY_OF_MONTH + i);
            fecha.set(Calendar.HOUR,i);
            if(i%2!=0)
                id="AV"+fecha.get(Calendar.DAY_OF_WEEK_IN_MONTH);
            else
                id="VC"+fecha.get(Calendar.DAY_OF_MONTH);
            switch (i){
                case 0:
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
                case 15:
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
                    origen="Medellin";
                    destino="Mexico";
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
    
    public static void inicializarReservas(){
      try {
      FileReader fr = new FileReader("C:/Users/jose-/OneDrive/Documentos/GitHub/TechFly/test/reservas.txt");
      BufferedReader br = new BufferedReader(fr);
      String idCliente,idVuelo,origen,destino,mes,dia,hora,minuto,año;
      Vuelo reservado;
      Calendar fecha=Calendar.getInstance();
      Reserva nuevo;
      while((idCliente = br.readLine()) != null){
          idVuelo=br.readLine();
          origen=br.readLine();
          destino=br.readLine();
          mes=br.readLine();
          dia=br.readLine();
          hora=br.readLine();
          minuto=br.readLine();
          año=br.readLine();
          fecha.set(Integer.parseInt(año), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
          reservado=new Vuelo(idVuelo,origen,destino,fecha);
          nuevo=new Reserva(reservado, idCliente);
          mes=br.readLine();
          dia=br.readLine();
          hora=br.readLine();
          minuto=br.readLine();
          año=br.readLine();
          fecha.set(Integer.parseInt(año), Integer.parseInt(mes), Integer.parseInt(dia), Integer.parseInt(hora), Integer.parseInt(minuto));
          nuevo.setTime(fecha);
          listaReservas.agregarReserva(nuevo);
      }
      fr.close();
    }
    catch(Exception e) {
      System.out.println("No se recuperaron las reservas: " + e.getMessage());
    }

    }
    
    public static void salvarReservas(){
        if(listaReservas!=null){
            Reserva recorre=listaReservas.getInicio();
            Vuelo reservado;
            Calendar fecha;
            FileWriter fichero = null;
            PrintWriter pw = null;
            try
            {
                fichero = new FileWriter("C:/Users/jose-/OneDrive/Documentos/GitHub/TechFly/test/reservas.txt");
                pw = new PrintWriter(fichero);
                while(recorre!=null){
                    pw.println(recorre.getIdCliente());
                    reservado=recorre.getVuelo();
                    pw.println(reservado.getId());
                    pw.println(reservado.getOrigen());
                    pw.println(reservado.getDestino());
                    fecha=reservado.getFecha();
                    pw.println(fecha.get(Calendar.MONTH));
                    pw.println(fecha.get(Calendar.DAY_OF_MONTH));
                    pw.println(fecha.get(Calendar.HOUR));
                    pw.println(fecha.get(Calendar.MINUTE));
                    pw.println(fecha.get(Calendar.YEAR));
                    fecha=recorre.getTime();
                    pw.println(fecha.get(Calendar.MONTH));
                    pw.println(fecha.get(Calendar.DAY_OF_MONTH));
                    pw.println(fecha.get(Calendar.HOUR));
                    pw.println(fecha.get(Calendar.MINUTE));
                    pw.println(fecha.get(Calendar.YEAR));
                    recorre=recorre.getSigReserva();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                if (null != fichero)
                   fichero.close();
                } 
                catch (IOException e2) {
                   e2.printStackTrace();
                }
            }
        }
    }
    
    public static void main(String args[]) {
        inicializarVuelos();
        inicializarReservas();
        consultarVuelos();
    }
    
}
