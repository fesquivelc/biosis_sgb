/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.entidades;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "indice")
public class Indice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "indice_id")
    private long id;
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fecha_hora_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCreacion;
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fecha_hora_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraModificacion;
    @Column(nullable = false)
    private int orden;
    @Column
    private String descripcion;
//    @Column(name = "cantidad_subindice")
//    private int cantidadSubindice;
    
//    @ManyToOne(targetEntity = Indice.class, optional = true)
//    @JoinColumn(name = "indice_superior_id", referencedColumnName = "indice_id", nullable = true)
//    private Indice indice;
    @ManyToOne(targetEntity = Libro.class, optional = false)
    @JoinColumn(name = "libro_id", referencedColumnName = "libro_id", nullable = false)
    private Libro libro;

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

//    public int getCantidadSubindice() {
//        return cantidadSubindice;
//    }
//
//    public void setCantidadSubindice(int cantidadSubindice) {
//        this.cantidadSubindice = cantidadSubindice;
//    }
//
//    public Indice getIndice() {
//        return indice;
//    }
//
//    public void setIndice(Indice indice) {
//        this.indice = indice;
//    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
}
