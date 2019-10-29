package com.yomia.jpa.controler;


import java.io.Serializable;

/**+
 *
 * @author Victor
 * @since 03/11/2016
 */
public interface BaseEntidade extends Serializable{

    public Serializable getId();
    public void setId(Integer i);
    
    
}
