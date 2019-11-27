package com.pizza.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pizza.bean.Customer;
import com.pizza.bean.PizzaOrder;
import com.pizza.service.PizzaService;

/**
 * Servlet implementation class PizzaController
 */
@WebServlet("/PizzaController")
public class PizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rd;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PizzaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String u1=request.getParameter("cname");
		String u2=request.getParameter("caddress");
		String u3=request.getParameter("cmobile");
		String u4=request.getParameter("top");
		PizzaOrder order=new PizzaOrder();
		Customer cust=new Customer();
		cust.setCustName(u1);
		cust.setAddress(u2);
		cust.setPhone(u3);
		order.setTopup(u4);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		//System.out.println(dtf.format(now));  
		Random rand = new Random(); 
		int custid = rand.nextInt(1000); 
        int orderid = rand.nextInt(1000); 
        order.setCustomerId(custid);
        order.setOrderId(orderid);
       PizzaService service=new PizzaService();
       int i=service.placeOrder(cust,order);
       if(i==2)
		{
		out.println(order.getTopup());
			rd=request.getRequestDispatcher("/pages/PlaceOrder.jsp");
			rd.include(request, response);
			out.println("Order placed with orderid"+order.getOrderId());
			
		}
		/*else
		{
			rd=request.getRequestDispatcher("/EmployeeRegistration.html");
			rd.include(request, response);
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
