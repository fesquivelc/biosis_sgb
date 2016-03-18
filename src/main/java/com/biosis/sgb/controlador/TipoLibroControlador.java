/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.TipoLibro;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Francis
 */
public class TipoLibroControlador extends Controlador<TipoLibro>{
    
    private TipoLibroControlador() {
        super(TipoLibro.class);
    }
    
    public static TipoLibroControlador getInstance() {
        return TipoLibroControladorHolder.INSTANCE;
    }
    
    private static class TipoLibroControladorHolder {

        private static final TipoLibroControlador INSTANCE = new TipoLibroControlador();
    }
    
    public List<TipoLibro> buscarXNombre(String nombre, int inicio, int tamanio){
        String jpql = "SELECT tl FROM TipoLibro tl WHERE tl.nombre LIKE CONCAT('%',:nombre,'%') OR tl.descripcion LIKE CONCAT('%',:nombre,'%') ORDER BY tl.nombre";
        Map<String, Object> params = new HashMap();
        params.put("nombre", nombre);
        return this.buscar(jpql, params, inicio, tamanio);
    }
    
    public int contarXNombre(String nombre){
        String jpql = "SELECT COUNT(tl) FROM TipoLibro tl WHERE tl.nombre LIKE CONCAT('%',:nombre,'%') OR tl.descripcion LIKE CONCAT('%',:nombre,'%')";
        Map<String, Object> params = new HashMap();
        params.put("nombre", nombre);
        return this.contar(jpql, params);
    }
}
