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
public class MisReservas extends JFrame implements ActionListener{
    
    private JLabel text= new JLabel();
    private JLabel text1= new JLabel();
    private JComboBox listado = new JComboBox();
    private JButton consulta = new JButton();
    private JButton volver = new JButton();
    private JTextField buscarConCedula =new JTextField("");
    
    public MisReservas(){
        this.setLayout(null);
    }
    
    public void ConsultaReservas(Reservas lista){
        inicializar(lista);
        //setInformation
        text1.setText("Ingrese otro documento");
        buscarConCedula.setText("");
        consulta.setText("Consultar");
        volver.setText("Volver");
        //addThis
        this.add(text);
        this.add(text1);
        this.add(buscarConCedula);
        this.add(consulta);
        this.add(volver);
        //changeVisible
        text.setVisible(true);
        text1.setVisible(true);
        buscarConCedula.setVisible(true);
        consulta.setVisible(true);
        volver.setVisible(true);
        this.setVisible(true);
        //action
        consulta.addActionListener(this);
        volver.addActionListener(this);
    }    
         
    @Override
    public void actionPerformed(ActionEvent e) {     
        if(e.getSource()==consulta){
            if(buscarConCedula.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Debe ingresar una cedula", "Error", 3);
            }
            else{
                this.dispose();
                TechFly.consultarReservas(buscarConCedula.getText());
            }            
        }
        if(e.getSource()==volver){
                TechFly.consultarVuelos();
                this.dispose();
            }
    }
    
    private void inicializar(Reservas lista){
        listado.removeAll();
        Reserva recorreR=lista.getInicio();
        if(recorreR==null){
            //setBounds
            this.setBounds(200,300,250,150);
            text.setBounds(20,5,200,22);
            text1.setBounds(20,25,200,22);
            buscarConCedula.setBounds(20, 50, 100, 22);
            consulta.setBounds(25, 75, 89,22);
            volver.setBounds(125,75,89,22);
            //setText
            this.setTitle("Sin Reservas");
            text.setText("No se encontraron Reservas");
            listado.setVisible(false);
        }
        else{
            //setBounds
            this.setBounds(200,300,240,200);
            text.setBounds(10,5,200,22);
            listado.setBounds(10, 25, 200, 22);
            text1.setBounds(10,50,220,22);
            buscarConCedula.setBounds(10, 70, 100, 22);
            consulta.setBounds(15, 100, 89,22);
            volver.setBounds(125,100,89,22);
            //setText
            this.setTitle("Reservas para "+recorreR.getIdCliente());
            text.setText("Sus Vuelos Reservados");
            Calendar fecha = Calendar.getInstance();
            while(recorreR!=null){
                if(recorreR.getVuelo().getFecha().get(Calendar.DAY_OF_MONTH)>=fecha.get(Calendar.DAY_OF_MONTH)){
                    Vuelo aux=recorreR.getVuelo();
                    listado.addItem(aux.datosVuelo()+", Reservado "+aux.getFecha());
                }
            recorreR = recorreR.getSigReserva();
            }
            this.add(listado);
            listado.setVisible(true);
        }
    }
}
