<!DOCTYPE html>
<html lang="en">

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
        <form action="add_depot" method="POST">
          <div class="form-group">
            <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">Depot name</label>
                <input class="form-control" name="name"id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Enter Depot name"required>
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">Depot ID</label>
                <input class="form-control" name="depot_id" id="depotId" type="text" aria-describedby="nameHelp" onkeyup="check_depot()" placeholder="Enter Depot ID" required>
              </div>
            </div>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">District</label>
            <input class="form-control" name="district" id="exampleInputEmail1" type="text" aria-describedby="emailHelp" placeholder="Enter District" required>
          </div>
          <div class="form-group">
        <div class="form-row">
              <div class="col-md-6">
                <label for="exampleInputName">City</label>
                <input class="form-control" name = "city" id="exampleInputName" type="text" aria-describedby="nameHelp" placeholder="Enter City" required>
              </div>
              <div class="col-md-6">
                <label for="exampleInputLastName">State</label>
                <input class="form-control" name = "state" id="exampleInputLastName" type="text" aria-describedby="nameHelp" placeholder="Enter State" required>
              </div>
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
