package com.eadgbe.a_jedan.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class Podneti_prilozi_zahtev {
	    private String[] prilozi_prijave;

	    private String[] opis_autorskog_dela;

	    private String[] primer_autorskog_dela;

	    private Popunjava[] popunjava;

	    public String[] getPrilozi_prijave ()
	    {
	        return prilozi_prijave;
	    }

	    public void setPrilozi_prijave (String[] prilozi_prijave)
	    {
	        this.prilozi_prijave = prilozi_prijave;
	    }

	    public String[] getOpis_autorskog_dela ()
	    {
	        return opis_autorskog_dela;
	    }

	    public void setOpis_autorskog_dela (String[] opis_autorskog_dela)
	    {
	        this.opis_autorskog_dela = opis_autorskog_dela;
	    }

	    public String[] getPrimer_autorskog_dela ()
	    {
	        return primer_autorskog_dela;
	    }

	    public void setPrimer_autorskog_dela (String[] primer_autorskog_dela)
	    {
	        this.primer_autorskog_dela = primer_autorskog_dela;
	    }

	    public Popunjava[] getPopunjava ()
	    {
	        return popunjava;
	    }

	    public void setPopunjava (Popunjava[] popunjava)
	    {
	        this.popunjava = popunjava;
	    }

	    @Override
	    public String toString()
	    {
	        return "ClassPojo [prilozi_prijave = "+prilozi_prijave+", opis_autorskog_dela = "+opis_autorskog_dela+", primer_autorskog_dela = "+primer_autorskog_dela+", popunjava = "+popunjava+"]";
	    }
	}