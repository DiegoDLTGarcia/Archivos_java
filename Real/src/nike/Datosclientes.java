/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nike;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author 
 */
public class Datosclientes extends JPanel {


     private JTextField tfnombre_trabajador,tfformapago,tfarticulos;
      private JComboBox cbarticulos,cbformadepago;
    
public Datosclientes(){
   
    
    //JLabel lblid_jugador = new JLabel("numero de cliente");
            //lblid_jugador.setForeground(Color.BLACK);
            //lblid_jugador.setHorizontalAlignment(JLabel.CENTER);
            
    //JLabel lblnombre_jugador = new JLabel("Nombre del cliente");
           // lblnombre_jugador.setForeground(Color.BLACK);
            //lblnombre_jugador.setHorizontalAlignment(JLabel.CENTER);
           
            
    JLabel lblformapago = new JLabel("forma de pago");
            lblformapago.setForeground(Color.blue);
            lblformapago.setHorizontalAlignment(JLabel.CENTER);
            
    JLabel lblarticulos = new JLabel("articulos");
            lblarticulos.setForeground(Color.blue);
            lblarticulos.setHorizontalAlignment(JLabel.CENTER);         
     
            
      JLabel lblfpago = new JLabel("Su forma de pago fue");
            lblfpago.setForeground(Color.blue);
            lblfpago.setHorizontalAlignment(JLabel.CENTER);
    
            
      JLabel lblarti = new JLabel("Su compra ");
            lblarti.setForeground(Color.blue);
            lblarti.setHorizontalAlignment(JLabel.CENTER);      
      
            
            
            
            //tfid_trabajador = new JTextField();
            tfnombre_trabajador = new JTextField();
            
            
            
            cbformadepago = new JComboBox();
            cbformadepago.addItem("Efectivo");
            cbformadepago.addItem("Targeta de Credito");
            cbformadepago.addItem("Targeta de Debito");
            
            
            cbarticulos = new JComboBox();
            cbarticulos.addItem("Tachones");
            cbarticulos.addItem("playera");
            cbarticulos.addItem("tennis");
            cbarticulos.addItem("Balones");
            cbarticulos.addItem("raquetas");
            cbarticulos.addItem("tablas");
            cbarticulos.addItem("chamarras");
            cbarticulos.setSelectedItem("medias");
            
            
            
            
        tfformapago=new JTextField();
        tfformapago.setEditable(false);
        
        tfarticulos=new JTextField();
        tfarticulos.setEditable(false);
        
            
        
        setLayout(new GridLayout(6,2,2,2));
            //add(lblid_jugador);
            //add(lblnombre_jugador);
            add(lblformapago);
            add(lblarticulos);
            
            
            //add(tfnombre_trabajador);
            add(tfformapago);
            add(tfarticulos);
            add(cbformadepago);
            add(cbarticulos);
        
            
           //add(lblnombre_jugador );
            add(lblfpago);
            add(lblarti);
            
            //add(tfnombre_trabajador);
            add(tfformapago);
            add(tfarticulos);
}

     public void setLimpiar(){
        
        tfnombre_trabajador.setText("");
        
        tfformapago.setText("");
        tfarticulos.setText("");
        
        
        cbformadepago.setSelectedItem("");
        cbarticulos.setSelectedItem("");
        
    }
    public void setDatosEmpleado(Empleado jug){
    
    
    //tfformapago.setText(jug.getfpago()+"");
    //tfarticulos.setText(jug.getarticulo()+"10000");
    
    

    }
    public Empleado getDatosJugador(){
    Empleado jug = new Empleado();

  
    //jug.setNombreJugador(tfnombre_trabajador.getText());
        jug.setNombreJugador(tfnombre_trabajador.getText());
        jug.setfpago((String)(cbformadepago.getSelectedItem()));
        jug.setarticulo(Double.parseDouble((String)(cbarticulos.getSelectedItem())));
    
    //jug.setformadepago();
    
    
    if(tfformapago.getText().equals(""))
        jug.setfpago("");
        
    else
        jug.setfpago((tfformapago.getText()));
    
    
    if (tfarticulos.getText().equals(""))
        jug.setSueldo(0.0);

    else
        jug.setarticulo(Double.parseDouble(tfarticulos.getText()));
    
    
       

    return jug;
}

    public void setDatosJugador(Empleado emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void activar(){
    tfformapago.setEnabled(true);
    tfnombre_trabajador.setEnabled(true);
    tfarticulos.setEnabled(true);
    

        
    }

      

}
    

