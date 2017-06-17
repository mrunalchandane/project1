<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@include file="header.jsp" %><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
body {
    margin-top: 20px;
}
</style>
<body>
<div class="container-wrapper" style="overflow:hidden">
    <div class="row">
        <div class="well col-xs-10 col-sm-10 col-md-6 col-xs-offset-1 col-sm-offset-1 col-md-offset-3">
        <div class="col-xs-12 col-sm-12 col-md-12 text-center">
                    <p>
                        <em>Date: ${date}</em>
                    </p>
                    <p>
                        <em>Receipt Id: 34522677W</em>
                    </p>
                    <h4>PaymentMode : ${paymentMode}</h4>
                </div>
            <div class="row">
                <div class="col-xs-6 col-sm-6 col-md-6 text-left">
                    <address>
                            <div class="col-md-12" >
					               Billing To,<br>
					               ${username},<br>
					               ${b.apartmentnumber},<br>
					               ${b.streetname },${b.city}<br>
					            ${b.country}-${b.zipcode}
					               
					          </div>
				     </address>
                </div>
              <div class="col-xs-6 col-sm-6 col-md-6 text-right">
                    <address>
                             <div class="col-md-12" >						
						        	Shipping To,<br>
						           ${username},
					                ${sa.apartmentnumber},<br>
					               ${sa.streetname },${sa.city}<br>
					            ${sa.country}-${sa.zipcode}
					              </div>
  						
                    </address>
                </div>
            </div>
            <div class="row">
                <div class="text-center">
                    <h3>Receipt</h3>
                </div>
             </div>
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Product</th>
                            <th class="text-center">Price</th>
                            <th class="text-center">Quantity</th>
                            <th class="text-center">Total</th>
                        </tr>
                    </thead>
                    <tbody>
                         <c:forEach items="${productInCart}" var="p">
                        <tr>
                            <td class="col-md-9"><em>${p.name}</em></td>
                            <td class="col-md-1 text-center">Rs.${p.price }</td>
                            <td class="col-md-1 text-center">${p.quantityperproduct }</td>
                        </tr>
                        </c:forEach>
                        <tr>
                            <td> Total items in the cart : <strong>${totalItem}</strong>  </td>
                            <td>   </td>
                            <td class="text-right">Sub-total: </td>
                            <td class="text-right"><strong>Rs ${subtotal}</strong></td>
                          </tr>
                         <tr>
                          <td> </td>
                          <td> </td>
                            <td class="text-right">Estimated shipping: </td>
                            <td class="text-right"><strong>Rs ${delivery }</strong></td>
                          </tr>
                        <tr>
                            <td> <h4>Thank you for shopping on eShop</h4> 
                                 <h5>Your order has been confirmed. We will get back to you soon.</h5> </td>
                            <td>   </td>
                            <td class="text-right">Grand Total: </td>
                            <td class="text-right text-danger"><strong>Rs ${grandtotal }</strong></td>
                        </tr>
                    </tbody>
                </table>
               
  <div class="control-group"> 
  <url:url value="/thanks" var="url"></url:url>
  <a href="${url}">
       <button type="submit" class="btn btn-default"> Print Your Receipt </button></a>
   </div>
                </div>
            </div>
        </div>
        
<br><br>
</body>
</html>
