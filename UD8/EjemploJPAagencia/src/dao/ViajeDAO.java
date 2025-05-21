package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Viaje;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

public class ViajeDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");

    public void guardar(Viaje viaje) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(viaje);
        em.getTransaction().commit();
        em.close();
    }

    public List<Viaje> ListaTodosLosViajes() {
        EntityManager em = emf.createEntityManager();
        List<Viaje> viajes = em.createQuery("SELECT v FROM Viaje v", Viaje.class).getResultList();
        em.close();
        return viajes;
    }
}
