/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.biosis.sgb.controlador;

import com.biosis.sgb.dao.DAO;
import com.biosis.sgb.dao.DAOImp;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author gabriel
 * @param <T>
 */
public abstract class Controlador<T>{
    private final DAO dao;
    public static final int NUEVO = 1;
    public static final int MODIFICAR = 2;
    public static final int ELIMINAR = 3;
    public static final int LEER = 4;
    private T seleccionado;
    private final Class<T> seleccionadoClass;
    private static final Logger LOG = Logger.getLogger(Controlador.class.getName());
    

    public T getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(T seleccionado) {
        this.seleccionado = seleccionado;
    }        

    public DAO getDao() {
        return dao;
    }

    public Controlador(Class<T> clase) {
        this.seleccionadoClass = clase;
        this.dao = DAOImp.getInstance();
    }

    protected boolean guardar(T objeto) {
        try {
            return this.dao.guardar(objeto);
        } catch (Exception ex) {
            LOG.error("Error al guardar", ex);
            return false;
        }
    }
    
    protected boolean guardarLote(List<T> lote){
        try {
            return this.dao.guardarLote((List)lote);
        } catch (Exception ex) {
            LOG.error("Error al guardar lote: ", ex);
            return false;
        }
    }

    protected boolean modificar(T objeto) {
        try {
            return this.dao.modificar(objeto);
        } catch (Exception ex) {
            LOG.error("Error al modificar: ", ex);
            return false;
        }
    }

    protected boolean eliminar(T objeto) {
        try {
            return this.dao.eliminar(objeto);
        } catch (Exception ex) {
            LOG.error("Error al eliminar: ", ex);
            return false;
        }
    }
    
    public List<T> buscarTodos(){
        try {
            return this.dao.buscarTodos(this.seleccionadoClass);
        } catch (Exception ex) {
            LOG.error("Error al buscar todos: ", ex);
            return null;
        }
    }
    
    public T buscarPorId(Object id){
        try {
            return (T)this.dao.buscarPorId(id, this.seleccionadoClass);
        } catch (Exception ex) {
            LOG.error("Error al buscar por id: ", ex);
            return null;
        }
    }
    
    protected List<T> buscar(String jpql){
        try {
            return this.dao.buscar(jpql);
        } catch (Exception ex) {
            LOG.error("Error al buscar: ", ex);
            return null;
        }
    }
    
    protected List<T> buscar(String jpql, Map<String, Object> parametros){
        try {
            return this.dao.buscar(jpql, parametros);
        } catch (Exception ex) {
            LOG.error("Error al buscar: ", ex);
            return null;
        }
    }
    
    protected int contar(String jpql, Map<String, Object> parametros){
        try {
            return this.dao.contar(jpql, parametros);
        } catch (Exception ex) {
            LOG.error("Error al contar: ", ex);
            return -1;
        }
    }
    
    public int contar(){
        try {
            return this.dao.contar(this.seleccionadoClass);
        } catch (Exception ex) {
            LOG.error("Error al contar: ", ex);
            return -1;
        }
    }
    
    protected List<T> buscar(String jpql, Map<String, Object> parametros, int inicio, int tamanio){
        try {
            return this.dao.buscar(jpql, parametros, inicio, tamanio);
        } catch (Exception ex) {
            LOG.error("Error al buscar: ", ex);
            return null;
        }
    }
    
    public void prepararCrear(){
        try {
            seleccionado = seleccionadoClass.newInstance();
            BeanUtils.setProperty(seleccionado, "fechaHoraCreacion", new Date());
        } catch (InstantiationException | IllegalAccessException ex) {
            LOG.error("Error al preparar crear: ", ex);
        } catch (InvocationTargetException ex) {
            LOG.error("Error al hacer set a la fechaHoraCreacion: ",ex);
        }
    }
    
    
    public boolean accion(int accion) {
        switch (accion) {
            case Controlador.NUEVO:
                return this.guardar(seleccionado);
            case Controlador.MODIFICAR:
                return this.modificar(seleccionado);
            case Controlador.ELIMINAR:
                return this.eliminar(seleccionado);
            default:
                break;
        }
        return false;
    }
}
