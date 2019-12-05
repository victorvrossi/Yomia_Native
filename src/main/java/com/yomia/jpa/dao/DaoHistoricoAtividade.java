package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbHistoricoStatusAtv;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.modulo.data.DataUtil;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.FalhaOperacaoDeBD;

public class DaoHistoricoAtividade extends DaoGenerico<TbHistoricoStatusAtv> {

    public void registrarHistorico(TbAtividade idAtividade, TbStatus idStatus) throws FalhaGenerica{
        TbHistoricoStatusAtv novo = new TbHistoricoStatusAtv();
        novo.setDataEfetivado(DataUtil.atual().data());
        novo.setIdAtividade(idAtividade);
        novo.setIdStatus(idStatus);
        salvar(novo);
    }
    @Override
    public Class<TbHistoricoStatusAtv> getClasseTabela() {
        return TbHistoricoStatusAtv.class;
    }

}
