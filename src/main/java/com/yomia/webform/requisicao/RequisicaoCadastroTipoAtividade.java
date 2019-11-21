package com.yomia.webform.requisicao;

import com.yomia.modulo.atividade.TipoAtividade;
import com.yomia.webform.AcaoParaObjetoRequisicaoDoFormularioSimples;
import com.yomia.webform.service.face.RequisicaoGenerica;
import static com.yomia.webform.service.face.RequisicaoGenerica.processaRequest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoCadastroTipoAtividade  extends RequisicaoGenerica {

    @Override
    public void processaRequest(HttpServletRequest request) {
         AcaoParaObjetoRequisicaoDoFormularioSimples formObjeto = new AcaoParaObjetoRequisicaoDoFormularioSimples() {
            @Override
            public void executarAcao(HttpServletRequest request) {
                try {
                    String tipoAtividade = request.getParameter("lb_titulo");
                    new TipoAtividade().novoTipoAtividade(tipoAtividade);
                } catch (Exception ex) {
                    
                }

            }
        };
        processaRequest(request, formObjeto);
        
    }

    @Override
    public void processaResponse(HttpServletResponse response) {
        
    }

}
