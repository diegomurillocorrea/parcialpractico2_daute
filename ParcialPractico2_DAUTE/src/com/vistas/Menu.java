/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.vistas;

/**
 *
 * @author diegomurillo
 */
public class Menu extends javax.swing.JFrame {

    FormAutor formAutor;

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        escritorio = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuSalir = new javax.swing.JMenu();
        menuCRUD = new javax.swing.JMenu();
        menuCategoria = new javax.swing.JMenuItem();
        menuLibro = new javax.swing.JMenuItem();
        menuAutor = new javax.swing.JMenuItem();
        menuReportes = new javax.swing.JMenu();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 876, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 545, Short.MAX_VALUE)
        );

        getContentPane().add(escritorio);

        menuSalir.setText("Salir");
        menuSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuSalirMouseClicked(evt);
            }
        });
        jMenuBar1.add(menuSalir);

        menuCRUD.setText("CRUD");

        menuCategoria.setText("Categoria");
        menuCRUD.add(menuCategoria);

        menuLibro.setText("Libro");
        menuCRUD.add(menuLibro);

        menuAutor.setText("Autor");
        menuAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAutorMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                menuAutorMousePressed(evt);
            }
        });
        menuCRUD.add(menuAutor);

        jMenuBar1.add(menuCRUD);

        menuReportes.setText("Reportes");
        jMenuBar1.add(menuReportes);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuSalirMouseClicked
        this.dispose();
    }//GEN-LAST:event_menuSalirMouseClicked

    private void menuAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAutorMouseClicked

    }//GEN-LAST:event_menuAutorMouseClicked

    private void menuAutorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAutorMousePressed
        if (formAutor == null || formAutor.isClosed()) {
            formAutor = new FormAutor();
            escritorio.add(formAutor);
            formAutor.setVisible(true);
        } else {
            formAutor.setVisible(true);
        }
        formAutor.setLocation(10, 10);
    }//GEN-LAST:event_menuAutorMousePressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem menuAutor;
    private javax.swing.JMenu menuCRUD;
    private javax.swing.JMenuItem menuCategoria;
    private javax.swing.JMenuItem menuLibro;
    private javax.swing.JMenu menuReportes;
    private javax.swing.JMenu menuSalir;
    // End of variables declaration//GEN-END:variables
}