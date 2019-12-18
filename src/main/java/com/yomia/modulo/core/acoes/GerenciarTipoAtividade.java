package com.yomia.modulo.core.acoes;

import com.yomia.jpa.dao.DaoFluxoAtividade;
import com.yomia.jpa.dao.DaoTipoAtividade;
import com.yomia.jpa.entidade.TbTipoAtividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.FalhaOperacaoDeBD;

public class GerenciarTipoAtividade {

    TbTipoAtividade buscarPorTitulo(String titulo) throws FalhaGenerica {
        DaoTipoAtividade m = new DaoTipoAtividade();
        TbTipoAtividade tipo = m.carregaTipoAtividadePorTitulo(titulo);
        if (tipo == null) {
            throw new FalhaOperacaoDeBD("Tipo não encontrato").lancarError("Tipo de Atividade não encontrato", "Error", "erro");
        }
        return tipo;
    }

}
