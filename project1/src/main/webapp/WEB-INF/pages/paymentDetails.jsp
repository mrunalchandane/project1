<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header.jsp" %><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container-wrapper">
    <div class="login-container">
           
         <form name="form-center" style="width:60%" action="${pageContext.request.contextPath}/receipt" method="post">
               
                <div class="form-group" style="width:60%">
                    <label for="paymentMode">Select any one payment mode : </label>
                   <select name="paymentMode">
					  <option value="COD">Cash-On-Delivery</option>
					  <option value="DC">Debit-Card</option>
					  <option value="CC">Credit-Card</option>
					  <option value="NB">Net-Banking</option>
					</select>
				</div>
                  
                 <url:url value="/receipt" var="url"></url:url>
  				<a href="${url}"><input type="submit" value="Next"></a>
            </form>
        </div>
    </div>
 </body>
 <%@include file="footer.jsp" %>
</html>
