/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import java.sql.*;
import java.util.*;
import java.util.logging.*;
import iotbay.model.dao.*;
import iotbay.model.Shipment;
import iotbay.model.Shipment_Details;
/**
 *
 * @author Bryan Guntoro
 */
public class TestDB {
    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private ShipmentDBManager db;

    public static void main (String [] args) throws SQLException {
        (new TestDB()).runQueries();
    }
    
    public TestDB() {
        try {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new ShipmentDBManager(conn);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private char readChoice(){
        System.out.println("Operation CRUDS or * to exit");
        return in.nextLine().charAt(0);
    }
    
    private void runQueries() throws SQLException {
        char c;
        
        while ((c = readChoice()) != '*') {
            switch (c) {
                case 'C': // Add Shipment Detail
                    testAdd(4);
                    break;
                    
                case 'R': // Find a shipment by id and date
                   testRead();
                   break;
                 
                case 'O': // View all shipment details of a user
                    viewAllShipment(4);
                    break;
                case 'U':
                    findAllShipment();
                    break;
                    /*
                case 'D' // Delete a shipment detail
                    testDelate();
                    break; */
                default:
                    System.out.println("Invalid Command. Please try again");
                    break;
            }
        }
    }
    
    
    // Adding a shipment Detail - The id is accessed by user.getId in the session
    private void testAdd(int id) {
        System.out.print("Street Adress: ");
        String streetAddress = in.nextLine();
        System.out.print("Suburb: ");
        String suburb = in.nextLine();
        System.out.print("Post Code: ");
        int postCode = in.nextInt();
        in.nextLine();
        System.out.print("State: ");
        String state = in.nextLine();
        try {
            db.addShipmentDetails(streetAddress, suburb, postCode, state, id); // How do u passed on the userAccountID which is 1 in thix context 
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Shipment Detail is added to your account");
    }
    
    
    // Find an existing shipment by ID and date
    private void testRead () throws SQLException {
        System.out.print("Shipping ID: ");
        int shippingID = in.nextInt();
        in.nextLine();
        System.out.print("Date (DD/MM/YYYY): ");
        String dateS = in.nextLine();
        Shipment shipment = db.findShipment(shippingID, dateS);
        if(shipment!= null) {
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.println("Shipment ID: " + shippingID +  "\n" + "Courier name: " + shipment.getCourierName() + "\n" + "Shipment Status: " + shipment.getShipmentStatus() + "\n" + "Tracking Number: " + shipment.getTrackingNumber());
            Shipment_Details shipmentD = db.findShipmentDetails(shipment.getShipmentDetailsID());
            System.out.println("Delivery Address: " + shipmentD.getStreetAddress() + ", " + shipmentD.getSuburb() + ", " + shipmentD.getPostcode() + ", " + shipmentD.getState() + "");
        } else {
            System.out.println("Shipment doesn't exist!");
        }
    }
    
    
        // View all Shipment Details
    private void viewAllShipment(int id) throws SQLException {
        try {
            ArrayList<Shipment_Details> shipmentdetails = db.fectShipmentDetails(id);
            System.out.println("Saved Shipping Details:");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-30s %-20s %-20s \n","ID", "Street Address", "Suburb", "Postcode", "State");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            shipmentdetails.stream().forEach((shipmentdetail) -> { 
                System.out.printf("%-10d %-20s %-30s %-20d %-3s \n",shipmentdetail.getShipmentDetailsID(), shipmentdetail.getStreetAddress(), shipmentdetail.getSuburb(),shipmentdetail.getPostcode(), shipmentdetail.getState());
            });
            System.out.println();      
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void findAllShipment () {
        System.out.print("User ID: ");
        int userID = in.nextInt();
        in.nextLine();
         try {
            ArrayList<Shipment> shipment = db.fectShipment(userID);
            System.out.println("Saved Shipping Details:");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            System.out.printf("%-10s %-20s %-30s %-20s %-20s \n","ID", "CourierName", "Status", "trackNumber", "Shipment Date");
            System.out.println("---------------------------------------------------------------------------------------------------------------");
            shipment.stream().forEach((shipments) -> { 
                System.out.printf("%-10d %-20s %-30s %-20s %-3s \n",shipments.getShipmentID(), shipments.getCourierName(), shipments.getShipmentStatus(),shipments.getTrackingNumber(), shipments.getShipmentDate());
            });
            System.out.println();      
        } catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

