
<%@ include file="header.jsp"%>
<ul class="nav navbar-nav navbar-right">
	<!--  drop down menu -->
	<li class="dropdown"><a href="#" class="dropdown-toggle"
		data-toggle="dropdown">My Profile <span class="caret"></span></a>
		<ul class="dropdown-menu">
			<li><a href="#">My Account</a></li>
			<li><a href="#">My Orders</a></li>
			<li><a href="#">Settings</a></li>
			<li><a href="home">Sign Out</a></li>
		</ul></li>
	<li><a href="#"><span
			class="glyphicon glyphicon-shopping-cart">Cart</span></a></li>
</ul>
</div>
</div>
<BR>
<div>
	<ul class="nav navbar-nav navbar-left">
		<li class="dropdown"><a href="#" class="dropdown-toggle"
			data-toggle="dropdown">Categories <span class="caret"></span></a>
			<ul class="dropdown-menu">
				<li><a href="#">Indoor Lightings</a></li>
				<li><a href="#">flat panel</a></li>
				<li><a href="#">surface panel</a></li>
				<li><a href="#">external lunar</a></li>
				<li><a href="#">led strip</a></li>
				<li><a href="#">color changing led panel light</a></li>
				<li><a href="#">Outdoor Lightings</a></li>
				<li><a href="#">pathway</a></li>
				<li><a href="#">street & roadway</a></li>
				<li><a href="#">decorative street & roadway</a></li>
				<li><a href="#">parking structure</a></li>
				<li><a href="#">high mast</a></li>
			</ul></li>
	</ul>
	<ul>
		<div>

			<form class="bs-example bs-example-form" role="form">
				<div class="row">
					<div class="col-lg-6">
						<div class="input-group">
							<input type="text" class="form-control"> <span
								class="input-group-btn">
								<button class="btn btn-default" type="button">Go!</button>
							</span>

						</div>
						<!-- /input-group -->
					</div>
					<!-- /.col-lg-6 -->

				</div>
				<!-- /.row -->
			</form>

		</div>

	</ul>
</div>
</nav>


<div class="container">
	<div class="row">
		<div class="col-md-3">
			<div class="sidebar-nav-fixed affix">
				<div class="well">
					<ul class="nav ">
						<li class="nav-header">Edit the Contents</li>
						<li><a href="#">Home</a></li>
						<li><a href="#">About us</a></li>
						<li><a href="#">Contact Us</a></li>

					</ul>
				</div>
			</div>
		</div>

		<div class="col-md-9">
			<div class="well">
				<div class="page-header">
					<h1>Welcome Admin!</h1>
				</div>
				<div class="jumbotron">
					<p align="center">Let's make Some Change</p>
				</div>

				<a class="button" href="manageproduct" style="vertical-align: middle"><span>Products </span></a> 
				<a	class="button" href="managecategory" style="vertical-align: middle"><span>Categories</span></a>

				<a class="button" href="managesupplier"
					style="vertical-align: middle"><span>Suppliers</span></a>

			</div>
		</div>

	</div>
</div>

<%@ include file="footer.jsp"%>

