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

public class AccessCustomerMainServlet extends HttpServlet {

       @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();                         //1- retrieve the current session
        AccessValidator validator = new AccessValidator();  
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        AccessDBManager manager = (AccessDBManager) session.getAttribute("manager");
        
        
        
        
    }
    

    

}
