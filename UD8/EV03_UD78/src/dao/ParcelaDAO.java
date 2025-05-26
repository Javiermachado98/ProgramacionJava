package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Parcela;

import java.util.List;

public class ParcelaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");

    public void guardar (Parcela parcela){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(parcela);
        em.getTransaction().commit();
        em.close();
    }


    public List<Parcela> ListaDeLasLibrerias(){
        EntityManager em = emf.createEntityManager();
        List<Parcela> myparcela = em.createQuery("SELECT p from Parcela p", Parcela.class).getResultList();
        em.close();
        return myparcela;
    }


}
