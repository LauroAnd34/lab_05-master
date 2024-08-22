package transportadora.repository;

import jakarta.persistence.EntityManager;
import transportadora.entity.CategoriaFrete;

import java.util.List;

public class CategoriaFreteRepository {

    private final EntityManager manager;
    private final DAOGenerico<CategoriaFrete> daoGenerico;

    public CategoriaFreteRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<>(manager);
    }

    public CategoriaFrete buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(CategoriaFrete.class, id);
    }

    public List<CategoriaFrete> readAll() {
        return this.manager.createQuery("from CategoriaFrete", CategoriaFrete.class)
                .getResultList();
    }

    public CategoriaFrete salvaOuAtualiza(CategoriaFrete categoriaFrete) {
        return daoGenerico.salvaOuAtualiza(categoriaFrete);
    }

    public void remove(CategoriaFrete categoriaFrete) {
        daoGenerico.remove(categoriaFrete);
    }
}
