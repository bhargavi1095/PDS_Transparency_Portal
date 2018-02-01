
<!DOCTYPE html>
<html lang="en">
<!--  login again page -->
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>PDS-Login</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Login</div>
      <div class="card-body">
      <!-- !!!! LOGIN !!!! -->
        <form action="LoginCheck" method="POST">
         
	      <span style="color:red"><% String status=(String)request.getAttribute("status");
	      if(status!=null)out.println(status);
	      int flagg=0;
	      HttpSession sess = request.getSession();
	      if(sess==null){
	    	  flagg=1;
	      }
	      else{
	    	  System.out.println(sess.getAttribute("category"));
	      }
	     String cat = (String)sess.getAttribute("category");
	      if(cat!=null){
	    	  if(cat.equals("Administrator")){
	    		  RequestDispatcher rd=request.getRequestDispatcher("dashboard_admin.jsp");  
	 			 rd.forward(request, response);	
	    	  }
	    	  else if(cat.equals("Manager")){
	    		  RequestDispatcher rd=request.getRequestDispatcher("mgr_new_req.jsp");  
					 rd.forward(request, response);		
	    		  
	    	  }
	      }
	      
	      
	      HttpSession session1 = request.getSession();
	      Cookie[] coockies=request.getCookies();
			int flag=0;
			 String c=null,i=null,n=null;
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
			 if(flagg==1){
				 flag=0;
			 }
			 if(flag==1){
				 if(c.equals("Administrator")){
					  RequestDispatcher rd=request.getRequestDispatcher("dashboard_admin.jsp");  
			 			 rd.forward(request, response);	
			 			
			 			 
						  
				 }
				 else if(cat.equals("Manager")){
		    		  RequestDispatcher rd=request.getRequestDispatcher("mgr_new_req.jsp");  
						 rd.forward(request, response);		
		    		  
		    	  }
			 }
			 
			 
	      
	      %>
	      </span>
          <div class="form-group"> 
            <label for="exampleInputEmail1">User ID</label>
            <input class="form-control" id="exampleInputEmail1" name="exampleInputEmail1"type="text"  placeholder="User ID" required>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input class="form-control" id="exampleInputPassword1" name="exampleInputPassword1" type="password" placeholder="Password" required>
          </div> 
           <div class="form-group">  
           <label for="exampleInputCategory">Login as </label><br>
           <label for="exampleInputAdmin">Administrator</label>
            <input  id="exampleInputCat" type="radio" name="category" value="Administrator">
            &nbsp;&nbsp;&nbsp;
           <label for="exampleInputManager">Manager</label>
           <input id="exampleInputCat" type="radio" name="category" value="Manager">
          </div>
          <div class="form-group">
            <div class="form-check">
              <label class="form-check-label">
                <input class="form-check-input" type="checkbox" name="remember"> Remember Password</label>
            </div>
          </div>
          <input type="submit" class="btn btn-primary btn-block" name="submit" value="Login">
        
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
