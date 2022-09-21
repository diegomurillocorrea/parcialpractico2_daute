package com.dao;

import com.conexion.Conexion;
import com.modelo.Autor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class AutorDAO extends Conexion {

    public int insertarAutor(Autor p) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO autor(nombre, apellido, nacionalidad) VALUES(?,?,?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, p.getNombre());
            pre.setString(2, p.getApellido());
            pre.setString(3, p.getNacionalidad());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al agregar registro " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<Autor> mostrarAutor() {
        ArrayList<Autor> listAutores = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM autor";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Autor p = new Autor();
                p.setId_autor(rs.getInt(1));
                p.setNombre(rs.getString("nombre"));
                p.setApellido(rs.getString("apellido"));
                p.setNacionalidad(rs.getString("nacionalidad"));
                listAutores.add(p);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al extraer los registros " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return listAutores;
    }

    public int modificarAutor(Autor p) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE autor SET nombre=?, apellido=?, nacionalidad=? WHERE id_autor=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, p.getNombre());
            pre.setString(2, p.getApellido());
            pre.setString(3, p.getNacionalidad());
            pre.setInt(4, p.getId_autor());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int eliminarAutor(Autor p) {
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM autor WHERE id_autor=?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, p.getId_autor());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

}