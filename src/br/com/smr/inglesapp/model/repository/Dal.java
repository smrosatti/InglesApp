/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.smr.inglesapp.model.repository;

import br.com.smr.inglesapp.model.Model;
import br.com.smr.inglesapp.model.Phrase;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author SARA
 */
public class Dal implements Serializable {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("InglesAppPU");

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public <G> boolean create(G g) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(g);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            closeAll(em);
        }
    }
    
     public List<Phrase> getPhrase(int id) {
        EntityManager em = getEntityManager();
        try {
            String sql = "select t from Phrase t where t.place.idPlace = " + id;
            Query query = getEntityManager().createQuery(sql);
            List<Phrase> list = query.getResultList();
            return list;
        } finally {
            closeAll(em);
        }
    }
    
     public <T> List<T> getList(Model m) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(m.getClass()));
            Query q = em.createQuery(cq);
            return q.getResultList();
        } catch (Exception e) {
            return null;

        } finally {
            closeAll(em);
        }
    }

    private void closeAll(EntityManager em) {
        if (em != null) {
            em.close();
        }
        if (emf != null) {
            emf.close();
        }
    }

}
