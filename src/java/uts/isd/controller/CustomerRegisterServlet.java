package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.ServletException;
import java.util.logging.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.AccessDBManager;
import uts.isd.controller.Validator;

public class CustomerRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        int id =0;                                              //default value because id is auto-generated
        int accid = 0;                                          //default value because userid is auto-generated
        
        //get session
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        
        //all the textfields in the customer_register.jsp
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String number = request.getParameter("number");
        String address = request.getParameter("address");
        String news = request.getParameter(String.valueOf("news"));
        AccessDBManager manager = (AccessDBManager) session.getAttribute("manager");
        validator.clear(session);
        
        //Check if all the textfields are valid
        if(!validator.validateEmail(email)){
            session.setAttribute("emailErr", "Error: Email format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }else if(!validator.validateName(name)){
            session.setAttribute("nameErr", "Error: Name format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }else if(!validator.validatePassword(password)){
            session.setAttribute("passErr", "Error: Password format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }else{
            try{
                Customer exist = manager.findCustomer(email);
                if(exist != null){                                                          //if the customer is already registered
                    session.setAttribute("existErr", "Customer already exists in the database");
                    request.getRequestDispatcher("customer_register.jsp").include(request, response);
                }else{
                    //if customer does not exist in the CUSTOMER table, add it to CUSTOMER and USER_ACCOUNT table
                    manager.addCustomer(name, number, email, address, Boolean.FALSE, password, dob, gender, Boolean.TRUE, 0);
                    Customer customer = new Customer(id, name, number, email, address, Boolean.valueOf(news));
                    User_Account user = new User_Account(accid, email, password, dob, gender, Boolean.valueOf(news), id);
                    session.setAttribute("customer", customer);
                    session.setAttribute("user", user);
                    LocalDate date = LocalDate.now();                                   //Get local date
                    LocalTime time = LocalTime.now();                                   //Get local time
                    manager.addLog(String.valueOf(date), String.valueOf(time));         //Add a row to the Access_Log table
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
                
            }catch(SQLException ex){
                Logger.getLogger(CustomerRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        
        
    }
    
   
}
