/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francis
 */
@Entity
@Table(name = "tema")
public class Tema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tema_id")
    private int id;
    @Column(nullable = false)
    private String nombre;
    @Column
    private String descripcion;
    @Column(name = "cantidad_subtema", nullable = false)
    private int cantidadSubtema;
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
    @ManyToOne(targetEntity = Tema.class)
    @JoinColumn(name = "tema_superior_id", referencedColumnName = "tema_id")
    private Tema temaSuperior;
    @OneToMany(mappedBy = "temaSuperior")
    @OrderBy("nombre ASC")
    private List<Tema> temaList;

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

    public int getCantidadSubtema() {
        return cantidadSubtema;
    }

    public void setCantidadSubtema(int cantidadSubtema) {
        this.cantidadSubtema = cantidadSubtema;
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

    public Tema getTemaSuperior() {
        return temaSuperior;
    }

    public void setTemaSuperior(Tema temaSuperior) {
        this.temaSuperior = temaSuperior;
    }

    public List<Tema> getTemaList() {
        return temaList;
    }

    public void setTemaList(List<Tema> temaList) {
        this.temaList = temaList;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
    
    
    
}
