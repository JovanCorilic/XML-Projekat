<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>
                    IZVEŠTAJ
                </title>
                <style>
                    body { font-family: arial;
                    font-size: 15px;
                    }
                    table, tr, td {
                    border: 1px solid black;
                    border-collapse: collapse;
                    vertical-align: text-top;
                    font-family: arial;
                    font-size: 15px;
                    width: 100%;
                    table-layout: fixed;
                    }
                </style>
            </head>
            <body>
                <p style="text-align: center;font-size: 24px;">IZVEŠTAJ</p><br></br>
                <table>
                    <tr>
                        <td>
                            Početni datum : <xsl:value-of select="izvestaj/datum_pocetka"/>
                        </td>
                        <td>
                            Krajnji datum : <xsl:value-of select="izvestaj/datum_kraja"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            Broj podnetih zahteva : <xsl:value-of select="izvestaj/broj_podnetih_prijava"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            Broj prihvaćenih zahteva : <xsl:value-of select="izvestaj/broj_prihvacenih_zahteva"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            Broj odbijenih zahteva : <xsl:value-of select="izvestaj/broj_odbijenih_zahteva"/>
                        </td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>