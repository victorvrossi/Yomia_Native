
package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbFluxoDesvio;
import com.yomia.jpa.entidade.TbFluxoSequencia;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.modulo.atividade.FluxoAtividade;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoFluxoSequencia extends DaoGenerico<TbFluxoSequencia>{

    
    public void novaSequencia(TbFluxoAtividade t,TbStatus status){
        TbFluxoSequencia nova = new TbFluxoSequencia();
        nova.setIdFluxo(t);
        nova.setIdStatus(status);
        try {
            salvar(nova);
        } catch (Exception ex) {
            Logger.getLogger(DaoFluxoSequencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    @Override
    public Class<TbFluxoSequencia> getClasseTabela() {
        return TbFluxoSequencia.class;
    }
    
    
}
