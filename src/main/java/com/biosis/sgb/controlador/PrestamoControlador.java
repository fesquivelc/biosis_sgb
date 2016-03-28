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
public class PrestamoControlador extends Controlador<Prestamo> {

    private PrestamoControlador() {
        super(Prestamo.class);
    }

    public static PrestamoControlador getInstance() {
        return PrestamoControladorHolder.INSTANCE;
    }

    private static class PrestamoControladorHolder {

        private static final PrestamoControlador INSTANCE = new PrestamoControlador();
    }

    public List<Prestamo> buscarXLibro(Libro libro, boolean devolucionPendiente, Date fechaInicio, Date fechaFin, int inicio, int tamanio) {
        StringBuilder jpql = new StringBuilder("SELECT p FROM Prestamo p WHERE p.ejemplar.libro = :libro ");
        Map<String, Object> params = new HashMap();
        params.put("libro", libro);
        if (devolucionPendiente) {
            Date fechaActual = FechaUtil.soloFecha(new Date());
            params.put("fechaActual", fechaActual);
            jpql.append("AND (p.fechaEntrega IS NULL AND :fechaActual >= p.fechaDevolucion) ");
        }
        if (fechaInicio != null && fechaFin != null) {
            params.put("fechaInicio", fechaInicio);
            params.put("fechaFin", fechaFin);
            jpql.append("AND (:fechaInicio <= p.fechaPrestamo AND p.fechaPrestamo <= :fechaFin) ");
        }
        jpql.append("ORDER BY p.fechaDevolucion DESC");
//        System.out.println("JPQL: " + jpql.toString());
        return this.buscar(jpql.toString(), params, inicio, tamanio);
    }

    public int contarXLibro(Libro libro, boolean devolucionPendiente, Date fechaInicio, Date fechaFin) {
        StringBuilder jpql = new StringBuilder("SELECT COUNT(p) FROM Prestamo p WHERE p.ejemplar.libro = :libro ");
        Map<String, Object> params = new HashMap();
        params.put("libro", libro);
        if (devolucionPendiente) {
            Date fechaActual = FechaUtil.soloFecha(new Date());
            params.put("fechaActual", fechaActual);
            jpql.append("AND (p.fechaEntrega IS NULL AND :fechaActual >= p.fechaDevolucion) ");
        }
        if (fechaInicio != null && fechaFin != null) {
            params.put("fechaInicio", fechaInicio);
            params.put("fechaFin", fechaFin);
            jpql.append("AND (:fechaInicio <= p.fechaPrestamo AND p.fechaPrestamo <= :fechaFin) ");
        }
        return this.contar(jpql.toString(), params);
    }

    public List<Prestamo> buscarXPersona(Persona persona, boolean devolucionPendiente, Date fechaInicio, Date fechaFin, int inicio, int tamanio) {
        StringBuilder jpql = new StringBuilder("SELECT p FROM Prestamo p WHERE p.persona = :persona ");
        Map<String, Object> params = new HashMap();
        params.put("persona", persona);
        if (devolucionPendiente) {
            Date fechaActual = FechaUtil.soloFecha(new Date());
            params.put("fechaActual", fechaActual);
            jpql.append("AND (p.fechaEntrega IS NULL AND :fechaActual >= p.fechaDevolucion) ");
        }
        if (fechaInicio != null && fechaFin != null) {
            params.put("fechaInicio", fechaInicio);
            params.put("fechaFin", fechaFin);
            jpql.append("AND (:fechaInicio <= p.fechaPrestamo AND p.fechaPrestamo <= :fechaFin) ");
        }
        jpql.append("ORDER BY p.fechaDevolucion DESC");
        return this.buscar(jpql.toString(), params, inicio, tamanio);
    }

    public List<Prestamo> consultaMultiple(Persona persona, Libro libro, boolean devolucionPendiente, Date fechaInicio, Date fechaFin) {
        StringBuilder jpql = new StringBuilder("SELECT p FROM Prestamo p ");
        StringBuilder condiciones = new StringBuilder("");
        Map<String, Object> params = new HashMap();
        int conteo = 0;
        if (persona != null) {
            conteo++;
            params.put("persona", persona);
            condiciones.append("(p.persona = :persona)");
        }
        if (libro != null) {
            params.put("libro", libro);
            if (conteo > 0) {
                condiciones.append(" AND ");
            }
            conteo++;
            condiciones.append("(p.ejemplar.libro = :libro)");
        }
        if (devolucionPendiente) {
            if (conteo > 0) {
                condiciones.append(" AND ");
            }
            conteo++;
            Date fechaActual = FechaUtil.soloFecha(new Date());
            params.put("fechaActual", fechaActual);
            condiciones.append("(p.fechaEntrega IS NULL AND :fechaActual >= p.fechaDevolucion)");
        }
        if (fechaInicio != null && fechaFin != null) {
            if (conteo > 0) {
                condiciones.append(" AND ");
            }
            conteo++;
            params.put("fechaInicio", fechaInicio);
            params.put("fechaFin", fechaFin);
            condiciones.append("(:fechaInicio <= p.fechaPrestamo AND p.fechaPrestamo <= :fechaFin)");
        }
        jpql.append(condiciones);
        jpql.append("ORDER BY p.ejemplar.libro.seccion.materia.nombre, p.ejemplar.libro.seccion.nombre, p.ejemplar.libro.titulo, p.ejemplar.libro.id p.fechaEntrega DESC");
        System.out.println("CONSULTA MULTIPLE PRESTAMO: " + jpql.toString());
        return this.buscar(jpql.toString(), params);
    }

    public List<Prestamo> consultaMultiple(Persona persona, Libro libro, boolean devolucionPendiente, Date fechaInicio, Date fechaFin, int inicio, int tamanio) {
        StringBuilder jpql = new StringBuilder("SELECT p FROM Prestamo p");
        StringBuilder condiciones = new StringBuilder("");
        Map<String, Object> params = new HashMap();
        int conteo = 0;
        if (persona != null) {
            conteo++;
            params.put("persona", persona);
            condiciones.append("(p.persona = :persona)");
        }
        if (libro != null) {
            params.put("libro", libro);
            if (conteo > 0) {
                condiciones.append(" AND ");
            }
            conteo++;
            condiciones.append("(p.ejemplar.libro = :libro)");
        }
        if (devolucionPendiente) {
            if (conteo > 0) {
                condiciones.append(" AND ");
            }
            conteo++;
            Date fechaActual = FechaUtil.soloFecha(new Date());
            params.put("fechaActual", fechaActual);
            condiciones.append("(p.fechaEntrega IS NULL AND :fechaActual >= p.fechaDevolucion)");
        }
        if (fechaInicio != null && fechaFin != null) {
            if (conteo > 0) {
                condiciones.append(" AND ");
            }
            conteo++;
            params.put("fechaInicio", fechaInicio);
            params.put("fechaFin", fechaFin);
            condiciones.append("(:fechaInicio <= p.fechaPrestamo AND p.fechaPrestamo <= :fechaFin)");
        }
        if (conteo > 0) {
            jpql.append(" WHERE ");
            jpql.append(condiciones);
        }
        jpql.append(" ORDER BY p.ejemplar.libro.seccion.materia.nombre, p.ejemplar.libro.seccion.nombre, p.ejemplar.libro.titulo, p.fechaEntrega DESC");
        System.out.println("CONSULTA MULTIPLE PRESTAMO: " + jpql.toString());
        return this.buscar(jpql.toString(), params, inicio, tamanio);
    }

    public int contarXPersona(Persona persona, boolean devolucionPendiente, Date fechaInicio, Date fechaFin) {
        StringBuilder jpql = new StringBuilder("SELECT COUNT(p) FROM Prestamo p WHERE p.persona = :persona ");
        Map<String, Object> params = new HashMap();
        params.put("persona", persona);
        if (devolucionPendiente) {
            Date fechaActual = FechaUtil.soloFecha(new Date());
            params.put("fechaActual", fechaActual);
            jpql.append("AND (p.fechaEntrega IS NULL AND :fechaActual >= p.fechaDevolucion) ");
        }
        if (fechaInicio != null && fechaFin != null) {
            params.put("fechaInicio", fechaInicio);
            params.put("fechaFin", fechaFin);
            jpql.append("AND (:fechaInicio <= p.fechaPrestamo AND p.fechaPrestamo <= :fechaFin) ");
        }
        return this.contar(jpql.toString(), params);
    }

    public int contarMultiple(Persona persona, Libro libro, boolean devolucionPendiente, Date fechaInicio, Date fechaFin) {
        StringBuilder jpql = new StringBuilder("SELECT COUNT(p) FROM Prestamo p ");
        StringBuilder condiciones = new StringBuilder("");
        Map<String, Object> params = new HashMap();
        int conteo = 0;
        if (persona != null) {
            conteo++;
            params.put("persona", persona);
            condiciones.append("(p.persona = :persona)");
        }
        if (libro != null) {
            params.put("libro", libro);
            if (conteo > 0) {
                condiciones.append(" AND ");
            }
            conteo++;
            condiciones.append("(p.ejemplar.libro = :libro)");
        }
        if (devolucionPendiente) {
            if (conteo > 0) {
                condiciones.append(" AND ");
            }
            conteo++;
            Date fechaActual = FechaUtil.soloFecha(new Date());
            params.put("fechaActual", fechaActual);
            condiciones.append("(p.fechaEntrega IS NULL AND :fechaActual >= p.fechaDevolucion)");
        }
        if (fechaInicio != null && fechaFin != null) {
            if (conteo > 0) {
                condiciones.append(" AND ");
            }
            conteo++;
            params.put("fechaInicio", fechaInicio);
            params.put("fechaFin", fechaFin);
            condiciones.append("(:fechaInicio <= p.fechaPrestamo AND p.fechaPrestamo <= :fechaFin)");
        }
        if (conteo > 0) {
            jpql.append(" WHERE ");
            jpql.append(condiciones);
        }

//        jpql.append("ORDER BY p.ejemplar.libro.seccion.materia.nombre, p.ejemplar.libro.seccion.nombre, p.ejemplar.libro.titulo, p.fechaEntrega DESC");
        System.out.println("CONTAR CONSULTA MULTIPLE PRESTAMO: " + jpql.toString());
        return this.contar(jpql.toString(), params);
    }
}
