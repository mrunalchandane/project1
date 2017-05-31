<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="border:2px solid black; top:20px; background-color:skyblue;width:400px;margin-left:10px;">
<h3>ENTER USERNAME AND PASSWORD <br><br></h3>
${error}
${logout}
${registrationSuccess}
<form action="<c:url value="/j_spring_security_check"></c:url>" method="post">
Enter username <input type="text" name="j_username"><br><br>
Enter password <input type="text" name="j_password"><br><br>
<input style="font-size: 20px;align:center" type="submit" value="SUBMIT">
</form>
</div>
</body>
<%@include file="footer.jsp" %>
</html>