//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5.1 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.29 at 10:39:47 AM CET 
//


package Patent.BackendPatent.model.resenjePatent;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the rs.uns.ftn.resenjepatent package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: rs.uns.ftn.resenjepatent
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Resenje }
     * 
     */
    public Resenje createResenje() {
        return new Resenje();
    }

    /**
     * Create an instance of {@link TipSluzbenik }
     * 
     */
    public TipSluzbenik createTipSluzbenik() {
        return new TipSluzbenik();
    }

    /**
     * Create an instance of {@link Resenje.DatumOdlukeOZahtevu }
     * 
     */
    public Resenje.DatumOdlukeOZahtevu createResenjeDatumOdlukeOZahtevu() {
        return new Resenje.DatumOdlukeOZahtevu();
    }

    /**
     * Create an instance of {@link TipProlaz }
     * 
     */
    public TipProlaz createTipProlaz() {
        return new TipProlaz();
    }

    /**
     * Create an instance of {@link Resenje.Sluzbenik }
     * 
     */
    public Resenje.Sluzbenik createResenjeSluzbenik() {
        return new Resenje.Sluzbenik();
    }

    /**
     * Create an instance of {@link TipSluzbenik.Ime }
     * 
     */
    public TipSluzbenik.Ime createTipSluzbenikIme() {
        return new TipSluzbenik.Ime();
    }

    /**
     * Create an instance of {@link TipSluzbenik.Prezime }
     * 
     */
    public TipSluzbenik.Prezime createTipSluzbenikPrezime() {
        return new TipSluzbenik.Prezime();
    }

}
