package br.com.fintech.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fintech.bean.*;
import br.com.fintech.dao.*;
import br.com.fintech.exception.*;
import br.com.fintech.factory.*;

/**
 * Servlet implementation class ReceitaServlet
 */
@WebServlet("/receita")
public class ReceitaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ReceitaDAO dao;

	@Override
	public void init() throws ServletException {
		super.init();
		dao = DAOFactory.getReceitaDAO();
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReceitaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

		// List<Receita> lista = dao.listar();
		// request.setAttribute("receitas", lista);
		// request.getRequestDispatcher("lista-receita.jsp").forward(request, response);

		String acao = request.getParameter("acao");

		switch (acao) {
			case "listar":
				listar(request, response);
				break;
			case "abrir-form-edicao-receita":
				int id = Integer.parseInt(
						request.getParameter("codigo"));
				Receita receita = dao.buscar(id);
				request.setAttribute("receita", receita);
				request.getRequestDispatcher("edicao-receita.jsp").forward(request, response);
		}

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Receita> lista = dao.listar();
		request.setAttribute("receitas", lista);
		request.getRequestDispatcher("lista-receita.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String acao = request.getParameter("acao");

		switch (acao) {
			case "cadastrar":
				cadastrar(request, response);
				break;
			case "editar":
				editar(request, response);
				break;
			case "excluir":
				excluir(request, response);
				break;
		}

		cadastrar(request, response);
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String nome = request.getParameter("nome");
			double valor = Double.parseDouble(request.getParameter("valor"));

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataReceita = Calendar.getInstance();
			dataReceita.setTime(format.parse(request.getParameter("dataReceita")));

			Receita receita = new Receita(0, nome, valor, dataReceita);
			dao.cadastrar(receita);

			request.setAttribute("msg", "Receita cadastrada!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, Valide os dados");
		}
		request.getRequestDispatcher("cadastro-receita.jsp").forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			int codigo = Integer.parseInt(request.getParameter("codigo"));
			String nome = request.getParameter("nome");
			double valor = Double.parseDouble(request.getParameter("valor"));
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Calendar dataReceita = Calendar.getInstance();
			dataReceita.setTime(format.parse(request.getParameter("dataReceita")));

			Receita receita = new Receita(codigo, nome, valor, dataReceita);
			dao.atualizar(receita);

			request.setAttribute("msg", "Receita atualizada!");
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar!");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", "Por favor, Valide os dados");
		}
		listar(request, response);
	}

	private void excluir(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int codigo = Integer.parseInt(request.getParameter("codigo"));

		try {
			dao.remover(codigo);
			request.setAttribute("msg", "Receita removida!");
		} catch (DBException e) {
			e.printStackTrace();
			request.setAttribute("erro", "Erro ao remover!");
		}
		listar(request, response);
	}

}
