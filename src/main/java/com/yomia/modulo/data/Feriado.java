
package com.yomia.modulo.data;

public class Feriado {

    EnumDataMes mes;
    int dia;
    void dataFeriado(EnumDataMes mes, int dia) {
        this.mes = mes;
        this.dia = dia;
        
    }
    
    boolean verificaDataFeriado(int diaCorrente,EnumDataMes mesCorrente){
        if(mes.equals(mesCorrente) && diaCorrente == dia){
            return true;
        }
        return false;
    }
}
