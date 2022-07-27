package real;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class BotonesJugador extends JPanel implements ActionListener {
    private JButton bCalcular,bConsultar,bEditar,bActualizar,bEliminar, bSalir;
    private Real Hala;   
   
    public BotonesJugador(Real Hala){
        this.Hala = Hala;
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

            Hala.Calcular();
        }
        else if(ae.getSource()==bConsultar){
            
            Hala.Consultar();
        }
        else if(ae.getSource()==bEditar){
          
            Hala.Editar();
        }
        else if(ae.getSource()==bActualizar){
        
            Hala.Actualizar();
        }
        else if(ae.getSource()==bEliminar){
           
            Hala.Eliminar();
        }
        else if(ae.getSource()==bSalir){
           
            Hala.SalirBotones();
        }  
   }
}

    
    
    
    
    
    
    
    
    
 
    
    
    
    
    
    
    
    
    
    
    