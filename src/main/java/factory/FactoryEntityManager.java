package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryEntityManager {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    private FactoryEntityManager () {

    }

    public static EntityManager createConnection() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("Integrador2");
        }
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }

    public static void closeConnection() {
        em.close();
        emf.close();
    }

}
