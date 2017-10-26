<%-- 
    Document   : manterDizimosInserirForm
    Created on : 05/12/2012, 19:23:51
    Author     : Danilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Tra%nsitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="../arquivosDeConfiguracaoDeLogin/verificarCookie.jsp" %>
<%@include file="../arquivosDeConfiguracaoDePagina/menu.jsp" %>
<html>
    <head>
        
        <script><%@include file="../arquivosDeAutenticacaoDePagina/validacaoFormularios.js" %></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter dizimos</title>
    </head>
    <body><br/><br/><br/><br/>
        
        <form action="../controlDizimos.do" method="get">
            <input name="OPBD" type="hidden" value="inserirPorNome"/>         
            Nome do Membro:<input type="text" size="30"  maxlength="30" name="nomeMembro" />&nbsp;
            <input type="submit" value="Iniciar Registro"/>
            <input type="reset" value="Limpar"/>
            <br><br><br>[<b><font color="red">*</font></b>] - Preenchimento Obrigatorio.<br>

        </form>
    </body>
</html>

