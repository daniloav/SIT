<%
//Verifica se está logado
if(session.getValue("loginUsuario") != null || session.getValue("senhaUsuario") != null){
out.println("Bem vindo  " + session.getValue("loginUsuario")+".Para fazer logoff clique <a href='logoff.jsp'>aqui</a>");
response.sendRedirect("../Index/index.jsp");
} else {
out.println("Você não está logado no sistema. Clique <a href='login.jsp'>aqui</a> para logar-se");
}
%>