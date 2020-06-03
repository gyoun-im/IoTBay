package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User_Account;
import uts.isd.model.dao.AccessDBManager;

public class AccessCustomerMainServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        AccessDBManager manager = (AccessDBManager) session.getAttribute("manager");
        
        try {
            User_Account user = manager.findUser(email, password);
            if(user != null){
                session.setAttribute("user", user);
                request.getRequestDispatcher("customerMain.jsp").include(request, response);
            }else{
                session.setAttribute("userErr", "You're not currently logged in");
                request.getRequestDispatcher("customerMain.jsp").include(request, response);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccessCustomerMainServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
       
        
    }
}
