package uts.isd.model.dao;

import uts.isd.model.Customer;
import uts.isd.model.Staff;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
 */
public class AcessDBManager {

    private Statement st;

    public AcessDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    /*
        The following functions are for the customer CRUD
    
    */
    

        //Find customer by email and password in the database   
        public Customer findCustomer(String email, String password) throws SQLException {
        //Find if the customer exists in the CUSTOMER TABLE
        String fetch ="select * from IOTBAY.CUSTOMER where EMAIL='" + email + "' and PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()) //goes through every row in the CUSTOMER table
        {
            String customerEmail = rs.getString(6);
            String customerPass = rs.getString(8);
                if (customerEmail.equals(email) && customerPass.equals(password)){
                    //number corresponds to the columns of the user table
                    Integer customerId=rs.getInt(1);
                    String customerName = rs.getString(2);
                    String customerGender = rs.getString(4);
                    String customerDob = rs.getString(3);
                    String customerNumber = rs.getString(5);
                    String customerAddress = rs.getString(7);
                    Boolean customerPromo = rs.getBoolean(9);
                    Integer customerReward = rs.getInt(10);
                    return new Customer (customerId, customerName, customerDob, customerGender, customerNumber, customerEmail, customerAddress, customerPass, customerPromo, customerReward);
                }
        }
        return null;
    }

    //Add a customer-data into the database   
    public void addCustomer(Integer Id, String name, String dob, String gender, String number, String email, String address, String password, Boolean promo, Integer reward, Boolean reg) throws SQLException {                   //code for add-operation       
       st.executeUpdate("INSERT INTO IOTBAY.CUSTOMER " + "VALUES ('" 
               + Id + "','" + name + "', '" + dob + "', '" 
               + gender + "', '" + number + "', '" 
               + email + "', '" + address + "', '" 
               + password + "', '" + promo + "', '"+ reward + "', '"+ reg               
               + "')");

    }
    
    public int customerId() throws SQLException{
        ArrayList list = fetchCustomer();
        
        int i = list.size();
        
        return i+1;
    }

//update a customer details in the database   
    public void updateCustomer(String name, String dob, String gender, String number, String email, String address, String password, Boolean promo, Integer reward) throws SQLException {
       st.executeUpdate("UPDATE IOTBAY.CUSTOMER SET "
               + "NAME ='" + name 
               + "DATEOFBIRTH ='" + dob 
               + "GENDER ='" + gender 
               + "CONTACTNUMBER ='" + number 
               + "BILLINGADDRESS ='" + address 
               + "PASSWORD ='" + password 
               + "PROMOTIONALNEWSLETTER ='" + promo 
               + "', REWARDPOINTS='" + reward 
               + "' WHERE EMAIL='" + email + "'" );

    }

    //delete a customer from the database   
    public void deleteUser(String email) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.CUSTOMER WHERE EMAIL='" + email + "'");

    }
    
    public boolean checkCustomer(String email, String password) throws SQLException
    {
        String fetch = "select * from IOTBAY.CUSTOMER where EMAIL ='" + email + "' and PASSWORD='" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next())
        {
            String customerEmail = rs.getString(6);
            String customerPass = rs.getString(8);
            if (customerEmail.equals(email) && customerPass.equals(password))
            {
                return true;
            }
        }
        return false;
    }
    
    public ArrayList<Customer> fetchCustomer() throws SQLException
    {
        String fetch = "select * from CUSTOMER";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Customer> temp = new ArrayList();
        
        while (rs.next())
        {
            Integer customerId=rs.getInt(1);
            String customerEmail = rs.getString(6);
            String customerPass = rs.getString(8); 
            String customerName = rs.getString(2);
            String customerGender = rs.getString(4);
            String customerDob = rs.getString(3);
            String customerNumber = rs.getString(5);
            String customerAddress = rs.getString(7);
            Boolean customerPromo = rs.getBoolean(9);
            Integer customerReward = rs.getInt(10);
            temp.add(new Customer (customerId, customerName, customerDob, customerGender, customerNumber, customerEmail, customerAddress, customerPass, customerPromo, customerReward));
           
        }
        return temp;
    }
    
    /*
        The following functions are for staff CRUD
    */
    
    
    //Find staff by email and password in the database   
        public Staff findStaff(String email, String password) throws SQLException {
        //Find if the staff exists in the CUSTOMER TABLE
        String fetch ="select * from IOTBAY.STAFF where EMAIL='" + email + "' and PASSWORD = '" + password + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()) //goes through every row in the STAFF table
        {
            String staffEmail = rs.getString(4);
            String staffPass = rs.getString(7);
                if (staffEmail.equals(email) && staffPass.equals(password)){
                    //number corresponds to the columns of the STAFF table
                    String staffName = rs.getString(2);
                    String staffDob = rs.getString(3);
                    String staffNumber = rs.getString(5);
                    String staffAddress = rs.getString(6);
                    return new Staff (staffName, staffDob, staffNumber, staffEmail, staffAddress, staffPass);
                }
        }
        return null;
    }

    //Add a staff-data into the database   
    public void addStaff(String name, String dob, String email, String number, String address, String password) throws SQLException {                   //code for add-operation       
       st.executeUpdate("INSERT INTO IOTBAY.STAFF " + "VALUES ('" 
               + name + "', '" + dob + "', '" 
               + email + "', '" + number+ "', '" 
               + address + "', '" + password + "')");

    }

    //update a staff details in the database   
    public void updateStaff(String name, String dob, String email, String number, String address, String password) throws SQLException {
       st.executeUpdate("UPDATE IOTBAY.STAFF SET "
               + "NAME ='" + name 
               + "DATEOFBIRTH ='" + dob 
               + "PHONENUMBER ='" + number 
               + "ADDRESS ='" + address 
               + "PASSWORD ='" + password 
               + "' WHERE EMAIL='" + email + "'" );

    }

//delete a staff from the database   
    public void deleteStaff(String email) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.STAFF WHERE EMAIL='" + email + "'");

    }

    
    
}
