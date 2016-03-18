/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.util;

import java.awt.Component;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author Francis
 * @param <T>
 */
public abstract class AbstractListCellRenderer<T> extends JLabel implements ListCellRenderer {

    public abstract String getTexto(T value);

    public abstract ImageIcon getIcono(T value);

    public AbstractListCellRenderer() {
        setOpaque(true);
        setHorizontalAlignment(LEFT);
        setVerticalAlignment(CENTER);

    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        if (isSelected) {
            setBackground(list.getSelectionBackground());
            setForeground(list.getSelectionForeground());
        } else {
            setBackground(list.getBackground());
            setForeground(list.getForeground());
        }
        setFont(list.getFont());
        if (value != null) {

            //Set the icon and text.  If icon was null, say so.
            T objeto = (T) value;
            Icon icon = this.getIcono(objeto);
            String texto = this.getTexto(objeto);
            setText(texto);

            if (icon != null) {
                setIcon(icon);

            }
        }
        return this;
    }

}
