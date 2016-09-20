  <%@ include file="header.jsp" %>
  
  <div>
  <div class="container" ng-app="myApp" ng-controller="dataCtrl" >
  
  <table>
  
  <thead>
   <tr>
      <th>Image</th>
      <th>Name</th>
      <th>Company</th>
      <th>Price</th>
      <th>More</th>
      
   </tr>
   </thead>
   
    <tbody><tr>
   <td>
				<div class="thumbnail" align="center">
				<img src="resources/images/${product.pro_Id}.jpg" class="img-circle" style="width:350px;height:300px">
				<p style="float:left">${product.pro_name}</p>
				<p style="float:right">Rs.${product.price}</p><br />
				<a href="viewProduct" class="btn btn-success">View</a></div>&nbsp;&nbsp;&nbsp;</td>
		<td><a href="#">Add to cart</a></td>		
  </tr>
  
  </table>
  
  
  <%--  <c:if test="${!empty productList}">
 
 <img src="resources/images/${product.pro_Id}.jpg" class="img-circle" style="width:350px;height:300px">
				<p style="float:left">${product.pro_name}</p>
				<p style="float:right">Rs.${product.price}</p><br />
				
 
 </c:if>
 --%> 
 <%@ include file="footer.jsp" %>