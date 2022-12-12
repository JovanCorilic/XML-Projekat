package com.eadgbe.a_jedan.model;

public class Nosilac_prijave {
	private String podnosilac_prijave;

    public String getPodnosilac_prijave ()
    {
        return podnosilac_prijave;
    }

    public void setPodnosilac_prijave (String podnosilac_prijave)
    {
        this.podnosilac_prijave = podnosilac_prijave;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [podnosilac_prijave = "+podnosilac_prijave+"]";
    }
}
