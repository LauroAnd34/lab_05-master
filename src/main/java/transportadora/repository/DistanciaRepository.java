package transportadora.repository;

import jakarta.persistence.EntityManager;
import transportadora.entity.Distancia;

import java.util.List;

public class DistanciaRepository {

    private final EntityManager manager;
    private final DAOGenerico<Distancia> daoGenerico;

    public DistanciaRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public Distancia buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(Distancia.class, id);
    }

    public List<Distancia> buscaPorCidadeOrigemEDestino(Integer cidadeOrigemId, Integer cidadeDestinoId) {
        return this.manager.createQuery("from Distancia " +
                        "where cidadeOrigem.id = :origemId and cidadeDestino.id = :destinoId", Distancia.class)
                .setParameter("origemId", cidadeOrigemId)
                .setParameter("destinoId", cidadeDestinoId)
                .getResultList();
    }

    public List<Distancia> readAll() {
        return this.manager.createQuery("from Distancia", Distancia.class).getResultList();
    }

    public Distancia salvaOuAtualiza(Distancia distancia) {
        return daoGenerico.salvaOuAtualiza(distancia);
    }

    public void remove(Distancia distancia) {
        daoGenerico.remove(distancia);
    }
}
