<%-- 
    Document   : manterDizimosInseriFormIdMembro
    Created on : 02/05/2014, 19:57:46
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
        <title>Manter Dizimos</title>
    </head>
    <body><br/><br/><br/><br/>
        
        <form action="../controlDizimos.do" method="get">
            <input name="OPBD" type="hidden" value="inserirPorId"/>         
            ID do Membro:<input type="text" size="4"  maxlength="4" name="idMembro" />&nbsp;
            <input type="submit" value="Iniciar Registro"/>
            <input type="reset" value="Limpar"/>
            <br><br><br><b><font color="red">*</font></b>] - Preenchimento Obrigatorio.<br>

        </form>
    </body>
</html>
