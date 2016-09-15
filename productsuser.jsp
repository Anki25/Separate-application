 <%@ include file="header.jsp" %>
  <ul class="nav navbar-nav navbar-right">
					<li><a href="signin">Sign In </a></li> 
				 <li><a href="signup">Sign Up</a></li> 
						
				</ul>
			</div>
		</div>
		<br>

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
							</div>
						</div>
					</form>
				</div>
			</ul>
		</div>
	</nav>
 
 <div class="container" ng-app="" >
  
 <table>
 <thead>
   <tr>
      <th>Image</th>
      <th>Name</th>
      <th>Price</th>
      <td>More</td>
      
   </tr>
   </thead>
   
   <tbody>
   <tr ng-repeat = "prod in product">
      <td><img src="resources/images/{{ prod.pro_id}}.jpg"></td>
      <td>{{ prod.pro_name }}</td>
      <td>{{ prod.price }}</td>
      <td>{{prod.more}}</td>
      
          
       </tr>
   </tbody>
</table>
</div>	