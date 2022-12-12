package com.eadgbe.a_jedan.model;

public class Anoniman {
	private String delo_delo_anonimnog_autora;

    public String getDelo_delo_anonimnog_autora ()
    {
        return delo_delo_anonimnog_autora;
    }

    public void setDelo_delo_anonimnog_autora (String delo_delo_anonimnog_autora)
    {
        this.delo_delo_anonimnog_autora = delo_delo_anonimnog_autora;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [delo_delo_anonimnog_autora = "+delo_delo_anonimnog_autora+"]";
    }
}
