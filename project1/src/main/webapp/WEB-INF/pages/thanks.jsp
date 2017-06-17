<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container-wrapper" > 
       <h1 style="text-align: center;">Thanks for your purchase from Kid's Sports Store! </h1> 
<div class="control-group"> 
  <url:url value="/" var="url"></url:url>
  <a href="${url}">
       <button type="submit" class="btn btn-default"> Go Back to Home Page </button></a>
   </div>		
</body>
<%@include file="footer.jsp" %>
</html>