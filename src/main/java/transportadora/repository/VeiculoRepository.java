package transportadora.repository;

import jakarta.persistence.EntityManager;
import transportadora.entity.Veiculo;

import java.util.List;

public class VeiculoRepository {
    private final EntityManager manager;
    private final DAOGenerico<Veiculo> daoGenerico;

    public VeiculoRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<Veiculo>(manager);
    }

    public Veiculo buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(Veiculo.class, id);
    }

    public List<Veiculo> buscaPorPlaca(String placa) {
        return this.manager.createQuery("from Veiculo " +
                        "where upper(numeroPlaca) like :placa", Veiculo.class)
                .setParameter("placa", placa.toUpperCase() + "%")
                .getResultList();
    }

    public List<Veiculo> readAll() {
        return this.manager.createQuery("from Veiculo", Veiculo.class).getResultList();
    }

    public Veiculo salvaOuAtualiza(Veiculo veiculo) {
        return daoGenerico.salvaOuAtualiza(veiculo);
    }

    public void remove(Veiculo veiculo) {
        daoGenerico.remove(veiculo);
    }
}
