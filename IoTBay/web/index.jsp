<html>
    <head>
        <title>Index page IoTBay</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/login.css" rel="stylesheet" type="text/css">
    </head>
    <body>
          <img src="css/IoTBay_Logo.png" class="centerz" alt="IoTBay_Logo">
          <a href="register.jsp">
              <button class="buttonposition"> Register</button>
          </a>
          <br>
          <a href="login.jsp">
              <button class="buttonposition"> Login </button>
          </a>
         
          <jsp:include page="/ConnServlet" flush="true" />
    </body>
</html>