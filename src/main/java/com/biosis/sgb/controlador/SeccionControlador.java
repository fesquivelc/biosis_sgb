/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Materia;
import com.biosis.sgb.entidades.Seccion;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Francis
 */
public class SeccionControlador extends Controlador<Seccion> {
    
    private SeccionControlador() {
        super(Seccion.class);
    }
    
    public static SeccionControlador getInstance() {
        return SeccionControladorHolder.INSTANCE;
    }
    
    private static class SeccionControladorHolder {

        private static final SeccionControlador INSTANCE = new SeccionControlador();
    }
    
    public List<Seccion> buscarXNombre(String nombre, int inicio, int tamanio){
        String jpql = "SELECT s FROM Seccion s WHERE s.nombre LIKE CONCAT('%',:nombre,'%') OR s.descripcion LIKE CONCAT('%',:nombre,'%') ORDER BY s.nombre";
        Map<String, Object> params = new HashMap();
        params.put("nombre", nombre);
        return this.buscar(jpql, params, inicio, tamanio);
    }
    
    public List<Seccion> buscarXNombreYMateria(String nombre, Materia materia, int inicio, int tamanio){
        String jpql = "SELECT s FROM Seccion s WHERE (s.nombre LIKE CONCAT('%',:nombre,'%') OR s.descripcion LIKE CONCAT('%',:nombre,'%')) AND s.materia = :materia ORDER BY s.nombre";
        Map<String, Object> params = new HashMap();
        params.put("nombre", nombre);
        params.put("materia", materia);
        return this.buscar(jpql, params, inicio, tamanio);
    }
    
    public int contarXNombre(String nombre){
        String jpql = "SELECT COUNT(s) FROM Seccion s WHERE s.nombre LIKE CONCAT('%',:nombre,'%') OR s.descripcion LIKE CONCAT('%',:nombre,'%')";
        Map<String, Object> params = new HashMap();
        params.put("nombre", nombre);
        return this.contar(jpql, params);
    }
    
    public int contarXNombreYMateria(String nombre, Materia materia){
        String jpql = "SELECT COUNT(s) FROM Seccion s WHERE (s.nombre LIKE CONCAT('%',:nombre,'%') OR s.descripcion LIKE CONCAT('%',:nombre,'%')) AND s.materia = :materia";
        Map<String, Object> params = new HashMap();
        params.put("nombre", nombre);
        params.put("materia", materia);
        return this.contar(jpql, params);
    }
    
}
