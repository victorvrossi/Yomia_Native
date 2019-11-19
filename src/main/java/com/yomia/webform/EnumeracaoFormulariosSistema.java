package com.yomia.webform;

import com.yomia.webform.formularios.AcaoFormulario;
import com.yomia.webform.formularios.RequisicaoCadastroStatus;
import com.yomia.webform.formularios.RequisicaoCadastroTipoAtividade;
import com.yomia.webform.formularios.ClienteListaTicket;
import com.yomia.webform.formularios.FormularioAtividade;
import com.yomia.webform.service.face.RequisicaoGenerica;
import com.yomia.webform.formularios.RequisicaoListaTipoAtividade;
import com.yomia.webform.formularios.RequisicaoCadastrarAtividade;
import com.yomia.webform.formularios.RequisicaoListarAtividade;
import java.util.HashMap;
import java.util.Map;

public enum EnumeracaoFormulariosSistema {

    CADASTRAR_ATIVIDADE(new Object[]{"atividade.form.cad", new RequisicaoCadastrarAtividade()}),
    CADASTRAR_TIPO_ATIVIDADE(new Object[]{"tipo_atividade.form.cad", new RequisicaoCadastroTipoAtividade()}),
    CADASTRAR_STATUS_ATIVIDADE(new Object[]{"status_atividade.form.cad", new RequisicaoCadastroStatus()}),
    
    LISTAR_ATIVIDADE(new Object[]{"atividade.form.lista", new RequisicaoListarAtividade()}),    
    LISTAR_TIPO_ATIVIDADE(new Object[]{"tipo_atividade.lista", new RequisicaoListaTipoAtividade()}),
    LISTA_TICKET(new Object[]{"ticket.list", new ClienteListaTicket()}),
    
    AVANCA_STATUS_ATIVIDADE(new Object[]{"atividade.avanca.status", new FormularioAtividade(AcaoFormulario.AVANCAR_STATUS)})
    ;

    public Object[] uri_obj;

    private EnumeracaoFormulariosSistema(Object[] uri) {
        this.uri_obj = uri;
    }

    public String uri() {
        return (String) uri_obj[0];
    }

    private static Map<String, EnumeracaoFormulariosSistema> relacao;
    
    static {
        relacao = new HashMap<>();
        for (EnumeracaoFormulariosSistema s : values()) {
            relacao.put((String) s.uri_obj[0], s);
        }
    }

    public static RequisicaoGenerica retornaFormPorURI(String URI) {
        if(!relacao.containsKey(URI)){
            throw  new NullPointerException("Nenhuma relação declarada para "+URI);
        }
        final Object var = relacao.get(URI).uri_obj[1];
        
        return (RequisicaoGenerica) var;
    }

    

}
