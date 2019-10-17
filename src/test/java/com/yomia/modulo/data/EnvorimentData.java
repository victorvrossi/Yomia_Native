
package com.yomia.modulo.data;

public class EnvorimentData {
    
    private int tempoEstimadoProjeto = new Modelo().tempoEstimadoProjeto;
    private  CalculoData calc = new Modelo().calc;
    
    public static int tempoEstimado (){
        return new EnvorimentData().tempoEstimadoProjeto;
    }
    public static CalculoData calcula (){
        return new EnvorimentData().calc;
    }
    
    public static DataDoSistema dataInicial(int horaEntrada,EnumDataMes mes) {
        final DataDoSistema dataManual = DataUtil.dataManual(2019, mes, 10,horaEntrada,25);
        if(dataManual == null){
            throw new RuntimeException("Falha ao criar dataManual");
        }
        return dataManual;
    }
    
    public static DataDoSistema calculaEntrega(int horaEntrada,int limite, boolean temAlmoco) {
        CalculoData calc = EnvorimentData.calcula();
        calc.consideraAlmoco(temAlmoco);
        DataDoSistema saida = calc.calculaDataEntregaDadoPrazo(EnvorimentData.dataInicial(horaEntrada,EnumDataMes.MAIO), limite);
        return saida;
    }
    public static DataDoSistema calculaEntregaConsiderandoFolga(int horaEntrada,int limite, boolean temAlmoco) {
        CalculoData calc = EnvorimentData.calcula();
        calc.consideraAlmoco(temAlmoco);
        FeriadosCadastrados lista = new FeriadosCadastrados();
        DataDoSistema saida = calc.calculaDataEntregaDadoPrazoConsiderandoFolga(EnvorimentData.dataInicial(horaEntrada,EnumDataMes.AGOSTO), limite, lista);
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
