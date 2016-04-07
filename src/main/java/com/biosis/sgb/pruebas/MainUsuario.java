/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.pruebas;

import com.biosis.sgb.controlador.UsuarioControlador;
import com.biosis.sgb.entidades.Usuario;

/**
 *
 * @author fesquivel
 */
public class MainUsuario {
    public static void main(String[] args) {
        UsuarioControlador uc = UsuarioControlador.getInstance();
        Usuario usuario = uc.realizarLogin("admin", "sgbmoquegua");
        
        if(usuario != null){
            System.out.println(String.format("ULTIMO EVENTO: %s", usuario.getEvento().getFechaHora()));
        }
        
        System.exit(0);
    }
}
