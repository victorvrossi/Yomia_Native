package com.yomia.modulo.data;

public class ConfiguracaoCalculo {

    private int diaInicial = 0;
    private EnumDataMes mesInicial = null;
    private DataDoSistema fim = null;
    private int diaFinal = 0;
    private EnumDataMes mesFinal = null;

    public ConfiguracaoCalculo(DataDoSistema inicio, DataDoSistema fim) {
        diaInicial = inicio.dia();
        mesInicial = inicio.mes();        
        diaFinal = fim.dia();
        mesFinal = fim.mes();
    }

    public boolean periodoMesmoMes() {
        return mesInicial.equals(mesFinal);
    }

    public EnumDataMes mesInicial() {
        return mesInicial;
    }

    public EnumDataMes mesFinal() {
        return mesFinal;
    }

    public int diaInicial() {
        return diaInicial;
    }

    public int diaFinal() {
        return diaFinal;
    }
}
