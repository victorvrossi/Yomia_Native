package com.yomia.modulo.data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FeriadoTest {

    int tempoEstimadoProjeto = EnvorimentData.tempoEstimado();
    CalculoData calc = EnvorimentData.calcula();

    @Test
    public void testVerificaDataFeriado() {
        Feriado f = new Feriado();
        f.dataFeriado(EnumDataMes.DEZEMBRO, 25);
        DataDoSistema dataManual = DataUtil.dataManual(2019, EnumDataMes.DEZEMBRO, 25);
        assertTrue(f.verificaDataFeriado(dataManual.dia(), dataManual.mes()));
    }

    @Test
    public void testCalculaComFeriadoNoPeriodo() {
        Feriado f = new Feriado();
        f.dataFeriado(EnumDataMes.MAIO, 11);

        FeriadosCadastrados a = new FeriadosCadastrados();
        a.adicionarFeriado(f);
        int calculaFeriadosNoPeriodo = calculaFeriado(a);
        assertEquals(1, calculaFeriadosNoPeriodo);
    }

    public int calculaFeriado(FeriadosCadastrados a) {
        int calculaFeriadosNoPeriodo = calc.calculaFeriadosNoPeriodo(EnvorimentData.dataInicial(10), 16, a);
        return calculaFeriadosNoPeriodo;
    }

    @Test
    public void testCalculaComFeriadoNoPeriodoDoisFeriados() {
        Feriado f = new Feriado();
        f.dataFeriado(EnumDataMes.MAIO, 11);

        Feriado d = new Feriado();
        d.dataFeriado(EnumDataMes.MAIO, 12);

        FeriadosCadastrados a = new FeriadosCadastrados();
        a.adicionarFeriado(f);
        a.adicionarFeriado(d);

        int calculaFeriadosNoPeriodo = calculaFeriado(a);
        assertEquals(2, calculaFeriadosNoPeriodo);
    }
    
    @Test
    public void testCalculaComFeriadoNoPeriodoDoisFeriadosEFimDeSemana() {
        Feriado f = new Feriado();
        f.dataFeriado(EnumDataMes.MAIO, 11);

        Feriado d = new Feriado();
        d.dataFeriado(EnumDataMes.MAIO, 12);

        FeriadosCadastrados a = new FeriadosCadastrados();
        a.adicionarFeriado(f);
        a.adicionarFeriado(d);

        int calculaFeriadosNoPeriodo = calculaFeriado(a);
        assertEquals(2, calculaFeriadosNoPeriodo);
    }

    @Test
    public void testCalculaComFeriadoForaDoPeriodo() {
        Feriado f = new Feriado();
        f.dataFeriado(EnumDataMes.DEZEMBRO, 11);

        FeriadosCadastrados a = new FeriadosCadastrados();
        a.adicionarFeriado(f);

        int calculaFeriadosNoPeriodo = calculaFeriado(a);;
        assertEquals(0, calculaFeriadosNoPeriodo);

    }
}
