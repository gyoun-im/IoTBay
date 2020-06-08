package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
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

        HttpSession session = request.getSession();
        AccessValidator validator = new AccessValidator();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(email.equals("staff@gmail.com")){
            session.setAttribute("currentRole", "Staff");
        } else {
            session.setAttribute("currentRole", "Customer");
        }
        response.sendRedirect("IoTDevices");
    }
}
