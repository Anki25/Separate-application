<%@ include file="header.jsp" %>

  </div>
  </div>
</nav>


<center>
<h1>Registration</h1>
<p>ALREADY REGISTERED? <a href= "signin">SIGN IN</a></p>
<a href="${flowExecutionUrl}&_eventId_home">Home</a>
<form:form commandName="us"  >
  
<table>
<tr><td>
Name</td><td><form:input type="text" path="name" /></td></tr>
 <!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('name')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 

<tr><td>
Choose a User Name</td><td><form:input type="text" path="userID"  /></td></tr>
<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('userID')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
<tr><td>
Enter Password</td><td><form:input type="password" path="password"  /></td></tr>
<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('password')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 

<tr><td>
Enter Confirmed Password</td><td><form:input type="password" path="cpassword"  /></td></tr>
<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('cpassword')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 
				<tr><td>
Email Id</td><td><form:input type="email" path="emailid" /></td></tr>
<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('emailid')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 

				

<tr><td>
Phone no.</td><td><form:input type="text" path="mobileno" /></td></tr>
<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('mobileno')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 


<tr><td>
City</td><td> <form:input type="text" path="address" /></td></tr>

<!-- to display validation messages -->
				<c:forEach
					items="${flowRequestContext.messageContext.getMessagesBySource('address')}"
					var="err">
					<div>
						<span>${err.text}</span>
					</div>
				</c:forEach> 

<tr><td>
<input type="CHECKBOX" NAME="OFFER" CHECKED>I agree to receive information about exciting offers
</td></tr>
</table>

<br /><br />

<div class="center">
<input type="submit" name="_eventId_submit" value="submit" ></div>

</form:form>
</center><br />
<%@ include file="footer.jsp" %>