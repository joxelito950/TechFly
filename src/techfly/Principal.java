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
    

public class Principal extends JFrame implements ActionListener{
    private JLabel text= new JLabel();
    private JComboBox listado = new JComboBox();
    private JButton consulta = new JButton();
    private JButton cerrar = new JButton();
    private JTextField cedula=new JTextField("");
    private JButton reserva= new JButton();
    private JButton volver = new JButton();

    public Principal(){
        this.setLayout(null);
    }
    
    public void consulta(Vuelos lista){
        //setBounds
        this.setBounds(300, 350, 330, 180);
        text.setBounds(10,5,200,22);
        listado.setBounds(10, 25, 280, 22);
        cedula.setBounds(10, 55, 100, 22);
        consulta.setBounds(10, 100, 89,22);
        reserva.setBounds(100, 100, 89, 22);
        cerrar.setBounds(200,100,80,22);
        //setInformation
        this.setTitle("Vuelos");
        text.setText("Vuelos Disponibles");
        Calendar fecha = Calendar.getInstance();
        Vuelo recorre=lista.getInicio();
        while(recorre!=null){
            if(recorre.getFecha().get(Calendar.DAY_OF_MONTH)>=fecha.get(Calendar.DAY_OF_MONTH))
                listado.addItem(recorre.datosVuelo());
            recorre = recorre.getProximo();
        }
        cedula.setText("Cedula");
        consulta.setText("Consultar");
        reserva.setText("Reservar");
        cerrar.setText("Cerrar");
        //addThis
        this.add(text);
        this.add(listado);
        this.add(cedula);
        this.add(consulta);
        this.add(reserva);
        this.add(cerrar);
        //changeVisible
        text.setVisible(true);
        listado.setVisible(true);
        cedula.setVisible(true);
        consulta.setVisible(true);
        reserva.setVisible(true);
        cerrar.setVisible(true);
        this.setVisible(true);
        //action
        cedula.addActionListener(this);
        consulta.addActionListener(this);
        reserva.addActionListener(this);
        cerrar.addActionListener(this);
    }
    public void error(){
        this.dispose();
        this.setBounds(300, 360, 200, 100);
        text.setBounds(10,5,200,22);
        volver.setBounds(10,25,89,22);
        this.setTitle("Error");
        text.setText("Debe ingresar una cedula");
        volver.setText("Volver");
        this.add(text);
        this.add(volver);
        text.setVisible(true);
        volver.setVisible(true);
        this.setVisible(true);
        volver.addActionListener(this);
    }
          
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        if(e.getSource()==reserva){
            if(cedula.getText().equals("")||cedula.getText().equals("Cedula")){
                error();
            }
            else{
                this.dispose();
                TechFly.reservar(cedula.getText(), TechFly.getListaVuelos().buscarVuelo(listado.getSelectedItem().toString()));
            }
        }
        
        if(e.getSource()==consulta){
            if(cedula.getText().equals("")||cedula.getText().equals("Cedula")){
                this.dispose();
                error();
            }
            else{
                TechFly.consultarReservas(cedula.getText());
                this.dispose();
            }
        }
        if(e.getSource()==volver)
            TechFly.consultarVuelos();
        if(e.getSource()==cerrar)
            this.dispose();
    }   
}
