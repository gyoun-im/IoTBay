package uts.isd.controller;

import java.sql.*;

import java.util.*;
import java.util.logging.*;
import uts.isd.model.*;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.*;

public class CustomerTestDB {

    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
<<<<<<< HEAD:IoTBay/src/java/uts/isd/controller/TestDB.java
    private AcessDBManager db;
=======
    private AccessDBManager db;
>>>>>>> Gabriel:IoTBay/src/java/uts/isd/controller/CustomerTestDB.java
    
    public static void main(String[] args) throws SQLException {
        (new CustomerTestDB()).runQueries();
        
    }
    
    public CustomerTestDB()
    {
        try
        {
            connector = new DBConnector();
            conn = connector.openConnection();
<<<<<<< HEAD:IoTBay/src/java/uts/isd/controller/TestDB.java
            db = new AcessDBManager(conn);
=======
            db = new AccessDBManager(conn);
>>>>>>> Gabriel:IoTBay/src/java/uts/isd/controller/CustomerTestDB.java
        }catch (ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(CustomerTestDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private char readChoice()
    {
        System.out.print("Operation CRUDS or * to exit: ");
        return in.nextLine().charAt(0);
    }
    
    private void runQueries() throws SQLException
    {
        char c;
        
        while ((c = readChoice()) != '*'){
            switch (c){
                case 'C':
                    testAdd();
                    break;
                case 'R':
                    testRead();
                    break;
                case 'U':
                    testUpdate();
                    break;
                case 'D':
                    testDelete();
                case 'S':
                    showAll();
                    break;
                default:
                    System.out.println("Unknown Command");
                    
            }
            
        }
    }
    
    private void testAdd(){
        
<<<<<<< HEAD:IoTBay/src/java/uts/isd/controller/TestDB.java
        System.out.print("User id: ");
        String id = in.nextLine();
        System.out.print("User name: ");
=======
        System.out.print("Customer name: ");
>>>>>>> Gabriel:IoTBay/src/java/uts/isd/controller/CustomerTestDB.java
        String name = in.nextLine();
        System.out.print("Customer number: ");
        String number = in.nextLine();
        System.out.print("Customer email: ");
        String email = in.nextLine();
        System.out.print("Customer address: ");
        String address = in.nextLine();
        System.out.print("Customer password: ");
        String password = in.nextLine();
        System.out.print("Customer dob: ");
        String dob = in.nextLine();
        System.out.print("Customer gender: ");
        String gender = in.nextLine();
       
       

        try{
<<<<<<< HEAD:IoTBay/src/java/uts/isd/controller/TestDB.java
            db.addCustomer(name, number, email, address, true);

=======
            db.addCustomer(name, number, email, address, true, password, dob, gender, true, 0 );
>>>>>>> Gabriel:IoTBay/src/java/uts/isd/controller/CustomerTestDB.java
        } catch (SQLException ex){
            Logger.getLogger(CustomerTestDB.class.getName()).log(Level.SEVERE,null, ex);
        }
        System.out.println("Customer is added to the database.");
        
    }
    
    private void testRead() throws SQLException{
        System.out.print("Customer email:");
        String email = in.nextLine();   
        Customer customer = db.findCustomer(email);
        
        if(customer != null){
            System.out.println("Customer " + customer.getName() + " exists in the database.");
        }else{
            System.out.println("Customer does not exist in the database.");
        }
    }
    
    private void testUpdate() {
        
        System.out.print("Customer email:");
        String email = in.nextLine();
        
        try{
            if(db.checkCustomer(email)){
                System.out.print("Customer name: ");
                String name = in.nextLine();
                System.out.print("Customer number: ");
                String number = in.nextLine();
                System.out.print("Customer address: ");
                String address = in.nextLine();  
                System.out.print("Customer password: ");
                String password = in.nextLine();  
                System.out.print("Customer gender: ");
                String gender = in.nextLine();  
                System.out.print("Customer dob: ");
                String dob = in.nextLine();  
                               
                
                db.updateCustomer(name, number, email, address, password, dob, gender, Boolean.TRUE);
            }else{
                System.out.println("Customer does not exist");
            }
        }catch (SQLException ex) {
            Logger.getLogger(CustomerTestDB.class.getName()).log(Level.SEVERE,null, ex);
        }     
    }
    
    private void testDelete(){
        System.out.print("Customer email:");
        String email = in.nextLine();
       
        
        try{
            if(db.checkCustomer(email)){
                db.deleteCustomer(email);
            }else{
                System.out.println("Customer does not exist");
            }
        }catch (SQLException ex) {
            Logger.getLogger(CustomerTestDB.class.getName()).log(Level.SEVERE,null, ex);
        }     
        
    }
    
    private void showAll(){
        try{
            ArrayList<Customer> customers = db.fetchCustomer();
            System.out.println("Customer Table:");
            customers.stream().forEach((customer) -> {
                System.out.printf("%-40s %-40s %-40s %-40s %-40s\n", 
                 customer.getId(), customer.getName(), customer.getNumber(), customer.getEmail(), customer.getAddress());
            });
            System.out.println();        
        }catch (SQLException ex) {
            Logger.getLogger(CustomerTestDB.class.getName()).log(Level.SEVERE,null, ex);
        }      
    
    }
    
}

