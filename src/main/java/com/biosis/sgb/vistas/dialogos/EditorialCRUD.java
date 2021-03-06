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
import com.biosis.sgb.controlador.EditorialControlador;
import com.biosis.sgb.entidades.Autor;
import com.biosis.sgb.entidades.Editorial;
import com.personal.utiles.FormularioUtil;
import java.awt.Component;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Francis
 */
public class EditorialCRUD extends javax.swing.JDialog {

    /**
     * Creates new form AutorCRUD
     */
    private EditorialControlador editorialControlador;
    private int accion;
    private boolean accionRealizada = false;
    private Editorial editorial;

    public Editorial getEditorial() {
        return editorial;
    }

    public boolean isAccionRealizada() {
        return accionRealizada;
    }

    public EditorialCRUD(java.awt.Frame parent, boolean modal, int accion, Autor autor) {
        super(parent, modal);
        initComponents();
        initComponents2();
    }

    public EditorialCRUD(Component component, boolean modal, int accion, Editorial editorial) {
        super(JOptionPane.getFrameForComponent(component), modal);
        initComponents();
        initComponents2();
        this.editorial = editorial;
        this.accion = accion;
        inicializar(editorial, accion);
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
        txtNombres = new javax.swing.JTextField();
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
        lblTitulo.setText("Registrar nueva editorial");
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

        txtNombres.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(txtNombres, gridBagConstraints);

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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        volcarData(editorialControlador.getSeleccionado());

        if (editorialControlador.accion(accion)) {
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
        inicializar(editorial, accion);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        this.accion = ELIMINAR;
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar este autor(a)?", "Mensaje del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (this.editorialControlador.accion(accion)) {
                FormularioUtil.mensajeExito(this, accion);
                this.editorial = null;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JTextField txtNombres;
    // End of variables declaration//GEN-END:variables

    private void initComponents2() {
        editorialControlador = EditorialControlador.getInstance();
    }

    private void volcarData(Editorial seleccionado) {
        FormularioUtil.convertirAMayusculas(txtNombres);
        seleccionado.setActivo(true);
//        seleccionado.setTipoAutor(cboTipoAutor.getSelectedIndex() + 1);
        seleccionado.setNombre(txtNombres.getText());
//        seleccionado.setPaterno(txtPaterno.getText());
//        seleccionado.setMaterno(txtMaterno.getText());
        if(this.accion == NUEVO){
            seleccionado.setFechaHoraCreacion(new Date());
        }else if(this.accion == MODIFICAR){
            seleccionado.setFechaHoraModificacion(new Date());
        }
    }
    
    private void inicializar(Editorial editorial, int accion) {
        switch (accion) {
            case NUEVO:
                
                lblTitulo.setText("Registrar editorial");
                btnCancelar.setText("Cancelar");
                break;
            case MODIFICAR:
                lblTitulo.setText("Modificar inf. de editorial");
                btnCancelar.setText("Cancelar");
                break;
            case LEER:
                lblTitulo.setText("Ver inf. de editorial");
                btnCancelar.setText("Cerrar");
                break;
        }

        editorialControlador.setSeleccionado(editorial);
        
        inicializarControles(accion);
        if (accion == MODIFICAR || accion == LEER) {
            llenarCampos(editorial);
        }

    }

    private void llenarCampos(Editorial editorial) {
//        cboTipoAutor.setSelectedIndex(autor.getTipoAutor() - 1);
        txtNombres.setText(editorial.getNombre());
//        txtPaterno.setText(autor.getPaterno());
//        txtMaterno.setText(autor.getMaterno());
    }
    
    private void inicializarControles(int accion){
        boolean leer = accion == LEER;
        boolean leerModificar = accion == LEER || accion == MODIFICAR;
        boolean nuevoModificar = accion == NUEVO || accion == MODIFICAR;

        this.btnEditar.setVisible(accion == LEER);
        this.btnEliminar.setVisible(leerModificar);
        this.btnGuardar.setVisible(nuevoModificar);
        
//        this.cboTipoAutor.setEnabled(!leer);
        this.txtNombres.setEditable(!leer);
//        this.txtPaterno.setEditable(!leer);
//        this.txtMaterno.setEditable(!leer);
    }
}
