<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/acessLog.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Staff Access Log Page</title>
    </head>
    <body>
        <div class="topRight">
            <a href="dashboard.jsp"><button class="bttn">Go back to main dashboard</button></a>
        </div>
        <div class="container">
            <img src="css/IoTBay_Logo.png">
        </div>
        <h1>Access Logs</h1>
            <div class="center">
                Logged in as:
            </div>
        <table>
            <tr>
                <td>
                    <form method="post">
                        <div class="left">
                            <input type="Search" placeholder="Search...">
                            <button class="sbttn" type="submit">Submit</button>
                        </div> 
                    </form>
                </td>          
                <td>
                    <div class="center">
                        Access logs of:
                    </div>
                </td>
            </tr>
        </table>
        <table class="accessTable">
            <tr>
                <th>Date</th>
                <th>Time</th>
                <th>Action</th>
            </tr>
            <tr>
                <td class="tabBorder">s</td>
                <td class="tabBorder">s</td>
                <td class="tabBorder">s</td>                
            </tr>
        </table>
        
    </body>
</html>
