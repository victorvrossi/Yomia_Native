package com.yomia.modulo.falhas;

public class FalhaGenerica extends Exception{
    private SaidaDeError saidaDeErro = new SaidaDeError();
    String titulo = "";
    String mensagem = "";
    
    public FalhaGenerica(String message) {
        super(message);
        this.titulo = message;
    }

    public FalhaGenerica setMensagem(Throwable e){
        mensagem = e.getMessage();
        return this;
    }
    public FalhaGenerica lancarError(String codigoErro,String titulo,String descricao){
        saidaDeErro.setCodigoErro(codigoErro);
        saidaDeErro.setTitulo(titulo);
        saidaDeErro.setDescricao(descricao);
        System.err.println("Falha:"+this.titulo+":"+mensagem);
        return this;
    }
    public SaidaDeError getErroGerado(){        
        return saidaDeErro;
    }
    
}
