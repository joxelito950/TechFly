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
    private JLabel text1= new JLabel();
    private JComboBox listado = new JComboBox();
    private JButton consulta = new JButton();
    private JButton cerrar = new JButton();
    private JTextField cedula=new JTextField("");
    private JButton reserva= new JButton();

    public Principal(){
        this.setLayout(null);
    }
    
    public void consulta(Vuelos lista){
        //setBounds
        this.setBounds(100, 200, 250, 200);
        text.setBounds(10,5,200,22);
        listado.setBounds(10, 25, 220, 22);
        text1.setBounds(10,55,220,22);
        cedula.setBounds(10, 75, 100, 22);
        consulta.setBounds(15, 110, 89,22);
        reserva.setBounds(105, 110, 89, 22);
        cerrar.setBounds(150,110,89,22);
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
        text1.setText("Consulte sus reservas o reserve un vuelo");
        cedula.setText("");
        consulta.setText("Consultar");
        reserva.setText("Reservar");
        cerrar.setText("Cerrar");
        //addThis
        this.add(text);
        this.add(listado);
        this.add(text1);
        this.add(cedula);
        this.add(consulta);
        this.add(reserva);
        this.add(cerrar);
        //changeVisible
        text.setVisible(true);
        listado.setVisible(true);
        text1.setVisible(true);
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
          
    @Override
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        if(e.getSource()==reserva){
            if(cedula.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Debe ingresar una cedula");
                this.dispose();
                TechFly.consultarVuelos();
            }
            else{
                this.dispose();
                TechFly.reservar(cedula.getText(), TechFly.getListaVuelos().buscarVuelo(listado.getSelectedItem().toString()));
            }
        }
        
        if(e.getSource()==consulta){
            if(cedula.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Debe ingresar una cedula");
                this.dispose();
                TechFly.consultarVuelos();
            }
            else{
                TechFly.consultarReservas(cedula.getText());
                this.dispose();
            }
        }
        if(e.getSource()==cerrar)
            this.dispose();
    }   
}
