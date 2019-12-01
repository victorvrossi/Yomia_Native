package com.yomia.modulo.saida;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.dao.DaoAtividade;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbStatusAtividade;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.modulo.core.Atividade;
import com.yomia.modulo.core.Entidade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.webform.json.model.CarregaListaJson;
import com.yomia.webform.json.JsonListarAtividades;

public class ProcessaJsonSaidaAtividade extends ModeloParaSaidaEmJson {

    public String geraListaJsonDeAtividades() throws FalhaGenerica {
        return geraListaJson(DaoAtividade.class, JsonListarAtividades.class, Atividade.class);
        
    }

    public String geraListaJsonDeAtividadesParaDataTable() throws FalhaGenerica {
        return geraListaJsonParaDataTable(DaoAtividade.class, ProcessaJsonSaidaAtividade.class);
    }

    @Override
    public String[] converteParaArrayDeString(BaseEntidade bt) {
        String[] arrayCamposAtividade = null;

        TbAtividade tb = (TbAtividade) bt;
        if (tb == null) {
            return arrayCamposAtividade;
        }
        try {

            final TbTipoAtividade idTipoAtividade = tb.getIdTipoAtividade();
            final TbStatusAtividade tbStatusAtividade = tb.getTbStatusAtividade();
            if (idTipoAtividade == null || tbStatusAtividade == null) {
                return arrayCamposAtividade;
            }
            String atividadeTitulo = tb.getTitulo();
            String atividadeDescricao = tb.getDescricao();
            String atividadeCodigo = tb.getCodigoAtividade();

            String AtividadeTipo = idTipoAtividade.getTitulo();
            String AtividadeDataCriacao = tb.getDataCriacao().toString();

            String AtividadeStatus = tbStatusAtividade.getIdStatus().getTitulo();
            String AtividadeNomeResponsavel = tb.getIdResponsavel().getNome();

//            if (AtividadeStatus == null || AtividadeStatus.equals("")) {
//                throw new NullPointerException("Falha ao carregar Status da atividade:" + tb.getId() + " StatusTB:" + tb.getTbStatusAtividade().getId() + ">>" + tb.getTbStatusAtividade().getIdStatus());
//            }
            arrayCamposAtividade = new String[]{atividadeTitulo, atividadeDescricao, atividadeCodigo, AtividadeTipo, AtividadeDataCriacao, AtividadeStatus, AtividadeNomeResponsavel};

        } catch (Exception e) {
            System.out.println("Falhou ao carregar atividade:" + e);
        }
        return arrayCamposAtividade;
    }
}
