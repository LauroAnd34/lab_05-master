package transportadora.service;

import jakarta.persistence.EntityManager;
import transportadora.entity.Frete;
import transportadora.repository.FreteRepository;

public class BuscaFreteIDService {
    private final FreteRepository freteRepository;

    public BuscaFreteIDService(EntityManager entityManager) {
        this.freteRepository = new FreteRepository(entityManager);
    }

    public Frete buscarFretePorId(Integer id) {
        return freteRepository.buscaPorId(id);
    }
}
