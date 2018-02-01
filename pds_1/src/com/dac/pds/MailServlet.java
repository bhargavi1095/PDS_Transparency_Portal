 package com.dac.pds;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MailServlet
 */
@WebServlet("/MailServlet")
public class MailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	      
	    //String to=request.getParameter("to"); 
	    String to="kishan.2k13@gmail.com";
	    String subject=request.getParameter("uname");
	   // String email=request.getParameter("umail");
	   // String number=request.getParameter("unum");
	    String msg=request.getParameter("msg");  
	          
	    Mailer.send(to, subject, msg);
	    
	    //out.print("message has been sent successfully");
	    response.sendRedirect("home_contact.html");
	    out.close();  
	}

}
