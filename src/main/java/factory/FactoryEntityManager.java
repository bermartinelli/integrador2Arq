package factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FactoryEntityManager {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Integrador2");
    private static EntityManager em;

    private FactoryEntityManager () {

    }

    public static EntityManager getInstance() {
        if ((em == null) ){
            em = emf.createEntityManager();
        }
        return em;
    }

    public static void closeConnection() {
        em.close();
        em = null;
        emf.close();
        emf = null;
    }

}
