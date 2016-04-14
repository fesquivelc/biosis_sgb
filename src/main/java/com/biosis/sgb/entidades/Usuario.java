/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.entidades;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
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
    
    @Column(nullable = false, length = 40)
    private String login;
    @Column(nullable = false, length = 100)
    private String password;
    @Column(nullable = false, name = "cambiar_password")
    private boolean cambiarPassword;
    
    @ManyToOne(targetEntity = Persona.class, optional = true,cascade = CascadeType.ALL)
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id", nullable = true)
    private Persona persona;
    @ManyToOne(targetEntity = Rol.class, optional = true)
    @JoinColumn(name = "rol_id", referencedColumnName = "rol_id", nullable = true)
    private Rol rol;
    @ManyToOne(targetEntity = Evento.class, optional = true)
    @JoinColumn(name = "evento_id", referencedColumnName = "evento_id", nullable = true)
    private Evento evento;

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isCambiarPassword() {
        return cambiarPassword;
    }

    public void setCambiarPassword(boolean cambiarPassword) {
        this.cambiarPassword = cambiarPassword;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
}
