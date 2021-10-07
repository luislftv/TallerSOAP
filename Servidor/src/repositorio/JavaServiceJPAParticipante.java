package repositorio;

import estructural.Mesa;
import estructural.Participante;

import estructural.Partido;

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
    
    public Participante searchParticipante(Participante participante){
        Participante participanteb = em.find(Participante.class, participante.getId());
        return participanteb;
        }
    
    
    public Integer[] EstadisticasNegrasYBlancas(Participante participante){
        
        Integer[] res = new Integer[2]; 
        Query query1 = em.createQuery("Select count(*) from akira.partido where parcipante_1 ="+participante.getId());
        res [0] = (Integer) query1.getResultList().get(0); 
        Query query2 = em.createQuery("Select count(*) from akira.partido where parcipante_2 ="+participante.getId());
        res [1] = (Integer) query2.getResultList().get(1);
        
        return res;
    }
    
    public List<Partido> listarPartidosDeUnParticipante(Participante participante){
        
        Query query = em.createQuery("SELECT * FROM akira.partido where parcipante_1 ="+ participante.getId() +"or parcipante_2 ="+ participante.getId());
        return query.getResultList();  
    }
    
    
    public List<Participante> filtrarParticipantePorApodo(Participante participante){
        
        Query query = em.createQuery("SELECT * FROM Participante where apodo LIKE '%"+participante.getApodo()+"%' ");
        return query.getResultList();
    }
    
    public List<Participante> listarParticipantes(){
        List<Participante> listaParticipantes= null;
     
        Query query = em.createQuery("SELECT p FROM Participante p");
        listaParticipantes  = query.getResultList();
        
        return listaParticipantes;
        
    }
    
}
