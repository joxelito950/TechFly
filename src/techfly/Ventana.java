/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techfly;

import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;

/**
 *
 * @author jose-
 */
    

public class Ventana extends JFrame implements ActionListener{
    JLabel text= new JLabel();
    JLabel text1= new JLabel();
    private JComboBox listado = new JComboBox();
    private JButton consulta = new JButton();
    private JTextField buscarConCedula =new JTextField("");
    private JButton reserva = new JButton("Reservar");
    private JCheckBox mayorEdad = new JCheckBox();
    static Vuelos listaVuelos = new Vuelos();
    static Reservas listaReservas = new Reservas();
    public Ventana(){
        setLayout(null);
        
    }
    
    public void consulta(){
        //setBounds
        this.setBounds(100, 200, 240, 180);
        text.setBounds(10,5,200,22);
        listado.setBounds(10, 25, 200, 22);
        text1.setBounds(10,55,220,22);
        buscarConCedula.setBounds(10, 75, 100, 22);
        consulta.setBounds(15, 105, 90,22);
        reserva.setBounds(115, 105, 90, 22);
        //setInformation
        this.setTitle("Vuelos");
        text.setText("Vuelos Disponibles");
        Calendar fecha = Calendar.getInstance();
        Vuelo recorre=listaVuelos.getListadoVuelos();
        while(recorre!=null){
            if(recorre.getFecha().get(Calendar.DAY_OF_MONTH)>fecha.get(Calendar.DAY_OF_MONTH))
                listado.addItem(recorre.datosVuelo());
            recorre = recorre.getProximo();
        }
        text1.setText("Consulte sus reservas con su Cedula");
        buscarConCedula.setText("");
        consulta.setText("Consultar");
        //addThis
        this.add(text);
        this.add(listado);
        this.add(text1);
        this.add(buscarConCedula);
        this.add(consulta);
        this.add(reserva);
        //changeVisible
        text.setVisible(true);
        listado.setVisible(true);
        text1.setVisible(true);
        buscarConCedula.setVisible(true);
        mayorEdad.setVisible(false);
        consulta.setVisible(true);
        reserva.setVisible(true);
        this.setVisible(true);
        //action
        buscarConCedula.addActionListener(this);
        consulta.addActionListener(this);
        reserva.addActionListener(this);
    }
    
    public void reserva(){
        //setBounds
        this.setBounds(100, 200, 300, 150);
        text.setBounds(10,5,200,22);
        mayorEdad.setBounds(20,20,190,22);
        consulta.setBounds(25, 90, 90,22);
        reserva.setBounds(145, 90, 90, 22);
        //setInformation
        this.setTitle("Reservas para "+buscarConCedula.getText());
//        text.setText(listado.getSelectedItem().toString());
        buscarConCedula.setText("");
        mayorEdad.setText("Soy Mayor de Edad");
        consulta.setText("Cancelar");
        //addThis
        this.add(text);
        this.add(mayorEdad);
        this.add(consulta);
        this.add(reserva);
        //changeVisible
        text.setVisible(true);
        listado.setVisible(false);
        text1.setVisible(false);
        buscarConCedula.setVisible(false);
        mayorEdad.setVisible(true);
        consulta.setVisible(true);
        reserva.setVisible(true);
        this.setVisible(true);
        //enable
        reserva.setEnabled(false);
        //acction
        mayorEdad.addActionListener(this);
        reserva.addActionListener(this);
        consulta.addActionListener(this);
    }
    
    public void ConsultaReservas(){
        //setBounds
        this.setBounds(100, 200, 240, 180);
        text.setBounds(10,5,200,22);
        listado.setBounds(10, 25, 200, 22);
        text1.setBounds(10,55,220,22);
        buscarConCedula.setBounds(10, 75, 100, 22);
        consulta.setBounds(55, 105, 100,22);
        //setInformation
        this.setTitle("Reservas "+buscarConCedula.getText());
        text.setText("Sus vuelos reservados");
        listado.removeAllItems();
        Calendar fecha = Calendar.getInstance();
        Vuelo recorre=listaVuelos.getListadoVuelos();
        while(recorre!=null){
            if(recorre.getId().equals(buscarConCedula.getText()) && recorre.getFecha().get(Calendar.DAY_OF_MONTH)>fecha.get(Calendar.DAY_OF_MONTH))
                listado.addItem(recorre.datosVuelo());
            recorre = recorre.getProximo();
        }
        text1.setText("Ingrese otro documento");
        buscarConCedula.setText("");
        consulta.setText("Consultar");
        //addThis
        this.add(text);
        this.add(listado);
        this.add(text1);
        this.add(buscarConCedula);
        this.add(consulta);
        //changeVisible
        text.setVisible(true);
        listado.setVisible(false);
        text1.setVisible(false);
        buscarConCedula.setVisible(false);
        mayorEdad.setVisible(false);
        consulta.setVisible(true);
        reserva.setVisible(false);
        this.setVisible(true);
        //action
        buscarConCedula.addActionListener(this);
        consulta.addActionListener(this);
    }    
            
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        if(e.getSource()==reserva){
            buscarConCedula.setText("");
            reserva();
        }
        
        if(e.getSource()==consulta){
            
            if(buscarConCedula.getText().equals("")){
                consulta();
            }
            else{
                ConsultaReservas();
            }
        }
        
        if(e.getSource()==buscarConCedula){
            ConsultaReservas();
        }
        
        if(e.getSource()==mayorEdad){
            if(mayorEdad.isSelected()==true)
                reserva.setEnabled(true);
            else
                reserva.setEnabled(false);
        }
    }
    
}
