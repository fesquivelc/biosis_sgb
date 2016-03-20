/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Libro;
import com.biosis.sgb.entidades.Persona;
import com.biosis.sgb.entidades.Prestamo;
import com.personal.utiles.FechaUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Francis
 */
public class PrestamoControlador extends Controlador<Prestamo>{
    
    private PrestamoControlador() {
        super(Prestamo.class);
    }
    
    public static PrestamoControlador getInstance() {
        return PrestamoControladorHolder.INSTANCE;
    }
    
    private static class PrestamoControladorHolder {

        private static final PrestamoControlador INSTANCE = new PrestamoControlador();
    }
    
    public List<Prestamo> buscarXLibro(Libro libro, boolean devolucionPendiente, Date fechaInicio, Date fechaFin, int inicio, int tamanio){
        StringBuilder jpql = new StringBuilder("SELECT p FROM Prestamo p WHERE p.ejemplar.libro = :libro ");
        Map<String, Object> params = new HashMap();
        params.put("libro", libro);
        if(devolucionPendiente){
            Date fechaActual = FechaUtil.soloFecha(new Date());
            params.put("fechaActual", fechaActual);
            jpql.append("AND (p.fechaEntrega IS NULL AND :fechaActual >= p.fechaDevolucion) ");
        }
        if(fechaInicio != null && fechaFin != null){
            params.put("fechaInicio", fechaInicio);
            params.put("fechaFin", fechaFin);
            jpql.append("AND (:fechaInicio <= p.fechaPrestamo AND p.fechaPrestamo <= :fechaFin) ");
        }
        jpql.append("ORDER BY p.fechaDevolucion DESC");
        return this.buscar(jpql.toString(), params, inicio, tamanio);
    }
    
    public int contarXLibro(Libro libro, boolean devolucionPendiente, Date fechaInicio, Date fechaFin){
        StringBuilder jpql = new StringBuilder("SELECT COUNT(p) FROM Prestamo p WHERE p.ejemplar.libro = :libro ");
        Map<String, Object> params = new HashMap();
        params.put("libro", libro);
        if(devolucionPendiente){
            Date fechaActual = FechaUtil.soloFecha(new Date());
            params.put("fechaActual", fechaActual);
            jpql.append("AND (p.fechaEntrega IS NULL AND :fechaActual >= p.fechaDevolucion) ");
        }
        if(fechaInicio != null && fechaFin != null){
            params.put("fechaInicio", fechaInicio);
            params.put("fechaFin", fechaFin);
            jpql.append("AND (:fechaInicio <= p.fechaPrestamo AND p.fechaPrestamo <= :fechaFin) ");
        }
        return this.contar(jpql.toString(), params);
    }
    
    public List<Prestamo> buscarXPersona(Persona persona, boolean devolucionPendiente, Date fechaInicio, Date fechaFin, int inicio, int tamanio){
        StringBuilder jpql = new StringBuilder("SELECT p FROM Prestamo p WHERE p.persona = :persona ");
        Map<String, Object> params = new HashMap();
        params.put("persona", persona);
        if(devolucionPendiente){
            Date fechaActual = FechaUtil.soloFecha(new Date());
            params.put("fechaActual", fechaActual);
            jpql.append("AND (p.fechaEntrega IS NULL AND :fechaActual >= p.fechaDevolucion) ");
        }
        if(fechaInicio != null && fechaFin != null){
            params.put("fechaInicio", fechaInicio);
            params.put("fechaFin", fechaFin);
            jpql.append("AND (:fechaInicio <= p.fechaPrestamo AND p.fechaPrestamo <= :fechaFin) ");
        }
        jpql.append("ORDER BY p.fechaDevolucion DESC");
        return this.buscar(jpql.toString(), params, inicio, tamanio);
    }
    
    public int contarXPersona(Persona persona, boolean devolucionPendiente, Date fechaInicio, Date fechaFin){
        StringBuilder jpql = new StringBuilder("SELECT COUNT(p) FROM Prestamo p WHERE p.persona = :persona ");
        Map<String, Object> params = new HashMap();
        params.put("persona", persona);
        if(devolucionPendiente){
            Date fechaActual = FechaUtil.soloFecha(new Date());
            params.put("fechaActual", fechaActual);
            jpql.append("AND (p.fechaEntrega IS NULL AND :fechaActual >= p.fechaDevolucion) ");
        }
        if(fechaInicio != null && fechaFin != null){
            params.put("fechaInicio", fechaInicio);
            params.put("fechaFin", fechaFin);
            jpql.append("AND (:fechaInicio <= p.fechaPrestamo AND p.fechaPrestamo <= :fechaFin) ");
        }
        return this.contar(jpql.toString(), params);
    }
}
