package com.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.modelo.Categoria;
import com.conexion.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class CategoriaDAO extends Conexion {

    public int insertarAutor(Categoria c) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO categoria(nombre, description) VALUES(?, ?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, c.getNombre());
            pre.setString(2, c.getDescripcion());
            res = pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar categoria: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<Categoria> mostrarCategorias() {
        ArrayList<Categoria> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM categoria";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setNombre(rs.getString(1));
                c.setDescripcion(rs.getString(2));
                lista.add(c);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }

    public int modificarCategoria(Categoria c) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE categoria SET nombre = ?, description = ? WHERE id_category = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, c.getNombre());
            pre.setString(2, c.getDescripcion());
            pre.setInt(3, c.getIdCategoria());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar categoria: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int eliminarCategoria(Categoria c) {
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM categoria WHERE id_category = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, c.getIdCategoria());
            res = pre.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar categoria: " + e.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
}
