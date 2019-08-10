package com.yomia.modulo.data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculoDataTest {

    int tempoEstimadoProjeto = new Modelo().tempoEstimadoProjeto;
    CalculoData calc = new Modelo().calc;

    @Test
    public void testContagemDeDiasDadoHoraSemSobra() {
        tempoEstimadoProjeto = 40;
        int dias = calc.calculaQuantidadeDeDiasDadoHora(tempoEstimadoProjeto);
        int resto = calc.restoTempo(tempoEstimadoProjeto);
        assertEquals("Quantidade De dias esperados:", 5, dias);
        assertEquals("Sobra de tempo esperados(Horas):", 0, resto);
    }

    @Test
    public void testContagemDeDiasDadoHoraComSobra() {
        int dias = calc.calculaQuantidadeDeDiasDadoHora(tempoEstimadoProjeto);
        int resto = calc.restoTempo(tempoEstimadoProjeto);
        assertEquals("Quantidade De dias esperados:", 5, dias);
        assertEquals("Sobra de tempo esperados(Horas):", 5, resto);
    }

    @Test
    public void testDataDeEntregaDadoConfiguracaoDoisDias() {

        DataDoSistema saida = calc.calculaDataEntregaDadoConfiguracao(DataUtil.dataManual(2019, EnumDataMes.MAIO, 10,8,25), 16);
        //assertEquals("2019-05-12",DataUtil.formatarData(saida.data().getTime()));
        assertEquals("2019-05-12 08:25",DataUtil.formatarDataYYYYMMDDHHMI(saida.data().getTime()));
        
    }
    @Test
    public void testDataDeEntregaDadoConfiguracaoDoisDiasQuatroHoras() {

        DataDoSistema saida = calc.calculaDataEntregaDadoConfiguracao(DataUtil.dataManual(2019, EnumDataMes.MAIO, 10,8,25), 20);        
        assertEquals("2019-05-12 12:25",DataUtil.formatarDataYYYYMMDDHHMI(saida.data().getTime()));
        
    }

    class Modelo {

        int tempoEstimadoProjeto = 45;
        CalculoData calc = new CalculoData();

        public Modelo() {
            calc.alterarTamanhoDeUmDia(8);
        }

    }

}
