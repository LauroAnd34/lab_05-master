package transportadora.repository;

import jakarta.persistence.EntityManager;
import transportadora.entity.TipoVeiculo;

import java.util.List;

public class TipoVeiculoRepository {

    private final EntityManager manager;
    private final DAOGenerico<TipoVeiculo> daoGenerico;

    public TipoVeiculoRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public TipoVeiculo buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(TipoVeiculo.class, id);
    }

    public TipoVeiculo salvaOuAtualiza(TipoVeiculo tipoVeiculo) {
        return daoGenerico.salvaOuAtualiza(tipoVeiculo);
    }

    public List<TipoVeiculo> readAll() {
        return this.manager.createQuery("from TipoVeiculo ", TipoVeiculo.class).getResultList();
    }

    public void remove(TipoVeiculo tipoVeiculo) {
        daoGenerico.remove(tipoVeiculo);
    }
}
