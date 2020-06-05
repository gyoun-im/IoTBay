<%-- 
    Document   : register
    Created on : 01/05/2020, 3:32:27 PM
    Author     : test
--%>

<%@page import="iotbay.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/login.css" rel="stylesheet" type="text/css">
        <title>Register an account - IoTBay</title>
    </head>
    <body>
       <img src ="css/IoTBay_Logo.png"  alt="IoTBay" width="105px" height="85px"><br></br><br></br>
        <div class="absolute"><h4> Already a member? <a href="login.jsp"> Sign in </a></h4></div>
        <h1 align="center">Create an account</h1>
        <h2 align="center"> Want to become an IoTBay Member? Register now! </h2>
        
        <form method="post" action ="welcome.jsp">
            
        <table class="center"> 
            <tr><td>Name:</td></tr><tr><td><input type="text" placeholder="Enter Name" name="name" required="true"></td></tr>
            <tr><td>Email:</td></tr><tr><td><input type="text" placeholder="Enter email" name="email" required></td></tr>
                <tr><td>Password:</td></tr><tr><td><input type="password" placeholder="Enter Password" name="password" required></td></tr>
                <tr><td>Date of Birth:</td></tr><tr><td><input type="date"  name="dob" placeholder="dd/mm/yyyy" required ></td></tr>
                <tr><td> <input type="checkbox" name="tos" required="true"> By creating an account you agree to our <a href="terms.jsp"> Terms of <br>        Service </a> and <a href="Privacy">Privacy Policy </a> </br> </td> </tr> 
               
          
                
            </table>
         
            <a href="index.jsp"> <button type="button" class="buttoncancelposition">Cancel </button></a> 
           
           <button type="submit"> Register </button>
        
            
        </form>
    </body>
</html>
