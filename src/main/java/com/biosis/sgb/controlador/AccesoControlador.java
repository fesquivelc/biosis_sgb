/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Acceso;

/**
 *
 * @author Francis
 */
public class AccesoControlador extends Controlador<Acceso>{
    
    private AccesoControlador() {
        super(Acceso.class);
    }
    
    public static AccesoControlador getInstance() {
        return AccesoControladorHolder.INSTANCE;
    }
    
    private static class AccesoControladorHolder {

        private static final AccesoControlador INSTANCE = new AccesoControlador();
    }
}
