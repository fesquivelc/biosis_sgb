/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Autor;
import com.biosis.sgb.entidades.Editorial;
import com.biosis.sgb.entidades.Libro;
import com.biosis.sgb.entidades.Seccion;
import com.biosis.sgb.entidades.Tema;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Francis
 */
public class LibroControlador extends Controlador<Libro> {

    private LibroControlador() {
        super(Libro.class);
    }

    public static LibroControlador getInstance() {
        return LibroControladorHolder.INSTANCE;
    }

    private static class LibroControladorHolder {

        private static final LibroControlador INSTANCE = new LibroControlador();
    }

    public List<Libro> consultaMultiple(Autor autor, Editorial editorial, Seccion seccion, Tema tema, String tituloISBN, boolean soloDisponibles, int inicio, int tamanio) {
        StringBuilder sb = new StringBuilder("SELECT l FROM Libro l WHERE (l.titulo LIKE CONCAT('%',:titulo,'%') OR l.isbn10 = :titulo OR l.isbn13 = :titulo)");
        Map<String, Object> params = new HashMap();
        params.put("titulo", tituloISBN);
        if (autor != null) {
            params.put("autor", autor);
            sb.append(" AND EXISTS(SELECT la.id FROM LibroAutor la WHERE la.libro = l AND la.autor = :autor)");
        }
        if (editorial != null) {
            params.put("editorial", editorial);
            sb.append(" AND l.editorial = :editorial");
        }
        if (seccion != null) {
            params.put("seccion", seccion);
            sb.append(" AND l.seccion = :seccion");
        }
        if (tema != null) {
            params.put("tema", tema);
            sb.append(" AND EXISTS(SELECT lt.id FROM LibroTema lt WHERE lt.tema = :tema AND lt.libro = l)");
        }
        if (soloDisponibles) {
            sb.append(" AND l.ejemplarDisponible > 0");
        }
        sb.append(" ORDER BY l.titulo ASC");

        return this.buscar(sb.toString(), params, inicio, tamanio);
    }

    public List<Libro> buscarXAutor(Autor autor, int inicio, int tamanio) {
        String jpql = "SELECT DISTINCT la.libro FROM LibroAutor la WHERE la.autor = :autor ORDER BY la.libro.titulo ASC";
        Map<String, Object> param = new HashMap();
        param.put("autor", autor);

        return this.buscar(jpql, param, inicio, tamanio);
    }

    public List<Libro> buscarXEditorial(Editorial editorial, int inicio, int tamanio) {
        String jpql = "SELECT l FROM Libro l WHERE l.editorial = :editorial ORDER BY l.titulo ASC";
        Map<String, Object> param = new HashMap();
        param.put("editorial", editorial);

        return this.buscar(jpql, param, inicio, tamanio);
    }

    public List<Libro> buscarXTitulo(String titulo, int inicio, int tamanio) {
        String jpql = "SELECT l FROM Libro l WHERE l.titulo LIKE CONCAT('%',:titulo,'%') ORDER BY l.titulo ASC";
        Map<String, Object> param = new HashMap();
        param.put("titulo", titulo);

        return this.buscar(jpql, param, inicio, tamanio);
    }

    public int totalXAutor(Autor autor) {
        String jpql = "SELECT COUNT(DISTINCT la.libro) FROM LibroAutor la WHERE la.autor = :autor";
        Map<String, Object> param = new HashMap();
        param.put("autor", autor);

        return this.contar(jpql, param);
    }

    public int totalXTitulo(String titulo) {
        String jpql = "SELECT COUNT(l) FROM Libro l WHERE l.titulo LIKE CONCAT('%',:titulo,'%')";
        Map<String, Object> param = new HashMap();
        param.put("titulo", titulo);

        return this.contar(jpql, param);
    }

    public int totalXEditorial(Editorial editorial) {
        String jpql = "SELECT COUNT(l) FROM Libro l WHERE l.editorial = :editorial";
        Map<String, Object> param = new HashMap();
        param.put("editorial", editorial);

        return this.contar(jpql, param);
    }

    public int contarMultiple(Autor autor, Editorial editorial, Seccion seccion, Tema tema, String tituloISBN, boolean soloDisponibles) {
        StringBuilder sb = new StringBuilder("SELECT COUNT(l.id) FROM Libro l WHERE (l.titulo LIKE CONCAT('%',:titulo,'%') OR l.isbn10 = :titulo OR l.isbn13 = :titulo)");
        Map<String, Object> params = new HashMap();
        params.put("titulo", tituloISBN);
        if (autor != null) {
            params.put("autor", autor);
            sb.append(" AND EXISTS(SELECT la FROM LibroAutor la WHERE la.libro = l AND la.autor = :autor)");
        }
        if (editorial != null) {
            params.put("editorial", editorial);
            sb.append(" AND l.editorial = :editorial");
        }
        if (seccion != null) {
            params.put("seccion", seccion);
            sb.append(" AND l.seccion = :seccion");
        }
        if (tema != null) {
            params.put("tema", tema);
            sb.append(" AND EXISTS(SELECT lt FROM LibroTema lt WHERE lt.tema = :tema AND lt.libro = l)");
        }
        if (soloDisponibles) {
            sb.append(" AND l.ejemplarDisponible > 0");
        }

        return this.contar(sb.toString(), params);
    }

    @Override
    public void prepararCrear() {
        super.prepararCrear(); //To change body of generated methods, choose Tools | Templates.
        this.getSeleccionado().setLibroAutorList(new ArrayList<>());
        this.getSeleccionado().setLibroTemaList(new ArrayList<>());
        this.getSeleccionado().setIndiceList(new ArrayList<>());
        this.getSeleccionado().setEjemplarList(new ArrayList<>());
    }
}
