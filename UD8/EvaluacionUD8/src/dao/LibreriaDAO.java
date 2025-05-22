package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Libreria;
import model.Libro;
import java.util.List;

public class LibreriaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");

    public void guardar (Libreria libreria){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(libreria);
        em.getTransaction().commit();
        em.close();
    }

    public List<Libreria> ListaDeLasLibrerias(){
        EntityManager em = emf.createEntityManager();
        List<Libreria> arma = em.createQuery("SELECT l from Libreria l", Libreria.class).getResultList();
        em.close();
        return arma;
    }



}
