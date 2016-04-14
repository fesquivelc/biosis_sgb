/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.vistas.dialogos;

import static com.biosis.sgb.Application.ESTILO1;
import static com.biosis.sgb.Application.ESTILO2;
import static com.biosis.sgb.Application.ESTILO5;
import static com.biosis.sgb.Application.ESTILO6;
import static com.biosis.sgb.controlador.Controlador.ELIMINAR;
import static com.biosis.sgb.controlador.Controlador.LEER;
import static com.biosis.sgb.controlador.Controlador.MODIFICAR;
import static com.biosis.sgb.controlador.Controlador.NUEVO;
import com.biosis.sgb.controlador.RolControlador;
import com.biosis.sgb.controlador.UsuarioControlador;
import com.biosis.sgb.entidades.Autor;
import com.biosis.sgb.entidades.Persona;
import com.biosis.sgb.entidades.Rol;
import com.biosis.sgb.entidades.Usuario;
import com.biosis.sgb.util.AbstractListCellRenderer;
import com.biosis.sgb.util.ControlAcceso;
import com.biosis.sgb.util.ImagenUtil;
import com.personal.utiles.FormularioUtil;
import java.awt.Component;
import java.util.Date;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author Francis
 */
public class UsuarioCRUD2 extends javax.swing.JDialog implements ControlAcceso {

    /**
     * Creates new form AutorCRUD
     */
    private UsuarioControlador usuarioControlador;
    private RolControlador rolControlador;
    
    private int accion;
    private boolean accionRealizada = false;
    private Usuario usuario;
    private Persona personaSeleccionada;
    private byte[] imagenSeleccionada;

    public Usuario getUsuario() {
        return usuario;
    }

    public boolean isAccionRealizada() {
        return accionRealizada;
    }

    public UsuarioCRUD2(java.awt.Frame parent, boolean modal, int accion, Autor autor) {
        super(parent, modal);
        initComponents();
        initComponents2();
    }

    public UsuarioCRUD2(Component component, boolean modal, int accion, Usuario usuario) {
        super(JOptionPane.getFrameForComponent(component), modal);
        initComponents();
        initComponents2();
        this.usuario = usuario;
        this.accion = accion;
        inicializar(usuario, accion);
        this.setLocationRelativeTo(component);
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

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlCuerpo = new javax.swing.JPanel();
        pnlPersona = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jPanel4 = new javax.swing.JPanel();
        chkUsuarioActivo = new javax.swing.JCheckBox();
        chkCambiarPassword = new javax.swing.JCheckBox();
        txtDNI = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        txtPaterno = new javax.swing.JTextField();
        txtMaterno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        pnlContacto = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        pnlFoto = new javax.swing.JPanel();
        lblFoto = new javax.swing.JLabel();
        btnSubirFoto = new javax.swing.JButton();
        btnEliminarFoto = new javax.swing.JButton();
        pnlRol = new javax.swing.JPanel();
        pnlRolSelector = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        cboRol = new javax.swing.JComboBox<>();
        btnRolAgregar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAcceso = new org.jdesktop.swingx.JXTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new java.awt.BorderLayout());

        lblTitulo.setBackground(new java.awt.Color(204, 204, 255));
        lblTitulo.setFont(ESTILO5);
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Registrar nuevo autor");
        lblTitulo.setOpaque(true);
        jPanel1.add(lblTitulo, java.awt.BorderLayout.PAGE_START);

        btnGuardar.setFont(ESTILO6);
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save/Save_16x16.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jPanel3.add(btnGuardar);

        btnEditar.setFont(ESTILO6);
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit/Edit_16x16.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEditar);

        btnEliminar.setFont(ESTILO6);
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete/Delete_16x16.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel3.add(btnEliminar);

        btnCancelar.setFont(ESTILO6);
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancel/Cancel_16x16.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel3.add(btnCancelar);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pnlCuerpo.setLayout(new java.awt.BorderLayout(5, 5));

        pnlPersona.setBorder(javax.swing.BorderFactory.createTitledBorder("Información de usuario"));
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 3, 0};
        jPanel2Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        pnlPersona.setLayout(jPanel2Layout);

        jLabel2.setFont(ESTILO1);
        jLabel2.setText("DNI:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlPersona.add(jLabel2, gridBagConstraints);

        jLabel3.setFont(ESTILO1);
        jLabel3.setText("Nombre de usuario:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlPersona.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(ESTILO1);
        jLabel4.setText("Contraseña:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlPersona.add(jLabel4, gridBagConstraints);

        txtUsername.setFont(ESTILO2);
        txtUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsernameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlPersona.add(txtUsername, gridBagConstraints);

        txtPassword.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlPersona.add(txtPassword, gridBagConstraints);

        chkUsuarioActivo.setFont(ESTILO1);
        chkUsuarioActivo.setText("Usuario activo");
        jPanel4.add(chkUsuarioActivo);

        chkCambiarPassword.setFont(ESTILO1);
        chkCambiarPassword.setText("Cambiar contraseña al iniciar sesión");
        chkCambiarPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCambiarPasswordActionPerformed(evt);
            }
        });
        jPanel4.add(chkCambiarPassword);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.gridwidth = 3;
        pnlPersona.add(jPanel4, gridBagConstraints);

        txtDNI.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlPersona.add(txtDNI, gridBagConstraints);

        jLabel7.setFont(ESTILO1);
        jLabel7.setText("Nombres:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlPersona.add(jLabel7, gridBagConstraints);

        jLabel8.setFont(ESTILO1);
        jLabel8.setText("Ap. paterno:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlPersona.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(ESTILO1);
        jLabel9.setText("Ap. materno:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlPersona.add(jLabel9, gridBagConstraints);

        txtNombres.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlPersona.add(txtNombres, gridBagConstraints);

        txtPaterno.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlPersona.add(txtPaterno, gridBagConstraints);

        txtMaterno.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlPersona.add(txtMaterno, gridBagConstraints);

        jLabel1.setFont(ESTILO1);
        jLabel1.setText("E-mail:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlPersona.add(jLabel1, gridBagConstraints);

        txtEmail.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlPersona.add(txtEmail, gridBagConstraints);

        java.awt.GridBagLayout pnlContactoLayout = new java.awt.GridBagLayout();
        pnlContactoLayout.columnWidths = new int[] {0, 3, 0, 3, 0, 3, 0};
        pnlContactoLayout.rowHeights = new int[] {0};
        pnlContacto.setLayout(pnlContactoLayout);

        jLabel5.setFont(ESTILO1);
        jLabel5.setText("Teléfono fijo:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        pnlContacto.add(jLabel5, gridBagConstraints);

        txtTelefono.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        pnlContacto.add(txtTelefono, gridBagConstraints);

        jLabel10.setFont(ESTILO1);
        jLabel10.setText("Celular:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        pnlContacto.add(jLabel10, gridBagConstraints);

        txtCelular.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        pnlContacto.add(txtCelular, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlPersona.add(pnlContacto, gridBagConstraints);

        pnlCuerpo.add(pnlPersona, java.awt.BorderLayout.CENTER);

        pnlFoto.setLayout(new java.awt.GridBagLayout());

        lblFoto.setFont(ESTILO1);
        lblFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lblFoto.setMaximumSize(new java.awt.Dimension(200, 200));
        lblFoto.setMinimumSize(new java.awt.Dimension(200, 200));
        lblFoto.setPreferredSize(new java.awt.Dimension(200, 200));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlFoto.add(lblFoto, gridBagConstraints);

        btnSubirFoto.setFont(ESTILO1);
        btnSubirFoto.setText("Subir foto");
        btnSubirFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubirFotoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlFoto.add(btnSubirFoto, gridBagConstraints);

        btnEliminarFoto.setFont(ESTILO1);
        btnEliminarFoto.setText("Eliminar foto");
        btnEliminarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFotoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlFoto.add(btnEliminarFoto, gridBagConstraints);

        pnlCuerpo.add(pnlFoto, java.awt.BorderLayout.LINE_START);

        pnlRol.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nivel de acceso", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, ESTILO1));
        pnlRol.setLayout(new java.awt.BorderLayout());

        pnlRolSelector.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        jLabel6.setFont(ESTILO1);
        jLabel6.setText("Rol: ");
        pnlRolSelector.add(jLabel6);

        cboRol.setFont(ESTILO2);
        cboRol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Persona", "Institución" }));
        cboRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRolActionPerformed(evt);
            }
        });
        pnlRolSelector.add(cboRol);

        btnRolAgregar.setFont(ESTILO1);
        btnRolAgregar.setText("Nuevo");
        pnlRolSelector.add(btnRolAgregar);

        pnlRol.add(pnlRolSelector, java.awt.BorderLayout.NORTH);

        jScrollPane1.setMaximumSize(new java.awt.Dimension(200, 200));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(200, 100));

        tblAcceso.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAcceso.setFont(ESTILO2);
        jScrollPane1.setViewportView(tblAcceso);

        pnlRol.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlCuerpo.add(pnlRol, java.awt.BorderLayout.SOUTH);

        jPanel1.add(pnlCuerpo, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        volcarData(usuarioControlador.getSeleccionado());

        if (usuarioControlador.accion(accion)) {
            FormularioUtil.mensajeExito(this, accion);
            this.accionRealizada = true;
            this.dispose();

        } else {
            FormularioUtil.mensajeError(this, accion);
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        this.accion = MODIFICAR;
        inicializar(usuario, accion);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        this.accion = ELIMINAR;
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar este autor(a)?", "Mensaje del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (this.usuarioControlador.accion(accion)) {
                FormularioUtil.mensajeExito(this, accion);
                this.usuario = null;
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsernameActionPerformed

    private void chkCambiarPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCambiarPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkCambiarPasswordActionPerformed

    private void cboRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRolActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboRolActionPerformed

    private void btnSubirFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubirFotoActionPerformed
        // TODO add your handling code here:
        String ruta = FormularioUtil.chooserImagen(this);
        imagenSeleccionada = ImagenUtil.obtenerBytes(ruta);

        mostrarImagen(imagenSeleccionada);


    }//GEN-LAST:event_btnSubirFotoActionPerformed

    private void btnEliminarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFotoActionPerformed
        // TODO add your handling code here:
        this.imagenSeleccionada = null;
        this.usuario.getPersona().setFotografia(null);
        mostrarImagen(imagenSeleccionada);

    }//GEN-LAST:event_btnEliminarFotoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarFoto;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRolAgregar;
    private javax.swing.JButton btnSubirFoto;
    private javax.swing.JComboBox<String> cboRol;
    private javax.swing.JCheckBox chkCambiarPassword;
    private javax.swing.JCheckBox chkUsuarioActivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlContacto;
    private javax.swing.JPanel pnlCuerpo;
    private javax.swing.JPanel pnlFoto;
    private javax.swing.JPanel pnlPersona;
    private javax.swing.JPanel pnlRol;
    private javax.swing.JPanel pnlRolSelector;
    private org.jdesktop.swingx.JXTable tblAcceso;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaterno;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtPaterno;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables

    private void initComponents2() {
        usuarioControlador = UsuarioControlador.getInstance();
        rolControlador = RolControlador.getInstance();
        
        cargarRoles();
    }

    private void volcarData(Usuario seleccionado) {
        seleccionado.setActivo(chkUsuarioActivo.isSelected());
        seleccionado.setCambiarPassword(chkCambiarPassword.isSelected());
        seleccionado.setLogin(txtUsername.getText().trim());
        seleccionado.setPassword(new String(txtPassword.getPassword()));
//        seleccionado.setPersona(obtenerPersonaSeleccionada());
        seleccionado.setRol(obtenerRolSeleccionado());
        //data de persona
        FormularioUtil.convertirAMayusculas(txtNombres,txtPaterno,txtMaterno);
        System.out.println("Persona: "+seleccionado.getPersona());
        seleccionado.getPersona().setDni(txtDNI.getText());
        seleccionado.getPersona().setNombres(txtNombres.getText());
        seleccionado.getPersona().setPaterno(txtPaterno.getText());
        seleccionado.getPersona().setMaterno(txtMaterno.getText());
        seleccionado.getPersona().setCelular(txtCelular.getText());
        seleccionado.getPersona().setTelefono(txtTelefono.getText());
        seleccionado.getPersona().setEmail(txtEmail.getText());
        seleccionado.getPersona().setFotografia(imagenSeleccionada);
        if (this.accion == NUEVO) {
            seleccionado.setFechaHoraCreacion(new Date());
        } else if (this.accion == MODIFICAR) {
            seleccionado.setFechaHoraModificacion(new Date());
        }
    }

    private void inicializar(Usuario usuario, int accion) {
        switch (accion) {
            case NUEVO:
                lblTitulo.setText("Nuevo usuario");
                btnCancelar.setText("Cancelar");
                break;
            case MODIFICAR:
                lblTitulo.setText("Modificar usuario");
                btnCancelar.setText("Cancelar");
                break;
            case LEER:
                lblTitulo.setText("Información de usuario");
                btnCancelar.setText("Cerrar");
                break;
        }

        usuarioControlador.setSeleccionado(usuario);

        inicializarControles(accion);
        if (accion == MODIFICAR || accion == LEER) {
            llenarCampos(usuario);
        }

    }

    private void llenarCampos(Usuario usuario) {
        cboRol.setSelectedItem(usuario.getRol());
        txtUsername.setText(usuario.getLogin());
        txtPassword.setText(usuario.getPassword());        
        if (usuario.getPersona() != null) {
            mostrarPersona(usuario.getPersona());
        }
        chkUsuarioActivo.setSelected(usuario.isActivo());
        chkCambiarPassword.setSelected(usuario.isCambiarPassword());
    }

    private void inicializarControles(int accion) {
        boolean leer = accion == LEER;
        boolean leerModificar = accion == LEER || accion == MODIFICAR;
        boolean nuevoModificar = accion == NUEVO || accion == MODIFICAR;

        this.btnEditar.setVisible(accion == LEER);
        this.btnEliminar.setVisible(leerModificar);
        this.btnGuardar.setVisible(nuevoModificar);

        this.cboRol.setEnabled(!leer);
        this.txtUsername.setEditable(!leer);
        this.txtPassword.setEditable(!leer);

        this.txtDNI.setEditable(!leer);
        this.txtNombres.setEditable(!leer);
        this.txtPaterno.setEditable(!leer);
        this.txtMaterno.setEditable(!leer);
        this.txtEmail.setEditable(!leer);
        this.txtTelefono.setEditable(!leer);
        this.txtCelular.setEditable(!leer);

        this.btnSubirFoto.setVisible(!leer);
        this.btnEliminarFoto.setVisible(!leer);
        this.btnRolAgregar.setVisible(!leer);

        this.chkCambiarPassword.setEnabled(!leer);
        this.chkUsuarioActivo.setEnabled(!leer);

    }

    @Override
    public void crud(boolean create, boolean read, boolean update, boolean delete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    private Persona obtenerPersonaSeleccionada() {
//        return this.personaSeleccionada;
//    }

    private Rol obtenerRolSeleccionado() {
        return (Rol) cboRol.getSelectedItem();
    }

    private void mostrarPersona(Persona persona) {
        txtDNI.setText(persona.getDni());
        txtNombres.setText(persona.getNombres());
        txtPaterno.setText(persona.getPaterno());
        txtMaterno.setText(persona.getMaterno());
        txtEmail.setText(persona.getEmail());
        txtTelefono.setText(persona.getTelefono());
        txtEmail.setText(persona.getEmail());
        mostrarImagen(persona.getFotografia());
    }

    private void mostrarImagen(byte[] imagen) {
        if (imagen == null) {
            lblFoto.setIcon(null);
        } else {
            FormularioUtil.imagenALabel(imagen, lblFoto);
//            ImageIcon imagenOriginal = ImagenUtil.obtenerImagen(imagenByte);
//            lblFoto.setIcon(new ImageIcon(imagenOriginal.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_SMOOTH)));
        }
    }

    private void cargarRoles() {
        List<Rol> rolList = rolControlador.buscarTodos();
        JComboBoxBinding bindeoCombo = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, rolList, cboRol);
        bindeoCombo.bind();
        
        cboRol.setRenderer(new AbstractListCellRenderer<Rol>() {
            @Override
            public String getTexto(Rol value) {
                return value.getNombre();
            }

            @Override
            public ImageIcon getIcono(Rol value) {
                return null;
            }
        });
    }
}
