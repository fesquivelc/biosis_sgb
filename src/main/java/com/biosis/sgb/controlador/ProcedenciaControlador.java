/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Procedencia;

/**
 *
 * @author Francis
 */
public class ProcedenciaControlador extends Controlador<Procedencia>{
    
    private ProcedenciaControlador() {
        super(Procedencia.class);
    }
    
    public static ProcedenciaControlador getInstance() {
        return ProcedenciaControladorHolder.INSTANCE;
    }
    
    private static class ProcedenciaControladorHolder {

        private static final ProcedenciaControlador INSTANCE = new ProcedenciaControlador();
    }
}
