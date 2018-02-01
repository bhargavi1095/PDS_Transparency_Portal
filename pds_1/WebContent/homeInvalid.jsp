<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Pds-Transparency</title>

    <!-- Bootstrap core CSS -->
    <link href="home_vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="home_vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="home_css/clean-blog.min.css" rel="stylesheet">

<link rel="stylesheet" href="home_css/style.css">

<script type="text/javascript">
function func(){
	alert("Status"+ " <%= request.getAttribute("uid") %> ");
}
</script>
  </head>

  <body onload="func()">

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand" href="index.html">Transparency System</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="index.html">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="home_about.html">About</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="home_post.html">Item</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="home_contact.html">Feedback</a>
            </li>

             <!--------------------------------------user status------------------------------------------>
             <li class="nav-item">
              <a class="nav-link" href="#page2">User</a>
             
               <div id="page2" class="pop-up-page2">
              <div class="popup2">
               <h3>Your Status!!</h3>
                <form action = "Valide_User" method = "post" >
              
                  <input class = "" type = "text" placeholder = "Aadhar Number" name="uid" pattern="[0-9]{12}" title="Enter 12 digit number only" id="uddi" required>
                  <hr>
                 <input type = "submit" value = "check" id="check" >
                </form>
                 <a href="#" class="fa2 fa-times" aria-hidden="true"></a>
              </div>
             </div>

              <script src='https://use.fontawesome.com/853e806641.js'></script>
               <!--user status-->
            </li>
             <li class="nav-item">
              <a class="nav-link" href="index.jsp">Login</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('home_img/wp.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="site-heading">
              <h1>PDS Transparency</h1>
              <span class="subheading">A Transparency System</span>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Main Content -->
    <div class="container">
      <div class="row">
        <div class="col-lg-8 col-md-10 mx-auto">
          <div class="post-preview">
            <a href="#">
              <h2 class="post-title">
                PDS ??
              </h2>
              <p class="post-subtitle">
                Public distribution system (PDS) is an Indian food security system. Established by the Government of India under Ministry of Consumer Affairs,
                Food, and Public Distribution and are managed jointly by state governments in India it distributes subsidized food and non-food items to India's poor. This scheme was first launched in February 1944, during the Second World War and was launched in the current form in June 1947.
              </p>
              <hr>
              <p>The PDS has been criticised for its urban bias and its failure to serve the poorer sections of the population effectively. The targeted PDS is costly and gives rise to much corruption in the process of extricating the poor from those who are less needy.</p>
            </a>
            <hr>
            <p>For more details....
              <a href="https://en.wikipedia.org/wiki/Public_distribution_system">pds wiki</a></p>
          </div>
          <hr>
         
          <!-- Pager -->
          <div class="clearfix">
            <a class="btn btn-primary float-right" href="#">Go to top..</a>
          </div>
        </div>
      </div>
    </div>

    <hr>

    <!-- Footer -->
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <ul class="list-inline text-center">
              <li class="list-inline-item">
                <a href="https://twitter.com/fciforum?lang=en">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="https://www.facebook.com/FoodCorpIndia/">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="http://fci.gov.in/">
                  <span class="fa-stack fa-lg">
                    <i class="fa fa-circle fa-stack-2x"></i>
                    <i class="fa fa-github fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
            </ul>
            <p class="copyright text-muted">Transparency System</p>
          </div>
        </div>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="home_vendor/jquery/jquery.min.js"></script>
    <script src="home_vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="home_js/clean-blog.min.js"></script>

  </body>

</html>
