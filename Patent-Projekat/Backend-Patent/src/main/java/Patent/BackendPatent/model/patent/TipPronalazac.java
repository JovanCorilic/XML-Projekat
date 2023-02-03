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
 * <p>Java class for tipPronalazac complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipPronalazac">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="da_li_pronalazac_zeli_da_bude_naveden" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="licne_informacije" type="{http://www.ftn.uns.rs/P-1}tipLicneInformacije"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipPronalazac", propOrder = {
    "daLiPronalazacZeliDaBudeNaveden",
    "licneInformacije"
})
public class TipPronalazac {

    @XmlElement(name = "da_li_pronalazac_zeli_da_bude_naveden")
    protected boolean daLiPronalazacZeliDaBudeNaveden;
    @XmlElement(name = "licne_informacije", required = true)
    protected TipLicneInformacije licneInformacije;

    /**
     * Gets the value of the daLiPronalazacZeliDaBudeNaveden property.
     * 
     */
    public boolean isDaLiPronalazacZeliDaBudeNaveden() {
        return daLiPronalazacZeliDaBudeNaveden;
    }

    /**
     * Sets the value of the daLiPronalazacZeliDaBudeNaveden property.
     * 
     */
    public void setDaLiPronalazacZeliDaBudeNaveden(boolean value) {
        this.daLiPronalazacZeliDaBudeNaveden = value;
    }

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

    public boolean ProveraPronalazac(){
        if (this.isDaLiPronalazacZeliDaBudeNaveden())
            if (this.getLicneInformacije().ProveraLicneInformacije())
                return true;
        return false;
    }

}
