/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.vistas;

import static com.biosis.sgb.Application.ESTILO1;
import static com.biosis.sgb.Application.ESTILO2;
import static com.biosis.sgb.Application.ESTILO5;
import static com.biosis.sgb.Application.ESTILO7;
import com.biosis.sgb.controlador.PrestamoControlador;
import com.biosis.sgb.entidades.Libro;
import com.biosis.sgb.entidades.Persona;
import com.biosis.sgb.entidades.Prestamo;
import com.biosis.sgb.vistas.dialogos.PersonaSelect;
import com.personal.utiles.FormularioUtil;
import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableCellRenderer;
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
public class PrestamoView extends javax.swing.JPanel {

    private final PrestamoControlador prestamoControlador;
//    private Autor autorSeleccionado;
//    private Editorial editorialSeleccionada;
    /*
    Controles de navegacion
     */
    private Persona personaSeleccionada;
    private Libro libroSeleccionado;

    private int paginaActual = 1;
    private int totalPaginas = 0;
    private int tamanioPagina = 0;

    private List<Prestamo> prestamoList;

    public PrestamoView() {
        initComponents();
        initComponents2();
        this.prestamoControlador = PrestamoControlador.getInstance();
        Busqueda busqueda = new Busqueda();
        busqueda.execute();
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

        grupoOpcionesBusqueda = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnlBusqueda = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        lblEspere = new org.jdesktop.swingx.JXBusyLabel();
        radPersona = new javax.swing.JRadioButton();
        radLibro = new javax.swing.JRadioButton();
        chkEntreFechas = new javax.swing.JCheckBox();
        chkPendienteDevolucion = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        txtPersona = new javax.swing.JTextField();
        btnPersona = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        txtLibro = new javax.swing.JTextField();
        btnLibro = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        dcFechaInicio = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        dcFechaFin = new com.toedter.calendar.JDateChooser();
        pnlAcciones = new javax.swing.JPanel();
        btnVer = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        pnlListado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPrestamoList = new org.jdesktop.swingx.JXTable();
        pnlNavegacion2 = new javax.swing.JPanel();
        btnPrimero2 = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        spPagina = new javax.swing.JSpinner();
        txtTotal = new javax.swing.JTextField();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        cboTamanio = new javax.swing.JComboBox();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(ESTILO5);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Préstamos y devoluciones");
        jLabel1.setOpaque(true);
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        pnlBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parámetros de búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, ESTILO1));
        java.awt.GridBagLayout pnlBusquedaLayout = new java.awt.GridBagLayout();
        pnlBusquedaLayout.columnWidths = new int[] {0, 5, 0};
        pnlBusquedaLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0};
        pnlBusqueda.setLayout(pnlBusquedaLayout);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 0, 5));

        btnBuscar.setFont(ESTILO1);
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Find/Find_16x16.png"))); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar);

        lblEspere.setText("Cargando resultados...");
        lblEspere.setFont(ESTILO1);
        jPanel2.add(lblEspere);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlBusqueda.add(jPanel2, gridBagConstraints);

        radPersona.setFont(ESTILO1);
        radPersona.setSelected(true);
        radPersona.setText("Persona:");
        radPersona.setOpaque(false);
        radPersona.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radPersonaStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlBusqueda.add(radPersona, gridBagConstraints);

        radLibro.setFont(ESTILO1);
        radLibro.setText("Libro:");
        radLibro.setOpaque(false);
        radLibro.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                radLibroStateChanged(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlBusqueda.add(radLibro, gridBagConstraints);

        chkEntreFechas.setFont(ESTILO1);
        chkEntreFechas.setText("Entre fechas:");
        chkEntreFechas.setOpaque(false);
        chkEntreFechas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkEntreFechasStateChanged(evt);
            }
        });
        chkEntreFechas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkEntreFechasActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlBusqueda.add(chkEntreFechas, gridBagConstraints);

        chkPendienteDevolucion.setFont(ESTILO1);
        chkPendienteDevolucion.setText("Devolución pendiente");
        chkPendienteDevolucion.setOpaque(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlBusqueda.add(chkPendienteDevolucion, gridBagConstraints);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new java.awt.GridBagLayout());

        txtPersona.setEditable(false);
        txtPersona.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel3.add(txtPersona, gridBagConstraints);
        txtPersona.setBorder(null);

        btnPersona.setBackground(new java.awt.Color(204, 204, 255));
        btnPersona.setFont(ESTILO1);
        btnPersona.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search/Search_16x16.png"))); // NOI18N
        btnPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.1;
        jPanel3.add(btnPersona, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        pnlBusqueda.add(jPanel3, gridBagConstraints);

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new java.awt.GridBagLayout());

        txtLibro.setEditable(false);
        txtLibro.setFont(ESTILO2);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(txtLibro, gridBagConstraints);
        txtLibro.setBorder(null);

        btnLibro.setFont(ESTILO1);
        btnLibro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Search/Search_16x16.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weighty = 0.1;
        jPanel4.add(btnLibro, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlBusqueda.add(jPanel4, gridBagConstraints);

        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        dcFechaInicio.setFont(ESTILO2);
        jPanel5.add(dcFechaInicio);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(ESTILO1);
        jLabel2.setText("  Al  ");
        jLabel2.setOpaque(true);
        jPanel5.add(jLabel2);

        dcFechaFin.setFont(ESTILO2);
        jPanel5.add(dcFechaFin);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlBusqueda.add(jPanel5, gridBagConstraints);

        jPanel1.add(pnlBusqueda, java.awt.BorderLayout.PAGE_START);

        pnlAcciones.setBackground(new java.awt.Color(255, 255, 255));

        btnVer.setFont(ESTILO7       );
        btnVer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Information/Information_24x24.png"))); // NOI18N
        btnVer.setText("Ver información");
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });
        pnlAcciones.add(btnVer);

        btnNuevo.setFont(ESTILO7       );
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add/Add_24x24.png"))); // NOI18N
        btnNuevo.setText("Registrar préstamo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlAcciones.add(btnNuevo);

        btnModificar.setFont(ESTILO7       );
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit/Edit_24x24.png"))); // NOI18N
        btnModificar.setText("Registrar devolución");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        pnlAcciones.add(btnModificar);

        btnEliminar.setFont(ESTILO7       );
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete/Delete_24x24.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        pnlAcciones.add(btnEliminar);

        jPanel1.add(pnlAcciones, java.awt.BorderLayout.PAGE_END);

        pnlListado.setBackground(new java.awt.Color(255, 255, 255));
        pnlListado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, ESTILO1        ));
        pnlListado.setLayout(new java.awt.BorderLayout());

        tblPrestamoList.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPrestamoList.setFont(ESTILO2);
        tblPrestamoList.setRowHeight(20);
        jScrollPane1.setViewportView(tblPrestamoList);

        pnlListado.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlNavegacion2.setBackground(new java.awt.Color(255, 255, 255));
        pnlNavegacion2.setLayout(new java.awt.GridBagLayout());

        btnPrimero2.setText("<<");
        btnPrimero2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrimero2ActionPerformed(evt);
            }
        });
        pnlNavegacion2.add(btnPrimero2, new java.awt.GridBagConstraints());

        btnAnterior.setText("<");
        btnAnterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnteriorActionPerformed(evt);
            }
        });
        pnlNavegacion2.add(btnAnterior, new java.awt.GridBagConstraints());

        spPagina.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spPagina.setMinimumSize(new java.awt.Dimension(60, 20));
        spPagina.setPreferredSize(new java.awt.Dimension(60, 20));
        spPagina.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spPaginaStateChanged(evt);
            }
        });
        pnlNavegacion2.add(spPagina, new java.awt.GridBagConstraints());

        txtTotal.setEditable(false);
        txtTotal.setColumns(3);
        txtTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txtTotal.setText("1");
        pnlNavegacion2.add(txtTotal, new java.awt.GridBagConstraints());

        btnSiguiente.setText(">");
        btnSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSiguienteActionPerformed(evt);
            }
        });
        pnlNavegacion2.add(btnSiguiente, new java.awt.GridBagConstraints());

        btnUltimo.setText(">>");
        btnUltimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimoActionPerformed(evt);
            }
        });
        pnlNavegacion2.add(btnUltimo, new java.awt.GridBagConstraints());

        cboTamanio.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "5", "10", "15", "20", "25", "40", "50" }));
        cboTamanio.setMinimumSize(new java.awt.Dimension(53, 24));
        cboTamanio.setPreferredSize(new java.awt.Dimension(53, 24));
        cboTamanio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTamanioActionPerformed(evt);
            }
        });
        pnlNavegacion2.add(cboTamanio, new java.awt.GridBagConstraints());

        pnlListado.add(pnlNavegacion2, java.awt.BorderLayout.SOUTH);

        jPanel1.add(pnlListado, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrimero2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrimero2ActionPerformed
        // TODO add your handling code here:
        primero();
    }//GEN-LAST:event_btnPrimero2ActionPerformed

    private void btnAnteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnteriorActionPerformed
        // TODO add your handling code here:
        anterior();
    }//GEN-LAST:event_btnAnteriorActionPerformed

    private void spPaginaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spPaginaStateChanged
        // TODO add your handling code here:
        this.seleccionPagina();
    }//GEN-LAST:event_spPaginaStateChanged

    private void btnSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSiguienteActionPerformed
        // TODO add your handling code here:
        siguiente();
    }//GEN-LAST:event_btnSiguienteActionPerformed

    private void btnUltimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimoActionPerformed
        // TODO add your handling code here:
        ultimo();
    }//GEN-LAST:event_btnUltimoActionPerformed

    private void cboTamanioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTamanioActionPerformed
        // TODO add your handling code here:
        this.paginaActual = 1;
        buscar();
        this.actualizarControlesNavegacion();
    }//GEN-LAST:event_cboTamanioActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        Busqueda busqueda = new Busqueda();
        busqueda.execute();
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
//        AutorCRUD autorCRUD = new AutorCRUD(this, true);
//        autorCRUD.setVisible(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarActionPerformed

    private void chkEntreFechasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkEntreFechasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkEntreFechasActionPerformed

    private void chkEntreFechasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkEntreFechasStateChanged
        // TODO add your handling code here:
        opcionesBusqueda();
    }//GEN-LAST:event_chkEntreFechasStateChanged

    private void radPersonaStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radPersonaStateChanged
        // TODO add your handling code here:
        opcionesBusqueda();
    }//GEN-LAST:event_radPersonaStateChanged

    private void radLibroStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_radLibroStateChanged
        // TODO add your handling code here:
        opcionesBusqueda();
    }//GEN-LAST:event_radLibroStateChanged

    private void btnPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonaActionPerformed
        // TODO add your handling code here:
        PersonaSelect personaSelect = new PersonaSelect(this, true);
        personaSelect.setVisible(true);
        this.personaSeleccionada = personaSelect.getPersona();

        if (this.personaSeleccionada != null) {
            mostrarPersona(this.personaSeleccionada);
        }
    }//GEN-LAST:event_btnPersonaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnLibro;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnPersona;
    private javax.swing.JButton btnPrimero2;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JButton btnVer;
    private javax.swing.JComboBox cboTamanio;
    private javax.swing.JCheckBox chkEntreFechas;
    private javax.swing.JCheckBox chkPendienteDevolucion;
    private com.toedter.calendar.JDateChooser dcFechaFin;
    private com.toedter.calendar.JDateChooser dcFechaInicio;
    private javax.swing.ButtonGroup grupoOpcionesBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXBusyLabel lblEspere;
    private javax.swing.JPanel pnlAcciones;
    private javax.swing.JPanel pnlBusqueda;
    private javax.swing.JPanel pnlListado;
    private javax.swing.JPanel pnlNavegacion2;
    private javax.swing.JRadioButton radLibro;
    private javax.swing.JRadioButton radPersona;
    private javax.swing.JSpinner spPagina;
    private org.jdesktop.swingx.JXTable tblPrestamoList;
    private javax.swing.JTextField txtLibro;
    private javax.swing.JTextField txtPersona;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void initComponents2() {
        lblEspere.setVisible(false);
        grupoOpcionesBusqueda.add(radPersona);
        grupoOpcionesBusqueda.add(radLibro);
        this.prestamoList = ObservableCollections.observableList(new ArrayList<Prestamo>());

        //procedemos a bindear
        BindingGroup grupo = new BindingGroup();

        BeanProperty paterno = BeanProperty.create("persona.paterno");
        BeanProperty materno = BeanProperty.create("persona.materno");
        BeanProperty nombres = BeanProperty.create("persona.nombres");
        BeanProperty codigoEjemplar = BeanProperty.create("ejemplar.codigo");
        BeanProperty tituloLibro = BeanProperty.create("ejemplar.libro.titulo");
        BeanProperty fechaInicioPrestamo = BeanProperty.create("fechaPrestamo");
        BeanProperty fechaFinPrestamo = BeanProperty.create("fechaDevolucion");
        BeanProperty fechaEntregaPrestamo = BeanProperty.create("fechaEntrega");
        JTableBinding bindeoTabla = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, prestamoList, tblPrestamoList);
        bindeoTabla.addColumnBinding(paterno).setColumnName("Apellido paterno").setEditable(false);
        bindeoTabla.addColumnBinding(materno).setColumnName("Apellido materno").setEditable(false);
        bindeoTabla.addColumnBinding(nombres).setColumnName("nombres").setEditable(false);
        bindeoTabla.addColumnBinding(codigoEjemplar).setColumnName("Código ejemplar").setEditable(false);
        bindeoTabla.addColumnBinding(tituloLibro).setColumnName("Libro").setEditable(false);
        bindeoTabla.addColumnBinding(fechaInicioPrestamo).setColumnName("Fecha préstamo").setEditable(false).setColumnClass(Date.class);
        bindeoTabla.addColumnBinding(fechaFinPrestamo).setColumnName("Fecha devolución").setEditable(false).setColumnClass(Date.class);
        bindeoTabla.addColumnBinding(fechaEntregaPrestamo).setColumnName("Fecha entrega").setEditable(false).setColumnClass(Date.class);
        grupo.addBinding(bindeoTabla);
        grupo.bind();

        tblPrestamoList.setDefaultRenderer(Date.class, new DefaultTableCellRenderer() {
            final DateFormat dfFecha = new SimpleDateFormat("dd/MM/yyyy");
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                String fecha = "";
                if(value != null){
                    Date date = (Date) value;
                    fecha = dfFecha.format(date);
                }
                return super.getTableCellRendererComponent(table, fecha, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
    }

    private void controles(boolean busqueda) {
        FormularioUtil.activarComponente(pnlBusqueda, !busqueda);
        FormularioUtil.activarComponente(pnlAcciones, !busqueda);

        txtPersona.setEditable(false);
        txtLibro.setEditable(false);
        if (!busqueda) {
            opcionesBusqueda();
        }
    }

    //cambiamos acorde a lo que se requiere
    private void buscar() {
//        String busqueda = txtBusqueda.getText();
        tamanioPagina = Integer.parseInt(cboTamanio.getSelectedItem().toString());

        //AQUI LO PASAMOS A UN SWING WORKER
        prestamoList.clear();

        prestamoList.addAll(this.listar(paginaActual, tamanioPagina));

        tblPrestamoList.packAll();
    }

    private List<Prestamo> listar(int pagina, int tamanio) {
        int total = 0;
        boolean entreFechas = chkEntreFechas.isSelected();
        if (radPersona.isSelected()) {
            total = prestamoControlador.contarXPersona(personaSeleccionada, chkPendienteDevolucion.isSelected(), entreFechas ? dcFechaInicio.getDate() : null, entreFechas ? dcFechaInicio.getDate() : null);
        } else {
            total = prestamoControlador.contarXLibro(libroSeleccionado, chkPendienteDevolucion.isSelected(), entreFechas ? dcFechaInicio.getDate() : null, entreFechas ? dcFechaInicio.getDate() : null);
        }

        if (total % tamanio == 0) {
            totalPaginas = total / tamanio;
        } else {
            totalPaginas = (total / tamanio) + 1;
        }

        if (totalPaginas == 0) {
            totalPaginas = 1;
        }

        int desde = (pagina - 1) * tamanio;

        if (radPersona.isSelected()) {
            return prestamoControlador.buscarXPersona(personaSeleccionada, chkPendienteDevolucion.isSelected(), entreFechas ? dcFechaInicio.getDate() : null, entreFechas ? dcFechaInicio.getDate() : null, desde, tamanio);
        } else {
            return prestamoControlador.buscarXLibro(libroSeleccionado, chkPendienteDevolucion.isSelected(), entreFechas ? dcFechaInicio.getDate() : null, entreFechas ? dcFechaInicio.getDate() : null, desde, tamanio);
        }

    }

    private void siguiente() {
        paginaActual++;
        buscar();
        this.actualizarControlesNavegacion();
    }

    private void ultimo() {
        paginaActual = totalPaginas;
        buscar();
        this.actualizarControlesNavegacion();
    }

    private void primero() {
        paginaActual = 1;
        buscar();
        this.actualizarControlesNavegacion();
    }

    private void anterior() {
        paginaActual--;
        buscar();
        this.actualizarControlesNavegacion();
    }

    private void seleccionPagina() {
        paginaActual = (int) spPagina.getValue();
        buscar();
        this.actualizarControlesNavegacion();
    }

    private void actualizarControlesNavegacion() {
        spPagina.setValue(paginaActual);
        txtTotal.setText(totalPaginas + "");

        SpinnerNumberModel modeloSP = (SpinnerNumberModel) spPagina.getModel();
        Comparable<Integer> maximo = totalPaginas;
        modeloSP.setMaximum(maximo);

        this.btnSiguiente.setEnabled(paginaActual != totalPaginas);
        this.btnUltimo.setEnabled(paginaActual != totalPaginas);

        this.btnAnterior.setEnabled(paginaActual != 1);
        this.btnPrimero2.setEnabled(paginaActual != 1);
    }

    private Prestamo obtenerPrestamoSeleccioado() {
        int fila = tblPrestamoList.getSelectedRow();
        if (fila != -1) {
            return prestamoList.get(fila);
        }
        return null;
    }

    private void opcionesBusqueda() {
        btnPersona.setEnabled(radPersona.isSelected());
        btnLibro.setEnabled(radLibro.isSelected());

        FormularioUtil.activarComponente(dcFechaInicio, chkEntreFechas.isSelected());
        FormularioUtil.activarComponente(dcFechaFin, chkEntreFechas.isSelected());
    }

    private void mostrarPersona(Persona persona) {
        txtPersona.setText(String.format("%s %s, %s", persona.getPaterno(), persona.getMaterno(), persona.getNombres()));
    }

    private class Busqueda extends SwingWorker<Double, Void> {

        @Override
        protected Double doInBackground() throws Exception {
            controles(true);
            lblEspere.setEnabled(true);
            lblEspere.setVisible(true);
            lblEspere.setBusy(true);
            paginaActual = 1;
            buscar();
            actualizarControlesNavegacion();
            return 0.0;
        }

        @Override
        protected void done() {
            controles(false);
            lblEspere.setBusy(false);
            lblEspere.setVisible(false);
        }

    }
}
