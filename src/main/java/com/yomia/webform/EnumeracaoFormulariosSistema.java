package com.yomia.webform;

import com.yomia.webform.formularios.face.FormularioGenerico;
import com.yomia.webform.formularios.FormularioParaAtividade;
import java.util.HashMap;
import java.util.Map;

public enum EnumeracaoFormulariosSistema {

    CAD_TICKET(new Object[]{"cadticket.form", new FormularioParaAtividade()});

    public Object[] uri_obj;

    private EnumeracaoFormulariosSistema(Object[] uri) {
        this.uri_obj = uri;
    }

    public String uri() {
        return (String) uri_obj[0];
    }

    private static Map<String, EnumeracaoFormulariosSistema> relacao;

    public static FormularioGenerico retornaFormPorURI(String URI) {
        if(!relacao.containsKey(URI)){
            throw  new NullPointerException("Nenhuma relação declarada");
        }
        final Object var = relacao.get(URI).uri_obj[1];
        
        return (FormularioGenerico) var;
    }

    static {
        relacao = new HashMap<>();
        for (EnumeracaoFormulariosSistema s : values()) {
            relacao.put((String) s.uri_obj[0], s);
        }
    }

}
