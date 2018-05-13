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
    private JLabel text= new JLabel();
    private JLabel text1= new JLabel();
    private JComboBox listado = new JComboBox();
    private JButton consulta = new JButton();
    private JTextField buscarConCedula =new JTextField("");
    private JButton reserva = new JButton("Reservar");
    
    public Ventana(){
        setLayout(null);
        
    }
    
    public void consulta(Vuelos lista){
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
        Vuelo recorre=lista.getListadoVuelos();
        while(recorre!=null){
            if(recorre.getFecha().get(Calendar.DAY_OF_MONTH)>=fecha.get(Calendar.DAY_OF_MONTH))
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
        consulta.setVisible(true);
        reserva.setVisible(true);
        this.setVisible(true);
        //action
        buscarConCedula.addActionListener(this);
        consulta.addActionListener(this);
        reserva.addActionListener(this);
    }
    
    
    
    
            
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        if(e.getSource()==reserva){
            TechFly.getListaReservas().reserva(buscarConCedula.getText(),listado.getSelectedItem().toString());
        }
        
        if(e.getSource()==consulta){
            if(buscarConCedula.getText().equals("")){
                TechFly.consulta();
            }
            else{
                TechFly.getListaVuelos().ConsultaReservas(TechFly.getListaReservas());
            }
        }
        
        if(e.getSource()==buscarConCedula){
            TechFly.getListaVuelos().ConsultaReservas(TechFly.getListaReservas());
        }
    }
    
}
