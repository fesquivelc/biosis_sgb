/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.dao;

import com.personal.utiles.ParametrosUtil;
import com.personal.utiles.PropertiesUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;

/**
 *
 * @author Francis
 */
public class DAOImp extends DAOJPA {

    private final String unidadPersistencia;
    private EntityManager entityManager;
    private static final Logger LOG = Logger.getLogger(DAOImp.class.getName());

    private DAOImp() {
        this.unidadPersistencia = "biblioteca-PU";
    }

    public static DAOImp getInstance() {
        return DAOHolder.INSTANCE;
    }

    @Override
    protected EntityManager getEntityManager() {
        if (entityManager == null) {
            Properties configuracion = PropertiesUtil.cargarProperties("configuracion/conexion.properties");
            int tipoBD = Integer.parseInt(configuracion.getProperty("tipo"));

            String driver = ParametrosUtil.obtenerDriver(tipoBD);
            String url = configuracion.getProperty("url");
            String usuario = configuracion.getProperty("usuario");
            String password = configuracion.getProperty("password");

            Map<String, String> properties = new HashMap<>();
            properties.put("javax.persistence.jdbc.user", usuario);
            properties.put("javax.persistence.jdbc.password", password.trim());
            properties.put("javax.persistence.jdbc.driver", driver);
            properties.put("javax.persistence.jdbc.url", url);
//            properties.put("hibernate.show_sql", "true");
            properties.put("javax.persistence.schema-generation.database.action", "none");

            try {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.unidadPersistencia, properties);
                entityManager = emf.createEntityManager();
            } catch (Exception e) {
                LOG.error("Error al obtener el entity manager", e);
            }

        }
        return entityManager;
    }

    private static class DAOHolder {

        private static final DAOImp INSTANCE = new DAOImp();
    }

}
