package com.yomia.envoriment;

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

    ObjetoTeste teste = new ObjetoTeste();

    public ObjetoTeste getObjetoTeste() {
        return teste;
    }

}
