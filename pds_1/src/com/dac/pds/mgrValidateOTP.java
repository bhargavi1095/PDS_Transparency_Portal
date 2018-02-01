package com.dac.pds;

import java.io.IOException;
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

import com.dac.pojo.USER_REQUESTS;

/**
 * Servlet implementation class mgrValidateOTP
 */
@WebServlet("/mgrValidateOTP")
public class mgrValidateOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mgrValidateOTP() {
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
		
		// getting the OTP entered from Form
		String rcvdOTP =  request.getParameter("inputOTP");
		
		String verify_request = rcvdOTP;
		
		// fetching result from user_requests where OTP matches
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();  
		String hql = "from USER_REQUESTS WHERE verify_request= :verify_request ";
		Query query = session.createQuery(hql);
		query.setParameter("verify_request", verify_request);
		
		
		
		List<USER_REQUESTS> results =((List<USER_REQUESTS>) query.list()); 
		int listCount = results.size();
		System.out.println(listCount);
	  
		String OTP="";
		String ration_id="";
		// validating OTP ,if match found in database and storing it in OTP variable
		if(listCount!=0){
			for(USER_REQUESTS a : results)
		    {
				 OTP = a.getVerify_request();
				 ration_id = a.getRation_id();
		    }
		}
		
		// if OTP is valid and matches
		if(rcvdOTP.equals(OTP)){
			
			// forwarding to check the stock allocation acc. to category
			request.setAttribute("ration_id", ration_id);
			RequestDispatcher rd2 = request.getRequestDispatcher("/mgrStock");
			rd2.forward(request, response);
		}
		// if OTP is entered wrong
		else
		{   
			// again redirecting to validate page
			request.setAttribute("error", "invalid OTP");
			RequestDispatcher rd2 = request.getRequestDispatcher("mgr_ValidateOTP.jsp");
			rd2.forward(request, response);
		}
		
		// closing session and sessionFactory
		session.close();
		sessionFactory.close();
		}
		
	

}
