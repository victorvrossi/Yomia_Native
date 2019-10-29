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

    public int restoTempoEstimadoParaTamanhoDoDia(int tempoEstimadoProjeto) {
        try {
            return tempoEstimadoProjeto % tamanhoDoDia;
        } catch (ArithmeticException e) {
            throw new FalhaDeDivisao();
        }
    }

    public DataDoSistema calculaDataEntregaDadoPrazo(DataDoSistema entrada, int prazo) {
        return calculaDataEntrega(entrada, prazo);
    }

    public DataDoSistema calculaDataEntregaDadoPrazoConsiderandoFolga(DataDoSistema entrada, int prazo, FeriadosCadastrados listaDeFeriados) {
        DataDoSistema saida = calculaDataEntrega(entrada, prazo);
        int totalDeDias = 0;
        totalDeDias = calculaFolga(entrada, prazo, listaDeFeriados);        
        saida.calendario().add(Calendar.DATE, totalDeDias);
        return saida;
    }

    int calculaFolga(DataDoSistema entrada, int prazo, FeriadosCadastrados listaDeFeriados) {
        int totalDeDias = 0;
        int feriados = calculaFeriadosNoPeriodo(entrada, prazo, listaDeFeriados);
        int feriadosNoFDS = calculaFeriadosNoFimDeSemanaNoPeriodo(entrada, prazo, listaDeFeriados);
        int fimDeSemana = calculaFimDeSemanaNoPeriodo(entrada, prazo);

        totalDeDias = (feriados + fimDeSemana) - feriadosNoFDS;
        return totalDeDias;
    }

    int calculaFeriadosNoPeriodo(DataDoSistema inicio, int totalDeDias, FeriadosCadastrados listaDeFeriados) {
        int contaFeriadosNoPeriodo = 0;
        EnumDataMes mesTemp;
        ConfiguracaoCalculo conf = new ConfiguracaoCalculo(inicio, calculaDataEntrega(inicio, totalDeDias));

        if (conf.periodoMesmoMes()) {
            mesTemp = conf.mesInicial();
            for (int diaTemp = conf.diaInicial(); diaTemp <= conf.diaFinal(); diaTemp++) {
                contaFeriadosNoPeriodo += listaDeFeriados.verificaSeTemFeriado(diaTemp, mesTemp);
            }
        }
        return contaFeriadosNoPeriodo;
    }

    int calculaFeriadosNoFimDeSemanaNoPeriodo(DataDoSistema inicio, int totalDeDias, FeriadosCadastrados listaDeFeriados) {
        int contaFeriadosNoPeriodo = 0;
        EnumDataMes mesTemp;
        ConfiguracaoCalculo conf = new ConfiguracaoCalculo(inicio, calculaDataEntrega(inicio, totalDeDias));

        if (conf.periodoMesmoMes()) {
            mesTemp = conf.mesInicial();
            for (int diaTemp = conf.diaInicial(); diaTemp <= conf.diaFinal(); diaTemp++) {
                contaFeriadosNoPeriodo += listaDeFeriados.verificaSeTemFeriadoNoFimDeSemana(diaTemp, mesTemp);
            }
        }
        return contaFeriadosNoPeriodo;
    }

    private DataDoSistema calculaDataEntrega(DataDoSistema s, int prazo) {
        DataDoSistema entrada = DataUtil.copiarData(s);
        prazo = ajusteLimiteCasoAntesDoExpediente(entrada, prazo);
        entrada = ajustaLimiteCasoDepoisDoExpediente(entrada);
        int horas = restoTempoEstimadoParaTamanhoDoDia(prazo);
        int totalDeDias = calculaQuantidadeDeDiasDadoHora(prazo);
        horas = calculaTempoDeAlmoco(horas);

        entrada.calendario().add(Calendar.DATE, totalDeDias);
        entrada.calendario().add(Calendar.HOUR_OF_DAY, horas);

        return entrada;
    }

    int calculaFimDeSemanaNoPeriodo(DataDoSistema inicio, int totalDeDias) {
        DataDoSistema entrada = DataUtil.copiarData(inicio);

        int contaFeriadosNoPeriodo = 0;
        EnumDataMes mesTemp;
        ConfiguracaoCalculo conf = new ConfiguracaoCalculo(inicio, calculaDataEntregaDadoPrazo(entrada, totalDeDias));
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
        return tempoEstimadoProjeto - restoTempoEstimadoParaTamanhoDoDia(tempoEstimadoProjeto);
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
