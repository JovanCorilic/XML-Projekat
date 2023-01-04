//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.03 at 02:10:42 PM CET 
//


package Patent.BackendPatent.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipRanijaPrijava complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipRanijaPrijava">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="datum_podnosenja_ranije_prijave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="broj_ranije_prijave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dvoslovna_oznaka_drzave_ili_organizacije" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipRanijaPrijava", propOrder = {
    "datumPodnosenjaRanijePrijave",
    "brojRanijePrijave",
    "dvoslovnaOznakaDrzaveIliOrganizacije"
})
public class TipRanijaPrijava {

    @XmlElement(name = "datum_podnosenja_ranije_prijave", required = true)
    protected String datumPodnosenjaRanijePrijave;
    @XmlElement(name = "broj_ranije_prijave", required = true)
    protected String brojRanijePrijave;
    @XmlElement(name = "dvoslovna_oznaka_drzave_ili_organizacije", required = true)
    protected String dvoslovnaOznakaDrzaveIliOrganizacije;

    /**
     * Gets the value of the datumPodnosenjaRanijePrijave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDatumPodnosenjaRanijePrijave() {
        return datumPodnosenjaRanijePrijave;
    }

    /**
     * Sets the value of the datumPodnosenjaRanijePrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDatumPodnosenjaRanijePrijave(String value) {
        this.datumPodnosenjaRanijePrijave = value;
    }

    /**
     * Gets the value of the brojRanijePrijave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojRanijePrijave() {
        return brojRanijePrijave;
    }

    /**
     * Sets the value of the brojRanijePrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojRanijePrijave(String value) {
        this.brojRanijePrijave = value;
    }

    /**
     * Gets the value of the dvoslovnaOznakaDrzaveIliOrganizacije property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDvoslovnaOznakaDrzaveIliOrganizacije() {
        return dvoslovnaOznakaDrzaveIliOrganizacije;
    }

    /**
     * Sets the value of the dvoslovnaOznakaDrzaveIliOrganizacije property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDvoslovnaOznakaDrzaveIliOrganizacije(String value) {
        this.dvoslovnaOznakaDrzaveIliOrganizacije = value;
    }

}
