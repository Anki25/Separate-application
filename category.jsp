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
	
	<h1>Add a Category</h1>
	<c:url var="addAction" value="/category/add"></c:url>
	<form:form action="${addAction}" commandName="category">
	<table class="table table-hover">
	<tr><td>
	<form:label path="cat_id"><spring:message text="Category ID"/></form:label></td>
	<c:choose>
	<c:when test="${!empty category.cat_id}">
	<td><form:input path="cat_id" disabled="true" readonly="true"/></td>
	</c:when>
	<c:otherwise>
	<td><form:input path="cat_id" required="true"/></td>
	</c:otherwise>
	</c:choose></tr>
	<tr><td>
	<form:label path="cat_name"><spring:message text="Name"/></form:label></td>
	<td><form:input path="cat_name" required="true"/></td></tr>
	<tr><td><form:label path="description"><spring:message text="Description"/></form:label></td>
	<td><form:input path="description" required="true"/></td>
	</tr>
	<tr>
	<td colspan="2"><c:if test="${!empty category.cat_name}">
	<input id="button" type="submit" value="<spring:message text="Edit Category"/>" />
	</c:if><c:if test="${empty category.cat_name}">
	<input id="button" type="submit" value="<spring:message text="Add Category"/>" />
	</c:if></td>
	</tr>
	</table>
	</form:form>
	<br>
	<h3>Category List</h3>
	<c:if test="${!empty categoryList}">
	<table class="tg">
	<tr>
	<th width="80">Category Id</th>
	<th width="120">Category Name</th>
	<th width="120">Description</th>
	<th width="60">Edit</th>
	<th width="60">Delete</th>
	</tr>
	<c:forEach items="${categoryList}" var="category">
	<tr>
	<td>${category.cat_id}</td>
	<td>${category.cat_name}</td>
	<td>${category.description}</td>
	<td><a href="<c:url value='category/edit/${category.cat_id}' />">Edit</a></td>
	<td><a href="<c:url value='category/remove/${category.cat_id}' />">Delete</a></td>
	</tr>
	</c:forEach>
	</table>
	</c:if>
	<br>
