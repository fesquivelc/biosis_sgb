/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.util;

import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author Francis
 */
public class ButtonImage extends JButton {

    public ButtonImage() {
        super();
        inicializar();
    }

    public ButtonImage(Icon icon, Icon rolloverIcon, Icon pressedIcon, Icon disabledIcon) {
        super();
        inicializar();
        this.setIcon(icon);
        this.setRolloverIcon(rolloverIcon);
        this.setPressedIcon(pressedIcon);
        this.setDisabledIcon(disabledIcon);
    }

    private final void inicializar() {
        this.setBorderPainted(false);
        this.setBorder(null);
//button.setFocusable(false);
        this.setMargin(new Insets(0, 0, 0, 0));
        this.setContentAreaFilled(false);
    }

}
