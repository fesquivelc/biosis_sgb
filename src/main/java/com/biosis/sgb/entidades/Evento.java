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
 * @author fesquivel
 */
@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "evento_id")
    private int id;
    @Column(length = 1)
    private String tipo;
    @Column(length = 140)
    private String tabla;
    @Column(length = 16, name = "direccion_ip")
    private String direccionIP;
    @Column(length = 23, name = "direccion_mac")
    private String direccionMAC;
    @Column(name = "fecha_hora", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHora;    
    @ManyToOne(targetEntity = Usuario.class, optional = true)
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id", nullable = true)
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }

    public String getDireccionIP() {
        return direccionIP;
    }

    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    public String getDireccionMAC() {
        return direccionMAC;
    }

    public void setDireccionMAC(String direccionMAC) {
        this.direccionMAC = direccionMAC;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
