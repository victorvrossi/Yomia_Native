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
    public void testTamanhoDia() {
        assertEquals("Valida tamanho do dia:", 8, calc.tamanhoDoDia);
    }
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
    public void testDataDeEntregaDoisDias() {

        DataDoSistema saida = calculaEntrega(8,16);
        assertEquals("2019-05-12 08:25",DataUtil.formatarDataYYYYMMDDHHMI(saida.data().getTime())); 
    }
    @Test
    public void testDataDeEntregaDoisDiasQuatroHoras() {
        DataDoSistema saida = calculaEntrega(8,20);        
        assertEquals("2019-05-12 12:25",DataUtil.formatarDataYYYYMMDDHHMI(saida.data().getTime()));
        
    }
    
    @Test
    public void testDataDeEntregaDadoConfiguracaoDoisDiasAntesExpediente() {
        DataDoSistema saida = calculaEntrega(7,16);
        assertEquals("2019-05-12 08:25",DataUtil.formatarDataYYYYMMDDHHMI(saida.data().getTime())); 
    }
    @Test
    public void testDataDeEntregaDadoConfiguracaoDoisDiasDepoisExpediente() {
        DataDoSistema saida = calculaEntrega(19,16);
        assertEquals("2019-05-13 08:00",DataUtil.formatarDataYYYYMMDDHHMI(saida.data().getTime())); 
    }
    @Test
    public void testDataDeEntregaDadoConfiguracao() {        
        DataDoSistema saida = calculaEntrega(19,20);
        assertEquals("2019-05-13 12:00",DataUtil.formatarDataYYYYMMDDHHMI(saida.data().getTime())); 
    }
    
    @Test
    public void testDataDeEntregaDadoConfiguracaoComAlmoco() {
        calc.consideraAlmoco(true);
        DataDoSistema saida = calculaEntrega(19,21);
        assertEquals("2019-05-13 15:00",DataUtil.formatarDataYYYYMMDDHHMI(saida.data().getTime())); 
    }
    
    @Test
    public void testDataDeEntregaDadoConfiguracaoSemAlmoco() {
        calc.consideraAlmoco(false);
        DataDoSistema saida = calculaEntrega(19,21);
        assertEquals("2019-05-13 13:00",DataUtil.formatarDataYYYYMMDDHHMI(saida.data().getTime())); 
    }

    public DataDoSistema calculaEntrega(int horaEntrada,int limite) {
        DataDoSistema saida = calc.calculaDataEntregaDadoConfiguracao(DataUtil.dataManual(2019, EnumDataMes.MAIO, 10,horaEntrada,25), limite);
        return saida;
    }

    class Modelo {

        int tempoEstimadoProjeto = 45;
        CalculoData calc = new CalculoData();

        public Modelo() {
            calc.alterarTamanhoDeUmDia(8,18,2);
        }

    }

}
