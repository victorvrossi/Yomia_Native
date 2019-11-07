package com.yomia.jpa.controler;


import com.yomia.jpa.controler.Persistencia;
import com.yomia.jpa.entidade.TbAtividade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


public abstract class DaoGenerico<T extends BaseEntidade> {

    Persistencia conexao = Persistencia.YOMIA_PERSISTENCE;

    public void setConexao(Persistencia conexao) {
        this.conexao = conexao;
    }
    
    
    public abstract Class<T> getClasseTabela(); 
    protected EntityManager getEntityManager() {
        validaPersistencia();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(conexao.getNome());
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

    public void remover(Class<T> clazz, Integer id) throws Exception {
        EntityManager manager = getEntityManager();
        T obj = manager.find(clazz, id);
        try {
            manager.getTransaction().begin();
            manager.remove(obj);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }

    }

    public T consultarPorId(Class<T> clazz, Integer id) {
        EntityManager manager = getEntityManager();
        T obj = null;
        try {
            manager.getTransaction().begin();
            obj = manager.find(clazz, id);
            manager.getTransaction().commit();
        } finally {
            manager.close();
        }
        return obj;

    }

    private void validaPersistencia() {
        if(conexao == null){
            throw new NullPointerException("Objeto de persistência está null"); 
        }
        
    }
    
     public List<BaseEntidade> carregarTodas(Class<T> t) {        
         EntityManager manager = getEntityManager();
        try {
             Query createNamedQuery = manager.createNamedQuery(t.getSimpleName()+".findAll");
             if(createNamedQuery == null){
                 throw new NullPointerException("Não existe query");
             }
             return createNamedQuery.getResultList();
        } finally {
            manager.close();
        }        
    }

}
