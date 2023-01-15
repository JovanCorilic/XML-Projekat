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
                        <td colspan="2">ZAVOD ZA INTELEKTUALNU SVOJINU OBRAZAC A-1</td>
                        <td colspan="2" text-align="left">ZAVOD ZA INTELEKTUALNU SVOJINU OBRAZAC A-1</td>
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
                    
                    <tr>
                        <td colspan="4">
                            Ime: <xsl:value-of select = "A-1/autor/ime"/><br />
                            Prezime: <xsl:value-of select = "A-1/autor/prezime"/><br />
                            Adresa: <xsl:value-of select = "A-1/autor/adresa/grad"/> , <xsl:value-of select = "A-1/autor/adresa/naziv_ulice"/> <xsl:value-of select = "A-1/autor/adresa/broj_ulice"/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="4">Pseudonim ili znak autora, (ako ga ima):</td>
                    </tr>
                    
                    <tr>
                        <td colspan="4">
                            Pseudonim ili znak autora: <xsl:value-of select = "A-1/pseudonim"/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="4">
                            Ime, prezime i adresa punomonika, ako se prijava podnosi preko punomonika:
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            [NEMA]<!-- TODO: staviti -->
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="4">
                            Naslov autorskog dela, odnosno alternativni naslov, ako ga ima, po kome autorsko delo može da
                            se identifikuje
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            Naslov/i:<br />
                            Naslov: <xsl:value-of select = "A-1/naslov"/>
                            Alternativni naslov: <xsl:value-of select = "A-1/alternativni_naslov"/>

                        </td>
                        
                    </tr>
                    
                    <tr>
                        <td colspan="4">
                            Podaci o naslovu autorskog dela na kome se zasniva delo prerade, ako je u pitanju autorsko delo
                            prerade, kao i podatak o autoru izvornog dela
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            <xsl:value-of select = "A-1/podaci_o_zasnivanju/podaci_o_naslovu"/>
                            <xsl:value-of select = "A-1/podaci_o_zasnivanju/podaci_o_autoru"/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="4">
                            Podaci o vrsti autorskog dela (književno delo, muziko delo, likovno delo, raunarski program i dr.) 
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            Vrsta autorskog dela: <xsl:value-of select = "A-1/vrsti_autorskog_dela"/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="4">
                            Podaci o formi zapisa autorskog dela (štampani tekst, optiki disk i slino) *:
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            Forma zapisa autorskog dela: t<xsl:value-of select = "A-1/forma_zapisa_autorskog_dela"/>
                        </td>
                    </tr>
                    
                    <tr>
                        <td colspan="4">
                            Podaci o autoru ako podnosilac prijave iz take 1. ovog zahteva nije autor i to: prezime, ime, adresa
                            i državljanstvo autora (grupe autora ili koautora), a ako su u pitanju jedan ili više autora koji nisu
                            živi, imena autora i godine smrti autora a ako je u pitanju autorsko delo anonimnog autora navod
                            da je autorsko delo delo anonimnog autora:
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            Ime i Prezime: <xsl:value-of select = "A-1/autor/ime"/> <xsl:value-of select = "A-1/autor/prezime"/><br />
                            Adresa: <xsl:value-of select = "A-1/autor/adresa/grad"/> <xsl:value-of select = "A-1/autor/adresa/naziv_ulice"/> <xsl:value-of select = "A-1/autor/adresa/broj_ulice"/>
                        </td>
                    </tr>
                    
                    
                    <tr>
                        <td colspan="4">
                            Prilozi koji se podnose uz zahtev:
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            Prilozi: <br />
                            <xsl:for-each select="A-1/podnosioci/podnosilac">

                                <xsl:value-of select = "anoniman/delo_delo_anonimnog_autora"/>
                                
                                <xsl:value-of select = "mrtav/prezime"/> <xsl:value-of select = "mrtav/ime"/> <xsl:value-of select = "mrtav/godina_smrti"/>
                                
                                
                                <xsl:value-of select = "ziv/prezime"/> <xsl:value-of select = "ziv/ime"/> 
                                <xsl:value-of select = "ziv/adresa/grad"/> <xsl:value-of select = "ziv/adresa/naziv_ulice"/> <xsl:value-of select = "ziv/adresa/broj_ulice"/> 
                                <xsl:value-of select = "ziv/drzavljanstvo"/>
                            </xsl:for-each>
                        </td>
                    </tr>
                    
                    
                    <tr>
                        <td colspan="4" text-align="center">ZAVOD ZA INTELEKTUALNU SVOJINU OBRAZAC A-1</td>
                    </tr>
                    
                    <tr>
                        <td colspan="4">
                            Prilozi uz projavu: 
                        </td>
                    </tr>
                    <tr>
                        <td colspan="4">
                            Prilozi: <br />
                            <xsl:for-each select="A-1/podnosioci/podnosilac">
                                
                                <xsl:value-of select = "anoniman/delo_delo_anonimnog_autora"/>
                                
                                <xsl:value-of select = "mrtav/prezime"/> <xsl:value-of select = "mrtav/ime"/> <xsl:value-of select = "mrtav/godina_smrti"/>
                                
                                
                                <xsl:value-of select = "ziv/prezime"/> <xsl:value-of select = "ziv/ime"/> 
                                <xsl:value-of select = "ziv/adresa/grad"/> <xsl:value-of select = "ziv/adresa/naziv_ulice"/> <xsl:value-of select = "ziv/adresa/broj_ulice"/> 
                                <xsl:value-of select = "ziv/drzavljanstvo"/>
                            </xsl:for-each>
                        </td>
                    </tr>
                    
                    
                    <tr>
                        <td colspan="4" text-align="center">- opis autorskog dela (ako je delo podneto na optikom disku</td>
                    </tr>
                    
                    <tr>
                        <td colspan="4" text-align="center">- primer autorskog dela (slika, video zapis, audio zapis);</td>
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
                            A-<xsl:value-of select = "A-1/broj_prijave"/><br /><br />
                            Datum Podnosenja<br />
                            A-<xsl:value-of select = "A-1/datum_podnosenja"/>
                        </td>
                    </tr>
                
                </table>

            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
        
        
      