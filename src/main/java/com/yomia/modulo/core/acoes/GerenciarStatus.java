package com.yomia.modulo.core.acoes;

import com.yomia.jpa.dao.DaoStatus;

public class GerenciarStatus {

    public static void cadastrar(String novo) {
        DaoStatus status = new DaoStatus();
        status.novoStatus(novo);
    }

}
