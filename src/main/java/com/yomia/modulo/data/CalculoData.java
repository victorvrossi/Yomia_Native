package com.yomia.modulo.data;

import java.util.Calendar;

public class CalculoData {

    int tamanhoDoDia;

    int horaEntrada;
    int horaSaida;
    int horaAlmocoTotal;
    int horaAlmocoSaida;
    int horaAlmocoEntrada;
    boolean consideraAlmoco = true;

    public int restoTempo(int tempoEstimadoProjeto) {
        return tempoEstimadoProjeto % tamanhoDoDia;
    }

    void alterarTamanhoDeUmDia(int entrada, int saida, int almoco) {
        horaEntrada = entrada;
        horaSaida = saida;
        horaAlmocoTotal = almoco;
        tamanhoDoDia = (saida - entrada) - almoco;
        horaAlmocoEntrada = 12;
        horaAlmocoSaida = horaAlmocoEntrada + horaAlmocoTotal;
    }

    int calculaQuantidadeDeDiasDadoHora(int tempoEstimadoProjeto) {
        return arredondaParaBaixoContagemDeDias(tempoEstimadoProjeto) / tamanhoDoDia;
    }

    DataDoSistema calculaDataEntregaDadoConfiguracao(DataDoSistema entrada, int limite) {
        limite = ajusteLimiteCasoAntesDoExpediente(entrada, limite);
        entrada = ajustaLimiteCasoDepoisDoExpediente(entrada);
        int horas = restoTempo(limite);
        int totalDeDias = calculaQuantidadeDeDiasDadoHora(limite);
        entrada.data().add(Calendar.DATE, totalDeDias);
        if ((horaEntrada + horas) > horaAlmocoEntrada) {
            if(consideraAlmoco){
                horas += horaAlmocoTotal;
            }
        }
        entrada.data().add(Calendar.HOUR_OF_DAY, horas);

        return entrada;
    }

    public int ajusteLimiteCasoAntesDoExpediente(DataDoSistema entrada, int limite) {
        int horaDantes = tempoAteHoraEntrada(entrada);
        if (horaDantes < 0) {
                horaDantes = horaDantes * (-1);
                limite += horaDantes;
        }
        return limite;
    }

    private int arredondaParaBaixoContagemDeDias(int tempoEstimadoProjeto) {
        return tempoEstimadoProjeto - restoTempo(tempoEstimadoProjeto);
    }

    private int tempoAteHoraEntrada(DataDoSistema entrada) {
        int horaLancada = entrada.hora();
        return horaLancada - horaEntrada;
    }

    private DataDoSistema ajustaLimiteCasoDepoisDoExpediente(DataDoSistema entrada) {
        int hora = entrada.hora();
        if (hora > horaSaida) {
            return DataUtil.dataManual(entrada.ano(), entrada.mes(), (entrada.dia() + 1), horaEntrada, 0);
        }
        return entrada;
    }

    void consideraAlmoco(boolean b) {
        consideraAlmoco = b;
    }

}
