package com.yomia.jpa.controler;


import com.yomia.jpa.controler.Persistencia;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Victor
 * @param <T>
 * @since 03/11/2016
 */
public class DaoGenerico<T extends BaseEntidade> {

    Persistencia conexao = Persistencia.YOMIA_TEST;

    public void setConexao(Persistencia conexao) {
        this.conexao = conexao;
    }
    
    protected EntityManager getEntityManager() {
        validaPersistencia();
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(conexao.getNome());
        return factory.createEntityManager();
    }

    /**
     * Ação Salvar.
     * <br>
     * O Objeto quando efetuar a ação salvar, será feita uma verificação para
     * saber se o objeto existe, caso exista será feita Update, caso não exista
     * será feito o Insert.
     *
     * @param obj Objeto a ser adicionado ou atualizado
     * @return Objeto resultante da operação
     * @throws Exception Caso exista problemas de conexção com o banco de dados.
     */
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

}
