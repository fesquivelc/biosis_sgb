/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.entidades;

import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francis
 */
@Entity
@Table(name = "seccion")
public class Seccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seccion_id")
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column
    private String descripcion;
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fecha_hora_creacion", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCreacion;
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fecha_hora_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraModificacion;
    @Column(nullable = false)
    private boolean activo;
    
    @ManyToOne(targetEntity = Materia.class)
    @JoinColumn(name = "materia_id", referencedColumnName = "materia_id")
    private Materia materia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
}
