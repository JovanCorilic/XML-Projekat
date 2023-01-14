<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet
	xmlns:my="xalan://com.xml.zig.zigbackapp.qrcode.QRCodeGenerator"
	extension-element-prefixes="my" exclude-result-prefixes="my"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">



	<xsl:template match="/">
		<html>

			<head>
				<meta http-equiv='Content-Type'
					content='text/html; charset=UTF-8' />
				
				<title>ЖИГ</title>
			</head>

			<body>


				<div
					style="height:80px; text-align: center;padding-bottom: 10%;">

					<div style="width: 80%; display:inline-block;margin-top: 5px;">
						<h3>ZAHTEV ZA PRIZNAVANJE Динара ZIGA</h3>
						<br />
						<p style="margin-top: 5px">ZAVOD ZA INTELEKTUALNU SVOJINU , KNJEGINJE MILICE 5,
							11000 BEOGRAD
						</p>
					</div>

					<div style="width: 80%; display:inline-block;margin-top: 5px;">
						(POPUNITI NA RACUNARU)
					</div>



				</div>

				<div style="border: 1px solid black;margin-top:100px">
					<div>
						<b>1. Podnosilac prijave: </b>
						ime i prezime/poslovno ime, ulica i broj, postanski broj, mesto,
						<br />
						drzava prebivalista/sedista:
					</div>
				</div>


				<div style="border: 1px solid black;height:60px">
					<div>
						<div style="text-align: left;padding-top:10px">

							Ime:
							<xsl:if test="trademark/applicant/subject/user">
								<xsl:value-of
									select="trademark/applicant/subject/user/first_name" />
								<xsl:text>        </xsl:text>
								<xsl:value-of
									select="trademark/applicant/subject/user/last_name" />

							</xsl:if>

							<xsl:if test="trademark/applicant/subject/company">
								<xsl:value-of
									select="trademark/applicant/subject/company" />
							</xsl:if>
							| Ulica:
							<xsl:value-of
								select="trademark/applicant/address/street_name" />
							| Broj:
							<xsl:value-of
								select="trademark/applicant/address/street_number" />
							| Postanski broj:
							<xsl:value-of
								select="trademark/applicant/address/zip_code" />
							| Grad:
							<xsl:value-of
								select="trademark/applicant/address/city" />
							| Drzava:
							<xsl:value-of
								select="trademark/applicant/address/country" />

						</div>
					</div>
				</div>
				<div style="border: 1px solid black;border-top:0px;height:20px">


					<span style="float: left;">
						telefon:
						<xsl:value-of
							select="trademark/applicant/contact/phone" />

					</span>
					|
					<span style="float: center;margin-left:20%">
						e-mail:
						<xsl:value-of
							select="trademark/applicant/contact/mail" />

					</span>

					<span style="float: right">
						|faks:
						<xsl:value-of
							select="trademark/applicant/contact/faks" />

					</span>



				</div>


				<div style="border: 1px solid black;margin-top:0px">
					<div>
						<b>2. Punomocnik: </b>
						ime i prezime/poslovno ime, ulica i broj, postanski broj, mesto,
						<br />
						drzava prebivalista/sedista:
					</div>
				</div>


				<div style="border: 1px solid black;height:60px">
					<div>
						<div style="text-align: left;padding-top:10px">

							Ime:
							<xsl:if test="trademark/applicant/subject/user">
								<xsl:value-of
									select="trademark/applicant/subject/user/first_name" />
								<xsl:text>        </xsl:text>
								<xsl:value-of
									select="trademark/applicant/subject/user/last_name" />

							</xsl:if>

							<xsl:if test="trademark/applicant/subject/company">
								<xsl:value-of
									select="trademark/applicant/subject/company" />
							</xsl:if>
							| Ulica:
							<xsl:value-of
								select="trademark/applicant/address/street_name" />
							| Broj:
							<xsl:value-of
								select="trademark/applicant/address/street_number" />
							| Postanski broj:
							<xsl:value-of
								select="trademark/applicant/address/zip_code" />
							| Grad:
							<xsl:value-of
								select="trademark/applicant/address/city" />
							| Drzava:
							<xsl:value-of
								select="trademark/applicant/address/country" />

						</div>
					</div>
				</div>

				<div style="border: 1px solid black;border-top:0px;height:20px">


					<span style="float: left;">
						telefon:
						<xsl:value-of
							select="trademark/applicant/contact/phone" />

					</span>
					|
					<span style="float: center;margin-left:20%">
						e-mail:
						<xsl:value-of
							select="trademark/applicant/contact/mail" />

					</span>

					<span style="float: right">
						|faks:
						<xsl:value-of
							select="trademark/applicant/contact/faks" />

					</span>



				</div>

				<div style="border: 1px solid black;margin-top:0px">
					<div>
						<b>3. Podaci o zajednickom predstavniku ako postoji vise
							podnosilaca prijave:
						</b>
						ime i prezime/poslovno ime, ulica i broj, postanski broj, mesto,

						drzava prebivalista/sedista:
					</div>
				</div>


				<div style="border: 1px solid black;height:60px">
					<div>
						<div style="text-align: left;padding-top:10px">

							Ime:
							<xsl:if test="trademark/applicant/subject/user">
								<xsl:value-of
									select="trademark/applicant/subject/user/first_name" />
								<xsl:text>        </xsl:text>
								<xsl:value-of
									select="trademark/applicant/subject/user/last_name" />

							</xsl:if>

							<xsl:if test="trademark/applicant/subject/company">
								<xsl:value-of
									select="trademark/applicant/subject/company" />
							</xsl:if>
							| Ulica:
							<xsl:value-of
								select="trademark/applicant/address/street_name" />
							| Broj:
							<xsl:value-of
								select="trademark/applicant/address/street_number" />
							| Postanski broj:
							<xsl:value-of
								select="trademark/applicant/address/zip_code" />
							| Grad:
							<xsl:value-of
								select="trademark/applicant/address/city" />
							| Drzava:
							<xsl:value-of
								select="trademark/applicant/address/country" />

						</div>
					</div>
				</div>

				<div style="border: 1px solid black;border-top:0px;height:20px">


					<span style="float: left;">
						telefon:
						<xsl:value-of
							select="trademark/applicant/contact/phone" />

					</span>
					|
					<span style="float: center;margin-left:20%">
						e-mail:
						<xsl:value-of
							select="trademark/applicant/contact/mail" />

					</span>

					<span style="float: right">
						|faks:
						<xsl:value-of
							select="trademark/applicant/contact/faks" />

					</span>



				</div>

				<div style="float: left ; width: 50%;border:1px solid black">

					<div style="height:20px;">
						<span style="float: left;">

							<b style="text-align:right;margin: auto;">
								4. Prijava se podnosi za (upisati X):

							</b>
						</span>


					</div>

					<!-- A) -->

					<div style="float: left; width: 33.333%">
						<div
							style="padding-top:20px;padding-bottom:20px;border:1px solid black;border-left:0px;">
							a)
						</div>

					</div>

					<div style="float: left;width: 33.333%;">



						<div
							style="border:1px solid black;padding-bottom:3.5px;border-left:0px;">

							<div>Individualniи zig</div>
							<div>Kolektivni zig</div>
							<div>Zig garancije</div>

						</div>
					</div>

					<div style="float: left; width: 33%;height:60px;">

						<div style="border:1px solid black;">

							<xsl:choose>
								<xsl:when
									test="trademark/trademark_info/trademark_type='IndividualTrademark'">
									<div
										style="margin-top:0px;border-bottom:1px solid black;height:15px">X</div>
								</xsl:when>
								<xsl:when
									test="trademark/trademark_info/trademark_type='CollectiveTrademark'">
									<div
										style="margin-top:0px;border-bottom:1px solid black;border-top:1px solid black;height:15px;margin-top:20px">X</div>
								</xsl:when>
								<xsl:when
									test="trademark/trademark_info/trademark_type='GuaranteeTrademark'">
									<div
										style="margin-top:0px;border-top:1px solid black;height:15px;margin-top:40px">X</div>
								</xsl:when>
							</xsl:choose>




						</div>

					</div>


					<!-- B) -->
					<div style="float: left; width: 33.333%;">
						<div
							style="padding-top:40px;padding-bottom:20px;border-left:0px;">
							b)
						</div>

					</div>

					<div style="float: left;width: 33.333%;">



						<div style="border:1px solid black;padding-bottom:3.5px;">

							<div>Verbalni znak</div>
							<div>Graficki znak</div>
							<div>kombinovani zn.</div>
							<div>trodimenz. znak</div>
							<div>drugi znak</div>
						</div>
					</div>

					<div style="float: left; width: 33%;height:60px;">

						<div style="border:1px solid black;">

							<xsl:choose>
								<xsl:when
									test="trademark/trademark_info/trademark_appearance='VerbalTrademark'">
									<div
										style="margin-top:0px;border-bottom:1px solid black;height:15px">X</div>
								</xsl:when>
								<xsl:when
									test="trademark/trademark_info/trademark_appearance='GraphicTrademark'">
									<div
										style="margin-top:0px;border-bottom:1px solid black;border-top:1px solid black;height:15px;margin-top:20px">X</div>
								</xsl:when>
								<xsl:when
									test="trademark/trademark_info/trademark_appearance='CombinedTrademark'">
									<div
										style="margin-top:0px;border-top:1px solid black;height:15px;margin-top:40px">X</div>
								</xsl:when>
								<xsl:when
									test="trademark/trademark_info/trademark_appearance='ThreeDimensionalTrademark'">
									<div
										style="margin-top:0px;border-top:1px solid black;height:15px;margin-top:60px">X</div>
								</xsl:when>

								<xsl:when
									test="trademark/trademark_info/trademark_appearance='AnotherTrademark'">
									<div
										style="margin-top:0px;border-top:1px solid black;height:15px;margin-top:80px">X</div>
								</xsl:when>

							</xsl:choose>




						</div>

					</div>

					<div style="position:absolute;margin-top:160px;">
						<b>
							5. Naznacenje boja, odnosno boja iz kojih se znak sastoji:
							<br />
							<ul style="gap: 0;list-style-type: none;margin-top:0px;">
								<xsl:for-each
									select="trademark/trademark_info/trademark_colors/trademark_color">


									<li style="display: inline;">
										<xsl:value-of select="text()" />
										-
									</li>







								</xsl:for-each>
							</ul>
						</b>
					</div>
					<div style="position:absolute;margin-top:220px;">

						<b>

							6. Transliteracija znaka*:
							<xsl:value-of
								select="trademark/trademark_info/trademark_transliteration" />
						</b>

					</div>
					<div style="position:absolute;margin-top:260px;">

						<b>

							7. Prevod znaka*:
							<xsl:value-of
								select="trademark/trademark_info/trademark_translation" />

						</b>

					</div>
					<div style="position:absolute;margin-top:300px;">


						<b>

							8. Opis znaka:
							<xsl:value-of
								select="trademark/trademark_info/trademark_description" />

						</b>

					</div>

				</div>

				<div style="float: right width: 50%;">

					<div style="text-align: left;height:35px;padding-top:10px;">

						<b style="padding-left:10px;padding-bottom:0px;">v) izgled znaka:</b>

					</div>

					<div>

						<div style="height:283px;padding-top:10px;">

							<img style="height:270px;width:350px;border:1px solid black;">
								<!-- trademark/trademark_info/trademark_view -->
								<!-- 'haha tekst mnkkn' -->
								<xsl:attribute name="src">
										        <xsl:value-of
									select="trademark/trademark_info/trademark_view" />

										    </xsl:attribute>

							</img>


						</div>

					</div>

				</div>

				<div style="margin-left:-7px">

					<b>
						9. Zaokruzite brojeve klasa robe i usluga prema nicanskoj
						klasifikaciji :
					</b>

				</div>

				<div style="height:60px">
					<span style="float: left;">
						<div style="display:inline-block">

							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='1'">
									<xsl:text>1X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>1</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='2'">
									<xsl:text>2X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>2</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='3'">
									<xsl:text>3X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>3</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='4'">
									<xsl:text>4X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>4</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='5'">
									<xsl:text>5X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>5</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='6'">
									<xsl:text>6X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>6</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='7'">
									<xsl:text>7X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>7</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='8'">
									<xsl:text>8X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>8</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='9'">
									<xsl:text>9X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>9</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='10'">
									<xsl:text>10X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>10</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='11'">
									<xsl:text>11X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>11</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='12'">
									<xsl:text>12X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>12</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='13'">
									<xsl:text>13X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>13</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='14'">
									<xsl:text>14X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>14</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='15'">
									<xsl:text>15X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>15</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='16'">
									<xsl:text>16X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>16</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='17'">
									<xsl:text>17X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>17</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='18'">
									<xsl:text>18X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>18</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='19'">
									<xsl:text>19X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>19</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='20'">
									<xsl:text>20X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>20</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='21'">
									<xsl:text>21X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>21</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='22'">
									<xsl:text>22X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>22</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							|&#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='23'">
									<xsl:text>23X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>23</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='24'">
									<xsl:text>24X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>24</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='25'">
									<xsl:text>25X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>25</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='26'">
									<xsl:text>26X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>26</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='27'">
									<xsl:text>27X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>27</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='28'">
									<xsl:text>28X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>28</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='29'">
									<xsl:text>29X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>29</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='30'">
									<xsl:text>30X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>30</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='31'">
									<xsl:text>31X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>31</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='32'">
									<xsl:text>32X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>32</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='33'">
									<xsl:text>33X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>33</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;
							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='34'">
									<xsl:text>34X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>34</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;

							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='35'">
									<xsl:text>35X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>35</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;

							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='36'">
									<xsl:text>36X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>36</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;

							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='37'">
									<xsl:text>37X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>37</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;

							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='38'">
									<xsl:text>38X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>38</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;

							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='39'">
									<xsl:text>39X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>39</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;

							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='40'">
									<xsl:text>40X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>40</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;

							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='41'">
									<xsl:text>41X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>41</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;

							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='42'">
									<xsl:text>42X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>42</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;

							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='43'">
									<xsl:text>43X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>43</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;

							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='44'">
									<xsl:text>44X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>44</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;

							<xsl:choose>
								<xsl:when test="trademark/fee/nice_class='45'">
									<xsl:text>45X</xsl:text>
								</xsl:when>
								<xsl:otherwise>
									<xsl:text>45</xsl:text>
								</xsl:otherwise>
							</xsl:choose>
							| &#x3000;

						</div>
					</span>


				</div>

				<div style="margin-left:-7px">

					<b>
						9. Zatrazeno prava prvenstva i osnov :
					</b>
					<xsl:value-of
						select="trademark/requested_right_of_priority_and_basis" />
				</div>

				<div style="width: 130%; display:inline-block;margin-top: 3%;">
					*Popuniti samo ako je znak ili elemenat znaka ispisan
					slovima koja nisu
					cirilicna

				</div>


				<div
					style="width: 70%;height:200px; text-align: center;background-color:#ffffff; margin-left: 20%;padding-bottom: 10%;">

					<div style="margin-left:-100px">

						<div
							style="float: left; width: 50%;border:1px solid black;margin-top:50px">

							<div style="border:1px solid black;"><b>11. Placene takse: </b></div>
							<div style="border:1px solid black;"><b>a) osnovna taksa  </b></div>
							<div style="border:1px solid black;">
								<p>
									<b>b) za
									<xsl:value-of select="trademark/fee/nice_class" />
									klasu</b>
								</p>
								<p><b>c) za graficko resenje </b></p>

							</div>
							<div style="border:1px solid black;"><b>UKUPNO </b></div>


						</div>

						<div
							style="float: right; width: 50%;border:1px solid black;margin-top:-156px;border-left:0px;">

							<div style="border:1px solid black;"><b>Dinara</b></div>

							<div style="border:1px solid black;">
								<xsl:value-of select="trademark/fee/basic" />
							</div>

							<div
								style="height:53px;padding-top:38px;border:1px solid black;">
								<xsl:value-of select="trademark/fee/nice_class" />
								+
								<xsl:value-of
									select="trademark/fee/graphical_solution" />
							</div>

							<div >
								<xsl:value-of
									select="sum((trademark/fee/basic | trademark/fee/nice_class | trademark/fee/graphical_solution)[number(.) = .])" />
							</div>

						</div>

					</div>

				</div>


				<div
					style="width: 80%; display:inline-block;margin-top: 3%;text-align:center;margin-left:70px">

					Popunjava Zavod

				</div>


				<div style="margin-top: 3%">

					<div style="float: left; width: 50%;">

						<div>
							<b>Prilozi uz zahtev:</b>
						</div>

						<div>
							<div style="float: left; width: 80%;">
								<div style="border:1px solid black">Primerak znaka</div>
								<div style="border:1px solid black">Spisak robe i usluga**</div>
								<div style="border:1px solid black">Punomocje</div>
								<div style="border:1px solid black">Generalno punomocje ranije prilozeno</div>
								<div style="border:1px solid black">Punomocje ce biti ranije dostavljeno </div>
								<div style="border:1px solid black">Opsti akt o kolek. zigu/zigu garancije</div>
								<div style="border:1px solid black">Dokaz o pravu prvenstva</div>
								<div style="border:1px solid black">Dokaz o uplati takse</div>
							</div>
							<div style="float: right; width: 20%;">

								<div style="border:1px solid black">
									<xsl:value-of
										select="trademark/institution/trademark_sample" />
								</div>
								<div style="border:1px solid black">
									<xsl:value-of
										select="trademark/institution/list_of_goods_and_services" />
								</div>
								<div style="border:1px solid black">
									<xsl:value-of
										select="trademark/institution/power_of_attorney" />
								</div>
								<div style="border:1px solid black">
									<xsl:value-of
										select="trademark/institution/general_power_of_attorney_previously_submitted" />
								</div>
								<div style="border:1px solid black">
									<xsl:value-of
										select="trademark/institution/power_of_attorney_will_be_delivered_later" />
								</div>
								<div style="border:1px solid black">
									<xsl:value-of
										select="trademark/institution/general_act" />
								</div>
								<div style="border:1px solid black">
									<xsl:value-of
										select="trademark/institution/proof_of_priority" />
								</div>
								<div style="border:1px solid black">
									<xsl:value-of
										select="trademark/institution/proof_of_fee_payment" />
								</div>
							</div>


						</div>

					</div>

					<div style="float: left; width: 50%;padding-top:40px">

						<div
							style="border:1px solid black;height:158px;margin-top:-22px;text-align:center">

							<p>Broj prijave ziga:</p>
							<p>
								Z-
								<xsl:value-of select="trademark/trademark_number" />
							</p>
							<p>Datum podnosenja:</p>
							<p>





								<xsl:value-of select="trademark/date" />
							</p>


						</div>

					</div>

				</div>
				<div>
					<p style="text-align: justify;margin-top:350px;">

						**Uz zaokruživanje broja klase robe/usluga Ničanske
						klasifikacije u
						rubrici 9 dostavlja se i spisak koji
						sadrži
						konkretne nazive robe koju
						podnosilac prijave proizvodi, odnosno
						usluga koje pruža. U cilju
						određenja obima zaštite koja se stiče
						žigom, spisak treba da
						sadrži jasne
						i precizne nazive robe i
						usluga. U tu svrhu mogu se
						koristiti pojmovi iz detaljne Liste roba
						i
						usluga ili MGS Manager
						aplikacije,
						dostupnih na sajtu Zavoda.
						Ukoliko se u spisak unose
						termini iz Liste
						klasa Ničanske
						klasifikacije,
						zaštita obuhvata
						samo tako imenovane, konkretne
						robe/usluge u njihovom
						jasnom i
						nedvosmislenom
						značenju

					</p>

				</div>
				<p style="text-align:center;margin-top:100px">QR CODE:</p>

				<div style="height:283px;padding-top:10px;text-align:center">

					<img style="height:270px;width:350px;border:1px solid black;">
						<!-- trademark/trademark_info/trademark_view -->
						<!-- 'haha tekst mnkkn' -->
						<xsl:attribute name="src">
										        <xsl:value-of
							select="my:getQRCodeAsByteArray(trademark/trademark_id)" />
										    </xsl:attribute>

					</img>


				</div>

				<!-- <img style="height:270px;width:350px;border:1px solid black;"> <xsl:attribute 
					name="src"> <xsl:value-of select="my:getQRCodeAsByteArray(trademark/trademark_id)" 
					/> </xsl:attribute> </img> -->


			</body>

		</html>



	</xsl:template>
</xsl:stylesheet>


