package transportadora.teste;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import transportadora.entity.Frete;
import transportadora.repository.DistanciaRepository;
import transportadora.service.CalculoValorFreteService;


public class TesteCalculoValor {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab_05");
        EntityManager em = emf.createEntityManager();


        Frete frete = em.find(Frete.class, "1");

        CalculoValorFreteService calculoService = new CalculoValorFreteService(new DistanciaRepository(em));
        calculoService.calcular(frete);

        System.out.println("Valor calculado do frete: " + frete.getValorFrete());

        em.close();
        emf.close();
    }
}

