<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informa��es - Campanhas-ON</title>
<link rel="shortcut icon" href=img/favicon.ico type="image/x-icon" />
<link href="css/layout.css" rel="stylesheet" type="text/css" media="all">
<link href="css/menu.css" rel="stylesheet" type="text/css" media="all">
<link href="css/rodape.css" rel="stylesheet" type="text/css" media="all">
<link href="css/conteudoInformacoes.css" rel="stylesheet"
	type="text/css" media="all">
</head>
<body>

	<!--  CABE�ALHO -->
	<%@include file="imports/cabecalho.jsp"%>
	<!-- FIM CABE�ALHO -->

	<!-- CONTEUDO DA PAGINA DE INFORMA��ES -->
	<div id="pagina">
		<div class="titulo_topo">
			<h3>Informa��es</h3>
		</div>
		<div id="conteudo_informacoes">
			<div class="informacoes">
				<h4>-- Quem Somos?</h4>
				<p></p>
				<p>	Somos alunos das disciplinas de M�todos de Desenvolvimento de Software e Gest�o de Portif�lios e Projetos de Software do curso de Engenharia de Software
					da Universidade de Bras�lia. Composto por cinco desenvolvedores: Augusto Modesto, Jonathan Moraes, Matheus Ferraz, Rafael Valen�a e Yuri Loiola; dois
					gestores: Luciano Prestes e Mac�rtur de Sousa; e sob orienta��o de dois <i>coaches</i>: Jo�o Henrique e Maria Luciene.
				</p>
				<p>	O projeto � parte da tem�tica de ambas as disciplinas, conceituada e aplicada pelo Professor Hilmer Rodrigues Neri. O tema exercido envolve a cria��o de um 
					sistema que extraia informa��es de Dados Abertos do Governo Federal e os traduza para informa��es acess�veis e intelig�veis. Tal metodologia n�o s� nos
					ensina m�todos de desenvolvimento e gest�o de produtos de software, como nos permite aprender a atuar de forma consciente na sociedade em que vivemos.
					Al�m de um projeto de software, � uma iniciativa que promove a cidadania.
				</p>
				<h4>-- O que � o Projeto?</h4>
				<p></p>
				<p>	Trata-se de uma solu��o de software que busca tornar os dados relativos � receitas e despesas de campanhas eleitorais de 2002 � 2012 mais acess�veis e
					leg�veis. Esses dados s�o abertos, disponibilizados pelo Tribunal Superior Eleitoral (TSE) com granularidade bianual em arquivos com a extens�o ".txt".
					Conforme disp�em os artigos 28 e 32 da Lei n� 9.504/97, os candidatos, partidos pol�ticos e comit�s financeiros devem fornecer estes dados � Justi�a Eleitoral
					at� o trig�simo dia posterior ao t�rmino das elei��es.
				</p>
				<p>	Contudo, mesmo esses dados sendo p�blicos, n�o existe uma forma simplificada e concisa que permita uma real abstra��o de informa��o a partir deles.
					Assim, o <b>Campanhas-ON</b> pode ser visto como uma forma integrada de acesso a todos os dados referentes �s contas eleitorais, disponibilizados pelo TSE.
					Al�m disso, � uma ferramenta que objetiva agregar valor aos dados atrav�s de gr�ficos, compara��es e relat�rios, n�o sendo, portanto, um mero buscador de
					informa��o.
				</p> 
				<h4>-- Como Utilizar o <i>Web Site</i>?</h4>
				<p></p>
				<p>	Navegue pelo menu no cabe�alho da p�gina para acessar informa��es referentes � candidatos e partidos. Tais p�ginas ter�o informa��es complementares que
					auxiliam no uso do software. Para pesquisas avan�adas, utilize a se��o de pesquisa.
				</p>
				<p> <b>Campanhas-ON</b> est� em seu primeiro <i>release</i>. Novas p�ginas, tratamento de dados e tecnologias ser�o inclu�das em seu segundo <i>release</i>.
				</p>
				<br>
				<br>
			</div>
		</div>
		<!-- content  -->
	</div>
	<!-- FIM CONTEUDO-->

	<!-- RODAP� -->
	<%@include file="imports/rodape.jsp"%>
	<!-- FIM RODAP� -->

</body>
</html>
