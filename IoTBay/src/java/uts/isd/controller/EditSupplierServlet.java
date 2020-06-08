package uts.isd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.Supplier;
import uts.isd.model.dao.SupplierDBManager;

public class EditSupplierServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        SupplierValidator validator = new SupplierValidator();

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String type = request.getParameter("type");
        String number = request.getParameter("number");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String status = request.getParameter("status");
        
        SupplierDBManager manager = (SupplierDBManager) session.getAttribute("supplierManager");
        validator.clear(session);

        if (validator.checkEmpty(name, type, number, email, address)) {
            session.setAttribute("supplierEmptyErr", "Please fill in every textfield");
            request.getRequestDispatcher("addSuppliers.jsp").include(request, response);
        } else if (!validator.validateEmail(email)) {
            session.setAttribute("supplierEmailErr", "Invalid email");
            request.getRequestDispatcher("addSuppliers.jsp").include(request, response);
        } else if (!validator.validateNumber(number)) {
            session.setAttribute("supplierNumberErr", "Invalid number");
            request.getRequestDispatcher("addSuppliers.jsp").include(request, response);
        } else {
            try {
                if (status.equals("Active")) {
                    manager.updateSupplier(Integer.parseInt(id), name, type, Integer.parseInt(number), email, address, true);
                    request.getRequestDispatcher("suppliers.jsp").include(request, response);
                } else {
                    manager.updateSupplier(Integer.parseInt(id), name, type, Integer.parseInt(number), email, address, false);
                    request.getRequestDispatcher("suppliers.jsp").include(request, response);
                }
            } catch (SQLException ex) {
                Logger.getLogger(EditSupplierServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
