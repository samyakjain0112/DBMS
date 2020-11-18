<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


          
<!DOCTYPE HTML>
<html>
<head>
<title>Daffodial Beauty Salon and Skin-Care Center</title>
<meta name="viewport0
" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="" />
<script type="applijewelleryion/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="/css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href="/css/style.css" rel='stylesheet' type='text/css' />	
 <link href="/css/form.css" rel='stylesheet' type='text/css' /> 
<link href="/css/swipebox.css" rel='stylesheet' type='text/css' />	
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />
<script src="js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="js/move-top.js"></script>
<script type="text/javascript" src="js/easing.js"></script>
<script src="js/modernizr.custom.97074.js"></script>
<!--/script-->
<script type="text/javascript">
			jQuery(document).ready(function($) {
				$(".scroll").click(function(event){		
					event.preventDefault();
					$('html,body').animate({scrollTop:$(this.hash).offset().top},900);
				});
			});
</script>
<script src="js/jquery.swipebox.min.js"></script> 
					<script type="text/javascript">
						jQuery(function($) {
							$(".swipebox").swipebox();
						});
					</script>
<!-- Add fancyBox main JS and CSS files -->
		<script src="js/jquery.magnific-popup.js" type="text/javascript"></script>
		<link href="css/magnific-popup.css" rel="stylesheet" type="text/css">
		<script>
			$(document).ready(function() {
				$('.popup-with-zoom-anim').magnificPopup({
					type: 'inline',
					fixedContentPos: false,
					fixedBgPos: true,
					overflowY: 'auto',
					closeBtnInside: true,
					preloader: false,
					midClick: true,
					removalDelay: 300,
					mainClass: 'my-mfp-zoom-in'
			});
		});
		</script>

</head>
<body>
	<!--start-main-->
           <div class="banner" id="home">
		        <div class="header-top">
			        <div class="container">
			           <div class="logo">
						  <a href="/"><h1>Daffodial Beauty Salon</h1></a>
					   </div>
				      <!-- <div class="search">
					   <form>
						<input type="submit" value="">
						<input type="text" value="Search " onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Search';}">
					   </form> 
				  </div>-->
					<!--top-nav-->
				    <span class="menu"> </span>
				    <div class="top-menu">
				      <nav>
					   <ul class="cl-effect-16">
					   
					   
					   
                                	<c:set var = "userStr" value = "${acc.getLoginId()}"/>
                                	<c:set var="intAsString">${acc.getLoginId()}</c:set>
	<c:set var = "len" value = "${fn:length(intAsString)}"/>
	<c:if test="${len==0}">
		<a href="/">Home</a><br>
		      <li><a href="/register">Register</a></li>
              <li><a href="/login">Log In</a></li>
		</c:if>
		<c:set var = "roleStr" value = "${acc.getRole()}"/>
	<c:if test="${len>0}">
		<c:if test="${roleStr == 'ROLE_CLIENT'}">
			<a href="/client">Home</a><br>
			<a href="/logout">Logout</a><br>
		</c:if>
		<c:if test="${roleStr == 'ROLE_DISTRIBUTER'}">
			<a href="/distributer">Home</a><br>
			<a href="/logout">Logout</a><br>
		</c:if>
		<c:if test="${roleStr == 'ROLE_CUSTOMER'}">
			<a href="/customer">Home</a><br>
			<a href="/logout">Logout</a><br>
		</c:if>
				<c:if test="${roleStr == 'ROLE_STAFF'}">
			<a href="/staffmember">Home</a><br>
			<a href="/logout">Logout</a><br>
		</c:if>
	</c:if>
								<!--  <li><a  href="#about" data-hover="About">About</a></li> -->
								<li><a  href="/offers" data-hover="Offers">Offers</a></li>
								<!--  <li><a  href="#team" data-hover="Team">Team</a></li> -->
									<!--  <li><a  href="#news" data-hover="News">News</a></li> -->
								<li><a  href="/gallery" data-hover="Gallery">Gallery</a></li>
							
								          
								<!-- <li><a  href="#contact" data-hover="Contact">Contact</a></li> -->
					      </ul>
				      </nav>		
				   </div>
				   
				<!--script-for-menu-->
				 	<script>
						$( "span.menu" ).click(function() {
						  $( ".top-menu" ).slideToggle( "slow", function() {
							// Animation complete.
						  });
						});
					</script> 
				<!--//script-for-menu-->
				
			</div>
</div>
</div>





	
				
<div class="login-page1">
 <div class="form1">
<form action="/client/addfacilitiescall">
<h3> Add a Treatment and Facility</h3>

<label for ="treatmentId">Treatment Id</label>
<input type="number" id= "treatmentId" name= "treatmentId"  required="required"><br>

<label for ="name">Name</label>
<input type="text" id= "name" name= "name" required="required"><br>

<label for ="cost">cost</label>
<input type="number" id="cost" name="cost" required="required"><br>



<label for ="staffId">Staff Id</label>
<input type="number" id="staffId" name="staffId" required="required"><br>

<label for ="timeRequired">Time Required</label>
<input type="number" id="timeRequired" name= "timeRequired" required="required"><br>

<input type="submit" value="Submit"><br>
</form>
	${displayMssg}
</div>
</div>











              
 <!--contact -->
			 <div id="contact1" class="contact1">
				<div class="container">
				   <h3 class="tittle">Contact Us</h3>
					 <div >
                          <!--contact-form-->
				        </div>
						 <div>
						      
								<div class="con-text">
								<h2> Open 10am - 8pm</h2><br>
										<h3><i class="icon glyphicon glyphicon-home"></i>Address</h3>
										<address>
										Flat No.102 Divine Building<br>
											  21N Sanchar Nagar Kanadiya Road <br> 
											   Near Bangali Square & Sai Mandir, JMB Shop <br>
											   Indore, 452016<br>
											  <abbr title="Phone">Mobile</abbr> 9981562657
											  <abbr title="Phone">Mobile</abbr> 9179144039
											</address>
								</div>
								<div class="con-text">
									  <h3><i class="icon glyphicon glyphicon-envelope"></i>Email</h3>
											<p class="mail">
											 seema196807@gmail.com
											</p>
								</div>
								  <div class="clearfix"> </div>
							</div>
					   <div class="clearfix"> </div>
		           </div>
			    </div>
          <!--//contact-->
	   <div class="copy">
	          <div class="logo two">
			    <a href="/"><h3>Daffodial Beauty Salon</h3></a>
			   </div>
			   <ul class="s_social two">
						<li><a href="https://www.facebook.com/Daffodial-Beauty-Salon-577216429411945"> <i class="fb1"> </i> </a></li>
			
		 			</ul>

		  
	   </div>

</body>
</html>