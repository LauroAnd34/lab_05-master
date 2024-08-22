package transportadora.repository;


import jakarta.persistence.EntityManager;
import transportadora.entity.Cliente;

import java.util.List;

public class ClienteRepository {

    private final EntityManager manager;
    private DAOGenerico<Cliente> daoGenerico;

    public ClienteRepository(EntityManager manager) {
        this.manager = manager;
        daoGenerico = new DAOGenerico<Cliente>(manager);
    }

    public Cliente buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(Cliente.class, id);
    }

    public List<Cliente> buscaPorNome(String nome) {
        return this.manager.createQuery("from Cliente " +
                        "where upper(nome) like :nome", Cliente.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public List<Cliente> readAll() {
        return this.manager.createQuery("from Cliente", Cliente.class).getResultList();
    }

    public Cliente salvaOuAtualiza(Cliente cliente) {
        return daoGenerico.salvaOuAtualiza(cliente);
    }

    public void remove(Cliente cliente) {
        daoGenerico.remove(cliente );
    }
}