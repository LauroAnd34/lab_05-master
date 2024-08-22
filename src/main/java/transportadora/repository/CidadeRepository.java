package transportadora.repository;

import jakarta.persistence.EntityManager;
import transportadora.entity.Cidade;

import java.util.List;

public class CidadeRepository {
    private final EntityManager manager;
    private final DAOGenerico<Cidade> daoGenerico;

    public CidadeRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<Cidade>(manager);
    }

    public Cidade buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(Cidade.class, id);
    }

    public List<Cidade> buscaPorNome(String nome) {
        return this.manager.createQuery("from Cidade " +
                        "where upper(nome) like :nome", Cidade.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public List<Cidade> readAll() {
        return this.manager.createQuery("from Cidade", Cidade.class).getResultList();
    }

    public Cidade salvaOuAtualiza(Cidade cidade) {
        return daoGenerico.salvaOuAtualiza(cidade);
    }

    public void remove(Cidade cidade) {
        daoGenerico.remove(cidade);
    }
}
