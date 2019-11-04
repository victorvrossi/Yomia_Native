
package com.yomia.jpa.dao;

import com.yomia.jpa.controler.DaoGenerico;
import com.yomia.jpa.entidade.TbAtividade;
import com.yomia.jpa.entidade.TbStatus;
import com.yomia.jpa.entidade.TbStatusAtividade;
import com.yomia.modulo.data.DataUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class DaoStatusAtividade extends DaoGenerico<TbStatusAtividade>{

    void consultaPorTitulo(TbAtividade atividade,String aberto) {
        TbStatus statusPesquisado = new DaoStatus().pesquisaPorTitulo(aberto);
         EntityManager manager = getEntityManager(); 
    }

    TbStatusAtividade novoStatus(TbAtividade idAtividade, TbStatus tbStatus) {
        TbStatusAtividade tbStatusAtividade = new TbStatusAtividade();
        tbStatusAtividade.setIdAtividade(idAtividade);
        tbStatusAtividade.setIdStatus(tbStatus);
        tbStatusAtividade.setDataEntrada(DataUtil.atual().data());
        return tbStatusAtividade;
    }
    
}
