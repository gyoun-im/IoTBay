<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<html>
    <head>
        <link rel="stylesheet" href="css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        
            <img src="css/IoTBay_Logo.png" class="logo">
        
        
        <div class="user">
            <p>You're not signed in <a href='customerRegister.jsp'>register</a> or <a href="login.jsp"> login</a></p>
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
                <th class="tabBorder">Logs</th>
                <th class="tabBorder">Sales</th>
                <th class="tabBorder">About us</th>
                <th class="tabBorder">Contact us</th>                
            </tr>
        </table>
        
    </body>
</html>
