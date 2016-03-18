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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Francis
 */
@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "autor_id")
    private long id;
    @Column(nullable = false)
    private String nombres;
    @Column(nullable = false)
    private String paterno;
    @Column(nullable = false, name = "tipo_autor")
    private int tipoAutor;
    @Column(nullable = true)
    private String materno;
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

    public int getTipoAutor() {
        return tipoAutor;
    }

    public void setTipoAutor(int tipoAutor) {
        this.tipoAutor = tipoAutor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
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
}
