<%@ include file="header.jsp"%>
<ul class="nav navbar-nav navbar-right">
    <!--  drop down menu -->
     <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">My Profile <span class="caret"></span></a>
        <ul class="dropdown-menu">
        <li><a href="#">My Account</a></li>
        <li><a href="#">My Orders</a></li>
        <li><a href="#">Settings</a></li>
        <li><a href="home">Sign Out</a></li>        
       </ul>
       </li>
       <li><a href="#"><span class="glyphicon glyphicon-shopping-cart">Cart</span></a></li>
      </ul>       
    </div>
    </div>
   <BR>
<div>
    <ul class="nav navbar-nav navbar-left">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">Categories <span class="caret"></span></a>
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
       </ul>
       </li>
    </ul>
  <ul> 
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



<div class="col-md-9">
   <form:form action="registerP"  method="post" commandName="prod" enctype="multipart/form-data">

<table class="table table-hover">
<tr>
    <th>Add the products</th>
    </tr>
    <tr>
    <td>Enter Product Name:</td>
  <td><form:input type="text" path="pro_name" /></td>
   <tr>
    <td>Enter Product Code:</td>
  <td><form:input type="text" path="prod_ID" /></td>
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
  <tr><td>
      <form:label path="sup_id"><spring:message text="Supplier"/></form:label></td>
      <td><form:select path="sup_id" items="${supplierList}"  ></form:select></td> <!-- itemsValue="supplier" itemValue="supplier" -->
      </tr>
      <tr><td>
      <form:label path="cat_id"><spring:message text="Category"/></form:label></td>
      <td><form:select path="cat_id" items="${categoryList}" ></form:select></td> <!-- itemsValue="category" itemValue="category" -->
      </tr>
      <tr>
      <td>Image</td>
      <td><form:input type="File" path="image" /></td>
      <td><form:input type="File" path="img" /></td>      
      </tr>
      <tr>
      <td>
      <input type="submit" value="Add Product" /></td><td>
        
      </tr>
      
</table>
</form:form>
</div>
</div>
</div>
