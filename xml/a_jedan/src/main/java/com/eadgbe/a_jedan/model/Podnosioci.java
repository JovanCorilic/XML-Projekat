package com.eadgbe.a_jedan.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Podnosioci {
    private Anoniman anoniman;

    public Anoniman getAnoniman ()
    {
        return anoniman;
    }

    public void setAnoniman (Anoniman anoniman)
    {
        this.anoniman = anoniman;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [anoniman = "+anoniman+"]";
    }
}
