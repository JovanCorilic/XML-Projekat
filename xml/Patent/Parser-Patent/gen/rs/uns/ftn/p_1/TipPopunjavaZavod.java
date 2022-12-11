//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.11 at 06:50:29 PM CET 
//


package rs.uns.ftn.p_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipPopunjavaZavod complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipPopunjavaZavod">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="broj_prijave" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="datum_prijema" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="priznati_datum_podnosenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pecat_i_potpis" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="drzava" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ustanova" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="adresa" type="{http://www.ftn.uns.rs/P-1}tipAdresa"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipPopunjavaZavod", propOrder = {
    "brojPrijave",
    "datumPrijema",
    "priznatiDatumPodnosenja",
    "pecatIPotpis",
    "drzava",
    "ustanova",
    "adresa"
})
public class TipPopunjavaZavod {

    @XmlElement(name = "broj_prijave")
    protected int brojPrijave;
    @XmlElement(name = "datum_prijema", required = true)
    protected String datumPrijema;
    @XmlElement(name = "priznati_datum_podnosenja", required = true)
    protected String priznatiDatumPodnosenja;
    @XmlElement(name = "pecat_i_potpis", required = true)
    protected String pecatIPotpis;
    @XmlElement(required = true)
    protected String drzava;
    @XmlElement(required = true)
    protected String ustanova;
    @XmlElement(required = true)
    protected TipAdresa adresa;

    /**
     * Gets the value of the brojPrijave property.
     * 
     */
    public int getBrojPrijave() {
        return brojPrijave;
    }

    /**
     * Sets the value of the brojPrijave property.
     * 
     */
    public void setBrojPrijave(int value) {
        this.brojPrijave = value;
    }

    /**
     * Gets the value of the datumPrijema property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumPrijema() {
        return datumPrijema;
    }

    /**
     * Sets the value of the datumPrijema property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumPrijema(String value) {
        this.datumPrijema = value;
    }

    /**
     * Gets the value of the priznatiDatumPodnosenja property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriznatiDatumPodnosenja() {
        return priznatiDatumPodnosenja;
    }

    /**
     * Sets the value of the priznatiDatumPodnosenja property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriznatiDatumPodnosenja(String value) {
        this.priznatiDatumPodnosenja = value;
    }

    /**
     * Gets the value of the pecatIPotpis property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPecatIPotpis() {
        return pecatIPotpis;
    }

    /**
     * Sets the value of the pecatIPotpis property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPecatIPotpis(String value) {
        this.pecatIPotpis = value;
    }

    /**
     * Gets the value of the drzava property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrzava() {
        return drzava;
    }

    /**
     * Sets the value of the drzava property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrzava(String value) {
        this.drzava = value;
    }

    /**
     * Gets the value of the ustanova property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUstanova() {
        return ustanova;
    }

    /**
     * Sets the value of the ustanova property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUstanova(String value) {
        this.ustanova = value;
    }

    /**
     * Gets the value of the adresa property.
     * 
     * @return
     *     possible object is
     *     {@link TipAdresa }
     *     
     */
    public TipAdresa getAdresa() {
        return adresa;
    }

    /**
     * Sets the value of the adresa property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipAdresa }
     *     
     */
    public void setAdresa(TipAdresa value) {
        this.adresa = value;
    }

}
