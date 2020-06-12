<%@page import="uts.isd.model.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.User_Account"%>
<%@page import="uts.isd.model.Shipment"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/dashboard.css" rel="stylesheet" type="text/css">
        <title>Find Shipment - IoTBay </title>
        <% User_Account user = (User_Account) session.getAttribute("user");
           String searchErr = (String)session.getAttribute("searchErr");
           Shipment shipment = (Shipment) session.getAttribute("shipment");
           String dateErr = (String) session.getAttribute("dateErr");
           Customer customer = (Customer) session.getAttribute("customer");
        %>
        <style>
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
            .no-outline:focus {
                outline: none;
            }
            input[type=int] {
                width: 300px;
            }
            input[type=password] {
                width: 300px;
            }
            input[type=checkbox] {
                width: 10px;
            }
            input[type=text] {
                width: 300px;
            }
            button {
                background-color: Red;
                color: white;
                padding: 16px 20px;
                margin: 8px 0;
                border: none;
                cursor: pointer;
                width: 30%;
                
            }
            .shakeanimation {
                /* Start the shake animation and make the animation last for 0.5 seconds */
                animation: shake 0.3s;
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





        
        <img src ="css/IoTBay_Logo.png"  alt="IoTBay" width="100px" height="95px" class="centerz">
        <p style="text-align:right">You are logged in as &lt; ${user.email} &gt; </p>  
        <table cellspacing="0" cellpadding="0" width="100%">
            <tr>
                 <th><a href="devices"><div class="center"><img src="css/home.png" width="16px" height="20px"></div>Home &nbsp;</a></th>
                <th><div class="center"><img src="css/menu.png" width="16px" height="20px"></div>Shop by Category</th>
                <th><a href="main.jsp"><div class="center"><img src="css/hotdeals.png" width="18px" height="20px"> </div>Hot Deals</a></th>
                <th> <a href="main.jsp"><div class="center"><img src="css/recent.png" width="20px" height="20px"> </div>Recently Viewed</a></th>
                <th class="dropdown">  <img src="css/user.png" width="25px" height="25px">&nbsp; &nbsp; &nbsp;Hi, ${customer.name}! <div class="dropdown-content"><a href="shipmentdetails.jsp" style="color:black;"> Shipment Details </a>
                          <a href="viewprofile.jsp" style="color:black;">My Account</a>        
                                    <a href="#" style="color:black"> My Shopping </a>
                                    <a href="shipment.jsp" style="color:black">  Find Shipment </a>
                                    <a href="ShipmentDetailsServlet?userID=<%=user.getUserAccountID()%>" style="color:black;"> View Shipment Details </a>
                                    <a href="#" style="color:black"> View Payment Details</a>
                                    <a href="#" style="color:black"> View Order History </a>
                                    <a href="CustomerAccessLogServlet?email='<%=user.getEmail()%>'&password='<%=user.getPassword()%>'" style="color:black"> View Access Logs </a>
                                    <a href="ViewShipmentServlet?userID=<%=user.getUserAccountID()%>" style="color:black"> View Shipment </a> 
                                      <a href="LogoutServlet" style="color:black;">Logout</a>
                    </div>
                    </div>
                </th>
            </tr>
        </table>

        <table cellspacing="0" cellpadding="0" height="70%" width="8%" bgcolor="#f0efef"  padding="0px" style="width: 8%; float: left;" > 
            <tr> <td style="padding-bottom:0px"> <img src="css/account.PNG"  padding="0px"></td> </tr>
            <tr>  <td style="padding-left: 15px; padding-bottom:0px; color:black"> MY ACCOUNT  
                    <div>
                        <ul>
                                  <li> Contact Details </li> 
                            <li> <a href="ShipmentDetailsServlet?userID=<%=user.getUserAccountID()%>"> Shipment Details </li> 
                            <li> <a href="shipment.jsp"> Find Shipment </a></li>
                            <li> Payment Details </li>
                            <li> IoTBay Card Rewards </li>
                            <li> Promotional Newsletter </li>
                            <li> Change Password</li>
                            <li> Change Language</li>
                            <li><a href="CustomerAccessLogServlet?email='<%=user.getEmail()%>'&password='<%=user.getPassword()%>'"> Access Logs </a>  </li>
                        </ul> </div></td>  </tr>
            <tr>  <td style="padding-left: 15px; padding-bottom:0px; color:black"> <b> MY SHOPPING </b> 
                    <div id="nacvontainer">
                        <ul id="navcontainer">
                            <li> </li> 
                            <li> IoTBay Priority</li> 
                            <li> Contact Us </li>
                            <li> Wishlist </li>
                            <li> Giftcards </li>
                            <li> eVouchers </li>
                            <li> Credits</li>
                            <li> Order History</li>
                            <li> <a href="ViewShipmentServlet?userID=<%=user.getUserAccountID()%>"> Shipment History </a> </li>
                        </ul> </div></td>  </tr>





        </table>

                <h1 style="text-align:left; margin-left:20px; margin-top:50px;"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Find Shipment <div style="color:tomato; float:right;" class="shakeanimation"> <%= (searchErr != null ? searchErr: "") %> </div></h1> <hr>
        <form method="post" action="ShipmentServlet"> 
            <table class="no-outline" style="margin-left:250px; border-bottom: 0pt;">
                <tr><td>Shipping ID </td></tr>
                <tr ><td style="border-bottom: 1px; border-left:0px; border-right: 0px; border-top: 0px"><input type ="int" class="no-outline" name="shipmentID" placeholder="Enter Shipping ID" required></td></tr>
                <tr></tr>
                <tr><td> Date of Shipment</td></tr>
                <tr><td> <input type ="text" class="no-outline" name="shipmentDate" placeholder="<%=(dateErr!=null ? dateErr : "dd/mm/yyyy")%>" required></td></tr>            
                <tr><td> <button style="margin-right:45%" type="submit"> Search </button>  </td>                   </table>
        </form>
                 
                <% if (shipment != null) { %>
                <table style="border: 0px solid #ddd; border-collapse: collapse; border-color: black; margin-left: 250px;" cellspacing="120"> 
                    <tr style="padding: 20px; border-bottom: 1px solid #ddd;">
                        <td style="border-bottom: 1px solid #ddd; border-color:gray; color:black; padding:10px;"> Shipment ID </td>
                        <td style="border-bottom: 1px solid #ddd; border-color:gray; color:black; padding:10px;"> Courier Name </td> 
                        <td style="border-bottom: 1px solid #ddd; border-color:gray; color:black; padding:10px;"> Shipment Status </td> 
                        <td style="border-bottom: 1px solid #ddd; border-color:gray; color:black; padding:10px;"> Tracking Number </td> 
                        <td style="border-bottom: 1px solid #ddd; border-color:gray; color:black; padding:10px;"> Shipment Date </td> 
                        <td style="border-bottom: 1px solid #ddd; border-color:gray; color:black; padding:10px;"> Shipment Address </td> 
                        <td style="border-bottom: 1px solid #ddd; border-color:gray; color:black; padding:10px;"> Order ID </td>
                    </tr>
                    <tr style="border: 0px">
                        <td style="border-bottom: 0px solid #ddd; border-color:gray; color:black; padding:10px;">${shipment.shipmentID} </td>
                        <td style="border-bottom: 0px solid #ddd; border-color:gray; color:black; padding:10px;">${shipment.courierName} </td>
                        <td style="border-bottom: 0px solid #ddd; border-color:gray; color:black; padding:10px;"> ${shipment.shipmentStatus}</td>
                        <td style="border-bottom: 0px solid #ddd; border-color:gray; color:black; padding:10px;"> ${shipment.trackingNumber} </td>
                        <td style="border-bottom: 0px solid #ddd; border-color:gray; color:black; padding:10px;"> ${shipment.shipmentDate} </td>
                        <td style="border-bottom: 0px solid #ddd; border-color:gray; color:black; padding:10px;"> ${shipmentDet.streetAddress}, ${shipmentDet.suburb}, ${shipmentDet.postcode}, ${shipmentDet.state} </td>
                        <td style="border-bottom: 0px solid #ddd; border-color:gray; color:black; padding:10px;"> ${shipment.orderID} </td>
                    </tr> 
                </table>
                    <%  } else {} %>
                    
       
       



    </body>
</html>