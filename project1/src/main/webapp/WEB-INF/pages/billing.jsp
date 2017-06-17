
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.box
{
		height:200px;
		width:200px;
		border: 2px solid black;
		font-size:15px;
		margin-left:10px;
}

</style>
</head>
<body>
  <h2>Billing Address</h2>
  <div class="box">
  Customer Name : ${customername} <br>
  BillingId : ${billingAddressList.billingId} <br>
  Apartment Number : ${billingAddressList.apartmentnumber } <br>
  Street Name : ${billingAddressList.streetname }<br>
  City : ${billingAddressList.city} <br>
  State:${billingAddressList.state}<br>
  Country : ${billingAddressList.country} <br> 
  Pin code : ${billingAddressList.zipcode} 
  </div>
  <br><br>
  <url:url value="/shipping" var="url"></url:url>
  <a href="${url}"><input type="submit" value="Next"></a>
  
 
 
</body>
<%@include file="footer.jsp" %>
</html>

 


