/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fesquivel
 */
public class UsuarioControlador extends Controlador<Usuario>{
    
    private UsuarioControlador() {
        super(Usuario.class);
    }
    
    public static UsuarioControlador getInstance() {
        return UsuarioControladorHolder.INSTANCE;
    }
    
    private static class UsuarioControladorHolder {

        private static final UsuarioControlador INSTANCE = new UsuarioControlador();
    }
    
    public Usuario realizarLogin(String login, String password){
        String sql = "SELECT usuario_id, login, password, activo, cambiar_password, persona_id,rol_id, fecha_hora_creacion, fecha_hora_modificacion, evento_id  FROM usuario "
                + "WHERE login = :login AND password = md5(:password)";
        Map<String, Object> param = new HashMap();
        param.put("login", login);
        param.put("password", password);
        List<Usuario> usuarioList = this.buscarNativo(sql,param);
        if(usuarioList.isEmpty()){
            return null;
        }else{
            return usuarioList.get(0);
        }
    }
}
