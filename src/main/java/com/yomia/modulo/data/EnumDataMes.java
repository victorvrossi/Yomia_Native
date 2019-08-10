package com.yomia.modulo.data;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public enum EnumDataMes {
    JANEIRO(Calendar.JANUARY),
    FEVEREIRO(Calendar.FEBRUARY),
    MARCO(Calendar.MARCH),
    ABRIL(Calendar.APRIL),
    MAIO(Calendar.MAY),
    JUNHO(Calendar.JUNE),
    JULHO(Calendar.JULY),
    AGOSTO(Calendar.AUGUST),
    SETEMBRO(Calendar.SEPTEMBER),
    OUTUBRO(Calendar.OCTOBER),
    NOVEMBRO(Calendar.NOVEMBER),
    DEZEMBRO(Calendar.DECEMBER);

    private static Map<Integer, EnumDataMes> relacao;

    public int valorMes;

    EnumDataMes(int mes) {
        valorMes = mes;
    }

    @Override
    public String toString() {
        return retornaMes(valorMes).name();
    }

    public static EnumDataMes retornaMes(int mes) {
        return relacao.get(mes);
    }

    static {
        relacao = new HashMap<>();
        for (EnumDataMes s : values()) {
            relacao.put(s.valorMes, s);
        }
    }

}
