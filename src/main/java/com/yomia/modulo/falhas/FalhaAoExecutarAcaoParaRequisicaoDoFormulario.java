package com.yomia.modulo.falhas;

public class FalhaAoExecutarAcaoParaRequisicaoDoFormulario extends RuntimeException {

    public FalhaAoExecutarAcaoParaRequisicaoDoFormulario(String string) {
        super(string);
    }

}
