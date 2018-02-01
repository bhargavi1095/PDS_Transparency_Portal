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
  <title>PDS Manager- Validate OTP</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  
  
    <script>
//Using setTimeout to execute a function after 5 seconds.
setTimeout(function () {
   //Redirect with JavaScript
   alert("Session expired , 1 minute over");
   
   window.location.href= 'http://localhost:8080/pds_final/mgr_new_req.jsp';
}, 60000);
</script>
  
  
  
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-register mx-auto mt-5">
      <div class="card-header">Verify OTP (valid only for 1 minute)</div>
      <div class="card-body">
      
      
        <!-- !!!! Validate OTP !!!! -->
        <form action="mgrValidateOTP" method="POST">
        
          <div class="form-group">
            <label for="inputAadhaar">Enter OTP</label>
            <input class="form-control" id="inputOTP" name="inputOTP" type="text" pattern="[0-9]{4}" title="Enter 4-digit OTP only" placeholder="Enter OTP sent" required>
          </div>
                      <input type="submit" class="btn btn-primary btn-block" name="put otp" value="Enter">
                      
                                  
        </form>
          <div class="form-group">
          </div>
        <form action="mgr_GenerateOTP.jsp" method="get">
                      <input type="submit" class="btn btn-primary btn-block" name="resend" value="Resend OTP">
        
        </form>
        
       <% String status= (String) request.getAttribute("error");
		  if(status!=null)out.println(status);
		  %>
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
