/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Francis
 */
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "libro_id")
    private long id;
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fecha_hora_creacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraCreacion;
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "fecha_hora_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraModificacion;
    @Column(nullable = false)
    private boolean activo;

    @Column(nullable = false)
    private String titulo;
    @Column
    private int numero;
    @Column
    private int volumen;
    @Column
    private int tomo;
    @Column(name = "numero_paginas", nullable = false)
    private int numeroPaginas;
    @Column(name = "numero_edicion", nullable = false)
    private int numeroEdicion;
    @Column(name = "fecha_publicacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPublicacion;
    @Column(length = 10)
    private String isbn10;
    @Column(length = 13)
    private String isbn13;
    @Column(name = "direccion_fichero")
    private String direccionFichero;
    @Column
    private int formato;
    @Column(name = "ejemplar_total")
    private int ejemplarTotal;
    @Column(name = "ejemplar_disponible")
    private int ejemplarDisponible;

    public int getEjemplarTotal() {
        return ejemplarTotal;
    }

    public void setEjemplarTotal(int ejemplarTotal) {
        this.ejemplarTotal = ejemplarTotal;
    }

    public int getEjemplarDisponible() {
        return ejemplarDisponible;
    }

    public void setEjemplarDisponible(int ejemplarDisponible) {
        this.ejemplarDisponible = ejemplarDisponible;
    }

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Seccion.class)
    @JoinColumn(name = "seccion_id", referencedColumnName = "seccion_id")
    private Seccion seccion;
//    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Procedencia.class)
//    @JoinColumn(name = "procedencia_id", referencedColumnName = "procedencia_id")
//    private Procedencia procedencia;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TipoLibro.class)
    @JoinColumn(name = "tipo_libro_id", referencedColumnName = "tipo_libro_id")
    private TipoLibro tipoLibro;
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Editorial.class)
    @JoinColumn(name = "editorial_id", referencedColumnName = "editorial_id")
    private Editorial editorial;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "libro", targetEntity = LibroAutor.class, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<LibroAutor> libroAutorList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "libro", targetEntity = LibroTema.class, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<LibroTema> libroTemaList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "libro", targetEntity = Indice.class, orphanRemoval = true, cascade = CascadeType.ALL)
    @OrderBy("orden ASC")
    private List<Indice> indiceList;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "libro", targetEntity = Ejemplar.class, orphanRemoval = true, cascade = CascadeType.ALL)
    @OrderBy("fechaEnttrada ASC")
    private List<Ejemplar> ejemplarList;

    public List<Ejemplar> getEjemplarList() {
        return ejemplarList;
    }

    public void setEjemplarList(List<Ejemplar> ejemplarList) {
        this.ejemplarList = ejemplarList;
    }

    public List<Indice> getIndiceList() {
        return indiceList;
    }

    public void setIndiceList(List<Indice> indiceList) {
        this.indiceList = indiceList;
    }

    public List<LibroTema> getLibroTemaList() {
        return libroTemaList;
    }

    public void setLibroTemaList(List<LibroTema> libroTemaList) {
        this.libroTemaList = libroTemaList;
    }

    public List<LibroAutor> getLibroAutorList() {
        return libroAutorList;
    }

    public void setLibroAutorList(List<LibroAutor> libroAutorList) {
        this.libroAutorList = libroAutorList;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getVolumen() {
        return volumen;
    }

    public void setVolumen(int volumen) {
        this.volumen = volumen;
    }

    public int getTomo() {
        return tomo;
    }

    public void setTomo(int tomo) {
        this.tomo = tomo;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    public void setNumeroPaginas(int numeroPaginas) {
        this.numeroPaginas = numeroPaginas;
    }

    public int getNumeroEdicion() {
        return numeroEdicion;
    }

    public void setNumeroEdicion(int numeroEdicion) {
        this.numeroEdicion = numeroEdicion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public String getDireccionFichero() {
        return direccionFichero;
    }

    public void setDireccionFichero(String direccionFichero) {
        this.direccionFichero = direccionFichero;
    }

    public int getFormato() {
        return formato;
    }

    public void setFormato(int formato) {
        this.formato = formato;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

//    public Procedencia getProcedencia() {
//        return procedencia;
//    }
//
//    public void setProcedencia(Procedencia procedencia) {
//        this.procedencia = procedencia;
//    }
    public TipoLibro getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(TipoLibro tipoLibro) {
        this.tipoLibro = tipoLibro;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

}
