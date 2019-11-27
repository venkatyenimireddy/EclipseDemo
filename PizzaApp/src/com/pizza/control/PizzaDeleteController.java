package com.pizza.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.DAO.PizzaOrderDAO;

/**
 * Servlet implementation class PizzaDeleteController
 */
@WebServlet("/PizzaDeleteController")
public class PizzaDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String u1=request.getParameter("id");
		PizzaOrderDAO dao=new PizzaOrderDAO();
		int i= dao.deleteDetails(Integer.parseInt(u1));
		if(i==1)
			{
			
				rd=request.getRequestDispatcher("/OrderDelete.jsp");
				rd.include(request, response);
				out.println("Order deleted");
				
			}
			else
			{
				
				rd=request.getRequestDispatcher("/OrderDelete.jsp");
				rd.include(request, response);
				out.println("Order id not found");
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
