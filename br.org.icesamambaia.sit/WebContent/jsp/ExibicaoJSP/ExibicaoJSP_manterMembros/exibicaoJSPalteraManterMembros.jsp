<%-- 
    Document   : exibicaoJSPalteraManterMembros
    Created on : 13/11/2015, 09:18:24
    Author     : c137050
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
        <form action="controlManterMembros.do" method="get">
            <input name="OPBD" type="hidden" value="acaoAlterar"/>
            Id do Membro:<input type="text" readonly="true" value="${mbr.idMembro}" name="idMembro"/><br />
            Foto:<input type="text" readonly="true" value=${mbr.fotoMembro}""><br/>
            Nome do Membro:<input type="text" value="${mbr.nomeMembro}" name="nomeMembro"/><br />            
            Data de Nascimento:<input type="text" value="${mbr.dataNascMembro}" name="dataNascMembro" /><br/>
            Cargo Membro:<input type="text" value="${mbr.cargoMembro}" name="cargoMembro" /><br/>
            CPF do Membro:<input type="text" value="${mbr.cpfMembro}" name="cpfMembro" onkeyPress="formatar_mascara(this,'###.###.###-##')" /><br />
            
            <input type="submit" value="Alterar"/>
            <input type="reset" value="Limpar"/>
        </form>

        

      

    </body>
</html>



