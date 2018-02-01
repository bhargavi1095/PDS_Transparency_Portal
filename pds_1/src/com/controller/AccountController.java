package com.controller;
import com.account.*;
import com.modelAcc.AccountModel;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.account.*;
/**
 * Servlet implementation class AccountController
 */
@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		if(action==null) {
			Account account=checkCoockie(request);
			if(account==null) {
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				AccountModel accModel = new AccountModel();
				if(accModel.login(account.getUsername(),account.getPassword())) {
				session.setAttribute("username",account.getUsername());
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
				}
				else {
					request.setAttribute("error", "inviled");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
		}
		else {
			
		}
	}
	
	
	/* --------------------------*/
	
	private Account checkCoockie(HttpServletRequest request) {
		Cookie[] coockies=request.getCookies();
		Account account=null;
		if(coockies == null) {
			return null;
			
		}
		else {
			String username="",password="";
			for(Cookie ck : coockies) {
				if(ck.getName().equalsIgnoreCase("username"))
					username=ck.getValue();
				
				if(ck.getName().equalsIgnoreCase("password"))
					password=ck.getValue();
					
			}
			if(!username.isEmpty() && !password.isEmpty())
				account=new Account(username,password);
		}
		return account;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String action=request.getParameter("action");
		HttpSession session=request.getSession();
		AccountModel accModel = new AccountModel();
		if(action==null) {
			String username = request.getParameter("username").trim();
			String password = request.getParameter("password").trim();
			boolean remember = request.getParameter("remember") !=null;
			if(accModel.login(username,password)) {
				session.setAttribute("username", username);
				if(remember) {
					Cookie ckUsername = new Cookie("username",username);
					ckUsername.setMaxAge(3600);
					response.addCookie(ckUsername);
					Cookie ckPassword = new Cookie("password",password);
					ckPassword.setMaxAge(3600);
					response.addCookie(ckPassword);
				}
				request.getRequestDispatcher("welcome.jsp").forward(request, response);
				
			}
			else {
				request.setAttribute("error", "inviled");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else {
			if(action.equalsIgnoreCase("logout")) {
				//remove session
				session.removeAttribute("username");
				//remove coockie
				Cookie[] coockie=request.getCookies();
				for(Cookie ck : coockie) {
					if(ck.getName().equalsIgnoreCase("username")) {
						ck.setMaxAge(0);
						response.addCookie(ck);
					}
				}
			}
		}
		
	}

}
