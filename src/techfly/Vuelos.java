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
public class Vuelos extends JFrame implements ActionListener{
    private JLabel text= new JLabel();
    private JLabel text1= new JLabel();
    private JComboBox listado = new JComboBox();
    private JButton consulta = new JButton();
    private JTextField buscarConCedula =new JTextField("");
    
    private Vuelo listadoVuelos;
    public Vuelos(){
        listadoVuelos=null;
    }

    public Vuelo getListadoVuelos() {
        return listadoVuelos;
    }
    
    public void agregarVuelo(String id,String origen, String destino, Calendar fecha){
       Vuelo nuevo = new Vuelo(id, origen, destino, fecha);
       if(listadoVuelos==null)
           nuevo.setProximo(listadoVuelos);
       listadoVuelos=nuevo;
    }
    
    public void ConsultaReservas(Reservas lista){
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
        Vuelo recorre=listadoVuelos;
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
        consulta.setVisible(true);
        this.setVisible(true);
        //action
        buscarConCedula.addActionListener(this);
        consulta.addActionListener(this);
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {     
        if(e.getSource()==consulta){
            
            if(buscarConCedula.getText().equals("")){
                TechFly.consulta();
            }
            else{
                ConsultaReservas(TechFly.getListaReservas());
            }
        }
        
        if(e.getSource()==buscarConCedula){
            ConsultaReservas(TechFly.getListaReservas());
        }
    }
}



