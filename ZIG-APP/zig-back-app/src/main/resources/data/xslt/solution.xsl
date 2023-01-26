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
				<title>Resenje</title>
			</head>
			<body>
				<div style="width: 100%; display:inline-block;margin-top: 5px;text-align:center">
						<h3>Resenje</h3>
						<br />
						
						<b>RESENJE ID:</b> <br/>
						<xsl:value-of
									select="solution/id" />
						<br/><br/><b>ZIG ID je:</b> <br/>
						<a >
							<xsl:attribute name="href">http://localhost:8888/all/document/html/<xsl:value-of
								select="solution/trademark_id" />
						    </xsl:attribute>
							LINK
						</a>
						<xsl:value-of
									select="solution/trademark_id" />
									
						<br/><br/><b>DATUM:</b> <br/>
						<xsl:value-of
									select="my:getDateFromMilliseconds(solution/date)" />
									
						<br/><br/><b>IME:</b> <br/>
						<xsl:value-of
									select="solution/username" />
						<br/>
						<xsl:if test="solution/description">
							<br/><b>OPIS:</b> <br/>
							<xsl:value-of
								select="solution/description" />
							
						</xsl:if>

						<xsl:if test="solution/trademark_number">
							<br/><b>BROJ ZIGA:</b> <br/>
							<xsl:value-of
								select="solution/trademark_number" />
						</xsl:if>
						
					</div>

			</body>
		</html>


	</xsl:template>
</xsl:stylesheet>