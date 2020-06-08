<%-- 
    Document   : login
    Created on : 01/05/2020, 3:32:02 PM
    Author     : test
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="iotbay.model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/login.css" rel="stylesheet" type="text/css">
        <title>Login to IoTBay</title>
    </head>
    <body>
        <a href="index.jsp"><img src ="css/IoTBay_Logo.png"  alt="IoTBay" width="100px" height="95px" ></a><br></br><br></br><br></br>
         <h1>Hello!</h1>
        
        <h2> Sign in to IoTBay or continue as <a href="main.jsp" class="test"> guest user here </a></h2>
        <form action="LoginServlet" method="post">
            
        
        <table class="center" >
            <tr><td>Email </td></tr>
            <tr><td><input type ="text" class="no-outline" name="email" placeholder="Enter email" required></td></tr>
            <tr><td> Password</td></tr>
            <tr><td> <input type ="password" class="no-outline" name="password" placeholder="Enter password" required></td></tr>            
        </table>
        
            
            <div> 
               <button class="buttonposition" type="submit"> Sign in </button> 
              
            </div>
             </form>
    
        <p> Don't have an account? Create an account <a href="register.jsp" class='test'> here </p></a>
        <p> Go back to <a href="index.jsp" class='test'> index page </a></p>
            
         
           
                     


    </body>
</html>
