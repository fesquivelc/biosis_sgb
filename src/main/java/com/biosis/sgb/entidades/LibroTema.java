/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.entidades;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "libro_tema")
public class LibroTema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_tema_id")
    private long id;
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fecha_hora_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCreacion;
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fecha_hora_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraModificacion;
    
    @ManyToOne(targetEntity = Tema.class)
    @JoinColumn(name = "tema_id", referencedColumnName = "tema_id")
    private Tema tema;
    @ManyToOne(targetEntity = Libro.class)
    @JoinColumn(name = "libro_id", referencedColumnName = "libro_id")
    private Libro libro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getFechaHoraCreacion() {
        return fechaHoraCreacion;
    }

    public void setFechaHoraCreacion(Date fechaHoraCreacion) {
        this.fechaHoraCreacion = fechaHoraCreacion;
    }

    public Date getFechaHoraModificacion() {
        return fechaHoraModificacion;
    }

    public void setFechaHoraModificacion(Date fechaHoraModificacion) {
        this.fechaHoraModificacion = fechaHoraModificacion;
    }

    public Tema getTema() {
        return tema;
    }

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
}
