<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="header.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="url" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page isELIgnored="false" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<div class="container wrapper">
  <div class="container">
  
  <url:url var="url" value="/admin/category/savecategory"></url:url>
<form:form action="${url }" modelAttribute="category"  enctype="multipart/form-data">
  
  <div class="form-group">
  <label for="cid"></label>
  <form:hidden path="cid"></form:hidden>
  <form:errors path="cid" cssStyle="color:red"></form:errors>
  </div>
  
  <div class="form-group">
  <label for="categoryDetails">Enter New Category Name</label>
  <form:input path="categoryDetails"></form:input>
  <form:errors path="categoryDetails" cssStyle="color:red"></form:errors>
  </div>
  

  <input type="submit" value="Add Category">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form:form>
  </div>
</div>
</body>

<%@include file="footer.jsp" %>
</html>