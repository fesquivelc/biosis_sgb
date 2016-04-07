/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.info;

import com.biosis.sgb.entidades.RolAcceso;
import com.biosis.sgb.entidades.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Francis
 */
public class GestorAcceso {

    public final static Map<String, Integer> USUARIO_ACCESO = new HashMap();

    public static void obtenerAccesos(Usuario usuario) {
        List<RolAcceso> rolAccesoList = usuario.getRol().getRolAccesoList();
        rolAccesoList.stream().forEach((RolAcceso ra) -> USUARIO_ACCESO.put(ra.getAcceso().getObjeto(), Integer.parseInt(ra.getCrud(), 2)));
    }

    public static boolean permiteCreate(String key) {
        int valor = USUARIO_ACCESO.get(key);
        return valor == 12 || valor == 13 || valor == 14 || valor == 15;
    }

    public static boolean permiteRead(String key) {
        int valor = USUARIO_ACCESO.get(key);
        return valor != 0;
    }

    public static boolean permiteUpdate(String key) {
        int valor = USUARIO_ACCESO.get(key);
        return valor == 6 || valor == 7 || valor == 14 || valor == 15;
    }

    public static boolean permiteDelete(String key) {
        int valor = USUARIO_ACCESO.get(key);
        return valor == 5 || valor == 7 || valor == 13 || valor == 15;
    }

    /*
    Permite obtener los permisos para determinado acceso
    boolean[4] para cada CRUD
    */
    public static boolean[] permisos(String key) {
        int valor = USUARIO_ACCESO.get(key);

        return new boolean[]{valor == 12 || valor == 13 || valor == 14 || valor == 15, valor != 0, valor == 6 || valor == 7 || valor == 14 || valor == 15, valor == 5 || valor == 7 || valor == 13 || valor == 15};
    }
}
