/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Shipment_Details;
import uts.isd.model.dao.ShipmentDBManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class addShipmentDetailsServlet extends HttpServlet {

 @Override
 protected void doPost(HttpServletRequest request, HttpServletResponse response) 
         throws ServletException, IOException {
     HttpSession session = request.getSession();
     ShipmentValidator validator = new ShipmentValidator();
     String streetAddress = request.getParameter("streetAddress");
     String suburb = request.getParameter("suburb");
     String state = request.getParameter("state");
     int postcode = Integer.parseInt(request.getParameter("postcode"));
     int userID = Integer.parseInt(request.getParameter("userID"));
     Shipment_Details shipmentDetail = null;
     ShipmentDBManager manager = (ShipmentDBManager) session.getAttribute("manager");
     session.setAttribute("addSuccess", null);
     session.setAttribute("addressErr", null);
     
     
     validator.clear(session);
     if (!validator.validateShipmentAddress(streetAddress)) {
         session.setAttribute("addressErr", "Address Format is Wrong!");
         request.getRequestDispatcher("addShipmentDetails.jsp").include(request,response);
     } else if (!validator.validatePostcode(postcode)){
         
         session.setAttribute("postcodeErr", "Wrong postcode! Please try again.");        
         request.getRequestDispatcher("addShipmentDetails.jsp").include(request,response);
     } 
     else { 
         try {
              session.setAttribute("addSuccess", "Shipment detail has been added to your account. You can now go back");
             manager.addShipmentDetails(streetAddress, suburb, postcode, state, userID);
             request.getRequestDispatcher("addShipmentDetails.jsp").include(request,response);
         } catch (SQLException ex) {
             Logger.getLogger(addShipmentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
         
     }
     
     }
 }
}

