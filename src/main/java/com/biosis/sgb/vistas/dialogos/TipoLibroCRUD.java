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
import com.biosis.sgb.controlador.AutorControlador;
import static com.biosis.sgb.controlador.Controlador.ELIMINAR;
import static com.biosis.sgb.controlador.Controlador.LEER;
import static com.biosis.sgb.controlador.Controlador.MODIFICAR;
import static com.biosis.sgb.controlador.Controlador.NUEVO;
import com.biosis.sgb.controlador.TipoLibroControlador;
import com.biosis.sgb.entidades.Autor;
import com.biosis.sgb.entidades.TipoLibro;
import com.personal.utiles.FormularioUtil;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Francis
 */
public class TipoLibroCRUD extends javax.swing.JDialog {

    /**
     * Creates new form AutorCRUD
     */
    private TipoLibroControlador tipoLibroControlador;
    private int accion;
    private boolean accionRealizada = false;
    private TipoLibro tipoLibro;

    public TipoLibro getTipoLibro() {
        return tipoLibro;
    }

    public boolean isAccionRealizada() {
        return accionRealizada;
    }

    public TipoLibroCRUD(java.awt.Frame parent, boolean modal, int accion, Autor autor) {
        super(parent, modal);
        initComponents();
        initComponents2();
    }

    public TipoLibroCRUD(Component component, boolean modal, int accion, TipoLibro tipoLibro) {
        super(JOptionPane.getFrameForComponent(component), modal);
        initComponents();
        initComponents2();
        this.tipoLibro = tipoLibro;
        this.accion = accion;
        inicializar(tipoLibro, accion);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setLayout(new java.awt.BorderLayout());

        lblTitulo.setBackground(new java.awt.Color(204, 204, 255));
        lblTitulo.setFont(ESTILO5);
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Registrar nuevo autor");
        lblTitulo.setOpaque(true);
        jPanel1.add(lblTitulo, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        java.awt.GridBagLayout jPanel2Layout = new java.awt.GridBagLayout();
        jPanel2Layout.columnWidths = new int[] {0, 3, 0, 3, 0, 3, 0, 3, 0};
        jPanel2Layout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        jPanel2.setLayout(jPanel2Layout);

        jLabel3.setFont(ESTILO1);
        jLabel3.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(ESTILO1);
        jLabel4.setText("Descripción:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel4, gridBagConstraints);

        txtNombre.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(txtNombre, gridBagConstraints);

        txtDescripcion.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(txtDescripcion, gridBagConstraints);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        volcarData(tipoLibroControlador.getSeleccionado());

        if (tipoLibroControlador.accion(accion)) {
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
        inicializar(tipoLibro, accion);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        this.accion = ELIMINAR;
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar este autor(a)?", "Mensaje del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (this.tipoLibroControlador.accion(accion)) {
                FormularioUtil.mensajeExito(this, accion);
                this.tipoLibro = null;
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    private void initComponents2() {
        tipoLibroControlador = TipoLibroControlador.getInstance();
    }

    private void volcarData(TipoLibro seleccionado) {
        FormularioUtil.convertirAMayusculas(txtNombre, txtDescripcion);
        seleccionado.setActivo(true);
        seleccionado.setNombre(txtNombre.getText());
        seleccionado.setDescripcion(txtDescripcion.getText());
        if (this.accion == NUEVO) {
            seleccionado.setFechaHoraCreacion(new Date());
        } else if (this.accion == MODIFICAR) {
            seleccionado.setFechaHoraModificacion(new Date());
        }
    }

    private void inicializar(TipoLibro tipoLibro, int accion) {
        switch (accion) {
            case NUEVO:

                lblTitulo.setText("Registrar tipo libro");
                btnCancelar.setText("Cancelar");
                break;
            case MODIFICAR:
                lblTitulo.setText("Modificar inf. de tipo de libro");
                btnCancelar.setText("Cancelar");
                break;
//            case LEER:
//                lblTitulo.setText("Ver inf. de autor");
//                btnCancelar.setText("Cerrar");
//                break;
        }

        tipoLibroControlador.setSeleccionado(tipoLibro);

        inicializarControles(accion);
        if (accion == MODIFICAR || accion == LEER) {
            llenarCampos(tipoLibro);
        }

    }

    private void llenarCampos(TipoLibro tipoLibro) {
        txtNombre.setText(tipoLibro.getNombre());
        txtDescripcion.setText(tipoLibro.getDescripcion());
    }

    private void inicializarControles(int accion) {
        boolean leer = accion == LEER;
        boolean leerModificar = accion == LEER || accion == MODIFICAR;
        boolean nuevoModificar = accion == NUEVO || accion == MODIFICAR;

        this.btnEditar.setVisible(accion == LEER);
        this.btnEliminar.setVisible(leerModificar);
        this.btnGuardar.setVisible(nuevoModificar);

        this.txtNombre.setEditable(!leer);
        this.txtDescripcion.setEditable(!leer);
    }
}
