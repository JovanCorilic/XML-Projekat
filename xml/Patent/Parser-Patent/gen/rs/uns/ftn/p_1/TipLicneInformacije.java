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
 * <p>Java class for tipLicneInformacije complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipLicneInformacije">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naziv" type="{http://www.ftn.uns.rs/P-1}tipNaziv"/>
 *         &lt;element name="prebivaliste" type="{http://www.ftn.uns.rs/P-1}tipPrebivaliste"/>
 *         &lt;element name="kontakt" type="{http://www.ftn.uns.rs/P-1}tipKontakt"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipLicneInformacije", propOrder = {
    "naziv",
    "prebivaliste",
    "kontakt"
})
public class TipLicneInformacije {

    @XmlElement(required = true)
    protected TipNaziv naziv;
    @XmlElement(required = true)
    protected TipPrebivaliste prebivaliste;
    @XmlElement(required = true)
    protected TipKontakt kontakt;

    /**
     * Gets the value of the naziv property.
     * 
     * @return
     *     possible object is
     *     {@link TipNaziv }
     *     
     */
    public TipNaziv getNaziv() {
        return naziv;
    }

    /**
     * Sets the value of the naziv property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipNaziv }
     *     
     */
    public void setNaziv(TipNaziv value) {
        this.naziv = value;
    }

    /**
     * Gets the value of the prebivaliste property.
     * 
     * @return
     *     possible object is
     *     {@link TipPrebivaliste }
     *     
     */
    public TipPrebivaliste getPrebivaliste() {
        return prebivaliste;
    }

    /**
     * Sets the value of the prebivaliste property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipPrebivaliste }
     *     
     */
    public void setPrebivaliste(TipPrebivaliste value) {
        this.prebivaliste = value;
    }

    /**
     * Gets the value of the kontakt property.
     * 
     * @return
     *     possible object is
     *     {@link TipKontakt }
     *     
     */
    public TipKontakt getKontakt() {
        return kontakt;
    }

    /**
     * Sets the value of the kontakt property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipKontakt }
     *     
     */
    public void setKontakt(TipKontakt value) {
        this.kontakt = value;
    }

}
