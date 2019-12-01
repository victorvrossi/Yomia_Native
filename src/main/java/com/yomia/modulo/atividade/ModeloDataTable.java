package com.yomia.modulo.atividade;

import com.yomia.jpa.controler.BaseEntidade;

public abstract class ModeloDataTable extends Entidade{

    public abstract String[] converteParaArrayDeString(BaseEntidade bt);
}
