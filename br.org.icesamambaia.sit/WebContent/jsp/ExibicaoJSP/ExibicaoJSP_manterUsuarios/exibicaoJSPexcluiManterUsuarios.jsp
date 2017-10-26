<%-- 
    Document   : exibicaoJSPexcluiManterUsuarios
    Created on : 01/12/2012, 12:27:27
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
        <h1>Excluir Por Nome</h1>

     
        <form action="controlManterUsuario.do" method="post">
            <input name="OPBD" type="hidden" value="acaoExcluir"/>
            Id do Usuario:<input type="text" readonly="true" value="${usr.idUser}" name="idUser"/><br />
            <p>Nome do Usuario:${usr.nomeUser}<br />
            Telefone do Usuario:${usr.telefoneUser}<br/>
            Email do Usuario:${usr.emailUser}<br/>
            CPF do Usuario:${usr.cpfUser}<br/>
            Login:${usr.loginUser}<br/>
            Senha:${usr.senhaUser}</p><br/>
            <input type="submit" value="Excluir"/>
            
        </form>

  



    </body>
</html>
