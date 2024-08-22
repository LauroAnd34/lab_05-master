package transportadora.repository;

import jakarta.persistence.EntityManager;
import transportadora.entity.Funcionario;

import java.util.List;

public class FuncionarioRepository {
    private final EntityManager manager;
    private final DAOGenerico<Funcionario> daoGenerico;

    public FuncionarioRepository(EntityManager manager) {
        this.manager = manager;
        this.daoGenerico = new DAOGenerico<Funcionario>(manager);
    }

    public Funcionario buscaPorId(Integer id) {
        return daoGenerico.buscaPorId(Funcionario.class, id);
    }

    public List<Funcionario> buscaPorNome(String nome) {
        return this.manager.createQuery("from Funcionario " +
                        "where upper(nome) like :nome", Funcionario.class)
                .setParameter("nome", nome.toUpperCase() + "%")
                .getResultList();
    }

    public List<Funcionario> readAll() {
        return this.manager.createQuery("from Funcionario", Funcionario.class).getResultList();
    }

    public Funcionario salvaOuAtualiza(Funcionario funcionario) {
        return daoGenerico.salvaOuAtualiza(funcionario);
    }

    public void remove(Funcionario funcionario) {
        daoGenerico.remove(funcionario );
    }
}
