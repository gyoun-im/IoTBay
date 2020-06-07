<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
         <div class="container">
            <img src="css/IoTBay_Logo.png">
        </div>
        <h1>Login</h1>
        <div class="center">
        <form method="post" action="welcome.jsp">
            <table class="center">
                <tr>
                    <td>
                        <input class="tb" type="text" placeholder="Enter your email" name="email" >
                    </td>
                </tr>
                <tr>
                    <td>
                        Username
                    </td>
                </tr>
                <tr>
                    <td>
                        <input class="tb" type="text" placeholder="Enter your password" name="password" >
                    </td>
                </tr>
                <tr>
                    <td>
                        Password
                    </td>
                </tr>
            </table>
            <div class="center">
                <a><button class="bttn" formaction="index.jsp" class="a">Cancel</button></a>
                <a><input class="bttn" type="submit" value="Login"></a>
            </div>
        </form>
        </div>
        
        <div class="center">
            <p>Don't have account? Sign up. Are you a <a href="customer_register.jsp">customer</a> or a <a href ="staff_register.jsp">staff</a></p>
            <p>or continue as guest <a href="mainPage.jsp">click here</a> </p>
        </div>
    </body>
</html>
