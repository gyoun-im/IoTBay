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
        System.out.print("User dob: ");
        String dob = in.nextLine();
        System.out.print("User gender: ");
        String gender = in.nextLine();
        System.out.print("User number: ");
        String number = in.nextLine();
        System.out.print("User email: ");
        String email = in.nextLine();
        System.out.print("User address: ");
        String address = in.nextLine();
        System.out.print("User password: ");
        String password = in.nextLine();
        System.out.print("User promo: ");
        String promo = in.nextLine();
        System.out.print("User reward: ");
        String reward = in.nextLine();
        System.out.print("User reg: ");
        String reg = in.nextLine();

        try{
            db.addCustomer(db.customerId(), name, dob, gender, number, email, address, password, Boolean.TRUE, Integer.SIZE, Boolean.TRUE);
        } catch (SQLException ex){
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE,null, ex);
        }
        System.out.println("User is added to the database.");
        
    }
    
    private void testRead() throws SQLException{
        System.out.print("User email:");
        String email = in.nextLine();
        System.out.print("User password:");
        String password = in.nextLine();
        Customer customer = db.findCustomer(email, password);
        
        if(customer != null){
            System.out.println("User " + customer.getName() + " exists in the database.");
        }else{
            System.out.println("User does not exist in the database.");
        }
    }
    
    private void testUpdate() {
        
        System.out.print("User email:");
        String email = in.nextLine();
        System.out.print("User password:");
        String password = in.nextLine();
        
        try{
            if(db.checkCustomer(email, password)){
                System.out.print("User name: ");
                String name = in.nextLine();
                System.out.print("User gender: ");
                String gender = in.nextLine();
                System.out.print("User favourite colour:");
                String colour = in.nextLine();
                db.updateCustomer(name, name, gender, name, email, gender, password, Boolean.TRUE, Integer.SIZE);
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
        System.out.print("User password:");
        String password = in.nextLine();
        
        try{
            if(db.checkCustomer(email, password)){
                db.deleteUser(email);
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
                System.out.printf("%-40s %-40s %-40s %-40s %-40s %-40s %-40s %-40s %-40s\n", 
                 customer.getName(), customer.getDob(), customer.getGender(), customer.getNumber(), customer.getEmail(), customer.getAddress(), customer.getPassword(), customer.getPromo(), customer.getReward());
            });
            System.out.println();        
        }catch (SQLException ex) {
            Logger.getLogger(TestDB.class.getName()).log(Level.SEVERE,null, ex);
        }      
    
    }
    
}

