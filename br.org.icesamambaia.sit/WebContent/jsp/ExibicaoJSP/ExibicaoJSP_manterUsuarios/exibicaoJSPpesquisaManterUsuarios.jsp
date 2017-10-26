<%-- 
    Document   : newjsp
    Created on : 01/12/2012, 13:03:30
    Author     : Danilo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../arquivosDeConfiguracaoDeLogin/verificarCookieExibicaoJSP.jsp" %>
<%@include file="../../arquivosDeConfiguracaoDePagina/menuExibicaoJSP.jsp" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIT</title>
    </head>
    <body>
        <h1>Pesquisa Por Nome</h1>       
        <p>Id do Usuario:${usr.idUser}<br />
            Nome do Usuario:${usr.nomeUser}<br />
            Telefone do Usuario:${usr.telefoneUser}<br/>
            Email do Usuario:${usr.emailUser}<br/>
            CPF do Usuario:${usr.cpfUser}<br/>
            Login:${usr.loginUser}<br/>
            Senha:${usr.senhaUser}</p><br/>
                        
        
    </body>
</html>
