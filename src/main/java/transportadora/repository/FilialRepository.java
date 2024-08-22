package transportadora.repository;

import jakarta.persistence.EntityManager;
import transportadora.entity.Filial;

import java.util.List;

public class FilialRepository {
    private final EntityManager manager;
    private final DAOGenerico<Filial> daoGenerico;

    public FilialRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<Filial>(manager);
    }

    public Filial buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(Filial.class, id);
    }

    public List<Filial> buscaPorNome(String nome) {
        return this.manager.createQuery("from Filial " +
                        "where upper(nome) like :nome", Filial.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public List<Filial> readAll() {
        return this.manager.createQuery("from Filial", Filial.class).getResultList();
    }

    public Filial salvaOuAtualiza(Filial filial) {
        return daoGenerico.salvaOuAtualiza(filial);
    }

    public void remove(Filial filial) {
        daoGenerico.remove(filial);
    }
}
