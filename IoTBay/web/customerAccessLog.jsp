<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.Access_Log" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/acessLog.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Access Log Page</title>
    </head>
    <body>
       
        <div class="topRight">
            <a href="customerMain.jsp"><button class="bttn">Go back to main dashboard</button></a>
            <a class="bttn" href="LogoutServlet">Logout</a>
        </div>
        <div class="container">
            <img src="css/IoTBay_Logo.png">
        </div>
        <h1>Access Logs</h1>
            
        <table>
            <tr>
                <td>
                   <div class="center">
                        Logged in as:
                    </div> 
                </td>          
                <td>
                    <div class="center">
                        Access logs of:
                    </div>
                </td>
                <td>
                    <div class="center">
                        <input type="Search" placeholder="Search Date" name="date">
                         <a class="bttn" href="FilterDateServlet">Filter</a>
                    </div>
                </td>
            </tr>
        </table>
        <table class="accessTable">
            <tr>
                <th>Date</th>
                <th>Time</th>
            </tr>
            <c:forEach items="${list}" var="logs" >
            <tr>
                <td class="tabBorder"><c:out value="${logs.date}"/></td>                
                <td class="tabBorder"><c:out value="${logs.time}"/></td>                
            </tr>
        </c:forEach>
        </table>
        
    </body>
</html>
