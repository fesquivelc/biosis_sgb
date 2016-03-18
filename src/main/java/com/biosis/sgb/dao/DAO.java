/*
 * Objecto change this license header, choose License Headers in Project Properties.
 * Objecto change this template file, choose Objectools | Objectemplates
 * and open the template in the editor.
 */
package com.biosis.sgb.dao;

import java.util.List;
import java.util.Map;

/**
 *
 * @author RyuujiMD
 * @param <Object>
 */
public interface DAO {
    public boolean guardar(Object objeto);
    public boolean eliminar(Object objeto);
    public boolean modificar(Object objeto);
    public boolean guardarLote(List<Object> objeto);
    public List buscarTodos(Class clase);
    public List buscar(String queryJPQL);
    public List buscar(String queryJPQL, Map<String, Object> parametros);
    public List buscar(String queryJPQL, Map<String, Object> parametros, int inicio, int tamanio);
    public int contar(String queryJPQL, Map<String, Object> parametros);
    public int contar(Class clase);
    public Object buscarPorId(Object id, Class clase);
    
}
