

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Supplier</title>
         <link rel="stylesheet" href="css/suppliers.css">
    </head>
    <body>
        <%
            String emptyErr = (String) session.getAttribute("supplierEmptyErr");
            String emailErr = (String) session.getAttribute("supplierEmailErr");
            String numberErr = (String) session.getAttribute("supplierNumberErr");
        %>
        
        <h1>Add Supplier</h1>
        <div class="center">
            <a href = suppliers.jsp >go back</a>
        </div>
        
        <p><span><%=(emptyErr != null ? emptyErr : "")%></span></p>
        
        <form method="post" action="AddSupplierServlet">
            <table class="center">
                <tr><th>Name: </th><td><input type="text" placeholder=" " name="name"></td></tr>
                <tr><th>Type: </th><td><input type="text" placeholder=" " name="type"></td></tr>
                <tr>
                    <th>Contact No.: </th><td><input type="text" placeholder=" " name="number"></td>
                    <td> <%=(numberErr != null ? numberErr : "")%></td>
                </tr>
                <tr>
                    <th>Email: </th><td><input type="text" placeholder=" " name="email"></td>
                    <td> <%=(emailErr != null ? emailErr : "")%></td>
                </tr>
                <tr>
                    <th>Address: </th><td><input type="text" placeholder=" " name="address"></td>
                </tr>
                <tr>
                    <th>Status: </th>
                    <td><input type="radio" name="status" value="Active" checked><label for="Active">Active</label>
                        <input type="radio" name="status" value="Inactive"><label for="Inactive">Inactive</label></td>
                </tr>
                <tr><td></td><td><input class="button" type="submit" value="add"></td></tr>
            </table>                   
        </form>
    </body>
</html>
