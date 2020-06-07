<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personal Details Page</title>
    </head>
    <body>
        <div class="topRight">
            <a href="dashboard.jsp"><button class="bttn">Go back to main dashboard</button></a>
        </div>
        <div class="container">
            <img src="css/IoTBay_Logo.png">
        </div>
        <h1>Personal details</h1>
        <p>Enter the new details in the textbox and click update if you would like to change your details</p>
        <table>
            <tr><td>Full name: </td><td><input class="tb" type="text" name="name" ></td></tr>                
            <tr><td>Date of birth: </td><td><input class="tb" type="date" name="dob" ></td></tr>
            <tr><td>Email: </td><td><input class="tb" type="text" name="email" ></td></tr>
            <tr><td>Contact number: </td><td><input class="tb" type="text" name="number" ></td></tr>
            <tr><td>Password: </td><td><input class="tb" type="password" name="password" ></td></tr>
        </table>
        <div class="center">
                <a><input class="bttn" type="submit" value="Update"></a>
        </div>
        
        <p>If you wish to delete your account click <input class="sbttn" type="submit" value="Delete"></p>
        
    </body>
</html>
