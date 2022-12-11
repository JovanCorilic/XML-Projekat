//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.11 at 06:50:29 PM CET 
//


package Patent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipPunomocnik complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipPunomocnik">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="da_li_je_punomocnik_za_zastupanje" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="da_li_je_punomocnik_za_prijem_pismena" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="da_li_je_zajednicki_predstavnik" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="licne_informacije" type="{http://www.ftn.uns.rs/P-1}tipLicneInformacije"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipPunomocnik", propOrder = {
    "daLiJePunomocnikZaZastupanje",
    "daLiJePunomocnikZaPrijemPismena",
    "daLiJeZajednickiPredstavnik",
    "licneInformacije"
})
public class TipPunomocnik {

    @XmlElement(name = "da_li_je_punomocnik_za_zastupanje")
    protected boolean daLiJePunomocnikZaZastupanje;
    @XmlElement(name = "da_li_je_punomocnik_za_prijem_pismena")
    protected boolean daLiJePunomocnikZaPrijemPismena;
    @XmlElement(name = "da_li_je_zajednicki_predstavnik")
    protected boolean daLiJeZajednickiPredstavnik;
    @XmlElement(name = "licne_informacije", required = true)
    protected TipLicneInformacije licneInformacije;

    /**
     * Gets the value of the daLiJePunomocnikZaZastupanje property.
     * 
     */
    public boolean isDaLiJePunomocnikZaZastupanje() {
        return daLiJePunomocnikZaZastupanje;
    }

    /**
     * Sets the value of the daLiJePunomocnikZaZastupanje property.
     * 
     */
    public void setDaLiJePunomocnikZaZastupanje(boolean value) {
        this.daLiJePunomocnikZaZastupanje = value;
    }

    /**
     * Gets the value of the daLiJePunomocnikZaPrijemPismena property.
     * 
     */
    public boolean isDaLiJePunomocnikZaPrijemPismena() {
        return daLiJePunomocnikZaPrijemPismena;
    }

    /**
     * Sets the value of the daLiJePunomocnikZaPrijemPismena property.
     * 
     */
    public void setDaLiJePunomocnikZaPrijemPismena(boolean value) {
        this.daLiJePunomocnikZaPrijemPismena = value;
    }

    /**
     * Gets the value of the daLiJeZajednickiPredstavnik property.
     * 
     */
    public boolean isDaLiJeZajednickiPredstavnik() {
        return daLiJeZajednickiPredstavnik;
    }

    /**
     * Sets the value of the daLiJeZajednickiPredstavnik property.
     * 
     */
    public void setDaLiJeZajednickiPredstavnik(boolean value) {
        this.daLiJeZajednickiPredstavnik = value;
    }

    /**
     * Gets the value of the licneInformacije property.
     * 
     * @return
     *     possible object is
     *     {@link TipLicneInformacije }
     *     
     */
    public TipLicneInformacije getLicneInformacije() {
        return licneInformacije;
    }

    /**
     * Sets the value of the licneInformacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipLicneInformacije }
     *     
     */
    public void setLicneInformacije(TipLicneInformacije value) {
        this.licneInformacije = value;
    }

}
