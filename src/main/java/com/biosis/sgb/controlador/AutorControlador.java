/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Autor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Francis
 */
public class AutorControlador extends Controlador<Autor> {

    private AutorControlador() {
        super(Autor.class);
    }

    public static AutorControlador getInstance() {
        return AutorControladorHolder.INSTANCE;
    }

    private static class AutorControladorHolder {

        private static final AutorControlador INSTANCE = new AutorControlador();
    }

    public List<Autor> buscarXNombre(String nombre, int inicio, int tamanio) {
        String jpql = "SELECT a FROM Autor a WHERE a.nombres LIKE CONCAT('%',:nombre,'%') OR a.paterno LIKE CONCAT('%',:nombre,'%') OR a.materno LIKE CONCAT('%',:nombre,'%') ORDER BY a.paterno, a.materno, a.nombres";
        Map<String, Object> param = new HashMap();
        param.put("nombre", nombre);

        return this.buscar(jpql, param, inicio, tamanio);
    }

    public int contarXNombre(String nombre) {
        String jpql = "SELECT COUNT(a) FROM Autor a WHERE a.nombres LIKE CONCAT('%',:nombre,'%') OR a.paterno LIKE CONCAT('%',:nombre,'%') OR a.materno LIKE CONCAT('%',:nombre,'%')";
        Map<String, Object> param = new HashMap();
        param.put("nombre", nombre);

        return this.contar(jpql, param);
    }
}
