//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2022.12.11 at 06:50:29 PM CET 
//


package rs.uns.ftn.p_1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *         &lt;element name="popunjava_zavod" type="{http://www.ftn.uns.rs/P-1}tipPopunjavaZavod"/>
 *         &lt;element name="naslov" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="naziv_pronalaska" type="{http://www.ftn.uns.rs/P-1}tipNazivPronalaska"/>
 *         &lt;element name="podnosilac_prijave" type="{http://www.ftn.uns.rs/P-1}tipPodnosilacPrijave"/>
 *         &lt;element name="pronalazac" type="{http://www.ftn.uns.rs/P-1}tipPronalazac"/>
 *         &lt;element name="punomocnik" type="{http://www.ftn.uns.rs/P-1}tipPunomocnik"/>
 *         &lt;element name="dostavljanje" type="{http://www.ftn.uns.rs/P-1}tipDostavljanje"/>
 *         &lt;element name="tip_prijave" type="{http://www.ftn.uns.rs/P-1}tipTipPrijave"/>
 *         &lt;element name="zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava" type="{http://www.ftn.uns.rs/P-1}tipZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "popunjavaZavod",
    "naslov",
    "nazivPronalaska",
    "podnosilacPrijave",
    "pronalazac",
    "punomocnik",
    "dostavljanje",
    "tipPrijave",
    "zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava"
})
@XmlRootElement(name = "P-1")
public class P1 {

    @XmlElement(name = "popunjava_zavod", required = true)
    protected TipPopunjavaZavod popunjavaZavod;
    @XmlElement(required = true)
    protected String naslov;
    @XmlElement(name = "naziv_pronalaska", required = true)
    protected TipNazivPronalaska nazivPronalaska;
    @XmlElement(name = "podnosilac_prijave", required = true)
    protected TipPodnosilacPrijave podnosilacPrijave;
    @XmlElement(required = true)
    protected TipPronalazac pronalazac;
    @XmlElement(required = true)
    protected TipPunomocnik punomocnik;
    @XmlElement(required = true)
    protected TipDostavljanje dostavljanje;
    @XmlElement(name = "tip_prijave", required = true)
    protected TipTipPrijave tipPrijave;
    @XmlElement(name = "zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava", required = true)
    protected TipZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Gets the value of the popunjavaZavod property.
     * 
     * @return
     *     possible object is
     *     {@link TipPopunjavaZavod }
     *     
     */
    public TipPopunjavaZavod getPopunjavaZavod() {
        return popunjavaZavod;
    }

    /**
     * Sets the value of the popunjavaZavod property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipPopunjavaZavod }
     *     
     */
    public void setPopunjavaZavod(TipPopunjavaZavod value) {
        this.popunjavaZavod = value;
    }

    /**
     * Gets the value of the naslov property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaslov() {
        return naslov;
    }

    /**
     * Sets the value of the naslov property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaslov(String value) {
        this.naslov = value;
    }

    /**
     * Gets the value of the nazivPronalaska property.
     * 
     * @return
     *     possible object is
     *     {@link TipNazivPronalaska }
     *     
     */
    public TipNazivPronalaska getNazivPronalaska() {
        return nazivPronalaska;
    }

    /**
     * Sets the value of the nazivPronalaska property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipNazivPronalaska }
     *     
     */
    public void setNazivPronalaska(TipNazivPronalaska value) {
        this.nazivPronalaska = value;
    }

    /**
     * Gets the value of the podnosilacPrijave property.
     * 
     * @return
     *     possible object is
     *     {@link TipPodnosilacPrijave }
     *     
     */
    public TipPodnosilacPrijave getPodnosilacPrijave() {
        return podnosilacPrijave;
    }

    /**
     * Sets the value of the podnosilacPrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipPodnosilacPrijave }
     *     
     */
    public void setPodnosilacPrijave(TipPodnosilacPrijave value) {
        this.podnosilacPrijave = value;
    }

    /**
     * Gets the value of the pronalazac property.
     * 
     * @return
     *     possible object is
     *     {@link TipPronalazac }
     *     
     */
    public TipPronalazac getPronalazac() {
        return pronalazac;
    }

    /**
     * Sets the value of the pronalazac property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipPronalazac }
     *     
     */
    public void setPronalazac(TipPronalazac value) {
        this.pronalazac = value;
    }

    /**
     * Gets the value of the punomocnik property.
     * 
     * @return
     *     possible object is
     *     {@link TipPunomocnik }
     *     
     */
    public TipPunomocnik getPunomocnik() {
        return punomocnik;
    }

    /**
     * Sets the value of the punomocnik property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipPunomocnik }
     *     
     */
    public void setPunomocnik(TipPunomocnik value) {
        this.punomocnik = value;
    }

    /**
     * Gets the value of the dostavljanje property.
     * 
     * @return
     *     possible object is
     *     {@link TipDostavljanje }
     *     
     */
    public TipDostavljanje getDostavljanje() {
        return dostavljanje;
    }

    /**
     * Sets the value of the dostavljanje property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipDostavljanje }
     *     
     */
    public void setDostavljanje(TipDostavljanje value) {
        this.dostavljanje = value;
    }

    /**
     * Gets the value of the tipPrijave property.
     * 
     * @return
     *     possible object is
     *     {@link TipTipPrijave }
     *     
     */
    public TipTipPrijave getTipPrijave() {
        return tipPrijave;
    }

    /**
     * Sets the value of the tipPrijave property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipTipPrijave }
     *     
     */
    public void setTipPrijave(TipTipPrijave value) {
        this.tipPrijave = value;
    }

    /**
     * Gets the value of the zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava property.
     * 
     * @return
     *     possible object is
     *     {@link TipZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava }
     *     
     */
    public TipZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava getZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava() {
        return zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava;
    }

    /**
     * Sets the value of the zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava }
     *     
     */
    public void setZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava(TipZahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava value) {
        this.zahtevZaPriznanjePravaPrvenstvaIzRanijihPrijava = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

}
