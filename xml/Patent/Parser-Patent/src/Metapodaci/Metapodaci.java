//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.29 at 10:39:48 AM CET 
//


package rs.uns.ftn.metapodaci;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="broj_prijave" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="priznati_datum_podnosenja" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="srpski_naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="engleski_naziv" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "brojPrijave",
    "priznatiDatumPodnosenja",
    "srpskiNaziv",
    "engleskiNaziv"
})
@XmlRootElement(name = "metapodaci")
public class Metapodaci {

    @XmlElement(name = "broj_prijave", required = true)
    protected String brojPrijave;
    @XmlElement(name = "priznati_datum_podnosenja", required = true)
    protected String priznatiDatumPodnosenja;
    @XmlElement(name = "srpski_naziv", required = true)
    protected String srpskiNaziv;
    @XmlElement(name = "engleski_naziv", required = true)
    protected String engleskiNaziv;

    /**
     * Gets the value of the brojPrijave property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBrojPrijave() {
        return brojPrijave;
    }

    /**
     * Sets the value of the brojPrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBrojPrijave(String value) {
        this.brojPrijave = value;
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
     * Gets the value of the srpskiNaziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSrpskiNaziv() {
        return srpskiNaziv;
    }

    /**
     * Sets the value of the srpskiNaziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSrpskiNaziv(String value) {
        this.srpskiNaziv = value;
    }

    /**
     * Gets the value of the engleskiNaziv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEngleskiNaziv() {
        return engleskiNaziv;
    }

    /**
     * Sets the value of the engleskiNaziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEngleskiNaziv(String value) {
        this.engleskiNaziv = value;
    }

}
