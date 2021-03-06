<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/accessLog.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Access Log Page</title>
    </head>
    <body>
        <div class="topRight">
            <a href="staffMain.jsp"><button class="bttn">Go back to main dashboard</button></a>
            <a class="bttn" href="LogoutServlet">Logout</a>
        </div>
        <div class="container">
            <img src="css/IoTBay_Logo.png">
        </div>
        <h1>Access Logs</h1>
        <table>
            <tr> 
                <td>
                    <form action="FilterDateServlet" method="post">
                        <div class="center">
                            <input type="text" placeholder="Search Date" name="date">
                            <input type="text" placeholder="Search user Id" name="userId">
                            <a><input class="sbttn" type="submit" value="Filter"></a>
                        </div>
                    </form>
                </td>
            </tr>
        </table>
        <table class="accessTable">
            <tr>
                <th>Id</th>
                <th>Date</th>
                <th>Time</th>
                <th>Action</th>
            </tr>
            <c:forEach items="${list}" var="logs" >
                <tr>
                    <td class="tabBorder">${logs.accid}</td>     
                    <td class="tabBorder"><c:out value="${logs.date}"/></td>                
                    <td class="tabBorder"><c:out value="${logs.time}"/></td>                
                    <td class="tabBorder"><c:out value="${logs.action}"/></td>                
                </tr>
            </c:forEach>
        </table>
    </body>
</html>