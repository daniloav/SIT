package br.org.icesamambaia.sit.control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.Dispatcher;

import org.apache.log4j.Logger;

import br.org.icesamambaia.sit.model.Cargo;
import br.org.icesamambaia.sit.model.Votante;
import br.org.icesamambaia.sit.model.DAO.CargoDAO;
import br.org.icesamambaia.sit.model.DAO.VotanteDAO;

/**
 * Servlet implementation class cadastroVotante
 */
@WebServlet(name = "Membros", urlPatterns = { "/Membros.do" })
public class Membros extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Membros.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String OPBD = request.getParameter("OPBD").trim();
		logger.debug("Pegando dados da variavel OPDB");

		if (OPBD.equals("inserirVotante")) {
			logger.info("###Entrou no servlet CadastroVotante.java###");
			SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
			logger.debug("Criando formatador de datas");
			Date dataNascimentoFormatada = null;
			logger.debug("Criando variavel local");
			Date dataIngressoFormatada = null;
			logger.debug("Criando variavel local");
			try {
				logger.info("Entrou no try");
				dataNascimentoFormatada = formata.parse(request.getParameter("dataNascimento").trim());
				logger.debug("Recebendo requisicao de data do form");
				dataIngressoFormatada = formata.parse(request.getParameter("dataIngresso").trim());
				logger.debug("Recebendo requisicao de data do form");
			} catch (ParseException e) {
				logger.info("Entrou no catch");
				logger.error("Ocorreu o seguinte erro: " + e.getMessage());
				e.printStackTrace();
			}

			Cargo cargo = CargoDAO.getInstance().le(request.getParameter("cargo"));
			logger.debug("Carregada dados no objeto com os dados do banco pesquisados");
			logger.info("Instanciando cargo com o construtor");
			VotanteDAO opBanco = new VotanteDAO();
			logger.debug("Cria objeto para operacao no banco de dados");
		

			Votante v = new Votante(Integer.parseInt(request.getParameter("id")), request.getParameter("nome").trim(),
					request.getParameter("sobrenome"), dataNascimentoFormatada, dataIngressoFormatada,
					request.getParameter("email").trim(), request.getParameter("telefone").trim(),
					request.getParameter("celular").trim(), request.getParameter("login").trim(),
					request.getParameter("senha").trim(), cargo, request.getParameter("cpf").trim());
			logger.info("Instanciando Votante com o construtor");

			opBanco.grava(v);
			logger.debug("Executa operacao de gravacao no base de dados");

			RequestDispatcher rd = request.getRequestDispatcher("/jsp/dispatcherRequestResponse/returnCadastro.jsp");
			logger.debug("Cria requestDispatcher para /jsp/dispatcherRequestResponse/returnCadastro.jsp ");
			rd.forward(request, response);
			logger.info("Finalizado e redirecionado para:/jsp/dispatcherRequestResponse/returnCadastro.jsp");

		}
		else if(OPBD.equals("alterarVotante")){
			logger.debug("##Entrando no if OPBD=alterarVotante##");
			Votante vt = VotanteDAO.getInstance().le(request.getParameter("login"));
			logger.debug("Carregando dados no objeto pegandos os dados correspondentes no banco");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/Membros/acaoAlterar.jsp");
			logger.debug("Criando dispatcher para /jsp/Membros/acaoAlterar.jsp");
			rd.forward(request, response);
			logger.info("Forward do request dispatcher executada");
		}
		else if(OPBD.equals("acaoAlterarVotante")) {

			Cargo cargo = CargoDAO.getInstance().le(request.getParameter("cargo"));
			logger.debug("Carregada dados no objeto com os dados do banco pesquisados");
			logger.info("Instanciando cargo com o construtor");
			VotanteDAO opBanco = new VotanteDAO();
			logger.debug("Cria objeto para operacao no banco de dados");
		

			Votante v = new Votante(Integer.parseInt(request.getParameter("id")), request.getParameter("nome").trim(),
					request.getParameter("sobrenome"), dataNascimentoFormatada, dataIngressoFormatada,
					request.getParameter("email").trim(), request.getParameter("telefone").trim(),
					request.getParameter("celular").trim(), request.getParameter("login").trim(),
					request.getParameter("senha").trim(), cargo, request.getParameter("cpf").trim());
			logger.info("Instanciando Votante com o construtor");

			opBanco.altera(v);
			logger.debug("Executa operacao de alteracao no base de dados");

			RequestDispatcher rd = request.getRequestDispatcher("/jsp/AlertasFinais/msmFinalAlterarVotante.jsp");
			logger.debug("Cria requestDispatcher para /jsp/AlertasFinais/msmFinalAlterarVotante.jsp");
			rd.forward(request, response);
			logger.info("Finalizado e redirecionado para /jsp/AlertasFinais/msmFinalAlterarVotante.jsp");
			
			
		}
		else if(OPBD.equals("PesquisarVotante")) {}
		else if(OPBD.equals("excluirVotante")) {}
		else if(OPBD.equals("inserirCongregante")){}
		else if(OPBD.equals("alterarCongregante")){}
		else if(OPBD.equals("PesquisarCongregante")) {}
		else if(OPBD.equals("excluirCongregante")) {}
		
	}

}
