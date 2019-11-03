package com.yomia.modulo.data;

import com.yomia.envoriment.Unitario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.experimental.categories.Category;

@Category(Unitario.class)
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

    public int calculaFolga(FeriadosCadastrados a) {
        int calculaFeriadosNoPeriodo = calc.calculaFolga(EnvorimentData.dataInicial(8,EnumDataMes.MAIO), 40, a);
        return calculaFeriadosNoPeriodo;
    }

    public int calculaFeriado(FeriadosCadastrados a) {
        int calculaFeriadosNoPeriodo = calc.calculaFeriadosNoPeriodo(EnvorimentData.dataInicial(8,EnumDataMes.MAIO), 40, a);
        return calculaFeriadosNoPeriodo;
    }

    public int calculaFeriadoNoFimDeSemana(FeriadosCadastrados a) {
        int calculaFeriadosNoPeriodo = calc.calculaFeriadosNoFimDeSemanaNoPeriodo(EnvorimentData.dataInicial(8,EnumDataMes.MAIO), 40, a);
        return calculaFeriadosNoPeriodo;
    }

    public int calculaFimDeSemana() {
        int calculaFeriadosNoPeriodo = calc.calculaFimDeSemanaNoPeriodo(EnvorimentData.dataInicial(8,EnumDataMes.MAIO), 40);
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
    public void testCalculaFeriadoNoPeriodoDoisFeriadosEFimDeSemana() {
        Feriado f = new Feriado();
        f.dataFeriado(EnumDataMes.MAIO, 11);

        Feriado d = new Feriado();
        d.dataFeriado(EnumDataMes.MAIO, 12);

        FeriadosCadastrados a = new FeriadosCadastrados();
        a.adicionarFeriado(f);
        a.adicionarFeriado(d);

        int calculaFeriadosNoPeriodo = calculaFeriado(a);
        int calculaFimDeSemanaNoPeriodo = calculaFimDeSemana();
        int calculaFeriadoNoFimDeSemana = calculaFeriadoNoFimDeSemana(a);

        assertEquals(2, calculaFeriadosNoPeriodo);
        assertEquals(2, calculaFimDeSemanaNoPeriodo);
        assertEquals(2, calculaFeriadoNoFimDeSemana);
    }

    @Test
    public void testCalculaFolga() {
        Feriado f = new Feriado();
        f.dataFeriado(EnumDataMes.MAIO, 11);

        Feriado d = new Feriado();
        d.dataFeriado(EnumDataMes.MAIO, 12);

        FeriadosCadastrados a = new FeriadosCadastrados();
        a.adicionarFeriado(f);
        a.adicionarFeriado(d);

        int calculo = calculaFolga(a);

        assertEquals(2, calculo);
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
