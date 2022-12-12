package com.eadgbe.a_jedan.model;

public class Autor {
    private String ime;

    private String prezime;

    private Adresa adresa;

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

    public Adresa getAdresa ()
    {
        return adresa;
    }

    public void setAdresa (Adresa adresa)
    {
        this.adresa = adresa;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ime = "+ime+", prezime = "+prezime+", adresa = "+adresa+"]";
    }
}

