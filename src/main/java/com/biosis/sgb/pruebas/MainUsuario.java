/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.pruebas;

import com.biosis.sgb.controlador.UsuarioControlador;
import com.biosis.sgb.entidades.Usuario;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fesquivel
 */
public class MainUsuario {

    public static void main(String[] args) {
        UsuarioControlador uc = UsuarioControlador.getInstance();
        Usuario usuario = uc.realizarLogin("admin", "sgbmoquegua");

        if (usuario != null) {
            System.out.println(String.format("ULTIMO EVENTO: %s", usuario.getEvento().getFechaHora()));
        }

        try {
            InetAddress ip = InetAddress.getLocalHost();
            System.out.println(String.format("Dirección IP: %s", ip.getHostAddress()));
            byte[] mac = NetworkInterface.getByInetAddress(ip).getHardwareAddress();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            System.out.println(sb.toString());
        } catch (UnknownHostException ex) {
            Logger.getLogger(MainUsuario.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SocketException ex) {
            Logger.getLogger(MainUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.exit(0);
    }
}
