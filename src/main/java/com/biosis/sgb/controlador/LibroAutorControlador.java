/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.LibroAutor;

/**
 *
 * @author Francis
 */
public class LibroAutorControlador extends Controlador<LibroAutor>{
    
    private LibroAutorControlador() {
        super(LibroAutor.class);
    }
    
    public static LibroAutorControlador getInstance() {
        return LibroAutorControladorHolder.INSTANCE;
    }
    
    private static class LibroAutorControladorHolder {

        private static final LibroAutorControlador INSTANCE = new LibroAutorControlador();
    }
}
