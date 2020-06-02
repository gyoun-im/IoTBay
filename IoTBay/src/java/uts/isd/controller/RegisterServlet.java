package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.AccessDBManager;



public class RegisterServlet extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       
       HttpSession session = request.getSession();
        AccessValidator validator = new AccessValidator();
        
        String name = request.getParameter("name");
        String dob = request.getParameter("dob");
        String email = request.getParameter("email");
        String number = request.getParameter("number");
        String address = request.getParameter("address");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");
        String news = request.getParameter(String.valueOf("news"));
        AccessDBManager manager = (AccessDBManager) session.getAttribute("manager");
        validator.clear(session);
        
        
        
   }
}
