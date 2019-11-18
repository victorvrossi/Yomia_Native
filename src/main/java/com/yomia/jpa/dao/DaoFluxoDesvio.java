package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbFluxoDesvio;
import com.yomia.jpa.entidade.TbFluxoSequencia;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoFluxoDesvio extends DaoGenerico<TbFluxoDesvio>{

    public TbFluxoDesvio novoDesvio(TbFluxoSequencia partida,TbFluxoSequencia chegada){
        TbFluxoDesvio m = new TbFluxoDesvio();
        try {
            
            m.setIdSequenciaPartida(partida);
            m.setIdSequenciaChegada(chegada);
            
            salvar(m);
            
        } catch (Exception ex) {
            Logger.getLogger(DaoFluxoDesvio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return m;
    }
    @Override
    public Class<TbFluxoDesvio> getClasseTabela() {
        return TbFluxoDesvio.class;
    }

}
