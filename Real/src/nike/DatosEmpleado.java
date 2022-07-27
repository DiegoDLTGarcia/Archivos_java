
package nike;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.*;


public class DatosEmpleado extends JPanel {
     private JTextField tfid_jugador,tfnombre_jugador,tfsueldo_jugador,tfrebaja,tfcaridad,tftotal;
      private JComboBox cbhorasjugadas,cbpagoporhora;
      
public DatosEmpleado(){
    JLabel lblid_jugador = new JLabel("numero de control");
            lblid_jugador.setForeground(Color.blue);
            lblid_jugador.setHorizontalAlignment(JLabel.CENTER);
            
    JLabel lblnombre_jugador = new JLabel("Nombre");
            lblnombre_jugador.setForeground(Color.blue);
            lblnombre_jugador.setHorizontalAlignment(JLabel.CENTER);
            
    JLabel lblhorasjugadas = new JLabel("Horas");
            lblhorasjugadas.setForeground(Color.blue);
            lblhorasjugadas.setHorizontalAlignment(JLabel.CENTER);
            
    JLabel lblpagoporhora = new JLabel("Pago por hora");
            lblpagoporhora.setForeground(Color.blue);
            lblpagoporhora.setHorizontalAlignment(JLabel.CENTER);
            
     JLabel lblSueldo_jugador = new JLabel("Sueldo ");
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
            tfid_jugador = new JTextField();
            tfnombre_jugador = new JTextField();
            
            cbhorasjugadas = new JComboBox();
            cbhorasjugadas.addItem("50");
            cbhorasjugadas.addItem("100");
            cbhorasjugadas.addItem("120");
            cbhorasjugadas.addItem("150");
            cbhorasjugadas.addItem("200");
            cbhorasjugadas.setSelectedItem("100");
            
            cbpagoporhora = new JComboBox();
            cbpagoporhora.addItem("50.6");
            cbpagoporhora.addItem("120.5");
            cbpagoporhora.addItem("230");
            cbpagoporhora.addItem("440");
            cbpagoporhora.addItem("550");
            cbpagoporhora.setSelectedItem("800");
            
        tfsueldo_jugador=new JTextField();
        tfsueldo_jugador.setEditable(false);
        
        tfrebaja=new JTextField();
        tfrebaja.setEditable(false);
        
        tfcaridad=new JTextField();
        tfcaridad.setEditable(false);
        
        tftotal=new JTextField();
        tftotal.setEditable(false);
         setLayout(new GridLayout(4,4,6,3));
         add(lblid_jugador);
            add(lblnombre_jugador);
            add(lblhorasjugadas);
            add(lblpagoporhora);
            
            add(tfid_jugador);
            add(tfnombre_jugador);
            add(cbhorasjugadas);
            add(cbpagoporhora);
            
            add(lblSueldo_jugador);
            add(lblrebaja);
            add(lblcaridad);
            add(lbltotal);
            
            add(tfsueldo_jugador);
            add(tfrebaja);
            add(tfcaridad);
            add(tftotal);
}
 public void setDatosJugador(Empleado jug){
        tfnombre_jugador.setText(jug.getNombre());
        cbhorasjugadas.setSelectedItem(jug.getHoras()+"");
        cbpagoporhora.setSelectedItem(jug.getPago()+"");
        tfsueldo_jugador.setText(jug.getSueldo()+"");
        tfrebaja.setText(jug.getDescontado()+"");
        tfcaridad.setText(jug.getSeguro()+"");
        tftotal.setText(jug.getTotal()+"");
    }
 public Empleado getDatosJugador(){
    
        Empleado jug = new Empleado();
        
        jug.setId_jugador(tfid_jugador.getText());
        jug.setNombreJugador(tfnombre_jugador.getText());
        jug.setHorasTrabajadas(Integer.parseInt((String)(cbhorasjugadas.getSelectedItem())));
        jug.setPago(Double.parseDouble((String)(cbpagoporhora.getSelectedItem())));
        
        if(tfsueldo_jugador.getText().equals(""))
            jug.setSueldo(0.0);
        else
            jug.setSueldo(Double.parseDouble(tfsueldo_jugador.getText()));
        
       if (tfrebaja.getText().equals(""))
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
     return tfid_jugador.getText();
 }   
  public void setLimpiar(){
    tfid_jugador.setText("");
    tfnombre_jugador.setText("");
    tfsueldo_jugador.setText("");
    tfrebaja.setText("");
    tfcaridad.setText("");
    tftotal.setText("");
    cbhorasjugadas.setSelectedItem("150");
    cbpagoporhora.setSelectedItem("700");
}

public void setDesactivar(){
    tfid_jugador.setEnabled(false);
    tfnombre_jugador.setEnabled(false);
    tfsueldo_jugador.setEnabled(false);
    tfrebaja.setEnabled(false);
    tfcaridad.setEnabled(false);
    tftotal.setEnabled(false);
    cbhorasjugadas.setEditable(false);
    cbpagoporhora.setEditable(false);
}
public void setActivar(){
    tfid_jugador.setEnabled(true);
    tfnombre_jugador.setEnabled(true);
    tfsueldo_jugador.setEnabled(true);
    tfrebaja.setEnabled(true);
    tfcaridad.setEnabled(true);
    tftotal.setEnabled(true);
    cbhorasjugadas.setEditable(true);
    cbpagoporhora.setEditable(true);
}
    
}
