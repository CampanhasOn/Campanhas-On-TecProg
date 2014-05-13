<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Candidato - Campanhas-ON</title>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoInformacoes.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body>


	<!-- CABECALHO e MENU -->
	<div id="topo">
		<div id="cabecalho">
			<div id="logo">
				<a href="index.jsp"> <img src="img/logo.png" width="257"
					height="58" alt="Logo" title="CampanhasOn">
				</a> <span class="titulo">Informe-se J�!</span>
			</div>

			<!-- MENU -->
			<div id="menu">
				<ul>
					<li><a href="index.jsp" class="home" title>Home</a></li>
					<li><a href="candidatos.jsp" class="candidatos" title>Candidatos</a>
					</li>
					<li><a href="partidos.jsp" class="partidos" title>Partidos</a>
					</li>
					<li><a href="pesquisar.jsp" class="pesquisar" title>Pesquisar</a>
					</li>
				</ul>
			</div>
			<!-- FIM MENU -->

		</div>
	</div>
	<!-- FIM CABECALHO e MENU -->

	<!-- CONTEUDO DA PAGINA DE INFORMA��ES -->
	<div id="pagina">
		<div class="titulo_topo">
			<h3>Informa��es</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<p></p>
				<h4>Para visualizar Receitas e Despesas deste candidato:</h4>
				<p>Selecione o ano desejado e click em Buscar:</p>

				<form action="requisitarMovimentacoes">
					<table>
						<tr>
							<td>Ano:</td>
							<td><select name="ano">
									<option value="2002">2002</option>
									<option value="2004">2004</option>
									<option value="2006">2006</option>
									<option value="2008">2008</option>
									<option value="2010">2010</option>
									<option value="2012">2012</option>
							</select></td>
						</tr>
						<tr>
							<td></td>
							<td><br>
							<input type="submit" value="Buscar" /></td>
						</tr>
					</table>
				</form>
				<br> <br>
			</div>
		</div>
		<!-- content  -->
	</div>
	<!-- FIM CONTEUDO-->

	<!-- RODAPE -->
	<div id="rodape">
		<div id="centro_rodape">
			<a href="index.jsp"> <img src="img/logo.png" width="257"
				height="58" alt="Logo" title="CampanhasOn"></a>
			<div id="redes_sociais">
				<a href="index.jsp"><img src="img/facebook.png" width="32"
					height="32" alt="Facebook" title="Facebook"></a> <a
					href="index.jsp"><img src="img/twitter.png" width="32"
					height="32" alt="Twitter" title="Twitter"></a> <a
					href="https://github.com/macartur/prestacao_de_contas_das_campanhas_eleitorais"><img
					src="img/github.png" width="32" height="32" alt="GitHub"
					title="GitHub"></a>
			</div>
			<div id="dado_rodape">
				Universidade de Bras�lia <br> Faculdade do Gama - FGA <br>
				Projeto: Campanhas-On / MDS
			</div>
		</div>
	</div>
	<!-- FIM RODAPE -->
</body>
</html>