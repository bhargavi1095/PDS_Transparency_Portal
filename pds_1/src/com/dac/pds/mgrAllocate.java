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

import com.dac.pojo.Consumption;
import com.dac.pojo.PDS_USERS;
import com.dac.pojo.USER_REQUESTS; 

/**
 * Servlet implementation class mgrAllocate
 */
@WebServlet("/mgrAllocate")
public class mgrAllocate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mgrAllocate() {
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
		
		
		// getting ration_id from session variable
		HttpSession sess=request.getSession(false);  
        String ration_id = sess.getAttribute("SRation").toString();
        String aadhaar = sess.getAttribute("aadhaar").toString();
		
        
        // getting requested amount of stock from the allocation form
		int reqWheat = Integer.parseInt(request.getParameter("wheat"));
		int reqRice = Integer.parseInt(request.getParameter("rice"));
		int reqOil = Integer.parseInt(request.getParameter("oil"));
		
		
		
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();  
		
		// to get depot_id from pds_users
		String hql = "from PDS_USERS WHERE aadhaar_id= :aadhaar_id ";
		Query query = session.createQuery(hql);
		query.setParameter("aadhaar_id", aadhaar);
		
		List<PDS_USERS> results =(List<PDS_USERS>) query.list(); 
		  int listCount = results.size();
		  
		  String depot="";
		  String pds="",ration="",mobile="",category="",depotId="";
		
		  // if result found then getting all the details from pds_users table
		  if(listCount>0){  
		  		    for(PDS_USERS u : results)
			    {
		  		    	pds = u.getPds_id();
		  		    	
		  		    	ration = u.getRation_id();
		  		    	mobile = u.getMobile_no();
		  		    	category = u.getCategory();
		  		    	depotId = u.getDepot_id();
		  		    	depot = u.getDepot_id();
		  		    	
			    }
		  		    
		  		    System.out.println("depot getting from pds"+depot);
		  }
		  
		  // if no result found
		  else{
			  
			  // again redirecting to allocate page
			  request.setAttribute("error", "no such data found");
				RequestDispatcher rd2 = request.getRequestDispatcher("mgr_Allocate.jsp");
				rd2.forward(request, response);
		  	   }
		  	  
		  //////////////////////////////////////////////////////////////////////////////////
		// to get Consumption table's data  
		  //////////////////////////////////////////////////////////////////////////////////
		
		  System.out.println("depot in consumption"+depot);
		  
		  String hql1 = "from Consumption WHERE depot_id= :depot ";
		Query query1 = session.createQuery(hql1);
		query1.setParameter("depot", depot);
		
		
		
		
		List<Consumption> result1 =((List<Consumption>) query1.list()); 
		int listCount1 = result1.size();
		int wheat=0,rice=0,oil=0;
		
		// if result found 
		if(listCount1!=0){
			for(Consumption a : result1)
		    {
				 wheat = Integer.parseInt(a.getWheat_consumption());
				 rice = Integer.parseInt(a.getRice_consumption());
				 oil = Integer.parseInt(a.getOil_consumption());
				 
		    }
		}
		else{
			
			// if consumption table is empty, redirecting back to allocation page
			request.setAttribute("error", "stock not granted to your depot");
			RequestDispatcher rd2 = request.getRequestDispatcher("mgr_Allocate.jsp");
			rd2.forward(request, response);
		}
		
		// getting values to be updated after allocation
		int oilReduce=0,wheatReduce=0,riceReduce=0;
		oilReduce+=oil-reqOil;
	   	wheatReduce+=wheat-reqWheat;
	   	riceReduce+=rice-reqRice;
		String oil_sub="",wheat_sub="",rice_sub="";
		
		oil_sub = Integer.toString(oilReduce);
		wheat_sub = Integer.toString(wheatReduce);
		rice_sub = Integer.toString(riceReduce);
	   	
	   	
		
		
		
		
		// when consumption table has stock and not updated prior to this
		
		
				if(wheat>0 && rice>0 && oil>0){
					if(reqWheat<=wheat && reqRice<=rice && reqOil<=oil){
						
						
						String hql4 = "from USER_REQUESTS WHERE ration_id= :ration_id ";
						Query query4 = session.createQuery(hql4);
						query4.setParameter("ration_id", ration);
						
						List<USER_REQUESTS> results1 =((List<USER_REQUESTS>) query4.list()); 
						int listCount4 = results1.size();
						
						String alloc="";
						
						
						// checking alloted stock or not when result is found
						if(listCount4!=0){
							for(USER_REQUESTS a : results1)
						    {
								alloc = a.getAllocated();
								
						    }
						
						
						
						
						
						
						
						
						
						
						
						// if stock can be allocated then updating consumption table
						//////////////////////////////////////////////////////////
							
							if(alloc.equals("0")){
								
							
						String hql3 = "UPDATE Consumption set oil_consumption = :oil_sub,"+
						"wheat_consumption =:wheat_sub,"+"rice_consumption = :rice_sub"+
								" where depot_id = :depot";
						Query query3 = session.createQuery(hql3);
						query3.setParameter("depot", depot);
						  query3.setParameter("oil_sub",oil_sub);
						  query3.setParameter("wheat_sub",wheat_sub);
						  query3.setParameter("rice_sub",rice_sub);
					
					   	
						  // checking if update query was successful or not
						int result = query3.executeUpdate();
						
						if(result==1){
							String allocated = "1";
							
						
							// if allocation and updation successful then in user_requests marking allocated as true/1
							String hql2 = "UPDATE USER_REQUESTS set allocated = :allocated"+
							" WHERE ration_id = :ration_id";
							Query query2 = session.createQuery(hql2);
							query2.setParameter("ration_id", ration_id);
							query2.setParameter("allocated", allocated);
							
							int res = query2.executeUpdate();
						
						
						}
						
						
		
						// forwarding further request to generate Receipt by setting the request attribute						
						request.setAttribute("pds", pds);
						request.setAttribute("aadhaar", aadhaar);
						request.setAttribute("ration", ration);
						request.setAttribute("mobile", mobile);
						request.setAttribute("category", category);
						request.setAttribute("depot", depotId);
						
						request.setAttribute("error", "stock allocation successful");
						request.setAttribute("wheat", Integer.toString(reqWheat));
						request.setAttribute("rice", Integer.toString(reqRice));
						request.setAttribute("oil", Integer.toString(reqOil));
						
						RequestDispatcher rd2 = request.getRequestDispatcher("mgr_GenReceipt.jsp");
						rd2.forward(request, response);
							}
							else{
								
								
								request.setAttribute("pds", pds);
								request.setAttribute("aadhaar", aadhaar);
								request.setAttribute("ration", ration);
								request.setAttribute("mobile", mobile);
								request.setAttribute("category", category);
								request.setAttribute("depot", depotId);
								
								request.setAttribute("error", "stock allocation successful");
								request.setAttribute("wheat", Integer.toString(reqWheat));
								request.setAttribute("rice", Integer.toString(reqRice));
								request.setAttribute("oil", Integer.toString(reqOil));
								request.setAttribute("error", "this request has already been submitted");	
								RequestDispatcher rd2 = request.getRequestDispatcher("mgr_GenReceipt.jsp");
								rd2.forward(request, response);
							}
						
							}
		
						}
					
	
					else{
						
						// if requested resources are higher than present in the consumption table
						
						request.setAttribute("error", "this request can not be fulfilled due to low resources");
						RequestDispatcher rd2 = request.getRequestDispatcher("mgr_Allocate.jsp");
						rd2.forward(request, response);
					}
	}
				else{
					// when consumption table is empty
					request.setAttribute("error", "your stock is empty");
					RequestDispatcher rd2 = request.getRequestDispatcher("mgr_Allocate.jsp");
					rd2.forward(request, response);
				}
		
				
}	
	}


