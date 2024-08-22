package transportadora.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import transportadora.entity.Frete;
import transportadora.repository.DistanciaRepository;
import transportadora.repository.FreteRepository;
import transportadora.util.EMFactory;


public class CadastroFreteService {

    private final FreteRepository freteRepository;
    private final EntityManager manager;
    private final CalculoValorFreteService calculoValorFreteService;


    public CadastroFreteService(EntityManager em){
        this.manager = EMFactory.getEntityManager();
        this.freteRepository = new FreteRepository(manager);
        DistanciaRepository distanciaRepository = new DistanciaRepository(manager);
        this.calculoValorFreteService = new CalculoValorFreteService(distanciaRepository);
    }

    public Frete cadastrarFrete(Frete frete) {
        EntityTransaction tx = null;
            tx = manager.getTransaction();
            tx.begin();
            if (frete.getCategoriaFrete() == null || frete.getCategoriaFrete().getId() == null) {
                throw new IllegalArgumentException("Categoria de frete inválida!!");
            }

        Frete freteExistente = manager.createQuery("SELECT f FROM Frete f WHERE f.numeroNotaFiscal = :numeroNotaFiscal", Frete.class).setParameter("numeroNotaFiscal", frete.getNumeroNotaFiscal()).getResultStream().findFirst().orElse(null);

        if (freteExistente != null) {
            throw new IllegalArgumentException("Já existe um frete com o mesmo número de nota fiscal!!");
        }

        double valorFrete = calculoValorFreteService.calcular(frete);
            frete.setValorFrete(valorFrete);
            manager.persist(frete);
            tx.commit();
            return frete;
    }
}
