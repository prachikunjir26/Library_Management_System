<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Book Info</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


 
		
   
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Library Management System</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/album/">

    

    <!-- Bootstrap core CSS -->
<link href="/docs/5.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- Favicons -->
<link rel="apple-touch-icon" href="/docs/5.1/assets/img/favicons/apple-touch-icon.png" sizes="180x180">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-32x32.png" sizes="32x32" type="image/png">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon-16x16.png" sizes="16x16" type="image/png">
<link rel="manifest" href="/docs/5.1/assets/img/favicons/manifest.json">
<link rel="mask-icon" href="/docs/5.1/assets/img/favicons/safari-pinned-tab.svg" color="#7952b3">
<link rel="icon" href="/docs/5.1/assets/img/favicons/favicon.ico">
<meta name="theme-color" content="#7952b3">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
  </head>
  <body style="background-color: #FEFBE7">

 
 
    
<header>
  <div class="collapse bg-dark" id="navbarHeader">
    <div class="container">
      <div class="row">
        <div class="col-sm-8 col-md-7 py-4">
          <h4 class="text-white">About</h4>
          <p class="text-muted">Add some information about the album below, the author, or any other background context. Make it a few sentences long so folks can pick up some informative tidbits. Then, link them off to some social networking sites or contact information.</p>
        </div>
        <div class="col-sm-4 offset-md-1 py-4">
          <h4 class="text-white">Contact</h4>
          <ul class="list-unstyled">
            <li><a href="#" class="text-white">Follow on Twitter</a></li>
            <li><a href="#" class="text-white">Like on Facebook</a></li>
            <li><a href="#" class="text-white">Email me</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <div class="navbar navbar-dark shadow-sm" style="background-color: #A0BCC2">
    <div class="container">
      <a href="#" class="navbar-brand d-flex align-items-center">
      <strong>Library Management System</strong>
      </a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarHeader" aria-controls="navbarHeader" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
    </div>
  </div>
</header>
<%@ include file ="search.jsp" %>


<main style="background-color: #FEFBE7">



			        
		            <form:form modelAttribute="book" method="post" action="addedbooks.htm" enctype="multipart/form-data">
					
					<div class="input-group input-group-sm mb-3" style="display:inline">
					<div style="display:inline; width: 200px; align-items:center">
					
            	   <br><input style="width: 200px; align-items:center; margin-left:500px" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" placeholder="BookName" type="text" id="bookname" name="bookName"><br>
					
            	   <input style="width: 200px; align-items:center; margin-left:500px" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" placeholder="BookDescription" type="text" id="bookdescription" name="bookDescription"><br>
            	   
            	
                   <input style="width: 200px; align-items:center; margin-left:500px" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" placeholder="BookPrice" type="hidden" id="bookprice" name="bookPrice" value="0"/>
                   
                   <input style="width: 200px; align-items:center; margin-left:500px" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" placeholder="SelectFile" type="file" name="imageF" id="imageF"/>
                   <input style="width: 200px; align-items:center; margin-left:500px" class="form-control" aria-label="Sizing example input" aria-describedby="inputGroup-sizing-sm" placeholder="SelectFile" type="submit" value="Submit"/>
                   
                    </div>
		</form:form>
		
		<button style="width: 200px; align-items:center; margin-left:500px" type="button" class="btn btn-sm btn-outline-secondary"><a href="view.htm">View</a></button>
		<button style="width: 200px; align-items:center; margin-left:500px" type="button" class="btn btn-sm btn-outline-secondary"><a href="logout.htm">logout</a></button>
		
		
	

</main>

<footer class="text-muted py-5">
  <div class="container">
    <p class="float-end mb-1">
      <a href="#">Back to top</a>
    </p>
    <p class="mb-1">Web Tools Project, Spring 2022 &copy; Prachi Kunjr</p>
     </div>
</footer>


    <script src="/docs/5.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>




</body>
</html>

<!--  
<form:form modelAttribute="book" method="post" action="addedbooks.htm" enctype="multipart/form-data">

<label>Book Name</label>
<input type="text" id="bookname" name="bookName">
<br>
<br>
<label>Book Description: </label>
<label>Book Name</label>
<input type="text" id="bookdescription" name="bookDescription">
<br>
<br>
<label>Book price</label>
<input type="text" id="bookprice" name="bookPrice">
<br>
<br>
Select File: <input type="file" name="imageF" id="imageF"/>  
<br> 
<br>
<br>
<input type="submit" value="Submit"/>  
</form:form>

-->




</body>
</html>