package real;

import java.sql.*;
import java.util.*;
import javax.swing.*;

public class AccesoDatosbd {

    private String bd;
    private String user;
    private String password;
    private String host;
    private String server;

    public AccesoDatosbd(String bd, String user, String password, String host) {

        this.bd = bd;
        this.user = user;
        this.password = password;
        this.host = host;
        this.server = "jdbc:mysql://" + host + "/" + bd;

    }

    public Connection getConexion() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = DriverManager.getConnection(server, user, password);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "estado :" + e.getSQLState());
            //System.out.println("estado :"+e.getSQLState());
            System.out.printf(("codigo de error :" + e.getErrorCode()));
            e.printStackTrace();
        } finally {
            return cn;
        }
    }

    public boolean existe(String id_jugador) {
        Connection cn = getConexion();
        Statement st = null;
        ResultSet rs = null;
        boolean estado = false;
        try {
            st = cn.createStatement();
            String sql = "SELECT id_jugador from jugadores where id_jugador = '" + id_jugador + "'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                estado = true;
            }
            rs.close();
            st.close();
            cn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "estado" + e.getSQLState());
            JOptionPane.showMessageDialog(null, "codigo de error" + e.getErrorCode());
            e.printStackTrace();
        } finally {
            return estado;
        }
    }

    public int nuevo(Jugador jug) {
        int LineaAfectada = 0;
        Connection cn = getConexion();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO jugadores VALUES(?,?,?,?,?,?,?,?)";
            ps = cn.prepareStatement(sql);
            ps.setString(1, jug.getIdJugador());
            ps.setString(2, jug.getNombre());
            ps.setInt(3, jug.getHoras());
            ps.setDouble(4, jug.getPago());
            ps.setDouble(5, jug.getSueldo());
            ps.setDouble(6, jug.getRebaja());
            ps.setDouble(7, jug.getCaridad());
            ps.setDouble(8, jug.getTotal());
            LineaAfectada = ps.executeUpdate();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "estado" + e.getSQLState());
            System.out.println("codigo de error :" + e.getErrorCode());
            e.printStackTrace();
        } finally {
            return LineaAfectada;
        }
    }

    public Jugador getJugador(String id_jugador) {
        Connection cn = getConexion();
        Statement st = null;
        ResultSet rs = null;
        Jugador jug = null;
        try {
            st = cn.createStatement();
            String sql = "Select * FROM jugadores WHERE id_jugador='" + id_jugador + "'";
            rs = st.executeQuery(sql);
            if (rs.next()) {
                jug = new Jugador();
                jug.setId_jugador(rs.getString("id_jugador"));
                jug.setNombreJugador(rs.getString("nombre_jugador"));
                jug.setHorasjugadas(rs.getInt("horasjugadas"));
                jug.setPago(rs.getDouble("pagoporhora"));
                jug.setSueldo(rs.getDouble("Sueldo_jugador"));
                jug.setRebaja(rs.getDouble("rebaja"));
                jug.setCaridad(rs.getDouble("caridad"));
                jug.setTotal(rs.getDouble("total"));
            }

            rs.close();
            cn.close();
            st.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "estado" + e.getSQLState());
            System.out.println("codigo de error :" + e.getErrorCode());
            e.printStackTrace();
        } finally {
            return jug;
        }
    }

    public int actualizar(Jugador jug) {
        int LineaAfectada = 0;
        Connection cn = getConexion();
        PreparedStatement ps;
        try {
            String sql = "UPDATE jugadores set nombre_jugador=?,"
                    + "" + "horasjugadas=?,"
                    + "pagoporhora=?,"
                    + "sueldo_jugador=?,"
                    + "rebaja=?,"
                    + "caridad=?,"
                    + "total=?"
                    + "WHERE id_jugador=?";
            ps = cn.prepareStatement(sql);
            ps.setString(1, jug.getNombre());
            ps.setInt(2, jug.getHoras());
            ps.setDouble(3, jug.getPago());
            ps.setDouble(4, jug.getSueldo());
            ps.setDouble(5, jug.getRebaja());
            ps.setDouble(6, jug.getCaridad());
            ps.setDouble(7, jug.getTotal());
            ps.setString(8, jug.getIdJugador());

            LineaAfectada = ps.executeUpdate();
            ps.close();
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "estado" + e.getSQLState());
            System.out.println("codigo de error :" + e.getErrorCode());
            e.printStackTrace();
        } finally {
            return LineaAfectada;
        }
    }

    public int eliminar(String pid_jugador) {
        Connection cn = getConexion();
        int LineaAfectada = 0;
        Statement st = null;
        try {
            st = cn.createStatement();
            String sql = "DELETE from jugadores WHERE id_jugador='" + pid_jugador + "'";
            LineaAfectada = st.executeUpdate(sql);
            st.close();
            cn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "estado" + e.getSQLState());
            System.out.println("codigo de error :" + e.getErrorCode());
            e.printStackTrace();
        } finally {
            return LineaAfectada;
        }
    }
}
