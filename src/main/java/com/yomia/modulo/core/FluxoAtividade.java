package com.yomia.modulo.core;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.entidade.TbFluxoAtividade;

public class FluxoAtividade extends Entidade{

    @Override
    public Entidade converteTabelaParaObjeto(BaseEntidade tb) {
        TbFluxoAtividade l =(TbFluxoAtividade)tb;
        
        return this;
    }

}
