package com.yomia.modulo.core;

import com.yomia.jpa.controler.BaseEntidade;

public abstract class Entidade {

    public abstract Entidade converteTabelaParaObjeto(BaseEntidade tb);
}
