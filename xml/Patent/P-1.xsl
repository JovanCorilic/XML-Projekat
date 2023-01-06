<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    exclude-result-prefixes="xs"
    version="2.0">
    <xsl:template match = "/"> 
        <html>
            <head>
                <title>
                   ZAHTEV ZA PRIZNANjE PATENTA
                </title>
            </head>
            <body>
                <table style="width: 55%">
                    <tr>
                        <td colspan="2">Popunjava Zavod</td>
                    </tr>
                    <tr>
                        <td colspan="2">Broj prijave <br/>
                            <xsl:value-of select = "P-1/popunjava_zavod/broj_prijave"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Datum prijema <br/>
                            <xsl:value-of select = "P-1/popunjava_zavod/datum_prijema"/>
                        </td>
                        <td>
                            Priznati datum podnošenja <br></br>
                            <xsl:value-of select = "P-1/popunjava_zavod/priznati_datum_podnosenja"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">Pečat i potpis <br></br>
                            Nevažno
                        </td>
                    </tr>
                </table> <br></br>
                <p>
                    Republika Srbija <br></br>
                    Zavod za intelektualnu svojinu <br></br>
                    Kneginje Ljubice broj 5 <br></br>
                    11000 Beograd <br></br>
                </p>
                <p>ZAHTEV <br></br>
                    ZA PRIZNANjE PATENTA</p>
                <p>(popuniti pisaćom mašinom ili računarom)</p>
                <table style="width: 90%">
                    <tr>
                        <td colspan="3">
                            Polje broj I	  NAZIV PRONALASKA <br></br>
                            * Naziv pronalaska treba da jasno i sažeto izražava suštinu pronalaska i ne 
                            sme da sadrži izmišljene ili komercijalne nazive, žigove, imena, šifre, uobičajene 
                            skraćenice za proizvode i sl.
                            
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">Na srpskom jeziku: 
                            <xsl:value-of select = "P-1/naziv_pronalaska/srpski_naziv"/><br></br>
                            Na engleskom jeziku:  
                            <xsl:value-of select = "P-1/naziv_pronalaska/engleski_naziv"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">Polje broj II	   PODNOSILAC PRIJAVE  
                            <xsl:choose>
                                <xsl:when test="P-1/podnosilac_prijave/je_pronalazac = 'true'">
                                    <input type="checkbox" checked="">Podnosilac prijave je i pronalazač</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >Podnosilac prijave je i pronalazač</input>
                                </xsl:otherwise>
                            </xsl:choose>
                        </td>
                    </tr>
                    <tr>
                        <td rowspan="2">
                            Ime i prezime / Poslovno ime: (prezime / poslovno ime upisati velikim slovima)<br></br>
                            <xsl:value-of select = "P-1/podnosilac_prijave/licne_informacije/naziv"/>
                        </td>
                        <td rowspan="2">
                            Ulica i broj, poštanski broj, mesto i država:<br></br>
                            <xsl:value-of select = "P-1/podnosilac_prijave/licne_informacije/prebivaliste"/>
                        </td>
                        <td>
                            Broj telefona:<br></br>
                            <xsl:value-of select = "P-1/podnosilac_prijave/licne_informacije/kontakt/broj_telefona"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Broj faksa:<br></br>
                            <xsl:value-of select = "P-1/podnosilac_prijave/licne_informacije/kontakt/broj_faksa"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            Državljanstvo:  <xsl:value-of select = "P-1/podnosilac_prijave/licne_informacije/drzavljanstvo"/> 
                            (popuniti samo za fizička lica)	
                        </td>
                        <td>
                            E-pošta: <br></br>
                            <xsl:value-of select = "P-1/podnosilac_prijave/licne_informacije/kontakt/e-posta"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            ☐   Ostali podnosioci prijave su navedeni u dodatnom listu 1 u nastavku ovog zahteva <br></br>
                            * Ako više lica podnosi prijavu, potrebno je odrediti jedno od tih lica kao zajedničkog predstavnika i dostaviti izjavu o zajedničkom predstavniku potpisanu od strane svih podnosilaca ili imenovati zajedničkog punomoćnika za zastupanje i dostaviti punomoćje
                        </td>
                    </tr>
                </table>
                
                <table style="width: 90%">
                    <tr>
                        
                    </tr>
                </table>
                
                <table>
                    <tr>
                        <td colspan="3">
                            Polje broj III        PRONALAZAČ  <br></br>
                            (ako su svi pronalazači ujedno i podnosioci prijave, polje broj III se ne popunjava)<br></br>
                            * Ako svi podnosioci prijave nisu i pronalazači, dostavlja se izjava podnosilaca prijave o 
                            osnovu sticanja prava na podnošenje prijave u odnosu na pronalazače koji nisu i podnosioci 
                            prijave i u tom slučaju u polje broj III se unose podaci o svim pronalazačim <br></br>
                            <xsl:choose>
                                <xsl:when test="P-1/pronalazac/da_li_pronalazac_zeli_da_bude_naveden = 'true'">
                                    <input type="checkbox" checked="">Pronalazač ne želi da bude naveden u prijavi</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >Pronalazač ne želi da bude naveden u prijavi</input>
                                </xsl:otherwise>
                            </xsl:choose> <br></br>
                            (ako pronalazač ne želi da bude naveden u prijavi polje broj III se ne popunjava)<br></br>
                            *Ako pronalazač ne želi da bude naveden u prijavi, potrebno je dostaviti potpisanu 
                            izjavu pronalazača da ne želi da bude naveden.
                        </td>
                    </tr>
                    <tr>
                        <td rowspan="3">
                            Ime i prezime: (prezime upisati velikim slovima) <br></br>
                            <xsl:value-of select = "P-1/pronalazac/licne_informacije/naziv"/>
                        </td>
                        <td rowspan="3">
                            Ulica i broj, poštanski broj, mesto i država:<br></br>
                            <xsl:value-of select = "P-1/pronalazac/licne_informacije/prebivaliste"/>
                        </td>
                        <td>
                            Broj telefona:<br></br>
                            <xsl:value-of select = "P-1/pronalazac/licne_informacije/kontakt/broj_telefona"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Broj faksa:<br></br>
                            <xsl:value-of select = "P-1/pronalazac/licne_informacije/kontakt/broj_faksa"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            E-pošta:<br></br>
                            <xsl:value-of select = "P-1/pronalazac/licne_informacije/kontakt/e-posta"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            ☐  Ostali pronalazači su navedeni u dodatnom listu 1 u nastavku ovog zahteva
                        </td>
                    </tr>
                </table>
                
                <table style="width: 90%">
                    <tr>
                        <td colspan="3">
                            Polje broj IV  <xsl:choose>
                                <xsl:when test="P-1/punomocnik/da_li_je_punomocnik_za_zastupanje = 'true'">
                                    <input type="checkbox" checked="">PUNOMOĆNIK ZA ZASTUPANjE</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >PUNOMOĆNIK ZA ZASTUPANjE</input>
                                </xsl:otherwise>
                            </xsl:choose>  
                            <xsl:choose>
                                <xsl:when test="P-1/punomocnik/da_li_je_punomocnik_za_prijem_pismena = 'true'">
                                    <input type="checkbox" checked="">PUNOMOĆNIK ZA PRIJEM PISMENA</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >PUNOMOĆNIK ZA PRIJEM PISMENA</input>
                                </xsl:otherwise>
                            </xsl:choose>  <br></br>
                            <xsl:choose>
                                <xsl:when test="P-1/punomocnik/da_li_je_zajednicki_predstavnik = 'true'">
                                    <input type="checkbox" checked="">ZAJEDNIČKI PREDSTAVNIK</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >ZAJEDNIČKI PREDSTAVNIK</input>
                                </xsl:otherwise>
                            </xsl:choose> <br></br>
                            * Punomoćnik za zastupanje je lice koje po ovlašćenju podnosioca prijave preduzima radnje u 
                            upravnom postupku u granicama punomoćja<br></br>
                            * Punomoćnik za prijem pismena je lice koje je podnosilac prijave odredio kao lice kome se  
                            upućuju sva pismena naslovljena na podnosioca<br></br>
                            * Zajedniči prestavnik je podnosilac prijave koga su podnosioci prijave, u slučaju da prijavu 
                            podnosi više lica, odredili da istupa u postupku pred organom ako podnosioci nisu imenovali 
                            zajedničkog punomoćnika za zastupanje
                        </td>
                    </tr>
                    <tr>
                        <td rowspan="2">
                            Ime i prezime: (prezime upisati velikim slovima) <br></br>
                            <xsl:value-of select = "P-1/punomocnik/licne_informacije/naziv"/>
                        </td>
                        <td rowspan="2">
                            Ulica i broj, poštanski broj, mesto i država:<br></br>
                            <xsl:value-of select = "P-1/punomocnik/licne_informacije/prebivaliste"/>
                        </td>
                        <td>
                            Broj telefona:<br></br>
                            <xsl:value-of select = "P-1/punomocnik/licne_informacije/kontakt/broj_telefona"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            E-pošta:<br></br>
                            <xsl:value-of select = "P-1/punomocnik/licne_informacije/kontakt/e-posta"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            Polje broj V        ADRESA ZA DOSTAVLjANjE  <br></br>
                            (ovo polje se popunjava ako podnosilac prijave, zajednički predstavnik ili 
                            punomoćnik želi da se dostavljanje podnesaka vrši na drugoj adresi od njegove navedene adrese)
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            Ulica i broj, poštanski broj i mesto: <br></br>
                            <xsl:value-of select = "P-1/dostavljanje/adresa"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            Polje broj VI        NAČIN DOSTAVLjANjA 
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <xsl:choose>
                                <xsl:when test="P-1/dostavljanje/nacin/dostavljanje_pismena_iskljucivo_elektronskim_putem = 'true'">
                                    <input type="checkbox" checked="">Podnosilac prijave je saglasan da Zavod vrši dostavljanje pismena isključivo elektronskim putem u formi elektronskog dokumenta (u ovom slučaju neophodna je registracija na portalu „eUprave”)</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >Podnosilac prijave je saglasan da Zavod vrši dostavljanje pismena isključivo elektronskim putem u formi elektronskog dokumenta (u ovom slučaju neophodna je registracija na portalu „eUprave”)</input>
                                </xsl:otherwise>
                            </xsl:choose> <br></br>
                            <xsl:choose>
                                <xsl:when test="P-1/dostavljanje/nacin/dostavljanje_pismena_u_papirnoj_formi = 'true'">
                                    <input type="checkbox" checked="">Podnosilac prijave je saglasan da Zavod vrši dostavljanje pismena u papirnoj formi</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >Podnosilac prijave je saglasan da Zavod vrši dostavljanje pismena u papirnoj formi</input>
                                </xsl:otherwise>
                            </xsl:choose>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            Polje broj VII 
                            <xsl:choose>
                                <xsl:when test="P-1/tip_prijave/da_li_je_dopunska_prijava = 'true'">
                                    <input type="checkbox" checked="">DOPUNSKA PRIJAVA</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >DOPUNSKA PRIJAVA</input>
                                </xsl:otherwise>
                            </xsl:choose> 
                            <xsl:choose>
                                <xsl:when test="P-1/tip_prijave/da_li_je_izdvojena_prijava = 'true'">
                                    <input type="checkbox" checked="">IZDVOJENA PRIJAVA</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >IZDVOJENA PRIJAVA</input>
                                </xsl:otherwise>
                            </xsl:choose>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            Broj prvobitne prijave / osnovne prijave, odnosno osnovnog patenta:  
                            <xsl:value-of select = "P-1/tip_prijave/broj_prvobitne_prijave"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            Datum podnošenja prvobitne prijave / osnovne prijave: 
                            <xsl:value-of select = "P-1/tip_prijave/datum_podnosenja_prvobitne_prijave"/>
                        </td>
                    </tr>
                </table>
                
                <table style="width: 90%">
                    <tr>
                        <td colspan="5">
                            Polje broj VIII       ZAHTEV ZA PRIZNANjE PRAVA PRVENSTVA IZ RANIJIH PRIJAVA:
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            Datum podnošenja ranije prijave
                        </td>
                        <td></td>
                        <td>
                            Broj ranije prijave
                        </td>
                        <td>
                            Dvoslovna oznaka države, regionalne ili međunarodne organizacije
                        </td>
                    </tr>
                    <xsl:for-each select="P-1/zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava">
                        <tr>
                            <td>
                                <xsl:value-of select="position()-1" />
                            </td>
                            <td>
                                <xsl:value-of select = "ranija_prijava/datum_podnosenja_ranije_prijave"/>
                            </td>
                            <td>
                                <xsl:value-of select = "ranija_prijava/broj_ranije_prijave"/>
                            </td>
                            <td>
                                <xsl:value-of select = "ranija_prijava/dvoslovna_oznaka_drzave_ili_organizacije"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                    <tr>
                        <td colspan="5">
                            ☐  Podaci o ostalim pravima prvenstva su navedeni u dodatnom listu 2 u nastavku ovog zahteva
                        </td>
                    </tr>
                </table>
                
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>