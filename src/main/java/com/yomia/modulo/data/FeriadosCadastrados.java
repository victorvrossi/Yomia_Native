package com.yomia.modulo.data;

import java.util.ArrayList;

public final class FeriadosCadastrados {

    private ArrayList<Feriado> listaFeriados = new ArrayList<>();

    public int verificaSeTemFeriado(int diaTemp,EnumDataMes mesTemp) {
        if(listaFeriados.isEmpty()){
            return 0;
        }
        int contaFeriadosNoPeriodo = 0;
        for (Feriado feriado : listaFeriados) {
            if (feriado.verificaDataFeriado(diaTemp, mesTemp)) {
                contaFeriadosNoPeriodo++;
            }
        }
        System.out.println("Andando pela Feriado?:" + contaFeriadosNoPeriodo);
        return contaFeriadosNoPeriodo;
    }

    public void adicionarFeriado(Feriado f) {
        listaFeriados.add(f);
    }

}
