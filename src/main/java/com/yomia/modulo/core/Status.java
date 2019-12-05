package com.yomia.modulo.core;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.jpa.dao.DaoStatus;
import com.yomia.jpa.entidade.TbStatus;

public class Status extends Entidade {

    String status;

    @Override
    public Entidade converteTabelaParaObjeto(BaseEntidade tb) {
        TbStatus bt = (TbStatus) tb;
        status = bt.getTitulo();
        return this;
    }

}
