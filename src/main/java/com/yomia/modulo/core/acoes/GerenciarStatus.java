package com.yomia.modulo.core.acoes;

import com.yomia.jpa.dao.DaoStatus;
import com.yomia.jpa.entidade.TbStatus;

public class GerenciarStatus implements GerenciarSistema{

    public static void cadastrar(String novo) {
        DaoStatus status = new DaoStatus();
        status.novoStatus(novo);
    }

    TbStatus buscarStatus(String string) {
        DaoStatus m = new DaoStatus();
        TbStatus l= m.pesquisaPorTitulo(string);
        return l;
    }

}
