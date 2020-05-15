<%-- 
    Document   : welcome
    Created on : 01/05/2020, 4:46:02 PM
    Author     : test
--%>

<%@page import="iotbay.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="css/login.css" rel="stylesheet" type="text/css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <title>Welcome to IoTBay</title>
    </head>
    <body>
        
         <%  String name  = request.getParameter("name"); 
         String email = request.getParameter("email"); 
         String password = request.getParameter("password");
         String dob = request.getParameter("dob"); 
            
         User user = new User(name, email, password, dob);
         session.setAttribute("user", user); 
             
            
            
          user = (User)session.getAttribute("user");%>
        
         <%  if (user == null) { %>
         <p style="text-align:right; vertical-align:middle"><img src ="css/IoTBay_Logo.png"  alt="IoTBay" width="100px" height="95px" align="left">
             <a href="Login.jsp"> Sign in</a> or <a href='Register.jsp'> Sign up </a> </p>
         <br> 
         <h1 style="margin-top:270px;"> Welcome Guest User! </h1>
        
        <% } else { %>
        
        <p style="text-align:right; position: relative"><img src ="css/IoTBay_Logo.png"  alt="IoTBay" width="100px" height="95px" align="left"> <a href="logout.jsp" class="logout">Logout </p> </a>
    
          <h1 style="margin-top:150px;">Welcome, <%= name %> !</h1>
        <p> Your email is : <%= email %> </p>
        <p> Your password is : <%= password  %> </p>
        <p> Your date of birth is : <%= dob  %>  </p>
        <br> </br>
        <% } %>

        
        <h2> Start browsing our Internet of Things products by exploring the main page! </h2>
         <a href="main.jsp"><button type="button" class="mainpage"> Main Page </button></a> 
      <a href="index.jsp"> <button type="button" class="indexpagebutton">  Go back to index page </button> </a>
       
        
        
       
    </body>
</html>
