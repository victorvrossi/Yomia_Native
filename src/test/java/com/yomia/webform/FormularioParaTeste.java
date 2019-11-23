package com.yomia.webform;

import com.yomia.envoriment.ObjetoTeste;
import com.yomia.webform.service.face.RequisicaoGenerica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FormularioParaTeste extends RequisicaoGenerica {

    ObjetoTeste teste;

    FormularioParaTeste(ObjetoTeste teste) {
        this.teste = teste;
    }

    @Override
    public void processaRequest(final HttpServletRequest request) {
       if(teste == null){
           throw new NullPointerException("Objeto de Teste está null");
       }
       teste.setTexto("TesteDeForm");
    }

    @Override
    public void processaResponse(HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
