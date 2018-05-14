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
public class Vuelo {
    private String id;
    private String origen;
    private String destino;
    private Calendar fecha;
    private Vuelo proximo;

    public Vuelo(String id, String origen, String destino, Calendar fecha) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fecha = fecha;
        proximo=null;
    }

    public String getId() {
        return id;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public Calendar getFecha() {
        return fecha;
    }

    public Vuelo getProximo() {
        return proximo;
    }

    public void setProximo(Vuelo proximo) {
        this.proximo = proximo;
    }
    
    public String datosVuelo(){
        String datos="";
        datos+=origen+" a "+destino+", Salida "+fecha.getTime()+".";
        return datos;
    }
}
