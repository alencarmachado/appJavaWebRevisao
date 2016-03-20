package br.com.csi.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.csi.dao.TarefaDao;
import br.com.csi.modelo.Tarefa;

/**
 * Servlet implementation class TarefaController
 */
@WebServlet("/tarefaController")
public class TarefaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TarefaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
			TarefaDao tdao = new TarefaDao();		
			String descricao = request.getParameter("descricao");
			String id = request.getParameter("id");
			String buscarTarefa = request.getParameter("buscarTarefa");
			
			RequestDispatcher dispatcher;
			String pagina = "/adiciona-tarefa.jsp";
			
			if(request.getParameter("id") != null && request.getParameter("buscarTarefa") != null){
				System.out.println("alterar ... ID = "+id);
				
				request.setAttribute("tarefa", tdao.getTarefa(Long.parseLong(id)));
				request.setAttribute("tarefas", tdao.getTarefas());
				dispatcher= getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request,response);
				
			}else if(request.getParameter("id") == null && request.getParameter("descricao") == null){
				
				System.out.println("primeiro acesso...");											
				
				request.setAttribute("tarefas", tdao.getTarefas());
				dispatcher= getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request,response);
								
				
			}else if (request.getParameter("descricao") != null){
				
				System.out.println("descrição "+descricao);
				String id_alterar = request.getParameter("id_alterar");
				
				String finalizado = request.getParameter("finalizado");
				System.out.println("finalizado: "+finalizado);
				
				String dataEmTexto = request.getParameter("dataFinalizacao");
				System.out.println("Data.........: "+dataEmTexto);
				
				Calendar dataFinalizado = Calendar.getInstance();;
								
				try{
				java.util.Date data =	new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);			
				dataFinalizado.setTime(data);
													
				Tarefa t = new Tarefa();
				t.setId(Long.parseLong(id_alterar));
				t.setDescricao(descricao);
				t.setDataFinalizacao(dataFinalizado);
				t.setFinalizado(Boolean.parseBoolean(finalizado));
				
				tdao.adiciona(t);

				}catch(Exception e){
					e.printStackTrace();
				}
				request.setAttribute("tarefas", tdao.getTarefas());
				dispatcher= getServletContext().getRequestDispatcher(pagina);
				dispatcher.forward(request,response);
			}
			
					
	}

	 
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
