<%-- 
    Document   : exibicaoJSPexcluiManterMembros
    Created on : 13/11/2015, 10:04:01
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
    <body>
        <h1>Excluir Por Nome</h1>

     
        <form action="controlManterMembros.do" method="post">
            <input name="OPBD" type="hidden" value="acaoExcluir"/>
            Id do Membro:<input type="text" readonly="true" value="${mbr.idMembro}" name="idMembro"/><br />
            <p>Nome do Membro:${mbr.nomeMembro}<br />
            Data de Nascimento:${mbr.dataNascMembro}<br/>
            Cargo Membro:${mbr.cargoMembro}<br/>
            CPF do Membro:${mbr.cpfMembro}<br />
            <input type="submit" value="Excluir"/>
            
        </form>
          

  



    </body>
</html>