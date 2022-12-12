package com.eadgbe.a_jedan.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Podaci_o_zasnivanju {
    private String podaci_o_naslovu;

    private Podaci_o_autoru podaci_o_autoru;

    public String getPodaci_o_naslovu ()
    {
        return podaci_o_naslovu;
    }

    public void setPodaci_o_naslovu (String podaci_o_naslovu)
    {
        this.podaci_o_naslovu = podaci_o_naslovu;
    }

    public Podaci_o_autoru getPodaci_o_autoru ()
    {
        return podaci_o_autoru;
    }

    public void setPodaci_o_autoru (Podaci_o_autoru podaci_o_autoru)
    {
        this.podaci_o_autoru = podaci_o_autoru;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [podaci_o_naslovu = "+podaci_o_naslovu+", podaci_o_autoru = "+podaci_o_autoru+"]";
    }
}
