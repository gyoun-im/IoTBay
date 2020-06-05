<%-- 
    Document   : Orders
    Created on : 2020年6月4日, 下午7:29:04
    Author     : Simon
--%>

<%@page import="uts.isd.model.Device"%>
<%@page import="uts.isd.model.Order"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Details</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/index.css">
    </head>
    <body>
        <div class="container">
            <img src="css/IoTBay_Logo.png">
        </div>
        <div class="center-container clearfix">
            <h1>Order Details</h1>
            <%
                Device d = (Device) request.getAttribute("device");
                Order o = (Order) request.getAttribute("order");
            %>
            <table style="margin: 10px 0">
                <tr>
                    <td>Order Id: </td>
                    <td>00000000<%= o.getId()%></td>
                </tr>
                <tr>
                    <td>Order Date: </td>
                    <td><%= o.getDate()%></td>
                </tr>
                <tr>
                    <td>Order Status: </td>
                    <td><%= o.getStatus()%></td>
                </tr>
            </table>
            <table class="table table-striped">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Unit</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Total</th>
                </tr>
                <tr>
                    <td><%= d.getId()%></td>
                    <td><%= d.getName()%></td>
                    <td><%= d.getType()%></td>
                    <td><%= d.getUnit()%></td>
                    <td><%= d.getPrice()%></td>
                    <td><%= o.getQuantity()%></td>
                    <td><%= o.getTotal()%></td>
                </tr>
            </table>
            <% if (!o.getStatus().equals("Finished")) {%>
            <a class="btn btn-warning float-right" href="payment.jsp">Pay</a>
            <%}%>
        </div>
    </body>
</html>
