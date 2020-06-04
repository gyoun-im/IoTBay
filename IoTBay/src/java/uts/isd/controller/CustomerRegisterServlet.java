package uts.isd.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import java.util.logging.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.*;
import uts.isd.model.dao.AccessDBManager;
import uts.isd.controller.AccessValidator;

public class CustomerRegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = 0;                                              //default value because id is auto-generated
        int accid = 0;                                          //default value because userid is auto-generated

        //get session
        HttpSession session = request.getSession();
        AccessValidator validator = new AccessValidator();

        //all the textfields in the customer_register.jsp
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String dob = request.getParameter("dob");
        String number = request.getParameter("number");
        String address = request.getParameter("address");
        String news = request.getParameter(String.valueOf("news"));
        AccessDBManager manager = (AccessDBManager) session.getAttribute("manager");
        validator.clear(session);

        //Input validations
        if (validator.registerCheckEmpty(email, password, name, dob, number, gender, address)) {
            session.setAttribute("empErr", "Please fill in every textfield");
            request.getRequestDispatcher("customerRegister.jsp").include(request, response);
        } else if (!validator.validateEmail(email)) {
            session.setAttribute("emailErr", "Error: Email format is incorrect");
            request.getRequestDispatcher("customerRegister.jsp").include(request, response);
        } else if (!validator.validateName(name)) {
            session.setAttribute("nameErr", "Error: Name format is incorrect");
            request.getRequestDispatcher("customerRegister.jsp").include(request, response);
        } else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format is incorrect");
            request.getRequestDispatcher("customerRegister.jsp").include(request, response);
        } else if (!validator.validateNumber(number)) {
            session.setAttribute("numErr", "Error: Number format is incorrect");
            request.getRequestDispatcher("customerRegister.jsp").include(request, response);
        } else {
            try {
                User exist = manager.findUserEmail(email);
                if (exist != null) {                                                          //if the customer is already registered
                    session.setAttribute("existErr", "User email already exists in the database");
                    request.getRequestDispatcher("customerRegister.jsp").include(request, response);
                } else {
                    //if customer does not exist in the CUSTOMER and USER_ACCOUNT table, add it to CUSTOMER and USER_ACCOUNT table
                    manager.addCustomer(name, number, email, address, Boolean.FALSE, password, dob, gender, Boolean.TRUE, 0);
                    Customer customer = new Customer(id, name, number, email, address, Boolean.valueOf(news));
                    User user = new User(accid, email, password, dob, gender, Boolean.valueOf(news), id);
                    session.setAttribute("customer", customer);
                    session.setAttribute("user", user);
                    //get userId of the user
                    int ids = user.getAccid();
                    //Add a LOGIN log to the ACCESS_LOG Table
                    manager.addLog(ids, "LOGIN");
                    request.getRequestDispatcher("customerMain.jsp").include(request, response);
                }

            } catch (SQLException ex) {
                Logger.getLogger(CustomerRegisterServlet.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
}
