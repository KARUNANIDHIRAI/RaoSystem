<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <title>How to open dropdown  
      menu on hover in Bootstrap</title> 
    <link href= "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" /> 
    <script src= "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js">   </script> 
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js">  </script> 
    <style type="text/css"> 
        .dropdown:hover .dropdown-menu { 
            display: block; 
        } 
    </style> 


</head>
<body>
        <div class="container"> 
            <h1 style="text-align:center;color:green;"> 
              GeeksforGeeks  
             </h1> 
            <h3>How to open dropdown menu on hover in Bootstrap 
             </h3> 
            <div class="bs-example"> 
                <ul id="nav" class="nav nav-pills clearfix right" role="tablist"> 
                    <li><a href="#">Home</a></li> 
                    <li><a href="#">Login</a></li> 
                    <li><a href="#">SignUp</a></li> 
                    <li class="dropdown"> 
                        
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
                        Menu 
                      </a> 
                        
                        <ul id="products-menu" class="dropdown-menu clearfix" 
                            role="menu"> 
                            <li><a href="">Algo</a></li> 
                            <li><a href="">Gate</a></li> 
                            <li><a href="">Subject</a></li> 
                            <li><a href="">Practise</a></li> 
                        </ul> 
                    </li> 
                   <li class="dropdown"> 
                        
                      <a href="#" class="dropdown-toggle" data-toggle="dropdown"> 
                        Menu  item
                      </a> 
                        
                        <ul id="products-menu" class="dropdown-menu clearfix" 
                            role="menu"> 
                            <li><a href="">Algo</a></li> 
                            <li><a href="">Gate</a></li> 
                            <li><a href="">Subject</a></li> 
                            <li><a href="">Practise</a></li> 
                        </ul> 
                    </li> 
 
                </ul> 
            </div> 
        </div> 
</body> 
  
</html> 
