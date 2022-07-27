
package nike;
import java.sql.*;
import java.util.*;
import javax.swing.*;


public class AccesoDatosbd {
    private String bd;
    private String user;
    private String password;
    private String host;
    private String server;

 public AccesoDatosbd(String bd,String user,String password,String host){
        
        this.bd = bd;
        this.user = user;
        this.password = password;
        this.host = host;
        this.server = "jdbc:mysql://"+host+"/"+bd;
        
    }
 public Connection getConexion(){
        Connection cn=null;
        try{
            //carga del driver
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn=DriverManager.getConnection(server, user, password);
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"estado :"+e.getSQLState());
            //System.out.println("estado :"+e.getSQLState());
             System.out.printf(("codigo de error :"+e.getErrorCode()));
             e.printStackTrace();
        }
       
        finally{
        return cn;
    
        }
        
    }
  public boolean existe(String id_trabajador){
        Connection cn = getConexion();
        Statement st = null;
        ResultSet rs = null;

        boolean estado = false;

        try{
        st=cn.createStatement();
        String sql = "SELECT id_jugador from trabajadores where id_jugador = '"+id_trabajador+"'";
        rs=st.executeQuery(sql);
        if(rs.next()){
            estado=true;
        }
        rs.close();
        st.close();
        cn.close();
        
    }
        catch(SQLException e){
        JOptionPane.showMessageDialog(null,"estado"+e.getSQLState());
        JOptionPane.showMessageDialog(null,"codigo de error"+e.getErrorCode());
         e.printStackTrace();
   }
        
        finally{
        return estado;
    
        }
  }
  public int nuevo(Empleado trab){
        int LineaAfectada = 0;
        
        Connection cn = getConexion();
        
        PreparedStatement ps = null;
        
        try{
            String sql = "INSERT INTO trabajadores VALUES(?,?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            
            ps.setString(1,trab.getIdTrabajador());
            ps.setString(2,trab.getNombre());
            ps.setInt(3,trab.getHoras());
            ps.setDouble(4,trab.getPago());
            ps.setDouble(5,trab.getSueldo());
            ps.setDouble(6,trab.getDescontado());
            ps.setDouble(7,trab.getSeguro());
            ps.setDouble(8,trab.getTotal());
        
            LineaAfectada=ps.executeUpdate();
            
            ps.close();
            cn.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"estado"+e.getSQLState());
            System.out.println("codigo de error :" + e.getErrorCode());
            e.printStackTrace();
        }
        finally{
            return LineaAfectada;
        }
        
    }
   public Empleado getTrabajador(String id_empleado){
        Connection cn = getConexion();
        Statement st = null;
        ResultSet rs = null;
        Empleado trab = null;
        try{
            st=cn.createStatement();
            String sql = "Select * FROM trabajadores WHERE id_jugador='"+id_empleado+"'";
            rs=st.executeQuery(sql);
            if(rs.next()){
                trab=new Empleado();
                trab.setId_jugador(rs.getString("id_jugador"));
                trab.setNombreJugador(rs.getString("nombre_jugador"));
                trab.setHorasTrabajadas(rs.getInt("horasjugadas"));
                trab.setPago(rs.getDouble("pagoporhora"));
                trab.setSueldo(rs.getDouble("sueldo_jugador"));
                trab.setRebaja(rs.getDouble("rebaja"));
                trab.setCaridad(rs.getDouble("caridad"));
                trab.setTotal(rs.getDouble("total"));
            }
            
            rs.close();
            cn.close();
            st.close();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,"estado"+e.getSQLState());
            System.out.println("codigo de error :" + e.getErrorCode());
            e.printStackTrace();
            
        }
        finally{
            return trab;
        }
    }   
    public int actualizar(Empleado trab){
          int LineaAfectada = 0;
          Connection cn = getConexion();
          PreparedStatement ps;
          
          try{
              String sql = "UPDATE trabajadores SET nombre_jugador=?,"+
                      "horasjugadas=?,"+
                      "pagoporhora=?,"+
                      "sueldo_jugador=?,"+
                      "rebaja=?,"+
                      "caridad=?,"+
                      "total=? "+
                      "WHERE id_jugador=?";
              ps = cn.prepareStatement(sql);
              ps.setString(1,trab.getNombre());
              ps.setInt(2,trab.getHoras());
              ps.setDouble(3,trab.getPago());
              ps.setDouble(4,trab.getSueldo());
              ps.setDouble(5,trab.getDescontado());
              ps.setDouble(6,trab.getSeguro());
              ps.setDouble(7,trab.getTotal());
              ps.setString(8,trab.getIdTrabajador());

              LineaAfectada=ps.executeUpdate();
              ps.close();
              cn.close();
          }
           catch(SQLException e){
            JOptionPane.showMessageDialog(null,"estado"+e.getSQLState());
            System.out.println("codigo de error :" + e.getErrorCode());
            e.printStackTrace();
          }
          finally{
              return LineaAfectada;
          }
    }
     public int eliminar(String pid_jugador){
        Connection cn = getConexion();
        int LineaAfectada = 0;
        Statement st = null;
        try{
        st=cn.createStatement();
        String sql = "DELETE from trabajadores WHERE id_jugador='"+pid_jugador+"'";
        LineaAfectada=st.executeUpdate(sql);
        st.close();
        cn.close();
        }
           catch(SQLException e){
            JOptionPane.showMessageDialog(null,"estado"+e.getSQLState());
            System.out.println("codigo de error :" + e.getErrorCode());
            e.printStackTrace();
           }
        finally{
            return LineaAfectada;
        }
    }
}
