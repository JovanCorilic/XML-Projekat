//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.08 at 11:10:33 AM CET 
//


package Patent.BackendPatent.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipAdresa complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipAdresa">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naziv_ulice_ustanove" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="broj_ulice_ustanove" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="grad_ustanove" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postanski_broj_ustanove" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipAdresa", propOrder = {
    "nazivUliceUstanove",
    "brojUliceUstanove",
    "gradUstanove",
    "postanskiBrojUstanove"
})
public class TipAdresa {

    @XmlElement(name = "naziv_ulice_ustanove", required = true)
    protected String nazivUliceUstanove;
    @XmlElement(name = "broj_ulice_ustanove")
    protected int brojUliceUstanove;
    @XmlElement(name = "grad_ustanove", required = true)
    protected String gradUstanove;
    @XmlElement(name = "postanski_broj_ustanove")
    protected int postanskiBrojUstanove;

    /**
     * Gets the value of the nazivUliceUstanove property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNazivUliceUstanove() {
        return nazivUliceUstanove;
    }

    /**
     * Sets the value of the nazivUliceUstanove property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNazivUliceUstanove(String value) {
        this.nazivUliceUstanove = value;
    }

    /**
     * Gets the value of the brojUliceUstanove property.
     * 
     */
    public int getBrojUliceUstanove() {
        return brojUliceUstanove;
    }

    /**
     * Sets the value of the brojUliceUstanove property.
     * 
     */
    public void setBrojUliceUstanove(int value) {
        this.brojUliceUstanove = value;
    }

    /**
     * Gets the value of the gradUstanove property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGradUstanove() {
        return gradUstanove;
    }

    /**
     * Sets the value of the gradUstanove property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGradUstanove(String value) {
        this.gradUstanove = value;
    }

    /**
     * Gets the value of the postanskiBrojUstanove property.
     * 
     */
    public int getPostanskiBrojUstanove() {
        return postanskiBrojUstanove;
    }

    /**
     * Sets the value of the postanskiBrojUstanove property.
     * 
     */
    public void setPostanskiBrojUstanove(int value) {
        this.postanskiBrojUstanove = value;
    }

}
