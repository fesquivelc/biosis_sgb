/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.biosis.sgb.dao;

import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author Francis
 */
public abstract class DAOJPA implements DAO {

    protected abstract EntityManager getEntityManager();
    private static final Logger LOG = Logger.getLogger(DAOJPA.class.getName());

    @Override
    public boolean guardar(Object objeto) {
        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            getEntityManager().persist(objeto);
            transaction.commit();
            getEntityManager().clear();
            return true;
        } catch (Exception e) {
            LOG.error("Error al guardar", e);
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean modificar(Object objeto) {
        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            getEntityManager().merge(objeto);
            transaction.commit();
            getEntityManager().clear();
            return true;
        } catch (Exception e) {
            LOG.error("Error al modificar", e);
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean eliminar(Object objeto) {
        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            getEntityManager().remove(objeto);
            transaction.commit();
            getEntityManager().clear();
            return true;
        } catch (Exception e) {
            LOG.error("Error al eliminar", e);
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public boolean guardarLote(List objetoList) {
        EntityTransaction transaction = getEntityManager().getTransaction();
        try {
            transaction.begin();
            objetoList.stream().forEach((Object o) -> getEntityManager().persist(o));
            transaction.commit();
            getEntityManager().clear();
            return true;
        } catch (Exception e) {
            LOG.error("Error al guardar lote", e);
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;
        }
    }

    @Override
    public List buscarTodos(Class clase) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(clase));
        return getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public List buscar(String queryJPQL) {
        return this.buscar(queryJPQL, null, -1, -1);
    }

    @Override
    public List buscar(String queryJPQL, Map<String, Object> parametros) {
        return this.buscar(queryJPQL, parametros, -1, -1);
    }

    @Override
    public List buscar(String queryJPQL, Map<String, Object> parametros, int inicio, int tamanio) {
        try {
            Query query = getEntityManager().createQuery(queryJPQL);

            if (parametros != null) {
                parametros.entrySet().stream().forEach((Map.Entry<String, Object> entry) -> {
                    query.setParameter(entry.getKey(), entry.getValue());
                });
            }

            if (inicio != -1) {
                query.setFirstResult(inicio);
            }

            if (tamanio != -1) {
                query.setMaxResults(tamanio);
            }

            List lista = query.getResultList();

            return lista;
        } catch (Exception e) {
            LOG.error("Error al buscar", e);
            return null;
        }
    }

    @Override
    public int contar(String queryJPQL, Map<String, Object> parametros) {
        try {
            Query query = getEntityManager().createQuery(queryJPQL);

            if (parametros != null) {
                parametros.entrySet().stream().forEach((Map.Entry<String, Object> entry) -> {
                    query.setParameter(entry.getKey(), entry.getValue());
                });
            }

            Long conteo = (Long) query.getSingleResult();

            return conteo.intValue();
        } catch (Exception e) {
            LOG.error("Error al contar", e);
            return -1;
        }
    }

    @Override
    public List buscarNativo(String sql, Class clazz, Map<String, Object> parametros, int inicio, int tamanio) {
        try {
            Query query = getEntityManager().createNativeQuery(sql, clazz);

            if (parametros != null) {
                parametros.entrySet().stream().forEach((Map.Entry<String, Object> entry) -> {
                    query.setParameter(entry.getKey(), entry.getValue());
                });
            }

            if (inicio != -1) {
                query.setFirstResult(inicio);
            }

            if (tamanio != -1) {
                query.setMaxResults(tamanio);
            }

            List lista = query.getResultList();

            return lista;
        } catch (Exception e) {
            LOG.error("Error al buscar", e);
            return null;
        }
    }
    
    

    @Override
    public Object buscarPorId(Object id, Class clase) {
        try {
            return getEntityManager().find(clase, id);
        } catch (Exception e) {
            LOG.error("Error al buscar por ID", e);
            return null;
        }

    }

    @Override
    public int contar(Class clase) {
        try {
            javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
            javax.persistence.criteria.Root rt = cq.from(clase);
            cq.select(getEntityManager().getCriteriaBuilder().count(rt));
            javax.persistence.Query q = getEntityManager().createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } catch (Exception e) {
            LOG.error("Error al contar todos", e);
            return -1;
        }

    }

}
