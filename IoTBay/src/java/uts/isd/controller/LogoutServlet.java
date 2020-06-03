package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.model.dao.AccessDBManager;

public class LogoutServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
       
        AccessDBManager manager = (AccessDBManager) session.getAttribute("manager"); 
        try {
            User user = (User) session.getAttribute("user");
            int id = user.getAccid();
            manager.addLog(id,"LOGOUT");
        } catch (SQLException ex) {
            Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        session.invalidate();   //delete the session
        
        
        request.getRequestDispatcher("index.jsp").include(request, response);   //direct user back to the index page
    }
    
}
