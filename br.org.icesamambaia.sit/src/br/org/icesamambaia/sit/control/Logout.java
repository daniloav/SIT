package br.org.icesamambaia.sit.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

@WebServlet(urlPatterns = "/Logout")
public class Logout extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Logout.class);

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		logger.info("###Entrou na classe Logout.java###");
		request.getSession().removeAttribute("loginUser");
		logger.info("Removeu sessao");
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/arquivosDeConfiguracaoDeLogin/logoff.jsp");
		rd.forward(request, response);
		logger.info("Redirecionou para /WEB-INF/jsp/arquivosDeConfiguracaoDeLogin/logoff.jsp");
	}
}
