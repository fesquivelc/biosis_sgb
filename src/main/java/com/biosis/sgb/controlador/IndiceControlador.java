/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Indice;

/**
 *
 * @author Francis
 */
public class IndiceControlador extends Controlador<Indice>{
    
    private IndiceControlador() {
        super(Indice.class);
    }
    
    public static IndiceControlador getInstance() {
        return IndiceControladorHolder.INSTANCE;
    }
    
    private static class IndiceControladorHolder {

        private static final IndiceControlador INSTANCE = new IndiceControlador();
    }
}
