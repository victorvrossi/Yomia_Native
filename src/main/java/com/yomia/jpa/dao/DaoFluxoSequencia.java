
package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbFluxoSequencia;
import com.yomia.jpa.entidade.TbStatus;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoFluxoSequencia extends DaoGenerico<TbFluxoSequencia>{

    
    public TbFluxoSequencia novaSequencia(TbFluxoAtividade t,TbStatus status,int ordem){
        TbFluxoSequencia nova = new TbFluxoSequencia();
        nova.setIdFluxo(t);
        nova.setIdStatus(status);
        nova.setOrdem(ordem);
        try {
            salvar(nova);
        } catch (Exception ex) {
            Logger.getLogger(DaoFluxoSequencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nova;
    }
    @Override
    public Class<TbFluxoSequencia> getClasseTabela() {
        return TbFluxoSequencia.class;
    }
    
    
}
