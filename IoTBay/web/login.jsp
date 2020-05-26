<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <img class="logo" src="css/IoTBay_Logo.png">
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
            <p>Don't have account? <a href="register.jsp">Sign up</a></p>
            <p>or continue as guest <a href="mainPage.jsp">click here</a> </p>
            <p>or go back to the <a href="index.jsp">index page</a> </p>
        </div>
    </body>
</html>
