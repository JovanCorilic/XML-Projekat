//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.03 at 02:10:42 PM CET 
//


package rs.uns.ftn.p_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipPrebivaliste complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipPrebivaliste">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naziv_ulice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="broj_ulice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="postanski_broj" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="naziv_grada" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="naziv_drzave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipPrebivaliste", propOrder = {
    "nazivUlice",
    "brojUlice",
    "postanskiBroj",
    "nazivGrada",
    "nazivDrzave"
})
public class TipPrebivaliste {

    @XmlElement(name = "naziv_ulice", required = true)
    protected String nazivUlice;
    @XmlElement(name = "broj_ulice", required = true, type = Integer.class, nillable = true)
    protected Integer brojUlice;
    @XmlElement(name = "postanski_broj", required = true, type = Integer.class, nillable = true)
    protected Integer postanskiBroj;
    @XmlElement(name = "naziv_grada", required = true)
    protected String nazivGrada;
    @XmlElement(name = "naziv_drzave", required = true)
    protected String nazivDrzave;

    /**
     * Gets the value of the nazivUlice property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivUlice() {
        return nazivUlice;
    }

    /**
     * Sets the value of the nazivUlice property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivUlice(String value) {
        this.nazivUlice = value;
    }

    /**
     * Gets the value of the brojUlice property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBrojUlice() {
        return brojUlice;
    }

    /**
     * Sets the value of the brojUlice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBrojUlice(Integer value) {
        this.brojUlice = value;
    }

    /**
     * Gets the value of the postanskiBroj property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getPostanskiBroj() {
        return postanskiBroj;
    }

    /**
     * Sets the value of the postanskiBroj property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setPostanskiBroj(Integer value) {
        this.postanskiBroj = value;
    }

    /**
     * Gets the value of the nazivGrada property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivGrada() {
        return nazivGrada;
    }

    /**
     * Sets the value of the nazivGrada property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivGrada(String value) {
        this.nazivGrada = value;
    }

    /**
     * Gets the value of the nazivDrzave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivDrzave() {
        return nazivDrzave;
    }

    /**
     * Sets the value of the nazivDrzave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivDrzave(String value) {
        this.nazivDrzave = value;
    }

}
