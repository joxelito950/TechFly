/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techfly;

import java.util.Calendar;

/**
 *
 * @author jose-
 */
public class Reserva {
    private Vuelo vuelo;
    private String idCliente;
    private Calendar reserva;
    private Reserva sigReserva;

    public Reserva(Vuelo vuelo,String idCliente) {
        this.vuelo = vuelo;
        this.idCliente = idCliente;
        this.reserva = Calendar.getInstance();
    }

    public Vuelo getVuelo() {
        return vuelo;
    }

    public void setVuelo(Vuelo vuelo) {
        this.vuelo = vuelo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Calendar getTime() {
        return reserva;
    }

    public Reserva getSigReserva() {
        return sigReserva;
    }

    public void setSigReserva(Reserva sigReserva) {
        this.sigReserva = sigReserva;
    }
    
}
