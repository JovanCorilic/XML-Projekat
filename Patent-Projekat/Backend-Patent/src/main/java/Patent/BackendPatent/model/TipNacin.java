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
 * <p>Java class for tipNacin complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="tipNacin">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dostavljanje_pismena_iskljucivo_elektronskim_putem" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="dostavljanje_pismena_u_papirnoj_formi" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipNacin", propOrder = {
    "dostavljanjePismenaIskljucivoElektronskimPutem",
    "dostavljanjePismenaUPapirnojFormi"
})
public class TipNacin {

    @XmlElement(name = "dostavljanje_pismena_iskljucivo_elektronskim_putem")
    protected boolean dostavljanjePismenaIskljucivoElektronskimPutem;
    @XmlElement(name = "dostavljanje_pismena_u_papirnoj_formi")
    protected boolean dostavljanjePismenaUPapirnojFormi;

    /**
     * Gets the value of the dostavljanjePismenaIskljucivoElektronskimPutem property.
     * 
     */
    public boolean isDostavljanjePismenaIskljucivoElektronskimPutem() {
        return dostavljanjePismenaIskljucivoElektronskimPutem;
    }

    /**
     * Sets the value of the dostavljanjePismenaIskljucivoElektronskimPutem property.
     * 
     */
    public void setDostavljanjePismenaIskljucivoElektronskimPutem(boolean value) {
        this.dostavljanjePismenaIskljucivoElektronskimPutem = value;
    }

    /**
     * Gets the value of the dostavljanjePismenaUPapirnojFormi property.
     * 
     */
    public boolean isDostavljanjePismenaUPapirnojFormi() {
        return dostavljanjePismenaUPapirnojFormi;
    }

    /**
     * Sets the value of the dostavljanjePismenaUPapirnojFormi property.
     * 
     */
    public void setDostavljanjePismenaUPapirnojFormi(boolean value) {
        this.dostavljanjePismenaUPapirnojFormi = value;
    }

}
