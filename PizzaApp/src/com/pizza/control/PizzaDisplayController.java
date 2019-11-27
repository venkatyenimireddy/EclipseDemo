package com.pizza.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.DAO.PizzaOrderDAO;
import com.pizza.bean.PizzaOrder;
import com.pizza.exception.PizzaException;

/**
 * Servlet implementation class PizzaDisplayController
 */
@WebServlet("/PizzaDisplayController")
public class PizzaDisplayController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaDisplayController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ArrayList<String> list=new ArrayList<String>();
		String u1=request.getParameter("id");
		PizzaOrderDAO dao=new PizzaOrderDAO();
		try {
		//	Customer p= dao.getOrderDetails(Integer.parseInt(u1));
			list= dao.getOrderDetails(Integer.parseInt(u1));
			request.setAttribute("Key",list);
		if(list==null)
		{
throw new PizzaException("order id not found");
				/*rd=request.getRequestDispatcher("/OrderDispaly.jsp");
				rd.include(request, response);
				out.println("order id not found");*/
		}		
		else
		{
			rd=request.getRequestDispatcher("/OrderDispaly.jsp");
			rd.include(request, response);
		}
				
} 
		catch (PizzaException e) {
			rd=request.getRequestDispatcher("/OrderDispaly.jsp");
			rd.include(request, response);
			out.println(e.getMessage());
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
