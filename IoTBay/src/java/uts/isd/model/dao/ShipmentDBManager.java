/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import uts.isd.model.Shipment;
import uts.isd.model.Shipment_Details;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Bryan Guntoro
 */
public class ShipmentDBManager {
    
   private Statement st;
   
   public ShipmentDBManager(Connection conn) throws SQLException {
       st = conn.createStatement();
   }
   
   // SHIPMENT MANAGER
   // Find Shipment by id and date
   public Shipment findShipment (int id, String date) throws SQLException {
       String fetch = "select * from IOTBAYUSER.SHIPMENT where SHIPMENTID =" + id + "and SHIPMENTDATE='" +  date + "'";
       ResultSet rs = st.executeQuery (fetch);
       
       while (rs.next()) { 
           int shipmentID = rs.getInt(1); 
           String shipmentDate = rs.getString(5);
           if (shipmentID == id && shipmentDate.equals(date)) {
               String courierName = rs.getString(2);
               String shipmentStatus = rs.getString(3);
               String trackingNumber = rs.getString(4);
               int shipmentDetailsID = rs.getInt(6);
               int orderID = rs.getInt(7);
               Shipment shipment = new Shipment (courierName, shipmentStatus, trackingNumber, shipmentDate, shipmentDetailsID , orderID);
               shipment.setShipmentID(id);
               return shipment;
           }
       }
       return null;
   }
   
   // SHIPMENT DETAILS MANAGER
   // Foreign key of Shipment stores the shipment_details id, passed on. THIS IS USED TO EDIT OR DELETE BUTTON IN THE JSP
   public Shipment_Details findShipmentDetails (int id) throws SQLException {
       String fetch = "select * from IOTBAYUSER.SHIPMENT_DETAILS where SHIPMENTDETAILSID =" + id;
       ResultSet rs = st.executeQuery(fetch);
       
       while (rs.next()) { 
           int shipmentDetailsID = rs.getInt(1);
           if(shipmentDetailsID == id) {
               String streetAddress = rs.getString(2);
               String suburb = rs.getString(3);
               int postCode = rs.getInt(4);
               String state = rs.getString(5);
               Shipment_Details shipmentDetails = new Shipment_Details(streetAddress, suburb, postCode, state);
               return shipmentDetails;
           }
       }
       return null;
   }
   
   
   // SHIPMENT DETAILS MANAGER
   // Create or Add Shipment Details of the registered user - UserAccountID is passed on automatically
   public void addShipmentDetails(String streetAddress, String suburb, int postCode, String state, int userAccountID) throws SQLException{
       st.executeUpdate("INSERT INTO IOTBAYUSER.SHIPMENT_DETAILS (STREETADDRESS, SUBURB, POSTCODE, STATE, USERACCOUNTID)  VALUES ('" + streetAddress +  "', '"  + suburb + "', " + postCode + ", '" + state + "'," + userAccountID + ")");
   }
   
   // SHIPMENT DETAILS MANAGER
   // Delete a particular shipmentDetail - if the button is clicked the shipment_detail id is passed and will be deleted
   public void deleteShipmentDetails (int shipmentDetailID) throws SQLException{
       st.executeUpdate("DELETE FROM IOTBAYUSER.SHIPMENT_DETAILS WHERE SHIPMENTDETAILSID =" +  shipmentDetailID);
   } 
   
   // SHIPMENT DETAILS MANAGER
   // Update a shipmentDetail
   public void updateShipmentDetails(int shipmentDetailsID, String streetAddress, String suburb, int postCode, String state) throws SQLException{
       st.executeUpdate("UPDATE IOTBAYUSER.SHIPMENT_DETAILS SET STREETADDRESS='" + streetAddress + "', SUBURB='" + suburb + "',POSTCODE=" + postCode + ", STATE='"  + state + "' where SHIPMENTDETAILSID =" + shipmentDetailsID);
   }
   
   // Get a shipmentDetail ID - for testing if the id of the user cant be passed in jsp
   public int getShipmentDetailID (String streetAddress, String suburb, int postCode, String state, int userAccountID) throws SQLException{
       String fetch = "select * from IOTBAY.SHIPMENT_DETAILS where userAccount =" + userAccountID + "and streetAdddress=' " + streetAddress + "' and SUBURB='" + suburb  + "and POSTCODE " + postCode + "and STATE='" + state + "'";
       ResultSet rs = st.executeQuery (fetch);
       
       while (rs.next()) {
           int id = rs.getInt (1);
           return id;
       }
       return 0; // 0 in the id means the shipping detail doesnt exist as it starts with 1 onwards
   }
   
   // SHIPMENT DETAILS MANAGER
   // View all Shipment Details of a particular registered user (the id variable is automatically passed in parameter)
   public ArrayList<Shipment_Details> fectShipmentDetails(int id) throws SQLException{
       String fetch = "select * from SHIPMENT_DETAILS where USERACCOUNTID =" + id;
       ResultSet rs = st.executeQuery(fetch);
       ArrayList<Shipment_Details> table = new ArrayList();
       
       
       while (rs.next()) {
           if (id == rs.getInt(6)) {
           String streetAddress = rs.getString(2);
           String suburb = rs.getString(3);
           int postCode = rs.getInt(4);
           String state = rs.getString(5);
           int shipmentDetailsID = rs.getInt(1);
           Shipment_Details shipmentDetails = new Shipment_Details(streetAddress, suburb, postCode, state);
           shipmentDetails.setShipmentDetailsID(shipmentDetailsID);
           table.add(shipmentDetails);
           }
       }
       if (!table.isEmpty()){
       return table;
       } else {
           return null;
       }
   }

   
   
   //  VIEW ALL SHIPMENTS OF A PARTICULAR ACCOUNT
   public ArrayList<Shipment> fectShipment(int id) throws SQLException {
        String fetch = "Select shipmentid, couriername, shipmentstatus, trackingnumber, shipmentdate, s.shipmentdetailsid From Shipment S  , Shipment_Details SD Where S.Shipmentdetailsid = SD.shipmentdetailsid and Sd.useraccountid =" + id;
        ResultSet rs = st.executeQuery(fetch);
        ArrayList <Shipment> table = new ArrayList();
        
        while (rs.next()) {
            String courierName = rs.getString(2);
            int shipmentID = rs.getInt(1);
            String shipmentStatus = rs.getString(3);
            String trackingNumber = rs.getString(4);
            String shipmentDate = rs.getString (5);
            int shipmentDetailsID = rs.getInt(6);
            int orderID = rs.getInt(7);
            Shipment shipment = new Shipment (courierName, shipmentStatus, trackingNumber, shipmentDate, shipmentDetailsID, orderID);
            shipment.setShipmentID(shipmentID);
            table.add(shipment);
        }
        if (!table.isEmpty()){
            return table;
        } else {
            return null;
        }
    }

   


}