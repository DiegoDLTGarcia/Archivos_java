
package nike;
import javax.swing.*;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;



public class Botones extends JPanel implements ActionListener {
    
    private JButton bCalcular,bNuevo,bGuardar,bSalir;
    private InterfazNikeStore tot;
    
  //  private AccesoDatosNominaTxt adntxt;
     public Botones(InterfazNikeStore tot){
        this.tot = tot;
        
        bCalcular = new JButton("Calcular");
        bNuevo = new JButton("Nuevo");
        bGuardar = new JButton("Guardar");
        
        bSalir = new JButton("Salir");
        
        bCalcular.addActionListener(this);
        bNuevo.addActionListener(this);
        bGuardar.addActionListener(this);
       
        bSalir.addActionListener(this);
        
        setLayout(new FlowLayout());
        
        add(bCalcular);
        add(bNuevo);
        add(bGuardar);
        
        add(bSalir);
    
    }
     public void desactivar(){
        bGuardar.setEnabled(false);
    }
    
    public void activar(){
        bGuardar.setEnabled(true);
    }
     public void actionPerformed(ActionEvent evento) {
       
        if(evento.getSource()==bCalcular){
          tot.calcularDatos();
           
        }
        else if (evento.getSource()==bNuevo){
            tot.nuevo();
        }
               
        else if(evento.getSource()==bGuardar){
           tot.guardarTxt();
          
        }
       
        else if(evento.getSource()==bSalir){
           tot.SalirBotones();
            
            
        }
     }
}
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
