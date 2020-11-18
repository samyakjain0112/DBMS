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


<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
	</script>
	
	
<script>
	function toggleBox(x) {
		x.classList.toggle('opened');
	}
</script>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">



<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<link href="/css/style.css" rel="stylesheet" type="text/css" media="all" />







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
				
				
				


				<div class="dropdown-list-container">
	<form-title><center><h2>Client</h2></center></form-title>
		
		<div class="dropdown-list-element">
			<div class="dropdown-title-container not-border" onclick="toggleBox(this)">
    			<div class="arrow"></div>
    			<div class="title-text">Profile</div>
  			</div>
			<div class="content">
			<ul class="dropdown-list-items">
			  <li><a href="/client/profile/${loggedInUsername}">${loggedInUsername} Profile</a></li>


			</ul>
			</div>
		</div>
				
		
		<div class="dropdown-list-element">
			<div class="dropdown-title-container not-border" onclick="toggleBox(this)">
    			<div class="arrow"></div>
    			<div class="title-text">Customer</div>
  			</div>
			<div class="content">
			<ul class="dropdown-list-items">
			
              <li><a href="/client/addcustomer">Add a Customer</a></li>
                            
              <li><a href="/client/viewcustomers">View Customers </a></li>
              
              <li><a href="/client/deletecustomer">Delete a Customer</a></li>

              <li><a href="/client/seetodayappointment">Today's Appointments</a></li>

			</ul>
			</div>
		</div>
		
		
		
		
		
		<div class="dropdown-list-element">
			<div class="dropdown-title-container not-border" onclick="toggleBox(this)">
    			<div class="arrow"></div>
    			<div class="title-text">StaffMember</div>
  			</div>
			<div class="content">
			<ul class="dropdown-list-items">
			
              
              <li><a href="/client/addstaffmember">Add a StaffMember</a></li>
              
              <li><a href="/client/viewstaffmembers">View Staff Members</a></li>
              
              
              <li><a href="/client/deletestaffmember">Delete a StaffMember</a></li>


			</ul>
			</div>
		</div>
		
		
				<div class="dropdown-list-element">
			<div class="dropdown-title-container not-border" onclick="toggleBox(this)">
    			<div class="arrow"></div>
    			<div class="title-text">Distributer</div>
  			</div>
			<div class="content">
			<ul class="dropdown-list-items">
			
              <li><a href="/client/adddistributer">Add a distributer</a></li>

              
                            
              <li><a href="/client/viewdistributers">View Distributers </a></li>


              <li><a href="/client/deletedistributer">Delete a distributer</a></li>


			</ul>
			</div>
		</div>
		
		
				<div class="dropdown-list-element">
			<div class="dropdown-title-container not-border" onclick="toggleBox(this)">
    			<div class="arrow"></div>
    			<div class="title-text">Treatment and Facilities</div>
  			</div>
			<div class="content">
			<ul class="dropdown-list-items">
			
              <li><a href="/client/addfacilities">Add a Treatment</a></li>
                
              <li><a href="/customer/seefacilities">View Treatment and Facilities Offered</a></li>
              
              <li><a href="/client/deletefacilities">Delete a Treatment</a></li>

			</ul>
			</div>
		</div>
		
		
				<div class="dropdown-list-element">
			<div class="dropdown-title-container not-border" onclick="toggleBox(this)">
    			<div class="arrow"></div>
    			<div class="title-text">Products for Sale</div>
  			</div>
			<div class="content">
			<ul class="dropdown-list-items">
			
              <li><a href="/client/addproduct">Add Products and Cosmetics for Sale</a></li>

              
              <li><a href="/customer/viewproducts">View Products and Cosmetics for Sale</a></li>

         
              <li><a href="/client/deleteproduct">Delete  Products and Cosmetics for Sale</a></li>


			</ul>
			</div>
		</div>
		
		
		
						<div class="dropdown-list-element">
			<div class="dropdown-title-container not-border" onclick="toggleBox(this)">
    			<div class="arrow"></div>
    			<div class="title-text">Products Required from Distributer</div>
  			</div>
			<div class="content">
			<ul class="dropdown-list-items">
			
              <li><a href="/client/addproductrequired">Add Products Required</a></li>
         
                                     
              <li><a href="/client/seeproductrequired">View Products Required</a></li>
         
                            
              <li><a href="/client/deleteproductrequired">Delete Products Required</a></li>
         

			</ul>
			</div>
		</div>
		
		
		
				
		<div class="dropdown-list-element">
			<div class="dropdown-title-container not-border" onclick="toggleBox(this)">
    			<div class="arrow"></div>
    			<div class="title-text">Payments and Feedbacks</div>
  			</div>
			<div class="content">
			<ul class="dropdown-list-items">
			
              <li><a href="/client/seetodaypurchases">Today's Purchases</a></li>

              
              <li><a href="/client/viewfeedback">Feedbacks</a></li>
            

			</ul>
			</div>
		</div>
		
		
		
	</div>
	
				
				
				
				
				
				
				
				
				
				
<!--  
            
              <li><a href="/client/profile/${loggedInUsername}">${loggedInUsername} Profile</a></li>
              Client can view all his profile and return also
              Return page
              
              
              <li><a href="/client/addcustomer">Add a Customer</a></li>
              The client can add a customer
              Return page
              
              <li><a href="/client/viewcustomers">View Customers </a></li>
              Client can view customers 

              <li><a href="/client/deletecustomer">Delete a Customer</a></li>
              The client can delete a customer
              Return page
              
              
              <li><a href="/client/adddistributer">Add a distributer</a></li>
              The client can add a distributer
              Return page
              
                            
              <li><a href="/client/viewdistributers">View Distributers </a></li>
              Client can view distributers 

              <li><a href="/client/deletedistributer">Delete a distributer</a></li>
              The client can delete a distributer
              Return page
              
              
              <li><a href="/client/addstaffmember">Add a StaffMember</a></li>
              The client can add a staffmember
              Return page

              
              <li><a href="/client/viewstaffmembers">View Staff Members</a></li>
              Client can view staffmembers               
              
              <li><a href="/client/deletestaffmember">Delete a StaffMember</a></li>
              The client can delete a staffmember
              Return page
              
                            
              <li><a href="/client/seetodayappointment">Today's Appointments</a></li>
              Client can see todays appointments with all the customer details
              Return page
              
              <li><a href="/client/addfacilities">Add a Treatment</a></li>
              Client can add  a treatment he wishes to give
              Return page
               
              <li><a href="/customer/seefacilities">View Treatment and Facilities Offered</a></li>
              Client can view treatment and facilities 
              
              
              <li><a href="/client/deletefacilities">Delete a Treatment</a></li>
              Client can delete a treatment he wishes to give
              Return page

              <li><a href="/client/addproduct">Add  Products and Cosmetics for Sale</a></li>
              Client can add products which he wants to sell
              View present products also
              Return page
              
              <li><a href="/customer/viewproducts">View Products and Cosmetics for Sale</a></li>
              Client can view present product
              Link to add product
              Return page
         
              <li><a href="/client/deleteproduct">Delete  Products and Cosmetics for Sale</a></li>
              Client can delete products which he wants to sell
              View present products also
              Return page 

              <li><a href="/client/addproductrequired">Add Products Required</a></li>
              Client can add the products he wants from distributer
                                     
              <li><a href="/client/seeproductrequired">View Products Required</a></li>
              Client can view products he wants from distributer     
                            
              <li><a href="/client/deleteproductrequired">Delete Products Required</a></li>
              Client can delete the products he wants from distributer
              
              
              <li><a href="/client/seetodaypurchases">Todays Purchases</a></li>
              Client can see all the purchases of today
              Money made today
              
              <li><a href="/client/viewfeedback">Feedbacks</a></li>
              Client can see all feedbacks 
-->

                      












              
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
