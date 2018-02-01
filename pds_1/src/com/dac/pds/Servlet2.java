package com.dac.pds;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.json.JSONArray;
import org.json.JSONObject;

import com.dac.pojo.Consumption;
import com.dac.pojo.Depot;
import com.dac.pojo.stock_details;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("!!111");
		String state=request.getParameter("stat");
		JSONObject jo1 = new JSONObject();
		   JSONObject jo2 = new JSONObject();
		   JSONObject jo3 = new JSONObject();
		   JSONArray ja = new JSONArray();
			
		 	System.out.println("!!"+state);
		 	JSONObject mainObj = new JSONObject();
		 	SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();    
			
			 String oil="0",rice="0",wheat="0";
			String hql = "from Consumption where depot_id=:depot"; 
				Query query = session.createQuery(hql); 
				query.setString("depot", state);
				List<Consumption> results = new ArrayList<Consumption>();
			  results =(List<Consumption>) query.list(); 
			  int listCount = results.size();
			  if(listCount==0){ 
				 oil="0";
				 rice="0";
				 wheat="0";
				 
			  }   else{
				  for(Consumption m : results)
				  {
					  oil=m.getOil_consumption();
					  rice=m.getRice_consumption();
					  wheat=m.getWheat_consumption();
				  }
			  }
				 
				  try{
					
					  jo1.put("id", oil); 
					ja.put(jo1);  	
					jo2.put("id", rice); 
					ja.put(jo2);  	
					jo3.put("id", wheat); 
					ja.put(jo3);
					mainObj.put("pro", ja);
					//System.out.println("!!!"+mainObj.toString());
					  System.out.println(oil+wheat+rice);
					  response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
					    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
					    response.getWriter().write(mainObj.toString());  
					  
				  }catch(Exception e ) {
					  System.out.println("error");
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
