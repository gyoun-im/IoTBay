package uts.isd.model.dao;

import uts.isd.model.Customer;
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
                    String customerName = rs.getString(2);
                    String customerGender = rs.getString(4);
                    String customerDob = rs.getString(3);
                    String customerNumber = rs.getString(5);
                    String customerAddress = rs.getString(7);
                    Boolean customerPromo = rs.getBoolean(9);
                    Integer customerReward = rs.getInt(10);
                    return new Customer (customerName, customerDob, customerGender, customerNumber, customerEmail, customerAddress, customerPass, customerPromo, customerReward);
                }
        }
        return null;
    }

    //Add a customer-data into the database   
    public void addCustomer(String name, String dob, String gender, String number, String email, String address, String password, Boolean promo, Integer reward) throws SQLException {                   //code for add-operation       
       st.executeUpdate("INSERT INTO ISDUSER.Users " + "VALUES ('" 
               + name + "', '" + dob + "', '" 
               + gender + "', '" + number + "', '" 
               + email + "', '" + address + "', '" 
               + password + "', '" + promo + "', '" 
               + reward + "')");

    }

//update a customer details in the database   
    public void updateCustomer(String name, String dob, String gender, String number, String email, String address, String password, Boolean promo, Integer reward) throws SQLException {
       st.executeUpdate("UPDATE ISDUSER.Users SET "
               + "NAME ='" + name 
               + "DATEOFBIRTH ='" + dob 
               + "GENDER ='" + gender 
               + "NUMBER ='" + number 
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
}
