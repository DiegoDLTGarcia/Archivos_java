/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nike;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import java.io.*;
import javax.swing.*;

public class AccesoDatosTxt {
    private String archivo = "src/plantilla.txt";
    
     public void guardar(Empleado jug) {
         try{
          BufferedWriter bw;
          bw = new BufferedWriter(new FileWriter(archivo, true));
          bw.write(jug.getIdTrabajador()+","+
                  jug.getNombre()+","+
                  jug.getHoras()+","+
                  jug.getPago()+","+
                  jug.getSueldo()+","+
                  jug.getDescontado()+","+
                  jug.getSeguro()+","+
                  jug.getTotal());
          
          bw.newLine();
          bw.close();
                  
       }
         catch(IOException ex){
           JOptionPane.showMessageDialog(null,"no se pudieron guardar los datos\n"+ ex.getMessage());
           
       }
     }
    
}
