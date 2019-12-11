package com.yomia.modulo.saida.dataTable;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.modulo.saida.ModeloParaSaidaEmJson;

public class ProcessaJsonAtividadeParaDataTable implements ModeloParaSaidaEmJson {

 
    @Override
    public String[] converteParaArrayDeString(BaseEntidade bt) {
        String[] arrayCamposAtividade = null;

        TbAtividade tb = (TbAtividade) bt;
        if (tb == null) {
            return arrayCamposAtividade;
        }
        try {

            final TbTipoAtividade idTipoAtividade = tb.getIdTipoAtividade();
            String atividadeTitulo = tb.getTitulo();
            String atividadeDescricao = tb.getDescricao();
            String atividadeCodigo = tb.getCodigoAtividade();

            String AtividadeTipo = idTipoAtividade.getTitulo();
            String AtividadeDataCriacao = tb.getDataCriacao().toString();

            String AtividadeNomeResponsavel = tb.getIdResponsavel().getNome();

            arrayCamposAtividade = new String[]{atividadeTitulo, atividadeDescricao, atividadeCodigo, AtividadeTipo, AtividadeDataCriacao, null, AtividadeNomeResponsavel};

        } catch (Exception e) {
            System.out.println("Falhou ao carregar atividade:" + e);
        }
        return arrayCamposAtividade;
    }
}
