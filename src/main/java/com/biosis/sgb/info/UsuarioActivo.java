/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.info;

import com.biosis.sgb.entidades.Usuario;

/**
 *
 * @author fesquivel
 */
public class UsuarioActivo {
    private static Usuario usuario;

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        UsuarioActivo.usuario = usuario;
    }
    
    
}
