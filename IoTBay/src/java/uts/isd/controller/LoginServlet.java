package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        Validator validator = new Validator();                              //2- create an instance of the Validator class    
        String email = request.getParameter("email");                       //3- capture the posted email      
        String password = request.getParameter("password");                 //4- capture the posted password    
        AccessDBManager manager = (AccessDBManager) session.getAttribute("manager");    //5- retrieve the manager instance from session      
        User_Account user = null;
        validator.clear(session);

        if(!validator.validateEmail(email)){                                        //Check if email is valid
            session.setAttribute("emailErr", "Error: Email format incorrect");      //If not show error msg
            request.getRequestDispatcher("login.jsp").include(request, response);   //Go back to login.jsp
        }else if(!validator.validatePassword(password)){                            //Check pw
            session.setAttribute("passErr", "Error: Password format incorrect");    //If not, show error msg
            request.getRequestDispatcher("login.jsp").include(request, response);   //go back to login.jsp
        }else{        
        try {
            user = manager.findUser(email, password);
            if(user != null){   //if user exists in the database, send them to the main dashboard
                session.setAttribute("user", user);
                LocalDate date = LocalDate.now();                               //Get local date
                LocalTime time = LocalTime.now();                               //Get local time
                manager.addLog(String.valueOf(date), String.valueOf(time));     //Add a row to the Access_Log table
                request.getRequestDispatcher("main.jsp").include(request, response);
            }else{              //if they are not in the database, send them back to the login screen
                session.setAttribute("existErr", "User does not exist in the database");
                request.getRequestDispatcher("login.jsp").include(request, response);
            }
        } catch (SQLException | NullPointerException ex) {
            System.out.println(ex.getMessage() == null ? "User does not exist":"welcome");
        }


    
        }
    }
}
