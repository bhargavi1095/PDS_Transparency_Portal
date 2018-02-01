package com.dac.pds;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.*;  
import javax.mail.internet.InternetAddress;  
import javax.mail.internet.MimeMessage;  

public class Mailer {
	
	public static void send(String to,String subject,String msg){  
		  
		final String user="its.cool091@gmail.com"; 
		final String pass="it/13/44"; 
		
		
		//String host = "http://localhost:8081/";
		Properties props = new Properties(); 
		props.put("mail.smtp.host","smtp.gmail.com");
		props.put("mail.socketFactory.port","587");
		props.put("mail.socketFactory.class","javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.auth", "true");  
		props.put("mail.smtp.port","587");
		 
		Session session = Session.getDefaultInstance(props,  
		 new javax.mail.Authenticator() {  
		  protected PasswordAuthentication getPasswordAuthentication() {  
		   return new PasswordAuthentication(user,pass);  
		   }  
		});  
		
		
		try { 

		 MimeMessage message = new MimeMessage(session);  
		 message.setFrom(new InternetAddress(user));  
		 message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
		 message.setSubject(subject);  
		 message.setText(msg);  
		   
		   
		 Transport.send(message);  
		  
		 System.out.println("Done");  
		  
		 } catch (MessagingException e) {  
		    throw new RuntimeException(e);  
		 }  
		      
		}  

}
