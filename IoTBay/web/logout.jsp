<%-- 
    Document   : logout
    Created on : 30/04/2020, 10:21:16 PM
    Author     : test
--%>

<%@page import="iotbay.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/login.css" rel="stylesheet" type="text/css">
        <title>Goodbye!</title>
        
    </head>
    <% User user = (User)session.getAttribute("user"); %>
    <body>
        <% session.invalidate(); %>
        <img src="css/IoTBay_Logo.png" class="centerz">

        <p>You have been logged out. Please click <a href="index.jsp">here</a> to go back to the main index page. </p> <br>
        <img src="css/logoutconfirm.png" class="buffer" height="20px">
         
    </body>
</html>
