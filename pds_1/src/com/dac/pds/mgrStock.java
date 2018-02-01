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

import com.dac.pojo.USER_REQUESTS;


/**
 * Servlet implementation class mgrStock
 */
@WebServlet("/mgrStock")
public class mgrStock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mgrStock() {
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
		
		// getting ration_id from request
		String ration_id = (String) request.getAttribute("ration_id");
		
		// fetching data from USER_REQUESTS table based on ration_id
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();  
		String hql = "from USER_REQUESTS WHERE ration_id= :ration_id ";
		Query query = session.createQuery(hql);
		query.setParameter("ration_id", ration_id);
		
		
		
		List<USER_REQUESTS> results =((List<USER_REQUESTS>) query.list()); 
		int listCount = results.size();
		String category="";
		String aadhaar="";
		
		// if result found then getting the category from result
		if(listCount!=0){
			for(USER_REQUESTS a : results)
		    {
				 
				 category = a.getCategory();
				 aadhaar = a.getAadhaar_id();
		    }
		}
		// if no result found
		else{
			
			// again redirecting to new request page
			request.setAttribute("error", "your request has not been generated");
			RequestDispatcher rd2 = request.getRequestDispatcher("mgr_new_req.jsp");
			rd2.forward(request, response);
		}
		
		// creating session variable ration_id
		HttpSession sess=request.getSession();  
	       sess.setAttribute("SRation",ration_id);
	       sess.setAttribute("aadhaar", aadhaar);
		
	       
	    // if category is APL then ssetting quantity for wheat,rice and oil to be allocated   
		if(category.equals("APL")){
		request.setAttribute("category", "APL");	
		request.setAttribute("wheat", "1");
		request.setAttribute("rice", "1");
		request.setAttribute("oil", "1");
		
		// and forwarding to allocate page
		RequestDispatcher rd2 = request.getRequestDispatcher("mgr_Allocate.jsp");
		rd2.forward(request, response);
		}
		
		// if category is BPL then ssetting quantity for wheat,rice and oil to be allocated
		if(category.equals("BPL")){
			request.setAttribute("category", "BPL");
			request.setAttribute("wheat", "2");
			request.setAttribute("rice", "2");
			request.setAttribute("oil", "2");
			
			// and forwarding to allocate page
			RequestDispatcher rd2 = request.getRequestDispatcher("mgr_Allocate.jsp");
			rd2.forward(request, response);
			}
		
			
	}

}
