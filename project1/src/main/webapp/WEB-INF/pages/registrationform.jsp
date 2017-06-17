<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url" %>
<%@ include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container wrapper">
<div class="container">
<url:url value="/all/register" var="url"></url:url>
<form:form  action="${url }" modelAttribute="customer" method="post">
<h4>Personal Details</h4>
<div class="boxed" style= "border:1px solid">

<div class="form-group">
<label for="customerId"></label>
<form:hidden path="customerId" ></form:hidden>
<form:errors path="customerId" cssStyle="color:red"></form:errors>
</div>


<div class="form-group">
<label for="firstname">Enter first name</label>
<form:input path="firstname"></form:input>
<form:errors path="firstname" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="lastname">Enter last name</label>
<form:input path="lastname"></form:input>
<form:errors path="lastname" cssStyle="color:red"></form:errors>
</div>



<div class="form-group">
<label for="email">Enter email</label>
<form:input path="email"></form:input>
<form:errors path="email" cssStyle="color:red"></form:errors>
<span style="color:red">${duplicateEmail }</span>
</div>



<div class="form-group">
<label for="phone">Enter phone number</label>
<form:input path="phone"></form:input>
<form:errors path="phone" cssStyle="color:red"></form:errors>
</div>
</div>
<br>

<h4>Login Details</h4>
<div class="boxed" style= "border:1px solid">
<div class="form-group">
<label for="users.username">Enter username</label>
<form:input path="users.username"></form:input>
<form:errors path="users.username" cssStyle="color:red"></form:errors>
<span style="color:red">${duplicateUsername }</span>
</div>

<div class="form-group">
<label for="users.password">Enter password</label>
<form:input path="users.password" type="password"></form:input>
<form:errors path="users.password" cssStyle="color:red"></form:errors>
</div>
</div>
<br>

<h4>Billing Address</h4>
<div class="boxed" style= "border:1px solid">
<div class="form-group">
<label for="billingAddress.streetname">Enter Streetname</label>
<form:input path="billingAddress.streetname"></form:input>
<form:errors path="billingAddress.streetname" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="billingAddress.apartmentnumber">Enter Apartment number</label>
<form:input path="billingAddress.apartmentnumber"></form:input>
<form:errors path="billingAddress.apartmentnumber" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="billingAddress.city">Enter City</label>
<form:input path="billingAddress.city"></form:input>
<form:errors path="billingAddress.city" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="billingAddress.state">Enter State</label>
<form:input path="billingAddress.state"></form:input>
<form:errors path="billingAddress.state" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="billingAddress.country">Enter country</label>
<form:input path="billingAddress.country"></form:input>
<form:errors path="billingAddress.country" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="billingAddress.zipcode">Enter zipcode</label>
<form:input path="billingAddress.zipcode"></form:input>
<form:errors path="billingAddress.zipcode" cssStyle="color:red"></form:errors>
</div>
</div>
<br>

<h4>Shipping Address</h4>
<div class="boxed" style= "border:1px solid">
<div class="form-group">
<label for="shippingAddress.streetname">Enter Streetname</label>
<form:input path="shippingAddress.streetname"></form:input>
<form:errors path="shippingAddress.streetname" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="shippingAddress.apartmentnumber">Enter Apartment number</label>
<form:input path="shippingAddress.apartmentnumber"></form:input>
<form:errors path="shippingAddress.apartmentnumber" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="shippingAddress.city">Enter City</label>
<form:input path="shippingAddress.city"></form:input>
<form:errors path="shippingAddress.city" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="shippingAddress.state">Enter State</label>
<form:input path="shippingAddress.state"></form:input>
<form:errors path="shippingAddress.state" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="shippingAddress.country">Enter country</label>
<form:input path="shippingAddress.country"></form:input>
<form:errors path="shippingAddress.country" cssStyle="color:red"></form:errors>
</div>

<div class="form-group">
<label for="shippingAddress.zipcode">Enter zipcode</label>
<form:input path="shippingAddress.zipcode"></form:input>
<form:errors path="shippingAddress.zipcode" cssStyle="color:red"></form:errors>
</div>
</div>

<input style="font-size: 20px;" type="submit" value="Register">

</form:form>
</div>
</div>


</body>
<%@include file="footer.jsp" %>
</html>