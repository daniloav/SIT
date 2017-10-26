<%-- 
    Document   : exibicaoJSPalteraManterUsuarios
    Created on : 01/12/2012, 09:40:48
    Author     : Danilo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@include file="../../arquivosDeConfiguracaoDeLogin/verificarCookieExibicaoJSP.jsp" %>
<%@include file="../../arquivosDeConfiguracaoDePagina/menuExibicaoJSP.jsp" %>



<html>
    <head>
        <script><%@include file="../../arquivosDeAutenticacaoDePagina/validacaoFormularios.js" %></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIT</title>
    </head>
    <body>
        <h1>Alterar Por Nome</h1>

        <p>
        <form action="controlManterUsuario.do" method="get">
            <input name="OPBD" type="hidden" value="acaoAlterar"/>
            Id do Usuario:<input type="text" readonly="true" value="${usr.idUser}" name="idUser"/><br />
            Nome do Usuario:<input type="text" value="${usr.nomeUser}" name="nomeUser"/><br />
            Telefone do Usuario:<input type="text"  size="21" value="${usr.telefoneUser}" name="telefoneUser" maxlength="21"  onkeyPress="formatar_mascara(this,'##.######-####')"/><br />
            Email do Usuario:<input type="text" size="14" value="${usr.emailUser}" name="emailUser"/><br />
            CPF do Usuario:<input type="text" value="${usr.cpfUser}" name="cpfUser" onkeyPress="formatar_mascara(this,'###.###.###-##')" /><br />
            Login:<input type="text" value="${usr.loginUser}" name="loginUser"/><br/>
            Senha:<input value="${usr.senhaUser}" name="senhaUser" type="password"/><br/>
            Confirma Senha:&nbsp;&nbsp;<input name="confirmaSenha" type="password" maxlength="12"/><br/><br/>
            <input type="submit" value="Alterar"/>
            <input type="reset" value="Limpar"/>
        </form>

        

      

    </body>
</html>



