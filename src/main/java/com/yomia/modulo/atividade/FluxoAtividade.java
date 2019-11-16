
package com.yomia.modulo.atividade;

import com.yomia.jpa.dao.DaoFluxoAtividade;
import com.yomia.jpa.dao.DaoFluxoSequencia;
import com.yomia.jpa.entidade.TbFluxoAtividade;


public class FluxoAtividade {
    
    
    public void novoFluxo(){
        DaoFluxoAtividade novoFluxo = new DaoFluxoAtividade();
        DaoFluxoSequencia novaSequencia = new DaoFluxoSequencia();
        TbFluxoAtividade novoFluxoTb = novoFluxo.novoFluxo("Teste");
        
        
    }
    
}
