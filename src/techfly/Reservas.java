/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techfly;



/**
 *
 * @author jose-
 */
public class Reservas{
    
    private Reserva listadoReservas;
     
     public Reservas(){
        listadoReservas = null;
     }
     
     public void agregarReserva(Vuelo vuelo,String idCliente){
        Reserva nuevo = new Reserva(vuelo,idCliente);
        if(listadoReservas!=null)
          nuevo.setSigReserva(listadoReservas);
        listadoReservas=nuevo;
     }
     
     public void agregarReserva(Reserva reserva){
        if(listadoReservas!=null)
          reserva.setSigReserva(listadoReservas);
        listadoReservas=reserva;
     }
     
     public Reserva getInicio(){
         return listadoReservas;
     }
     
     public Reserva buscarUltimaReserva(String cedula){
        Reserva recorre = listadoReservas;
        while(recorre!=null){
            if(recorre.getIdCliente().equals(cedula))
                break;
            recorre=recorre.getSigReserva();
        }
        return recorre;
    }
}
