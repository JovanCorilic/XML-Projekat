package com.eadgbe.a_jedan.model;

public class Adresa {
    private String naziv_ulice;

    private String broj_ulice;

    private String grad;

    public String getNaziv_ulice ()
    {
        return naziv_ulice;
    }

    public void setNaziv_ulice (String naziv_ulice)
    {
        this.naziv_ulice = naziv_ulice;
    }

    public String getBroj_ulice ()
    {
        return broj_ulice;
    }

    public void setBroj_ulice (String broj_ulice)
    {
        this.broj_ulice = broj_ulice;
    }

    public String getGrad ()
    {
        return grad;
    }

    public void setGrad (String grad)
    {
        this.grad = grad;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [naziv_ulice = "+naziv_ulice+", broj_ulice = "+broj_ulice+", grad = "+grad+"]";
    }
}
