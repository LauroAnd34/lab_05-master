package transportadora.teste;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import transportadora.entity.Frete;
import transportadora.service.BuscaFreteIDService;

public class TesteBuscarFreteID {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab_05");
        EntityManager em = emf.createEntityManager();

        BuscaFreteIDService buscaService = new BuscaFreteIDService(em);
        Frete frete = buscaService.buscarFretePorId(1);

        System.out.println("Frete encontrado: " + frete);

        em.close();
        emf.close();
    }
}
