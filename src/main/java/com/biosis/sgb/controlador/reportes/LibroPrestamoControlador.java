/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador.reportes;

import com.biosis.sgb.controlador.Controlador;
import com.biosis.sgb.entidades.Autor;
import com.biosis.sgb.entidades.Editorial;
import com.biosis.sgb.entidades.Seccion;
import com.biosis.sgb.entidades.Tema;
import com.biosis.sgb.entidades.reporte.LibroPrestamo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Francis
 */
public class LibroPrestamoControlador extends Controlador<LibroPrestamo> {

    private LibroPrestamoControlador() {
        super(LibroPrestamo.class);
    }

    public static LibroPrestamoControlador getInstance() {
        return EjemplarPrestamoControladorHolder.INSTANCE;
    }

    private static class EjemplarPrestamoControladorHolder {

        private static final LibroPrestamoControlador INSTANCE = new LibroPrestamoControlador();
    }
    
    public List<LibroPrestamo> consultaMultiple(Autor autor, Editorial editorial, Seccion seccion, Tema tema, String tituloISBN, boolean soloDisponibles){
        return this.consultaMultiple(autor, editorial, seccion, tema, tituloISBN, soloDisponibles, -1);
    }

    public List<LibroPrestamo> consultaMultiple(Autor autor, Editorial editorial, Seccion seccion, Tema tema, String tituloISBN, boolean soloDisponibles, int maximo) {
        StringBuilder sb = new StringBuilder("SELECT lp FROM LibroPrestamo lp WHERE (lp.libro.titulo LIKE CONCAT('%',:titulo,'%') OR lp.libro.isbn10 = :titulo OR lp.libro.isbn13 = :titulo)");
        Map<String, Object> params = new HashMap();
        params.put("titulo", tituloISBN);
        if (autor != null) {
            params.put("autor", autor);
            sb.append(" AND EXISTS(SELECT la.id FROM LibroAutor la WHERE la.libro = lp.libro AND la.autor = :autor)");
        }
        if (editorial != null) {
            params.put("editorial", editorial);
            sb.append(" AND lp.libro.editorial = :editorial");
        }
        if (seccion != null) {
            params.put("seccion", seccion);
            sb.append(" AND lp.libro.seccion = :seccion");
        }
        if (tema != null) {
            params.put("tema", tema);
            sb.append(" AND EXISTS(SELECT lt.id FROM LibroTema lt WHERE lt.tema = :tema AND lt.libro = lp.libro)");
        }
        if (soloDisponibles) {
            sb.append(" AND lp.libro.ejemplarDisponible > 0");
        }
        sb.append(" AND lp.conteo > 0");
        sb.append(" ORDER BY lp.conteo DESC");
        if (maximo != -1) {
            return this.buscar(sb.toString(), params, -1, maximo);
        }
        return this.buscar(sb.toString(), params);
    }
}
