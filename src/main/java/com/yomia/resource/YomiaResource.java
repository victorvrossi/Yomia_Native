package com.yomia.resource;

import com.yomia.jpa.controler.Persistencia;
import java.util.Properties;
public class YomiaResource {
    
    public Persistencia devolveAmbienteQueEstaEmExecucao(){        
        try {
            Properties properties = new Properties();
            properties.load(YomiaResource.class.getResourceAsStream("yomia.properties"));
            System.out.println("*************************>" + properties.getProperty("ambiente"));
            String ambiente = properties.getProperty("ambiente");
            if("dev".equals(ambiente)){
                return Persistencia.YOMIA_TEST;
            }
        } catch (Exception ex) {
            
        }
        return Persistencia.YOMIA_PERSISTENCE;
    }
}
