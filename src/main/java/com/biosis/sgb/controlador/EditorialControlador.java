/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Editorial;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Francis
 */
public class EditorialControlador extends Controlador<Editorial>{
    
    private EditorialControlador() {
        super(Editorial.class);
    }
    
    public static EditorialControlador getInstance() {
        return EditorialControladorHolder.INSTANCE;
    }
    
    private static class EditorialControladorHolder {

        private static final EditorialControlador INSTANCE = new EditorialControlador();
    }
    
    public List<Editorial> buscarXNombre(String nombre, int inicio, int tamanio){
        String jpql = "SELECT e FROM Editorial e WHERE e.nombre LIKE CONCAT('%',:nombre,'%') ORDER BY e.nombre";
        Map<String, Object> param = new HashMap();
        param.put("nombre", nombre);
        
        return this.buscar(jpql, param, inicio, tamanio);
    }
    
    public int contarXNombre(String nombre){
        String jpql = "SELECT COUNT(e) FROM Editorial e WHERE e.nombre LIKE CONCAT('%',:nombre,'%')";
        Map<String, Object> param = new HashMap();
        param.put("nombre", nombre);
        
        return this.contar(jpql, param);
    }
}
