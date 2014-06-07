<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Partidos - Campanhas-ON</title>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoInformacoes.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body>

	<%@include file="imports/cabecalhopartidos.jsp"%>

	<div id="pagina">
		<div class="titulo_topo">
			<h3>Listagem</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<p>
					Abaixo a <b>lista de Partidos</b>.
				</p>

				<c:forEach var="partido" items="${listaPartidos}">
					<table border="2" width="300">
						<tr>
							<td>Nome:</td>
							<td>							
								<c:url var="partidoURL" value="/SelecionarPartido">
									<c:param name="sigla" value="${partido.sigla}"></c:param>
								</c:url>
								<a  href="${partidoURL}" > ${partido.nome} </a>
							</td>
						</tr>
						<tr>
							<td>Sigla:</td>
							<td> ${partido.sigla}</td>
						</tr>
					</table>
					<br />
				</c:forEach>
				<br>
			</div>
		</div>
	</div>
	<!-- FIM CONTEUDO-->

	<%@include file="imports/rodape.jsp"%>


</body>
</html>