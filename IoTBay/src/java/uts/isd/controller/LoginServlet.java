package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.AccessDBManager;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();                         //1- retrieve the current session
        AccessValidator validator = new AccessValidator();                              //2- create an instance of the AccessValidator class    
        String email = request.getParameter("email");                       //3- capture the posted email      
        String password = request.getParameter("password");                 //4- capture the posted password    
        AccessDBManager manager = (AccessDBManager) session.getAttribute("manager");    //5- retrieve the manager instance from session      
        User user = null;                                                   //null values to determine whether       
        Customer customer = null;                                                   //a customer or a staff is logging in
        Staff staff = null;
        validator.clear(session);
        
         if(validator.checkEmpty(email, password)){
            session.setAttribute("empErr", "Please fill in every textfield");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
         else if(!validator.validateEmail(email)){                                        //Check if email is valid
            session.setAttribute("emailErr", "Error: Email format incorrect");      //If not show error msg
            request.getRequestDispatcher("login.jsp").include(request, response);   //Go back to login.jsp
        }else if(!validator.validatePassword(password)){                            //Check pw
            session.setAttribute("passErr", "Error: Password format incorrect");    //If not, show error msg
            request.getRequestDispatcher("login.jsp").include(request, response);   //go back to login.jsp
        }else{        
        try {
            user = manager.findUser(email, password);                                           //find user in the USER_ACCOUNT table
            customer = manager.findCustomer(email);                                             //find customer in the CUSTOMER table
            staff = manager.findStaff(email);                                                   //find staff in the STAFF table
            if(user != null && customer != null && staff == null){                              //if customer is the one logging in
                session.setAttribute("user", user);  
                session.setAttribute("customer", customer);
                int id = user.getAccid();                                                       //get userId of the user
                manager.addLog(id,"LOGIN");                                                             //Add a row to the Access_Log table
                request.getRequestDispatcher("customerMain.jsp").include(request, response);
            }else if(user != null && staff != null && customer == null){                        //if staff is the one logging in
                session.setAttribute("user", user);
                session.setAttribute("staff", staff);
                int id = user.getAccid();                                                       //get userId of the user
                manager.addLog(id,"LOGIN");                                                             //Add a row to the Access_Log table
                request.getRequestDispatcher("staffMain.jsp").include(request, response);
            }else{                                                                              //if they are not in the database, clear the textfield
                session.setAttribute("existErr", "User does not exist in the database");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "User does not exist":"welcome");
        }


    
        }
    }
}
