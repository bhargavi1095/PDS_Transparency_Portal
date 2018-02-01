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

import com.dac.pojo.*;

/**
 * Servlet implementation class Valide_User
 */
@WebServlet("/Valide_User")
public class Valide_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Valide_User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
response.setContentType("text/html");
		
		//PrintWriter out = response.getWriter();
		
		String AadharNumber = request.getParameter("uid");
		
		SessionFactory sessionFactory =new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		String hql = "from PDS_USERS WHERE aadhaar_id=:AadharNumber";
		
		
		Query query = session.createQuery(hql);
		
		query.setParameter("AadharNumber", AadharNumber);
		
		List<PDS_USERS> results = (List<PDS_USERS>) query.list();
		
		int listCount = results.size();
		if(listCount==1) {
			request.setAttribute("uid", "VALID");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("home_index.jsp");
			dispatcher.forward(request, response);
			
		 /*	for(pds_users u:results) {
				
				//out.println(u.getAadhaar_id()+u.getCategory()+u.getMobile_no()+u.getRation_id()+u.getDepot_id());
		}*/
		}	
		else {
			request.setAttribute("uid", "INVALID");
 
			RequestDispatcher dispatcher = request.getRequestDispatcher("home_index.jsp");
			dispatcher.forward(request, response);
			
		} 
		
		//out.println(hql);
		
			session.close();

		
	}

}
