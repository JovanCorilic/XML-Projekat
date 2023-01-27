<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:template match = "/">
    
        <html>
            <head>
                <title>
                    ZAVOD ZA INTELEKTUALNU SVOJINU
                </title>
                <style>
                    table, tr, td {
                    cellspacing="0"
                    cellpadding="0"
                    width: 100%;
                    }
                </style>
            </head>
        <body>
                <table>
                    <tr>
                        <td colspan="2">ZAVOD ZA INTELEKTUALNU SVOJINU OBRAZAC AJedan</td>
                        <td colspan="2" text-align="left">ZAVOD ZA INTELEKTUALNU SVOJINU OBRAZAC AJedan</td>
                    </tr>
                    <tr>
                        <td colspan="4">Beograd, Kneginje Ljubice 5</td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="4">Podnosilac - ime, prezime, adresa i državljanstvo autora ili drugog nosioca autorskog prava ako je
                            podnosilac fiziko lice, odnosno poslovno ime i sedište nosioca autorskog prava ako je podnosilac
                            pravno lice*:</td>
                    </tr>
                    
                    <tr><!-- JEDAN -->
                        <td colspan="4">
                            Ime: <xsl:value-of select = "AJedan/Jedan/Podnosilac/Ime"/><br />
                            Prezime: <xsl:value-of select = "AJedan/Jedan/Podnosilac/Prezime"/><br />
                            Adresa: <xsl:value-of select = "AJedan/Jedan/Podnosilac/Adresa/Grad"/> , <xsl:value-of select = "AJedan/Jedan/Podnosilac/Adresa/Ulica"/> <xsl:value-of select = "AJedan/Jedan/Podnosilac/Adresa/Broj"/><br />
                            Drzavljanstvo: <xsl:value-of select = "AJedan/Jedan/Podnosilac/Drzavljanstvo"/>
                        </td>
                        <td colspan="4">
                            Telefonski Broj: <xsl:value-of select = "AJedan/Jedan/Telefonski_Broj"/><br />
                            E-mail Adresa: <xsl:value-of select = "AJedan/Jedan/email"/>
                        </td>
                    </tr>
                    
                    <tr><!-- DVA -->
                        <td colspan="4">Pseudonim ili znak autora, (ako ga ima):</td>
                        <td colspan="4">
                            Pseudonim: <xsl:value-of select = "AJedan/Dva/Pseudonim"/><br />
                            Znak Autora: <xsl:value-of select = "AJedan/Dva/Znak_Autora"/>
                        </td>
                    </tr>
                    
                    <tr><!-- TRI -->
                        <td colspan="4">Ime, prezime i adresa punomoćnika, ako se prijava podnosi preko punomoćnika</td>
                        <td colspan="4">
                            Punomoćnik: <br />
                                Ime: <xsl:value-of select = "AJedan/Tri/Punomocnik/Ime"/><br />
                                Prezime: <xsl:value-of select = "AJedan/Tri/Punomocnik/Prezime"/><br />
                                Adresa: <xsl:value-of select = "AJedan/Tri/Punomocnik/Adresa/Grad"/> , <xsl:value-of select = "AJedan/Tri/Punomocnik/Adresa/Ulica"/> <xsl:value-of select = "AJedan/Tri/Podnosilac/Adresa/Broj"/>
                        </td>
                    </tr>
                    
                    <tr><!-- CETIRI -->
                        <td colspan="4">
                            Naslov autorskog dela, odnosno alternativni naslov, ako ga ima, po kome autorsko delo može da
                            se identifikuje
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            Naslov/i:<br />
                            Naslov: <xsl:value-of select = "AJedan/Cetiri/Naslov"/><br />
                            Alternativni naslov: <xsl:value-of select = "AJedan/Cetiri/Alternativni_Naslov"/>
                        </td>
                        
                    </tr>
                    
                    <tr><!-- PET -->
                        <td colspan="4">
                            Podaci o naslovu autorskog dela na kome se zasniva delo prerade, ako je u pitanju autorsko delo
                            prerade, kao i podatak o autoru izvornog dela
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            Podaci O Originalnom Autorskom Delu: <xsl:value-of select = "AJedan/Pet/Autorsko_Delo_Prerade/Podaci_O_Originalnom_Autorskom_Delu"/><br />
                            Ime Autora: <xsl:value-of select = "AJedan/Pet/Autorsko_Delo_Prerade/Ime_Autora"/>
                        </td>
                    </tr>
                    
                    <tr><!-- SEST -->
                        <td colspan="4">
                            Podaci o vrsti autorskog dela (književno delo, muziko delo, likovno delo, raunarski program i dr.) 
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            Vrsta autorskog dela: <xsl:value-of select = "AJedan/Sest/Podaci_O_Vrsti_Autorskog_Dela"/>
                        </td>
                    </tr>
                    
                    <tr><!-- SEDAM -->
                        <td colspan="4">
                            Podaci o formi zapisa autorskog dela (štampani tekst, optiki disk i slino) *:
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            Forma zapisa autorskog dela: t<xsl:value-of select = "AJedan/Sedam/Podaci_O_Formi_Autorskog_Zapisa_Dela"/>
                        </td>
                    </tr>
                    
                    <tr><!-- OSAM -->
                        <td colspan="4">
                            Podaci o autoru ako podnosilac prijave iz take 1. ovog zahteva nije autor i to: prezime, ime, adresa
                            i državljanstvo autora (grupe autora ili koautora), a ako su u pitanju jedan ili više autora koji nisu
                            živi, imena autora i godine smrti autora a ako je u pitanju autorsko delo anonimnog autora navod
                            da je autorsko delo delo anonimnog autora:
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            Prilozi: <br />
                            <!-- ZIVI -->
                            <xsl:for-each select="AJedan/Osam/Podnosioci/Zivi_Podnosioci/Ziv_Podnosilac">
                                <xsl:value-of select = "Ziv_Podnosilac/Prezime"/> <xsl:value-of select = "Ziv_Podnosilac/Ime"/>
                                <xsl:value-of select = "Ziv_Podnosilac/adresa/grad"/> <xsl:value-of select = "Ziv_Podnosilac/Adresa/Ulica"/> <xsl:value-of select = "Ziv_Podnosilac/Adresa/Broj"/>
                                <xsl:value-of select = "Ziv_Podnosilac/Drzavljanstvo"/>
                            </xsl:for-each>
                            <!-- MRTVI -->
                            <xsl:for-each select="AJedan/Osam/Podnosioci/Mrtvi_Podnosioci">
                                <xsl:value-of select = "Mrtav_Podnosilac/Prezime"/> <xsl:value-of select = "Mrtav_Podnosilac/Ime"/> <xsl:value-of select = "Mrtav_Podnosilac/Godina_Smrti"/>
                            </xsl:for-each>
                            <!-- ANONIMNI -->
                            <xsl:for-each select="AJedan/Osam/Podnosioci/Mrtvi_Podnosioci/Anoniman_Podnosilac">
                                <xsl:value-of select = "Delo_Anonimnog_Autora"/>
                            </xsl:for-each>
                        </td>
                    </tr>

                    <tr><!-- DEVET -->
                        <td colspan="4">
                            Podatak da li je u pitanju autorsko delo stvoreno u radnom odnosu:
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <xsl:value-of select = "AJedan/Devet/Da_Li_Je_Autorsko_Delo_Stvoreno_U_Radnom_Odnosu"/>
                        </td>
                    </tr>

                    <tr><!-- DESET -->
                        <td colspan="4">
                            Način korišćenja autorskog dela ili nameravani način korišćenja autorskog dela:
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <xsl:value-of select = "AJedan/Deset/Nacin_Koriscenja_Autorskog_Dela"/><br />
                            <xsl:value-of select = "AJedan/Devet/Nameravani_Nacin_Koriscenja_Autorskog_Dela"/>
                        </td>
                    </tr>

                    <tr><!-- JEDANAEST -->
                        <td colspan="2">
                            <xsl:value-of select = "AJedan/Jedanaest/Potpis"/>
                        </td>
                        <td colspan="2">
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            ____________________________________________
                        </td>
                        <td colspan="1">
                            <b>Podnosilac prijave, nosilac prava</b>
                        </td>
                        <td colspan="1">
                            (mesto za potpis fizičkog lica, odnosno potpis
                            zastupnika pravnog lica ili ovlašćenog predstavnika
                            u pravnom licu)*
                        </td>
                    </tr>

                    <tr><!-- DVANAEST -->
                        <td colspan="4">
                            Prilozi koji se podnose uz zahtev:
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <xsl:value-of select = "AJedan/Dvanaest/Prilozi_Uz_Zahtev"/><br />
                        </td>
                    </tr>






                    
                    <tr>
                        <td colspan="4">
                            <td colspan="4" text-align="center">- opis autorskog dela (ako je delo podneto na optikom disku</td>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <xsl:value-of select = "AJedan/Opis_Autorskog_Dela"/><br />
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <td colspan="4" text-align="center">- primer autorskog dela (slika, video zapis, audio zapis);</td>
                        </td>
                    </tr>
                    
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>
                    <tr>
                        <td colspan="2"></td>
                        <td colspan="2">
                            Broj Prijave<br />
                            A-<xsl:value-of select = "AJedan/Broj_Prijace"/><br /><br />
                            Datum Podnosenja<br />
                            <xsl:value-of select = "AJedan/Datum_Podnosenja"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Rubrike u zahtevu A-1 koje su označene sa * moraju da budu obavezno popunjene.</td>
                    </tr>
                </table>

            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
        
        
      