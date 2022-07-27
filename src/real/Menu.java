
package real;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import javax.swing.JMenuBar;
import javax.swing.*;
import javax.swing.event.*;

public class Menu extends JMenuBar implements ActionListener {
    private JMenu RealMadridPlantilla, equipo, Directiva, Bernabeu, Salir;
    private JMenuItem Altas,consultar,salir, registro;
    
    private Real Jugador;
    public Menu(Real iEmp){
        
        Jugador=iEmp;
        
        RealMadridPlantilla = new JMenu("Plantilla");
        equipo = new JMenu("Equipo");
        Directiva = new JMenu("Directiva");
        Bernabeu = new JMenu("Bernabeu");
        Salir = new JMenu("Salir");
        Salir.addActionListener(this);
        
        Altas = new JMenuItem("Altas");
        Altas.addActionListener(this);
        
        registro = new JMenuItem("Registro de director");
        registro.addActionListener(this);
        
        consultar = new JMenuItem("Consulta");
        consultar.addActionListener(this);
        
        salir = new JMenuItem("Seguro?");
        salir.addActionListener(this);
  
    Directiva.add(registro);
        RealMadridPlantilla.add(consultar);
        Salir.add(salir);
    //RealMadridPlantilla.add(salir);
        equipo.add(Altas);
        
    add(Directiva);
        add(RealMadridPlantilla);
        add(equipo);
        add(Salir);
  
    }
     public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        
      if(comando.equals("Altas")){
        Jugador.menuNuevo();
      }

      if(comando.equals("Consulta")){
        Jugador.menuConsultar();
      }
      
      if(comando.equals("Registro de director")){
        Jugador.menuConsultar();
      }      
      if(comando.equals("Seguro?")){
       
            System.exit(0);
        }
    }
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
