package com.yomia.webform.requisicao;

import com.yomia.modulo.falhas.FalhaGenerica;
import com.yomia.modulo.falhas.FalhaOperacaoDeBD;
import com.yomia.webform.service.face.RequisicaoGenerica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequisicaoAvancarStatusAtividade extends RequisicaoGenerica {

    @Override
    public void processaRequest(final HttpServletRequest request) throws FalhaGenerica {
        throw new FalhaOperacaoDeBD("Falhou").lancarError("BD-068", "Falha ao acessar Dados", "Houve uma falha ao tentar acessar os dados referentes ao Status da Atividade, entre em contato com o administrador do sistema para mais detalhes.");
    }

    @Override
    public void processaResponse(HttpServletResponse response)throws FalhaGenerica {
        
    }

}
