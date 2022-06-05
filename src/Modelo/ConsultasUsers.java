
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultasUsers extends Conexion{
    public boolean registrar(Usuario user) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO usuario(nombreUsuario, contraUsuario) VALUES(?,?)";

        try {

            ps = con.prepareStatement(sql);
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
    
    
}
