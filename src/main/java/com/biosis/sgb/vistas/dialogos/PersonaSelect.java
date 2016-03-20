/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.vistas.dialogos;

import static com.biosis.sgb.Application.*;
import com.biosis.sgb.controlador.PersonaControlador;
import com.biosis.sgb.controlador.TemaControlador;
import com.biosis.sgb.entidades.Persona;
import com.biosis.sgb.entidades.Tema;
import com.personal.utiles.FormularioUtil;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingWorker;
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
public class PersonaSelect extends javax.swing.JDialog {

    /**
     * Creates new form AutorSelect
     */
    private int paginaActual = 1;
    private int totalPaginas = 0;
    private int tamanioPagina = 0;

    private List<Persona> personaList;
    
    private Persona persona;
    
    private final PersonaControlador personaControlador;
    
    public PersonaSelect(Component parent, boolean modal) {
        super(JOptionPane.getFrameForComponent(parent), modal);
        this.personaControlador = PersonaControlador.getInstance();
        initComponents();
        initComponents2();
        this.setLocationRelativeTo(parent);
        Busqueda busquedaLibro = new Busqueda();
        busquedaLibro.execute();  
    }

    public Persona getPersona() {
        return persona;
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
        lblEspere = new org.jdesktop.swingx.JXBusyLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlListado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPersonaList = new org.jdesktop.swingx.JXTable();
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
        jLabel1.setText("Seleccione una persona");
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

        pnlSecundario.add(pnlBusqueda, java.awt.BorderLayout.PAGE_START);

        pnlListado.setBackground(new java.awt.Color(255, 255, 255));
        pnlListado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Listado", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, ESTILO1        ));
        pnlListado.setLayout(new java.awt.BorderLayout());

        tblPersonaList.setModel(new javax.swing.table.DefaultTableModel(
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
        tblPersonaList.setFont(ESTILO2);
        tblPersonaList.setRowHeight(20);
        tblPersonaList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPersonaListMouseClicked(evt);
            }
        });
        tblPersonaList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tblPersonaListKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblPersonaList);

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

    private void tblPersonaListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPersonaListMouseClicked
        // TODO add your handling code here:
        int conteo = evt.getClickCount();
        if(conteo == 2){
            int fila = tblPersonaList.getSelectedRow();
            this.persona = this.personaList.get(fila);
            this.dispose();
        }
    }//GEN-LAST:event_tblPersonaListMouseClicked

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_DOWN){
            if(this.personaList.size() > 0){
                tblPersonaList.requestFocus();
                tblPersonaList.setRowSelectionInterval(0, 0);
            }
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void tblPersonaListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPersonaListKeyReleased
        // TODO add your handling code here:
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            int fila = tblPersonaList.getSelectedRow();
            this.persona = this.personaList.get(fila);
            this.dispose();
        }
        if(evt.getKeyCode() == KeyEvent.VK_UP && tblPersonaList.getSelectedRow() == 0){
            txtNombre.requestFocus();
        }
    }//GEN-LAST:event_tblPersonaListKeyReleased
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnterior;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnPrimero2;
    private javax.swing.JButton btnSiguiente;
    private javax.swing.JButton btnUltimo;
    private javax.swing.JComboBox cboTamanio;
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
    private org.jdesktop.swingx.JXTable tblPersonaList;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

    private void initComponents2() {
        lblEspere.setVisible(false);
        this.personaList = ObservableCollections.observableList(new ArrayList<Persona>());
        //procedemos a bindear
        BindingGroup grupo = new BindingGroup();

        BeanProperty nombre = BeanProperty.create("nombres");
        BeanProperty paterno = BeanProperty.create("paterno");
        BeanProperty materno = BeanProperty.create("materno");
        BeanProperty email = BeanProperty.create("email");
        JTableBinding bindeoTabla = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, personaList, tblPersonaList);
        bindeoTabla.addColumnBinding(nombre).setColumnName("Nombres").setEditable(false);
        bindeoTabla.addColumnBinding(paterno).setColumnName("Ap. paterno").setEditable(false);
        bindeoTabla.addColumnBinding(materno).setColumnName("Ap. materno").setEditable(false);
        bindeoTabla.addColumnBinding(email).setColumnName("E-mail").setEditable(false);
        grupo.addBinding(bindeoTabla);
        grupo.bind();
        
    }
    
    private void controles(boolean busqueda){
        FormularioUtil.activarComponente(pnlBusqueda, !busqueda);
//        if(!busqueda){
//            checkbox();
//        }
//        FormularioUtil.activarComponente(pnlAcciones, !busqueda);
    }

    //cambiamos acorde a lo que se requiere
    private void buscar() {
//        String busqueda = txtBusqueda.getText();
        tamanioPagina = Integer.parseInt(cboTamanio.getSelectedItem().toString());

        //AQUI LO PASAMOS A UN SWING WORKER
        personaList.clear();

        personaList.addAll(this.listar(paginaActual, tamanioPagina));

        tblPersonaList.packAll();
    }

    private List<Persona> listar(int pagina, int tamanio) {
        int total = 0;
        String nombreStr = txtNombre.getText();
        total = personaControlador.contarXNombre(nombreStr);
        
        if (total % tamanio == 0) {
            totalPaginas = total / tamanio;
        } else {
            totalPaginas = (total / tamanio) + 1;
        }

        if (totalPaginas == 0) {
            totalPaginas = 1;
        }

        int desde = (pagina - 1) * tamanio;

        return this.personaControlador.buscarXNombre(nombreStr, desde, tamanio);
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
