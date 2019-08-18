package com.yomia.webform;

import java.util.Iterator;
import javax.servlet.http.HttpServletRequest;

public interface AcaoParaObjetoRequisicaoDoFormularioSimples {

    public void executarAcao(HttpServletRequest request,Iterator<String> asIterator);

}
