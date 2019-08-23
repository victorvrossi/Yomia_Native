
package com.yomia.webform.formularios.face;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface InterfaceFormularioHTTP {
    public abstract void processaRequest(HttpServletRequest request);
    public abstract void processaResponse(HttpServletResponse response);
}
