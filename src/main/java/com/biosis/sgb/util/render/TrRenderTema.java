/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.util.render;

import static com.biosis.sgb.Application.ESTILO3;
import static com.biosis.sgb.Application.ESTILO4;
import com.biosis.sgb.entidades.Tema;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 *
 * @author Francis
 */
public class TrRenderTema extends DefaultTreeCellRenderer {

    private final JLabel label;
    private final ImageIcon iconoTema;
    private final ImageIcon iconoSubTema;
    private final Color focusColor;

    public TrRenderTema() {
        this.label = new JLabel();
        this.label.setOpaque(true);

        iconoTema = new ImageIcon(getClass().getResource("/icon/tema.png"));
        iconoSubTema = new ImageIcon(getClass().getResource("/icon/subtema.png"));
        this.focusColor = new Color(219, 237, 255);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        Object elemento = ((DefaultMutableTreeNode) value).getUserObject();
        
        ImageIcon icono;
        String titulo;
        if (elemento != null) {

            if (elemento instanceof Tema) {
                Tema tema = (Tema) elemento;
                icono = tema.getTemaSuperior() == null ? iconoTema : iconoSubTema;
                this.label.setFont(tema.getTemaSuperior() == null ? ESTILO3 : ESTILO4);
                titulo = tema.getNombre();
            } else {
                titulo = elemento.toString();
                icono = iconoTema;
                this.label.setFont(ESTILO3);
            }
            if (hasFocus) {
                this.label.setBackground(this.focusColor);
                this.label.setForeground(Color.BLACK);
            } else {
                this.label.setBackground(Color.WHITE);
                this.label.setForeground(Color.BLACK);
            }
            this.label.setIcon(icono);
            this.label.setText(titulo);
        }
        return this.label;
    }

}
