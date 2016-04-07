/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.info;

import com.biosis.sgb.entidades.Evento;

/**
 *
 * @author Francis
 */

public class Monitor<T> {
    private T objetoOld;
    private T objetoNew;
    private Evento eventoOld;
    private Evento eventoNew;
    
    public final static String CREATE = "C";
    public final static String READ = "R";
    public final static String UPDATE = "U";
    public final static String DELETE = "D";
    public final static String LOGIN = "L";
    
    private void hola(){
        
    }
    
    
}
