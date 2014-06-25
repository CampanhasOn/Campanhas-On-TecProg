<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
					<li><a href="index.jsp" class="home">Home</a></li>
					<li><a href="requisitar_candidato.jsp" class="candidatos">Candidatos</a>
					</li>
					<li>
					<c:url var="url_partido" value="/mvc">
						<c:param name="logica" value="RequisitarPartido"></c:param>
						<c:param name="inicio" value="${0}"></c:param>
						<c:param name="qtdPorPagina" value="${10}"></c:param>
						<c:param name="verTodos" value="${false}"></c:param>
					</c:url>
					<a href="${url_partido}" class="partidos">Partidos</a>
					</li>
					<li><a href="top_five.jsp" class="pesquisar">TOP 5</a>
					</li>
				</ul>
			</div>
			<!-- FIM MENU -->
		</div>
	</div>
	<!-- FIM CABECALHO e MENU -->