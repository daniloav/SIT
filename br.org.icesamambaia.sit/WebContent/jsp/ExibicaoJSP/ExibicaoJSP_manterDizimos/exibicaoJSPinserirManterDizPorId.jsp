<%-- 
    Document   : exibicaoJSPinserirManterDizPorId
    Created on : 02/05/2014, 20:14:09
    Author     : Danilo
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include
	file="../../arquivosDeConfiguracaoDeLogin/verificarCookieExibicaoJSP.jsp"%>
<%@include
	file="../../arquivosDeConfiguracaoDePagina/menuExibicaoJSP.jsp"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SIT</title>
</head>
<body>
	<h1>Registro de dizimo Por id</h1>
	<form action="controlDizimos.do" method="get">
		<p>
			<input name="OPBD" type="hidden" value="inserirFinalizar" /> Id do
			Membro:<input type="text" readonly="true" value="${mbr.idMembro}"
				name="idKeyEstMembro" /><br /> Id Usuario:<input type="text"
				readonly="true" value="${usr.idUser}" name="idKeyEstUsuario" /> <br />
			Valor do dizimo:<input type="text" name="valorDiz" /><br /> Data de
			entrega do dizimo:<input type="text" name="dataDiz" size="9"
				maxlength="9" onkeyPress="formatar_mascara(this,'##/##/##')" />&nbsp;<br />
			Periodo dizimo:<input type="text" name="periodoDiz" size="7"
				maxlength="7" onkeyPress="formatar_mascara(this,'##/####')" />&nbsp;<br />
			Data de Lançamento:<input type="text" name="dataLancDiz" size="8"
				value="${diz.dataLancDiz}" /><br /> <input type="submit"
				value="Finalizar Registro" /> <input type="reset" value="Limpar" />
		</p>
	</form>


</body>
</html>
