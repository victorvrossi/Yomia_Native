package com.yomia.atividade;

import com.yomia.webform.*;
import com.yomia.envoriment.Enviroment;
import com.yomia.modulo.atividade.Atividade;
import com.yomia.webform.service.face.FormularioGenerico;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import javax.enterprise.inject.Model;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.Mockito;

public class AtividadeTest {

    @Test
    public void testAtividadeCriacao() throws Exception {
        Atividade a = new Atividade();
        
    }

}
