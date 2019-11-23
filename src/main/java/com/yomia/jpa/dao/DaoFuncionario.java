package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbFuncionario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoFuncionario extends DaoGenerico<TbFuncionario> {

    public TbFuncionario novoFuncionario(String nome) {
        TbFuncionario func = new TbFuncionario();
        func.setNome(nome);
        try {
            salvar(func);
        } catch (Exception ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return func;
    }

    public List<TbFuncionario> pesquisaPorNome(String teste) {
        String queryNomeada = "SELECT t FROM TbFuncionario t WHERE t.nome = :nome";
        EntityManager manager = getEntityManager();
        try {
            Query createNamedQuery = manager.createQuery(queryNomeada);

            if (createNamedQuery == null) {
                throw new NullPointerException("Não existe query");
            }
            createNamedQuery.setParameter("nome", teste);
            return createNamedQuery.getResultList();
        } finally {
            manager.close();
        }
    }

    @Override
    public Class<TbFuncionario> getClasseTabela() {
        return TbFuncionario.class;
    }

}
