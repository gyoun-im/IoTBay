/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.controller;

import java.io.IOException;
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
        AccessValidator validator = new AccessValidator();
        int id=0;                                               //id is auto-generated
        int accid =0;                                           //id is auto-generated
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String number = request.getParameter("number");
        String address = request.getParameter("address");
        String news = request.getParameter(String.valueOf("news"));
        
        validator.clear(session);
                
        Customer customer = new Customer(id, name, number, email, address, Boolean.valueOf(news));
        User user = new User(accid, email, password, dob, gender, Boolean.valueOf(news), id);
        AccessDBManager manager = (AccessDBManager) session.getAttribute("manager");
        
        if(validator.registerCheckEmpty(email, password, name, dob, number, gender, address)){
            session.setAttribute("empErr", "Please fill in every textfield");
            request.getRequestDispatcher("customerRegister.jsp").include(request, response);
        }
        
        else if(!validator.validateNumber(number)){                                        //Check if email is valid
            session.setAttribute("numErr", "Error: Number format incorrect");      //If not show error msg
            request.getRequestDispatcher("customerDetails.jsp").include(request, response);   //Go back to login.jsp
        }else if(!validator.validatePassword(password)){                            //Check pw
            session.setAttribute("passErr", "Error: Password format incorrect");    //If not, show error msg
            request.getRequestDispatcher("customerDetails.jsp").include(request, response);   //go back to login.jsp
        }else if(!validator.validateName(name)){                            //Check pw
            session.setAttribute("nameErr", "Error: Name format incorrect");    //If not, show error msg
            request.getRequestDispatcher("customerDetails.jsp").include(request, response);   //go back to login.jsp
        }else{  
       
        try{                                                                                 
            if(user != null){
                session.setAttribute("user", user);
                session.setAttribute("customer", customer);
                manager.updateCustomer(name, number, email, address, password, dob, gender, Boolean.TRUE);  //Update both CUSTOMER and USER_ACCOUNT table
                session.setAttribute("updated", "Update was successful");                                   //Displays a message to the user if update is successful
                request.getRequestDispatcher("customerDetails.jsp").include(request, response);
            }else{
                session.setAttribute("updated", "Update was not successful");
                request.getRequestDispatcher("customerDetails.jsp").include(request, response);
            }
        }catch(SQLException ex){
            Logger.getLogger(CustomerUpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("customerDetails.jsp");
        }
    }
}
