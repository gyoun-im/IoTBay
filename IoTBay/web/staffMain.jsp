<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/main.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Main Page</title>
    </head>
    <body>
        <%
            Staff staff = (Staff) session.getAttribute("name");
            User_Account user = (User_Account) session.getAttribute("user");
        %>            
        <img src="css/IoTBay_Logo.png" class="logo">        
        <div class="topRight">
            <a class="bttn" href="LogoutServlet">Logout</a>
        </div>
        <div class="user">               
            <p>You're logged in as <%=user.getEmail()%></p>         
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
                <th class="tabBorder"><a href="StaffEditServlet?email='<%=user.getEmail()%>'&password='<%=user.getPassword()%>'">   Profile</th>
                <th class="tabBorder"><a href="StaffAccessLogServlet?email='<%=user.getEmail()%>'&password='<%=user.getPassword()%>'">   Logs</th>
                <th class="tabBorder">Sales</th>
                <th class="tabBorder"><a href="suppliers.jsp">Suppliers</th>
                <th class="tabBorder">About us</th>
                <th class="tabBorder">Contact us</th>                
            </tr>
        </table>        
    </body>
</html>