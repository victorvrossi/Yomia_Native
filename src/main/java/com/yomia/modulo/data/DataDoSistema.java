package com.yomia.modulo.data;

import java.util.Calendar;

public class DataDoSistema {

    static DataDoSistema novaData(Calendar c) {
        return new DataDoSistema(c);
    }
    private Calendar data;

    private DataDoSistema(Calendar data) {
        this.data = data;
    }

    public Calendar data() {
        return data;
    }

    int dia() {
        return data.get(Calendar.DATE);
    }
    int hora() {
        return data.get(Calendar.HOUR_OF_DAY);
    }
    int minuto() {
        return data.get(Calendar.MINUTE);
    }
    EnumDataMes mes() {
        return DataUtil.resgatarMes(data);
    }
    int ano() {
        return DataUtil.resgatarAno(data);
    }

}
