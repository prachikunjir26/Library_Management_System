<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
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
  
 

		           
		   

<form:form modelAttribute="book" action="${pageContext.request.contextPath}/update.htm" method="post" >
					
<label>name: </label>	
<br>				
<form:input path="bookName" size="30" />

<br>

<label>Description: </label>
<br>
<form:input path="bookDescription" size="30" />
<input id="id" name="id" type="hidden" value="${requestScope.book.bookID}"/>
<br>
<input type="submit" value="Submit"/>  
</form:form>
					
					
		<button style="width: 200px; align-items:center; margin-left:500px" type="button" class="btn btn-sm btn-outline-secondary"><a href="/prachi/logout.htm">logout</a></button>
		
		
  
  
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
  
  

<form:form modelAttribute="book" action="${pageContext.request.contextPath}/update.htm" method="post" >

<form:input path="bookName" size="30" />
<br>
<br>
<label>name: </label>
<br>
<br>

<form:input path="bookDescription" size="30" /><br>
<br> 
<input id="id" name="id" type="hidden" value="${requestScope.book.bookID}"/>
<br>
<br>
<input type="submit" value="Submit"/>  
</form:form>
<a href="logout.htm">logout</a>
</body>
</html>

-->