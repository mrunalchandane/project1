<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@include file="header.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

div.seg
{
			width :100%;
			position: relative;
			background-color:transparent;
			overflow:hidden;
}

div.rec
		{
			height: 400px;
			width:20%;
			display:inline-block;
			box-shadow:.5px 3px 8px 2px lightgray;
			background-color: white;
			margin-top: 0px;
    		margin-left: 150px;

		}

		div.disc
		{
			height: 150px;
			width:135px;
			border-radius: 50%;
			background-color: transparent;
			margin-top: 20px;
			margin-left: 55px;
			position: relative;

		}

		div.square
		{
			height: 200px;
			width: 200px;
			position: absolute;
			margin-left: 40px;
			margin-top: 10px;
		}
		
		p.text
		{
			font-size: 40px;
			color: white;
			font-family: serif;
			margin-left: 20px;
			margin-bottom: 0px;
		}
		
		div.carousel-caption
		{
			background-color:skyblue;
		}

</style>
</head>
<body>
<div class="container-wrapper">
<div class="container-fluid" style="background-color:skyblue; padding-top:-20px">
<div id="myCarousel" class="carousel slide" data-ride="carousel" >
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
                <li data-target="#myCarousel" data-slide-to="3"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <img class="first-slide home-image" src="resources/images/1.jpe" alt="first slide"  >
                    <div class="container">
                        <div class="carousel-caption" >
                            <h1>WELCOME TO THE KID'S SPORTS STORE</h1>
                            <p>Here You Can Browse And Buy Sport Equipments.Order Now For Your Amazing New Arrivals</p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="second-slide home-image" src="resources/images/2.jpe" alt="Second slide" >
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>The SPORT's Store.</h1>
                            <p>online shopping can make your life more easier</p>
                        </div>
                    </div>
                </div>
                <div class="item">
                    <img class="third-slide home-image " src="resources/images/3.jpe" alt="Third slide" >
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Multiple Accessories</h1>
                            <p>Vibrant Colors, Safe and Secure equipments!!</p>
                        </div>
                    </div>
                </div>
                 <div class="item">
                    <img class="forth-slide home-image " src="resources/images/4.jpe" alt="forth slide" >
                    <div class="container">
                        <div class="carousel-caption">
                            <h1>Swings... Ladders.... Slides</h1>
                            <p>Many more.... with huge discounts!!</p>
                        </div>
                    </div>
                </div>
            </div>
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" ></span>
                <span class="sr-only">Next</span>
            </a>
        </div><!-- /.carousel -->

</div>
  
<div class="seg" style="top:0px;">
		 <div style="height: 10%;width: 20%;opacity:0.8;color:yellow;top:5%;left:5%;
		background-color: transparent;position: absolute;font-family:lucida;text-align: 
		center;padding-top: 0px;">	<h1>Free Shipping !!!</h1> 
			<p > <h3>On all orders over Rs.500 all over India</h3></p>
		</div>
		<img src="resources/images/swing7.jpg" style="width:100%"></img>
</div>

<!--
<div class="seg" style="top:0px;" >
	<img src="resources/images/1.jpe" style="position:absolute;height: 400px;width: 200px;z-index: 10" ></img>
	<div class="rec">
		<div class="disc" style="background-image: url('resources/images/swinging.jpe');"></div>
		<div class="square" style="background-color: red"><p class="text" style="margin-top: 0px;">Swinging </p> 
		                  <p class="text" style="font-size: 20px; margin-top: 15px;"> Infant and Toddler <br> 
		                  Belt Swings <br> Flat Swings <br> Swing Hardware</p></div>
	</div>
	
	<div class="rec">
		<div class="disc" style="background-image: url('resources/images/sliding.jpe');"></div>
		<div class="square" style="background-color: orange;"><p class="text" style="margin-top: 0px;">Sliding </p> 
						<p class="text" style="font-size: 20px; margin-top: 15px;"> Flat Bed Slides <br> 
						Wave Slides <br> Scoop Slides <br> Sectional Slides</p></div>
	</div>
	
	<div class="rec">
		<div class="disc" style="background-image: url('resources/images/climbing.jpe');"></div>
		<div class="square" style="background-color: blue"><p class="text" style="margin-top: 0px;">Climbing </p> 
				<p class="text" style="font-size: 20px; margin-top: 15px;"> Rope Ladders <br> Rock Climbs <br> 
				Overhead Ladders <br> Handles and Bars</p></div>
	</div>
</div>-->
</div>

</body>
<%@include file="footer.jsp" %>
</html>