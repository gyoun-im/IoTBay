/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import iotbay.model.Shipment_Details;
import iotbay.model.dao.DBManager;
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
public class UpdateShipmentDetailsServlet extends HttpServlet {

  
   @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    HttpSession session = request.getSession();
    String streetAddress = request.getParameter("streetAddress");
    String suburb = request.getParameter("suburb");
    int postcode = Integer.parseInt(request.getParameter("postcode"));
    String state = request.getParameter("state");
    int shipmentDetailsID = Integer.parseInt(request.getParameter("shipmentDetailsID"));
    DBManager manager = (DBManager) session.getAttribute("manager");
    session.setAttribute("updated",null);
    
    // To display back all the shipment details have through mapping URL from servlet to servlet
    // int userAccountID = Integer.parseInt(request.getParameter("userID"));
    
    Shipment_Details shipmentDet = new Shipment_Details (streetAddress, suburb, postcode, state);
            try {
                if (shipmentDet!=null) {
                    session.setAttribute("shipmentDet", shipmentDet);
                    manager.updateShipmentDetails(shipmentDetailsID, streetAddress, suburb, postcode, state);
                    session.setAttribute("updated", "Shipment Details were succesfully updated!");
                    request.getRequestDispatcher("editshipmentdetails.jsp").include(request,response);
                } else {
                    session.setAttribute("updated", "Update was not sucessful");
                    request.getRequestDispatcher("edit.jsp").include(request,response);
                }
            } catch (SQLException ex) {
           Logger.getLogger(UpdateShipmentDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
        }
    }



