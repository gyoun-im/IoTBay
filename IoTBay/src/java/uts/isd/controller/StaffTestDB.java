package uts.isd.controller;

import java.sql.*;

import java.util.*;
import java.util.logging.*;
import uts.isd.model.*;
import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.*;
import uts.isd.model.Staff;

public class StaffTestDB {

    private static Scanner in = new Scanner(System.in);
    private DBConnector connector;
    private Connection conn;
    private AccessDBManager db;
    
    public static void main(String[] args) throws SQLException {
        (new StaffTestDB()).runQueries();
        
    }
    
    public StaffTestDB()
    {
        try
        {
            connector = new DBConnector();
            conn = connector.openConnection();
            db = new AccessDBManager(conn);
        }catch (ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(StaffTestDB.class.getName()).log(Level.SEVERE, null, ex);
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
        
        System.out.print("Staff name: ");
        String name = in.nextLine();
        System.out.print("Staff number: ");
        String number = in.nextLine();
        System.out.print("Staff email: ");
        String email = in.nextLine();
        System.out.print("Staff address: ");
        String address = in.nextLine();
        System.out.print("Staff password: ");
        String password = in.nextLine();
        System.out.print("Staff dob: ");
        String dob = in.nextLine();
        System.out.print("Staff gender: ");
        String gender = in.nextLine();
        System.out.print("Staff type: ");
        String type = in.nextLine();
       
       

        try{
            db.addStaff(name, email, number, address, type, "null", password, dob, gender, Boolean.FALSE, 0);
        } catch (SQLException ex){
            Logger.getLogger(StaffTestDB.class.getName()).log(Level.SEVERE,null, ex);
        }
        System.out.println("Staff is added to the database.");
        
    }
    
    private void testRead() throws SQLException{
        System.out.print("Staff email:");
        String email = in.nextLine();   
        Staff staff = db.findStaff(email);
        
        if(staff != null){
            System.out.println("Staff " + staff.getName() + " exists in the database.");
        }else{
            System.out.println("Staff does not exist in the database.");
        }
    }
    
    private void testUpdate() {
        
        System.out.print("Staff email:");
        String email = in.nextLine();
        
        try{
            if(db.checkStaff(email)){
                System.out.print("Staff name: ");
                String name = in.nextLine();
                System.out.print("Staff number: ");
                String number = in.nextLine();
                System.out.print("Staff address: ");
                String address = in.nextLine();  
                System.out.print("Staff password: ");
                String password = in.nextLine();  
                System.out.print("Staff gender: ");
                String gender = in.nextLine();  
                System.out.print("Staff dob: ");
                String dob = in.nextLine();  
                               
                
                db.updateStaff(name, email, number, address, name, password, dob, gender);
            }else{
                System.out.println("Customer does not exist");
            }
        }catch (SQLException ex) {
            Logger.getLogger(StaffTestDB.class.getName()).log(Level.SEVERE,null, ex);
        }     
    }
    
    private void testDelete(){
        System.out.print("Staff email:");
        String email = in.nextLine();
       
        
        try{
            if(db.checkStaff(email)){
                db.deleteStaff(email);
            }else{
                System.out.println("Staff does not exist");
            }
        }catch (SQLException ex) {
            Logger.getLogger(StaffTestDB.class.getName()).log(Level.SEVERE,null, ex);
        }     
        
    }
    
    private void showAll(){
        try{
            ArrayList<Staff> staffs = db.fetchStaff();
            System.out.println("Staff Table:");
            staffs.stream().forEach((staff) ->{
                System.out.printf("%-30s %-30s %-30s %-30s %-30s %-30s %-30s\n", 
                 staff.getStaffid(), staff.getName(), staff.getEmail(), staff.getAddress(), staff.getType(), staff.getHistory(), staff.getAccid());
            });
            System.out.println();        
        }catch (SQLException ex) {
            Logger.getLogger(StaffTestDB.class.getName()).log(Level.SEVERE,null, ex);
        }      
    
    }
    
}

