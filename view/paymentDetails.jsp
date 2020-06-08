<%@page import="uts.isd.model.PaymentMethod"%>
<%@page import="uts.isd.model.Payment"%>
<%@page import="uts.isd.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/index.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Payment Page</title>
    </head>
    <body>
        <%

            String existErr = (String) session.getAttribute("existErr");
            String idErr = (String) session.getAttribute("idErr");
            String dateErr = (String) session.getAttribute("dateErr");
            String empErr = (String) session.getAttribute("empErr");
            PaymentMethod payment = (PaymentMethod) session.getAttribute("payment");
        %>
        <div class="container">
            <img src="css/IoTBay_Logo.png">
        </div>
        <h1>Payment Method Details </h1>  <p><span><%=(empErr != null ? empErr : "")%></span></p>
        <div class="center">

        </div>
        <div class="center">
            <p><span><%=(existErr != null ? existErr : "")%></span><span><%=(empErr != null ? empErr : "")%></span></p>
            <form action="ViewPaymentMethodServlet" method="post" >
                <table class="center">
                    <tr>
                        <td>CardNumber</td>
                    </tr>
                    <tr>
                        <td><input class="tb" type="text" placeholder="<%=(idErr != null ? idErr : "Enter id")%>" name="cardNumber" required ></td>
                    </tr>                                          
                </table>
                <div class="center">
                    <a class="bttn" href="CancelServlet">Cancel</a>
                    <a><input class="bttn" type="submit" value="Search"></a>
                    <a class="bttn" href="addPaymentDetails.jsp">Create Payment Details</a> 
                </div>

            </form>
        </div>
        <% if (payment != null) {%>

       <table style="border: 0px solid #ddd; border-collapse: collapse; border-color: black; margin-left: 250px;" cellspacing="120"> 
                    <tr style="padding: 20px; border-bottom: 1px solid #ddd;">
                        <td style="border-bottom: 1px solid #ddd; border-color:gray; color:black; padding:10px;"> Card Name </td>
                        <td style="border-bottom: 1px solid #ddd; border-color:gray; color:black; padding:10px;"> Card Number </td> 
                        <td style="border-bottom: 1px solid #ddd; border-color:gray; color:black; padding:10px;"> CVC </td> 
                        <td style="border-bottom: 1px solid #ddd; border-color:gray; color:black; padding:10px;"> Bank Name </td> 
                       
                    </tr>
                    <tr style="border: 0px">
                        <td style="border-bottom: 0px solid #ddd; border-color:gray; color:black; padding:10px;">${payment.cardName} </td>
                        <td style="border-bottom: 0px solid #ddd; border-color:gray; color:black; padding:10px;">${payment.cardNumber} </td>
                        <td style="border-bottom: 0px solid #ddd; border-color:gray; color:black; padding:10px;"> ${payment.cvc}</td>
                        <td style="border-bottom: 0px solid #ddd; border-color:gray; color:black; padding:10px;"> ${payment.bankName} </td>
                        
                    </tr> 
                </table>
                    <%  } else {} %>

                   

    </body>
</html>