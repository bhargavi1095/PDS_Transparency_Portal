package com.dac.pds;

import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.sql.Timestamp;

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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.dac.pojo.Administrator;
import com.dac.pojo.Consumption;
import com.dac.pojo.Depot;
import com.dac.pojo.stock_details;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubS
		try {
			String state=request.getParameter("state");
			if(state==null){
				state="Karnataka";
				 
			}
		
			int delhi=0,tamil=0,kar=0,bihar=0;
			
			   JSONObject mainObj = new JSONObject();
		
			List<String> arr = new ArrayList<String>();
			SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
			Session session=sessionFactory.openSession();    
			
			
			String hql = "from Depot"; 
				Query query = session.createQuery(hql); 
				List<Depot> results = new ArrayList<Depot>();
			  results =(List<Depot>) query.list(); 
			  int listCount = results.size();
			  if(listCount==0){ 
				 
			  }   else{
		   for(Depot m : results)
	    {
			   boolean contains = Arrays.asList(arr).contains(m.getDepot_state());
			   if(!contains){
				   arr.add(m.getDepot_state());
			   }
	    }
		
		 /*
		   JSONArray ja = new JSONArray();
			   JSONObject d = new JSONObject();
			   JSONObject b = new JSONObject();
			   JSONObject t = new JSONObject();
			   JSONObject k = new JSONObject();
			   JSONObject jo = new JSONObject();
			   */		
		long c1=21,c2 =1212,c3=1212,c4=11; 
		String s1="21",s2 ="1212",s3="1212",s4="11"; 
		
		for(String f : arr){ 

			   Query query_1 = session.createQuery(
				        "select count(*) from Depot  where state=:state");
			   query_1.setString("state", f);
				Long count = (Long)query_1.uniqueResult();
				
			   if(f==null){}
			   
			   else{
				   if(f.equals("Delhi")){
				
					  if(delhi!=1){
					  c1= count;
					  s1=f;
					  delhi=1;

						System.out.println("d"+c1);
						//mainObj.put("pro", ja);
				  }
			   }
			    if(f.equals("Bihar")){
				  if(bihar!=1){

					  c2= count;  
					  s2=f;
					  bihar=1;

						System.out.println("b"+c2);
						//mainObj.put("pro", ja);
				  }
			   }
			     if(f.equals("Karnataka")){
				   
				  if(kar!=1){

					  c3= count;
					  s3=f;
					  kar=1;
						//mainObj.put("pro", ja);

						System.out.println("k"+c3);
				  }
			   } 
			     if(f.equals("Tamil Nadu")){
				  if(tamil!=1){

					  c4= count;
					  s4=f;
					  tamil=1;
					   System.out.println("t"+c4);
				  }
			   }
			   }
			   System.out.println("t"+c4+c3+c2+c1);
			   JSONObject jo1 = new JSONObject();
			   JSONObject jo2 = new JSONObject();
			   JSONObject jo3 = new JSONObject();
			   JSONObject jo4 = new JSONObject();
			   JSONObject jm1 = new JSONObject();
			   JSONObject jm2 = new JSONObject();
			   JSONObject jm3 = new JSONObject();
			   JSONObject jm4 = new JSONObject();
				  
				  
			   JSONArray ja = new JSONArray();
					jo1.put("id", c1); 
					ja.put(jo1);  	
					jo2.put("id", c2); 
					ja.put(jo2);  	
					jo3.put("id", c3); 
					ja.put(jo3);
					jo4.put("id", c4);
					ja.put(jo4);	
					
					jm1.put("id", s1); 
					ja.put(jm1);  
					jm2.put("id", s2); 
					ja.put(jm2);  	
					jm3.put("id", s3); 
					ja.put(jm3);  	
					jm4.put("id", s4); 
					ja.put(jm4);  		
					//jo.put("state", "Delhi"); 
				//jm.put("state", "Karnataka"); 
				
				mainObj.put("pro", ja);
				
				
			  // mainObj.put("pro", ja);
			    
		   }
		
		 
	    }
		   
	    response.setContentType("text/plain");  // Set content type of the response so that jQuery knows what it can expect.
	    response.setCharacterEncoding("UTF-8"); // You want world domination, huh?
	    response.getWriter().write(mainObj.toString());  
	    
	    // Write response body.
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
