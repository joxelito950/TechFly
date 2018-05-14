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
    private String ced;
    private Vuelo vuelo;
    
    public ConfirmarReserva(){
        this.setLayout(null);
    }
    
    public void reserva(String cedula,Vuelo vuelo){
        if(puedeReservar(cedula)){
            ced=cedula;
            this.vuelo=vuelo;
            confirmarReserva();
        }
        else{
            JOptionPane.showMessageDialog(null, "Usted ya realizo una reserva el dia de hoy", "Lo Sentimos", JOptionPane.INFORMATION_MESSAGE);
            TechFly.consultarVuelos();
        }
    }
    
    public void confirmarReserva(){
        //setBounds
        
        this.setBounds(100, 300, 400, 150);
        text.setBounds(10,5,300,22);
        text1.setBounds(10, 20, 350, 22);
        mayorEdad.setBounds(30,40,400,22);
        cancelar.setBounds(25, 80, 90,22);
        reserva.setBounds(145, 80, 90, 22);
        //setInformation
        this.setTitle("Reserva para " + ced);
        text.setText("Costo Reserva: "+ costoVuelo(vuelo));
        text1.setText("Vuelo: "+vuelo.datosVuelo());
        mayorEdad.setText("Soy Mayor de Edad");
        cancelar.setText("Volver");
        reserva.setText("reservar");
        //addThis
        this.add(text);
        this.add(text1);
        this.add(mayorEdad);
        this.add(cancelar);
        this.add(reserva);
        //changeVisible
        text.setVisible(true);
        text1.setVisible(true);
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
    
    public float costoVuelo(Vuelo vuelo){
        float costo;
        Calendar fecha=vuelo.getFecha();
        if(fecha.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || fecha.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
            if(fecha.get(Calendar.AM_PM)==Calendar.AM){
                costo=559000;
            }
            else{
                costo=499000;
            }
        }
        else{
            if(fecha.get(Calendar.AM_PM)==Calendar.AM){
                costo=429000;
            }
            else{
                costo=399000;
            }
        }
        return costo;
    }
    
    private boolean puedeReservar(String cedula){
        boolean puede=false;
        Calendar hoy=Calendar.getInstance();
        Reserva ultima=TechFly.getListaReservas().buscarUltimaReserva(cedula);
        if(ultima==null)
            puede=true;
        if(ultima!=null && ultima.getIdCliente().equals(cedula) && ultima.getTime().get(Calendar.DAY_OF_MONTH)!=hoy.get(Calendar.DAY_OF_MONTH))
            puede=true;
        return puede;
    }
    
      @Override
    public void actionPerformed(ActionEvent e) {     
        if(e.getSource()==mayorEdad){
            if(mayorEdad.isSelected()==true)
                reserva.setEnabled(true);
            else
                reserva.setEnabled(false);
        }
        if(e.getSource()==cancelar){
            this.dispose();
            TechFly.consultarVuelos();
        }
        if(e.getSource()==reserva){
            TechFly.getListaReservas().agregarReserva(vuelo, ced);
            JOptionPane.showMessageDialog(this, "Reserva Confirmada con Exito", "Vuelo Reservado", JOptionPane.PLAIN_MESSAGE);
            this.dispose();
            TechFly.consultarVuelos();
        }
    }
}
