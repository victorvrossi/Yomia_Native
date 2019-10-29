package com.yomia.jpa.controler;

public enum Persistencia {
    YOMIA_TEST("test_yomia"),
    YOMIA_PERSISTENCE("persistence_yomia");
    private String nome;

    public String getNome() {
        return nome;
    }
    
    private Persistencia(String valor) {
        this.nome = valor;
    }

}
