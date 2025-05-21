package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Arma;
import java.util.List;

public class ArmaDAO {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");

    public void guardar (Arma arma){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(arma);
        em.getTransaction().commit();
        em.close();
    }

    public List<Arma> ListaDeLasArmas(){
        EntityManager em = emf.createEntityManager();
        List<Arma> arma = em.createQuery("SELECT a from Arma a", Arma.class).getResultList();
        em.close();
        return arma;
    }
}
