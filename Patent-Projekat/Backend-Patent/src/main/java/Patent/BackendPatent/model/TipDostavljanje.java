//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.11 at 06:50:29 PM CET 
//


package Patent.BackendPatent.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipDostavljanje complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipDostavljanje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="adresa" type="{http://www.ftn.uns.rs/P-1}tipAdresa"/>
 *         &lt;element name="nacin" type="{http://www.ftn.uns.rs/P-1}tipNacin"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipDostavljanje", propOrder = {
    "adresa",
    "nacin"
})
public class TipDostavljanje {

    @XmlElement(required = true)
    protected TipAdresa adresa;
    @XmlElement(required = true)
    protected TipNacin nacin;

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

    /**
     * Gets the value of the nacin property.
     * 
     * @return
     *     possible object is
     *     {@link TipNacin }
     *     
     */
    public TipNacin getNacin() {
        return nacin;
    }

    /**
     * Sets the value of the nacin property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipNacin }
     *     
     */
    public void setNacin(TipNacin value) {
        this.nacin = value;
    }

}
