<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
	google.load("visualization", "1", {
		packages : [ "corechart" ]
	});
	google.setOnLoadCallback(drawChart);
	function drawChart() {
		var data = google.visualization.arrayToDataTable([
				[ 'Presidente', 'Despesa M�xima Declarada' ],
				[ 'Jos� Serra', 180000000 ], [ 'Dilma', 176000000 ],
				[ 'Marina Silva', 90000000 ], [ 'Eymael', 25000000 ],
				[ 'Levy Fidelix', 10000000 ] ]);

		var options = {
			title : 'Despesas M�ximas Declaradas - Presidente - 2010',
			hAxis : {
				title : 'Candidatos'
			}
		};

		var chart = new google.visualization.ColumnChart(document
				.getElementById('chart_div'));
		chart.draw(data, options);
	}
</script>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Campanhas-ON</title>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/banner.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoHome.css" rel="stylesheet" type="text/css"
	media="all">
<link href="css/top5.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
</head>
<body>

	<!--  CABE�ALHO -->
	<%@include file="imports/header_home.jsp"%>
	<!-- FIM CABE�ALHO -->

	<!-- PAGINA CENTRAL, BANNER, INFORMACOES e TOP5 -->
	<!-- PAGINA CENTRAL -->
	<div id="pagina">
		<!-- BANNER -->
		<div id="banner">
			<div id="fundo_banner">
				<div id="imagem_central">
					<!-- Integrar depois anima��o em flash -->
					<ul id="lista">
						<li>
							<div class="imagem_fundo_verde">
								<img src="img/green.png" width="933" height="218"
									alt="fundo_verde">
							</div>

							<div class="conteudo_banner">
								<div class="texto_banner">
									<h2>
										<b> Bem-Vindo ao Campanhas-ON</b>
									</h2>
									<p></p>
									<p>

										<span>O Campanhas-ON � um <i>Web Site</i> desenvolvido
											para VOC�, com o intuito de compartilhar informa��o de
											dif�cil acesso de forma r�pida e usual.

										</span>
									</p>
									<p>
										<span>� aqui onde VOC� poder� verificar a presta��o de contas de campanhas eleitorais 
											dos candidatos do Distrito Federal, incluindo a Presid�ncia da Rep�blica. 
											Com apenas alguns <i>clicks</i> ser� poss�vel acessar um universo de informa��es.&nbsp;
										</span> Para navegar pelas informa��es de <b>CANDIDATOS</b>
										entre no <b>MENU Candidatos</b>. Para acessar informa��es
										acerca dos <b>PARTIDOS</b> de sua prefer�ncia, entre no <b>MENU Partidos</b>.
										
									</p>
								</div>
								<div class="eleicoes_banner">
									<a href="about.jsp"><img src="img/banner.png"
										width="220" height="171" alt="banner" title="Elei��es Limpas"></a>
								</div>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<!-- FIM BANNER -->
		<!-- INFORMACOES -->
		<div id="informativos">
			<br>
			<h3>
				<center>Informa��es</center>
			</h3>
			<div id="box_servicos">
				<!-- BOX 1 -->
				<div id="box_servicos_1">
					<div id="efeito_box1">
						<h1>
							<center>Quem Somos</center>
						</h1>
						<div id="conteudo_box">

							Alunos das disciplinas de M�todos de Desenvolvimento de
							Software e Gest�o de Portif�lios e Projetos de Software do curso
							de Engenharia de Software da Universidade de Bras�lia. O time de
							desenvolvimento � composto por nove pessoas.

						</div>
						<br>
						<div id="saiba_mais_box">
							<a href="about.jsp">Clique aqui para saber mais (+)</a>
						</div>
					</div>
				</div>
				<!-- BOX 2 -->
				<div id="box_servicos_2">
					<div id="efeito_box2">
						<h1>
							<center>O que � o Projeto</center>
						</h1>

						<div id="conteudo_box">Parte do objetivo das disciplinas est� voltado para
							o desenvolvimento de um Software que exibe dados abertos, oferecidos pelo Governo, de maneira intelig�vel.
							O <b>Campanhas-On</b> � fruto da proposta das disciplinas. 
							</div>
						<br>
						<div id="saiba_mais_box">
							<a href="about.jsp">Clique aqui para saber mais (+)</a>
						</div>
					</div>
				</div>
				<!-- BOX 3 -->
				<div id="box_servicos_3">
					<div id="efeito_box3">
						<h1>
							<center>
								Como Utilizar o <i>Web Site</i>
							</center>
						</h1>
						<div id="conteudo_box">Navegue pelo menu no cabe�alho da
							p�gina para acessar informa��es referentes � candidatos e
							partidos. Tais p�ginas ter�o informa��es complementares que
							auxiliar�o no uso do software.
							</div>
						<br>
						<div id="saiba_mais_box">
							<a href="about.jsp">Clique aqui para saber mais (+)</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- FIM INFORMACOES -->

		<!-- TOP5 -->
		<div id="top5">
			<br>
			<h3>
				<center>TOP 5</center>
			</h3>
			<br>
			<center>
				<div id="em_construcao">
					<div id="chart_div" style="width: 505px; height: 285px;"></div>
				</div>
			</center>
		</div>
		<!-- FIM TOP5 -->

	</div>
	<!-- FIM PAGINA CENTRAL -->

	<!-- RODAP� -->
	<%@include file="imports/rodape.jsp"%>
	<!-- FIM RODAP� -->

</body>
</html>