<%-- 
    Document   : index
    Created on : 17/04/2020, 1:55:26 PM
    Author     : Cowton
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/css1.css">
        <title>Homepage</title>
    </head>
    <body>
        
      <div class="center">   <h1>IoTBay</h1>
        <a href="paymentDetails.jsp" class="button button1" >Register</a>
        <a href="payment.jsp"> Login </a>
      
     
        </div>
        <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>
