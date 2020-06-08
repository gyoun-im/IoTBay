package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import java.util.logging.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.AccessDBManager;

public class CustomerFilterDateServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String date = request.getParameter("date");
        String userId = request.getParameter("userId");
        AccessDBManager manager = (AccessDBManager) session.getAttribute("accessManager");
        User_Account user = (User_Account) session.getAttribute("user");
        
        try {  
                //Filter by the current session's userId
                int id = user.getUserAccountID();
                System.out.println(id);
                ArrayList<Access_Log> lists = manager.fetchLogDate(date, id);
                request.setAttribute("list", lists);
                request.getRequestDispatcher("customerAccessLog.jsp").forward(request, response);
            
        } catch (SQLException ex) {
            Logger.getLogger(FilterDateServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
