<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.top
{
height:50px;
width:100%;
background-color:blue;
color:yellow;
font-size:20px;
overflow:hidden;
}
</style>
</head>
<body>
<div class="container-wrapper">
<div style="width:100%;height:20%;"></div>
<div class="top"><strong>${totalItem} ${msg}</strong></div>
<br>
<c:forEach items="${productInCart}" var="p">
<pre>
Product Id      :  ${p.productId }
Product Name    :  ${p.name }
Product Quantity : ${p.quantityperproduct}
Product Price   :  ${p.price }
<a href="<c:url value="/deleteCartItem/${p.productId}" />">Remove</a> 
</pre>
</c:forEach>

<c:if test="${show }">
<pre>
Sub Total       :    ${subtotal}
Tax             :    20
Grand Total     :	${grandtotal }

<a href="<c:url value="/billing" />">Check Out</a> 

</pre>
</c:if>
</div>

</body>
<%@include file="footer.jsp" %>
</html>