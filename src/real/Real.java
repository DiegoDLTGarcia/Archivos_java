
package real;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.EmptyBorder;

public class Real extends JFrame {
    private Jugador jug;
    private Datos datos;
    private Botones botones;
    private Menu menu;    
    private BotonesJugador Botonesjugador;
    private AccesoDatosTxt adntxt;
    private AccesoDatosbd ad;
    private DatosJugador DatosJugador;
    
public Real(){
        Imagenes p = new Imagenes();
        p.setBorder(new EmptyBorder(5, 5, 5, 5));
        p.setLayout(new BorderLayout(0, 0));
        setContentPane(p);
        setLayout(new BorderLayout());
        
        menu= new Menu(this);
        botones = new Botones(this);
        Botonesjugador = new BotonesJugador(this);
        datos = new Datos();
        DatosJugador = new DatosJugador();
        adntxt = new AccesoDatosTxt();
        ad = new AccesoDatosbd("RealMadrid","root","root","localhost");
        
        setJMenuBar(menu);
        setTitle("Real Madrid F.C");
        setResizable(true);
        setSize(900,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
public void menuNuevo(){
    Imagenes p = new Imagenes();
        p.setBorder(new EmptyBorder(5, 5, 5, 5));
        p.setLayout(new BorderLayout(0, 0));
        setContentPane(p);
        setLayout(new BorderLayout());
        
       SalirBotones();
        
        repaint();
        setLayout(new BorderLayout());
              
        add(datos,BorderLayout.NORTH);
        add(botones,BorderLayout.CENTER);
        setVisible(true);
    }
public void menuConsultar(){
    Imagenes p = new Imagenes();
        p.setBorder(new EmptyBorder(5, 5, 5, 5));
        p.setLayout(new BorderLayout(0, 0));
        setContentPane(p);
        setLayout(new BorderLayout());
        
       SalirBotones();
       
        repaint();
        setLayout(new BorderLayout());
        add(DatosJugador,BorderLayout.NORTH);
        add(Botonesjugador,BorderLayout.CENTER);
        setVisible(true);
        validate();
    }
public void SalirBotones(){
        datos.setLimpiar();
        DatosJugador.setLimpiar();
        remove(datos);
        remove(botones);
        remove(DatosJugador);
        remove(Botonesjugador);
        repaint();
    }
 public void Calcular(){
        jug = DatosJugador.getDatosJugador();
        jug.setCalcularSueldo();
        jug.setCalcularRebaja();
        jug.setCalcularCaridad();
        jug.setCalcularTotal();
        DatosJugador.setDatosJugador(jug);

        botones.activar();
         
    }

  public void Consultar(){
        
    String id_jugador = DatosJugador.getTfid_jugador();
        
        if(ad.existe(id_jugador)){
            jug=ad.getJugador(id_jugador);
            JOptionPane.showMessageDialog(null,"El Jugador fue encontrado","Mensaje",0);
            DatosJugador.setDatosJugador(jug);
        }
        else {
            
          JOptionPane.showMessageDialog(null,"El Jugador no juega aquí","Mensaje",0); 
          DatosJugador.setLimpiar();
        }
        
    }
   public void Editar(){
        DatosJugador.setActivar();
    }
    public void Actualizar(){
        String id_jugador = DatosJugador.getTfid_jugador();
        if(ad.existe(id_jugador)){
            jug=DatosJugador.getDatosJugador();
            ad.actualizar(jug);
        }
         else{
           JOptionPane.showMessageDialog(null,"El jugador no juega aquí","Mensaje",0); 
          DatosJugador.setLimpiar();
          DatosJugador.setDesactivar();
            
        }
       
    
    }
    public void Eliminar(){
         String id_jugador = DatosJugador.getTfid_jugador();
        if(ad.existe(id_jugador)){
            ad.eliminar(id_jugador);
            DatosJugador.setLimpiar();
            DatosJugador.setDesactivar();;
        }
        else{
            
            JOptionPane.showMessageDialog(null,"El jugador no juega aqui","Mensaje",2);
            
        }
        
        
    }
    private void centrarFrame(){
        Dimension ScreenSize = getToolkit().getScreenSize();
        int screenWidth = (int)ScreenSize.getWidth();
        int screenHeight = (int) ScreenSize.getHeight();
        
        
        int x = getWidth();
        int y = getHeight();
        
        int a = (screenWidth - x)/2;
        int b = (screenHeight - y)/2;
        setLocation(a,b);
    
    }
    public void calcularDatos(){
      
        jug = datos.getDatosJugador();
        jug.setCalcularSueldo();
        jug.setCalcularRebaja();
        jug.setCalcularCaridad();
        jug.setCalcularTotal();
        datos.setDatosJugador(jug);
        datos.Activar();
   }
   public void nuevo(){
        datos.setLimpiar();
        botones.activar();
   }
  public void guardarbd(){
       
         String id_jugador = datos.getTfid_jugador();
         if(ad.existe(id_jugador)){
         JOptionPane.showMessageDialog(null,"El jugador ya juega aquí","mensaje",2);
         }
       else{
         jug=datos.getDatosJugador();
         ad.nuevo(jug);
         JOptionPane.showMessageDialog(null,"Se registro el jugador " + " con exito bienvenido","Mensaje",2);
         datos.setLimpiar();
         botones.desactivar();
         }
        
  }
  public void guardarTxt(){
      jug = datos.getDatosJugador();
      adntxt.guardar(jug);
      guardarbd();
      datos.setLimpiar();
      botones.desactivar();
      
  }

    public static void main(String[] args) {
//        Real gui = new Real();
//        gui.centrarFrame();
        
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            try {
                Real gui = new Real();
                gui.centrarFrame();
            } catch (Exception e) {
            e.printStackTrace();
            }
       
        }
    });

    }
}
