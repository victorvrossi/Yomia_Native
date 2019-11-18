package com.yomia.modulo.atividade;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.dao.DaoStatus;

public class Status extends Entidade{
    
    
    public void novoStatus(String novo){
        DaoStatus status = new DaoStatus();
        status.novoStatus(novo);
    }

    @Override
    public Entidade converteTabelaParaObjeto(BaseEntidade tb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
