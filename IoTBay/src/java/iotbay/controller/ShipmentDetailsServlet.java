/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import iotbay.model.Shipment_Details;
import iotbay.model.dao.DBManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;

/**
 *
 * @author Bryan Guntoro
 */
public class ShipmentDetailsServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       HttpSession session = request.getSession();
       Validator validator = new Validator();
       int userID = Integer.parseInt(request.getParameter("userID"));
       DBManager manager = (DBManager) session.getAttribute("manager");
        ArrayList <Shipment_Details> shipmentD = null;
        session.setAttribute("existErr", null);
        session.setAttribute("shipmentD", null);
        
       try {
           shipmentD = manager.fectShipmentDetails(userID);
           if (shipmentD != null) {
           session.setAttribute("shipmentD", shipmentD);
           request.getRequestDispatcher("shipmentdetails.jsp").include(request,response);
           } else {
               session.setAttribute("existErr", "You don't have any saved shipment addresses");
               request.getRequestDispatcher("shipmentdetails.jsp").include(request, response);
           }
       } catch (SQLException ex) {
           java.util.logging.Logger.getLogger(ShipmentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
   }
}