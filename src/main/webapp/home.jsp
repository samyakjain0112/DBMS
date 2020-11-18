<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- <!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 Welcome to Daffodial Beauty Parlour

         
          
          <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
           
              <li><a href="/logout">Log Out ( ${pageContext.request.userPrincipal.name} )</a></li>
            </c:when>
            <c:otherwise>
                          <li><a href="/register">Register</a></li>
              <li><a href="/login">Log In</a></li>
            </c:otherwise>
          </c:choose>
          </body>
</html>
          -->
          
          
          
          
          
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
 <link href="/css/form.css" rel='stylesheet' type='text/css' /> 
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
                                <li><a  href="/" data-hover="Home">Home</a></li>
								<!--  <li><a  href="#about" data-hover="About">About</a></li> -->
								<li><a  href="/offers" data-hover="Offers">Offers</a></li>
								<!--  <li><a  href="#team" data-hover="Team">Team</a></li> -->
									<!--  <li><a  href="#news" data-hover="News">News</a></li> -->
								<li><a  href="/gallery" data-hover="Gallery">Gallery</a></li>
								          <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
           
              <li><a href="/logout">Log Out ( ${pageContext.request.userPrincipal.name} )</a></li>
            </c:when>
            <c:otherwise>
                          <li><a href="/register">Register</a></li>
              <li><a href="/login">Log In</a></li>
            </c:otherwise>
          </c:choose>
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
				
               <div class="clearfix"></div>
				</div>
	         </div>
		         <div class="banner-slider">
			            <div class="flexslider">
						<div class="banner-info">
										  <p>We always Pretty</p>
										  <h3>Makeup Art be Gorgeous</h3>
										 </div>
			                <ul class="slides">
									<li data-thumb="images/1.jpg">
										  <img src="images/1.jpg"  alt=""/>
								<!--  	</li>
									<li data-thumb="images/2.jpg">
										  <img src="images/2.jpg"  alt=""/>
									</li>
									<li data-thumb="images/3.jpg">
										  <img src="images/3.jpg"  alt=""/>
									</li> -->
								</ul>
							</div>
							<!-- FlexSlider -->
							  <script defer src="js/jquery.flexslider.js"></script>

								<script>
							// Can also be used with $(document).ready()
							$(window).load(function() {
							  $('.flexslider').flexslider({
								animation: "slide",
								controlNav: "thumbnails"
							  });
							});
							</script>
					 </div>	

     </div>
	 	  <!--about-->
			<div class="about" id="about">
			  <div class="col-md-6 main-bnr-text">
				  <h5>Hello, We are Daffodial Beauty Parlour!!</h5>
				  <h3>About Us</h3>
				  <p> We are a team of people each with some specialization. Our primary focus is cutomer satisfaction. Please try some facility available at us it will be a completely new experience for you. </p>
				  					 
			  </div>
			  <div class="col-md-6  main-bnr-bg"> </div>
			   <div class="clearfix"> </div>		
            </div>
	  <!--services-->
			<div class="welcome" id="service">
				<div class="container">
					<h2>Beauty Care and Health Information</h2>
					 <div class="tip-main">
						   <div class="col-md-4 top-grid">
							 <i class="glyphicon glyphicon-user"></i>
							 <h4 class="ser">Beauty Center</h4>
							 <p class="ser"> Facilities like make-up, bridal saree dressing and waterproof makeups are available</p>
						  </div>		
							<div class="col-md-4 top-grid">
							  <i class="glyphicon glyphicon-eye-open"></i>
								<h4 class="ser">Skin Care Center</h4>
								 <p class="ser">Facials ranging from platinuma and gold to fruit all different categories are available. Padicure, Waxing and many more</p>
						  </div>	
						   <div class="col-md-4 top-grid">
								   <i class="glyphicon glyphicon-tint"></i>
								 <h4 class="ser">Hair Salon</h4>
								  <p class="ser">Straightening, V cut, baby cut, hair dressing and many more.. </p>
						  </div>	
					    <div class="clearfix"> </div>				
					</div>
				</div>
			</div>
    <!--team-->
	<div class="staff" id="team">
      <div class="container">
	      <h3 class="tittle">Our Experts</h3>
		  <div class="team">
           <div class="col-md-3 staff2">
        	<div class="view view-fifth">
                <div class="mask1"><img src="images/t3.jpeg" alt="image" class="img-responsive zoom-img" /></div>
                    <div class="mask">
                      
		                  <div id="small-dialog2" class="mfp-hide">
							   <div class="pop_up2">
							   	  <img src="images/t3.jpeg" class="img-responsive" alt=""/>
								     <h3>About</h3>
							   	   <p class="popup_desc">She has an experience of 30+ years and she is the owner of the salon</p>
							   </div>
						  </div>
					</div>
        	  <h3>Seema Jain</h3>
        	      <p>She has an experience of 20+ years and she is the owner of the salon</p>
        			<ul class="s_social">
						<li><a href="https://www.facebook.com/Daffodial-Beauty-Salon-577216429411945"> <i class="fb1"> </i> </a></li>
					
		 			</ul>
          </div>
        </div>
        <div class="col-md-3 staff2">
        	<div class="view view-fifth">
                <div class="mask1"><img src="images/t1.jpg" alt="image" class="img-responsive zoom-img" /></div>
                    <div class="mask">
                      
		                  <div id="small-dialog1" class="mfp-hide">
							   <div class="pop_up2">
							   	  <img src="images/t1.jpg" class="img-responsive" alt=""/>
								     <h3>About</h3>
							   	  <p class="popup_desc">Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes </p>
							   </div>
							 </div>
					</div>
        	 <h3><a href="#">Pooja Sharma</a></h3>
        	      <p>She is the staff member of the salon and she is very polite</p>
        	   
          </div>
        </div>
        <div class="col-md-3 staff2">
        	<div class="view view-fifth">
                <div class="mask1"><img src="images/t2.jpg" alt="image" class="img-responsive zoom-img" /></div>
                    <div class="mask">
                       
		                  <div id="small-dialog2" class="mfp-hide">
							   <div class="pop_up2">
							   	  <img src="images/t2.jpg" class="img-responsive" alt=""/>
								     <h3>About</h3>
							   	   <p class="popup_desc">Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes </p>
							   </div>
						  </div>
					</div>
        	  <h3><a href="#">Sapna Shinde</a></h3>
        	      <p>She is the staff member of the salon and she is hard working</p>
 
          </div>
        </div>
        <div class="col-md-3 staff2">
        	<div class="view view-fifth">
                <div class="mask1"><img src="images/t4.jpg" alt="image" class="img-responsive zoom-img" /></div>
                    <div class="mask">
                       
		                  <div id="small-dialog3" class="mfp-hide">
							   <div class="pop_up2">
							   	  <img src="images/t4.jpg" class="img-responsive" alt=""/>
								   <h3>About</h3>
							   	   <p class="popup_desc">Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima. Eodem modo typi, qui nunc nobis videntur parum clari, fiant sollemnes </p>
							   </div>
						  </div>
					</div>
        	       <h3>Sarita Kumari</h3>
        	      <p>She is the staff member of the salon and she is very punctual and polite</p>
             </div>
        </div>
        <div class="clearfix"></div>
      </div>
    </div>
</div>
 <!--//team-->
   <div class="packages">	
	  <div class="container">
	      <h3 class="tittle pack"> Packages</h3> 
	     <div class="package-top">
		    <div class="col-md-6 p-left">
            
            	<div class="package1">
                	<h5>Primary Package</h5>
                    <ul class="list-default">
                    	<li>Hair Spa or Hair Cut or Hair Color</li>
                    	<li>Hand Wax </li>
                    	<li>Facial</li>
                    	<li>Threading</li>
                    </ul>
                    <strong class="price">700</strong>
                    
					<div class="clearfix"> </div>
                </div><!-- end package -->
                
                <div class="package">
                	<h5>Medium Package</h5>
                    <ul class="list-default">
                    	<li>Facial</li>
                    	<li>Bleach</li>
                    	<li>Hair Spa or Hair Cut or Hair Color</li>
                    	<li>Hand Wax</li>
                    	<li>Threading</li>
                    	<li>Pedicure</li>
                    </ul>
                    <strong class="price">1000</strong>
                    
					<div class="clearfix"> </div>
                </div><!-- end package -->
                
                <div class="package2">
                	<h5>Premium Package</h5>
                    <ul class="list-default">
                    	<li>Bleach</li>
                    	<li>Facial</li>
                    	<li>Hand oil wax</li>
                    	<li>Manicure</li>
                    	<li>Padicure</li>
                    	<li>Hair Spa</li>
                    	<li>Threading</li>
                    </ul>
                    <strong class="price">1500</strong>
					<div class="clearfix"> </div>
                </div><!-- end package -->
                
            </div>
			<div class="col-md-6 p-right">
            
            	<div class="package1">
                	<h5>Luxury Package</h5>
                    <ul class="list-default">
                   		<li>Spa</li>
                    	<li>Bleach</li>
                    	<li>Facial</li>
                    	<li>Hand oil wax</li>
                    	<li>Manicure</li>
                    	<li>Padicure</li>
                    	<li>Hair Spa</li>
                    	<li>Threading</li>
                    </ul>
                    </ul>
                    <strong class="price">2000</strong>
					<div class="clearfix"> </div>
                </div><!-- end package -->
             
                <div class="package">
                	<h5>Skin and Care Treatment</h5>
                    <ul class="list-default">
                   		<li>Spa</li>
                    	<li>Bleach</li>
                    	<li>Facial</li>
                    	<li>Hand oil wax</li>
                    	<li>Manicure</li>
                    	<li>Padicure</li>
                    	<li>Hair Spa</li>
                    	<li>Threading</li>
                    </ul>
                  <strong class="price">3000</strong>
					<div class="clearfix"> </div>
                </div>
                
                <div class="package2 wow fadeInLeft animated" data-wow-offset="150" data-wow-delay="400m" style="visibility: visible;-webkit-animation-delay: 400m; -moz-animation-delay: 400m; animation-delay: 400m;">
                	<h5>Bridal Makeup</h5>
                    <ul class="list-default">
                   		<li>Spa</li>
                    	<li>Bleach</li>
                    	<li>Facial</li>
                    	<li>Hand oil wax</li>
                    	<li>Manicure</li>
                    	<li>Padicure</li>
                    	<li>Hair Spa</li>
                    	<li>Threading</li>
                    </ul>
                    <strong class="price">4500</strong>
					<div class="clearfix"> </div>
                </div>
                 
                
            </div>
				<div class="clearfix"> </div>
	     </div>
	  </div>
    </div>

<!--start-news-->
<!-- 
	<div class="news" id="news">
		<div class="container">
		    <h3 class="tittle">News</h3>
			<div class="news-top">
			     <div class="col-md-4 news-grid">
					<a href="#"><img src="images/n2.jpg" class="img-responsive" alt="/"> </a>
				   <a class="news" href="#"> New Post With Image</a>
				   <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore...</p>
				   <div class="bog_post_info infoPost">
					   <span class="datePost"><a href="#" class="post_date">Aug 30, 2015</a></span>
					   <span class="commentPost"><a class="icon-comment-1" title="Comments - 2" href="#"><i class="glyphicon glyphicon-comment"></i>2</a></span>
					   <span class="likePost"><i class="glyphicon glyphicon-heart"></i><a class="icon-heart" title="Likes - 4" href="#">4</a></span>
					</div>
				</div>
				<div class="col-md-4 news-grid">
					<a href="#"><img src="images/n1.jpg" class="img-responsive" alt="/"> </a>
				   <a class="news" href="#">Skin Care for Teen Skin</a>
				   <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore...</p>
				   <div class="bog_post_info infoPost">
					   <span class="datePost"><a href="#" class="post_date">Aug 30, 2015</a></span>
					   <span class="commentPost"><a class="icon-comment-1" title="Comments - 2" href="#"><i class="glyphicon glyphicon-comment"></i>2</a></span>
					   <span class="likePost"><i class="glyphicon glyphicon-heart"></i><a class="icon-heart" title="Likes - 4" href="#">4</a></span>
					</div>
				</div>
				<div class="col-md-4 news-grid">
					<a href="#"><img src="images/n3.jpg" class="img-responsive" alt="/"> </a>
				   <a class="news" href="#"> New Post With Image</a>
				   <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore...</p>
				   <div class="bog_post_info infoPost">
					   <span class="datePost"><a href="#" class="post_date">Aug 30, 2015</a></span>
					   <span class="commentPost"><a class="icon-comment-1" title="Comments - 2" href="#"><i class="glyphicon glyphicon-comment"></i>2</a></span>
					   <span class="likePost"><i class="glyphicon glyphicon-heart"></i><a class="icon-heart" title="Likes - 4" href="#">4</a></span>
					</div>
				</div>
				<div class="clearfix"> </div>
		    </div>
		</div>
    </div> 	
	<div class="products">
		<div class="container">
		        <h3 class="tittle pro">We are Use only Top Products</h3>
				
				
		</div>
    </div>	
    -->
<!--start-gallery-->
<div class="gallery" id="gallery">
	<div class="container">
		       <h3 class="tittle">Gallery</h3>
			<div class="top-gallery">
				<div class="col-md-4 gallery-grid gallery1">
					<a href="images/g1.jpg" class="swipebox"><img src="images/g1.jpg" class="img-responsive" alt="/">
						<div class="textbox">
							<h4>>Daffodial Beauty Salon</h4>
							<p>Welcome</p>
							
						</div>
				</a>
				</div>
				<div class="col-md-4 gallery-grid gallery1">
					<a href="images/g2.jpg" class="swipebox"><img src="images/g2.jpg" class="img-responsive" alt="/">
						<div class="textbox">
							<h4>Daffodial Beauty Salon</h4>
							<p>Welcome</p>
						
						</div>
				</a>
				</div>
				<div class="col-md-4 gallery-grid gallery1">
					<a href="images/g3.jpg" class="swipebox"><img src="images/g3.jpg" class="img-responsive" alt="/">
						<div class="textbox">
							<h4>>Daffodial Beauty Salon</h4>
							<p>Welcome</p>
							
						</div>
				</a>
				</div>
				<div class="col-md-4 gallery-grid gallery1">
					<a href="images/g4.jpg" class="swipebox"><img src="images/g4.jpg" class="img-responsive" alt="/">
						<div class="textbox">
							<h4>>Daffodial Beauty Salon</h4>
							<p>Welcome</p>
							
						</div>
				</a>
				</div>
				
				<div class="col-md-4 gallery-grid gallery1">
					<a href="images/g5.jpg" class="swipebox"><img src="images/g5.jpg" class="img-responsive" alt="/">
						<div class="textbox">
							<h4>>Daffodial Beauty Salon</h4>
							<p>Welcome</p>
							
						</div>
					</a>
				</div>
				
				<div class="col-md-4 gallery-grid gallery1">
					<a href="images/g6.jpg" class="swipebox"><img src="images/g6.jpg" class="img-responsive" alt="/">
						<div class="textbox">
							<h4>>Daffodial Beauty Salon</h4>
							<p>Welcome</p>
					   </div>
				   </a>
				</div>
				
				<div class="col-md-4 gallery-grid gallery1">
					<a href="images/g7.jpg" class="swipebox"><img src="images/g7.jpg" class="img-responsive" alt="/">
						<div class="textbox">
							<h4>>Daffodial Beauty Salon</h4>
							<p>Welcome</p>
							
						</div>
					</a>
				</div>
				
								<div class="col-md-4 gallery-grid gallery1">
					<a href="images/g8.jpg" class="swipebox"><img src="images/g8.jpg" class="img-responsive" alt="/">
						<div class="textbox">
							<h4>>Daffodial Beauty Salon</h4>
							<p>Welcome</p>
					
							
						</div>
					</a>
				</div>
				
				
				
				
					<div class="col-md-4 gallery-grid gallery1">
					<a href="images/g9.jpg" class="swipebox"><img src="images/g9.jpg" class="img-responsive" alt="/">
						<div class="textbox">
							<h4>>Daffodial Beauty Salon</h4>
							<p>Welcome</p>
							
						</div>
					</a>
				</div>
				
				<div class="clearfix"> </div>
			</div>
		</div>	
	</div>
	<!--//gallery-->
<div class="testimonials" id="test">	
	  <div class="container">
	   <h3 class="tittle what">What Our Customers Say</h3>
		<div class="callbacks_container">
					<ul class="rslides" id="slider3">
						<li>
							<div class="testi-text">
								<div class="testi-img">
									<img src="images/client2.jpg" alt=""/>
								</div>
								<h4>- Shalini Ghosh</h4>
								<p>Geat a very uniques experience and very good service</p>
							</div>
						</li>
						<li>
							<div class="testi-text">
								<div class="testi-img">
									<img src="images/client.jpg" alt=""/>
								</div>
								<h4>- Nandini Garg</h4>
								<p> Very unique treatments are available at very cheap market price</p>
							</div>
						</li>
						<li>
							<div class="testi-text">
								<div class="testi-img">
									<img src="images/client1.jpg" alt=""/>
								</div>
					         	<h4>- Apoorva Doshi</h4>
								<p>Love attending Spa facilities feels very relaxed</p>
							</div>
						</li>
					</ul>
				</div>
		</div>
	</div>
	<!--banner-text Slider starts Here-->
		<script src="js/responsiveslides.min.js"></script>
		<script>
			// You can also use "$(window).load(function() {"
				$(function () {
				// Slideshow 3
					$("#slider3").responsiveSlides({
					auto: true,
					pager:true,
					nav:false,
					speed: 500,
					namespace: "callbacks",
					before: function () {
					$('.events').append("<li>before event fired.</li>");
					},
					after: function () {
						$('.events').append("<li>after event fired.</li>");
					}
				});	
			});
		</script>

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
          