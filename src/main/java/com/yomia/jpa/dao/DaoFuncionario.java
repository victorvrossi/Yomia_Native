
package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbFuncionario;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoFuncionario extends DaoGenerico<TbFuncionario>  {

    public TbFuncionario novoFuncionario(String nome){
        TbFuncionario func = new TbFuncionario();
        func.setNome(nome);
        try {
            salvar(func);
        } catch (Exception ex) {
            Logger.getLogger(DaoFuncionario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return func;
    }
    @Override
    public Class<TbFuncionario> getClasseTabela() {
        return TbFuncionario.class;
    }
    
}
