<!DOCTYPE html>
<html lang="en">
<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <%@ page import="org.hibernate.SessionFactory" %>
 <%@ page import="java.io.IOException" %>
 <%@ page import="java.io.PrintWriter" %>
 <%@ page import="java.util.List" %>

 <%@ page import="javax.servlet.RequestDispatcher" %>
 <%@ page import="javax.servlet.ServletException" %>
 <%@ page import="javax.servlet.annotation.WebServlet" %>
 <%@ page import="javax.servlet.http.HttpServlet" %>
 <%@ page import="javax.servlet.http.HttpServletRequest" %>
 <%@ page import="javax.servlet.http.HttpServletResponse" %>
 <%@ page import="javax.servlet.http.HttpSession" %>

 <%@ page import="org.hibernate.Query" %>
 <%@ page import="org.hibernate.Session" %>
 <%@ page import="org.hibernate.SessionFactory" %>
 <%@ page import="org.hibernate.cfg.AnnotationConfiguration" %>

 <%@ page import="com.dac.pojo.Depot" %>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Administrator-Add Depot</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Add a new Depot</div>
      <div class="card-body">
       <span style="color:red">
       <% String status= (String) request.getAttribute("status");
		  if(status!=null)out.println(status);
		  %>
		  </span><br>
        <form action="allocate_stock" method="POST">
          
          <div class="form-group">
        <div class="form-row">
        
            <label for="exampleInputdepot">Select Depot Name: &nbsp;</label>
        <br>
            <select name="depotname" required>
              <option value=" " >Select</option>
			
          <%
			SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
			Session sess=sessionFactory.openSession();  
			
            		String hql = "from Depot";
        			Query query = sess.createQuery(hql);
        			
        			List<Depot> results =(List<Depot>) query.list(); 
        		  int listCount = results.size();
        		  
            for(Depot a : results)
        {
            	
		String depot_id = a.getDepot_id(); 
		String depot_name = a.getDepot_name(); 
				%>
				<option value="<%=depot_id%>"><%=depot_name %></option>
			<%
		}	
		%>
		</select>	
	</div>
          </div>
          <div class="form-group">
            <div class="form-row">
                 <label for="exampleInputName">Wheat Stock</label>
                <input class="form-control" name="wheat"id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Enter Wheat Stock"required>
                 <label for="exampleInputLastName">Rice Stock</label>
                <input class="form-control" name="rice" id="depotId" type="text" aria-describedby="nameHelp" onkeyup="check_depot()" placeholder="Enter Rice Stock" required>
               <label for="exampleInputLastName">Oil Stock</label>
                <input class="form-control" name="oil" id="depotId" type="text" aria-describedby="nameHelp" onkeyup="check_depot()" placeholder="Enter Oil Stock" required>
               </div>
          </div>
          
           <input type="submit" class="btn btn-primary btn-block" name="submit" value="Add Depot">
        </form> 
        <br>
        <form action="dashboard_admin.jsp">
         <input type="submit" class="btn btn-info btn-block" name="submit" value="Go to Dashboard">
        </form> 
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script> 
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
