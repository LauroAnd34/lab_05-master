package transportadora.service;

import jakarta.persistence.EntityManager;
import transportadora.entity.Frete;
import transportadora.repository.FreteRepository;

import java.util.List;

public class ListarFretesClienteService {
    private final FreteRepository freteRepository;

    public ListarFretesClienteService(EntityManager entityManager) {
        this.freteRepository = new FreteRepository(entityManager);
    }

    public List<Frete> listarFretesPorCliente(Integer clienteId) {
        return freteRepository.buscaPorCliente(clienteId);
    }
}
