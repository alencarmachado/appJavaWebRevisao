package br.com.csi.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.csi.modelo.*;
import br.com.csi.dao.*;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		Usuario us = new Usuario();
		us.setLogin(login);
		us.setSenha(senha);
		
		UsuarioDao uDao = new UsuarioDao();
		boolean logado = false;
		try{
			 logado = uDao.logado(us);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		RequestDispatcher dispatcher;			 
		
		if(logado){
		
			String pagina = "/WEB-INF/jsp/principal.jsp";		
			request.getSession().setAttribute("usuarioLogado",us);			
			dispatcher= getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request,response);
			System.out.println("logado");
		}else{
			
			String pagina = "/index.jsp";
			request.setAttribute("msg", "Usuário ou Senha inválidos");
			dispatcher= getServletContext().getRequestDispatcher(pagina);
			dispatcher.forward(request,response);
			System.out.println("NAO LOGADO ....");
		}
	
	
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
