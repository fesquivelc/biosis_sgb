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
import com.biosis.sgb.controlador.MateriaControlador;
import com.biosis.sgb.entidades.Autor;
import com.biosis.sgb.entidades.Materia;
import com.biosis.sgb.entidades.Seccion;
import com.personal.utiles.FormularioUtil;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author Francis
 */
public class MateriaSeccionCRUD extends javax.swing.JDialog {

    /**
     * Creates new form AutorCRUD
     */
    private MateriaControlador materiaControlador;
    private int accion;
    private int accionSeccion;
    private boolean accionRealizada = false;
    private Materia materia;
    private Seccion seccion;

    private List<Seccion> seccionList;

    public Materia getMateria() {
        return materia;
    }

    public boolean isAccionRealizada() {
        return accionRealizada;
    }

    public MateriaSeccionCRUD(java.awt.Frame parent, boolean modal, int accion, Autor autor) {
        super(parent, modal);
        initComponents();
        initComponents2();
    }

    public MateriaSeccionCRUD(Component component, boolean modal, int accion, Materia materia) {
        super(JOptionPane.getFrameForComponent(component), modal);
        initComponents();
        initComponents2();
        this.materia = materia;
        this.accion = accion;
        inicializar(materia, accion);
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
        txtMateriaNombre = new javax.swing.JTextField();
        txtMateriaDescripcion = new javax.swing.JTextField();
        pnlSeccion = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSeccionesList = new org.jdesktop.swingx.JXTable();
        pnlSeccionInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtSeccionNombre = new javax.swing.JTextField();
        txtSeccionDescripcion = new javax.swing.JTextField();
        pnlSeccionGuardarCancelar = new javax.swing.JPanel();
        btnSeccionGuardar = new javax.swing.JButton();
        btnSeccionCancelar = new javax.swing.JButton();
        pnlSeccionAcciones = new javax.swing.JPanel();
        btnSeccionNuevo = new javax.swing.JButton();
        btnSeccionEditar = new javax.swing.JButton();
        btnSeccionEliminar = new javax.swing.JButton();
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
        jPanel2Layout.columnWidths = new int[] {0, 3, 0};
        jPanel2Layout.rowHeights = new int[] {0, 5, 0, 5, 0};
        jPanel2.setLayout(jPanel2Layout);

        jLabel3.setFont(ESTILO1);
        jLabel3.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(ESTILO1);
        jLabel4.setText("Descripción:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel2.add(jLabel4, gridBagConstraints);

        txtMateriaNombre.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(txtMateriaNombre, gridBagConstraints);

        txtMateriaDescripcion.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        jPanel2.add(txtMateriaDescripcion, gridBagConstraints);

        pnlSeccion.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Secciones", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, ESTILO1));
        pnlSeccion.setLayout(new java.awt.BorderLayout(0, 5));

        tblSeccionesList.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSeccionesList.setFont(ESTILO2);
        tblSeccionesList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSeccionesListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSeccionesList);

        pnlSeccion.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        java.awt.GridBagLayout pnlSeccionInfoLayout = new java.awt.GridBagLayout();
        pnlSeccionInfoLayout.columnWidths = new int[] {0, 3, 0, 3, 0};
        pnlSeccionInfoLayout.rowHeights = new int[] {0, 3, 0};
        pnlSeccionInfo.setLayout(pnlSeccionInfoLayout);

        jLabel1.setFont(ESTILO1);
        jLabel1.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlSeccionInfo.add(jLabel1, gridBagConstraints);

        jLabel2.setFont(ESTILO1);
        jLabel2.setText("Descripción:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlSeccionInfo.add(jLabel2, gridBagConstraints);

        txtSeccionNombre.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlSeccionInfo.add(txtSeccionNombre, gridBagConstraints);

        txtSeccionDescripcion.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 0.1;
        pnlSeccionInfo.add(txtSeccionDescripcion, gridBagConstraints);

        pnlSeccionGuardarCancelar.setLayout(new java.awt.GridLayout(0, 1));

        btnSeccionGuardar.setFont(ESTILO1);
        btnSeccionGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Save/Save_16x16.png"))); // NOI18N
        btnSeccionGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeccionGuardarActionPerformed(evt);
            }
        });
        pnlSeccionGuardarCancelar.add(btnSeccionGuardar);

        btnSeccionCancelar.setFont(ESTILO1);
        btnSeccionCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Cancel/Cancel_16x16.png"))); // NOI18N
        btnSeccionCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeccionCancelarActionPerformed(evt);
            }
        });
        pnlSeccionGuardarCancelar.add(btnSeccionCancelar);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlSeccionInfo.add(pnlSeccionGuardarCancelar, gridBagConstraints);

        pnlSeccion.add(pnlSeccionInfo, java.awt.BorderLayout.PAGE_START);

        pnlSeccionAcciones.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 0));

        btnSeccionNuevo.setFont(ESTILO1);
        btnSeccionNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add/Add_16x16.png"))); // NOI18N
        btnSeccionNuevo.setText("Añadir sección");
        btnSeccionNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeccionNuevoActionPerformed(evt);
            }
        });
        pnlSeccionAcciones.add(btnSeccionNuevo);

        btnSeccionEditar.setFont(ESTILO1);
        btnSeccionEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit/Edit_16x16.png"))); // NOI18N
        btnSeccionEditar.setText("Editar sección");
        btnSeccionEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeccionEditarActionPerformed(evt);
            }
        });
        pnlSeccionAcciones.add(btnSeccionEditar);

        btnSeccionEliminar.setFont(ESTILO1);
        btnSeccionEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete/Delete_16x16.png"))); // NOI18N
        btnSeccionEliminar.setText("Eliminar sección");
        btnSeccionEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeccionEliminarActionPerformed(evt);
            }
        });
        pnlSeccionAcciones.add(btnSeccionEliminar);

        pnlSeccion.add(pnlSeccionAcciones, java.awt.BorderLayout.PAGE_END);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel2.add(pnlSeccion, gridBagConstraints);

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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        volcarData(materiaControlador.getSeleccionado());

        if (materiaControlador.accion(accion)) {
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
        inicializar(materia, accion);
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        this.accion = ELIMINAR;
        if (JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar este autor(a)?", "Mensaje del sistema", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            if (this.materiaControlador.accion(accion)) {
                FormularioUtil.mensajeExito(this, accion);
                this.materia = null;
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblSeccionesListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSeccionesListMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 1) {
            int fila = tblSeccionesList.getSelectedRow();
            if (fila != -1) {
                this.accionSeccion = LEER;
                seccionInicializar(seccion, accionSeccion);
            }

        }
    }//GEN-LAST:event_tblSeccionesListMouseClicked

    private void btnSeccionNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeccionNuevoActionPerformed
        // TODO add your handling code here:
        this.accionSeccion = NUEVO;
        this.seccionInicializar(new Seccion(), accionSeccion);
    }//GEN-LAST:event_btnSeccionNuevoActionPerformed

    private void btnSeccionEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeccionEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeccionEliminarActionPerformed

    private void btnSeccionEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeccionEditarActionPerformed
        // TODO add your handling code here:
        int filaSeccion = tblSeccionesList.getSelectedRow();
        if (filaSeccion != -1) {
            this.accionSeccion = MODIFICAR;
            Seccion seccionSeleccionada = materia.getSeccionList().get(filaSeccion);
            this.seccionInicializar(seccionSeleccionada, accionSeccion);
        }

    }//GEN-LAST:event_btnSeccionEditarActionPerformed

    private void btnSeccionGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeccionGuardarActionPerformed
        // TODO add your handling code here:
        volcarDataSeccion(seccion);
        int filaSeccion;
        if (this.accionSeccion == NUEVO) {
            this.seccionList.add(seccion);
            this.materia.getSeccionList().add(seccion);
            filaSeccion = seccionList.size() - 1;
        } else {
            filaSeccion = seccionList.indexOf(seccion);
            this.seccionList.set(filaSeccion, seccion);
        }
        tblSeccionesList.setRowSelectionInterval(filaSeccion, filaSeccion);
        this.accionSeccion = LEER;
        seccionInicializar(seccion, accionSeccion);


    }//GEN-LAST:event_btnSeccionGuardarActionPerformed

    private void btnSeccionCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeccionCancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSeccionCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnSeccionCancelar;
    private javax.swing.JButton btnSeccionEditar;
    private javax.swing.JButton btnSeccionEliminar;
    private javax.swing.JButton btnSeccionGuardar;
    private javax.swing.JButton btnSeccionNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlSeccion;
    private javax.swing.JPanel pnlSeccionAcciones;
    private javax.swing.JPanel pnlSeccionGuardarCancelar;
    private javax.swing.JPanel pnlSeccionInfo;
    private org.jdesktop.swingx.JXTable tblSeccionesList;
    private javax.swing.JTextField txtMateriaDescripcion;
    private javax.swing.JTextField txtMateriaNombre;
    private javax.swing.JTextField txtSeccionDescripcion;
    private javax.swing.JTextField txtSeccionNombre;
    // End of variables declaration//GEN-END:variables

    private void initComponents2() {
        materiaControlador = MateriaControlador.getInstance();
        seccionList = ObservableCollections.observableList(new ArrayList<Seccion>());

        /*
        Bindeo salvaje
         */
        BindingGroup bindeo = new BindingGroup();
        BeanProperty pNombre = BeanProperty.create("nombre");
        BeanProperty pDescripcion = BeanProperty.create("descripcion");
        JTableBinding bindeoSeccion = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, seccionList, tblSeccionesList);
        bindeoSeccion.addColumnBinding(pNombre).setColumnName("Sección").setEditable(false);
        bindeoSeccion.addColumnBinding(pDescripcion).setColumnName("Descripción").setEditable(false);
        bindeo.addBinding(bindeoSeccion);
        bindeo.bind();

    }

    private void volcarData(Materia seleccionado) {
        seleccionado.setActivo(true);
        seleccionado.setNombre(txtMateriaNombre.getText());
        seleccionado.setDescripcion(txtMateriaDescripcion.getText());
        if (this.accion == NUEVO) {
            seleccionado.setFechaHoraCreacion(new Date());
        } else if (this.accion == MODIFICAR) {
            seleccionado.setFechaHoraModificacion(new Date());
        }
    }

    private void inicializar(Materia materia, int accion) {

        switch (accion) {
            case NUEVO:

                lblTitulo.setText("Registro de materias y secciones");
                btnCancelar.setText("Cancelar");
                break;
            case MODIFICAR:
                lblTitulo.setText("Modificar inf. de materias y secciones");
                btnCancelar.setText("Cancelar");
                break;
            case LEER:
                lblTitulo.setText("Ver inf. de materias y secciones");
                btnCancelar.setText("Cerrar");
                break;
        }

        materiaControlador.setSeleccionado(materia);

        inicializarControles(accion);
        if (accion == MODIFICAR || accion == LEER) {
            llenarCampos(materia);
        }

    }

    private void seccionInicializar(Seccion seccion, int accionSeccion) {
        switch (accionSeccion) {
            case NUEVO:
                ((TitledBorder) pnlSeccion.getBorder()).setTitle("Nueva sección");
                break;
            case MODIFICAR:
                ((TitledBorder) pnlSeccion.getBorder()).setTitle("Modificar sección");
                break;
            case LEER:
                ((TitledBorder) pnlSeccion.getBorder()).setTitle("Secciones");
                break;
        }

        this.seccion = seccion;

        seccionInicializarControles(accionSeccion);
        if (accionSeccion == MODIFICAR || accionSeccion == LEER) {
            seccionLlenarCampos(this.seccion);
        }
    }

    private void llenarCampos(Materia materia) {
        txtMateriaNombre.setText(materia.getNombre());
        txtMateriaDescripcion.setText(materia.getDescripcion());

        seccionList.clear();
        seccionList.addAll(materia.getSeccionList());
    }

    private void inicializarControles(int accion) {
        boolean leer = accion == LEER;
        boolean leerModificar = accion == LEER || accion == MODIFICAR;
        boolean nuevoModificar = accion == NUEVO || accion == MODIFICAR;

        this.btnEditar.setVisible(accion == LEER);
        this.btnEliminar.setVisible(leerModificar);
        this.btnGuardar.setVisible(nuevoModificar);

        this.txtMateriaNombre.setEditable(!leer);
        this.txtMateriaDescripcion.setEditable(!leer);

        this.pnlSeccionGuardarCancelar.setVisible(false);
        this.pnlSeccionAcciones.setVisible(!leer);
    }

    private void seccionInicializarControles(int accion) {
        boolean leer = accion == LEER;
        boolean leerModificar = accion == LEER || accion == MODIFICAR;
        boolean nuevoModificar = accion == NUEVO || accion == MODIFICAR;

        this.btnSeccionNuevo.setVisible(leer);
        this.btnSeccionEditar.setVisible(accion == LEER);
        this.btnSeccionEliminar.setVisible(leerModificar);
        this.pnlSeccionGuardarCancelar.setVisible(nuevoModificar);

        this.txtMateriaNombre.setEditable(!leer);
        this.txtMateriaDescripcion.setEditable(!leer);

        if (accion == NUEVO) {
            this.txtSeccionNombre.setText("");
            this.txtSeccionDescripcion.setText("");
        }

    }

    private void mostrarSeccion(Seccion seccion) {
        txtSeccionNombre.setText(seccion.getNombre());
        txtSeccionDescripcion.setText(seccion.getDescripcion());
    }

    private void seccionLlenarCampos(Seccion seccion) {
        txtSeccionNombre.setText(seccion.getNombre());
        txtSeccionDescripcion.setText(seccion.getDescripcion());
    }

    private void volcarDataSeccion(Seccion seccion) {
        seccion.setNombre(txtSeccionNombre.getText());
        seccion.setDescripcion(txtSeccionDescripcion.getText());
        seccion.setMateria(materia);
        if (this.accionSeccion == NUEVO) {
            seccion.setFechaHoraCreacion(new Date());

        } else {
            seccion.setFechaHoraModificacion(new Date());

        }

        this.tblSeccionesList.packAll();

    }
}
