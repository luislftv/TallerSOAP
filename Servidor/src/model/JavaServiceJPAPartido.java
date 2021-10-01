package model;

import estructural.Partido;
import estructural.PartidoPK;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JavaServiceJPAPartido {
    private final EntityManager em;

    public JavaServiceJPAPartido() {
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

    public Partido persistPartido(Partido partido) {
        em.persist(partido);
        commitTransaction();
        return partido;
    }

    public Partido mergePartido(Partido partido) {
        Partido entity = null;
        entity = em.merge(partido);
        commitTransaction();
        return entity;
    }

    public void removePartido(Partido partido) {
        partido =
            em.find(Partido.class,
                    new PartidoPK(partido.getParticipante().getId(), partido.getParticipante1().getId(),
                                  partido.getMesa().getId_mesa()));
        em.remove(partido);
        commitTransaction();
    }
}
