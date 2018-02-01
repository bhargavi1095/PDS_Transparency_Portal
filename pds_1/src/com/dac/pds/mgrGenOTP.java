package com.dac.pds;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;

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

import com.dac.pojo.PDS_USERS;
import com.dac.pojo.USER_REQUESTS;  

/**
 * Servlet implementation class mgrGenOTP
 */
@WebServlet("/mgrGenOTP")
public class mgrGenOTP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mgrGenOTP() {
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
		
		
		// getting aadhaar_id from session variable
		HttpSession sess=request.getSession(false);  
        String aadhaar = sess.getAttribute("SAadhaar").toString();
        
       
        
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();  
		
		// to get data from pds_users
		String hql = "from PDS_USERS WHERE aadhaar_id= :aadhaar ";
		Query query = session.createQuery(hql);
		query.setParameter("aadhaar", aadhaar);
		
		// generating OTP through Random number
		Random rndm_method = new Random();
    	String password=String.format("%04d", rndm_method.nextInt(10000));
    	String request_id = String.format("%04d", rndm_method.nextInt(10000));
    	
	  List<PDS_USERS> results =(List<PDS_USERS>) query.list(); 
	  int listCount = results.size();
	  
	  String pds_id="";
	  String category="";
	  String phone="";
	  String ration_id="";
	  
	  // if result found 
	  if(listCount>0){  
	  		    for(PDS_USERS u : results)
		    {
	  
	  		    	pds_id=u.getPds_id();
	  		    	category = u.getCategory();
	  		    	phone = u.getMobile_no();
	  		    	ration_id = u.getRation_id();
		    }
	  
	  		    	 
	  		  // creating object of USER_REQUESTS and setting its fields to persist in database
	  		  System.out.println("user request");   
	  		  USER_REQUESTS ur = new USER_REQUESTS();
	  		  ur.setRequest_id(request_id);
	  		  ur.setAadhaar_id(aadhaar);
	  		  ur.setPds_id(pds_id);
	  		  ur.setCategory(category);
	  		  ur.setRation_id(ration_id);
	  		  ur.setVerify_request(password);
	  		  
	  		  
	  		  // setting timestamp using date function
	  		  Date date = new Date();
	  		  long time = date.getTime();
	  		  Timestamp ts = new Timestamp(time);
	  		  ur.setTimestamp(ts.toString());
	  		  ur.setAllocated("0");
	  		  
	  		  
	  		  // saving the object in database
	  		  session.beginTransaction();
	  		  session.save(ur);
	  		  session.getTransaction().commit();
	  		  
	  		  // closing session and sessionFactory
	  		  session.close();
	  		  sessionFactory.close();
	  		  
	  		  // sending OTP on the phone number
	  		  
	  		try {
	        	
	  			
	  			
	          URL url = new URL("https://smsapi.engineeringtgr.com/send/?Mobile=7023222688&Password=Abc123&Message=OTP:"+password+"&To="+phone+"&Key=shreyGBIDhzjFJT2EUtXkq");
	  			  
	  			 URLConnection urlcon = url.openConnection();
	            InputStream stream = urlcon.getInputStream();
	            int i;
	            String res="";
	            while ((i = stream.read()) != -1) {
	                res+=(char)i;
	            }
	            
	            // if msg successfully sent
	            if(res.contains("success")){
	            	System.out.println("lklkhl");
	                // forwarding to validate the OTP
	                RequestDispatcher rd2 = request.getRequestDispatcher("mgr_ValidateOTP.jsp");
	    			rd2.forward(request, response);
	            }
	            // if msg not sent successfully
	            else
	            {
	                // again redirecting to generate OTP
	                
	                request.setAttribute("error", "OTP not sent");
	                RequestDispatcher rd2 = request.getRequestDispatcher("mgr_GenerateOTP.jsp");
	    			rd2.forward(request, response);
	            }
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	            
	        }/*finally{session.close();
			sessionFactory.close();}*/
	  		
	  		
	  		
	  		}
	 
	   }
	
		
		
		
	}


