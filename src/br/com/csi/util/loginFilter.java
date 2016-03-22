package br.com.csi.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class loginFilter
 */
@WebFilter("/*")
public class loginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public loginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("dentro do doFilter");

		//if(request.getSession().getAttribute("usuarioLogado") != null){
		//return true;
		//}
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		System.out.println("req.getRequestURI() .. "+req.getRequestURI());
		System.out.println("... "+req.getRequestURI().equals("/appJavaWebRevisao/index.jsp"));
		
		if(req.getSession().getAttribute("usuarioLogado") == null 
				&& !req.getRequestURI().equals("/appJavaWebRevisao/index.jsp") && !req.getRequestURI().equals("/appJavaWebRevisao/usuarioController")){
			// pass the request along the filter chain				 
			
			System.out.println("dentro do IF");
			RequestDispatcher rd = req.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
            return;
			
		} 
		chain.doFilter(request, response);	
		 
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
