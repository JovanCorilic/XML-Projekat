package com.eadgbe.a_jedan.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "A-1")
public class A1 implements Serializable{
	@XmlElement
	private Podneti_prilozi_zahtev podneti_prilozi_zahtev;
	
	@XmlElement
    private String datum_podnosenja;

	@XmlElement
    private Podaci_o_zasnivanju podaci_o_zasnivanju;

	@XmlElement
    private String forma_zapisa_autorskog_dela;

	@XmlElement
    private String vrsti_autorskog_dela;

	@XmlElement
    private String broj_prijave;

	@XmlElement
    private Autor autor;

	@XmlElement
    private String nacin_koriscenja_autorskog_dela;

	@XmlElement
    private String[] naslov;

	@XmlElement
    private String da_li_je_delo_stvoreno_u_radnom_odnosu;

	@XmlElement
    private String telefon;

	@XmlElement
    private Adresa adresa;

	@XmlElement
    private String obrazac;

	@XmlElement
    private Podnosioci podnosioci;

	@XmlElement
    private Nosilac_prijave nosilac_prijave;

	@XmlElement
    private String zavod_za_intelektualnu_svoinu;

	@XmlElement
    private Podnosilac_firma podnosilac_firma;

	@XmlElement
    private String pseudonim;

	@XmlElement
    private String alternativni_naslov;

	@XmlElement
    private String email;

    public Podneti_prilozi_zahtev getPodneti_prilozi_zahtev ()
    {
        return podneti_prilozi_zahtev;
    }

    public void setPodneti_prilozi_zahtev (Podneti_prilozi_zahtev podneti_prilozi_zahtev)
    {
        this.podneti_prilozi_zahtev = podneti_prilozi_zahtev;
    }

    public String getDatum_podnosenja ()
    {
        return datum_podnosenja;
    }

    public void setDatum_podnosenja (String datum_podnosenja)
    {
        this.datum_podnosenja = datum_podnosenja;
    }

    public Podaci_o_zasnivanju getPodaci_o_zasnivanju ()
    {
        return podaci_o_zasnivanju;
    }

    public void setPodaci_o_zasnivanju (Podaci_o_zasnivanju podaci_o_zasnivanju)
    {
        this.podaci_o_zasnivanju = podaci_o_zasnivanju;
    }

    public String getForma_zapisa_autorskog_dela ()
    {
        return forma_zapisa_autorskog_dela;
    }

    public void setForma_zapisa_autorskog_dela (String forma_zapisa_autorskog_dela)
    {
        this.forma_zapisa_autorskog_dela = forma_zapisa_autorskog_dela;
    }

    public String getVrsti_autorskog_dela ()
    {
        return vrsti_autorskog_dela;
    }

    public void setVrsti_autorskog_dela (String vrsti_autorskog_dela)
    {
        this.vrsti_autorskog_dela = vrsti_autorskog_dela;
    }

    public String getBroj_prijave ()
    {
        return broj_prijave;
    }

    public void setBroj_prijave (String broj_prijave)
    {
        this.broj_prijave = broj_prijave;
    }

    public Autor getAutor ()
    {
        return autor;
    }

    public void setAutor (Autor autor)
    {
        this.autor = autor;
    }

    public String getNacin_koriscenja_autorskog_dela ()
    {
        return nacin_koriscenja_autorskog_dela;
    }

    public void setNacin_koriscenja_autorskog_dela (String nacin_koriscenja_autorskog_dela)
    {
        this.nacin_koriscenja_autorskog_dela = nacin_koriscenja_autorskog_dela;
    }

    public String[] getNaslov ()
    {
        return naslov;
    }

    public void setNaslov (String[] naslov)
    {
        this.naslov = naslov;
    }

    public String getDa_li_je_delo_stvoreno_u_radnom_odnosu ()
    {
        return da_li_je_delo_stvoreno_u_radnom_odnosu;
    }

    public void setDa_li_je_delo_stvoreno_u_radnom_odnosu (String da_li_je_delo_stvoreno_u_radnom_odnosu)
    {
        this.da_li_je_delo_stvoreno_u_radnom_odnosu = da_li_je_delo_stvoreno_u_radnom_odnosu;
    }

    public String getTelefon ()
    {
        return telefon;
    }

    public void setTelefon (String telefon)
    {
        this.telefon = telefon;
    }

    public Adresa getAdresa ()
    {
        return adresa;
    }

    public void setAdresa (Adresa adresa)
    {
        this.adresa = adresa;
    }

    public String getObrazac ()
    {
        return obrazac;
    }

    public void setObrazac (String obrazac)
    {
        this.obrazac = obrazac;
    }

    public Podnosioci getPodnosioci ()
    {
        return podnosioci;
    }

    public void setPodnosioci (Podnosioci podnosioci)
    {
        this.podnosioci = podnosioci;
    }

    public Nosilac_prijave getNosilac_prijave ()
    {
        return nosilac_prijave;
    }

    public void setNosilac_prijave (Nosilac_prijave nosilac_prijave)
    {
        this.nosilac_prijave = nosilac_prijave;
    }

    public String getZavod_za_intelektualnu_svoinu ()
    {
        return zavod_za_intelektualnu_svoinu;
    }

    public void setZavod_za_intelektualnu_svoinu (String zavod_za_intelektualnu_svoinu)
    {
        this.zavod_za_intelektualnu_svoinu = zavod_za_intelektualnu_svoinu;
    }

    public Podnosilac_firma getPodnosilac_firma ()
    {
        return podnosilac_firma;
    }

    public void setPodnosilac_firma (Podnosilac_firma podnosilac_firma)
    {
        this.podnosilac_firma = podnosilac_firma;
    }

    public String getPseudonim ()
    {
        return pseudonim;
    }

    public void setPseudonim (String pseudonim)
    {
        this.pseudonim = pseudonim;
    }

    public String getAlternativni_naslov ()
    {
        return alternativni_naslov;
    }

    public void setAlternativni_naslov (String alternativni_naslov)
    {
        this.alternativni_naslov = alternativni_naslov;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [podneti_prilozi_zahtev = "+podneti_prilozi_zahtev+", datum_podnosenja = "+datum_podnosenja+", podaci_o_zasnivanju = "+podaci_o_zasnivanju+", forma_zapisa_autorskog_dela = "+forma_zapisa_autorskog_dela+", vrsti_autorskog_dela = "+vrsti_autorskog_dela+", broj_prijave = "+broj_prijave+", autor = "+autor+", nacin_koriscenja_autorskog_dela = "+nacin_koriscenja_autorskog_dela+", naslov = "+naslov+", da_li_je_delo_stvoreno_u_radnom_odnosu = "+da_li_je_delo_stvoreno_u_radnom_odnosu+", telefon = "+telefon+", adresa = "+adresa+", obrazac = "+obrazac+", podnosioci = "+podnosioci+", nosilac_prijave = "+nosilac_prijave+", zavod_za_intelektualnu_svoinu = "+zavod_za_intelektualnu_svoinu+", podnosilac_firma = "+podnosilac_firma+", pseudonim = "+pseudonim+", alternativni_naslov = "+alternativni_naslov+", email = "+email+"]";
    }
}
