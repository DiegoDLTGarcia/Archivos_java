
package nike;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JMenuBar;
import javax.swing.*;
import javax.swing.event.*;


public class Menu extends JMenuBar implements ActionListener {
    private JMenu nikeeq, trab, dueño,tin,  Salir ,Clientes,Chamarras;
    private JMenuItem Altas,tiendas,consultar,salir,clientes,chamarras;
    
    private InterfazNikeStore Empleado131;
    public Menu(InterfazNikeStore iEmp){
        
        Empleado131=iEmp;
        
        nikeeq = new JMenu("Equipo de trabajo");
        trab = new JMenu("Trabajadores");
        Clientes=new JMenu("Clientes");
        Chamarras=new JMenu("Chamarras");
        
        //tiendas = new JMenu("Tiendas");
       
        clientes = new JMenuItem("Clientes");
        clientes.addActionListener(this);
        
        Salir = new JMenu("Salir");
        Salir.addActionListener(this);
        
        Altas = new JMenuItem("Altas");
        Altas.addActionListener(this);
        
       chamarras = new JMenuItem("Chamarras");
       chamarras.addActionListener(this);
        
        
        consultar = new JMenuItem("Consulta");
        consultar.addActionListener(this);
        
        salir = new JMenuItem("Seguro?");
        salir.addActionListener(this);
        
        
        
        Chamarras.add(chamarras);
        Clientes.add(clientes);
        nikeeq.add(consultar);
        Salir.add(salir);
        
        trab.add(Altas);
        //tin.add(tiendas);
        add(Chamarras);
        add(Clientes);
        add(nikeeq);
        add(trab);
        
        add(Salir);
        
        
    }
     public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();//recupera la accion del click
       
      if(comando.equals("Chamarras")){
        Empleado131.menuArtCha();
      }
      if(comando.equals("Altas")){
        Empleado131.menuNuevo();
      }
      
      if(comando.equals("Clientes")){
        Empleado131.menuClientes();
      }
        
      if(comando.equals("tieda")){
        Empleado131.menuNuevo();
      
      
      }
      if(comando.equals("Consulta")){
        Empleado131.menuConsultar();
      }
            
      if(comando.equals("Seguro?")){
       
            System.exit(0);
        }
      
      
         
    
    }
    
    
     }



    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
