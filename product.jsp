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


${message}

<h2>Add the products</h2>
	   
	<form:form action="registerP" method="post" commandName="prod"
		enctype="multipart/form-data">

		<table class="table table-hover">
			<tr>
				<td>Enter Product Id:</td>
				<c:choose>
					<c:when test="${!empty product.pro_Id}">
						<td><form:input path="pro_Id" disable="true"
								readonly="true" /></td>
					</c:when>
					<c:otherwise>
						<td><form:input path="pro_Id" pattern=".{4,7}" required="true" title="id should contain 4 to 7 characters" /></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<td>Enter Product Name:</td>
				<td><form:input type="text" path="pro_name" /></td>
			</tr>
			<tr>
				<td>Enter Product Code:</td>
				<td><form:input type="text" path="prod_ID" /></td>
			</tr>
			<tr>
				<td>Enter Company Name:</td>
				<td><form:input type="text" path="comp_name" /></td>
			</tr>
			<tr>
				<td>Description:</td>
				<td><form:textarea path="description" rows="5" cols="30" /></td>
			</tr>
			<tr>
				<td>Price:</td>
				<td>Rs.<form:input type="text" path="price" /></td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td><form:input type="text" path="quantity" /></td>
			</tr>
			<tr>
				<td><form:label path="supplier">
						<spring:message text="Supplier" />
					</form:label></td>
				<td><form:select path="supplier.sup_name" items="${supplierList}"
						itemValue="sup_name" itemLabel="sup_name"></form:select></td>
			</tr>

			<tr>
				<td><form:label path="category">
						<spring:message text="Category" />
					</form:label></td>
				<td><form:select path="category.cat_name" items="${categoryList}"
						itemValue="cat_name" itemLabel="cat_name"></form:select></td>
			</tr>
			<tr>
				<td>Image</td>
				<td><form:input type="File" path="image" /></td>
				<td><form:input type="File" path="img" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${!empty product.pro_name}">
						<input id="button" type="submit" value="<spring:message text="Edit Product"/>" />
					</c:if>
					<c:if test="${empty product.pro_name}">
						<input id="button" type="submit" value="<spring:message text="Add Product"/>" />
					</c:if></td>
			</tr>
		</table>
	</form:form>

	<br>
	<h3>Product List</h3>
	<c:if test="${!empty productList}">
		<table class="tg">
			<tr>
				<th width="80">Product Id</th>
				<th width="100">Product Code</th>
				<th width="120">Product Name</th>
				<th width="120">Company Name</th>
				<th width="200">Description</th>
				<th width="80">Price</th>
				<th width="80">Quantity</th>
				<th width="80">Category</th>
				<th width="80">Supplier</th>
				<th width="60">Edit</th>
				<th width="60">Delete</th>
			</tr>
			<c:forEach items="${productList}" var="product">
				<tr>
					<td>${product.pro_Id}</td>
					<td>${product.prod_ID}</td>
					<td>${product.pro_name}</td>
					<td>${product.comp_name}</td>
					<td>${product.description}</td>
					<td>${product.price}</td>
					<td>${product.quantity}</td>
					<td>${product.category.cat_id}</td>
					<td>${product.supplier.sup_id}</td>
					<td><a href="<c:url value='product/edit/${product.pro_Id}' />">Edit</a></td>
					<td><a
						href="<c:url value='product/remove/${product.pro_Id}' />">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>



<%@ include file="footer.jsp"%>
