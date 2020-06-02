<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer Register Page</title>
    </head>
    <body>
        
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String nameErr = (String) session.getAttribute("nameErr");
            String numErr = (String) session.getAttribute("numErr");
            String empErr = (String) session.getAttribute("empErr");
        %>
        <div class="container">
            <img src="css/IoTBay_Logo.png">
        </div>
        <h1>Customer Register</h1>
         <div class="center">
         <p><span><%=(existErr != null ? existErr : "")%></span><span><%=(empErr != null ? empErr : "")%></span></p>
         </div>
        <form method="post" action="CustomerRegisterServlet">
            <table>
                <tr><td>Full name: </td><td><input class="tb" type="text" name="name" ></td><td> <%=(nameErr != null ? nameErr : "")%></td></tr>                
                <tr><td>Date of birth: </td><td><input class="tb" type="date" name="dob" ></td></tr>
                <tr><td>Email: </td><td><input class="tb" type="text" name="email" ></td><td> <%=(emailErr != null ? emailErr : "")%></td></tr>
                <tr><td>Contact number: </td><td><input class="tb" type="text" name="number" ></td><td> <%=(numErr != null ? numErr : "")%></td></tr>
                <tr><td>Address: </td><td><input class="tb" type="text" name="address" ></td></tr>
                <tr><td>Gender</td>
                    <td>
                        <select name="gender">
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="Prefer not to say">Prefer not to say</option>
                        </select>
                    </td>
                </tr>
                <tr><td>Password: </td><td><input class="tb" type="password" name="password" ></td><td> <%=(passErr != null ? passErr : "")%></td></tr>
                <tr><td>Would you like to receive a promotional newsletter?</td><td><input type="checkbox" name="news" value="yes"></td></tr>
            </table>
            <div class="center">
                <a href="CancelServlet" class="bttn" class="a">Cancel</button></a>
                <a><input class="bttn" type="submit" value="Register"></a>
            </div>
        </form>
        <div class="center">
            <p>Already have an account? <a href="login.jsp">Login here</a></p>
            <p>or continue as guest <a href="mainPage.jsp">click here</a> </p>
            <p>Registering as a staff? <a href="staff_register.jsp">click here</a> </p>
        </div>
    </body>
</html>
