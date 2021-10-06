package repositorio;

import estructural.Mesa;
import estructural.Participante;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JavaServiceJPAParticipante {
    private final EntityManager em;

    public JavaServiceJPAParticipante() {
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

    public Participante persistParticipante(Participante participante) {
        em.persist(participante);
        commitTransaction();
        return participante;
    }

    public Participante mergeParticipante(Participante participante) {
        Participante entity = null;
        entity = em.merge(participante);
        commitTransaction();
        return entity;
    }

    public void removeParticipante(Participante participante) {
        participante = em.find(Participante.class, participante.getId());
        em.remove(participante);
        commitTransaction();
    }
    
    public List<Participante> listarParticipantes(){
        List<Participante> listaParticipantes= null;
     
        Query query = em.createQuery("SELECT p FROM Participante p");
        listaParticipantes  = query.getResultList();
        
        return listaParticipantes;
        
    }
    
}
