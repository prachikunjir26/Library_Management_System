<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Library Main Page</title>
</head>
<body style="background-color:lightblue; border: 5px solid cornflowerblue; text-align: center; color:white">

		
		 
		<form:form modelAttribute="user" method="post" action="login.htm">
		          <input type="text" name="UserName" placeholder="Username"><br>
		          <input type="password" name="UserPass" placeholder="password"><br>
		          <input type="submit" name="login" value="login"/>
		</form:form>
				<form:form modelAttribute="user" action="signup.htm">
		          <input type="submit" name="login" value="SignUp"/><br>
				</form:form>
				
				
						<div class="form">

		<div class="buttons">
			<label for="chbox" class="login btn"><span>Login</span></label>
			<label for="chbox" class="SignUp btn"><span>SignUp</span></label>
		</div>
		
		
		
		<form action="login.htm" method="post">
			<br><input type="text" name="uname" placeholder="Username"><br>
			<input type="password" name="upass" placeholder="password"><br>
					    <input type="submit" name="login" value="login"/>
       		<input type="hidden" name="page" value="login"/>
  			</form>
		</div>

			<form:form modelAttribute="user" method="post" action="signup.htm">
			<br><input type="text" name="firstName" placeholder="Username"><br>
			<input type="text" name="lastName" placeholder="lastname"><br>
			<input type="password" name="password" placeholder="password"><br>
		    <input type="submit" name="signup" value="signup"/>
  			</form:form>
		</div>

<a href="logout.htm">logout</a>

</body>
</html>