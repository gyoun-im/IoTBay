package uts.isd.model.dao;

import uts.isd.model.Customer;
import uts.isd.model.Staff;
import uts.isd.model.Access_Log;
import java.sql.*;
import java.util.ArrayList;

/* 
* DBManager is the primary DAO class to interact with the database. 
* Complete the existing methods of this classes to perform CRUD operations with the db.
 */
public class AccessDBManager {

    private Statement st;

    public AccessDBManager(Connection conn) throws SQLException {
        st = conn.createStatement();
    }
    
    /*
        The following functions are for the customer CRUD
    
    */
    

    //Find customer by email in the database   
    public Customer findCustomer(String email) throws SQLException {
        //Find if the customer exists in the CUSTOMER TABLE
        String fetch ="select * from IOTBAY.CUSTOMER where EMAIL='" + email +  "'";
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()){
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
    public void addCustomer(String name, String number, String email, String address, Boolean register, String password, String dob, 
            String gender, Boolean promo, int reward) throws SQLException {                   
        //Add into the CUSTOMER table
      st.executeUpdate("INSERT INTO IOTBAY.CUSTOMER (NAME, CONTACTNUMBER, EMAIL, BILLINGADDRESS, ISREGISTERED) "    
              + "VALUES ('" + name + "','"+number+"', '" + email + "', '" + address + "' , "+register+ ")");
        //Add into the USER_ACCOUNT table
      st.executeUpdate("INSERT INTO IOTBAY.USER_ACCOUNT (USERNAME, PASSWORD, DATEOFBIRTH, GENDER, PROMOTIONALNEWSLETTER, REWARDPOINTS) " 
              + "VALUES ('" + email +"','" + password + "','" + dob + "','" + gender + "'," + promo + "," + reward + ")");

    }
    
    
//update a customer details in the database   
    public void updateCustomer( String name, String number, String email, String address, String password, String dob, String gender, Boolean promo) 
            throws SQLException {
        //Update CUSTOMER table
      st.executeUpdate("UPDATE IOTBAY.CUSTOMER SET NAME ='" + name + "', BILLINGADDRESS = '" + address + "', CONTACTNUMBER='" + number 
              + "' WHERE EMAIL='" + email + "'" );
        //Update USER_ACCOUNT table
      st.executeUpdate("UPDATE IOTBAY.USER_ACCOUNT SET PASSWORD = '" + password + "', DATEOFBIRTH = '" + dob + "', GENDER = '" + gender + "', PROMOTIONALNEWSLETTER = " +promo 
              +" WHERE USERNAME ='"+email+"'");
    }

    //delete a customer from the database   
    public void deleteCustomer(String email) throws SQLException {
        //Delete from CUSTOMER table
        st.executeUpdate("DELETE FROM IOTBAY.CUSTOMER WHERE EMAIL='" + email + "'");
        //Delete from USER_ACCOUNT table
        st.executeUpdate("DELETE FROM IOTBAY.USER_ACCOUNT WHERE USERNAME='" + email + "'");
        

    }
    
    //check if customer exist in the database
    public boolean checkCustomer(String email) throws SQLException
    {
        String fetch = "select * from IOTBAY.CUSTOMER where EMAIL ='" + email + "'";
        ResultSet rs = st.executeQuery(fetch);
        //Find if there is an email matching in the CUSTOMER table
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
    
    //get all customer rows in the CUSTOMER table
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
    public void addStaff( String name, String email, String number, String address, String type, String history, 
            String password, String dob, String gender, Boolean promo, int points) 
            throws SQLException { 
        //Add staff in the USER_ACCOUNT table
        st.executeUpdate("INSERT INTO IOTBAY.USER_ACCOUNT (USERNAME, PASSWORD, DATEOFBIRTH, GENDER, PROMOTIONALNEWSLETTER, REWARDPOINTS) " 
              + "VALUES ('" + email +"','" + password + "','" + dob + "','" + gender + "'," + promo + "," + points + ")");
        
        //Add staff in the CUSTOMER table
        st.executeUpdate("INSERT INTO IOTBAY.STAFF (NAME, EMAIL, PHONENUMBER, ADDRESS, STAFFTYPE, ACTIONHISTORY) "
                + "VALUES ('" + name + "', '"  
               + email + "', '" + number+ "', '" 
               + address + "', '" + type+ "', '" + history+ "')");
    }

    //update a staff details in the database   
    public void updateStaff(String name, String email, String number, String address, String type, String password, String dob, String gender) throws SQLException {
       //update STAFF table
        st.executeUpdate("UPDATE IOTBAY.STAFF SET "
               + "NAME ='" + name 
               + "',STAFFTYPE ='" + type
               + "',PHONENUMBER ='" + number 
               + "',ADDRESS ='" + address 
               + "' WHERE EMAIL='" + email + "'" );
        //update USER_ACCOUNT table
       st.executeUpdate("UPDATE IOTBAY.USER_ACCOUNT SET "
               + "PASSWORD ='" + password 
               + "',DATEOFBIRTH ='" + dob
               + "',GENDER ='" + gender 
               + "' WHERE USERNAME='" + email + "'" );

    }

//delete a staff from the database   
    public void deleteStaff(String email) throws SQLException {
        //delete from STAFF table
        st.executeUpdate("DELETE FROM IOTBAY.STAFF WHERE EMAIL='" + email + "'");
        //delete from USER_ACCOUNT table
        st.executeUpdate("DELETE FROM IOTBAY.USER_ACCOUNT WHERE USERNAME='" + email + "'");

    }
    
    //get all rows in the STAFF table
     public ArrayList<Staff> fetchStaff() throws SQLException
    {
        String fetch = "select * from STAFF";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Staff> temp = new ArrayList();
        
        while (rs.next())
        {
            Integer staffId=rs.getInt(1);
            String staffEmail = rs.getString(3);           
            String staffName = rs.getString(2);
            String staffNumber = rs.getString(4);
            String staffAddress = rs.getString(5);
            String staffType = rs.getString(6);
            String staffHistory = rs.getString(7);
            int userId= rs.getInt(8);
            
            temp.add(new Staff (staffId, staffName,  staffEmail, staffNumber, staffAddress, staffType, staffHistory, userId));
           
        }
        return temp;
    }

     //Check if staff exist in the database
     public boolean checkStaff(String email) throws SQLException
    {
        String fetch = "select * from IOTBAY.STAFF where EMAIL ='" + email + "'";
        ResultSet rs = st.executeQuery(fetch);
        //Find if there is an email matching in the STAFF table
        while (rs.next())
        {
            String staffEmail = rs.getString(3);
            if (staffEmail.equals(email) )
            {
                return true;
            }
        }
        return false;
    }
    
    


/*

    The following code are for the access log CRUD
    Since a user cannot delete or update any access logs
    no code is created for update and deleting logs

*/


        //Find log using LogId in the database 
        public Access_Log findLog(int logId) throws SQLException {
        //Find if the log exists in the ACCESS_LOG table
        String fetch ="select * from IOTBAY.ACCESS_LOG where ACCESSLOGID=" + logId ;
        ResultSet rs = st.executeQuery(fetch);
        
        while(rs.next()){    
            int lognum = rs.getInt(1);
            
                if (lognum == logId){
                    //number corresponds to the columns of the ACCESS_LOG table
                    String logDate = rs.getString(3);
                    String logTime = rs.getString(4);
                    Integer userId =rs.getInt(2);
                    return new Access_Log (lognum, userId, logDate, logTime);
                }
        }
        return null;
    }

    //Add a staff-data into the database   
    public void addLog(String date, String time) 
            throws SQLException { 
        //Add staff in the USER_ACCOUNT table
        st.executeUpdate("INSERT INTO IOTBAY.ACCESS_LOG (DATE, TIME) " 
              + "VALUES ('" + date +"','" + time + "')");
       
    }

    //get all rows in the ACCESS_LOG table
     public ArrayList<Access_Log> fetchLog() throws SQLException
    {
        String fetch = "select * from ACCESS_LOG";
        ResultSet rs = st.executeQuery(fetch);
        ArrayList<Access_Log> temp = new ArrayList();
        
        while (rs.next())
        {
            Integer logId=rs.getInt(1);
            String logDate = rs.getString(3);           
            String logTime = rs.getString(4);
            int userId= rs.getInt(2);
            
            temp.add(new Access_Log (logId, userId, logDate, logTime));
           
        }
        return temp;
    }
     
}

    
    
    

