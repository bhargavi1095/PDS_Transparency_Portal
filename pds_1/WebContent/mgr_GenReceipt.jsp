<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

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



 
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>PDS Manager- Generate Receipt</title>
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
      <div class="card-header">Details of the receipt:</div>
      <div class="card-body">
       <span style="color:red">
       <% String status= (String) request.getAttribute("error");
		  if(status!=null)out.println(status);
		  %>
		  </span><br>
        <form action="mgrGenReceipt" method="POST">
          
          <div class="form-group">
            <div class="form-row">
                <label for="exampleInputName">Customer PDS ID</label>
                <input class="form-control" name="pds" id="inputPDS" type="text" aria-describedby="nameHelp"  value="<%= request.getAttribute("pds") %>" readonly>
                 <label for="exampleInputLastName">Aadhaar ID</label>
                <input class="form-control" name="aadhaar" id="inputAadhaar" type="text" aria-describedby="nameHelp"  value="<%= request.getAttribute("aadhaar") %>" readonly>
               <label for="exampleInputLastName">Ration ID</label>
                <input class="form-control" name="ration" id="inputRation" type="text" aria-describedby="nameHelp"   value="<%= request.getAttribute("ration") %>" readonly>
                
                <label for="exampleInputName">Mobile No.</label>
                <input class="form-control" name="mobile" id="inputMobile" type="text" aria-describedby="nameHelp"  value="<%= request.getAttribute("mobile") %>" readonly>
                 <label for="exampleInputLastName">Category</label>
                <input class="form-control" name="category" id="inputCategory" type="text" aria-describedby="nameHelp"  value="<%= request.getAttribute("category") %>" readonly>
               <label for="exampleInputLastName">Depot ID</label>
                <input class="form-control" name="depot" id="inputDepot" type="text" aria-describedby="nameHelp"   value="<%= request.getAttribute("depot") %>" readonly>
                
                 <label for="exampleInputName">Wheat Allocated at Rs.3 per kg</label>
                <input class="form-control" name="wheat" id="inputWheat" type="text" aria-describedby="nameHelp"  value="<%= request.getAttribute("wheat") %>" readonly>
                 <label for="exampleInputLastName">Rice Allocated at Rs.5 per kg</label>
                <input class="form-control" name="rice" id="inputRice" type="text" aria-describedby="nameHelp"   value="<%= request.getAttribute("rice") %>" readonly>
               <label for="exampleInputLastName">Oil Allocated at Rs.10 per kg</label>
                <input class="form-control" name="oil" id="inputOil" type="text" aria-describedby="nameHelp"   value="<%= request.getAttribute("oil") %>" readonly>
               </div>
          </div>
          
           <input type="submit" class="btn btn-primary btn-block" name="submit" value="Download">
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
		  
