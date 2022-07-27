
package nike;

import java.awt.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.BorderLayout;

public class InterfazNikeStore extends JFrame {
    private Empleado emp;
    private Datos datos;
    private Botones botones;
    private Menu menu;    
    private BotonesEmpleados BotonesEmpleado;
    private AccesoDatosTxt adntxt;
    private AccesoDatosbd ad;
    private DatosEmpleado DatosEmpleado;
    private Datosclientes Datosclientes;
    private  DatosArtTachos  DatosArtTachos;
    
public InterfazNikeStore(){
        setLayout(new BorderLayout());
        
        DatosArtTachos = new  DatosArtTachos();
        Datosclientes =new Datosclientes();
        menu= new Menu(this);
        botones = new Botones(this);
        BotonesEmpleado = new BotonesEmpleados(this);
        datos = new Datos();
        DatosEmpleado = new DatosEmpleado();
        adntxt = new AccesoDatosTxt();
        ad = new AccesoDatosbd("empleados","root","root","localhost");
        
        setJMenuBar(menu);
        setTitle("NikeFactoryStore");
        setResizable(true);
        setSize(900,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        Imagen F=new Imagen();//crar el objeto
        this.add(F,BorderLayout.CENTER);
        this.pack();
    }



public void menuClientes(){
       SalirBotones();
        //remove(pDatosAsignacion);
        //remove(pBotonesAsignacion);
        repaint();
        setLayout(new BorderLayout());
        add(Datosclientes,BorderLayout.NORTH);
        
        add(botones,BorderLayout.CENTER);;
        setVisible(true);
        validate();
    }

public void menuArtCha(){
        SalirBotones();
        //remove(pDatosEmpleado);
        //remove(pBotonesDatosEmpleado);
        repaint();
        setLayout(new BorderLayout());
              
        add(DatosArtTachos,BorderLayout.NORTH);
        add(botones,BorderLayout.CENTER);
        setVisible(true);
    }

public void menuNuevo(){
       SalirBotones();
        //remove(pDatosEmpleado);
        //remove(pBotonesDatosEmpleado);
        repaint();
        setLayout(new BorderLayout());
              
        add(datos,BorderLayout.NORTH);
        add(botones,BorderLayout.CENTER);
        setVisible(true);
    }
public void menuConsultar(){
       SalirBotones();
        //remove(pDatosAsignacion);
        //remove(pBotonesAsignacion);
        repaint();
        setLayout(new BorderLayout());
        add(DatosEmpleado,BorderLayout.NORTH);
        add(BotonesEmpleado,BorderLayout.CENTER);
        setVisible(true);
        validate();
    }
public void SalirBotones(){
        datos.setLimpiar();
        DatosEmpleado.setLimpiar();
        remove(datos);
        remove(botones);
        remove(DatosEmpleado);
        remove(BotonesEmpleado);
        remove(Datosclientes);
        remove( DatosArtTachos);
        repaint();
    }
 public void Calcular(){
        //emp = Datosclientes.getDatosJugador();
        //emp = DatosArtTachos.getDatosJugador();   
        emp = DatosEmpleado.getDatosJugador();
        emp.setCalcularSueldo();
        emp.setCalcularRebaja();
        emp.setCalcularCaridad();
        emp.setCalcularTotal();
        //emp.setformadepago();
        
        DatosEmpleado.setDatosJugador(emp);
        //DatosArtTachos.setDatosJugador(emp);
        //Datosclientes.setDatosJugador(emp);

        botones.activar();
       
         
    }

  public void Consultar(){
        
    String id_jugador = DatosEmpleado.getTfid_jugador();
        
        if(ad.existe(id_jugador)){
            emp=ad.getTrabajador(id_jugador);
            JOptionPane.showMessageDialog(null,"El empleado fue encontrado","Mensaje",0);
            DatosEmpleado.setDatosJugador(emp);
        }
        else {
            
          JOptionPane.showMessageDialog(null,"El empleado no trabaja aquí","Mensaje",0); 
          DatosEmpleado.setLimpiar();
        }
        
    }
   public void Editar(){
        DatosEmpleado.setActivar();
    }
    public void Actualizar(){
        String id_jugador = DatosEmpleado.getTfid_jugador();
        if(ad.existe(id_jugador)){
            emp=DatosEmpleado.getDatosJugador();
            ad.actualizar(emp);
            JOptionPane.showMessageDialog(null,"Actualizacion realizada","Mensaje",0);
        }
         else{
           JOptionPane.showMessageDialog(null,"El empleado no trabaja aquí","Mensaje",0); 
          DatosEmpleado.setLimpiar();
          DatosEmpleado.setDesactivar();
            
        }
       
    
    }
    public void Eliminar(){
         String id_jugador = DatosEmpleado.getTfid_jugador();
        if(ad.existe(id_jugador)){
            ad.eliminar(id_jugador);
            DatosEmpleado.setLimpiar();
            DatosEmpleado.setDesactivar();;
        }
        else{
            
            JOptionPane.showMessageDialog(null,"El empleado no trabaja aquí","Mensaje",2);
            
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
      emp = datos.getDatosJugador();
        emp.setCalcularSueldo();
        emp.setCalcularRebaja();
        emp.setCalcularCaridad();
        emp.setCalcularTotal();
        datos.setDatosEmpleado(emp);
        datos.Activar();
   }
   public void nuevo(){
        datos.setLimpiar();
        botones.activar();
        DatosArtTachos.setLimpiar();
        botones.activar();
        Datosclientes.setLimpiar();
        botones.activar();
   }
  public void guardarbd(){
       
         String id_jugador = datos.getTfid_jugador();
         if(ad.existe(id_jugador)){
         JOptionPane.showMessageDialog(null,"El empleado ya trabaja aquí","mensaje",2);
         }
       else{
         emp=datos.getDatosJugador();
         ad.nuevo(emp);
         JOptionPane.showMessageDialog(null,"Se registro el trabajador " + " con exito welcome","Mensaje",2);
         datos.setLimpiar();
         botones.desactivar();
         }
        
  }
  public void guardarTxt(){
      emp = datos.getDatosJugador();
      adntxt.guardar(emp);
      guardarbd();
      datos.setLimpiar();
      botones.desactivar();
      
  }
 /*public void Guardar(){
      emp = datos.getDatosJugador();
      adntxt.guardar(emp);
      guardarbd();
      datos.setLimpiar();
      botones.desactivar();
      
  }*/

    public static void main(String[] args) {
        InterfazNikeStore gui = new InterfazNikeStore();
        gui.centrarFrame();
       
    }

   
}
