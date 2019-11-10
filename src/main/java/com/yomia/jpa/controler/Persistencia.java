package com.yomia.jpa.controler;

public enum Persistencia {
    YOMIA_TEST("homologacao_yomia"),
    YOMIA_PERSISTENCE("producao_yomia");
    private String nome;

    public String getNome() {
        return nome;
    }
    
    private Persistencia(String valor) {
        this.nome = valor;
    }

}
