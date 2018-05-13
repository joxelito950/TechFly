/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techfly;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author jose-
 */
public class Reservas extends JFrame implements ActionListener {
    private JLabel text;
    private JLabel text1;
    private JButton cancelar;
    private JButton reserva;
    private JCheckBox mayorEdad;
    private boolean reservar;
    
    private Reserva listadoReservas;
     
     public Reservas(){
        listadoReservas = null;
        JLabel text= new JLabel();
        JLabel text1= new JLabel();
        JButton cancelar = new JButton();
        JButton reserva = new JButton();
        JCheckBox mayorEdad = new JCheckBox();
        boolean reservar = false;
     }
     
     public void agregarReserva(String idVuelo,String idCliente){
         Reserva nuevo = new Reserva(idVuelo,idCliente);
         if(listadoReservas!=null)
            nuevo.setSigReserva(listadoReservas);
         listadoReservas=nuevo;
     }
     
     public Reserva getInicio(){
         return listadoReservas;
     }
     
     public void reserva(String cedula, String vuelo){
        reservar=false;
        //setBounds
        this.setBounds(100, 300, 600, 150);
        text.setBounds(10,5,500,22);
        mayorEdad.setBounds(30,30,400,22);
        cancelar.setBounds(25, 90, 90,22);
        reserva.setBounds(145, 90, 90, 22);
        //setInformation
        this.setTitle("Reserva para " + cedula);
        text.setText(vuelo);
        mayorEdad.setText("Soy Mayor de Edad");
        cancelar.setText("Cancelar");
        reserva.setText("reservar");
        //addThis
        this.add(text);
        this.add(mayorEdad);
        this.add(cancelar);
        this.add(reserva);
        //changeVisible
        text.setVisible(true);
        text1.setVisible(false);
        mayorEdad.setVisible(true);
        cancelar.setVisible(true);
        reserva.setVisible(true);
        this.setVisible(true);
        //enable
        reserva.setEnabled(false);
        //acction
        mayorEdad.addActionListener(this);
        cancelar.addActionListener(this);
        reserva.addActionListener(this);
        if(reservar==true)
            agregarReserva(vuelo,cedula);
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==mayorEdad)
            reserva.setEnabled(true);
        if(e.getSource()==cancelar)
            TechFly.consulta();
        if(e.getSource()==reserva)
            reservar=true;
    }
     
     
     
}
