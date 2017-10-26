<%
//Verifica se esta logado
if(session.getAttribute("loginUser") != null || session.getAttribute("senhaUser") != null){
out.println("<p align='center'> " + session.getAttribute("loginUser")+", seja bem vindo ao m&oacute;dulo de Administração Financeira do SIT!!!, "+"<br> Para fazer logoff clique"+"<a href='../arquivosDeConfiguracaoDeLogin/logoff.jsp'>&nbsp;aqui</a>"+"<img src='../arquivosDeConfiguracaoDePagina/IMAGENS/logoff.png'width='20' height='15'/></center>");
} else {
	
	RequestDispatcher rd = request.getRequestDispatcher("/jsp/Login/login.jsp");
	rd.forward(request, response);
//response.sendRedirect("/WEB-INF/jsp/arquivosDeConfiguracaoDeLogin/login.jsp");
}

 %>