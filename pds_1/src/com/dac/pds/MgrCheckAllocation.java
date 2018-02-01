package com.dac.pds;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
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
import com.dac.pojo.USER_REQUESTS;

/**
 * Servlet implementation class MgrCheckAllocation
 */
@WebServlet("/MgrCheckAllocation")
public class MgrCheckAllocation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MgrCheckAllocation() {
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
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();
		HttpSession sess=request.getSession();  
	    //sess.setAttribute("SAadhaar",se);
	    
		
		// getting ration id from request
		String ration_id = (String) request.getAttribute("ration_id");
		
		// checking ration_id in user_requests table
		String hql = "from USER_REQUESTS WHERE ration_id= :ration_id ";
		Query query = session.createQuery(hql);
		query.setParameter("ration_id", ration_id);
		
		List<USER_REQUESTS> results =((List<USER_REQUESTS>) query.list()); 
		int listCount = results.size();
		
		String allocated="";
		String time="";
		String aadhaar="";
		
		// checking alloted stock or not when result is found
		if(listCount!=0){
			for(USER_REQUESTS a : results)
		    {
				allocated = a.getAllocated();
				time = a.getTimestamp();
				aadhaar = a.getAadhaar_id();
		    }
			
			// splitting the timestamp received from the user_requests table
			String[] result = time.split("-");
			
			// getting current system date
			Date date = new Date();
			LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int month = localDate.getMonthValue();
			int year = localDate.getYear();
			
			
			
			int rcvdYear = Integer.parseInt(result[0]);
			int rcvdMonth = Integer.parseInt(result[1]);
			System.out.println("res"+" "+rcvdYear+" "+rcvdMonth);
			
			
			// checking if stock is already allocated or not for present month and year
			
			// if stock allocated already
			if(allocated.equals("1")&&month==rcvdMonth&&year==rcvdYear){
			request.setAttribute("error", "already ration supplied for this month: "+month+" "+"and year: "+year);
			RequestDispatcher rd2 = request.getRequestDispatcher("mgr_new_req.jsp");
			rd2.forward(request, response);
			}
			else{
				
				// if not allocated then forwarding to generate OTP
				// creating session variable for aadhaar_id
				System.out.println(sess.getAttribute("SAadhaar"));
				 
			    RequestDispatcher rd2 = request.getRequestDispatcher("mgr_GenerateOTP.jsp");
				rd2.forward(request, response);
			 
			}
		}
		else{
			// if not allocated and new request , forwarding to generate OTP
			request.setAttribute("ration_id", ration_id);
			// setting session variable for aadhaar_id
			  sess=request.getSession();  
		   //    sess.setAttribute("SAadhaar",aadhaar);
			RequestDispatcher rd2 = request.getRequestDispatcher("mgr_GenerateOTP.jsp");
			rd2.forward(request, response);
		}
		// closing session and sessionFactory
		session.close();
		sessionFactory.close();
	}

}
