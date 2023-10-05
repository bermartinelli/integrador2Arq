import entities.*;
import dto.*;
import Repository.*;

import factory.FactoryEntityManager;
import javax.persistence.EntityManager;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        EntityManager em = FactoryEntityManager.createConnection();
        em.getTransaction().begin();
        FactoryEntityManager.closeConnection();
        em.close();
    }
}
