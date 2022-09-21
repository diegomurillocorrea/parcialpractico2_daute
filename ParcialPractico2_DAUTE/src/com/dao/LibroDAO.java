package com.dao;

import com.modelo.Libro;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.conexion.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class LibroDAO extends Conexion {

    public int insertarLibro(Libro l) {
        int res = 0;
        try {
            this.conectar();
            String sql = "INSERT INTO libro(titulo, description, stock, stock_minimo, category_id, autor_id) VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, l.getTitulo());
            pre.setString(2, l.getDescripcion());
            pre.setInt(3, l.getStock());
            pre.setInt(4, l.getStockMinimo());
            pre.setInt(5, l.getCodigoCategoria());
            pre.setInt(6, l.getCodigoAutor());
            res = pre.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error al insertar libro: " + err.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public ArrayList<Libro> mostrarLibros() {
        ArrayList<Libro> lista = new ArrayList<>();
        try {
            this.conectar();
            String sql = "SELECT * FROM libro l INNER JOIN categoria c on l.category_id = c.id_category INNER JOIN autor a on a.id_autor = l.autor_id";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Libro l = new Libro();
                l.setIdLibro(rs.getInt(1));
                l.setTitulo(rs.getString(2));
                l.setDescripcion(rs.getString(3));
                l.setStock(rs.getInt(4));
                l.setStockMinimo(rs.getInt(5));
                l.setNombreCategoria(rs.getString(9));
                l.setNombreAutor(rs.getString(12));
                lista.add(l);
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error al mostrar datos: " + err.getMessage());
        } finally {
            this.desconectar();
        }
        return lista;
    }

    public int modificarLibro(Libro l) {
        int res = 0;
        try {
            this.conectar();
            String sql = "UPDATE libro SET titulo = ?, description = ?, stock = ?, stock_minimo = ?, category_id = ?, autor_id = ? WHERE id_libro = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setString(1, l.getTitulo());
            pre.setString(2, l.getDescripcion());
            pre.setInt(3, l.getStock());
            pre.setInt(4, l.getStockMinimo());
            pre.setInt(5, l.getCodigoCategoria());
            pre.setInt(6, l.getCodigoAutor());
            pre.setInt(7, l.getIdLibro());
            res = pre.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error al modificar libro: " + err.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }

    public int eliminarLibro(Libro l) {
        int res = 0;
        try {
            this.conectar();
            String sql = "DELETE FROM libro WHERE id_libro = ?";
            PreparedStatement pre = this.getCon().prepareStatement(sql);
            pre.setInt(1, l.getIdLibro());
            res = pre.executeUpdate();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error al eliminar libro: " + err.getMessage());
        } finally {
            this.desconectar();
        }
        return res;
    }
}
