<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ERRO - Campanhas-ON</title>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoInformacoes.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body>

	<%@include file="imports/cabecalho.jsp"%>

	<!-- CONTEUDO DA PAGINA DE INFORMA��ES -->
	<div id="pagina">
		<div class="titulo_topo">
			<h3>Erro!</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<h4>Um erro ocorreu! N�o ser� poss�vel exibir a P�gina!</h4>
				<br>
				<form name="voltar" action="index.jsp">
					<input type="submit" class="botao" value="Voltar">
				</form>
				<br>
			</div>
		</div>
		<!-- content  -->
	</div>
	<!-- FIM CONTEUDO-->

	<%@include file="imports/rodape.jsp"%>


</body>
</html>