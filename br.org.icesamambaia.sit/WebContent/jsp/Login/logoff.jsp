<%
//Destroi as sessions
session.invalidate();

out.println("<h1>Logoff</h1>");
response.sendRedirect("login.jsp");
%>
