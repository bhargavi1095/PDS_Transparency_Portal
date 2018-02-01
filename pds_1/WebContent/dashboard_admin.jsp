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
  <title>Administrator Dashboard</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin CSS-->
  <link href="vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
   <script>
    

    var ctx = document.getElementById("myBarChart");
   
   // var text2=test2("state"); 
var state_1,c1=0,c2=0,c3=0; 
   function test2() { 

	   state_1=document.getElementById("state").value;
       myFunction2(function(d) {
 
    	   obj=JSON.parse(d);  
      		  c1 =obj.pro[0].id;
            c2 = obj.pro[1].id;
            c3 = obj.pro[2].id;
          console.log(c1+c2+c3);
          document.getElementById("oil").innerHTML = c1.toString();
          document.getElementById("rice").innerHTML = c2.toString();
          document.getElementById("wheat").innerHTML = c3.toString();
       }); 
       }
    
    function myFunction2(callback) {
        var data;  
        
        console.log("check"+state_1);
        $.ajax({
        	url : 'Servlet2',
        	type: "GET",
        	async: false,
    		data : { stat:state_1} ,
    		success : function(responseText) {
    		 data = responseText ; 
                callback(data);
            },
            error: function () {}
        });
    }
    </script>
</head>

<body class="fixed-nav sticky-footer bg-dark" id="page-top">
  <!-- Navigation-->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <a class="navbar-brand" href="index.html">Hello 
  <% HttpSession session1=request.getSession(false);  
        String n=(String)session1.getAttribute("name");  
		  if(n==null){
		      Cookie[] coockies=request.getCookies();
				int flag=0;
				 String c=null,i=null;
				 System.out.println(coockies);
				 if(coockies == null) {
				 flag=0; 
				}
				else { 
					for(Cookie ck : coockies) {
						if(ck.getName().equalsIgnoreCase("category"))
							c=ck.getValue();
						
						if(ck.getName().equalsIgnoreCase("id"))
							i=ck.getValue();  
						if(ck.getName().equalsIgnoreCase("name"))
							n=ck.getValue();  
						System.out.println(c+i);
						
					}
					if(c==null || i==null) {
						flag=0; 
					}
					
					else {
						flag=1; 
					} 
				}
				 
		  }
 
        out.print(n);   
        %>!
        </a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav navbar-sidenav" id="exampleAccordion">
        <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Dashboard">
          <a class="nav-link" href="dashboard_admin.jsp">
            <i class="fa fa-fw fa-dashboard"></i>
            <span class="nav-link-text">Dashboard</span>
          </a>
        </li>  
<li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">
          <a class="nav-link" href="admin_add_depot.jsp" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Add Depot</span>
          </a> 
        </li>
     
         <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">
          <a class="nav-link" href="admin_add_manager.jsp" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Add Manager</span>
          </a> 
        </li>
         <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">
          <a class="nav-link" href="admin_add_pds.jsp" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Register User</span>
          </a> 
        </li>
            <li class="nav-item" data-toggle="tooltip" data-placement="right" title="Link">
          <a class="nav-link" href="admin_allocate_stock.jsp" data-parent="#exampleAccordion">
            <i class="fa fa-fw fa-wrench"></i>
            <span class="nav-link-text">Allocate Stock</span>
          </a> 
        </li>
       
      </ul>
      <ul class="navbar-nav sidenav-toggler">
        <li class="nav-item">
          <a class="nav-link text-center" id="sidenavToggler">
            <i class="fa fa-fw fa-angle-left"></i>
          </a>
        </li>
      </ul>
      <ul class="navbar-nav ml-auto">

        </li>
        <li class="nav-item">
          <a class="nav-link" data-toggle="modal" data-target="#exampleModal">
            <i class="fa fa-fw fa-sign-out"></i>Logout</a>
        </li>
      </ul>
    </div>
  </nav>
  <div class="content-wrapper">
    <div class="container-fluid">
      <!-- Breadcrumbs-->
      <ol class="breadcrumb">
        <li class="breadcrumb-item">
          <a href="#">Dashboard</a>
        </li>
        <li class="breadcrumb-item active"> <% out.print(n);   
        %></li>
      </ol>
   
      <!-- Area Chart Example-->
      <div class="card mb-3">
        <div class="card-header"> 
    
          <i class="fa fa-area-chart"></i> Area Chart Example
         <!-- 
         <div class="dropdown">
        <button class="btn btn-primary dropdown-toggle pull-right" type="button" data-toggle="dropdown">Select State
        <span class="caret">
        </span>
        </button>
        <ul class="dropdown-menu"  onchange="leaveChange()">
        <li>Delhi</li>
        <li>Karnataka</li>
        <li>Tamil Nadu</li> 
        </ul>
        </div> 
        -->
       
		</div>
        <div class="card-body">
          <canvas id="myAreaChart" width="100%" height="30"></canvas>
        </div>
        <div class="card-footer small text-muted"><script>
        
        document.write(Date());
        </script>
        <label name ="date" id="datee"></label>
        </div>
      </div>
      <div class="row">
        <div class="col-lg-12">
          <!-- Example Bar Chart Card-->
          <div class="card mb-3">
            <div class="card-header">
             <i class="fa fa-bar-chart"></i> Stock in depot</div>
        
		            <select id="state" onchange="test2()" name="state" required>
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
           
    <div class="card mb-3">
        <div class="card-header"> 
        <div class="card-body">
          <div class="table-responsive">
            <table class="table table-bordered"  width="100%" cellspacing="0">
              <thead>
                <tr>
                  <th>Oil</th>
                  <th>Rice</th>
                  <th>Wheat</th> 
                </tr>
              </thead>
              <tfoot>
                <tr>
                  <th id="oil"><script type="text/javascript">document.write(c1)</script></th>
                  <th id="rice"><script type="text/javascript">document.write(c2)</script></th>
                  <th id="wheat"><script type="text/javascript">document.write(c3)</script></th> 
                </tr>
              </tfoot> 
            </table>
          </div>
        </div>  </div>
              <!--  <div class="col-sm-4 text-center my-auto">
                  <div class="h4 mb-0 text-primary">$34,693</div>
                  <div class="small text-muted">YTD Revenue</div>
                  <hr>
                  <div class="h4 mb-0 text-warning">$18,474</div>
                  <div class="small text-muted">YTD Expenses</div>
                  <hr>
                  <div class="h4 mb-0 text-success">$16,219</div>
                  <div class="small text-muted">YTD Margin</div>
                </div>
               
              </div>  
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
          </div>
           

 

          </div>
    <!-- /.container-fluid-->
    <!-- /.content-wrapper-->
   <!--  <footer class="sticky-footer">
      <div class="container">
        <div class="text-center">
          <small>PDS Transparency Portal</small>
        </div>
      </div>
    </footer> -->
    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
      <i class="fa fa-angle-up"></i>
    </a>
    <!-- Logout Modal-->
    <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
            <button class="close" type="button" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">X</span>
            </button>
          </div>
          <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
          <div class="modal-footer">
            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
          <!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! -->  
           <form action="logout" method="POST">
         <input type="submit" class="btn btn-primary btn-block" name="submit" value="Logout">
         </form> 
          </div>
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery-1.10.2.js"
	type="text/javascript"></script>
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <!-- Core plugin JavaScript-->
    <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
    <!-- Page level plugin JavaScript-->
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/datatables/jquery.dataTables.js"></script>
    <script src="vendor/datatables/dataTables.bootstrap4.js"></script>
    <!-- Custom scripts for all pages-->
    <script src="js/sb-admin.min.js"></script>
    <!-- Custom scripts for this page-->
    <script src="js/sb-admin-datatables.min.js"></script>
    <script src="js/sb-admin-charts.js"></script>
  </div>
</body>

</html>
