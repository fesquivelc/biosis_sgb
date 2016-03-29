/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.vistas.dialogos;

/**
 *
 * @author Francis
 * @param <T>
 */
public interface FormularioCRUD<T> {
    void guardarCambios();
    void volcarData(T seleccionado);
    void llenarCampos(T seleccionado);
    void inicializar(T seleccionado, int accion);
    void controles(int accion);
}
