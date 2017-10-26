<%-- 
    Document   : manterMembrosInserir
    Document Modified on: VotanteInserir
    Created on : 01/12/2012, 14:46:38
    Modified on: 18/10/2017 01:04:00
    Author     : Danilo
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Tra%nsitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="/jsp/Login/verificarCookie.jsp"%>
<%@include file="/jsp/arquivosDeConfiguracaoDePagina/menu.jsp"%>
<html>
<head>
<script><%@include file="/jsp/arquivosDeAutenticacaoDePagina/validacaoFormularios.js" %></script>
<script>
	/* Máscaras ER */
	function mascara(o, f) {
		v_obj = o
		v_fun = f
		setTimeout("execmascara()", 1)
	}
	function execmascara() {
		v_obj.value = v_fun(v_obj.value)
	}
	function mtel(v) {
		v = v.replace(/D/g, ""); //Remove tudo o que não é dígito
		v = v.replace(/^(d{2})(d)/g, "($1) $2"); //Coloca parênteses em volta dos dois primeiros dígitos
		v = v.replace(/(d)(d{4})$/, "$1-$2"); //Coloca hífen entre o quarto e o quinto dígitos
		return v;
	}
	function id(el) {
		return document.getElementById(el);
	}
	window.onload = function() {
		id('telefone').onkeypress = function() {
			mascara(this, mtel);
		}
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuarios</title>
</head>
<body>
	<br />
	<br />
	<br />
	<br />

	<c:url value="../../Membros.do" var="urlVotante" />
	<form action="${urlVotante}" method="post">
		<input name="OPBD" type="hidden" value="inserirVotante" /> Nome<b><font
			color="red">*</font></b>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="text" name="nome" maxlength="30" size="30" />&nbsp;<br />
		<br /> Sobrenome<b><font color="red">*</font></b>:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input
			type="text" name="sobreNome" maxlength="30" size="30" />&nbsp;<br />
		<br /> Data de Nascimento<b><font color="red">*</font></b>:<input
			type="text" size="10" maxlength="10" name="dataNascimento"
			onkeypress="formatar_mascara(this,'##/##/####')" />&nbsp;dd/mm/aaaa&nbsp;&nbsp;&nbsp;</br>
		</br> Data de Ingresso<b><font color="red">*</font></b>:<input type="text"
			size="10" maxlength="10" name="dataIngresso"
			onkeypress="formatar_mascara(this,'##/##/####')" />&nbsp;dd/mm/aaaa&nbsp;&nbsp;&nbsp;</br>
		</br> Telefone<b><font color="red">*</font></b>:<input type="text"
			maxlength="15" name="telefone" id="telefone" /></br> Celular<b><font
			color="red">*</font></b>::<input type="text" name="celular"
			onkeypress="formatar_mascara(this,'(##) # ####-####')"></br> Login<b><font
			color="red">*</font></b>::<input type="text" name="login" size="12"
			maxlength="12"></br> Senha<b><font color="red">*</font></b>::<input
			type="password" name="senha"></br> CPF<b><font color="red">*</font></b>:<input
			type="text" size="14" name="cpfMembro" maxlength="14"
			onkeyPress="formatar_mascara(this,'###.###.###-##')" /><br />
		<br /> Cargo<b><font color="red">*</font></b>:<select name="cargo">
			<option value="presidente">Pastor Presidente</option>
			<option value="diretor">Diretor Patrimonial</option>
			<option value="tesoureiro1">1° Tesoureiro</option>
			<option value="tesoureiro2">2° Tesoureiro</option>
			<option value="secretario1">1° Secretário</option>
			<option value="secretario2">2° Secretário</option>
			<option value="cpec">Membro CPEC</option>
			<option value="membro">Membro</option>
		</select></br> <input type="submit" value="Cadastrar" /> <input type="reset"
			value="Limpar" /> <br>
		<br>
		<br>
		<b><font color="red">*</font></b> - Preenchimento Obrigatorio.<br>

	</form>
</body>
</html>
