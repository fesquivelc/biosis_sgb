/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.entidades.reporte;

/**
 *
 * @author Francis
 */
import com.biosis.sgb.entidades.Libro;
import javax.persistence.*;
@Entity
@Table(name = "v_libro_prestamo")
public class LibroPrestamo {
    @Id
    @Column(name = "libro_id")
    private long id;
    @Column
    private int conteo;
    
    @ManyToOne(targetEntity = Libro.class)
    @JoinColumn(name = "libro_id", referencedColumnName = "libro_id",insertable = false,updatable = false)
    private Libro libro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getConteo() {
        return conteo;
    }

    public void setConteo(int conteo) {
        this.conteo = conteo;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
}
