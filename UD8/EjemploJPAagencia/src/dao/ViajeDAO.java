package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Viaje;

import javax.swing.text.html.parser.Entity;

public class ViajeDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");
    public void guardar(Viaje viaje){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(viaje);
        em.getTransaction().commit();
        em.close();
    }
}
