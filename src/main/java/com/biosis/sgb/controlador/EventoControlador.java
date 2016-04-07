/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Evento;

/**
 *
 * @author Francis
 */
public class EventoControlador extends Controlador<Evento>{
    
    private EventoControlador() {
        super(Evento.class);
    }
    
    public static EventoControlador getInstance() {
        return EventoControladorHolder.INSTANCE;
    }
    
    private static class EventoControladorHolder {

        private static final EventoControlador INSTANCE = new EventoControlador();
    }
}
