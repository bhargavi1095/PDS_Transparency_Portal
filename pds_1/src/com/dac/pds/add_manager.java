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
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.dac.pojo.Depot;
import com.dac.pojo.Manager;
import com.dac.pojo.PDS_USERS;

/**
 * Servlet implementation class add_manager
 */
@WebServlet("/add_manager")
public class add_manager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_manager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String first_name = request.getParameter("firstname");
			String last_name = request.getParameter("lastname");
			String mobile = request.getParameter("mobile");
			String email = request.getParameter("email");
			String depot = request.getParameter("depot");

				int flag_1=0,flag_2=0;
	
	SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
	Session session=sessionFactory.openSession();    
	
	
	String hql = "from Manager WHERE manager_phone= :mobile";
	Query query = session.createQuery(hql);
	query.setParameter("mobile", mobile); 
  List<Manager> results1 =(List<Manager>)query.list(); 
  int listCount = results1.size();
  if(listCount!=0){
	  request.setAttribute("status", "Manager is already registered");
	  RequestDispatcher rd=request.getRequestDispatcher("admin_add_manager.jsp");  
	  rd.forward(request, response);
  }
  else{
	  flag_1=1;
  }
  
  	hql = "from Depot WHERE depot_id= :depot";
	 query = session.createQuery(hql);
	query.setParameter("depot", depot); 
List<Depot> results =(List<Depot>)query.list(); 
 listCount = results.size();
if(listCount==0){
	  request.setAttribute("status", "Depot ID is not Valid");
	  RequestDispatcher rd=request.getRequestDispatcher("admin_add_manager.jsp");  
	  rd.forward(request, response);
}
else{
	  flag_2=1;
}

if(flag_1==1 && flag_2==1){
	
	Manager m = new Manager() ; 
	  HttpSession session1 = request.getSession();
		String admin_id=(String) session1.getAttribute("id");  
		String manager_id = first_name+"_"+mobile;
		m.setAdmin_id(admin_id);
		m.setDepot_id(depot);
		m.setManager_email(email);
		m.setManager_first_name(first_name);
		m.setManager_last_name(last_name);
		m.setManager_phone(mobile);
		m.setManager_id(manager_id);
		m.setManager_password("fish");

		  session.beginTransaction();
		  session.save(m);
		  session.getTransaction().commit(); 
		
		  request.setAttribute("status", "Manager Successfully Added");
		  RequestDispatcher rd_3=request.getRequestDispatcher("admin_add_manager.jsp");  
		  rd_3.forward(request, response);
		
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
