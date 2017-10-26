<%-- 
    Document   : manterFornecedoresInserirForm
    Created on : 11/12/2012, 19:35:03
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
        <title>Cadastro de Fornecedores</title>
    </head>
    <body><br/><br/><br/><br/>
        
        <form action="../controlManterFornecedores.do" method="get">
           <input name="OPBD" type="hidden" value="inserir"/>
                        
            Nome do Fornecedor<b><font color="red">*</font></b>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="nomeFornecedor" maxlength="30" size="30"/>&nbsp;<br/><br/>
            CNPJ<b><font color="red">*</font></b>:<input  type="text" size="18" name="cnpjFornecedor" maxlength="18"  onkeyPress="formatar_mascara(this,'##.###.###/####-##')"/><br/><br/>
            Descricao<b><font color="red">*</font></b>:<textarea name="descFornecedor" COLS=40 ROWS=5 maxlenght="150"></textarea><br/><br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="submit" value="Cadastrar"/>
            <input type="reset" value="Limpar"/>
            <br><br><br><b><font color="red">*</font></b> - Preenchimento Obrigatorio.<br>

        </form>
    </body>
</html>

