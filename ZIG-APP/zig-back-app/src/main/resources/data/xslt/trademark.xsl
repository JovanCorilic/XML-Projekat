<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet
	xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:my="xalan://com.xml.zig.zigbackapp.qrcode.QRCodeGenerator"
	extension-element-prefixes="my" exclude-result-prefixes="my"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="2.0">



	<xsl:template match="/">


		<!-- sadržaj stranica -->

		<html>
			<head>
				<meta charset="UTF-8" />
				<title>ЖИГ</title>
			</head>
			<body style="background-color:#9da19f;">
				<div
					style="width: 60%; text-align: center;background-color:#ffffff; margin-left: 20%;padding-bottom: 10%;padding-top: 100px;">


					<div
						style="width: 60%;height:920px; text-align: center;background-color:#ffffff; margin-left: 20%;padding-bottom: 10%;">

						<div style="width: 80%; display:inline-block;margin-top: 3%;">
							<h3>ЗАХТЕВ ЗА ПРИЗНАЊЕ ЖИГА</h3>
							<br />
							<p style="margin-top:-4%">Заводу за интелектуалну својину, Кнегиње Љубице 5,
								11000 Београд
							</p>
						</div>

						<div style="width: 80%; display:inline-block;margin-top: 3%;">
							(попунити на рачунару)
						</div>


						<xsl:comment>

							<!-- PODNOSILAC PRIJAVE -->

						</xsl:comment>

						<div
							style="border: 1px solid black;margin-left:-25%;margin-right:-25%">
							<div
								style="margin-left:5px;margin-top: 3%;margin-right:15%;text-align:left;margin-top:0px">
								<b>1. Подносилац пријаве: </b>
								име и презиме/пословно име, улица и број, поштански број, место,
								<br />
								држава пребивалишта/седишта:
							</div>
						</div>

						<div
							style="border: 1px solid black;border-top:0px;margin-left:-25%;margin-right:-25%;height:60px">
							<div
								style="margin-left:5px;margin-top: 3%;margin-right:15%;text-align:left;margin-top:0px">
								<div style="text-align: left;padding-top:10px">


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
									| Улица:
									<xsl:value-of
										select="trademark/applicant/address/street_name" />
									| Број:
									<xsl:value-of
										select="trademark/applicant/address/street_number" />
									| Поштански број:
									<xsl:value-of
										select="trademark/applicant/address/zip_code" />
									| Град:
									<xsl:value-of
										select="trademark/applicant/address/city" />
									| Држава:
									<xsl:value-of
										select="trademark/applicant/address/country" />

								</div>
							</div>
						</div>

						<div
							style="border: 1px solid black;border-top:0px;margin-left:-25%;margin-right:-25%;height:20px">


							<span style="float: left;">
								телефон:
								<xsl:value-of
									select="trademark/applicant/contact/phone" />

							</span>
							|
							<span style="float: center;">
								e-mail:
								<xsl:value-of
									select="trademark/applicant/contact/mail" />

							</span>

							<span style="float: right;margin-right:25%">
								|факс:
								<xsl:value-of
									select="trademark/applicant/contact/faks" />

							</span>



						</div>


						<xsl:comment>

							<!-- PUNOMOCNIK -->

						</xsl:comment>

						<div
							style="border: 1px solid black;border-top:0px;margin-left:-25%;margin-right:-25%">
							<div
								style="margin-left:5px;margin-top: 3%;margin-right:15%;text-align:left;margin-top:0px">
								<b>2. Пуномоћник: </b>
								име и презиме/пословно име, улица и број, поштански број, место,
								<br />
								држава пребивалишта/седишта:
							</div>
						</div>

						<div
							style="border: 1px solid black;border-top:0px;margin-left:-25%;margin-right:-25%;height:60px">
							<div
								style="margin-left:5px;margin-top: 3%;margin-right:15%;text-align:left;margin-top:0px">
								<div style="text-align: left;padding-top:10px">


									<xsl:if test="trademark/proxy/subject/user">
										<xsl:value-of
											select="trademark/proxy/subject/user/first_name" />
										<xsl:text>        </xsl:text>
										<xsl:value-of
											select="trademark/proxy/subject/user/last_name" />

									</xsl:if>

									<xsl:if test="trademark/proxy/subject/company">
										<xsl:value-of
											select="trademark/proxy/subject/company" />
									</xsl:if>

									| Улица:
									<xsl:value-of
										select="trademark/proxy/address/street_name" />
									| Број:
									<xsl:value-of
										select="trademark/proxy/address/street_number" />
									| Поштански број:
									<xsl:value-of
										select="trademark/proxy/address/zip_code" />
									| Град:
									<xsl:value-of
										select="trademark/proxy/address/city" />
									| Држава:
									<xsl:value-of
										select="trademark/proxy/address/country" />
								</div>
							</div>
						</div>


						<div
							style="border: 1px solid black;border-top:0px;margin-left:-25%;margin-right:-25%;height:20px">


							<span style="float: left;">
								телефон:
								<xsl:value-of
									select="trademark/proxy/contact/phone" />

							</span>
							|
							<span style="float: center;">
								e-mail:
								<xsl:value-of select="trademark/proxy/contact/mail" />

							</span>

							<span style="float: right;margin-right:25%">
								|факс:
								<xsl:value-of select="trademark/proxy/contact/faks" />

							</span>



						</div>


						<xsl:comment>

							<!-- ZAJEDNICKI PREDSTAVNIK -->

						</xsl:comment>

						<div
							style="border: 1px solid black;border-top:0px;margin-left:-25%;margin-right:-25%">
							<div
								style="margin-left:5px;margin-top: 3%;margin-right:15%;text-align:left;margin-top:0px">
								<b>
									3. Подаци о заједничком представнику ако постоји више
									подносилаца пријаве:
								</b>

							</div>
						</div>

						<div
							style="border: 1px solid black;border-top:0px;margin-left:-25%;margin-right:-25%;height:60px">
							<div
								style="margin-left:5px;margin-top: 3%;margin-right:15%;text-align:left;margin-top:0px">
								<div style="text-align: left;padding-top:10px">


									<xsl:if
										test="trademark/common_representative/subject/user">
										<xsl:value-of
											select="trademark/common_representative/subject/user/first_name" />
										<xsl:text>        </xsl:text>
										<xsl:value-of
											select="trademark/common_representative/subject/user/last_name" />

									</xsl:if>

									<xsl:if
										test="trademark/common_representative/subject/company">
										<xsl:value-of
											select="trademark/common_representative/subject/company" />
									</xsl:if>

									| Улица:
									<xsl:value-of
										select="trademark/common_representative/address/street_name" />
									| Број:
									<xsl:value-of
										select="trademark/common_representative/address/street_number" />
									| Поштански број:
									<xsl:value-of
										select="trademark/common_representative/address/zip_code" />
									| Град:
									<xsl:value-of
										select="trademark/common_representative/address/city" />
									| Држава:
									<xsl:value-of
										select="trademark/common_representative/address/country" />

								</div>
							</div>
						</div>

						<div
							style="border: 1px solid black;border-top:0px;margin-left:-25%;margin-right:-25%;height:20px">


							<span style="float: left;">
								телефон:
								<xsl:value-of
									select="trademark/common_representative/contact/phone" />

							</span>
							|
							<span style="float: center;">
								e-mail:
								<xsl:value-of
									select="trademark/common_representative/contact/mail" />

							</span>

							<span style="float: right;margin-right:25%">
								|факс:
								<xsl:value-of
									select="trademark/common_representative/contact/faks" />

							</span>



						</div>

						<div
							style="border:1px solid black;margin-left:-25%;margin-right:-25%;height:350px;border-top:0px;">

							<div style="float: left; width: 50%;">

								<div style="height:20px;">
									<span style="float: left;">

										<b style="text-align:right;margin: auto;">
											4. Пријава се подноси за (уписати X):

										</b>
									</span>


								</div>
								<div>

									<div style="float: left; width: 33.333%">
										<div
											style=";padding-top:20px;padding-bottom:20px;border:1px solid black;border-left:0px;">
											a)
										</div>

									</div>

									<div style="float: left;width: 33.333%;">



										<div
											style="display:inline-block;border:1px solid black;padding-bottom:3.5px;border-left:0px;">

											<div>индивидуални жиг</div>
											<div>колективни жиг</div>
											<div>жиг гаранције</div>

										</div>
									</div>

									<div style="float: left; width: 33.333%;height:60px;">

										<div style="border:1px solid black;">

											<xsl:choose>
												<xsl:when
													test="trademark/trademark_info/trademark_type='IndividualTrademark'">
													<div
														style="margin-top:0px;border-bottom:1px solid black;">X</div>
												</xsl:when>
												<xsl:otherwise>


													<div
														style="margin-top:0px;border-bottom:1px solid black;">
														<p></p>
													</div>


												</xsl:otherwise>
											</xsl:choose>


											<xsl:choose>
												<xsl:when
													test="trademark/trademark_info/trademark_type='CollectiveTrademark'">
													<div
														style="margin-top:0px;border-bottom:1px solid black;border-top:1px solid black;">X</div>
												</xsl:when>
												<xsl:otherwise>


													<div
														style="margin-top:0px;border-bottom:1px solid black;border-top:1px solid black;">
														<p></p>
													</div>


												</xsl:otherwise>
											</xsl:choose>




											<xsl:choose>
												<xsl:when
													test="trademark/trademark_info/trademark_type='GuaranteeTrademark'">
													<div style="margin-top:0px;border-top:1px solid black;">X</div>
												</xsl:when>
												<xsl:otherwise>

													<div style="margin-top:0px;border-top:1px solid black;">
														<p></p>
													</div>

												</xsl:otherwise>
											</xsl:choose>

										</div>





									</div>

								</div>
								<div style="flaot:left;margin-left:-1px">

									<div style="float: left; width: 33.333%">
										<div
											style="padding-top:38px;padding-bottom:38px;border:1px solid black;border-left:0px;">
											б)
										</div>

									</div>

									<div style="float: left;width: 33.333%;">



										<div
											style="display:inline-block;border:1px solid black;padding-bottom:3.5px;border-left:0px;">

											<div>вербални знак</div>
											<div>графички знак</div>
											<div>комбиновани знак</div>
											<div>тродименз. знак</div>
											<div>другу врсту знака</div>

										</div>
									</div>

									<div style="float: left; width: 33.333%;height:60px;">

										<div style="border:1px solid black;">


											<xsl:choose>
												<xsl:when
													test="trademark/trademark_info/trademark_appearance='VerbalTrademark'">
													<div
														style="margin-top:0px;border-bottom:1px solid black;border-top:1px solid black;">X</div>
												</xsl:when>
												<xsl:otherwise>


													<div
														style="margin-top:0px;border-bottom:1px solid black;border-top:1px solid black;">
														<p></p>
													</div>


												</xsl:otherwise>
											</xsl:choose>

											<xsl:choose>
												<xsl:when
													test="trademark/trademark_info/trademark_appearance='GraphicTrademark'">
													<div
														style="margin-top:0px;border-bottom:1px solid black;border-top:1px solid black;">X</div>
												</xsl:when>
												<xsl:otherwise>


													<div
														style="margin-top:0px;border-bottom:1px solid black;border-top:1px solid black;">
														<p></p>
													</div>


												</xsl:otherwise>
											</xsl:choose>

											<xsl:choose>
												<xsl:when
													test="trademark/trademark_info/trademark_appearance='CombinedTrademark'">
													<div
														style="margin-top:0px;border-bottom:1px solid black;border-top:1px solid black;">X</div>
												</xsl:when>
												<xsl:otherwise>


													<div
														style="margin-top:0px;border-bottom:1px solid black;border-top:1px solid black;">
														<p></p>
													</div>


												</xsl:otherwise>
											</xsl:choose>

											<xsl:choose>
												<xsl:when
													test="trademark/trademark_info/trademark_appearance='ThreeDimensionalTrademark'">
													<div
														style="margin-top:0px;border-bottom:1px solid black;">X</div>
												</xsl:when>
												<xsl:otherwise>


													<div
														style="margin-top:0px;border-bottom:1px solid black;">
														<p></p>
													</div>


												</xsl:otherwise>
											</xsl:choose>







											<xsl:choose>
												<xsl:when
													test="trademark/trademark_info/trademark_appearance='AnotherTrademark'">
													<div
														style="margin-top:0px;border-bottom:1px solid black;border-top:1px solid black;">X</div>
												</xsl:when>
												<xsl:otherwise>


													<div
														style="margin-top:0px;border-bottom:1px solid black;border-top:1px solid black;">
														<p></p>
													</div>


												</xsl:otherwise>
											</xsl:choose>

										</div>





									</div>



								</div>
								<div style="position:absolute;margin-top:160px;">
									<b>
										5. Назначење боје, односно боја из којих се знак
										састоји:
										<br />
										<ul style="gap: 0;list-style-type: none;margin-top:0px;">
											<xsl:for-each
												select="trademark/trademark_info/trademark_colors/trademark_color">


												<li>
													<xsl:value-of select="text()" />
												</li>







											</xsl:for-each>
										</ul>
									</b>
								</div>
								<div style="position:absolute;margin-top:220px;">

									<b>

										6. Транслитерација знака*:
										<xsl:value-of
											select="trademark/trademark_info/trademark_transliteration" />
									</b>

								</div>
								<div style="position:absolute;margin-top:260px;">

									<b>

										7. Превод знака*:
										<xsl:value-of
											select="trademark/trademark_info/trademark_translation" />

									</b>

								</div>
								<div style="position:absolute;margin-top:300px;">


									<b>

										8. Опис знака:
										<xsl:value-of
											select="trademark/trademark_info/trademark_description" />

									</b>

								</div>

							</div>

							<div style="float: left; width: 50%;">

								<div
									style="text-align: left;height:35px;padding-top:10px;border: 1px solid black;border-top:0px;border-right:0px;">

									<b style="padding-left:10px;padding-bottom:0px;">в) изглед знака:</b>

								</div>
								<div>

									<div
										style="height:283px;padding-top:10px;border-left: 1px solid black;">

										<img
											style="height:270px;width:350px;border:1px solid black;">
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
						</div>



						<div
							style="border:1px solid black;margin-left:-25%;margin-right:-25%;">

							<b style="margin-left:-30%">
								9. Заокружити бројеве класа робе и услуга према
								Ничанској класификацији :
							</b>

						</div>

						<div
							style="border:1px solid black;margin-left:-25%;margin-right:-25%;height:60px">
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


						<div
							style="border:1px solid black;margin-left:-25%;margin-right:-25%;height:20px">
							<span style="float: left;">

								<b style="text-align:right;margin: auto;">
									10. Затражено право првенства и основ:
									<xsl:value-of
										select="trademark/requested_right_of_priority_and_basis" />

								</b>
							</span>
						</div>





						<div
							style="margin-left:-100px;width: 130%; display:inline-block;margin-top: 3%;">
							*Попунити само ако је знак или елемент знака исписан
							словима која нису ћирилична или латинична

						</div>

					</div>

					<div style="height:10px;background-color:#9da19f;">
						<p></p>
					</div>

					<div
						style="width: 70%;height:850px; text-align: center;background-color:#ffffff; margin-left: 20%;padding-bottom: 10%;">

						<div style="margin-left:-100px">

							<div
								style="float: left; width: 50%;border:1px solid black;margin-top:50px">

								<div style="border:1px solid black;">
									<b>11. Плаћене таксе: </b>
								</div>
								<div style="border:1px solid black;">
									<b>а) основна такса </b>
								</div>
								<div style="border:1px solid black;">
									<p>
										<b>
											б) за
											<xsl:value-of select="trademark/fee/nice_class" />
											класу
										</b>
									</p>
									<p>
										<b>в) за графичко решење </b>
									</p>

								</div>
								<div style="border:1px solid black;">
									<b>УКУПНО </b>
								</div>


							</div>

							<div
								style="float: right; width: 50%;border:1px solid black;margin-top:-150px;border-left:0px;">

								<div style="border:1px solid black;">
									<b>Динара</b>
								</div>

								<div style="border:1px solid black;">
									<xsl:value-of select="trademark/fee/basic" />
								</div>

								<div
									style="height:45px;padding-top:39px;border:1px solid black;">
									<xsl:value-of select="trademark/fee/nice_class" />
									+
									<xsl:value-of
										select="trademark/fee/graphical_solution" />
								</div>

								<div style="border:1px solid black;">
									<xsl:value-of
										select="sum((trademark/fee/basic | trademark/fee/nice_class | trademark/fee/graphical_solution)[number(.) = .])" />
								</div>

							</div>

						</div>

						<div
							style="width: 80%; display:inline-block;margin-top: 3%;margin-left:-100px">

							ПОПУЊАВА ЗАВОД

						</div>


						<div style="margin-left:-10px;margin-top: 3%">

							<div style="float: left; width: 50%;">

								<div>
									<b>Прилози уз захтев:</b>
								</div>

								<div>
									<div style="float: left; width: 80%;">
										<div style="border:1px solid black">Примерак знака</div>
										<div style="border:1px solid black">Списак робе и услуга**</div>
										<div style="border:1px solid black">Пуномоћје</div>
										<div style="border:1px solid black">Генерално пуномоћје </div>
										<div style="border:1px solid black">Пуномоћје  накнадно достављено </div>
										<div style="border:1px solid black">Општи акт о колек. жигу</div>
										<div style="border:1px solid black">Доказ о праву првенства</div>
										<div style="border:1px solid black">Доказ о уплати таксе</div>
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
									style="border:1px solid black;height:161px;margin-top:-21px">

									<p>Број пријаве жига:</p>
									<p>
										Ж-
										<xsl:value-of select="trademark/trademark_number" />
									</p>
									<p>Датум подношења:</p>
									<p>





										<xsl:value-of select="trademark/date" />
									</p>


								</div>

							</div>

						</div>

						<p
							style="text-align: justify;margin-top:350px;margin-left:-10px">

							**Уз заокруживање броја класе робе/услуга Ничанске
							класификације у
							рубрици 9 доставља се и списак који
							садржи
							конкретне називе робе коју
							подносилац пријаве производи, односно
							услуга које пружа. У циљу
							одређења обима заштите која се стиче
							жигом, списак треба да
							садржи јасне
							и прецизне називе робе и
							услуга. У ту сврху могу се
							користити појмови из детаљне Листе роба
							и
							услуга или MGS Manager
							апликације,
							доступних на сајту Завода.
							Уколико се у списак уносе
							термини из Листе
							класа Ничанске
							класификације,
							заштита обухвата
							само тако именоване, конкретне
							робе/услуге у њиховом
							јасном и
							недвосмисленом
							значењу

						</p>

					</div>
					QR CODE:
					<div
						style="height:283px;padding-top:10px;">

						<img style="height:270px;width:350px;border:1px solid black;">
							<!-- trademark/trademark_info/trademark_view -->
							<!-- 'haha tekst mnkkn' -->
							<xsl:attribute name="src">
										        <xsl:value-of
								select="my:getQRCodeAsByteArray(trademark/trademark_id)" />
										    </xsl:attribute>

						</img>


					</div>


				</div>


			</body>
		</html>


	</xsl:template>
</xsl:stylesheet>