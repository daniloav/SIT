package br.org.icesamambaia.sit.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import br.org.icesamambaia.sit.model.DAO.VotanteDAO;

import br.org.icesamambaia.sit.model.Membros;
import br.org.icesamambaia.sit.model.Votante;

/**
 *
 * @author Danilo
 */

@WebServlet(name = "Login", urlPatterns = { "/Login.do" })
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Auditoria.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		logger.info("###ENTROU NO SERVLET LOGIN###");
		String autLoginUser, autSenhaUser,tipoAcesso;
		logger.info("Cria as variáveis para comparar a senha");
		autLoginUser = request.getParameter("loginUser").trim();
		autSenhaUser = request.getParameter("senhaUser").trim();
		tipoAcesso = request.getParameter("tipoAcesso").trim();
		logger.info("Capturou via request variaveis vindas do jsp");

		HttpSession session = request.getSession();
		logger.info("Cria sessão");

		try {
			if(tipoAcesso.equals("votante")){
			Votante vt = VotanteDAO.getInstance().le(autLoginUser);
			logger.info("Busca na base de dados o usuário digitado");
			String validaLogin = vt.getLogin();
			String validaSenha = vt.getSenha();
			logger.info("Joga dados buscados na variaveis");
			if (validaLogin.equals(autLoginUser) && validaSenha.equals(autSenhaUser)) {
				logger.info("Comparando credenciais");
				// out.print("Logado com sucesso"); //Mostra na tela que foi logado com sucesso
				session.setAttribute("loginUser", autLoginUser); // Grava a session com o Login
				session.setAttribute("senhaUser", autSenhaUser); // Grava a session com a Senha
				logger.info("Granvando sessão");
				response.sendRedirect("index.jsp");
				logger.info("Redirecionando para exibição jsp");
				// out.println("<script>document.location.href='login/logado.jsp';</script>");
				// //Exibe um código javascript para redireionar ao painel

			} else { // Se estiverem incorretos...
				// out.println("<body background='senhas.jpg'><b><h1><font color='red'>Login ou
				// senha inválidos. <a href='login/login.jsp'>Voltar</a>"); //Exibe na tela e
				// pede para voltar
				// session.setAttribute("loginUsuario", alogin); //Grava a session com o Login
				// response.sendRedirect("login/erroPswUser.jsp");}
				logger.info("Entrou no caso de uso de crendeciais invalidas");
				out.print(
						"<script>alert('Usuário e/ou senha informados de forma incorreta. Por favor, tente novamente com os dados corretos!');</script>");
				out.println("<script>document.location.href='jsp/arquivosDeConfiguracaoDeLogin/login.jsp';</script>");
				logger.info("Redirecionou para a tela de login com mensagem de erro");
			}
			}else{}
			
			
			
			
		} catch (NullPointerException ex) {
			logger.info("Entrou no catch de NullPointerException");
			// response.sendError(10,"N&aacute;o foi poss&iacute;vel conect&aacute;-lo como
			// Funcion&aacute;rio!");
			logger.debug(ex.getMessage());
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/Login/erroLogin.jsp");
			rd.forward(request, response);
			logger.info("Redireciona para jsp de erro de login");
		}

	}
}
