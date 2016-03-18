/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Persona;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Francis
 */
public class PersonaControlador extends Controlador<Persona> {

    private PersonaControlador() {
        super(Persona.class);
    }

    public static PersonaControlador getInstance() {
        return PersonaControladorHolder.INSTANCE;
    }

    private static class PersonaControladorHolder {

        private static final PersonaControlador INSTANCE = new PersonaControlador();
    }

    public List<Persona> buscarXNombre(String nombre, int inicio, int tamanio) {
        String jpql = "SELECT p FROM Persona p "
                + "WHERE "
                + "p.nombres LIKE CONCAT('%',:nombre,'%') OR "
                + "p.paterno LIKE CONCAT('%',:nombre,'%') OR "
                + "p.materno LIKE CONCAT('%',:nombre,'%') OR "
                + "p.dni = :nombre "
                + "ORDER BY p.paterno,p.materno,p.nombres";
        Map<String, Object> params = new HashMap();
        params.put("nombre", nombre);
        return this.buscar(jpql, params, inicio, tamanio);
    }

    public int contarXNombre(String nombre) {
        String jpql = "SELECT COUNT(p) FROM Persona p "
                + "WHERE "
                + "p.nombres LIKE CONCAT('%',:nombre,'%') OR "
                + "p.paterno LIKE CONCAT('%',:nombre,'%') OR "
                + "p.materno LIKE CONCAT('%',:nombre,'%') OR "
                + "p.dni = :nombre ";
        Map<String, Object> params = new HashMap();
        params.put("nombre", nombre);
        return this.contar(jpql, params);
    }
}
