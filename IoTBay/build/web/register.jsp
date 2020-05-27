<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
    </head>
    <body>
        <div class="container">
            <img src="css/IoTBay_Logo.png">
        </div>
        <h1>Register</h1>   
        <form method="post" action="welcome.jsp">
            <table>
                <tr><td>Full name: </td><td><input class="tb" type="text" name="name" ></td></tr>                
                <tr><td>Date of birth: </td><td><input class="tb" type="date" name="dob" ></td></tr>
                <tr><td>Email: </td><td><input class="tb" type="text" name="email" ></td></tr>
                <tr><td>Contact number: </td><td><input class="tb" type="text" name="number" ></td></tr>
                <tr><td>Password: </td><td><input class="tb" type="password" name="password" ></td></tr>
                <tr><td>Are you a staff?</td><td><input type="checkbox" name="submitted" value="yes"></td></tr>
            </table>
            <div class="center">
                <a><button class="bttn" formaction="index.jsp" class="a">Cancel</button></a>
                <a><input class="bttn" type="submit" value="Register"></a>
            </div>
        </form>
        <div class="center">
            <p>Already have an account? <a href="login.jsp">Login here</a></p>
            <p>or continue as guest <a href="mainPage.jsp">click here</a> </p>
        </div>
    </body>
</html>
