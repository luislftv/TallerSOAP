package servidor;

import estructural.Mesa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JavaServiceJPAMesa {
    private final EntityManager em;

    public JavaServiceJPAMesa() {
        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("Servidor-1");
        em = emf.createEntityManager();
    }

    /**
     * All changes that have been made to the managed entities in the
     * persistence context are applied to the database and committed.
     */
    public void commitTransaction() {
        final EntityTransaction entityTransaction = em.getTransaction();
        if (!entityTransaction.isActive()) {
            entityTransaction.begin();
        }
        entityTransaction.commit();
    }

    public Object queryByRange(String jpqlStmt, int firstResult, int maxResults) {
        Query query = em.createQuery(jpqlStmt);
        if (firstResult > 0) {
            query = query.setFirstResult(firstResult);
        }
        if (maxResults > 0) {
            query = query.setMaxResults(maxResults);
        }
        return query.getResultList();
    }

    public <T> T persistEntity(T entity) {
        em.persist(entity);
        commitTransaction();
        return entity;
    }

    public <T> T mergeEntity(T entity) {
        entity = em.merge(entity);
        commitTransaction();
        return entity;
    }

    public Mesa persistMesa(Mesa mesa) {
        em.persist(mesa);
        commitTransaction();
        return mesa;
    }

    public Mesa mergeMesa(Mesa mesa) {
        Mesa entity = null;
        entity = em.merge(mesa);
        commitTransaction();
        return entity;
    }

    public void removeMesa(Mesa mesa) {
        mesa = em.find(Mesa.class, mesa.getId_mesa());
        em.remove(mesa);
        commitTransaction();
    }
}
