package uts.isd.controller;


import java.io.*;
import java.sql.SQLException;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.http.*;
import uts.isd.model.*;
import uts.isd.model.dao.AccessDBManager;

public class CustomerEditServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        AccessDBManager manager = (AccessDBManager) session.getAttribute("manager");
        
        
        
        try{
            User_Account user = manager.findUser(email, password);
            if(user != null){
                session.setAttribute("user", user);
                request.getRequestDispatcher("customerDetails.jsp").include(request, response);
            }else{
                session.setAttribute("existErr", "User does not exist in the Database");
                request.getRequestDispatcher("customerDetails.jsp").include(request, response);
            }
        }catch (SQLException ex){
            Logger.getLogger(CustomerEditServlet.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getErrorCode() + " and " + ex.getMessage());
        }
        request.getRequestDispatcher("customerDetails.jsp").include(request, response);
        
        
    }
    
    
}
