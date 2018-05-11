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
    private String idVuelo;
    private String idCliente;
    private Calendar ultimaReserva;
    private Reserva sigReserva;

    public Reserva(String idVuelo,String idCliente) {
        this.idVuelo = idVuelo;
        this.idCliente = idCliente;
        this.ultimaReserva = Calendar.getInstance();
    }

    public String getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(String idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Calendar getUltimaReserva() {
        return ultimaReserva;
    }

    public Reserva getSigReserva() {
        return sigReserva;
    }

    public void setSigReserva(Reserva sigReserva) {
        this.sigReserva = sigReserva;
    }
    
}
