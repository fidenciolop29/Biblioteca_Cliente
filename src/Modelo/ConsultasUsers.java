
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasUsers extends Conexion{
    public boolean registrar(Usuario user) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuario(idUsuario, nombreUsuario, contraUsuario) VALUES(?,?)";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(user.getId()));
            ps.setString(2, user.getUser());
            ps.setString(3, user.getPassword());
            ps.execute();
            return true;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    ////////////////////////////////////////////////////////////////////
     public boolean buscar(Usuario user) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM usuario WHERE (nombreUsuario=?) AND (contraUsuario=?) ";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(2, user.getUser());
            ps.setString(3, user.getPassword());
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                user.setUser(rs.getString("nombreUsuario"));
                user.setPassword(rs.getString("contraUsuario"));
                return true;
            }            
            return false;

        } catch (SQLException e) {
            System.err.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    
}
