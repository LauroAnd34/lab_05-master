package transportadora.repository;

import jakarta.persistence.EntityManager;
import transportadora.entity.EntidadeBase;

import java.util.Objects;

class DAOGenerico<T extends EntidadeBase> {

    private final EntityManager manager;

    DAOGenerico(EntityManager manager) {
        this.manager = manager;
    }

    T buscaPorId(Class<T> clazz, Integer id) {
        return manager.find(clazz, id);
    }

    T salvaOuAtualiza(T t) {
        this.manager.getTransaction().begin();
        if( Objects.isNull(t.getId()) )
            this.manager.persist(t);
        else
            t = this.manager.merge(t);
        this.manager.getTransaction().commit();
        return t;
    }

    void remove(T t) {
        manager.remove(t);
        manager.flush();
    }
}