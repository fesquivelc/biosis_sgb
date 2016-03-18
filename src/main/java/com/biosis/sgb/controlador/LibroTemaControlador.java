/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.LibroTema;

/**
 *
 * @author Francis
 */
public class LibroTemaControlador extends Controlador<LibroTema>{
    
    private LibroTemaControlador() {
        super(LibroTema.class);
    }
    
    public static LibroTemaControlador getInstance() {
        return LibroTemaControladorHolder.INSTANCE;
    }
    
    private static class LibroTemaControladorHolder {

        private static final LibroTemaControlador INSTANCE = new LibroTemaControlador();
    }
}
