/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.vistas.dialogos;

import static com.biosis.sgb.Application.BORDE_FONDO;
import static com.biosis.sgb.Application.ESTILO2;
import com.biosis.sgb.controlador.UsuarioControlador;
import com.biosis.sgb.entidades.Usuario;
import com.biosis.sgb.info.UsuarioActivo;
import com.biosis.sgb.vistas.Principal;
import java.awt.Component;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author Francis
 */
public class Login extends javax.swing.JDialog {

    private final UsuarioControlador usuarioControlador;
    private Usuario usuario;

    /**
     * Creates new form Login
     */
    public Login(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        usuarioControlador = UsuarioControlador.getInstance();
        initComponents();
        pnlPrincipal.setBorder(BORDE_FONDO);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        txtLogin = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPrincipal.setLayout(null);

        txtLogin.setFont(ESTILO2);
        txtLogin.setBorder(null);
        txtLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLoginKeyReleased(evt);
            }
        });
        pnlPrincipal.add(txtLogin);
        txtLogin.setBounds(240, 150, 260, 30);

        txtPassword.setFont(ESTILO2);
        txtPassword.setBorder(null);
        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPasswordKeyReleased(evt);
            }
        });
        pnlPrincipal.add(txtPassword);
        txtPassword.setBounds(240, 202, 260, 40);

        btnIngresar.setBackground(new java.awt.Color(195, 80, 56));
        btnIngresar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnIngresar.setForeground(new java.awt.Color(255, 255, 255));
        btnIngresar.setText("Ingresar");
        btnIngresar.setContentAreaFilled(false);
        btnIngresar.setOpaque(true);
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        pnlPrincipal.add(btnIngresar);
        btnIngresar.setBounds(190, 275, 320, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login_background.png"))); // NOI18N
        pnlPrincipal.add(jLabel1);
        jLabel1.setBounds(0, 0, 690, 387);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 687, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLoginKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            realizarLogin();
        }
    }//GEN-LAST:event_txtLoginKeyReleased

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        // TODO add your handling code here:
        realizarLogin();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void txtPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            realizarLogin();
        }
    }//GEN-LAST:event_txtPasswordKeyReleased

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = new Login(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

    private void realizarLogin() {
        LoginDaemon loginDaemon = new LoginDaemon(this);
        loginDaemon.execute();
//        String login = txtLogin.getText();
//        String password = new String(txtPassword.getPassword());
//        usuario = usuarioControlador.realizarLogin(login, password);
//
//        if (usuario != null) {
//            if (usuario.isActivo()) {
//                UsuarioActivo.setUsuario(usuario);
//                Principal principal = new Principal();
//                principal.setAlwaysOnTop(true);
//                principal.setVisible(true);
//                principal.setExtendedState(principal.getExtendedState() | JFrame.MAXIMIZED_BOTH);
//                this.dispose();
//
//            } else {
//                JOptionPane.showConfirmDialog(this, "Usuario no activo", "Mensaje del sistema", JOptionPane.WARNING_MESSAGE);
//            }
//
//        } else {
//            JOptionPane.showConfirmDialog(this, "Usuario o contraseña incorrecta", "Mensaje del sistema", JOptionPane.WARNING_MESSAGE);
//        }
    }

    private class LoginDaemon extends SwingWorker<Void, Double> {

        private final Component ventana;

        public LoginDaemon(Component ventana) {
            this.ventana = ventana;
        }

        @Override
        protected Void doInBackground() throws Exception {
            btnIngresar.setText("Espere un momento...");
            btnIngresar.setEnabled(false);
            txtLogin.setEditable(false);
            txtPassword.setEditable(false);
            
            String login = txtLogin.getText();
            String password = new String(txtPassword.getPassword());
            usuario = usuarioControlador.realizarLogin(login, password);

            return null;
        }

        @Override
        protected void done() {

            if (usuario != null) {
                if (usuario.isActivo()) {
                    UsuarioActivo.setUsuario(usuario);
                    Principal principal = new Principal();
                    principal.setAlwaysOnTop(true);
                    principal.setVisible(true);
                    principal.setExtendedState(principal.getExtendedState() | JFrame.MAXIMIZED_BOTH);
                    dispose();

                } else {
                    JOptionPane.showConfirmDialog(ventana, "Usuario no activo", "Mensaje del sistema", JOptionPane.WARNING_MESSAGE);
                }

            } else {
                JOptionPane.showConfirmDialog(ventana, "Usuario o contraseña incorrecta", "Mensaje del sistema", JOptionPane.WARNING_MESSAGE);
            }

            btnIngresar.setText("Ingresar");
            btnIngresar.setEnabled(true);
            txtLogin.setEditable(true);
            txtPassword.setEditable(true);
        }

    }
}
