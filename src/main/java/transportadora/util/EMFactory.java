package transportadora.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceConfiguration;

public class EMFactory {

    private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab_05");

    public static EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    public void close(){
        factory.close();
    }
}
