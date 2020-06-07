package uts.isd.model.dao;

import uts.isd.model.Customer;
import uts.isd.model.Staff;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
 */
public class DBManager_Access {

    private Statement st;

    public DBManager_Access(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    /*
        The following functions are for the customer CRUD
    
    */
    

        //Find customer by email and password in the database   
        public Customer findCustomer(String email) throws SQLException {
        //Find if the customer exists in the CUSTOMER TABLE
        String fetch ="select * from IOTBAY.CUSTOMER where EMAIL='" + email +  "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()) //goes through every row in the CUSTOMER table
        {
            String customerEmail = rs.getString(4);
                if (customerEmail.equals(email)){
                    //number corresponds to the columns of the user table
                    Integer customerId=rs.getInt(1);
                    String customerName = rs.getString(2);
                    String customerNumber = rs.getString(3);
                    String customerAddress = rs.getString(5);
                    Boolean customerReg = rs.getBoolean(6);        
                    return new Customer (customerId, customerName, customerNumber, customerEmail, customerAddress, customerReg);
                }
        }
        return null;
    }

    //Add a customer-data into the database   
    public void addCustomer(String name, String number, String email, String address, boolean register) throws SQLException {                   //code for add-operation       
      st.executeUpdate("INSERT INTO IOTBAY.CUSTOMER " + "VALUES ('" + name + "','"+number+"', '" + email + "', '" + address + "', '" + register + "')");

    }
    
    public int customerId() throws SQLException{
        ArrayList list = fetchCustomer();
        
        int i = list.size();
        
        return i+1;
    }

//update a customer details in the database   
    public void updateCustomer( String name, String number, String email, String address) throws SQLException {
      st.executeUpdate("UPDATE IOTBAY.CUSTOMER SET NAME ='" + name + "', BILLINGADDRESS = '" + address + "', CONTACTNUMBER='" + number + "' WHERE EMAIL='" + email + "'" );

    }

    //delete a customer from the database   
    public void deleteCustomer(String email) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.CUSTOMER WHERE EMAIL='" + email + "'");

    }
    
    public boolean checkCustomer(String email) throws SQLException
    {
        String fetch = "select * from IOTBAY.CUSTOMER where EMAIL ='" + email + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while (rs.next())
        {
            String customerEmail = rs.getString(4);
            if (customerEmail.equals(email) )
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
            String customerEmail = rs.getString(4);           
            String customerName = rs.getString(2);
            String customerNumber = rs.getString(3);
            String customerAddress = rs.getString(5);
            Boolean customerReg = rs.getBoolean(6);
            
            temp.add(new Customer (customerId, customerName,  customerNumber, customerEmail, customerAddress, customerReg));
           
        }
        return temp;
    }
    
    /*
        The following functions are for staff CRUD
    */
    
    
    //Find staff by email and password in the database   
        public Staff findStaff(String email) throws SQLException {
        //Find if the staff exists in the CUSTOMER TABLE
        String fetch ="select * from IOTBAY.STAFF where EMAIL='" + email + "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()) //goes through every row in the STAFF table
        {
            String staffEmail = rs.getString(3);
            
                if (staffEmail.equals(email)){
                    //number corresponds to the columns of the STAFF table
                    Integer staffId =rs.getInt(1);
                    String staffName = rs.getString(2);
                    String staffNumber = rs.getString(4);
                    String staffAddress = rs.getString(5);
                    String staffType = rs.getString(6);
                    String staffHistory = rs.getString(7);
                    Integer userId =rs.getInt(8);
                    return new Staff (staffId, staffName, staffNumber, staffEmail, staffAddress, staffType, staffHistory, userId);
                }
        }
        return null;
    }

    //Add a staff-data into the database   
    public void addStaff(int staffid, String name, String email, String number, String address, String type, String history, int accid) throws SQLException {                   //code for add-operation       
       st.executeUpdate("INSERT INTO IOTBAY.STAFF " + "VALUES ('" 
               + staffid + "','" + name + "', '"  
               + email + "', '" + number+ "', '" 
               + address + "', '" + type+ "', '" + history+ "', '"             
               + accid + "')");

    }

    //update a staff details in the database   
    public void updateStaff( String name, String email, String number, String address, String type, String history, int accid) throws SQLException {
       st.executeUpdate("UPDATE IOTBAY.STAFF SET "
               + "NAME ='" + name 
               + "TYPE ='" + type
               + "PHONENUMBER ='" + number 
               + "ADDRESS ='" + address 
               + "history ='" + history 
               + "' WHERE EMAIL='" + email + "'" );

    }

//delete a staff from the database   
    public void deleteStaff(String email) throws SQLException {
        st.executeUpdate("DELETE FROM IOTBAY.STAFF WHERE EMAIL='" + email + "'");

    }

    
    
}
