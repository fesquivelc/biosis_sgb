/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Ejemplar;
import com.biosis.sgb.entidades.Libro;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Francis
 */
public class EjemplarControlador extends Controlador<Ejemplar>{
    
    private EjemplarControlador() {
        super(Ejemplar.class);
    }
    
    public static EjemplarControlador getInstance() {
        return EjemplarControladorHolder.INSTANCE;
    }
    
    private static class EjemplarControladorHolder {

        private static final EjemplarControlador INSTANCE = new EjemplarControlador();
    }
    
    public List<Ejemplar> buscarXLibro(Libro libro, int inicio, int tamanio){
        String jpql = "SELECT e FROM Ejemplar e WHERE e.libro = :libro";
        Map<String, Object> params = new HashMap();
        params.put("libro", libro);
        return this.buscar(jpql, params, inicio, tamanio);
    }
}
