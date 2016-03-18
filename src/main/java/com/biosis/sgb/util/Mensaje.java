/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.util;

/**
 *
 * @author Francis
 */
public class Mensaje {
    private String descripcion;
    private String recomendacion;

    public Mensaje(String descripcion, String recomendacion) {
        this.descripcion = descripcion;
        this.recomendacion = recomendacion;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
