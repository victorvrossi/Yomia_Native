package com.yomia.webform.service.face;

import com.yomia.modulo.falhas.FalhaGenerica;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

interface InterfaceFormularioHTTP {

    public abstract void processaRequest(HttpServletRequest request) throws FalhaGenerica;

    public abstract void processaResponse(HttpServletResponse response) throws FalhaGenerica;
}
