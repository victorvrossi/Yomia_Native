package com.yomia.modulo.core.acoes;

import com.yomia.jpa.dao.DaoFluxoAtividade;
import com.yomia.jpa.entidade.TbFluxoAtividade;
import com.yomia.jpa.entidade.TbFluxoSequencia;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.modulo.core.FluxoAtividade;
import com.yomia.modulo.core.Status;
import com.yomia.modulo.core.TipoAtividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import java.util.ArrayList;
import java.util.List;

public class GerenciarFluxoAtividade implements GerenciarSistema{
    
    public TbFluxoAtividade novoFluxoParaAtividade(String titulo,TipoAtividade tipoAtividade,List<Status> listaStatus) throws FalhaGenerica{
        TbTipoAtividade tipo = buscarTipoAtividade(tipoAtividade);        
        DaoFluxoAtividade fluxo = new DaoFluxoAtividade();
        List<TbFluxoSequencia> listaSequencia =  carregaListaFluxoSequencia(listaStatus);
        
        FluxoAtividade flx = new FluxoAtividade();
        
       return fluxo.cadastrarNovoFluxo(titulo, tipo, listaSequencia);
    }

    private List<TbFluxoSequencia> carregaListaFluxoSequencia(List<Status> listaStatus) {
        GerenciarStatus gerenciarStatus = new GerenciarStatus();
        int ordem = 1;
        List<TbFluxoSequencia> listaSequencia = new ArrayList<TbFluxoSequencia>();
        for (Status listaStatu : listaStatus) {
            TbFluxoSequencia sequencia = new TbFluxoSequencia();
            sequencia.setIdStatus(gerenciarStatus.buscarStatus(listaStatu.getStatus()));
            sequencia.setOrdem(ordem);
            listaSequencia.add(sequencia);
            ordem += 1;
        }
        return listaSequencia;
    }

    private TbTipoAtividade buscarTipoAtividade(TipoAtividade tipoAtividade) throws FalhaGenerica {
        GerenciarTipoAtividade gerTipo = new GerenciarTipoAtividade();
        TbTipoAtividade tipo = gerTipo.buscarPorTitulo(tipoAtividade.getTitulo());
        return tipo;
    }

}
