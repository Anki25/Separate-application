  <%@ include file="header.jsp" %>
  
 <div class="container">
	<div class="row">
		<div class="col-md-4">
		<div id="myCarousel" class="carousel slide" >
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img src="resources/images/${product.pro_Id}.jpg" class="img-rounded" style="width:350px;height:300px">
    </div>

    <div class="item">
      <img src="resources/images/${product.prod_ID}.jpg" class="img-rounded" style="width:350px;height:300px">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
		</div>
				
				
			<div class="col-md-8">	
				
				<p style="font-weight:bold;font-size: 200%;">${product.pro_name}</p>
				<p style="font-weight:bold;font-size: 250%;"><i class="fa fa-inr" aria-hidden="true"></i>${product.price}</p><br />
				<p>Brand: ${product.comp_name}</p>
				<p>Sold By: ${product.supplier.sup_name}</p><br/>
				<p>Product Description: ${product.description }</p><br/>
				<a href="addtocart?pro_Id=${product.pro_Id}?userid=${loggedInUserID}" class="btn btn-success">Add to Cart</a>&nbsp;&nbsp;&nbsp;
				
		</div>
		</div>
		</div>
		
  <br /><br /><br />
  <%@ include file="footer.jsp" %>