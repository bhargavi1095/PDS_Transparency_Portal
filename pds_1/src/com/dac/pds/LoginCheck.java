package com.dac.pds;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import com.account.Account;
import com.dac.pojo.Administrator;
import com.dac.pojo.Manager;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("exampleInputEmail1");
		String password = request.getParameter("exampleInputPassword1");
		boolean remember = request.getParameter("remember") !=null;
	
		String category = request.getParameter("category");
		
		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();  
		
		Cookie[] coockies=request.getCookies();
		int flag=0;
		 String c=null,i=null,n=null;
		 System.out.println(coockies);
		 if(coockies == null) {
		 flag=0;
			System.out.println("cookie1");
		}
		else { 
			for(Cookie ck : coockies) {
				if(ck.getName().equalsIgnoreCase("category"))
					c=ck.getValue();
				
				if(ck.getName().equalsIgnoreCase("id"))
					i=ck.getValue(); 
				if(ck.getName().equalsIgnoreCase("name"))
					n=ck.getValue(); 
				System.out.println("cookie2"+c+i);
			}
			if(c==null) {
				flag=0;
				System.out.println("cookie3");
			}
			
			else {
				flag=1;
				System.out.println("cookie4");
			}
			System.out.println("cookie5");
		}
		
		
		HttpSession session1 = request.getSession();
		
		if(flag==0)
		{  
			
	try{	
				 
		  if(category.equals("Administrator")){
				
			String hql = "from Administrator WHERE admin_id= :user_id AND admin_password= :password";
			Query query = session.createQuery(hql);
			query.setParameter("user_id", user_id);
			query.setParameter("password", password);
		  List<Administrator> results =(List<Administrator>) query.list(); 
		  int listCount = results.size();
		  if(listCount==0){
			  //User not valid
			  request.setAttribute("status", "User Id or Password is incorrect");
			  RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
			  rd.forward(request, response);
		  }   
			    for(Administrator a : results)
			    {
			  //System.out.println("!!!"+a.getAdmin_first_name()+a.getAdmin_last_name());  
			  session1.setAttribute("category","Administrator");
			  session1.setAttribute("id",a.getAdmin_id());
		       /*
		        * SET COOKIE
		        * */
		       if(remember) {
					Cookie cat = new Cookie("category","Administrator");
					cat.setMaxAge(3600);
					response.addCookie(cat);
					Cookie pass = new Cookie("id",a.getAdmin_id());
					pass.setMaxAge(3600);
					response.addCookie(pass);
					String na = a.getAdmin_first_name()+a.getAdmin_last_name();
					 Cookie name = new Cookie("name",na);
					name.setMaxAge(3600); 
					response.addCookie(name); 
						session1.setAttribute("name",a.getAdmin_first_name()+" "+a.getAdmin_last_name());
				} 
		       
		       ////
		       System.out.println("Admin id : "+a.getAdmin_id());
		       session1.setAttribute("name",a.getAdmin_first_name()+" "+a.getAdmin_last_name());
			 RequestDispatcher rd=request.getRequestDispatcher("dashboard_admin.jsp");  
			 rd.forward(request, response);		 
			    } 
		  }		
		  if(category.equals("Manager")){
			 
			String hql = "from Manager WHERE manager_id= :user_id AND manager_password= :password";
			Query query = session.createQuery(hql);
			query.setParameter("user_id", user_id);
			query.setParameter("password", password);
		  List<Manager> results =(List<Manager>) query.list(); 
		  int listCount = results.size();
		  if(listCount==0){
			  request.setAttribute("status", "User Id or Password is incorrect");
			  RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
			  rd.forward(request, response); 
		  }   
			    for(Manager a : results)
			    {
			    	  // System.out.println("!!!"+a.getManager_first_name()+a.getDepot_id());  
			    	session1.setAttribute("category","Manager");
			    	session1.setAttribute("id",a.getManager_id());
					 RequestDispatcher rd=request.getRequestDispatcher("mgr_new_req.jsp");  
					 rd.forward(request, response);		 
					 
			    } 
		  }
	}catch(NullPointerException e){
		  request.setAttribute("status", "User Id or Password is incorrect");
		  RequestDispatcher rd=request.getRequestDispatcher("index.jsp");  
		  rd.forward(request, response); 
	  
	}
		}else if(flag==1){  
			 RequestDispatcher rd=request.getRequestDispatcher("dashboard_admin.jsp");  
			 rd.forward(request, response);	
			}  
		session.close();
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
