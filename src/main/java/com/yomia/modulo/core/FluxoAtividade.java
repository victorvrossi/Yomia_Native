
package com.yomia.modulo.core;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.dao.DaoFluxoAtividade;
import com.yomia.jpa.dao.DaoFluxoSequencia;
import com.yomia.jpa.dao.DaoStatus;
import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbFluxoSequencia;
import com.yomia.jpa.entidade.TbStatus;
import java.util.ArrayList;
import java.util.List;


public class FluxoAtividade extends Entidade{
    
    
    public void novoFluxo(){
        
        List<TbFluxoSequencia> tbFluxoSequenciaList = new ArrayList<>();
        
        
        
        
        DaoFluxoAtividade novoFluxo = new DaoFluxoAtividade();
        TbFluxoAtividade k = novoFluxo.novoFluxo("Fluxo Alfa",tbFluxoSequenciaList);
        
        DaoStatus daoStatus = new DaoStatus();
        TbStatus status;
        
        DaoFluxoSequencia novaSequencia = new DaoFluxoSequencia();
        
        int idMala = daoStatus.novoStatus("Kaba").getId();
        
        int idAber = daoStatus.novoStatus("Dabra").getId();
        
        int idFecha = daoStatus.novoStatus("Xazam").getId();
        
        
        novaSequencia.novaSequencia(k, new DaoStatus().consultarPorId(idMala), 0);
        novaSequencia.novaSequencia(k, new DaoStatus().consultarPorId(idAber), 1);
        novaSequencia.novaSequencia(k, new DaoStatus().consultarPorId(idFecha), 2);
        
    }

    @Override
    public Entidade converteTabelaParaObjeto(BaseEntidade tb) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
