
package nike;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;


public class Datos extends JPanel {
     private JTextField tfid_trabajador,tfnombre_trabajador,tfsueldo_trabajador,tfrebaja,tfcaridad,tftotal,tfformapago,tfarticulos;
      private JComboBox cbhorastrabajadas,cbpagoporhora,cbarticulos,cbformadepago;
   
    
public Datos(){
   
    JLabel lblid_jugador = new JLabel("numero de control");
            lblid_jugador.setForeground(Color.blue);
            lblid_jugador.setHorizontalAlignment(JLabel.CENTER);
            
    JLabel lblnombre_jugador = new JLabel("Nombre");
            lblnombre_jugador.setForeground(Color.blue);
            lblnombre_jugador.setHorizontalAlignment(JLabel.CENTER);
            
    JLabel lblhorasjugadas = new JLabel("Horas");
            lblhorasjugadas.setForeground(Color.blue);
            lblhorasjugadas.setHorizontalAlignment(JLabel.CENTER);
            
    JLabel lblformapago = new JLabel("forma de pago");
            lblformapago.setForeground(Color.blue);
            lblformapago.setHorizontalAlignment(JLabel.CENTER);
            
    JLabel lblarticulos = new JLabel("articulos");
            lblarticulos.setForeground(Color.blue);
            lblarticulos.setHorizontalAlignment(JLabel.CENTER);         
            
    JLabel lblpagoporhora = new JLabel("Pago por hora");
            lblpagoporhora.setForeground(Color.blue);
            lblpagoporhora.setHorizontalAlignment(JLabel.CENTER);
            
     JLabel lblSueldo_jugador = new JLabel("Sueldo acordado");
            lblSueldo_jugador.setForeground(Color.blue);
            lblSueldo_jugador.setHorizontalAlignment(JLabel.CENTER);
            
     JLabel lblrebaja = new JLabel("rebaja");
            lblrebaja.setForeground(Color.blue);
            lblrebaja.setHorizontalAlignment(JLabel.CENTER);
            
      JLabel lblcaridad = new JLabel("caridad");
            lblcaridad.setForeground(Color.blue);
            lblcaridad.setHorizontalAlignment(JLabel.CENTER);
           
      JLabel lbltotal = new JLabel("Total");
            lbltotal.setForeground(Color.blue);
            lbltotal.setHorizontalAlignment(JLabel.CENTER);
            
      
            
            
            
            tfid_trabajador = new JTextField();
            tfnombre_trabajador = new JTextField();
            
            
            
            
            cbhorastrabajadas = new JComboBox();
            cbhorastrabajadas.addItem("50");
            cbhorastrabajadas.addItem("100");
            cbhorastrabajadas.addItem("120");
            cbhorastrabajadas.addItem("150");
            cbhorastrabajadas.addItem("200");
            cbhorastrabajadas.setSelectedItem("100");
            
            cbpagoporhora = new JComboBox();
            cbpagoporhora.addItem("60.5");
            cbpagoporhora.addItem("120.5");
            cbpagoporhora.addItem("220.6");
            cbpagoporhora.addItem("350.4");
            cbpagoporhora.addItem("469.5");
            cbpagoporhora.setSelectedItem("599.3");
            
       
            
        tfsueldo_trabajador=new JTextField();
        tfsueldo_trabajador.setEditable(false);
        
        tfrebaja=new JTextField();
        tfrebaja.setEditable(false);
        
        tfcaridad=new JTextField();
        tfcaridad.setEditable(false);
        
        tftotal=new JTextField();
        tftotal.setEditable(false);
        setLayout(new GridLayout(5,5,6,3));
            add(lblid_jugador);
            add(lblnombre_jugador);
            add(lblhorasjugadas);
            add(lblpagoporhora);
            
            
            add(tfid_trabajador);
            add(tfnombre_trabajador);
            
            add(cbhorastrabajadas);
            add(cbpagoporhora);
            //add(cbformadepago);
            //add(cbarticulos);
            
            
            
            add(lblSueldo_jugador);
            add(lblrebaja);
            add(lblcaridad);
            add(lbltotal);
            
            
            add(tfsueldo_trabajador);
            add(tfrebaja);
            add(tfcaridad);
            add(tftotal);
            
}

     public void setLimpiar(){
        tfid_trabajador.setText("");
        tfnombre_trabajador.setText("");
        tfsueldo_trabajador.setText("");
        tfrebaja.setText("");
        tfcaridad.setText("");
        tftotal.setText("");
        
        
        cbhorastrabajadas.setSelectedItem("100");
        cbpagoporhora.setSelectedItem("800");
        
        
    }
     public void Activar(){
        tfnombre_trabajador.setEditable(true);
    }
     public void setDatosEmpleado(Empleado jug){
    
    tfsueldo_trabajador.setText(jug.getSueldo()+"");
    tfrebaja.setText(jug.getDescontado()+"");
    tfcaridad.setText(jug.getSeguro()+"");
    tftotal.setText(jug.getTotal()+"");
    
    
    

    }
    public Empleado getDatosJugador(){
    Empleado jug = new Empleado();

    jug.setId_jugador(tfid_trabajador.getText());
    jug.setNombreJugador(tfnombre_trabajador.getText());
    jug.setHorasTrabajadas(Integer.parseInt((String)(cbhorastrabajadas.getSelectedItem())));
    jug.setPago(Double.parseDouble((String)(cbpagoporhora.getSelectedItem())));
    
    
    if (tfsueldo_trabajador.getText().equals(""))
        jug.setSueldo(0.0);

    else
        jug.setSueldo(Double.parseDouble(tfsueldo_trabajador.getText()));

    if(tfrebaja.getText().equals(""))
        jug.setRebaja(0.0);

    else
        jug.setRebaja(Double.parseDouble(tfrebaja.getText()));

    if(tfcaridad.getText().equals(""))
        jug.setCaridad(0.0);

    else
        jug.setCaridad(Double.parseDouble(tfcaridad.getText()));

    if(tftotal.getText().equals(""))
        jug.setTotal(0.0);

    else
        jug.setTotal(Double.parseDouble(tftotal.getText()));

    return jug;
}
    public String getTfid_jugador(){
     return tfid_trabajador.getText();
 }   

      

}
    

