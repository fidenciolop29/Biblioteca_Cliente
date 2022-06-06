package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConsultasLibros extends Conexion {
    public boolean registrar(Libro libro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "INSERT INTO libro(codigoLibro,nombreLibro, autorLibro, editorialLibro,categLibro) VALUES(?,?,?,?,?)";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(libro.getId()));
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getAutor());
            ps.setString(4, libro.getEditorial());
            ps.setString(5, libro.getCategoria());
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
    ////////////////////////////////////////////////////
    public boolean modificar(Libro libro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "UPDATE libro SET nombreLibro=?, autorLibro=?, editorialLibro=?, categLibro=?"
                + " WHERE codigoLibro=? ";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getEditorial());
            ps.setString(4, libro.getCategoria());
            ps.setInt(5, libro.getId());
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
    //////////////////////////////////////////////////////
    public boolean eliminar(Libro libro) {
        PreparedStatement ps = null;
        Connection con = getConexion();

        String sql = "DELETE FROM libro WHERE codigoLibro= ";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, libro.getId());
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
    //////////////////////////////////////////////////////
    public boolean buscar(Libro libro) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConexion();

        String sql = "SELECT * FROM libro WHERE codigoLibro=? ";

        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, String.valueOf(libro.getId()));
            rs = ps.executeQuery();
            
            if(rs.next())
            {
                libro.setId(Integer.parseInt(rs.getString("codigoLibro")));
                libro.setTitulo(rs.getString("nombreLibro"));
                libro.setAutor(rs.getString("autorLibro"));
                libro.setEditorial(rs.getString("editorialLibro"));
                libro.setCategoria(rs.getString("categLibro"));
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
