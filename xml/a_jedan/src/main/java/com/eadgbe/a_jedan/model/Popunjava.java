package com.eadgbe.a_jedan.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Popunjava {
	private String ime;

    private String prezime;

    public String getIme ()
    {
        return ime;
    }

    public void setIme (String ime)
    {
        this.ime = ime;
    }

    public String getPrezime ()
    {
        return prezime;
    }

    public void setPrezime (String prezime)
    {
        this.prezime = prezime;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ime = "+ime+", prezime = "+prezime+"]";
    }
}