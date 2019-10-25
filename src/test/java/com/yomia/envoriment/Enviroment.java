package com.yomia.envoriment;

import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.mockito.Mockito;

public class Enviroment {

    public static HttpServletRequest getMockRequest() {
        HttpServletRequest request = Mockito.mock(HttpServletRequest.class);
        List<String> arrlist = new ArrayList<>();
        arrlist.add("Ram");
        Enumeration<String> e = Collections.enumeration(arrlist);
        Mockito.when(request.getParameterNames()).thenReturn(e);
        return request;
    }

    public static AcaoParaObjetoRequisicaoDoFormularioSimples acaoParaObjetoDeTeste(final ObjetoTeste teste) {
        AcaoParaObjetoRequisicaoDoFormularioSimples objeto = new AcaoParaObjetoRequisicaoDoFormularioSimples() {
            @Override
            public void executarAcao(HttpServletRequest request) {
                teste.setTexto("teste");
            }
        };
        return objeto;
    }

    public static AcaoParaObjetoRequisicaoDoFormularioSimples acaoParaObjetoComplexo(final ObjetoTeste teste) {
        AcaoParaObjetoRequisicaoDoFormularioSimples formObjeto = new AcaoParaObjetoRequisicaoDoFormularioSimples() {
            @Override
            public void executarAcao(HttpServletRequest request) {
                teste.setTexto("TesteDeForm");
            }
        };
        return formObjeto;
    }

    ObjetoTeste teste = new ObjetoTeste();

    public ObjetoTeste get() {
        return teste;
    }

    public class ObjetoTeste {

        String texto;

        public String getTexto() {
            return texto;
        }

        public void setTexto(String texto) {
            this.texto = texto;
        }

    }

}
