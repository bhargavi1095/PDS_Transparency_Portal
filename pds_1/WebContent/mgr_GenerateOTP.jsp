<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>PDS Manager- Proceed Request</title>
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
      <div class="card-header">Generate OTP</div>
      <div class="card-body">
        <!-- !!!! Put request in DB and generate OTP !!!! -->
        <form action="mgrGenOTP" method="POST">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                
          <% String status= (String) request.getAttribute("error");
		  if(status!=null)out.println(status);
		  %>
              </div>
              
            </div>
          </div>
          
            <input type="submit" class="btn btn-primary btn-block" name="gen OTP" value="SEND">
        </form>
        <div class="form-group">
          </div>
        <form action="mgr_new_req.jsp" method="get">
                      <input type="submit" class="btn btn-primary btn-block" name="new request" value="Back to new request">
        
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
