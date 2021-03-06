/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.util.dialogos;

import static com.biosis.sgb.Application.*;
import com.biosis.sgb.util.Mensaje;
import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
public class DlgMensajes extends javax.swing.JDialog {

    private List<Mensaje> mensajeList;
    
    private void inicializar(TipoMensaje tipoMensaje, List<Mensaje> mensajeList) {
        switch(tipoMensaje){
            case ERROR:
               lblTitulo.setText("Se ha(n) encontrado el(los) siguiente(s) error(es)");
               lblTitulo.setIcon(iconoError);
               break;
            default:
               lblTitulo.setText("Mensaje del sistema");
               lblTitulo.setIcon(iconoInformacion);
               break;
        }
        llenarCampos(mensajeList);
        
    }

    private void initComponents2() {
        this.mensajeList = ObservableCollections.observableList(new ArrayList<Mensaje>());
        
        BindingGroup bindeoSalvaje = new BindingGroup();
        JTableBinding bindeoTabla = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, mensajeList, tblMensaje);
        bindeoSalvaje.addBinding(bindeoTabla);
        BeanProperty pDescripcion = BeanProperty.create("descripcion");
        bindeoTabla.addColumnBinding(pDescripcion).setColumnName("Descripción").setEditable(false);
        
        bindeoSalvaje.bind();
    }

    private void llenarCampos(List<Mensaje> mensajeList) {
        this.mensajeList.addAll(mensajeList);
    }

    /**
     * Creates new form DlgError
     */
    public enum TipoMensaje{
        ERROR, INFORMACION, ADVERTENCIA
    }
    private final ImageIcon iconoError;
    private final ImageIcon iconoInformacion;
    private final ImageIcon iconoAdvertencia;
    public DlgMensajes(java.awt.Frame parent) {
        super(parent, true);
        initComponents();
        iconoError = new ImageIcon(getClass().getResource("/icon/Cancel_24x24.png"));
        iconoInformacion = new ImageIcon(getClass().getResource("/icon/Information_24x24.png"));
        iconoAdvertencia = new ImageIcon(getClass().getResource("/icon/Information_24x24.png"));
    }
    public DlgMensajes(java.awt.Frame parent, TipoMensaje tipoMensaje, List<Mensaje> mensajeList) {
        super(parent, true);
        initComponents();
        initComponents2();
        iconoError = new ImageIcon(getClass().getResource("/icon/Cancel_24x24.png"));
        iconoInformacion = new ImageIcon(getClass().getResource("/icon/Information_24x24.png"));
        iconoAdvertencia = new ImageIcon(getClass().getResource("/icon/Information_24x24.png"));
        inicializar(tipoMensaje, mensajeList);
        this.setLocationRelativeTo(parent);
    }
    public DlgMensajes(Component parent, TipoMensaje tipoMensaje, List<Mensaje> mensajeList) {
        super(JOptionPane.getFrameForComponent(parent), true);
        initComponents();
        initComponents2();
        iconoError = new ImageIcon(getClass().getResource("/icon/Cancel/Cancel_24x24.png"));
        iconoInformacion = new ImageIcon(getClass().getResource("/icon/Information/Information_24x24.png"));
        iconoAdvertencia = new ImageIcon(getClass().getResource("/icon/Information/Information_24x24.png"));
        inicializar(tipoMensaje, mensajeList);
        this.setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMensaje = new org.jdesktop.swingx.JXTable();
        pnlRecomendacion = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRecomendacion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mensaje del sistema");

        jPanel1.setLayout(new java.awt.BorderLayout(5, 5));

        lblTitulo.setBackground(new java.awt.Color(222, 51, 42));
        lblTitulo.setFont(ESTILO1);
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setText("jLabel1");
        lblTitulo.setMaximumSize(new java.awt.Dimension(41, 40));
        lblTitulo.setMinimumSize(new java.awt.Dimension(41, 20));
        lblTitulo.setOpaque(true);
        lblTitulo.setPreferredSize(new java.awt.Dimension(41, 30));
        jPanel1.add(lblTitulo, java.awt.BorderLayout.PAGE_START);

        tblMensaje.setModel(new javax.swing.table.DefaultTableModel(
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
        tblMensaje.setFont(ESTILO2);
        tblMensaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblMensajeMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblMensaje);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pnlRecomendacion.setLayout(new javax.swing.BoxLayout(pnlRecomendacion, javax.swing.BoxLayout.LINE_AXIS));

        txtRecomendacion.setEditable(false);
        txtRecomendacion.setColumns(20);
        txtRecomendacion.setFont(ESTILO2);
        txtRecomendacion.setLineWrap(true);
        txtRecomendacion.setRows(3);
        txtRecomendacion.setTabSize(4);
        jScrollPane2.setViewportView(txtRecomendacion);

        pnlRecomendacion.add(jScrollPane2);

        jPanel1.add(pnlRecomendacion, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblMensajeMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMensajeMouseReleased
        // TODO add your handling code here:
        int fila = tblMensaje.getSelectedRow();
        if(fila != -1){
            Mensaje mensaje = this.mensajeList.get(fila);
            txtRecomendacion.setText(mensaje.getRecomendacion());
        }
    }//GEN-LAST:event_tblMensajeMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlRecomendacion;
    private org.jdesktop.swingx.JXTable tblMensaje;
    private javax.swing.JTextArea txtRecomendacion;
    // End of variables declaration//GEN-END:variables
}
