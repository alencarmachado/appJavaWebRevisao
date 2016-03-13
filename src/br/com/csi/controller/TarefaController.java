package br.com.csi.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
		
		
		
			Tarefa t = new Tarefa();
			TarefaDao tdao = new TarefaDao();
			
			String descricao = request.getParameter("descricao");
			
			if(request.getParameter("descricao") == null){
				
				System.out.println("primeiro acesso...");
				
			}else{
		
				System.out.println("descrição "+descricao);
				String finalizado = request.getParameter("finalizado");
				System.out.println("finalizado: "+finalizado);
				String dataEmTexto = request.getParameter("dataFinalizado");
				Calendar dataFinalizado = Calendar.getInstance();;
								
				try{
				java.util.Date data =	new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);			
				dataFinalizado.setTime(data);
					
				System.out.println("..data "+dataFinalizado.getTime().toString());
				
				}catch(Exception e){
					System.out.println("erro na conversão da data");
				}
				
				
				t.setDescricao(descricao);
				t.setDataFinalizacao(dataFinalizado);
				t.setFinalizado(false);
				
				tdao.adiciona(t);
				//request.setAttribute("tarefas", tdao.getTarefas());

				
			}
			
					response.sendRedirect("adiciona-tarefa.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
