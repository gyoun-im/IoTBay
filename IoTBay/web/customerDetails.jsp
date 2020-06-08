<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Personal Details Page</title>
    </head>
    <body>

        <%
            Customer customer = (Customer) session.getAttribute("customer");
            String updated = (String) session.getAttribute("updated");
            User_Account user = (User_Account) session.getAttribute("user");
            String nameErr = (String) session.getAttribute("nameErr");
            String numErr = (String) session.getAttribute("numErr");
            String passErr = (String) session.getAttribute("passErr");
            String empErr = (String) session.getAttribute("empErr");
        %>

        <div class="topRight">
            <a href="main.jsp"><button class="bttn">Go back to main dashboard</button></a>
            <a class="bttn" href="LogoutServlet">Logout</a>
        </div>
        <div class="container">
            <img src="css/IoTBay_Logo.png">
        </div>
        <h1>Personal details </h1>
        <div class="center">
            <p>Enter the new details in the textbox and click update if you would like to change your details</p>
            <span><%=(updated != null ? updated : "")%></span><span><%=(empErr != null ? empErr : "")%></span>
        </div>
        <form method="post" action="CustomerUpdateServlet">
            <table>
                <tr><td>Full name: </td><td><input class="tb" type="text" name="name" value="<%=customer.getName()%>"></td><td> <%=(nameErr != null ? nameErr : "")%></td></tr>                
                <tr><td>Date of birth: </td><td><input class="tb" type="date" name="dob" value="<%=user.getDob()%>"></td></tr>
                <tr><td>Email: </td><td><input class="tb" type="text" name="email" value="<%=customer.getEmail()%>" ></td></tr>
                <tr><td>Contact number: </td><td><input class="tb" type="text" name="number" value="<%=customer.getNumber()%>"></td><td> <%=(numErr != null ? numErr : "")%></td></tr>
                <tr><td>Gender</td>
                    <td>
                        <select name="gender" value="<%=user.getGender()%>">
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="Prefer not to say">Prefer not to say</option>
                        </select>
                    </td>
                </tr>
                <tr><td>Address: </td><td><input class="tb" type="text" name="address" value="<%=customer.getAddress()%>"></td></tr>
                <tr><td>Password: </td><td><input class="tb" type="password" name="password" value="<%=user.getPassword()%>"</td><td> <%=(passErr != null ? passErr : "")%></td></tr>
                <tr><td>Would you like to receive a promotional newsletter?</td><td><input type="checkbox" name="news" value="<%=user.isNews()%>"></td></tr>
                <tr><td>Reward points: </td><td><%=user.getPoints()%></td></tr>
            </table>
            <div class="center">
                <a><input class="bttn" type="submit" value="Update"></a>
            </div>
        </form>
        <p>If you wish to delete your account click <a href="DeleteServlet"><button class="bttn">Delete</button></a></p>
    </body>
</html>