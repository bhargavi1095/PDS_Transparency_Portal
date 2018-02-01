package com.dac.pds;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.dac.pojo.Allotment;
import com.dac.pojo.Consumption;
import com.dac.pojo.Manager;
import com.dac.pojo.stock_details; 
/**
 * Servlet implementation class allocate_stock
 */
@WebServlet("/allocate_stock")
public class allocate_stock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public allocate_stock() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession sess=request.getSession(); 
		String admin_id = (String) sess.getAttribute("id");
		if(admin_id==null){
			 RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
			  rd.forward(request, response);
		}
	String depot_name= request.getParameter("depotname");
	String rice=request.getParameter("rice");
	String wheat = request.getParameter("wheat");
	String oil = request.getParameter("oil");
	System.out.print(depot_name+rice+wheat+oil);
	int flag_r=0,flag_w=0,flag_o=0;
	if (rice.matches("[0-9]+")) {
	flag_r=1;
	}
	if (wheat.matches("[0-9]+") ) {
		flag_w=1;
		}
	if (oil.matches("[0-9]+")) {
		flag_o=1;
		}
	if(flag_r==0 || flag_w==0 || flag_o==0){
		 request.setAttribute("status", "Enter only digits in stock");
		  RequestDispatcher rd=request.getRequestDispatcher("admin_allocate_stock.jsp");  
		  rd.forward(request, response); 
	}
	
	else{
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time); 
		 int oil_add,old_oil,wheat_add,old_wheat,rice_add,old_rice;
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();    
		Allotment a = new Allotment();
		a.setAdmin_id(admin_id);
		a.setAllocation_id(ts.toString()+"_"+admin_id);
		a.setDepot_id(depot_name);
		a.setOil_stock(oil);
		a.setRice_stock(rice);
		a.setWheat_stock(wheat);
		a.setTimestamp(ts.toString());
		 session.beginTransaction();
		 session.save(a);
		 session.getTransaction().commit();
		 
		int month_current =date.getMonth()+1;
		 
		stock_details s = new stock_details(); 
		s.setAdmin_id(admin_id);
		s.setDepot_id(depot_name);
		s.setTimestamp(ts.toString());
		String stock_id = month_current+"_"+depot_name;
		s.setStock_id(stock_id);
		 String hql = "from stock_details WHERE stock_id= :stock_id";
			Query query = session.createQuery(hql);
			query.setParameter("stock_id", stock_id);
		  List<stock_details> results =(List<stock_details>) query.list(); 
		  int listCount = results.size();
		  if(listCount==0){
			  s.setOil_stock(oil);
			  s.setWheat_stock(wheat);
			  s.setRice_stock(rice);
			  session.beginTransaction();
			  session.save(s);
			
		  }   else{
	   for(stock_details m : results)
    {
		   
		   	  oil_add = Integer.parseInt(m.getOil_stock());
		   	  wheat_add = Integer.parseInt(m.getWheat_stock());
		   	  rice_add= Integer.parseInt(m.getRice_stock());
		   	  old_oil= Integer.parseInt(oil);
		   	  old_wheat=Integer.parseInt(wheat);
		   	  old_rice =Integer.parseInt(rice);
		   	oil_add+=old_oil;
		   	wheat_add+=old_wheat;
		   	rice_add+=old_rice;

			 // s.setOil_stock(Integer.toString(oil_add));
			 // s.setWheat_stock(Integer.toString(wheat_add));
			 // s.setRice_stock(Integer.toString(rice_add));
			 
		   	System.out.println("Stock id"+stock_id);
		    String hql1 = "UPDATE stock_details set oil_stock = :oil_add , wheat_stock =:wheat_add , rice_stock =:rice_add where stock_id = :stock_id";
			Query query1 = session.createQuery(hql1);
			query1.setParameter("stock_id", stock_id);
			  query1.setParameter("oil_add",Integer.toString(oil_add));
			  query1.setParameter("wheat_add",Integer.toString(wheat_add));
			  query1.setParameter("rice_add",Integer.toString(rice_add));
		
		   	session.getTransaction().begin();
			     query1.executeUpdate();
		 
    }
	   
  }
		  session.getTransaction().commit();
		
	////////ADD TO CONSUMPTION TABLE 
		  
		  
			Consumption c = new Consumption(); 
			c.setDepot_id(depot_name);
			c.setTimestamp(ts.toString());
			String consumption_id = month_current+"_"+depot_name;
			c.setConsumption_id(consumption_id);
			 String hql2 = "from Consumption WHERE consumption_id= :consumption_id";
				Query query2 = session.createQuery(hql2);
				query2.setParameter("consumption_id", consumption_id);
			  List<Consumption> results2 =(List<Consumption>) query2.list(); 
			  int listCount2 = results2.size();
			  if(listCount2==0){
				  c.setWheat_consumption(wheat);
				  c.setOil_consumption(oil);
				  c.setRice_consumption(rice);
				  session.beginTransaction();
				  session.save(c);
				
			  }   else{
		   for(Consumption l : results2)
	    {
			   
			   	  oil_add = Integer.parseInt(l.getOil_consumption());
			   	  wheat_add = Integer.parseInt(l.getWheat_consumption());
			   	  rice_add= Integer.parseInt(l.getRice_consumption());
			   	  old_oil= Integer.parseInt(oil);
			   	  old_wheat=Integer.parseInt(wheat);
			   	  old_rice =Integer.parseInt(rice);
			   	oil_add+=old_oil;
			   	wheat_add+=old_wheat;
			   	rice_add+=old_rice;

				 // s.setOil_stock(Integer.toString(oil_add));
				 // s.setWheat_stock(Integer.toString(wheat_add));
				 // s.setRice_stock(Integer.toString(rice_add));
				 
			    String hql3 = "UPDATE Consumption set oil_consumption = :oil_add , wheat_consumption =:wheat_add , rice_consumption =:rice_add where consumption_id = :consumption_id";
				Query query3 = session.createQuery(hql3);
				query3.setParameter("consumption_id", consumption_id);
				  query3.setParameter("oil_add",Integer.toString(oil_add));
				  query3.setParameter("wheat_add",Integer.toString(wheat_add));
				  query3.setParameter("rice_add",Integer.toString(rice_add));
			
			   	session.getTransaction().begin();
				     query3.executeUpdate();
			 
	    }
		   
	  }
			  session.getTransaction().commit();
			
			  
			  ///////////////////
		request.setAttribute("status", "Stock allocated successfully.");
		  RequestDispatcher rd=request.getRequestDispatcher("admin_allocate_stock.jsp");  
		  rd.forward(request, response); 
	
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
