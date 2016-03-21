/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.entidades;
import java.util.Date;
import javax.persistence.*;
/**
 *
 * @author Francis
 */
@Entity
@Table(name = "ejemplar")
public class Ejemplar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ejemplar_id")
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
    private boolean activo;
    
    @Column(nullable = false)
    private String codigo;
    @Column(nullable = false)
    private int estado;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "fecha_entrada")
    private Date fechaEntrada;
    @ManyToOne(targetEntity = Libro.class)
    @JoinColumn(name = "libro_id", referencedColumnName = "libro_id")
    private Libro libro;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Procedencia.class)
    @JoinColumn(name = "procedencia_id", referencedColumnName = "procedencia_id")
    private Procedencia procedencia;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Procedencia getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(Procedencia procedencia) {
        this.procedencia = procedencia;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
    
}
