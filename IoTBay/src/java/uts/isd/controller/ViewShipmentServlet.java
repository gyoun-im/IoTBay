/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import com.sun.istack.logging.Logger;
import uts.isd.model.Shipment;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User_Account;
import uts.isd.model.Shipment_Details;
import uts.isd.model.dao.ShipmentDBManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
//import sun.util.logging.PlatformLogger;

/**
 *
 * @author Bryan Guntoro
 */
public class ViewShipmentServlet extends HttpServlet {

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
       HttpSession session = request.getSession();
       
       int userID = Integer.parseInt(request.getParameter("userID"));
       ShipmentDBManager manager = (ShipmentDBManager) session.getAttribute("shipmentManager");
        ArrayList <Shipment> shipmentList = null;
        session.setAttribute("shipmentErr", null);
       
       
       try {
           shipmentList = manager.fectShipment(userID);
           if (shipmentList != null) {
           session.setAttribute("shipmentList", shipmentList);
           
           request.getRequestDispatcher("viewshipment.jsp").include(request,response);
           
           } else {
               session.setAttribute("shipmentList", null);
               session.setAttribute("shipmentErr", "You don't have any exisiting or previous Shipments!");
               request.getRequestDispatcher("viewshipment.jsp").include(request, response);
           }
       } catch (SQLException ex) {
           java.util.logging.Logger.getLogger(ShipmentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
   }
}