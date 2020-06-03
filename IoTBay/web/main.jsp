<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="uts.isd.model.User"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/ref.css" rel="stylesheet" type="text/css">
        <title>Main Page of IoTBay</title>
        <% User user = (User) session.getAttribute("user"); 
           
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
        </style>
    </head>

    <body>





        <%  if (user != null) { %>
        <img src ="css/IoTBay_Logo.png"  alt="IoTBay" width="100px" height="95px" class="centerz">
        <p style="text-align:right">You are logged in as &lt; ${user.email} &gt; </p>  
        <table cellspacing="0" cellpadding="0" width="100%">
            <tr>
                <th><a href="main.jsp"><div class="center"><img src="css/home.png" width="16px" height="20px"></div>Home &nbsp;</a></th>
                <th><div class="center"><img src="css/menu.png" width="16px" height="20px"></div>Shop by Category</th>
                <th><a href="main.jsp"><div class="center"><img src="css/hotdeals.png" width="18px" height="20px"> </div>Hot Deals</a></th>
                <th> <a href="main.jsp"><div class="center"><img src="css/recent.png" width="20px" height="20px"> </div>Recently Viewed</a></th>
                <th class="dropdown">  <img src="css/user.png" width="25px" height="25px">&nbsp; &nbsp; &nbsp;Hi, ${user.name}! <div class="dropdown-content"><a href="shipmentdetails.jsp" style="color:black;"> Shipment Details </a>
                        <a href="viewprofile.jsp" style="color:black;">View Profile</a>
                        <a href="logout.jsp" style="color:black;">Logout</a>
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
                            <li> Shipment Details </li> 
                            <li> <a href="shipment.jsp" > Find Shipment </a></li>
                            <li> Payment Details </li>
                            <li> IoTBay Card Rewards </li>
                            <li> Promotional Newsletter </li>
                            <li> Change Password</li>
                            <li> Change Language</li>
                             </ul> </div></td>  </tr>
                 <tr>  <td style="padding-left: 15px; padding-bottom:0px; color:black"> MY SHOPPING 
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
                            
                        </ul> </div></td>  </tr>
              
       
       
            
           
        </table>

                        <h1 style="text-align:left; margin-left:20px; margin-top:50px"> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Saved Shipment Details </h1>
                        <a href="ShipmentDetailsServlet?userID=3"> Test View </a>
                       
                                
                        

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