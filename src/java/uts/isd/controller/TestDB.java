package uts.isd.controller;

import java.sql.*;

import java.util.*;
import java.util.logging.*;
import uts.isd.model.*;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.*;

public class TestDB {

    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private DBManager_Access db;
    
    public static void main(String[] args) throws SQLException {
        (new TestDB()).runQueries();
        
    }
    
    public TestDB()
    {
        try
        {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new DBManager_Access(conn);
        }catch (ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE, null, ex);
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
        
        System.out.print("User name: ");
        String name = in.nextLine();
        System.out.print("User number: ");
        String number = in.nextLine();
        System.out.print("User email: ");
        String email = in.nextLine();
        System.out.print("User address: ");
        String address = in.nextLine();
        

        try{
            db.addCustomer(name, number, email, address, true);
        } catch (SQLException ex){
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE,null, ex);
        }
        System.out.println("User is added to the database.");
        
    }
    
    private void testRead() throws SQLException{
        System.out.print("User email:");
        String email = in.nextLine();   
        Customer customer = db.findCustomer(email);
        
        if(customer != null){
            System.out.println("User " + customer.getName() + " exists in the database.");
        }else{
            System.out.println("User does not exist in the database.");
        }
    }
    
    private void testUpdate() {
        
        System.out.print("User email:");
        String email = in.nextLine();
        
        try{
            if(db.checkCustomer(email)){
                System.out.print("User name: ");
                String name = in.nextLine();
                System.out.print("User number: ");
                String number = in.nextLine();
                System.out.print("User address: ");
                String address = in.nextLine();     
                db.updateCustomer(name, number, email, address);
            }else{
                System.out.println("User does not exist");
            }
        }catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE,null, ex);
        }     
    }
    
    private void testDelete(){
        System.out.print("User email:");
        String email = in.nextLine();
       
        
        try{
            if(db.checkCustomer(email)){
                db.deleteCustomer(email);
            }else{
                System.out.println("User does not exist");
            }
        }catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE,null, ex);
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
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE,null, ex);
        }      
    
    }
    
}

