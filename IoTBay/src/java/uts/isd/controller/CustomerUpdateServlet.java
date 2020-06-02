/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import java.util.logging.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.AccessDBManager;

/**
 *
 * @author Gabriel
 */
public class CustomerUpdateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        int id=0;       //id is auto-generated
        int accid =0;   //id is auto-generated
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String number = request.getParameter("number");
        String address = request.getParameter("address");
        String news = request.getParameter(String.valueOf("news"));
                
        Customer customer = new Customer(id, name, number, email, address, Boolean.valueOf(news));
        User_Account user = new User_Account(accid, email, password, dob, gender, Boolean.valueOf(news), id);
        AccessDBManager manager = (AccessDBManager) session.getAttribute("manager");
        
        
         //Check if all the textfields are valid
        if(!validator.validateEmail(email)){
            session.setAttribute("emailErr", "Error: Email format is incorrect");
            request.getRequestDispatcher("personal_details.jsp").include(request, response);
        }else if(!validator.validateName(name)){
            session.setAttribute("nameErr", "Error: Name format is incorrect");
            request.getRequestDispatcher("personal_details.jsp").include(request, response);
        }else if(!validator.validatePassword(password)){
            session.setAttribute("passErr", "Error: Password format is incorrect");
            request.getRequestDispatcher("personal_details.jsp").include(request, response);
        }else{
        try{
            if(manager.checkCustomer(email)){                                                   //each email is unique
            session.setAttribute("emailErr", "Error: Email already exists");                    //is a user were to change their email to an email
            request.getRequestDispatcher("personal_details.jsp").include(request, response);    //that already exists in the database
            }                                                                                   //It will give an error
            else if(user != null){
                session.setAttribute("user", user);
                session.setAttribute("customer", customer);
                manager.updateCustomer(name, number, email, address, password, dob, gender, Boolean.TRUE);  //Update both CUSTOMER and USER_ACCOUNT table
                session.setAttribute("updated", "Update was successful");                                   //Displays a message to the user if update is successful
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }else{
                session.setAttribute("updated", "Update was not successful");
                request.getRequestDispatcher("edit.jsp").include(request, response);
            }
        }catch(SQLException ex){
            Logger.getLogger(CustomerEditServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("edit.jsp");
        }
    }
}
