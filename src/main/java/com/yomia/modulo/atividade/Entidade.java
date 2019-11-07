package com.yomia.modulo.atividade;

import com.yomia.jpa.controler.BaseEntidade;

public abstract class Entidade {

    public abstract Entidade converteTabelaParaObjeto(BaseEntidade tb);
}
