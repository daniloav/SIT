<%-- 
    Document   : manterMembrosExcluir
    Created on : 01/12/2012, 14:46:23
    Author     : Danilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
    <%@include file="../arquivosDeConfiguracaoDeLogin/verificarCookie.jsp" %>
<%@include file="../arquivosDeConfiguracaoDePagina/menu.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIT</title>
    </head>
    <body><br/><br/>
        <h1>Excluir por nome</h1>
        <form action="../controlManterMembros.do" method="get">
            <input name="OPBD" type="hidden" value="excluir"/>
            Nome<b><font color="red">*</font></b>:<input type="text" name="nomeMembro"/>
            <input type="submit" value="Pesquisar">
            <br><br><br>[<b><font color="red">*</font></b>] - Preenchimento Obrigatorio.<br>
        </form>



    </body>
</html>
