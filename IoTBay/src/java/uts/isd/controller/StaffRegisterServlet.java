package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import javax.servlet.ServletException;
import java.util.logging.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Staff;
import uts.isd.model.dao.AccessDBManager;
import uts.isd.controller.Validator;

public class StaffRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        int id =0;                  //Default value due to id is auto-generated
        String history = "";        //Default value due to newly registered staff has not done any actions
        int accid=0;                //Default value due to id is auto-generated
        
        HttpSession session = request.getSession();
        Validator validator = new Validator();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String number = request.getParameter("number");
        String address = request.getParameter("address");
        String type = request.getParameter("type");
        AccessDBManager manager = (AccessDBManager) session.getAttribute("manager");
        validator.clear(session);
        
        if(!validator.validateEmail(email)){
            session.setAttribute("emailErr", "Error: Email format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }else if(!validator.validateName(name)){
            session.setAttribute("nameErr", "Error: Name format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }else if(!validator.validateName(type)){
            session.setAttribute("nameErr", "Error: Staff type format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }else if(!validator.validatePassword(password)){
            session.setAttribute("passErr", "Error: Password format is incorrect");
            request.getRequestDispatcher("register.jsp").include(request, response);
        }else{
            try{
                Staff exist = manager.findStaff(email);
                if(exist != null){  //Check if staff email already exists in the database
                    session.setAttribute("existErr", "Staff already exists in the database");
                    request.getRequestDispatcher("staff_register.jsp").include(request, response);
                }else{  //add the staff in the STAFF and USER_ACCOUNT table
                    manager.addStaff(name, email, number, address, type, password, password, dob, gender, Boolean.TRUE, id);
                    Staff staff = new Staff(id, name, email, number, address, type, history, accid);
                    session.setAttribute("customer", staff);
                    
                    //manager.addLog();                                                           //Add a row to the Access_Log table
                    request.getRequestDispatcher("main.jsp").include(request, response);
                }
                
            }catch(SQLException ex){
                Logger.getLogger(StaffRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        
        
    }
    
   
}
