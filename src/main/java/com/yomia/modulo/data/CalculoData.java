package com.yomia.modulo.data;

import java.util.Calendar;

public class CalculoData {

    int tamanhoDoDia;

    public int restoTempo(int tempoEstimadoProjeto) {
        return tempoEstimadoProjeto % tamanhoDoDia;
    }

    void alterarTamanhoDeUmDia(int hora) {
        tamanhoDoDia = hora;
    }

    int calculaQuantidadeDeDiasDadoHora(int tempoEstimadoProjeto) {
        return arredondaParaBaixoContagemDeDias(tempoEstimadoProjeto) / tamanhoDoDia;
    }

    DataDoSistema calculaDataEntregaDadoConfiguracao(DataDoSistema entrada, int limite) {
        int totalDeDias = calculaQuantidadeDeDiasDadoHora(limite);
        int horas = restoTempo(limite);
        entrada.data().add(Calendar.DATE, totalDeDias);
        entrada.data().add(Calendar.HOUR_OF_DAY, horas);
        return entrada;
    }

    private int arredondaParaBaixoContagemDeDias(int tempoEstimadoProjeto) {
        return tempoEstimadoProjeto - restoTempo(tempoEstimadoProjeto);
    }

}
