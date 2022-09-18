package com.dao;

import com.modelo.Autor;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.conexion.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class AutorDAO extends Conexion {

    public int insertarAutor(Autor a) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO autor(nombre, apellido, nacionalidad) VALUES(?, ?, ?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, a.getNombre());
            pre.setString(2, a.getApellido());
            pre.setString(3, a.getNacionalidad());
            res = pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar autor: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<Autor> mostrarAutores() {
        ArrayList<Autor> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM autor";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Autor a = new Autor();
                a.setIdAutor(rs.getInt(1));
                a.setNombre(rs.getString(2));
                a.setApellido(rs.getString(3));
                a.setNacionalidad(rs.getString(4));
                lista.add(a);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }

    public int modificarAutor(Autor a) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE autor SET nombre = ?, apellido = ?, nacionalidad = ? WHERE id_autor = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, a.getNombre());
            pre.setString(2, a.getApellido());
            pre.setString(3, a.getNacionalidad());
            pre.setInt(4, a.getIdAutor());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar autor: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int eliminarAutor(Autor a) {
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM autor WHERE id_autor = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, a.getIdAutor());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar autor: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
}
