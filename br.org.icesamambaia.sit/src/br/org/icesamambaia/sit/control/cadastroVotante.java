package br.org.icesamambaia.sit.control;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.org.icesamambaia.sit.model.Cargo;
import br.org.icesamambaia.sit.model.Votante;

/**
 * Servlet implementation class cadastroVotante
 */
@WebServlet(description = "Servlet que controla o cadastro do model VOTANTE", urlPatterns = { "/cadastroVotante.do" })
public class cadastroVotante extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public cadastroVotante() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
		Date dataNascimentoFormatada = null;
		Date dataIngressoFormatada = null;
		try {
			dataNascimentoFormatada = formata.parse(request.getParameter("dataNascimento").trim());
			dataIngressoFormatada = formata.parse(request.getParameter("dataIngresso").trim());
		} catch (ParseException e) {

			e.printStackTrace();
		}

		Cargo cargo = new Cargo(request.getParameter("cargo").trim(), 8);

		Votante v = new Votante(request.getParameter("nome").trim(), request.getParameter("sobrenome"),
				dataNascimentoFormatada, dataIngressoFormatada, request.getParameter("email").trim(),
				request.getParameter("telefone").trim(), request.getParameter("celular").trim(),
				request.getParameter("login").trim(), request.getParameter("senha").trim(), cargo,
				request.getParameter("cpf").trim());
		response.getWriter().print(v.toString());

		response.getWriter().print("<script>" + "alert('Concluído');" + "</script>");
	}

}
