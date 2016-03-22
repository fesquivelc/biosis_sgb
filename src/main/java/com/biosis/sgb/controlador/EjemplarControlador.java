/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Autor;
import com.biosis.sgb.entidades.Editorial;
import com.biosis.sgb.entidades.Ejemplar;
import com.biosis.sgb.entidades.Libro;
import com.biosis.sgb.entidades.Seccion;
import com.biosis.sgb.entidades.Tema;
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
        String jpql = "SELECT e FROM Ejemplar e WHERE e.libro = :libro ORDER BY e.fechaEntrada DESC";
        Map<String, Object> params = new HashMap();
        params.put("libro", libro);
        return this.buscar(jpql, params, inicio, tamanio);
    }
    
    public List<Ejemplar> buscarXLibroYDisponible(Libro libro){
        String jpql = "SELECT e FROM Ejemplar e WHERE e.libro = :libro AND e.estado = 1 ORDER BY e.fechaEntrada DESC";
        Map<String, Object> params = new HashMap();
        params.put("libro", libro);
        return this.buscar(jpql, params);
    }
    
    public int contarXLibro(Libro libro){
        String jpql = "SELECT COUNT(e.id) FROM Ejemplar e WHERE e.libro = :libro";
        Map<String, Object> params = new HashMap();
        params.put("libro", libro);
        return this.contar(jpql, params);
    }
    
    public List<Ejemplar> consultaMultiple(Autor autor, Editorial editorial, Seccion seccion, Tema tema, String tituloISBN, boolean soloDisponibles, int inicio, int tamanio) {
        StringBuilder sb = new StringBuilder("SELECT e FROM Ejemplar e WHERE (e.libro.titulo LIKE CONCAT('%',:titulo,'%') OR e.libro.isbn10 = :titulo OR e.libro.isbn13 = :titulo)");
        Map<String, Object> params = new HashMap();
        params.put("titulo", tituloISBN);
        if (autor != null) {
            params.put("autor", autor);
            sb.append(" AND EXISTS(SELECT la.id FROM LibroAutor la WHERE la.libro = e.libro AND la.autor = :autor)");
        }
        if (editorial != null) {
            params.put("editorial", editorial);
            sb.append(" AND e.libro.editorial = :editorial");
        }
        if (seccion != null) {
            params.put("seccion", seccion);
            sb.append(" AND e.libro.seccion = :seccion");
        }
        if (tema != null) {
            params.put("tema", tema);
            sb.append(" AND EXISTS(SELECT lt.id FROM LibroTema lt WHERE lt.tema = :tema AND lt.libro = e.libro)");
        }
        if (soloDisponibles) {
            sb.append(" AND e.estado = 1");
        }
        sb.append(" ORDER BY e.libro.titulo ASC");

        return this.buscar(sb.toString(), params, inicio, tamanio);
    }
    
    public int contarMultiple(Autor autor, Editorial editorial, Seccion seccion, Tema tema, String tituloISBN, boolean soloDisponibles) {
        StringBuilder sb = new StringBuilder("SELECT COUNT(e) FROM Ejemplar e WHERE (e.libro.titulo LIKE CONCAT('%',:titulo,'%') OR e.libro.isbn10 = :titulo OR e.libro.isbn13 = :titulo)");
        Map<String, Object> params = new HashMap();
        params.put("titulo", tituloISBN);
        if (autor != null) {
            params.put("autor", autor);
            sb.append(" AND EXISTS(SELECT la.id FROM LibroAutor la WHERE la.libro = e.libro AND la.autor = :autor)");
        }
        if (editorial != null) {
            params.put("editorial", editorial);
            sb.append(" AND e.libro.editorial = :editorial");
        }
        if (seccion != null) {
            params.put("seccion", seccion);
            sb.append(" AND e.libro.seccion = :seccion");
        }
        if (tema != null) {
            params.put("tema", tema);
            sb.append(" AND EXISTS(SELECT lt.id FROM LibroTema lt WHERE lt.tema = :tema AND lt.libro = e.libro)");
        }
        if (soloDisponibles) {
            sb.append(" AND e.estado = 1");
        }

        return this.contar(sb.toString(), params);
    }
}
