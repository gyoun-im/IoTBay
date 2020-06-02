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
public class StaffAccessLogServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        AccessValidator validator = new AccessValidator();
       
        String id = request.getParameter("id");
        Access_Log log;
        AccessDBManager manager = (AccessDBManager) session.getAttribute("manager");
        
        
        try {
            if(manager.checkLog(Integer.valueOf(id))){                  //check if the userId exists in the Access_Log 
             session.setAttribute("logErr", "Error: no Logs found");    //If not, show an error
            request.getRequestDispatcher("staff_access.jsp").include(request, response); 
            }else{
                log = manager.findLog(Integer.valueOf(id));             //if userId exist, show it to the user
            }       
        } catch (SQLException ex) {
            Logger.getLogger(StaffAccessLogServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
    }
}
