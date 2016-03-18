/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Materia;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Francis
 */
public class MateriaControlador extends Controlador<Materia> {

    private MateriaControlador() {
        super(Materia.class);
    }

    public static MateriaControlador getInstance() {
        return MateriaControladorHolder.INSTANCE;
    }

    private static class MateriaControladorHolder {

        private static final MateriaControlador INSTANCE = new MateriaControlador();
    }

    @Override
    public void prepararCrear() {
        super.prepararCrear();
        this.getSeleccionado().setSeccionList(new ArrayList<>());
    }

    public List<Materia> buscarXNombre(String nombre, int inicio, int tamanio) {
        String jpql = "SELECT DISTINCT s.materia FROM Seccion s WHERE s.materia.nombre LIKE CONCAT('%',:nombre,'%') OR s.nombre LIKE CONCAT('%',:nombre,'%') ORDER BY s.materia.nombre";
        Map<String, Object> param = new HashMap();
        param.put("nombre", nombre);

        return this.buscar(jpql, param, inicio, tamanio);
    }

    public int contarXNombre(String nombre) {
        String jpql = "SELECT COUNT(DISTINCT s.materia) FROM Seccion s WHERE s.materia.nombre LIKE CONCAT('%',:nombre,'%') OR s.nombre LIKE CONCAT('%',:nombre,'%')";
        Map<String, Object> param = new HashMap();
        param.put("nombre", nombre);

        return this.contar(jpql, param);
    }
}
