package com.yomia.webform.json;

import com.yomia.modulo.atividade.Atividade;
import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.SaidaDeError;

public class JsonInformeErro extends JsonResponse {

    public static JsonInformeErro converte(Atividade atividade) {
        return (JsonInformeErro) new JsonInformeErro().converteParaJson(atividade);
    }

    public String getCodigoErro() {
        return codigoErro;
    }

    public void setCodigoErro(String codigoErro) {
        this.codigoErro = codigoErro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    

    @Override
    public JsonResponse converteParaJson(Object atv) {
        JsonInformeErro nv = new JsonInformeErro();
        if(!(atv instanceof SaidaDeError)){
            nv.setCodigoErro("CVT-001");
            nv.setTitulo("Falha ao gerar Json");
            nv.setDescricao("Uma falha ocorreu ao tentar gerar a Mensagem de Erro. Favor entrar em contato com o suporte técnico.");
            return nv;
        }
        SaidaDeError atividade = (SaidaDeError) atv;  
        System.out.println("converteParaJson>>"+atividade.getTitulo());        
        nv.titulo = atividade.getTitulo();
        nv.codigoErro = atividade.getCodigoErro();
        nv.descricao = atividade.getDescricao();
        
        return nv;
    }

    String codigoErro;
    String titulo;
    String descricao;

}
