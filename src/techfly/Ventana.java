/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techfly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import javax.swing.*;

/**
 *
 * @author jose-
 */
    

public class Ventana extends JFrame implements ActionListener{
    private JComboBox listado = new JComboBox();
    private JButton consulta = new JButton("Consultar");
    private JButton reserva = new JButton("Reservar");
    static Vuelos listaVuelos = new Vuelos();
    static Reservas listaReservas = new Reservas();
    public Ventana(){
        setLayout(null);
        
    }
    
    public void consulta(){
        this.setBounds(100, 200, 240, 120);
        this.setTitle("Vuelos");
        listado.setBounds(10, 10, 200, 20);
        Calendar fecha = Calendar.getInstance();
        Vuelo recorre=listaVuelos.getListadoVuelos();
        while(recorre!=null){
            if(recorre.getFecha().get(Calendar.DAY_OF_MONTH)>fecha.get(Calendar.DAY_OF_MONTH))
            {
                listado.addItem(recorre.datosVuelo());
            }
            recorre = recorre.getProximo();
        }
        this.add(listado);
        reserva.setBounds(55, 40, 90, 22);
        this.add(reserva);
        reserva.addActionListener(this);
        this.setVisible(true);
    }
    
    public void reserva(){
        this.setBounds(100, 200, 240, 120);
        this.setTitle("Reservar");
        consulta.setBounds(55, 40, 90, 22);
        this.add(consulta);
        consulta.addActionListener(this);
    }
            
            
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==reserva){
            reserva();
        }
        if(e.getSource()==consulta){
            consulta();
        }
    }
}
