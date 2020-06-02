/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author Gabriel
 */
public class FilterDateServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException{
        HttpSession session = request.getSession();
        
        
        String date = request.getParameter("date");

        AccessDBManager manager = (AccessDBManager) session.getAttribute("manager");
        
        try{                                                                                 
            User_Account user = (User_Account) session.getAttribute("user");
            
            int id = user.getAccid();
           
            ArrayList<Access_Log> lists = manager.fetchLogDate(date, id);
            request.setAttribute("list", lists);
           request.getRequestDispatcher("customerAccessLog.jsp").forward(request, response);
        }catch(SQLException ex){
            Logger.getLogger(FilterDateServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            response.sendRedirect("customerAccessLog.jsp");
        }
    }

