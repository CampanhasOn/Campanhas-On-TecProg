<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Campanhas-ON</title>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/banner.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoHome.css" rel="stylesheet" type="text/css" media="all">
<link href="css/top5.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
</head>
<body>

	<!--  CABE�ALHO -->
	<%@include file="imports/cabecalhohome.jsp"%>
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
										<b>Campanhas-ON</b>
									</h2>
									<p></p>
									<p>
										<span>O Campanhas-ON � um <i>Web Site</i> desenvolvido
											para VOC�, com o intuito de compartilhar informa��o de
											dificil acesso de forma r�pida e usual.
										</span>
									</p>
									<p>
										<span>� aqui onde VOC� poder� verificar as receitas e
											despesas de partidos e candidatos. Com apenas alguns <i>clicks</i>
											ser� poss�vel acessar a um universo de informa��o.&nbsp;
										</span> Para navegar pelas informa��es de seus <b>CANDIDATOS</b>
										entre no <b>MENU</b> Candidatos ou para acessar informa��es
										acerca dos <b>PARTIDOS</b> de sua prefer�ncia entre no <b>MENU</b>
										Partidos.
									</p>
									<p class="mais_banner">
										<a href="informacoes.jsp">Clique aqui para obter mais
											informa��es</a>
									</p>
								</div>
								<div class="eleicoes_banner">
									<a href="informacoes.jsp"><img src="img/banner.png"
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
							Somos alunos das disciplinas de
							M�todos de Desenvolvimento de
							Software e Gest�o de Portif�lios
							e Projetos de Software do curso
							de Engenharia de Software da
							Universidade de Bras�lia. Composto
							por cinco desenvolvedores, dois
							gestores e dois <i>coaches</i>.
						</div>
						<br>
						<div id="saiba_mais_box">
							<a href="informacoes.jsp">Clique aqui para saber mais (+)</a>
						</div>
					</div>
				</div>
				<!-- BOX 2 -->
				<div id="box_servicos_2">
					<div id="efeito_box2">
						<h1>
							<center>O que � o Projeto</center>
						</h1>
						<div id="conteudo_box">
							Trata-se de uma solu��o de
							software que busca tornar os
							dados relativos � receitas e
							despesas de campanhas
							eleitorais de 2002 � 2012 mais 
							acess�veis e leg�veis. Esses 
							dados s�o abertos, 
							disponibilizados pelo TSE 
							com granularidade bianual.
						</div>
						<br>
						<div id="saiba_mais_box">
							<a href="informacoes.jsp">Clique aqui para saber mais (+)</a>
						</div>
					</div>
				</div>
				<!-- BOX 3 -->
				<div id="box_servicos_3">
					<div id="efeito_box3">
						<h1>
							<center>Como Utilizar o <i>Web Site</i></center>
						</h1>
						<div id="conteudo_box">
							Navegue pelo menu no cabe�alho
							da p�gina para acessar
							informa��es referentes �
							candidatos e partidos. Tais
							p�ginas ter�o informa��es
							complementares que auxiliam no 
							uso do software. Para pesquisas 
							avan�adas, utilize a se��o de
							pesquisa.
						</div>
						<br>
						<div id="saiba_mais_box">
							<a href="informacoes.jsp">Clique aqui para saber mais (+)</a>
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
					<img src="img/sob_construcao.jpg" alt="">
				</div>
			</center>
		</div>
		<!-- FIM TOP5 -->

	</div>
	<!-- FIM PAGINA CENTRAL -->

	<%@include file="imports/rodape.jsp"%>

</body>
</html>