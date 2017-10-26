<%-- 
    Document   : exibicaoJSPpesquisaManterMembros
    Created on : 01/12/2012, 16:23:15
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
        <p>Id do Membro:${mbr.idMembro} &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            Foto:<img src="manterMembros/imagensMembros/${mbr.fotoMembro}" width=80/><br/>
            Nome do Membro:${mbr.nomeMembro}<br />
            Data de Nascimento:${mbr.dataNascMembro}<br/>
            CPF do Membro:${mbr.cpfMembro}<br/>
            Cargo do Membro:${mbr.cargoMembro}<br/>
            
            <a href="../../org.br.tesouraria/arquivosDeInicioIndex/index.jsp">Voltar</a>
                        
        
    </body>
</html>