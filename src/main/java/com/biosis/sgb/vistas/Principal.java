/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.vistas;

import static com.biosis.sgb.Application.ESTILO1;
import static com.biosis.sgb.Application.ESTILO4;
import static com.biosis.sgb.Application.IMG_FONDO_APP;
import com.biosis.sgb.util.ButtonTabComponent;
import com.personal.utiles.ImagenFondo;
import java.awt.Component;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author Francis
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    private static final Logger LOG = Logger.getLogger(Principal.class.getName());
    public static ImagenFondo borde;
    public Principal() {
        initComponents();
//        iniciarTab(0);

        try {
            borde = new ImagenFondo(ImageIO.read(IMG_FONDO_APP));
//            pnlBienvenida.setBorder(borde);
//            pnlPrincipal.setBorder(borde);
        } catch (IOException ex) {
            LOG.error("Error al inicializar borde", ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        pnlPrincipal = new javax.swing.JPanel();
        tabPrincipal = new javax.swing.JTabbedPane();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        mnuRegistroLibro = new javax.swing.JMenuItem();
        mnuRegistroEjemplar = new javax.swing.JMenuItem();
        mnuConsultas = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        mnuRegistroAutor = new javax.swing.JMenuItem();
        mnuRegistroEditorial = new javax.swing.JMenuItem();
        mnuRegistroMateria = new javax.swing.JMenuItem();
        mnuRegistroTema = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        mnuPersona = new javax.swing.JMenuItem();
        mnuPrestamo = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        tabPrincipal.setFont(ESTILO1);
        pnlPrincipal.add(tabPrincipal, java.awt.BorderLayout.CENTER);

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setFont(ESTILO4);
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Find/Find_24x24.png"))); // NOI18N
        jButton1.setText("   Consultas   ");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jButton3.setFont(ESTILO4);
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/library.png"))); // NOI18N
        jButton3.setText("  Ejemplares en biblioteca  ");
        jButton3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton2.setFont(ESTILO4);
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Properties/Properties_24x24.png"))); // NOI18N
        jButton2.setText("   Préstamos y devoluciones   ");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton2);

        pnlPrincipal.add(jToolBar1, java.awt.BorderLayout.NORTH);

        getContentPane().add(pnlPrincipal, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Inicio");
        jMenu1.setFont(ESTILO4);

        jMenuItem6.setFont(ESTILO4);
        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Log Out/Log Out_16x16.png"))); // NOI18N
        jMenuItem6.setText("Salir");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("Biblioteca");
        jMenu4.setFont(ESTILO4);

        mnuRegistroLibro.setFont(ESTILO4);
        mnuRegistroLibro.setText("Registro de libros");
        mnuRegistroLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistroLibroActionPerformed(evt);
            }
        });
        jMenu4.add(mnuRegistroLibro);

        mnuRegistroEjemplar.setFont(ESTILO4);
        mnuRegistroEjemplar.setText("Registro de ejemplares");
        jMenu4.add(mnuRegistroEjemplar);

        mnuConsultas.setFont(ESTILO4);
        mnuConsultas.setText("Consultas");
        jMenu4.add(mnuConsultas);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Datos de material bibliográfico");
        jMenu5.setFont(ESTILO4);

        mnuRegistroAutor.setFont(ESTILO4);
        mnuRegistroAutor.setText("Registro de autores");
        mnuRegistroAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistroAutorActionPerformed(evt);
            }
        });
        jMenu5.add(mnuRegistroAutor);

        mnuRegistroEditorial.setFont(ESTILO4);
        mnuRegistroEditorial.setText("Registro de editoriales");
        mnuRegistroEditorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegistroEditorialActionPerformed(evt);
            }
        });
        jMenu5.add(mnuRegistroEditorial);

        mnuRegistroMateria.setFont(ESTILO4);
        mnuRegistroMateria.setText("Registro de materias y secciones");
        jMenu5.add(mnuRegistroMateria);

        mnuRegistroTema.setFont(ESTILO4);
        mnuRegistroTema.setText("Registro de temas y subtemas");
        jMenu5.add(mnuRegistroTema);

        jMenuBar1.add(jMenu5);

        jMenu7.setText("Préstamos");
        jMenu7.setFont(ESTILO4);

        mnuPersona.setFont(ESTILO4);
        mnuPersona.setText("Información y registro de personas");
        mnuPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPersonaActionPerformed(evt);
            }
        });
        jMenu7.add(mnuPersona);

        mnuPrestamo.setFont(ESTILO4);
        mnuPrestamo.setText("Préstamos y devoluciones");
        mnuPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuPrestamoActionPerformed(evt);
            }
        });
        jMenu7.add(mnuPrestamo);

        jMenuBar1.add(jMenu7);

        jMenu2.setText("Reportes");
        jMenu2.setFont(ESTILO4);

        jMenuItem8.setFont(ESTILO4);
        jMenuItem8.setText("Reporte de ejemplares");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem8);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        agregarPestaña("Préstamos y devoluciones", PrestamoView.getInstance());
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        agregarPestaña("Consultas", ConsultaView.getInstance());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        agregarPestaña("Ejemplares", EjemplarView.getInstance());
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
        agregarPestaña("Reporte de ejemplares", ReporteEjemplarView.getInstance());
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void mnuRegistroLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistroLibroActionPerformed
        // TODO add your handling code here:
        agregarPestaña("Registro de libros", LibroView.getInstance());
    }//GEN-LAST:event_mnuRegistroLibroActionPerformed

    private void mnuRegistroAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistroAutorActionPerformed
        // TODO add your handling code here:
        agregarPestaña("Registro de autores", AutorView.getInstance());
    }//GEN-LAST:event_mnuRegistroAutorActionPerformed

    private void mnuPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPersonaActionPerformed
        // TODO add your handling code here:
        agregarPestaña("Registro de personas", PersonaView.getInstance());
    }//GEN-LAST:event_mnuPersonaActionPerformed

    private void mnuPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuPrestamoActionPerformed
        // TODO add your handling code here:
        agregarPestaña("Préstamos y devoluciones", PrestamoView.getInstance());
    }//GEN-LAST:event_mnuPrestamoActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void mnuRegistroEditorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegistroEditorialActionPerformed
        // TODO add your handling code here:
        agregarPestaña("Registro de editoriales", EditorialView.getInstance());
    }//GEN-LAST:event_mnuRegistroEditorialActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JButton jButton1;
    private static javax.swing.JButton jButton2;
    private static javax.swing.JButton jButton3;
    private static javax.swing.JMenu jMenu1;
    private static javax.swing.JMenu jMenu2;
    private static javax.swing.JMenu jMenu4;
    private static javax.swing.JMenu jMenu5;
    private static javax.swing.JMenu jMenu7;
    private static javax.swing.JMenuBar jMenuBar1;
    private static javax.swing.JMenuItem jMenuItem6;
    private static javax.swing.JMenuItem jMenuItem8;
    private static javax.swing.JToolBar jToolBar1;
    private static javax.swing.JMenuItem mnuConsultas;
    private static javax.swing.JMenuItem mnuPersona;
    private static javax.swing.JMenuItem mnuPrestamo;
    private static javax.swing.JMenuItem mnuRegistroAutor;
    private static javax.swing.JMenuItem mnuRegistroEditorial;
    private static javax.swing.JMenuItem mnuRegistroEjemplar;
    private static javax.swing.JMenuItem mnuRegistroLibro;
    private static javax.swing.JMenuItem mnuRegistroMateria;
    private static javax.swing.JMenuItem mnuRegistroTema;
    private static javax.swing.JPanel pnlPrincipal;
    private static javax.swing.JTabbedPane tabPrincipal;
    // End of variables declaration//GEN-END:variables

    private void iniciarTab(int numero) {
//        for(int i = 0; i <= numero; i++){
//        ButtonTabComponent tab = new ButtonTabComponent(tabPrincipal);
//        tabPrincipal.add("Mantenimiento de inf. de libros", new LibroView());
//        tabPrincipal.setTabComponentAt(0, tab);
//        ButtonTabComponent tab2 = new ButtonTabComponent(tabPrincipal);
//        tabPrincipal.add("Préstamos y devoluciones", new PrestamoView());
//        tabPrincipal.setTabComponentAt(0, tab2);
//        }
    }

    public static void agregarPestaña(String titulo, Component ventana) {
        int index = tabPrincipal.indexOfComponent(ventana);
        if (index >= 0) {
            tabPrincipal.setSelectedIndex(index);
        } else {
//            ((JPanel)ventana).setBorder(borde);
            ButtonTabComponent tab = new ButtonTabComponent(tabPrincipal);
            tabPrincipal.add(titulo, ventana);
            tabPrincipal.setTabComponentAt(tabPrincipal.getTabCount() - 1, tab);
            tabPrincipal.setSelectedIndex(tabPrincipal.getTabCount() - 1);
            
        }
    }
}
