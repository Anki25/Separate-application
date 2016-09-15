   <%@ include file="header.jsp" %> 
    <ul class="nav navbar-nav navbar-right">
    <li><a href="signin">Sign In </a></li>
    <li><a href="signup">Sign Up</a></li>
    </ul>   
    </div>   
    </div>
</div><br>

  <div>
    <ul class="nav navbar-nav navbar-left">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Categories <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <li><a href="#">LED Lights</a></li>
        <li><a href="#">Lamps</a></li>
        <li><a href="#">Chandeliers</a></li>
        <li><a href="HOME.html">Wall Mounted Lights</a></li>
        <li><a href="HOME.html">Lanterns</a></li>
        <li><a href="HOME.html">Festive Lights</a></li>
        <li><a href="HOME.html">Street Lights and High Masts</a></li>
        </ul>
       </li>
    </ul>
    <ul> <!--
<form class = "form-inline" role="form" method="get" action="#">
<div class = "row">
<div class = "col-lg-10">
      <label>
      <input LIST = "STAT"  class = "form-control input-sm" id = "SEARCH" placeholder = "Start Your Search Here..." width: 1000px>
<DATALIST ID="STAT">
<OPTION VALUE="LED">
<OPTION VALUE="INDOOR LIGHTING">
<OPTION VALUE="OUTDOOR LIGHTING">
<OPTION VALUE="LAMPS">
<OPTION VALUE="TUBELIGHTS">
</DATALIST>
<button type = "submit" class = "btn btn-default btn-sm">Begin</button>
</div></div>
</form> -->
 <div>
    
   <form class = "bs-example bs-example-form" role = "form">
      <div class = "row">
 <div class = "col-lg-6">
            <div class = "input-group">
               <input type = "text" class = "form-control">
               
               <span class = "input-group-btn">
                  <button class = "btn btn-default" type = "button">
                     Go!
                  </button>
               </span>
               
            </div><!-- /input-group -->
         </div><!-- /.col-lg-6 -->
         
      </div><!-- /.row -->
   </form>
   
</div>
    </ul>
  </div>
 </nav> 

   

<!-- <div id="wrapper">
sidebar 
   <div id="sidebar-wrapper">
     <ul class="sidebar-nav">
       <li a href="#">Account</a></li>
       <li a href="#">Settings</a></li>
       <li a href="#">LogOut</a></li>  
      </ul>   
   </div> 


page content
    <div id="page-content-wrapper">
      <div class="container-fluid">
        <div class="row">
          <div class="column-lg-12">
        <a href="#" class="btn btn-success" id="menu-toggle">Toggle Menu</a>
        <h1>Sidebar menu</h1>
        <p>aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa
        aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa</p>
         </div>
        </div>         
      </div>  
    </div>
 </div>   
Menu toggle script
<script>
  $("#menu-toggle").click(function (e)){
	  e.preventDefault();
	  $("#wrapper").toggleClass("toggled");
  }
</script> -->

<p style="color:red; text-align:center">
${signinmsg}
</p><br>

<div id="myCarousel" class="carousel slide">
<ol class="carousel-indicators">
 <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
 <li data-target="#myCarousel" data-slide-to="1"></li>
 <li data-target="#myCarousel" data-slide-to="2"></li>
</ol>

<div class="carousel-inner">
 <div class ="item">
 <img src="resources/images/LampsB.jpg" alt="4"  class="img-responsive">
 <div class="carousel-caption"><h3>Offers</h3></div>
  </div>
  
 <div class ="item active">
 <img src="resources/images/sale.jpg" alt="5"  class="img-responsive">
 <div class="carousel-caption"><h3>Offers</h3></div>
  </div>
 
 <div class ="item">
 <img src="resources/images/solar.jpg" alt="6"  class="img-responsive">
 <div class="carousel-caption"><h3>Offers</h3></div>
  </div>   
</div>

<a class="carousel-control left" href="#myCarousel" data-slide="prev">
<span class="icon-prev"></span>
</a>

<a class="carousel-control right" href="#myCarousel" data-slide="next">
<span class="icon-next"></span>
</a>

</div>
<br><br>
   

<div class="row">
  <div class="col-md-4" align="center">
    <a href="images" class="thumbnail">
      <p>LEDs</p> 
      <img src="resources/images/led.jpg" class="img-circle" style="width:350px;height:300px">
    </a>
  </div>
  <div class="col-md-4" align="center">
    <a href="images" class="thumbnail">
      <p>Lamps</p>
      <img src="resources/images/lamps.jpg" class="img-circle" style="width:350px;height:300px">
    </a>
  </div>
  <div class="col-md-4" align="center">
    <a href="images" class="thumbnail">
      <p>Chandeliers</p> 
      <img src="resources/images/chandeliers.jpg" class="img-circle" style="width:350px;height:300px">
    </a>
  </div>
</div>

<div class="row" >
  <div class="col-md-4" align="center">
    <a href="images" class="thumbnail">
      <p>Wall Mounted Lights</p> 
      <img src="resources/images/wall mounted.jpg" class="img-circle" style="width:350px;height:300px">
    </a>
  </div>
</div>

<div class="row">
  <div class="col-md-4" align="center">
    <a href="images" class="thumbnail">
      <p>Lanterns</p> 
      <img src="resources/images/lanterns.jpg" class="img-circle" style="width:350px;height:300px">
    </a>
  </div>
  <div class="col-md-4" align="center">
    <a href="images" class="thumbnail">
      <p>Festive Lights</p>
      <img src="resources/images/festive.jpg" class="img-circle" style="width:350px;height:300px">
    </a>
  </div>
  <div class="col-md-4">
    <a href="images" class="thumbnail" align="center">
      <p>Stret Lights and High Masts</p> 
      <img src="resources/images/high mast.jpg" class="img-circle" style="width:350px;height:300px">
    </a>
  </div>
</div>

 <a href="productsuser">Products</a>

<%@ include file="footer.jsp" %>