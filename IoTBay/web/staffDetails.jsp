<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="uts.isd.model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Details Page</title>
    </head>
    <body>
        <%
            Staff staff = (Staff) session.getAttribute("staff");
            String updated = (String) session.getAttribute("updated");
            User user = (User) session.getAttribute("user");
            String nameErr = (String) session.getAttribute("nameErr");
            String numErr = (String) session.getAttribute("numErr");
            String passErr = (String) session.getAttribute("passErr");
            String empErr = (String) session.getAttribute("empErr");
        %>
        <div class="topRight">
            <a href="staffMain.jsp"><button class="bttn">Go back to main dashboard</button></a>
            <a class="bttn" href="LogoutServlet">Logout</a>
        </div>
        <div class="container">
            <img src="css/IoTBay_Logo.png">
        </div>
        <h1>Staff Personal details </h1>
        <div class="center">
            <p>Enter the new details in the textbox and click update if you would like to change your details</p>
            <span><%=(updated != null ? updated : "")%></span><span><%=(empErr != null ? empErr : "")%></span>
        </div>
        <form method="post" action="StaffUpdateServlet">
            <table>
                <tr><td>Full name: </td><td><input class="tb" type="text" name="name"value="<%=staff.getName()%>" ></td><td> <%=(nameErr != null ? nameErr : "")%></td></tr>                
                <tr><td>Date of birth: </td><td><input class="tb" type="date" name="dob" value=""<%=user.getDob()%>"></td></tr>
                <tr><td>Email: </td><td><input class="tb" type="text" name="email" value="<%=staff.getNumber()%>"></td></tr>
                <tr><td>Contact number: </td><td><input class="tb" type="text" name="number" value="<%=staff.getEmail()%>"></td><td> <%=(numErr != null ? numErr : "")%></td></tr>
                <tr><td>Address: </td><td><input class="tb" type="text" name="address" value="<%=staff.getAddress()%>"></td></tr>   
                <tr><td>Staff type</td>
                    <td>
                        <select name="type"value="<%=staff.getType()%>">
                            <option value="manager">Manager</option>
                            <option value="supervisor">Supervisor</option>
                            <option value="normal staff">Normal staff</option>
                        </select>
                    </td>
                </tr>
                <tr><td>Gender</td>
                    <td>
                        <select name="gender"value="<%=user.getGender()%>">
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="Prefer not to say">Prefer not to say</option>
                        </select>
                    </td>
                </tr>
                <tr><td>Password: </td><td><input class="tb" type="password" name="password"value="<%=user.getPassword()%>" ></td><td> <%=(passErr != null ? passErr : "")%></td></tr>             
            </table>
            <div class="center">
                <a><input class="bttn" type="submit" value="Update"></a>
            </div>
        </form>
        <p>If you wish to delete your account click <a href="StaffDeleteServlet"><button class="bttn">Delete</button></a></p>
    </body>
</html>
