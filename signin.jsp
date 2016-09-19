<%@ include file="header.jsp" %>
   
   <center>
          <h4>Sign In</h4>
          <p>NOT REGISTERED? <a href= "signup">SIGN UP</a> AND GET EXCITING OFFERS</p>
         
          <p style="color:red; text-align:center">
          ${errorMessage}
        
         <form method="post" action="perform_login">
         
         <input type="text" name="username" placeholder="ENTER YOUR USERID" required><BR><BR><BR>
         <input type="password" name="password" placeholder="ENTER YOUR PASSWORD"><BR><BR><BR>
         <input type="submit" value="SIGN IN">
         </form><br><br>
         <br>
         </center>


<%@ include file="footer.jsp" %>