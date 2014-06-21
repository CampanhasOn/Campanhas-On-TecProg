<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Movimentação - Campanhas-ON</title>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoInformacoes.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body>

	<%@include file="imports/cabecalho.jsp"%>

	<div id="pagina">
		<div class="titulo_topo">
			<h3>Movimentação</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
			
			<center><table border="2">
			<tr>
				<td width="200">
					Data: <c:out value="${movimentacao.data}" />
				</td>
				<td width="200">
				</td>
				<td width="200"> 
					Valor: R$ <c:out value="${movimentacao.valor}" />
				</td>
			</tr>
			<tr>
				<td colspan="3">
					Candidato: <c:out value="${movimentacao.campanha.nomeDeUrna}" />
				</td>
			</tr>
			<tr>
				<td colspan="3">
					Partido: <c:out value="${movimentacao.campanha.partido.sigla}" />
				</td>
			</tr>
			<tr>
				<td colspan="3">
					Tipo: <c:out value="${movimentacao.tipoMovimentacao}" />
				</td>
			</tr>
			<tr>
				<td colspan="3">
					Forma de Pagamento: <c:out value="${movimentacao.formaPagamento}" />
				</td>
			</tr>
			<tr>
				<td colspan="3">
					Descrição: <c:out value="${movimentacao.descricao}" />
				</td>
			</tr>
			
			</table></center>

				
			</div>
		</div>
	</div>

	<%@include file="imports/rodape.jsp"%>


</body>
</html>