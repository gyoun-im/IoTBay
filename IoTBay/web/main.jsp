<%@page import="iotbay.model.User"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css/dashboard.css" rel="stylesheet" type="text/css">
        <title>Main Page of IoTBay</title>
        <% User user = (User)session.getAttribute("user"); %>
    </head>
   
    <body>
        
        
      
        
       
        <%  if (user!=null) { %>
         <img src ="css/IoTBay_Logo.png"  alt="IoTBay" width="100px" height="95px" class="centerz">
          <p style="text-align:right">You are logged in as &lt; ${user.email} &gt; </p>  
         <table cellspacing="0" cellpadding="0" width="100%">
                            <tr>
                                <th><a href="main.jsp"><div class="center"><img src="css/home.png" width="16px" height="20px"></div>Home &nbsp;</a></th>
                                <th><div class="center"><img src="css/menu.png" width="16px" height="20px"></div>Shop by Category</th>
                                <th><a href="main.jsp"><div class="center"><img src="css/hotdeals.png" width="18px" height="20px"> </div>Hot Deals</a></th>
                                <th> <a href="main.jsp"><div class="center"><img src="css/recent.png" width="20px" height="20px"> </div>Recently Viewed</a></th>
                            <th class="dropdown">  <img src="css/user.png" width="25px" height="25px">&nbsp; &nbsp; &nbsp;Hi, ${user.name}! <div class="dropdown-content"><a href="#" style="color:black;"> Payment Details </a>
                                                                                                                                                        <a href="viewprofile.jsp" style="color:black;">View Profile</a>
                                                                                                                                                        <a href="logout.jsp" style="color:black;">Logout</a>
                                                                                                                          </div>
                                                                                                                          </div>
                            </th>
                        </tr>
            </table>
                       
                            <table class='viewprofile'>
                                <tr><h1>Account Details </h1></tr>
                                <tr class="viewprofiles"> <td class="title">Full Name </td> </tr>
                                <tr class="viewprofiles"> <td> ${user.name} </td> </tr>
                                <tr><td> &nbsp;</td></tr>
                                <tr class="viewprofiles"> <td class="title">Email address</td> </tr>
                                <tr class="viewprofiles"><td>${user.email}</td></tr>
                                 <tr><td> &nbsp;</td></tr>
                                <tr class="viewprofiles"> <td class="title">Password</td> </tr>
                                <tr class="viewprofiles"><td>${user.password}</td></tr>
                                 <tr><td> &nbsp;</td></tr>
                                <tr class="viewprofiles"> <td class="title">Date of Birth:</td> </tr>
                                <tr class="viewprofiles"><td>${user.dob}</td></tr>
                                
                              
                            </table>
                   
     
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
       <% } %>

  
      
    </body>
</html>