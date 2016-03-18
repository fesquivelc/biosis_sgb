/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Tema;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Francis
 */
public class TemaControlador extends Controlador<Tema> {

    private TemaControlador() {
        super(Tema.class);
    }

    public static TemaControlador getInstance() {
        return TemaControladorHolder.INSTANCE;
    }

    private static class TemaControladorHolder {

        private static final TemaControlador INSTANCE = new TemaControlador();
    }

    public List<Tema> buscarSubtemaXNombreYTema(String nombre, Tema tema, int inicio, int tamanio) {
        String jpql = "SELECT t FROM Tema t WHERE t.nombre LIKE CONCAT('%',:nombre,'%') AND t.temaSuperior = :tema ORDER BY t.nombre";
        Map<String, Object> param = new HashMap();
        param.put("nombre", nombre);
        param.put("tema", tema);
        return this.buscar(jpql, param, inicio, tamanio);
    }

    public List<Tema> buscarSubtemaXNombre(String nombre, int inicio, int tamanio) {
        String jpql = "SELECT t FROM Tema t WHERE t.temaSuperior IS NOT NULL AND (t.nombre LIKE CONCAT('%',:nombre,'%') OR t.descripcion LIKE CONCAT('%',:nombre,'%'))  ORDER BY t.nombre";
        Map<String, Object> param = new HashMap();
        param.put("nombre", nombre);
        return this.buscar(jpql, param, inicio, tamanio);
    }

    public List<Tema> buscarXNombre(String nombre, int inicio, int tamanio) {
        String jpql = "SELECT t FROM Tema t WHERE t.nombre LIKE CONCAT('%',:nombre,'%') OR t.descripcion LIKE CONCAT('%',:nombre,'%') ORDER BY t.nombre";
        Map<String, Object> param = new HashMap();
        param.put("nombre", nombre);
        return this.buscar(jpql, param, inicio, tamanio);
    }

    public List<Tema> buscarTemaSuperior() {
        String jpql = "SELECT t FROM Tema t WHERE t.temaSuperior IS NULL ORDER BY t.nombre";
        return this.buscar(jpql);
    }

    public List<Tema> buscarSubtema() {
        String jpql = "SELECT t FROM Tema t WHERE t.temaSuperior IS NOT NULL";
        return this.buscar(jpql);
    }

    public int contarSubtemaXNombre(String nombre) {
        String jpql = "SELECT COUNT(t) FROM Tema t WHERE t.temaSuperior IS NOT NULL AND (t.nombre LIKE CONCAT('%',:nombre,'%') OR t.descripcion LIKE CONCAT('%',:nombre,'%'))";
        Map<String, Object> param = new HashMap();
        param.put("nombre", nombre);
        return this.contar(jpql, param);
    }

    public int contarSubtemaXNombreYTema(String nombre, Tema tema) {
        String jpql = "SELECT COUNT(t) FROM Tema t WHERE t.nombre LIKE CONCAT('%',:nombre,'%') AND t.temaSuperior = :tema";
        Map<String, Object> param = new HashMap();
        param.put("nombre", nombre);
        param.put("tema", tema);
        return this.contar(jpql, param);
    }

    public int contarXNombre(String nombre) {
        String jpql = "SELECT COUNT(t) FROM Tema t WHERE t.nombre LIKE CONCAT('%',:nombre,'%')";
        Map<String, Object> param = new HashMap();
        param.put("nombre", nombre);
        return this.contar(jpql, param);
    }

    public int contarXTemaSuperior(Tema tema) {
        String jpql = "SELECT COUNT(t.id) FROM Tema t WHERE t.temaSuperior = :tema";
        Map<String, Object> param = new HashMap();
        param.put("tema", tema);
        return this.contar(jpql, param);
    }
}
