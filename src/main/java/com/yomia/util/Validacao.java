package com.yomia.util;

import com.yomia.jpa.controler.BaseEntidade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.FalhaOperacaoDeBD;

public class Validacao {

    public static void verificaTabela(BaseEntidade projeto) throws FalhaGenerica {
        if (verificaSeNull(projeto) || verificaSeNull(projeto.getId())) {
            throw new FalhaOperacaoDeBD("Entrada NULL em DataAtividade");
        }
    }

    public static boolean verificaSeVazio(String titulo) {
        return titulo.equals("");
    }

    public static boolean verificaSeNull(Object titulo) {
        return titulo == null;
    }

}
