<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> you returned the book</h1>

<h1>${requestScope.book.bookID}</h1>
<h1>${requestScope.book.bookName}</h1>
Return date: <%= (new java.util.Date()).toLocaleString()%>

<h1> Thanks for using our library site to lend books..</h1>
<a href="logout.htm">return</a>


</body>
</html>