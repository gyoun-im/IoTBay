package uts.isd.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.dao.*;

public class ConnServlet extends HttpServlet {

    private DBConnector db;
    private SupplierDBManager supplierManager;
    private ShipmentDBManager shipmentManager;
    private AccessDBManager accessManager;
    private PaymentDBManager paymentDBManager;   
    private Connection conn;

    @Override
    public void init() {

        try {
            db = new DBConnector();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        conn = db.openConnection();

        try {
            supplierManager = new SupplierDBManager(conn);
            shipmentManager = new ShipmentDBManager(conn);
            accessManager = new AccessDBManager(conn);
            paymentDBManager = new PaymentDBManager(conn);
        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        session.setAttribute("supplierManager", supplierManager);
        session.setAttribute("shipmentManager", shipmentManager);
        session.setAttribute("accessManager", accessManager);
        session.setAttribute("manager", paymentDBManager); 

    }

    @Override
    public void destroy() {

        try {
            db.closeConnection();
        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
