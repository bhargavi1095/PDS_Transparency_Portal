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

import com.dac.pojo.Aadhaar;
import com.dac.pojo.Administrator;
import com.dac.pojo.PDS_USERS;
import com.dac.pojo.Ration;

/**
 * Servlet implementation class add_user
 */
@WebServlet("/add_user")
public class add_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public add_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			int flag_1=0;
			int flag_2=0;
			int flag_3=0;
			String aadhaar= request.getParameter("aadhaar");
			String ration = request.getParameter("ration");
			String mobile_no="",category="",user_status="",depot_id=""; 
			
			SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();    
			
			
			String hql = "from PDS_USERS WHERE aadhaar_id= :aadhaar_id";
			Query query = session.createQuery(hql);
			query.setParameter("aadhaar_id", aadhaar); 
		  List<PDS_USERS> results1 =(List<PDS_USERS>)query.list(); 
		  int listCount = results1.size();
		  PrintWriter out = response.getWriter();
		  if(listCount!=0){
			  request.setAttribute("status", "User is already registered");
			  RequestDispatcher rd=request.getRequestDispatcher("admin_add_pds.jsp");  
			  rd.forward(request, response);
		  }
		  else{
			  flag_3=1;
		  }
		  
		  
			 hql = "from Aadhaar WHERE aadhaar_id= :aadhaar_id";
			 query = session.createQuery(hql);
			query.setParameter("aadhaar_id", aadhaar); 
		  List<Aadhaar> results =(List<Aadhaar>)query.list(); 
		   listCount = results.size(); 
		  if(listCount==0){
			  request.setAttribute("status", "Aadhaar Id does not Exists");
			  RequestDispatcher rd=request.getRequestDispatcher("admin_add_pds.jsp");  
			  rd.forward(request, response);
		  }
		  else{
			  flag_1=1;
		  }
		  
		  
			String hql_2 = "from Ration WHERE ration_id= :ration";
			Query query_2 = session.createQuery(hql_2);
			query_2.setParameter("ration", ration); 
		  List<Ration> results_2 =(List<Ration>)query_2.list(); 
		  int listCount_2 = results_2.size();
		  if(listCount_2==0){
			  request.setAttribute("status", "Ration Id does not Exists");
			  RequestDispatcher rd_2=request.getRequestDispatcher("admin_add_pds.jsp");  
			  rd_2.forward(request, response);
		  }
		  else{
			  flag_2=1;
		  }
		  System.out.println(flag_1+"----"+flag_2);
		  if(flag_1==1 && flag_2==1 && flag_3==1){
			  user_status="1";
			  System.out.println("VALID");
			  for(Aadhaar a : results)
			    {
				  	mobile_no=a.getMobile_no();
			    }
			  for(Ration r : results_2){
				  category = r.getCategory();
				  depot_id = r.getDepot_id();
			  }
			  HttpSession session1 = request.getSession();
				String admin_id=(String) session1.getAttribute("id");  
			  String pds_id = aadhaar+"_"+ration;
			  
			  PDS_USERS pds_users = new PDS_USERS();
			  pds_users.setAadhaar_id(aadhaar);
			  pds_users.setCategory(category);
			  pds_users.setDepot_id(depot_id);
			  pds_users.setManager_id(admin_id);
			  pds_users.setPds_id(pds_id);
			  pds_users.setMobile_no(mobile_no);
			  pds_users.setRation_id(ration);
			  pds_users.setUser_status(user_status);
			 
			  
			  session.beginTransaction();
			  session.save(pds_users);
			  session.getTransaction().commit(); 
			
			  request.setAttribute("status", "User Successfully Added");
			  RequestDispatcher rd_3=request.getRequestDispatcher("admin_add_pds.jsp");  
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
