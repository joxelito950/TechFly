/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techfly;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author jose-
 */
public class ConfirmarReserva extends JFrame implements ActionListener{
    private JLabel text= new JLabel();
    private JLabel text1= new JLabel();
    private JCheckBox mayorEdad = new JCheckBox();
    private JButton cancelar = new JButton();
    private JButton reserva = new JButton();
    
    public ConfirmarReserva(){
        this.setLayout(null);
    }
    
    public void reserva(String cedula, Vuelo vuelo){
        //setBounds
        this.setBounds(100, 300, 600, 150);
        text.setBounds(10,5,500,22);
        mayorEdad.setBounds(30,30,400,22);
        cancelar.setBounds(25, 90, 90,22);
        reserva.setBounds(145, 90, 90, 22);
        //setInformation
        this.setTitle("Reserva para " + cedula);
        text.setText(vuelo.datosVuelo());
        mayorEdad.setText("Soy Mayor de Edad");
        cancelar.setText("Volver");
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
    }
    
      @Override
    public void actionPerformed(ActionEvent e) {     
        if(e.getSource()==mayorEdad){
            reserva.setEnabled(true);
        }
        else
            reserva.setEnabled(false);
        if(e.getSource()==cancelar){
            this.dispose();
            TechFly.consultarVuelos();
        }
        if(e.getSource()==reserva)
            this.dispose();
    }
}
