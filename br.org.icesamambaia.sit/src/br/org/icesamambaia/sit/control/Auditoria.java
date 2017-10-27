package br.org.icesamambaia.sit.control;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import br.org.icesamambaia.sit.model.Membros;

@WebFilter(filterName = "Auditoria", urlPatterns = "/*")
public class Auditoria implements Filter {

	private static final Logger logger = Logger.getLogger(Auditoria.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		logger.info("###Entrou no servlet filter###");
		HttpServletRequest req = (HttpServletRequest) request;
		logger.info("Criando objeto HttpServlet");
		String uri = req.getRequestURI();
		logger.info("Capturando URI requisitada");
		String usuario = getUsuario(req);
		System.out.println("Usuario " + usuario + " acessando a URI: " + uri);
		logger.info("Exibindo String, com acesso do usuario: " + usuario + " na uri" + uri);
		chain.doFilter(request, response);
		logger.info("Requisicao enviada para: " + uri);

	}

	private String getUsuario(HttpServletRequest req) {
		logger.info("###Entrou no metodo de gravacao de sessao###");
		Membros membro = (Membros) req.getSession().getAttribute("loginUser");
		logger.info("Pega a sessao");

		try {
			if (membro.equals(null)) {
				logger.info("Executa if validacao de campo nulo");
				return "<deslogado>";
			}

		} catch (NullPointerException e) {
			System.out.println("Erro"+e.getMessage());e.printStackTrace();
		}
		return membro.getEmail();//so pro commit

	}
}
