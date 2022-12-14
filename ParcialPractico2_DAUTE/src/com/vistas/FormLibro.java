package com.vistas;

import java.util.ArrayList;
import com.modelo.Autor;
import com.dao.AutorDAO;
import com.modelo.Categoria;
import com.dao.CategoriaDAO;
import com.modelo.Libro;
import com.dao.LibroDAO;
import javax.swing.JOptionPane;
import com.utilidades.ComboboxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class FormLibro extends javax.swing.JInternalFrame {

    AutorDAO autorDAO = new AutorDAO();
    LibroDAO libroDAO = new LibroDAO();
    CategoriaDAO categoriaDAO = new CategoriaDAO();

    /**
     * Creates new form FormLibro
     */
    public FormLibro() {
        initComponents();
        comboAutor();
        comboCategoria();
        llenarTabla();
    }

    public void comboAutor() {
        ArrayList<Autor> listaAutor = autorDAO.mostrarAutor();
        DefaultComboBoxModel<ComboboxModel> modelo = new DefaultComboBoxModel();
        for (Autor a : listaAutor) {
            modelo.addElement(new ComboboxModel(a.getId_autor(), a.getNombre()));
        }
        cmbAutor.setModel(modelo);
    }

    public void comboCategoria() {
        ArrayList<Categoria> listaCategoria = categoriaDAO.mostrarCategorias();
        DefaultComboBoxModel<ComboboxModel> modelo = new DefaultComboBoxModel();
        for (Categoria c : listaCategoria) {
            modelo.addElement(new ComboboxModel(c.getIdCategoria(), c.getNombre()));
        }
        cmbCategoria.setModel(modelo);
    }

    public void llenarTabla() {
        ArrayList<Libro> lista = libroDAO.mostrarLibros();
        String[] encabezados = {"ID", "Titulo", "Descripcion", "Stock", "Stock Min", "Categoria", "Autor"};
        DefaultTableModel modelo = new DefaultTableModel(null, encabezados);
        for (Libro libro : lista) {
            Object[] data = {
                libro.getIdLibro(),
                libro.getTitulo(),
                libro.getDescripcion(),
                libro.getStock(),
                libro.getStockMinimo(),
                libro.getNombreCategoria(),
                libro.getNombreAutor()
            };
            modelo.addRow(data);
        }
        tblLibros.setModel(modelo);
    }

    public Libro capturarDatos() {
        int id = Integer.parseInt(txtID.getText());
        String titulo = txtTitulo.getText();
        String descripcion = txtDescripcion.getText();
        int stock = Integer.parseInt(txtStock.getText());
        int stockMin = Integer.parseInt(txtStockMinimo.getText());
        String categoria = cmbCategoria.getSelectedItem().toString();
        String autor = cmbAutor.getSelectedItem().toString();
        int codigoCategoria = 0;
        int codigoAutor = 0;
        for (int i = 0; i < cmbCategoria.getItemCount(); i++) {
            String nombreCategoria = cmbCategoria.getItemAt(i).getValor();
            if (categoria.equals(nombreCategoria)) {
                codigoCategoria = cmbCategoria.getItemAt(i).getCodigo();
            }
        }
        for (int i = 0; i < cmbAutor.getItemCount(); i++) {
            String nombreAutor = cmbAutor.getItemAt(i).getValor();
            if (autor.equals(nombreAutor)) {
                codigoAutor = cmbAutor.getItemAt(i).getCodigo();
            }
        }
        Libro l = new Libro();
        l.setIdLibro(id);
        l.setTitulo(titulo);
        l.setDescripcion(descripcion);
        l.setStock(stock);
        l.setStockMinimo(stockMin);
        l.setCodigoCategoria(codigoCategoria);
        l.setCodigoAutor(codigoAutor);
        return l;
    }

    public void limpiarFormulario() {
        txtID.setText("0");
        txtTitulo.setText("");
        txtDescripcion.setText("");
        txtStock.setText("");
        txtStockMinimo.setText("");
        cmbCategoria.setSelectedIndex(0);
        cmbAutor.setSelectedIndex(0);
    }

    public void llenarFormulario() {
        int row = tblLibros.getSelectedRow();
        String codigo = tblLibros.getValueAt(row, 0).toString();
        String titulo = tblLibros.getValueAt(row, 1).toString();
        String descripcion = tblLibros.getValueAt(row, 2).toString();
        String stock = tblLibros.getValueAt(row, 3).toString();
        String stockMin = tblLibros.getValueAt(row, 4).toString();
        String categoria = tblLibros.getValueAt(row, 5).toString();
        String autor = tblLibros.getValueAt(row, 6).toString();
        txtID.setText(codigo);
        txtTitulo.setText(titulo);
        txtDescripcion.setText(descripcion);
        txtStock.setText(stock);
        txtStockMinimo.setText(stockMin);
        cmbCategoria.getModel().setSelectedItem(categoria);
        cmbAutor.getModel().setSelectedItem(autor);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        tblLibros = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnCerrar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtStockMinimo = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtStock = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbAutor = new javax.swing.JComboBox<>();
        cmbCategoria = new javax.swing.JComboBox<>();

        tblLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblLibros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibrosMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblLibros);

        jLabel2.setText("Libro ID");

        txtID.setEditable(false);
        txtID.setText("0");

        btnCerrar.setText("CERRAR");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        jLabel3.setText("Titulo");

        jLabel5.setText("Stock Minimo");

        jLabel4.setText("Descripcion");

        jLabel6.setText("Stock");

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        btnAgregar.setText("AGREGAR");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel7.setText("Categoria");

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        jLabel8.setText("Autor");

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("GESTION DE LIBROS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregar)
                                .addGap(27, 27, 27)
                                .addComponent(btnModificar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnEliminar)
                                .addGap(30, 30, 30)
                                .addComponent(btnCerrar)))
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtStock, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                                    .addComponent(txtID))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(44, 44, 44))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(28, 28, 28)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnCerrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (tblLibros.getSelectedRow() != -1) {
            int res = libroDAO.modificarLibro(capturarDatos());
            if (res == 1) {
                JOptionPane.showMessageDialog(null, "Libro actualizado");
                llenarTabla();
                limpiarFormulario();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para modificar");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void tblLibrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibrosMouseClicked
        llenarFormulario();
    }//GEN-LAST:event_tblLibrosMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        int res = libroDAO.insertarLibro(capturarDatos());
        if (res == 1) {
            JOptionPane.showMessageDialog(null, "Libro registrado");
            llenarTabla();
            limpiarFormulario();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tblLibros.getSelectedRow() != -1) {
            int resp = JOptionPane.showConfirmDialog(null, "Seguro que desea Eliminarlo?", "Eliminar registro", 0);
            if (JOptionPane.OK_OPTION == resp) {
                int res = libroDAO.eliminarLibro(capturarDatos());
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Libro eliminado");
                    llenarTabla();
                    limpiarFormulario();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<ComboboxModel> cmbAutor;
    private javax.swing.JComboBox<ComboboxModel> cmbCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable tblLibros;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtStockMinimo;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
