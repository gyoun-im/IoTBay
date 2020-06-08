<%@page import="uts.isd.model.Supplier"%>
<%@page import="uts.isd.model.dao.SupplierDBManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Supplier</title>
        <link rel="stylesheet" href="css/dashboard.css">
    </head>
    <body>
        <%
            SupplierDBManager manager = (SupplierDBManager) session.getAttribute("supplierManager");
            String name = request.getParameter("name");
            Supplier supplier = manager.findSupplierByName(name);
                       
            String emptyErr = (String) session.getAttribute("supplierEmptyErr");
            String emailErr = (String) session.getAttribute("supplierEmailErr");
            String numberErr = (String) session.getAttribute("supplierNumberErr");
        %>
        
        <h1>Edit Supplier</h1>
        <a href = suppliers.jsp >go back</a>
        
        <p><span><%=(emptyErr != null ? emptyErr : "")%></span></p>
        
        <form method="post" action="EditSupplierServlet">
            <table>
                <input type="hidden" value="<%=supplier.getSupplierID()%>" name="id">
                <tr><th>Name: </th><td><input type="text" value="<%=supplier.getSupplierName()%>" name="name"></td></tr>
                <tr><th>Type: </th><td><input type="text" value="<%=supplier.getCompanyType()%>" name="type"></td></tr>
                <tr>
                    <th>Contact No.: </th><td><input type="text" value="<%=supplier.getContactNumber()%>" name="number"></td>
                    <td> <%=(numberErr != null ? numberErr : "")%></td>
                </tr>
                <tr>
                    <th>Email: </th><td><input type="text" value="<%=supplier.getEmail()%>" name="email"></td>
                    <td> <%=(emailErr != null ? emailErr : "")%></td>
                </tr>
                <tr><th>Address: </th><td><input type="text" value="<%=supplier.getAddress()%>" name="address"></td></tr>
                <%  if(supplier.getStatus()){%>
                <tr>
                    <th>Status: </th>
                    <td><input type="radio" name="status" value="Active" checked><label for="Active">Active</label>
                        <input type="radio" name="status" value="Inactive"><label for="Inactive">Inactive</label></td>
                </tr>
                <%  }else {%>
                <tr>
                    <th>Status: </th>
                    <td><input type="radio" name="status" value="Active" checked><label for="Active">Active</label>
                        <input type="radio" name="status" value="Inactive"><label for="Inactive">Inactive</label></td>
                </tr>        
                <%  }%>
                <tr>
                    <td></td><td><input class="button" type="submit" value="edit"></td>
                </tr>               
            </table>                   
        </form>
    </body>
</html>
