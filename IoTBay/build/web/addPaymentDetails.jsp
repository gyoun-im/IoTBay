<%@page import="uts.isd.model.PaymentMethod"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.User"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/dashboard.css" rel="stylesheet" type="text/css">
        <title>Main Page of IoTBay</title>
        <% User user = (User) session.getAttribute("user");
            PaymentMethod p = (PaymentMethod) session.getAttribute("p");
            String cvcErr = (String) session.getAttribute("postcodeErr");
            
            String addSuccess = (String) session.getAttribute("addSuccess");
        %>
        <style>
            .redcolor:hover{
                color:red;
            }
            .box{
                background-color: white;
                width: 300px;
                border: 2px solid gray;
                padding: 10px;
                margin: 20px;
                float:left;
            }
            .redcolor
            {
                text-align:left; 
                margin-left:70px; 
                margin-top:50px; 
                display:inline-block; 
                font-size:25px; 
                color: #3e88ff; 
            }
            td {
                font-family:Arial;
                font-size:15px;
                font-weight:normal;
                padding: 0px;
                text-align:left;
                vertical-align: middle;
            }
            ul {
                list-style: none;
                padding-left: 0px;
                color:#3e88ff;
            }
            li {
                margin-bottom: 15px;
            }
            li a:hover{
                color: tomato;
                cursor: pointer;
            }
            li a {
                color:#3e88ff;
            }
            .shakeanimation {
                /* Start the shake animation and make the animation last for 0.5 seconds */
                animation: shake 0.3s;
            }
            p {
                font-size:18px;
                color:black;
                font-family:Arial;
            }
            .button2 {
                background-color: white; 
                color: #3e88ff; 
                border: 2px solid #3e88ff;
                width:90px;
                padding:5px;
                border-radius: 10px;
            }
            .button2:hover {
                background-color: #3e88ff;
                color: white;
            }
            .button3 {
                background-color: white; 
                color:  #cc0000; 
                border: 2px solid #cc0000;
                width:90px;
                padding:5px;
                border-radius: 10px;
                text-align:center;
            }
            .button3:hover {
                background-color:  #cc0000;
                color: white;
            }
            .button {
                border-radius: 4px;
                background-color: #f4511e;
                border: none;
                color: #FFFFFF;
                text-align: center;
                font-size: 16px;
                padding: 15px;
                width: 190px;
                transition: all 0.5s;
                cursor: pointer;
                margin: 5px;
                display: inline-block;
                float: none; 
            }
            .button span {
                cursor: pointer;
                position: relative;
                transition: 0.3s;
            }
            .button span:after {
                content: '\00bb';
                position: absolute;
                opacity: 0;
                top: 0;
                right: -20px;
                transition: 0.5s;
                text-align:center;
            }
            .button:hover span {
                padding-right: 25px;
            }
            .button:hover span:after {
                opacity: 1;
                right: 0;
            }   
            .no-outline:focus {
                outline: none;
            }
            @keyframes shake {
                0% { transform: translate(1px, 1px) rotate(0deg); }
                10% { transform: translate(-1px, -2px) rotate(-1deg); }
                20% { transform: translate(-3px, 0px) rotate(1deg); }
                30% { transform: translate(3px, 2px) rotate(0deg); }
                40% { transform: translate(1px, -1px) rotate(1deg); }
                50% { transform: translate(-1px, 2px) rotate(-1deg); }
                60% { transform: translate(-3px, 1px) rotate(0deg); }
                70% { transform: translate(3px, 1px) rotate(-1deg); }
                80% { transform: translate(-1px, -1px) rotate(1deg); }
                90% { transform: translate(1px, 2px) rotate(0deg); }
                100% { transform: translate(1px, -2px) rotate(-1deg); }
            }
        </style>
    </head>

    <body>

    <h1 style="color:tomato; text-align:left; margin-left:20px;display:inline-block;font-size: 25px; color: black;"> Add Payment Details: &nbsp; &nbsp;  <div style="color:tomato; float:right;" class="shakeanimation"> <%= (cvcErr != null ? cvcErr : "")%> </div></h1>
        <form action="AddPaymentMethodServlet" method="post">
            
            <table style="border-bottom:1px; border-left:0px; border-right:0px; border-top:0px; border-left:0px; padding:3.8px; margin-left:300px;">

                <tr><td>Card Name </td></tr>
                <tr><td><input type="text" class="no-outline" name="cardName" placeholder="Card Name" ></td></tr>
                <tr><td>Card Number</td></tr>
                <tr><td><input type="int" class="no-outline" name="cardNumber" placeholder="Card Number" ></td></tr>
                <tr><td>CVC</td></tr>
                <tr><td><input type="int" class="no-outline" name="cvc" placeholder="cvc" required></td></tr>
                <tr><td>Bank Name</td></tr>
                <tr><td><input type="text" class="no-outline" name="bankName" placeholder="bankName" ></td></tr>
                
                               
            </table>
            <br><br>
            <button class="button2" href="CancelServlet">Cancel</button>
            <button class="button2" href="paymentDetails.jsp">Back</button>
            
            <button class="button2" type="submit" style="margin-left:0px"><b> Create </b> </button>
           

        </form>




       



    </body>
</html>