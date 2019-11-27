package com.pizza.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.pizza.bean.Customer;
import com.pizza.bean.PizzaOrder;
import com.pizza.exception.PizzaException;

interface Pizzaorder
{
	  int placeOrder(Customer customer,PizzaOrder pizza);
	//Customer getOrderDetails(int orderid)throws PizzaException;
	  ArrayList<String> getOrderDetails(int orderid) throws PizzaException;
	 int deleteDetails(int orderid);
	 int setOrderDetails(String a,String b,int c1);
}
public class PizzaOrderDAO implements Pizzaorder  {
	

		public int placeOrder(Customer customer,PizzaOrder pizza)
		{
			Connection c=null;
			Statement stmt=null;
			int i=0,j=0;
			//ResultSet rs=null;
			try
			{
				c=MySqlConn.getCon();
				stmt=c.createStatement();

				i=stmt.executeUpdate("insert into customer values("+pizza.getCustomerId()+",'"
						+customer.getCustName()+"','"+customer.getAddress()+"',"+customer.getPhone()+","+pizza.getOrderId()+")");
				j=stmt.executeUpdate("insert into orderdetails values("+pizza.getOrderId()+","
						+pizza.getTotalPrice()+")");
		

			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			return i+j;

		}
		public ArrayList<String> getOrderDetails(int orderid) throws PizzaException

		{
			/*Customer pz=new Customer();
			PizzaOrder po=new PizzaOrder();*/
			Connection c=null;
			Statement stmt=null;
			ResultSet rs=null;
			ArrayList<String> list=new ArrayList<String>();
			try
			{
				c=MySqlConn.getCon();
				stmt=c.createStatement();
				
				rs=stmt.executeQuery("select * from customer where orderid="+orderid);
			
				if(rs.next())
				{
					
					/*po.setCustomerId(rs.getInt(1));
					pz.setCustName(rs.getString(2));
                       pz.setAddress(rs.getString(3));
                       //pz.setPhone((String)(rs.getLong(4)));
                       po.setOrderId(rs.getInt(5));*/
                       list.add(Integer.toString((rs.getInt(1))));//Adding object in arraylist    
                       list.add(rs.getString(2));    
                       list.add(rs.getString(3));    
                       list.add(Long.toString((rs.getInt(4))));    
                       
				}
				else{
					throw new PizzaException("Order id not found")	;
				}
				rs=stmt.executeQuery("select price from orderdetails where orderid="+orderid);
				
			
				while(rs.next())
				{
					//po.setTotalPrice(rs.getInt(1));
					list.add(Integer.toString((rs.getInt(1))));
				}	
					
			
				
			}
			catch (Exception e)
			{
				list=null;
			}
			
			
			return list;
		}
		/*public PizzaOrder getOrderDetails1(int orderid) throws PizzaException

		{
			Customer pz=new Customer();
			PizzaOrder po=new PizzaOrder();
			Connection c=null;
			Statement stmt=null;
			ResultSet rs=null;
			try
			{
				c=MySqlConn.getCon();
				stmt=c.createStatement();
				rs=stmt.executeQuery("select price from orderdetails where orderid="+orderid);
				if(rs.next())
				{
				rs=stmt.executeQuery("select price from orderdetails where orderid="+orderid);
				
				while(rs.next())
				{
					po.setTotalPrice(rs.getInt(1));
				}	
					
					}
				else{
					throw new PizzaException("Order id not found")	;
				}
				
			}
			catch (SQLException e)
			{
				System.out.println("order not found");;
			}
			finally
			{
				try {
					c.close();
					stmt.close();
					rs.close();
					//rs1.close();
				} catch (SQLException e) {
					e.printStackTrace();

				}
			}
			return po;
		}*/
		public int deleteDetails(int orderid){
			Connection c=null;
			Statement stmt=null;
			ResultSet rs=null;
			int i=0;
			try
			{
				c=MySqlConn.getCon();
				stmt=c.createStatement();


			i=stmt.executeUpdate("delete from customer where orderid="+orderid);
				
			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			return i;
		}	

		public int setOrderDetails(String a,String b,int c1)
		{
			Connection c=null;
			Statement stmt=null;
			ResultSet rs=null;
			int i=0;
			try
			{
				c=MySqlConn.getCon();
				stmt=c.createStatement();

			 i=stmt.executeUpdate("update customer set cname='"+a+"',caddress='"+b+"' where orderid="+c1);

				/*rs=stmt.executeQuery("select * from customer where orderid="+c1);
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+"    "+rs.getString(2)+"    "+rs.getString(3)+"     "+rs.getLong(4)+"  "+rs.getInt(5));
				}*/

			}
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			return i;
		}
}

