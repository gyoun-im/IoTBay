<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<html>
    <head>
        <link rel="stylesheet" href="css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <body>
        
      
        <%
            Customer customer = (Customer)session.getAttribute("customer");
            User_Account user = (User_Account) session.getAttribute("user");  
        %>
        
       
            <img src="css/IoTBay_Logo.png" class="logo">
        
        
        <div class="topRight">
            <a class="bttn" href="LogoutServlet">Logout</a>
        </div>
            
            <div class="user">
                
                <p>You're logged in as</p>
                <p>You're not signed in <a href='register.jsp'>register</a> or <a href="login.jsp"> login</a></p>
           
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
                <th class="tabBorder"><a href="CustomerEditServlet?email='<%=user.getEmail()%>'&password='<%=user.getPassword()%>'">   Profile</th>
                <th class="tabBorder">Categories</th>
                <th class="tabBorder">Sales</th>
                <th class="tabBorder">About us</th>
                <th class="tabBorder">Contact us</th>                
            </tr>
        </table>
        
    </body>
</html>