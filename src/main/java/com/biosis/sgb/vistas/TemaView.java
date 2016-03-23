/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.vistas;

import static com.biosis.sgb.Application.*;
import static com.biosis.sgb.controlador.Controlador.*;
import com.biosis.sgb.controlador.TemaControlador;
import com.biosis.sgb.entidades.Tema;
import com.biosis.sgb.util.ButtonImage;
import com.biosis.sgb.util.render.TrRenderTema;
import com.biosis.sgb.vistas.dialogos.TemaCRUD;
import com.personal.utiles.FormularioUtil;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingWorker;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import org.jdesktop.observablecollections.ObservableCollections;

/**
 *
 * @author Francis
 */
public class TemaView extends javax.swing.JPanel {

    private final TemaControlador temaControlador;

    private TreeModel trModeloTema;
    private final TrRenderTema renderTema;

    private List<Tema> temaList;

    public TemaView() {
        initComponents();
        initComponents2();
        this.temaControlador = TemaControlador.getInstance();
        renderTema = new TrRenderTema();
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

        grupoOpcionesBusqueda = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pnlAcciones = new javax.swing.JPanel();
        btnVer = new javax.swing.JButton();
        btnVerLibros = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        pnlListado = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        trTemaSubtema = new javax.swing.JTree();
        pnlRefrescar = new javax.swing.JPanel();
        btnActualizar = new javax.swing.JButton();
        lblEspere = new org.jdesktop.swingx.JXBusyLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(204, 204, 255));
        jLabel1.setFont(ESTILO5);
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mantenimiento de información de temas y subtemas");
        jLabel1.setOpaque(true);
        add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

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

        btnVerLibros.setFont(ESTILO7       );
        btnVerLibros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Find/Find_24x24.png"))); // NOI18N
        btnVerLibros.setText("Ver libros");
        btnVerLibros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerLibrosActionPerformed(evt);
            }
        });
        pnlAcciones.add(btnVerLibros);

        btnNuevo.setFont(ESTILO7);
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Add/Add_24x24.png"))); // NOI18N
        btnNuevo.setText("Nuevo tema");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });
        pnlAcciones.add(btnNuevo);

        btnModificar.setFont(ESTILO7       );
        btnModificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Edit/Edit_24x24.png"))); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        pnlAcciones.add(btnModificar);

        btnEliminar.setFont(ESTILO7       );
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Delete/Delete_24x24.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        pnlAcciones.add(btnEliminar);

        jPanel1.add(pnlAcciones, java.awt.BorderLayout.PAGE_END);

        pnlListado.setBackground(new java.awt.Color(255, 255, 255));
        pnlListado.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Temas y subtemas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, ESTILO1        ));
        pnlListado.setLayout(new java.awt.BorderLayout(5, 5));

        trTemaSubtema.setRowHeight(30);
        jScrollPane2.setViewportView(trTemaSubtema);

        pnlListado.add(jScrollPane2, java.awt.BorderLayout.CENTER);

        pnlRefrescar.setOpaque(false);
        pnlRefrescar.setLayout(new javax.swing.BoxLayout(pnlRefrescar, javax.swing.BoxLayout.LINE_AXIS));

        btnActualizar.setFont(ESTILO7);
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Refresh/Refresh_24x24.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        pnlRefrescar.add(btnActualizar);

        lblEspere.setText("Cargando datos...");
        lblEspere.setFont(ESTILO1);
        pnlRefrescar.add(lblEspere);

        pnlListado.add(pnlRefrescar, java.awt.BorderLayout.NORTH);

        jPanel1.add(pnlListado, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerLibrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerLibrosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnVerLibrosActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        temaControlador.prepararCrear();
        TemaCRUD temaCRUD = new TemaCRUD(this, true, NUEVO, temaControlador.getSeleccionado());
        temaCRUD.setVisible(true);
        if (temaCRUD.isAccionRealizada()) {
            Busqueda busqueda = new Busqueda();
            busqueda.execute();
        }
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        // TODO add your handling code here:
        //        
        Tema temaSeleccionado = obtenerTemaArbol();
        TemaCRUD temaCRUD = new TemaCRUD(this, true, LEER, temaSeleccionado);
        temaCRUD.setVisible(true);
        if (temaCRUD.isAccionRealizada()) {
            Busqueda busqueda = new Busqueda();
            busqueda.execute();
        }
    }//GEN-LAST:event_btnVerActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        Tema temaSeleccionado = obtenerTemaArbol();
        TemaCRUD temaCRUD = new TemaCRUD(this, true, MODIFICAR, temaSeleccionado);
        temaCRUD.setVisible(true);
        if (temaCRUD.isAccionRealizada()) {
            Busqueda busqueda = new Busqueda();
            busqueda.execute();
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        Busqueda busqueda = new Busqueda();
        busqueda.execute();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVer;
    private javax.swing.JButton btnVerLibros;
    private javax.swing.ButtonGroup grupoOpcionesBusqueda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXBusyLabel lblEspere;
    private javax.swing.JPanel pnlAcciones;
    private javax.swing.JPanel pnlListado;
    private javax.swing.JPanel pnlRefrescar;
    private javax.swing.JTree trTemaSubtema;
    // End of variables declaration//GEN-END:variables

    private void initComponents2() {
        lblEspere.setVisible(false);
        this.temaList = ObservableCollections.observableList(new ArrayList<Tema>());

        //procedemos a bindear
        /*
        BindingGroup grupo = new BindingGroup();

        BeanProperty paterno = BeanProperty.create("Tema principal");
        BeanProperty materno = BeanProperty.create("materno");
        BeanProperty nombres = BeanProperty.create("nombres");
        JTableBinding bindeoTabla = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ, temaList, tblAutorList);
        bindeoTabla.addColumnBinding(paterno).setColumnName("Apellido paterno").setEditable(false);
        bindeoTabla.addColumnBinding(materno).setColumnName("Apellido materno").setEditable(false);
        bindeoTabla.addColumnBinding(nombres).setColumnName("nombres").setEditable(false);
        grupo.addBinding(bindeoTabla);
        grupo.bind();
         */
    }

    private void controles(boolean busqueda) {
//        FormularioUtil.activarComponente(pnlBusqueda, !busqueda);
        FormularioUtil.activarComponente(pnlAcciones, !busqueda);
        btnActualizar.setEnabled(!busqueda);
    }

    //cambiamos acorde a lo que se requiere
    private void buscar() {
//        String busqueda = txtBusqueda.getText();

        //AQUI LO PASAMOS A UN SWING WORKER
        TreeNode nodoPrincipal = new DefaultMutableTreeNode("Temas y subtemas");
        trModeloTema = new DefaultTreeModel(nodoPrincipal);
        trTemaSubtema.setModel(trModeloTema);
        trTemaSubtema.setCellRenderer(renderTema);
        temaList = temaControlador.buscarTemaSuperior();
        llenarArbol((DefaultTreeModel) trModeloTema, temaList, (DefaultMutableTreeNode) nodoPrincipal);
        for (int i = 0; i < trTemaSubtema.getRowCount(); i++) {
            trTemaSubtema.expandRow(i);
        }
    }

    private void llenarArbol(DefaultTreeModel modelo, List listado, DefaultMutableTreeNode padre) {
        for (Object elemento : listado) {
            DefaultMutableTreeNode nodo = new DefaultMutableTreeNode(elemento);
            modelo.insertNodeInto(nodo, padre, padre.getChildCount());
            if (elemento instanceof Tema) {
                Tema temaPrincipal = (Tema) elemento;
                if (temaPrincipal.getCantidadSubtema() > 0) {
                    List<Tema> subTemaList = temaPrincipal.getTemaList();
                    llenarArbol(modelo, subTemaList, nodo);
                }
            }
        }
    }

    private Tema obtenerTemaArbol() {
        DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) trTemaSubtema.getLastSelectedPathComponent();
        if (nodo != null) {
            Object elemento = nodo.getUserObject();
            if (elemento instanceof Tema) {
                return (Tema) elemento;
            } else {
                return null;
            }
        }
        return null;
    }

    private class Busqueda extends SwingWorker<Double, Void> {

        @Override
        protected Double doInBackground() throws Exception {
            controles(true);
            lblEspere.setEnabled(true);
            lblEspere.setVisible(true);
            lblEspere.setBusy(true);
//            paginaActual = 1;            
            buscar();
//            actualizarControlesNavegacion();
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
