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
    private JLabel text= new JLabel();
    private JLabel text1= new JLabel();
    private JButton cancelar = new JButton();
    private JButton reserva = new JButton();
    private JCheckBox mayorEdad = new JCheckBox();
    
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
     
     public void reserva(String cedula, String vuelo){
        //setBounds
        this.setBounds(100, 300, 600, 150);
        text.setBounds(10,5,500,22);
        mayorEdad.setBounds(30,30,400,22);
        cancelar.setBounds(25, 90, 90,22);
        reserva.setBounds(145, 90, 90, 22);
        //setInformation
        this.setTitle("Reservas para " + cedula);
        text.setText(vuelo);
        mayorEdad.setText("Soy Mayor de Edad");
        cancelar.setText("Cancelar");
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
        reserva.addActionListener(this);
        cancelar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
     
     
}
