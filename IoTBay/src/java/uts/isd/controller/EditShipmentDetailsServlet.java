/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

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
 * @author Bryan Guntoro
 */
public class EditShipmentDetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        //String streetAddress = request.getParameter("streetAddress");
        //String suburb = request.getParameter("suburb");
        //int postcode = Integer.parseInt(request.getParameter("postcode"));
        //String state = request.getParameter("state");
        // int userID = Integer.parseInt(request.getParameter("userID"));
        int shipmentDetailsID = Integer.parseInt(request.getParameter("shipmentDetailsID"));
        
        ShipmentDBManager manager = (ShipmentDBManager) session.getAttribute("shipmentManager");
        
        Shipment_Details shipmentDet = null;
        
        
        try{
            shipmentDet = manager.findShipmentDetails(shipmentDetailsID);
            if(shipmentDet != null) {
                session.setAttribute("shipmentDet", shipmentDet);
                shipmentDet.setShipmentDetailsID(shipmentDetailsID);
                request.getRequestDispatcher("editshipmentdetails.jsp").include(request,response);
            } else {
                session.setAttribute("existErr", "Shipment Detail does not exist in the Database!");
                request.getRequestDispatcher("editshipmentdetails.jsp").include(request,response);
            }
             
            
        } catch (SQLException ex) {
            Logger.getLogger(EditShipmentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       

    }
}