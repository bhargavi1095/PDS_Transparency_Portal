package com.dac.pds;

import java.io.IOException;
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

import com.dac.pojo.Administrator;
import com.dac.pojo.Manager;
import com.dac.pojo.PDS_USERS;
import com.dac.pojo.USER_REQUESTS;


/**
 * Servlet implementation class NewRequest
 */
@WebServlet("/NewRequest")
public class NewRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRequest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		// getting aadhaar id from form
		String aadhaar_id = request.getParameter("inputAadhaar");
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();  
	
			// checking aadhaar valid or not from PDS_USERS	table
			String hql = "from PDS_USERS WHERE aadhaar_id= :aadhaar_id ";
			Query query = session.createQuery(hql);
			query.setParameter("aadhaar_id", aadhaar_id);
			
			// getting result of query in the list
		  List<PDS_USERS> results =(List<PDS_USERS>) query.list(); 
		  int listCount = results.size();
		  
		  // if no result found
		  if(listCount==0){
			  //User not valid and forwarding to the new request page again
			  request.setAttribute("error", "No valid data found");
			  RequestDispatcher rd=request.getRequestDispatcher("mgr_new_req.jsp");  
			  rd.forward(request, response);
			  session.close();
		  		}  
		  
		  else{

				HttpSession sess=request.getSession();  
			    sess.setAttribute("SAadhaar",aadhaar_id);
			   
			  // checking allocation if for this month and year allocation already done
			   String ration_id="";
			  for(PDS_USERS a : results)
			    {
				  ration_id = a.getRation_id();
				  
			    }
			  
			  // forwarding request to Check Allocation 
			  request.setAttribute("ration_id", ration_id);
			  RequestDispatcher rd=request.getRequestDispatcher("MgrCheckAllocation");  
			  rd.forward(request, response);
			   
			  
			  
			  session.close();  
			  
		  	}
			    
		  
	}
	
}
	

	



