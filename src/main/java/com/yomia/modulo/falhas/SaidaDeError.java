package com.yomia.modulo.falhas;

import com.yomia.webform.json.JsonInformeErro;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;

public class SaidaDeError {

    String codigoErro;
    String titulo;
    String descricao;

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

    public String gerarJson() {        
        JsonInformeErro jsonErro = new JsonInformeErro();
        return jsonErro.formarJson(jsonErro.converteParaJson(this));
    }

    public static void responseComSaidaDeErro(HttpServletResponse response,FalhaGenerica e) {
        try (PrintWriter out = response.getWriter()) {
            response.getWriter().flush();
            System.out.println("Erro Gerado:"+e.getErroGerado().gerarJson());
            out.println(e.getErroGerado().gerarJson());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
