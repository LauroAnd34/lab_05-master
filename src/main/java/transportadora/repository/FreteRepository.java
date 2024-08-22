package transportadora.repository;

import jakarta.persistence.EntityManager;
import transportadora.entity.Frete;

import java.util.List;

public class FreteRepository {
    private final EntityManager manager;
    private final DAOGenerico<Frete> daoGenerico;

    public FreteRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<Frete>(manager);
    }

    public Frete buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(Frete.class, id);
    }

    public List<Frete> buscaPorCliente(Integer clienteId) {
        return this.manager.createQuery("from Frete " +
                        "where cliente.id = :clienteId", Frete.class)
                .setParameter("clienteId", clienteId)
                .getResultList();
    }

    public List<Frete> readAll() {
        return this.manager.createQuery("from Frete", Frete.class).getResultList();
    }

    public Frete salvaOuAtualiza(Frete frete) {
        return daoGenerico.salvaOuAtualiza(frete);
    }

    public void remove(Frete frete) {
        daoGenerico.remove(frete);
    }
}
