/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.vistas.dialogos;

import static com.biosis.sgb.Application.*;
import static com.biosis.sgb.controlador.Controlador.NUEVO;
import com.biosis.sgb.controlador.TemaControlador;
import com.biosis.sgb.entidades.Tema;
import com.biosis.sgb.util.AbstractListCellRenderer;
import com.personal.utiles.FormularioUtil;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingWorker;
import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.BindingGroup;
import org.jdesktop.observablecollections.ObservableCollections;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

/**
 *
 * @author Francis
 */
public class TemaSelect extends javax.swing.JDialog {

    /**
     * Creates new form AutorSelect
     */
    private int paginaActual = 1;
    private int totalPaginas = 0;
    private int tamanioPagina = 0;

    private List<Tema> temaList;
    private List<Tema> temaSuperiorList;

    private Tema tema;

    private final TemaControlador temaControlador;

    public TemaSelect(Component parent, boolean modal) {
        super(JOptionPane.getFrameForComponent(parent), modal);
        this.temaControlador = TemaControlador.getInstance();
        initComponents();
        initComponents2();
        Busqueda busquedaLibro = new Busqueda();
        busquedaLibro.execute();
        this.setLocationRelativeTo(parent);
    }

    public Tema getTema() {
        return tema;
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
        jLabel1 = new javax.swing.JLabel();
        pnlSecundario = new javax.swing.JPanel();
        pnlBusqueda = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        btnBuscar1 = new javax.swing.JButton();
        lblEspere = new org.jdesktop.swingx.JXBusyLabel();
        jLabel2 = new javax.swing.JLabel();
        chkTema = new javax.swing.JCheckBox();
        cboTema = new javax.swing.JComboBox<>();
        pnlListado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAutorList = new org.jdesktop.swingx.JXTable();
        pnlNavegacion2 = new javax.swing.JPanel();
        btnPrimero2 = new javax.swing.JButton();
        btnAnterior = new javax.swing.JButton();
        spPagina = new javax.swing.JSpinner();
        txtTotal = new javax.swing.JTextField();
        btnSiguiente = new javax.swing.JButton();
        btnUltimo = new javax.swing.JButton();
        cboTamanio = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPrincipal.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(ESTILO5);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Seleccione un subtema");
        jLabel1.setOpaque(true);
        pnlPrincipal.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        pnlSecundario.setLayout(new java.awt.BorderLayout());

        pnlBusqueda.setBackground(new java.awt.Color(255, 255, 255));
        pnlBusqueda.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Parámetros de búsqueda", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, ESTILO1));
        pnlBusqueda.setLayout(new java.awt.GridBagLayout());

        txtNombre.setFont(ESTILO2);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        pnlBusqueda.add(txtNombre, gridBagConstraints);

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

        btnBuscar1.setFont(ESTILO1);
        btnBuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add/Add_16x16.png"))); // NOI18N
        btnBuscar1.setText("Nuevo");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnBuscar1);

        lblEspere.setText("Cargando resultados...");
        lblEspere.setFont(ESTILO1);
        jPanel2.add(lblEspere);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        pnlBusqueda.add(jPanel2, gridBagConstraints);

        jLabel2.setFont(ESTILO1);
        jLabel2.setText("Nombre:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        pnlBusqueda.add(jLabel2, gridBagConstraints);

        chkTema.setFont(ESTILO1);
        chkTema.setText("Tema:");
        chkTema.setOpaque(false);
        chkTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkTemaActionPerformed(evt);
            }
        });
        pnlBusqueda.add(chkTema, new java.awt.GridBagConstraints());

        cboTema.setFont(ESTILO2);
        cboTema.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        pnlBusqueda.add(cboTema, gridBagConstraints);

        pnlSecundario.add(pnlBusqueda, java.awt.BorderLayout.PAGE_START);

        pnlListado.setBackground(new java.awt.Color(255, 255, 255));
        pnlListado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, ESTILO1        ));
        pnlListado.setLayout(new java.awt.BorderLayout());

        tblAutorList.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAutorList.setFont(ESTILO2);
        tblAutorList.setRowHeight(20);
        tblAutorList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAutorListMouseClicked(evt);
            }
        });
        tblAutorList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblAutorListKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblAutorList);

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

        pnlSecundario.add(pnlListado, java.awt.BorderLayout.CENTER);

        pnlPrincipal.add(pnlSecundario, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        Busqueda busqueda = new Busqueda();
        busqueda.execute();
    }//GEN-LAST:event_btnBuscarActionPerformed

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

    private void tblAutorListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAutorListMouseClicked
        // TODO add your handling code here:
        int conteo = evt.getClickCount();
        if (conteo == 2) {
            int fila = tblAutorList.getSelectedRow();
            this.tema = this.temaList.get(fila);
            this.dispose();
        }
    }//GEN-LAST:event_tblAutorListMouseClicked

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            if (this.temaList.size() > 0) {
                tblAutorList.requestFocus();
                tblAutorList.setRowSelectionInterval(0, 0);
            }
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void tblAutorListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblAutorListKeyReleased
        // TODO add your handling code here:

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            int fila = tblAutorList.getSelectedRow();
            this.tema = this.temaList.get(fila);
            this.dispose();
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP && tblAutorList.getSelectedRow() == 0) {
            txtNombre.requestFocus();
        }
    }//GEN-LAST:event_tblAutorListKeyReleased

    private void chkTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkTemaActionPerformed
        // TODO add your handling code here:
        checkbox();
    }//GEN-LAST:event_chkTemaActionPerformed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
        TemaCRUD temaCRUD = new TemaCRUD(this, true, NUEVO, new Tema(), true);
        temaCRUD.setVisible(true);
        if (temaCRUD.isAccionRealizada()) {
            this.tema = temaCRUD.getTema();
            this.dispose();
        }
    }//GEN-LAST:event_btnBuscar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnPrimero2;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox cboTamanio;
    private javax.swing.JComboBox<String> cboTema;
    private javax.swing.JCheckBox chkTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXBusyLabel lblEspere;
    private javax.swing.JPanel pnlBusqueda;
    private javax.swing.JPanel pnlListado;
    private javax.swing.JPanel pnlNavegacion2;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JPanel pnlSecundario;
    private javax.swing.JSpinner spPagina;
    private org.jdesktop.swingx.JXTable tblAutorList;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void initComponents2() {
        lblEspere.setVisible(false);
        this.temaList = ObservableCollections.observableList(new ArrayList<Tema>());
        this.temaSuperiorList = this.temaControlador.buscarTemaSuperior();
        //procedemos a bindear
        BindingGroup grupo = new BindingGroup();

        BeanProperty temaSuperior = BeanProperty.create("temaSuperior.nombre");
        BeanProperty nombre = BeanProperty.create("nombre");
        BeanProperty descripcion = BeanProperty.create("descripcion");
        JTableBinding bindeoTabla = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, temaList, tblAutorList);
        bindeoTabla.addColumnBinding(temaSuperior).setColumnName("Tema").setEditable(false);
        bindeoTabla.addColumnBinding(nombre).setColumnName("Subtema").setEditable(false);
        bindeoTabla.addColumnBinding(descripcion).setColumnName("Descripcion").setEditable(false);
        grupo.addBinding(bindeoTabla);

        JComboBoxBinding bindTemaSuperior = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ, temaSuperiorList, cboTema);
        grupo.addBinding(bindTemaSuperior);
        grupo.bind();

        cboTema.setRenderer(new AbstractListCellRenderer<Tema>() {
            @Override
            public String getTexto(Tema value) {
                return value.getNombre();
            }

            @Override
            public ImageIcon getIcono(Tema value) {
                return null;
            }
        });
    }

    private void controles(boolean busqueda) {
        FormularioUtil.activarComponente(pnlBusqueda, !busqueda);
        if (!busqueda) {
            checkbox();
        }
//        FormularioUtil.activarComponente(pnlAcciones, !busqueda);
    }

    //cambiamos acorde a lo que se requiere
    private void buscar() {
//        String busqueda = txtBusqueda.getText();
        tamanioPagina = Integer.parseInt(cboTamanio.getSelectedItem().toString());

        //AQUI LO PASAMOS A UN SWING WORKER
        temaList.clear();

        temaList.addAll(this.listar(paginaActual, tamanioPagina));

        tblAutorList.packAll();
    }

    private List<Tema> listar(int pagina, int tamanio) {
        int total = 0;
        String nombreStr = txtNombre.getText();
        Tema tema = null;
        if (this.chkTema.isSelected()) {
            tema = (Tema) cboTema.getSelectedItem();
            total = temaControlador.contarSubtemaXNombreYTema(nombreStr, tema);
        } else {
            total = temaControlador.contarSubtemaXNombre(nombreStr);
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

        if (this.chkTema.isSelected()) {
            return this.temaControlador.buscarSubtemaXNombreYTema(nombreStr, tema, desde, tamanio);
        } else {
            return this.temaControlador.buscarSubtemaXNombre(nombreStr, desde, tamanio);
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

    private void checkbox() {
        this.cboTema.setEnabled(this.chkTema.isSelected());
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
