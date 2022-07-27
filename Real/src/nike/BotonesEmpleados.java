
package nike;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BotonesEmpleados extends JPanel implements ActionListener {
   
    private JButton bCalcular,bConsultar,bEditar,bActualizar,bEliminar, bSalir;
    private InterfazNikeStore tot;
      
   public BotonesEmpleados(InterfazNikeStore tot){
        this.tot = tot;
       
        bCalcular = new JButton("Calcular");
        bConsultar = new JButton("Consultar");
        bEditar = new JButton("Editar");
        bActualizar = new JButton("Actualizar");
        bEliminar = new JButton("Eliminar");
        bSalir = new JButton("Salir");
        
        
        bCalcular.addActionListener(this);
        bConsultar.addActionListener(this);
        bEditar.addActionListener(this);
        bActualizar.addActionListener(this);
        bEliminar.addActionListener(this);
        bSalir.addActionListener(this);
        
        
        setLayout(new FlowLayout());
        
      
        add(bCalcular);
        add(bConsultar);
        add(bEditar);
        add(bActualizar);
        add(bEliminar);
        add(bSalir);

    
    }
   public void actionPerformed(ActionEvent ae) {
        
       if (ae.getSource()==bCalcular){

            tot.Calcular();
        }
      
        else if(ae.getSource()==bConsultar){
            
            tot.Consultar();
        }
        else if(ae.getSource()==bEditar){
          
            tot.Editar();
        }
        else if(ae.getSource()==bActualizar){
        
            tot.Actualizar();
        }
        else if(ae.getSource()==bEliminar){
           
            tot.Eliminar();
        }
        else if(ae.getSource()==bSalir){
           
            tot.SalirBotones();
        }
        
    }
}

    
    
    
    
    
    
    
    
    
 
    
    
    
    
    
    
    
    
    
    
    