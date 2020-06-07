<%@page import="uts.isd.model.Shipment_Details"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.User_Account"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/dashboard.css" rel="stylesheet" type="text/css">
        <title>Main Page of IoTBay</title>
        <% User_Account user = (User_Account) session.getAttribute("user");
            ArrayList<Shipment_Details> shipmentDet = (ArrayList) session.getAttribute("shipmentD");
            String existErr = (String) session.getAttribute("existErr");
            request.setAttribute("shipmentList", shipmentDet);
            
        %>
        <style>
            .box{
                background-color: white;
                width: 300px;
                border: 2px solid gray;
                padding: 10px;
                margin: 20px;
                
                float:left;
                
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
                width:70px;
                padding:10px;
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
                padding:10px;
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





        <%  if (user != null) {%>
        <img src ="css/IoTBay_Logo.png"  alt="IoTBay" width="100px" height="95px" class="centerz">
        <p style="text-align:right">You are logged in as &lt; ${user.email} &gt; </p>  
        <table cellspacing="0" cellpadding="0" width="100%">
            <tr>
                <th><a href="main.jsp"><div class="center"><img src="css/home.png" width="16px" height="20px"></div>Home &nbsp;</a></th>
                <th><div class="center"><img src="css/menu.png" width="16px" height="20px"></div>Shop by Category</th>
                <th><a href="main.jsp"><div class="center"><img src="css/hotdeals.png" width="18px" height="20px"> </div>Hot Deals</a></th>
                <th> <a href="main.jsp"><div class="center"><img src="css/recent.png" width="20px" height="20px"> </div>Recently Viewed</a></th>
                <th class="dropdown">  <img src="css/user.png" width="25px" height="25px">&nbsp; &nbsp; &nbsp;Hi, ${user.name}! <div class="dropdown-content"><a href="shipmentdetails.jsp" style="color:black;"> Shipment Details </a>
                          <a href="viewprofile.jsp" style="color:black;">My Account</a>        
                                    <a href="#" style="color:black"> My Shopping </a>
                                    <a href="shipment.jsp" style="color:black">  Find Shipment </a>
                                    <a href="#" style="color:black">  Find Payment </a>
                                    <a href="ShipmentDetailsServlet?userAccountID=<%=user.getUserAccountID()%>" style="color:black;"> View Shipment Details </a>
                                    <a href="#" style="color:black"> View Payment Details</a>
                                    <a href="#" style="color:black"> View Order History </a>
                                    <a href="#" style="color:black"> View Access Logs </a>
                                    <a href="ViewShipmentServlet?userAccountID=<%=user.getUserAccountID()%"  style="color:black">View Shipment </a> 
                                      <a href="logout.jsp" style="color:black;">Logout</a>
                    </div>
                    </div>
                </th>
            </tr>
        </table>

        <table cellspacing="0" cellpadding="0" height="70%" width="8%" bgcolor="#f0efef"  padding="0px" style="width: 8%; float: left;" > 
            <tr> <td style="padding-bottom:0px"> <img src="css/account.PNG"  padding="0px"></td> </tr>
            <tr>  <td style="padding-left: 15px; padding-bottom:0px; color:black"> <b> MY ACCOUNT  </b>
                    <div>
                        <ul>
                                  <li> Contact Details </li> 
                            <li> <a href="ShipmentDetailsServlet?userID=<%=user.getUserAccountID()%"> Shipment Details </li> 
                            <li> <a href="shipment.jsp"> Find Shipment </a></li>
                            <li> Payment Details </li>
                            <li> Find Payment </li>
                            <li> IoTBay Card Rewards </li>
                            <li> Promotional Newsletter </li>
                            <li> Change Password</li>
                            <li> Change Language</li>
                            <li> Access Logs </li>
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
                            <li> <a href="ViewShipmentServlet?userID=<%=user.getUserAccountID()%"> Shipment History </a> </li>

                        </ul> </div></td>  </tr>





        </table>

        <h1 style="text-align:left; margin-left:250px; margin-top:50px"> Saved Shipment Details </h1>
        <h1 style="color:tomato; text-align:left; margin-left:250px;"> <%= (existErr != null ? existErr : "")%>   </h1>

        <% if (shipmentDet != null ) {%> 
 
        <div style="margin-left:230px;">
            <%  for (Shipment_Details shipmentList : shipmentDet) { %>
            <div class="box">
                <%=shipmentList.getStreetAddress()%><br>
                <%=shipmentList.getSuburb()%>, <%=shipmentList.getState()%>, <%=shipmentList.getPostcode()%><br>
                Australia <br> <br>
                <a href="EditShipmentDetailsServlet?shipmentDetailsID=<%=shipmentList.getShipmentDetailsID()%>"><button class="button2"> <b>EDIT</b> </button></a> 
                  <a href="DeleteShipmentDetailsServlet?shipmentDetailsID=<%=shipmentList.getShipmentDetailsID()%>&userID=<%=user.getUserAccountID()%"><button class="button3"> <b>REMOVE</b> </button></a>
            </div>
        </div>
                
            
       <% } %>
       
        <% } else { %>

        <table style="margin-left:250px; border-bottom:0px; width:800px;">
            <tr>
                <td rowspan="2"> <img src="css/locationmap.jpg"  height="150px" width="170px">  </td>
                <td> <p> <b>Save your shipment address to your account now! </b></p> </td>
            </tr>
            <tr> <td> <p> Add multiple addresses to your account to allow easy selection before purchasing an order. </p> </td>
            
        </table>
         
        <% } %> 
        
        <br></br><div style="float:none; display:inline-block;"><a href="addShipmentDetails.jsp"><button class="button" style="margin-left:50px"> <span>ADD ADDRESS </span> </button></a></div>
        
        <% } else { %>
        <img src ="css/IoTBay_Logo.png"  alt="IoTBay" width="100px" height="95px" class="centerz">

        <br> 
        <table cellspacing="0" cellpadding="0" width="100%">
            <tr>
                <th><a href="main.jsp"><div class="center"><img src="css/home.png" width="16px" height="20px"></div>Home &nbsp;</a></th>
                <th><a href="#"><div class="center"><img src="css/menu.png" width="16px" height="20px"></div>Shop by Category</a></th>
                <th> <a href="#"><div class="center"><img src="css/hotdeals.png" width="18px" height="20px"> </div>Hot Deals</th>
                <th> <a href="#"><div class="center"><img src="css/recent.png" width="20px" height="20px"> </div>Recently Viewed</th>
                <th class="dropdown">  <img src="css/user.png" width="25px" height="25px">&nbsp; &nbsp; &nbsp;Sign In or Create an Account <div class="dropdown-content"><a href="login.jsp" style="color:black;"> Sign In </a>
                        <a href="register.jsp" style="color:black;">Create an Account</a></div>
                    </div>
                </th>
            </tr>
        </table>
        <% }%>



    </body>
</html>
