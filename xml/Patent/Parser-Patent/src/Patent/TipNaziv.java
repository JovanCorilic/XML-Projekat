//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.08 at 11:10:33 AM CET 
//


package rs.uns.ftn.p_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipNaziv complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipNaziv">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="osoba" type="{http://www.ftn.uns.rs/P-1}tipOsoba" minOccurs="0"/>
 *         &lt;element name="firma" type="{http://www.ftn.uns.rs/P-1}tipFirma" minOccurs="0"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipNaziv", propOrder = {
    "osoba",
    "firma"
})
public class TipNaziv {

    protected TipOsoba osoba;
    protected TipFirma firma;

    /**
     * Gets the value of the osoba property.
     * 
     * @return
     *     possible object is
     *     {@link TipOsoba }
     *     
     */
    public TipOsoba getOsoba() {
        return osoba;
    }

    /**
     * Sets the value of the osoba property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipOsoba }
     *     
     */
    public void setOsoba(TipOsoba value) {
        this.osoba = value;
    }

    /**
     * Gets the value of the firma property.
     * 
     * @return
     *     possible object is
     *     {@link TipFirma }
     *     
     */
    public TipFirma getFirma() {
        return firma;
    }

    /**
     * Sets the value of the firma property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipFirma }
     *     
     */
    public void setFirma(TipFirma value) {
        this.firma = value;
    }

}
