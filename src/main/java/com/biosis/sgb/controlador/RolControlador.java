/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Rol;

/**
 *
 * @author fesquivel
 */
public class RolControlador extends Controlador<Rol>{
    
    private RolControlador() {
        super(Rol.class);
    }
    
    public static RolControlador getInstance() {
        return RolControladorHolder.INSTANCE;
    }
    
    private static class RolControladorHolder {

        private static final RolControlador INSTANCE = new RolControlador();
    }
}
