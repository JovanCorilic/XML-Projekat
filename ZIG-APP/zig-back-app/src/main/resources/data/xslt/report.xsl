<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet
	xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:my="xalan://com.xml.zig.zigbackapp.date.MyDateConverter"
	extension-element-prefixes="my" exclude-result-prefixes="my"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">



	<xsl:template match="/">


		<!-- sadržaj stranica -->

		<html>
			<head>
				<meta charset="UTF-8" />
				<title>Izvestaj</title>
			</head>
			<body>
				<div style="width: 100%; display:inline-block;margin-top: 5px;text-align:center">
						<h3>Izvestaj</h3>
						<br />
						
						<b>Datum Start:</b> <br/>
						<xsl:value-of
									select="my:getDateFromMilliseconds(report/startdate)" />
						<br/><br/><b>Datum Kraj:</b> <br/>
						<xsl:value-of
									select="my:getDateFromMilliseconds(report/enddate)" />
									
						<br/><br/><b>PRIHVACENI:</b> <br/>
						<xsl:value-of
									select="report/accept" />
									
						<br/><br/><b>ODBIJENI:</b> <br/>
						<xsl:value-of
									select="report/decline" />
									
						<br/><br/><b>NA CEKANJU:</b> <br/>
						<xsl:value-of
									select="report/wait" />
						
					</div>

			</body>
		</html>


	</xsl:template>
</xsl:stylesheet>