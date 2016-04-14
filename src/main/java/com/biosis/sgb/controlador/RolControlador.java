/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.controlador;

import com.biosis.sgb.entidades.Acceso;
import com.biosis.sgb.entidades.Rol;
import com.biosis.sgb.entidades.RolAcceso;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author fesquivel
 */
public class RolControlador extends Controlador<Rol> {

    private final AccesoControlador accesoControlador = AccesoControlador.getInstance();

    private RolControlador() {
        super(Rol.class);
    }

    public static RolControlador getInstance() {
        return RolControladorHolder.INSTANCE;
    }

    private static class RolControladorHolder {

        private static final RolControlador INSTANCE = new RolControlador();
    }

    @Override
    public Rol prepararCrear() {
        super.prepararCrear(); //To change body of generated methods, choose Tools | Templates.
        List<Acceso> accesoList = accesoControlador.buscarTodos();
        List<RolAcceso> rolAccesoList = new ArrayList();
        Date date = new Date();
        accesoList.stream().forEach(acc -> rolAccesoList.add(new RolAcceso(date, "0000", this.getSeleccionado(), acc)));
        this.getSeleccionado().setRolAccesoList(rolAccesoList);
        return this.getSeleccionado();
    }

}
