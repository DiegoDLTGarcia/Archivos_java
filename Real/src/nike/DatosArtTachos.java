
package nike;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;


public class DatosArtTachos extends JPanel {
     private JTextField tfnombre_trabajador,tfsueldo_trabajador,tfrebaja,tfcaridad,tftotal;
      private JComboBox cbnumdearticulos,cbcostodechamarra,cbchamarras;
   
    
public DatosArtTachos(){
   
            
    JLabel lblhorasjugadas = new JLabel("Precios");
            lblhorasjugadas.setForeground(Color.blue);
            lblhorasjugadas.setHorizontalAlignment(JLabel.CENTER);
            
                
       JLabel lblpagoporhora = new JLabel("Estilos");
            lblpagoporhora.setForeground(Color.blue);
            lblpagoporhora.setHorizontalAlignment(JLabel.CENTER);
            
     JLabel lblSueldo_jugador = new JLabel("Sueldo acordado");
            lblSueldo_jugador.setForeground(Color.blue);
            lblSueldo_jugador.setHorizontalAlignment(JLabel.CENTER);
            
     JLabel lblrebaja = new JLabel("I.V.A");
            lblrebaja.setForeground(Color.blue);
            lblrebaja.setHorizontalAlignment(JLabel.CENTER);
            
      JLabel lblcaridad = new JLabel("Ahorro");
            lblcaridad.setForeground(Color.blue);
            lblcaridad.setHorizontalAlignment(JLabel.CENTER);
           
      JLabel lbltotal = new JLabel("Total");
            lbltotal.setForeground(Color.blue);
            lbltotal.setHorizontalAlignment(JLabel.CENTER);
            
                                
         cbchamarras = new JComboBox();
            cbchamarras.addItem("chamarra real madrid");
              cbchamarras.addItem("chamarra nike");
              cbchamarras.addItem("chamarra adidas");
              cbchamarras.addItem("chamarra puma");
              cbchamarras.addItem("chamarra umbro");
              cbchamarras.addItem("chamarra brazil");
              cbchamarras.addItem("chamarra de justin bieber");
              cbchamarras.addItem("chamarra barca");
              cbchamarras.addItem("chamarra cruz azul");
              cbchamarras.addItem("chamarra told");
              cbchamarras.addItem("chamarra juma");
              cbchamarras.addItem("chamarra pirma");
              cbchamarras.addItem("chamarra zosk");
              cbchamarras.addItem("chamarra adio");
              cbchamarras.addItem("chamarra juventus");
              cbchamarras.addItem("chamarra de la seleccion");
              cbchamarras.addItem("chamarra españa");
            
              cbchamarras.setSelectedItem("chamarra cr7");
            
            cbcostodechamarra = new JComboBox();
            cbcostodechamarra.addItem("700");
            cbcostodechamarra.addItem("1500");
            cbcostodechamarra.addItem("200");
            cbcostodechamarra.addItem("1000");
            cbcostodechamarra.addItem("300");
            cbcostodechamarra.addItem("250");
            cbcostodechamarra.addItem("350");
            cbcostodechamarra.addItem("850");
            cbcostodechamarra.setSelectedItem("100");               
     
               
            cbnumdearticulos = new JComboBox();
            cbnumdearticulos.addItem("1");
            cbnumdearticulos.addItem("2");
            cbnumdearticulos.addItem("3");
            cbnumdearticulos.addItem("4");
            cbnumdearticulos.addItem("5");
            cbnumdearticulos.addItem("6");
            cbnumdearticulos.addItem("7");
            cbnumdearticulos.addItem("8");
            cbnumdearticulos.addItem("9");
            cbnumdearticulos.addItem("10");
            cbnumdearticulos.addItem("11");
            cbnumdearticulos.addItem("12");
            cbnumdearticulos.addItem("13");
            cbnumdearticulos.addItem("14");
            cbnumdearticulos.addItem("15");
            cbnumdearticulos.addItem("16");
            cbnumdearticulos.addItem("17");
            cbnumdearticulos.addItem("18");
            cbnumdearticulos.addItem("19");
            cbnumdearticulos.setSelectedItem("10");
            
            cbcostodechamarra = new JComboBox();
            cbcostodechamarra.addItem("700");
            cbcostodechamarra.addItem("1500");
            cbcostodechamarra.addItem("200");
            cbcostodechamarra.addItem("1000");
            cbcostodechamarra.addItem("300");
            cbcostodechamarra.addItem("250");
            cbcostodechamarra.addItem("350");
            cbcostodechamarra.addItem("850");
            cbcostodechamarra.setSelectedItem("100");
            
       
        
            
        tfsueldo_trabajador=new JTextField();
        tfsueldo_trabajador.setEditable(false);
        
        tfrebaja=new JTextField();
        tfrebaja.setEditable(false);
        
        tfcaridad=new JTextField();
        tfcaridad.setEditable(false);
        
        tftotal=new JTextField();
        tftotal.setEditable(false);
        setLayout(new GridLayout(4,3,3,3));
            
            
            add(lblhorasjugadas);
            add(lblpagoporhora);
          
            
            
       
            add(cbnumdearticulos);
            add(cbcostodechamarra);
            add(cbchamarras);
            
            
            
            add(lblrebaja);
            add(lblcaridad);
            add(lbltotal);
           
            
            add(tfsueldo_trabajador);
            add(tfrebaja);
            add(tfcaridad);
            add(tftotal);
            
}

     public void setLimpiar(){
        
        tfsueldo_trabajador.setText("");
        tfrebaja.setText("");
        tfcaridad.setText("");
        tftotal.setText("");
        
        
        cbnumdearticulos.setSelectedItem("100");
        cbcostodechamarra.setSelectedItem("800");
        
    }
     public void Activar(){
        tfnombre_trabajador.setEditable(true);
    }
     public void setDatosEmpleado(Empleado jug){
    
    tfsueldo_trabajador.setText(jug.getSueldo()+"");
    tfrebaja.setText(jug.getDescontado()+"");
    tfcaridad.setText(jug.getSeguro()+"");
    tftotal.setText(jug.getTotal()+"");
    
    //tfarticulos.setText(jug.getArticulo()+"");
    
    

    }
    public Empleado getDatosJugador(){
    Empleado jug = new Empleado();

    
    //jug.setNombreJugador(tfnombre_trabajador.getText());
    jug.setHorasTrabajadas(Integer.parseInt((String)(cbnumdearticulos.getSelectedItem())));
    jug.setPago(Double.parseDouble((String)(cbcostodechamarra.getSelectedItem())));
    //jug.setformadepago();
    
    
    
    
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
    
    void setDatosJugador(Empleado emp) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

      

}
    

