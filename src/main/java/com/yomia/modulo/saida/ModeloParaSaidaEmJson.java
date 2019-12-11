package com.yomia.modulo.saida;

import com.yomia.jpa.controler.BaseEntidade;

public interface ModeloParaSaidaEmJson {

    public abstract String[] converteParaArrayDeString(BaseEntidade bt);

}
