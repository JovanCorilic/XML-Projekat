//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.03 at 02:10:42 PM CET 
//


package Patent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipAdresaDostavljanje complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipAdresaDostavljanje">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naziv_ulice" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="broj_ulice" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="grad" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="postanski_broj" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipAdresaDostavljanje", propOrder = {
    "nazivUlice",
    "brojUlice",
    "grad",
    "postanskiBroj"
})
public class TipAdresaDostavljanje {

    @XmlElement(name = "naziv_ulice", required = true)
    protected String nazivUlice;
    @XmlElement(name = "broj_ulice")
    protected int brojUlice;
    @XmlElement(required = true)
    protected String grad;
    @XmlElement(name = "postanski_broj")
    protected int postanskiBroj;

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
     */
    public int getBrojUlice() {
        return brojUlice;
    }

    /**
     * Sets the value of the brojUlice property.
     * 
     */
    public void setBrojUlice(int value) {
        this.brojUlice = value;
    }

    /**
     * Gets the value of the grad property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrad() {
        return grad;
    }

    /**
     * Sets the value of the grad property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrad(String value) {
        this.grad = value;
    }

    /**
     * Gets the value of the postanskiBroj property.
     * 
     */
    public int getPostanskiBroj() {
        return postanskiBroj;
    }

    /**
     * Sets the value of the postanskiBroj property.
     * 
     */
    public void setPostanskiBroj(int value) {
        this.postanskiBroj = value;
    }

}