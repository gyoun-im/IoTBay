<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <%
            String existErr = (String) session.getAttribute("existErr");
            String emailErr = (String) session.getAttribute("emailErr");
            String passErr = (String) session.getAttribute("passErr");
            String empErr = (String) session.getAttribute("empErr");
        %>
        <div class="container">
            <img src="css/IoTBay_Logo.png">
        </div>
        <h1>Login </h1>
        <div class="center">
            <p><span><%=(existErr != null ? existErr : "")%></span><span><%=(empErr != null ? empErr : "")%></span></p>
        </div>
        <div class="center">
            <form method="post" action="LoginServlet">
                <table class="center">
                    <tr>
                        <td><input class="tb" type="text" placeholder="<%=(emailErr != null ? emailErr : "Enter email")%>" name="email" ></td>
                    </tr>
                    <tr>
                        <td>Username</td>
                    </tr>
                    <tr>
                        <td><input class="tb" type="password" placeholder="<%=(passErr != null ? passErr : "Enter password")%>" name="password" ></td>
                    </tr>
                    <tr>
                        <td>Password</td>
                    </tr>
                </table>
                <div class="center">
                    <a class="bttn" href="CancelServlet">Cancel</a>
                    <a><input class="bttn" type="submit" value="Login"></a>
                </div>
            </form>
        </div>
        <div class="center">
            <p>Don't have account? Sign up. Are you a <a href="customerRegister.jsp">customer</a> or a <a href ="staffRegister.jsp">staff</a></p>
            <p>or continue as guest <a href="customerMain.jsp">click here</a> </p>
        </div>
    </body>
</html>
