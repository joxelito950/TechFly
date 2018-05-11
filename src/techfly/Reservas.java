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
public class Reservas {
     private Reserva listadoReservas;
     
     public Reservas(){
         listadoReservas = null;
     }
     
     public void agregarReserva(String idVuelo,String idCliente){
         Reserva nuevo = new Reserva(idVuelo,idCliente);
         if(listadoReservas!=null)
            nuevo.setSigReserva(listadoReservas);
         listadoReservas=nuevo;
     }
     
     
     
}
