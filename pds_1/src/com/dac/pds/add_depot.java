package com.dac.pds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.dac.pojo.Depot;

/**
 * Servlet implementation class add_depot
 */
@WebServlet("/add_depot")
public class add_depot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_depot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		
		String name= request.getParameter("name");
		String depot_id = request.getParameter("depot_id");
		String district = request.getParameter("district");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();    
		
		String hql = "from Depot WHERE depot_id= :depot_id";
		Query query = session.createQuery(hql);
		query.setParameter("depot_id", depot_id); 
	  List<Depot> results =(List<Depot>)query.list(); 
	  int listCount = results.size();
	   if(listCount!=0){
		  request.setAttribute("status", "Depot Id already Exists");
		  RequestDispatcher rd=request.getRequestDispatcher("admin_add_depot.jsp");  
		  rd.forward(request, response);
	  
	  }
	  else{ 
		  Depot d = new Depot();
		  d.setDepot_city(city);
		  d.setDepot_district(district);   
		  d.setDepot_id(depot_id);
		  d.setDepot_name(name);
		  d.setDepot_state(state);
		  session.beginTransaction();
		  session.save(d);
		  session.getTransaction().commit();
		  request.setAttribute("status", "Depot sucessfully added");
		  RequestDispatcher rd=request.getRequestDispatcher("admin_add_depot.jsp");  
		  rd.forward(request, response);
	  }
		session.close(); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
