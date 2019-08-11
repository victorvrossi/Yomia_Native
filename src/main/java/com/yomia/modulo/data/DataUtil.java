package com.yomia.modulo.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class DataUtil {

    public static DataDoSistema atual() {
        Calendar c = Calendar.getInstance();
        return DataDoSistema.novaData(c);
    }

    public static DataDoSistema dataManual(int ano, EnumDataMes mes, int dia) {
        Calendar c = new GregorianCalendar(ano, mes.valorMes, dia);
        return DataDoSistema.novaData(c);
    }

    public static DataDoSistema dataManual(int ano, EnumDataMes mes, int dia, int hora, int minuto) {
        Calendar c = new GregorianCalendar(ano, mes.valorMes, dia, hora, minuto);
        return DataDoSistema.novaData(c);
    }

    public static DataDoSistema copiarData(DataDoSistema d) {
        int ano = d.ano();
        EnumDataMes mes = d.mes();
        int dia = d.dia();
        int hora = d.hora();
        int minuto = d.minuto();
        Calendar c = new GregorianCalendar(ano, mes.valorMes, dia, hora, minuto);
        return DataDoSistema.novaData(c);
    }

    public static String formatarData(Date data) {
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd");
        return formatarDate.format(data);
    }

    public static String formatarDataYYYYMMDDHHMI(Date data) {
        SimpleDateFormat formatarDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return formatarDate.format(data);
    }

    public static EnumDataMes resgatarMes(Calendar data) {
        return EnumDataMes.retornaMes(data.get(Calendar.MONTH));
    }

    public static int resgatarAno(Calendar data) {
        return data.get(Calendar.YEAR);
    }

    public static int resgatarDia(Calendar data) {
        return data.get(Calendar.DAY_OF_MONTH);
    }

    public static int contaDiasDaDataEntradaAteDataSaida(Calendar entrada, Calendar saida) {
        long longEntrada = entrada.getTimeInMillis();
        long longSaida = saida.getTimeInMillis();
        long resolverProblemaComHorarioDeVeraoComUmaHora = 3600000L;
        long resultado = (longSaida - longEntrada) + resolverProblemaComHorarioDeVeraoComUmaHora;
        return (int) (resultado / 86400000L);
    }

    public static EnumDataMes resgatarMesAnterior(Calendar atual) {
        EnumDataMes mesAtual = resgatarMes(atual);
        if (mesAtual == EnumDataMes.JANEIRO) {
            return mesAtual.DEZEMBRO;
        }
        int iMesAnterior = mesAtual.valorMes - 1;
        return EnumDataMes.retornaMes(iMesAnterior);
    }

}
