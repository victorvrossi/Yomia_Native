package com.yomia.modulo.data;

import com.yomia.modulo.falhas.FalhaDeDivisao;
import java.util.Calendar;

public class CalculoData {

    private int tamanhoDoDia;
    private int horaEntrada;
    private int horaSaida;
    private int horaAlmocoTotal;
    private int horaAlmocoSaida;
    private int horaAlmocoEntrada;
    private boolean consideraAlmoco = false;

    public int restoTempo(int tempoEstimadoProjeto) {
        try {
            return tempoEstimadoProjeto % tamanhoDoDia;
        } catch (ArithmeticException e) {
            throw new FalhaDeDivisao();
        }
    }

    public DataDoSistema calculaDataEntregaDadoConfiguracao(DataDoSistema entrada, int limite) {
        entrada = calculaDataEntrega(entrada, limite);
        int totalDeDias = 0;
        entrada.data().add(Calendar.DATE, totalDeDias);
        return entrada;
    }

    public int calculaFeriadosNoPeriodo(DataDoSistema inicio, int totalDeDias, FeriadosCadastrados listaDeFeriados) {

        int contaFeriadosNoPeriodo = 0;
        EnumDataMes mesTemp;
        ConfiguracaoCalculo conf = new ConfiguracaoCalculo(inicio, calculaDataEntrega(inicio, totalDeDias));

        if (conf.periodoMesmoMes()) {
            mesTemp = conf.mesInicial();
            System.out.println("FOR:"+conf.diaInicial()+"/"+conf.diaFinal());
            for (int diaTemp = conf.diaInicial(); diaTemp <= conf.diaFinal(); diaTemp++) {
                contaFeriadosNoPeriodo += listaDeFeriados.verificaSeTemFeriado(diaTemp, mesTemp);
            }
        }
        return contaFeriadosNoPeriodo;
    }
    
    private DataDoSistema calculaDataEntrega(DataDoSistema s, int limite) {
        DataDoSistema entrada = DataUtil.copiarData(s);
        limite = ajusteLimiteCasoAntesDoExpediente(entrada, limite);
        entrada = ajustaLimiteCasoDepoisDoExpediente(entrada);
        int horas = restoTempo(limite);
        int totalDeDias = calculaQuantidadeDeDiasDadoHora(limite);        
        horas = calculaTempoDeAlmoco(horas);

        entrada.data().add(Calendar.DATE, totalDeDias);
        entrada.data().add(Calendar.HOUR_OF_DAY, horas);

        return entrada;
    }

    public int calculaFimDeSemanaNoPeriodo(DataDoSistema inicio, int totalDeDias, FeriadosCadastrados listaDeFeriados) {

        int contaFeriadosNoPeriodo = 0;
        EnumDataMes mesTemp;
        ConfiguracaoCalculo conf = new ConfiguracaoCalculo(inicio, calculaDataEntregaDadoConfiguracao(inicio, totalDeDias));
        if (conf.periodoMesmoMes()) {
            mesTemp = conf.mesInicial();
            for (int diaTemp = conf.diaInicial(); diaTemp <= conf.diaFinal(); diaTemp++) {
                if (DataDoSistema.finalDeSemana(diaTemp, mesTemp)) {
                    contaFeriadosNoPeriodo++;
                }
            }
        }
        return contaFeriadosNoPeriodo;
    }

    int calculaTempoDeAlmoco(int horas) {
        if ((horaEntrada + horas) > horaAlmocoEntrada) {
            if (consideraAlmoco) {
                horas += horaAlmocoTotal;
            }
        }
        return horas;
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

    int ajusteLimiteCasoAntesDoExpediente(DataDoSistema entrada, int limite) {
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

    int tamanhoDoDia() {
        return tamanhoDoDia;
    }

}