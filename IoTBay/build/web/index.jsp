<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Index Page</title>
    </head>
    <body>
        <img class="logo" src="css/IoTBay_Logo.png">
        <div>
            <table class="center">
                <tr>
                    <td><a href="login.jsp"><button class="bttn">Login</button></a></td>
                    <td><a href="customerRegister.jsp"><button class="bttn">Register as customer</button></a></td>
                    <td><a href="staffRegister.jsp"><button class="bttn">Register as staff</button></a></td>
                </tr>
            </table>
        </div>
        <div class="center">
            <a href="AccessCustomerMainServlet"><button class="bttn">Continue to IoTBay</button></a>
        </div>
        <jsp:include page="/ConnServlet" flush="true"/>
    </body>
</html>
