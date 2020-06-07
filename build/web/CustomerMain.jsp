<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<%@page import="uts.isd.controller.LogoutController" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        
        <%
            Customer customer = (Customer)session.getAttribute("name");

        %>
        
       
            <img src="css/IoTBay_Logo.png" class="logo">
        
        
        <div class="topRight">
            <a class="bttn" href="LogoutController">Logout</a>
        </div>
                      
        
        
        <div class="center">
            <form method="post">
                <input class="searchTb" type="search" placeholder="Search..." name="search">
            </form>
            <div class="cart">
                <a href="cart.jsp">View cart</a>
            </div>
        </div>
        
        <table class="dashboardTable">
            <tr>
                <th class="tabBorder">Profile</th>
                <th class="tabBorder">Categories</th>
                <th class="tabBorder">Sales</th>
                <th class="tabBorder">About us</th>
                <th class="tabBorder">Contact us</th>                
            </tr>
        </table>
        
    </body>
</html>
