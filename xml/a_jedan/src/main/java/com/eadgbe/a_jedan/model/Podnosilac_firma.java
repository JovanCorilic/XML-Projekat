package com.eadgbe.a_jedan.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Podnosilac_firma {
	private String sediste_nosioca_autorskog;

    private String poslovno_ime;

    public String getSediste_nosioca_autorskog ()
    {
        return sediste_nosioca_autorskog;
    }

    public void setSediste_nosioca_autorskog (String sediste_nosioca_autorskog)
    {
        this.sediste_nosioca_autorskog = sediste_nosioca_autorskog;
    }

    public String getPoslovno_ime ()
    {
        return poslovno_ime;
    }

    public void setPoslovno_ime (String poslovno_ime)
    {
        this.poslovno_ime = poslovno_ime;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [sediste_nosioca_autorskog = "+sediste_nosioca_autorskog+", poslovno_ime = "+poslovno_ime+"]";
    }
}
