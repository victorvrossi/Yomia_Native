package com.yomia.jpa.controler;

import com.yomia.resource.YomiaResource;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class DaoGenerico<T extends BaseEntidade> {

    public abstract Class<T> getClasseTabela();

    protected EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(new YomiaResource().devolveAmbienteQueEstaEmExecucao().getNome());
        return factory.createEntityManager();
    }

    public T salvar(T obj) throws Exception {

        EntityManager manager = getEntityManager();

        try {
            manager.getTransaction().begin();
            if (obj.getId() == null) {
                manager.persist(obj);
            } else {
                if (!manager.contains(obj)) {
                    if (manager.find(obj.getClass(), obj.getId()) == null) {
                        throw new Exception("Falha ao Atualizar");
                    }
                }
                obj = manager.merge(obj);
            }

            manager.getTransaction().commit();
        } finally {
            manager.close();
        }

        return obj;
    }

    public void remover(Integer id) throws Exception {
        EntityManager manager = getEntityManager();
        T obj = manager.find(getClasseTabela(), id);
        try {
            manager.getTransaction().begin();
            manager.remove(obj);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }

    }

    public T consultarPorId( Integer id) {
        EntityManager manager = getEntityManager();
        T obj = null;
        try {
            manager.getTransaction().begin();
            obj = manager.find(getClasseTabela(), id);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
        return obj;
    }

    public List<BaseEntidade> carregarTodas(String queryNomeada) {
        EntityManager manager = getEntityManager();
        try {
            Query createNamedQuery = manager.createNamedQuery(getClasseTabela().getSimpleName() + "." + queryNomeada);
            if (createNamedQuery == null) {
                throw new NullPointerException("Não existe query");
            }
            return createNamedQuery.getResultList();
        } finally {
            manager.close();
        }
    }

}
