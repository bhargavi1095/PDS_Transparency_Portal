<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Administrator-Add PDS USER</title>
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
      <div class="card-header">Register user to PDS</div>
      <div class="card-body">
      <span style="color:red">
       <% String status= (String) request.getAttribute("status");
		  if(status!=null)out.println(status);
		  %>
		  </span><br>
        <form action="add_user" method="POST">
          <div class="form-group">
            <div class="form-row">
                <label for="exampleInputName">Aadhaar ID</label>
                <input class="form-control" id="exampleInputid1" name="aadhaar" type="text" pattern="[0-9]{12}" title="Enter 12 digit number only" placeholder="Enter Aadhaar ID of user" required>
             
            </div>
          </div>
          <div class="form-group">
            <label for="exampleInputid2">Ration ID</label>
            <input class="form-control" id="exampleInputid2" name="ration" type="text" aria-describedby="idHelp" placeholder="Enter Ration ID of user" required>
          </div>   
         <input type="submit" class="btn btn-primary btn-block" name="submit" value="Add User">
        </form> <br>
        
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
