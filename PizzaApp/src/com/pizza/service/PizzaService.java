package com.pizza.service;

import com.pizza.DAO.PizzaOrderDAO;
import com.pizza.bean.Customer;
import com.pizza.bean.PizzaOrder;

interface Service
{
	int placeOrder(Customer customer,PizzaOrder pizza);
}
public class PizzaService implements Service {
	PizzaOrderDAO dao=new PizzaOrderDAO();
	int i=0;
		public int placeOrder(Customer customer,PizzaOrder pizza)
		{
			
			if(pizza.getTopup().equals("Mushroom"))
			{
				double p=400;
				pizza.setTotalPrice(p);
				 i= dao.placeOrder(customer, pizza);
				
			}
			else if(pizza.getTopup().equals("Capsicum"))
			{
				double p=380;
				pizza.setTotalPrice(p);
				  i= dao.placeOrder(customer, pizza);
			}
			else if(pizza.getTopup().equals("Paneer"))
			{
				double p=390;
				pizza.setTotalPrice(p);
				 i= dao.placeOrder(customer, pizza);
			}
			else 
			{
				double p=500;
				pizza.setTotalPrice(p);
				 i= dao.placeOrder(customer, pizza);
			}
			
			
			return i;
			
		}


}
