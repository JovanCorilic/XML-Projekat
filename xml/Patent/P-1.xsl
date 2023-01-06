<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:template match = "/"> 
        <html>
            <head>
                <title>
                   ZAHTEV ZA PRIZNANjE PATENTA
                </title>
                <style>
                    table, tr, td {
                    border: 1px solid black;
                    border-collapse: collapse;
                    vertical-align: text-top;
                    font-family: arial;
                    font-size: 9px;
                    width: 100%;
                    }
                    body { font-family: arial;
                    font-size: 9px;
                    }
                </style>
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
                <p style="font-size: 10px;">
                    Republika Srbija <br></br>
                    Zavod za intelektualnu svojinu <br></br>
                    Kneginje Ljubice broj 5 <br></br>
                    11000 Beograd <br></br>
                </p>
                <p style="text-align: center;">ZAHTEV <br></br>
                    ZA PRIZNANjE PATENTA</p><br></br>
                <p style="text-align: center;">(popuniti pisaćom mašinom ili računarom)</p>
                <table >
                    <tr>
                        <td colspan="3">
                            Polje broj I&#xA0;&#xA0;NAZIV PRONALASKA <br></br>
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
                        <td colspan="3">Polje broj II&#xA0;&#xA0;PODNOSILAC PRIJAVE&#xA0;&#xA0;  
                            <xsl:choose>
                                <xsl:when test="P-1/podnosilac_prijave/je_pronalazac = 'true'">
                                    <input type="checkbox" checked="">(DA)</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >(NE)</input>
                                </xsl:otherwise>
                            </xsl:choose>&#xA0;&#xA0;Podnosilac prijave je i pronalazač
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
                            &#xA0;&#xA0;(popuniti samo za fizička lica)	
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
                <table >
                    <tr>
                        <td colspan="3">
                            Polje broj III&#xA0;&#xA0;PRONALAZAČ  <br></br>
                            (ako su svi pronalazači ujedno i podnosioci prijave, polje broj III se ne popunjava)<br></br>
                            * Ako svi podnosioci prijave nisu i pronalazači, dostavlja se izjava podnosilaca prijave o 
                            osnovu sticanja prava na podnošenje prijave u odnosu na pronalazače koji nisu i podnosioci 
                            prijave i u tom slučaju u polje broj III se unose podaci o svim pronalazačim <br></br>
                            <xsl:choose>
                                <xsl:when test="P-1/pronalazac/da_li_pronalazac_zeli_da_bude_naveden = 'true'">
                                    <input type="checkbox" checked="">(DA)</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >(NE)</input>
                                </xsl:otherwise>
                            </xsl:choose>&#xA0;&#xA0;Pronalazač ne želi da bude naveden u prijavi<br></br>
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
                
                <table >
                    <tr>
                        <td colspan="3">
                            Polje broj IV&#xA0;&#xA0;<xsl:choose>
                                <xsl:when test="P-1/punomocnik/da_li_je_punomocnik_za_zastupanje = 'true'">
                                    <input type="checkbox" checked="">(DA)</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >(NE)</input>
                                </xsl:otherwise>
                            </xsl:choose>&#xA0;&#xA0;PUNOMOĆNIK ZA ZASTUPANjE&#xA0;&#xA0;  
                            <xsl:choose>
                                <xsl:when test="P-1/punomocnik/da_li_je_punomocnik_za_prijem_pismena = 'true'">
                                    <input type="checkbox" checked="">(DA)</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >(NE)</input>
                                </xsl:otherwise>
                            </xsl:choose>&#xA0;&#xA0;PUNOMOĆNIK ZA PRIJEM PISMENA  <br></br>
                            <xsl:choose>
                                <xsl:when test="P-1/punomocnik/da_li_je_zajednicki_predstavnik = 'true'">
                                    <input type="checkbox" checked="">(DA)</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >(NE)</input>
                                </xsl:otherwise>
                            </xsl:choose>&#xA0;&#xA0;ZAJEDNIČKI PREDSTAVNIK <br></br>
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
                            Polje broj V&#xA0;&#xA0; ADRESA ZA DOSTAVLjANjE  <br></br>
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
                            Polje broj VI&#xA0;&#xA0; NAČIN DOSTAVLjANjA 
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            <xsl:choose>
                                <xsl:when test="P-1/dostavljanje/nacin/dostavljanje_pismena_iskljucivo_elektronskim_putem = 'true'">
                                    <input type="checkbox" checked="">(DA)</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >(NE)</input>
                                </xsl:otherwise>
                            </xsl:choose>&#xA0;&#xA0;Podnosilac prijave je saglasan da Zavod vrši dostavljanje pismena isključivo elektronskim putem u formi elektronskog dokumenta (u ovom slučaju neophodna je registracija na portalu „eUprave”) <br></br>
                            <xsl:choose>
                                <xsl:when test="P-1/dostavljanje/nacin/dostavljanje_pismena_u_papirnoj_formi = 'true'">
                                    <input type="checkbox" checked="">(DA)</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >(NE)</input>
                                </xsl:otherwise>
                            </xsl:choose>&#xA0;&#xA0;Podnosilac prijave je saglasan da Zavod vrši dostavljanje pismena u papirnoj formi
                        </td>
                    </tr>
                    <tr>
                        <td colspan="3">
                            Polje broj VII&#xA0;&#xA0;
                            <xsl:choose>
                                <xsl:when test="P-1/tip_prijave/da_li_je_dopunska_prijava = 'true'">
                                    <input type="checkbox" checked="">(DA)</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >(NE)</input>
                                </xsl:otherwise>
                            </xsl:choose>&#xA0;&#xA0;DOPUNSKA PRIJAVA&#xA0;&#xA0;
                            <xsl:choose>
                                <xsl:when test="P-1/tip_prijave/da_li_je_izdvojena_prijava = 'true'">
                                    <input type="checkbox" checked="">(DA)</input>
                                </xsl:when>
                                <xsl:otherwise>
                                    <input type="checkbox" >(NE)</input>
                                </xsl:otherwise>
                            </xsl:choose>&#xA0;&#xA0;IZDVOJENA PRIJAVA
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
                
                <table >
                    <tr>
                        <td colspan="5">
                            Polje broj VIII&#xA0;&#xA0;ZAHTEV ZA PRIZNANjE PRAVA PRVENSTVA IZ RANIJIH PRIJAVA:
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
                    <xsl:for-each select="P-1/zahtev_za_priznanje_prava_prvenstva_iz_ranijih_prijava/ranija_prijava">
                        <tr>
                            <td>
                                <xsl:value-of select="position()" />
                            </td>
                            <td>
                                <xsl:value-of select = "datum_podnosenja_ranije_prijave"/>
                            </td>
                            <td></td>
                            <td>
                                <xsl:value-of select = "broj_ranije_prijave"/>
                            </td>
                            <td>
                                <xsl:value-of select = "dvoslovna_oznaka_drzave_ili_organizacije"/>
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