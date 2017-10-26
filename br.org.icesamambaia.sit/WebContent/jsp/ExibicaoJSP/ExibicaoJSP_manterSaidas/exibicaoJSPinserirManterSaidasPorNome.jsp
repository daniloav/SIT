<%-- 
    Document   : exibicaoJSPinserirManterSaidasPorNome
    Created on : 11/12/2012, 20:08:08
    Author     : Danilo
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib   uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../../arquivosDeConfiguracaoDeLogin/verificarCookieExibicaoJSP.jsp" %>
<%@include file="../../arquivosDeConfiguracaoDePagina/menuExibicaoJSP.jsp" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIT</title>
        <script>
            now = new Date()
dia = now.getDate()
mes = now.getMonth() + 1
ano = now.getYear()
TodaysHour = new Date()
horas = TodaysHour.getHours()
minutos = TodaysHour.getMinutes()
        </script>
    </head>
    <body>
        <h1>Registro de saida Por Nome de Solicitante</h1> 
        <form action="controlSaidas.do" method="get">
            <p> 
                <input name="OPBD" type="hidden" value="inserirFinalizar"/>
                Id do Membro Solicitante:<input type="text" readonly="true" value="${mbr.idMembro}" name="idKeyMembrosSolicitante"/><br />
                Id Usuario Lançador:<input type="text" readonly="true" value="${usr.idUser}" name="idKeyEstUsuariosLancador"/><br />
                Id do fornecedor:<input type="text" readonly="true" value="${forn.idFornecedor}" name="idKeyEstFornecedoresComprado"/><br />
                Numero de NF:<input type="text" name="numNfSaida"/><br/>
                Data da NF:<input type="text" name="dataNfSaida"/>&nbsp;<br/>
                Data de Lançamento:<input name="dataLancamentoNfSaida" value= <script language=javascript>window.document.write(new Date());</script>/>&nbsp;<br/>
                Periodo contabil:<input type="text" name="periodoLancamentoNfSaida"/>&nbsp;<br/>
                Descrição Saida:<input type="text" name="descricaoSaida"/>
                Tipo de gasto:<input type="text" name="tipoSaida"/>
                <input type="submit" value="Finalizar Registro"/>
            <input type="reset" value="Limpar"/>
            </p>
        </form>


    </body>
</html>
