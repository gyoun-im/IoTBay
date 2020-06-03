
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
import uts.isd.controller.AccessValidator;
import uts.isd.model.User;

public class StaffRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        int id =0;                  //Default value due to id is auto-generated
        String history = "";        //Default value due to newly registered staff has not done any actions
        int accid=0;                //Default value due to id is auto-generated
        
        HttpSession session = request.getSession();
        AccessValidator validator = new AccessValidator();
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
        
        if(validator.registerCheckEmpty(email, password, name, dob, number, gender, address)){
            session.setAttribute("empErr", "Please fill in every textfield");
            request.getRequestDispatcher("staffRegister.jsp").include(request, response);
        }
        else if(!validator.validateEmail(email)){
            session.setAttribute("emailErr", "Error: Email format is incorrect");
            request.getRequestDispatcher("staffRegister.jsp").include(request, response);
        }else if(!validator.validateName(name)){
            session.setAttribute("nameErr", "Error: Name format is incorrect");
            request.getRequestDispatcher("staffRegister.jsp").include(request, response);
        }else if(!validator.validatePassword(password)){
            session.setAttribute("passErr", "Error: Password format is incorrect");
            request.getRequestDispatcher("staffRegister.jsp").include(request, response);
        }else{
            try{
                Staff exist = manager.findStaff(email);
                if(exist != null){  //Check if staff email already exists in the database
                    session.setAttribute("existErr", "Staff already exists in the database");
                    request.getRequestDispatcher("staffRegister.jsp").include(request, response);
                }else{  //add the staff in the STAFF and USER_ACCOUNT table
                    manager.addStaff(name, email, number, address, type, history, password, dob, gender, Boolean.FALSE, id);
                    Staff staff = new Staff(id, name, email, number, address, type, history, accid);
                    User user = new User(accid, email, password, dob, gender, Boolean.FALSE, id);
                    session.setAttribute("staff", staff);
                    session.setAttribute("user", user);
                    
                    int ids = user.getAccid();                                                       //get userId of the user
                    manager.addLog(ids);   
                    request.getRequestDispatcher("staffMain.jsp").include(request, response);
                }
                
            }catch(SQLException ex){
                Logger.getLogger(StaffRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
                
            }
        }
        
        
    }
    
   
}
