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

}
