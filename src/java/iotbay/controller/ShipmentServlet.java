/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import uts.isd.model.Shipment;
import uts.isd.model.Shipment_Details;
import uts.isd.model.dao.ShipmentDBManager;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author Bryan0. Guntoro
 */
public class ShipmentServlet extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       HttpSession session = request.getSession();
       ShipmentValidator validator = new ShipmentValidator();
       int shipmentID = Integer.parseInt(request.getParameter("shipmentID"));
       String shipmentDate = request.getParameter("shipmentDate");
      ShipmentDBManager manager = (ShipmentDBManager) session.getAttribute("shipmentManager");
       Shipment shipment = null;
       session.setAttribute ("shipment", null);
       session.setAttribute("searchErr", null);
       validator.clear(session);
       
       if (!validator.validateShipmentDate(shipmentDate)) {
           session.setAttribute("dateErr", "Date is invalid! Follow: dd/mm/yyyy");
           request.getRequestDispatcher("shipment.jsp").include(request,response);
       } else {
           try {
               shipment = manager.findShipment(shipmentID,shipmentDate);
               if (shipment != null) {
                   session.setAttribute("shipment", shipment);
                   Shipment_Details shipmentDet = manager.findShipmentDetails(shipment.getShipmentDetailsID());
                   session.setAttribute("shipmentDet", shipmentDet);
                   request.getRequestDispatcher("shipment.jsp").include(request, response);
                   
               } else {
                   session.setAttribute("searchErr", "Shipment does not exist in the Database! Please try again.");
                   request.getRequestDispatcher("shipment.jsp").include(request, response);
               }
           } catch (SQLException ex) {
               Logger.getLogger(ShipmentServlet.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   }
}
