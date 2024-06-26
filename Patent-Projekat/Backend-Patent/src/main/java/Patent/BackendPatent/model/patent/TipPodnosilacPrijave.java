//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.29 at 10:39:47 AM CET 
//


package Patent.BackendPatent.model.patent;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipPodnosilacPrijave complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipPodnosilacPrijave">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="licne_informacije" type="{http://www.ftn.uns.rs/P-1}tipLicneInformacije"/>
 *         &lt;element name="drzavljanstvo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="je_pronalazac" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipPodnosilacPrijave", propOrder = {
    "licneInformacije",
    "drzavljanstvo",
    "jePronalazac"
})
public class TipPodnosilacPrijave {

    @XmlElement(name = "licne_informacije", required = true)
    protected TipLicneInformacije licneInformacije;
    @XmlElement(required = true)
    protected String drzavljanstvo;
    @XmlElement(name = "je_pronalazac")
    protected boolean jePronalazac;

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

    /**
     * Gets the value of the drzavljanstvo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    /**
     * Sets the value of the drzavljanstvo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrzavljanstvo(String value) {
        this.drzavljanstvo = value;
    }

    /**
     * Gets the value of the jePronalazac property.
     * 
     */
    public boolean isJePronalazac() {
        return jePronalazac;
    }

    /**
     * Sets the value of the jePronalazac property.
     * 
     */
    public void setJePronalazac(boolean value) {
        this.jePronalazac = value;
    }

    public boolean proveraPodnosilacPrijave(){
        if (
                this.getDrzavljanstvo().equals("") || this.getLicneInformacije().ProveraLicneInformacije()
        ){
            return true;
        }else
            return false;
    }

}
