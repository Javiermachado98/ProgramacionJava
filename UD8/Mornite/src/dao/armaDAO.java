package dao;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class armaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("miUnidadDePersistencia");


}
