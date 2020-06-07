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

    private DBConnector db;                             //Create database connection
    private AccessDBManager accessManager;              //Share database manager
    private Connection conn;                            //close database connection

    @Override
    //Create and instance of DBConnector for the deployment session
    public void init() {
        try {
            db = new DBConnector();                                                  //creates an instance of DBConnector (from model.DAO)
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    //Add the DBConnector, AccessDBManager, Connection instances to the session
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {                              //Captures the current session from request and                          
        response.setContentType("text/html;charset=UTF-8");                     //opens the connection with usersdb
        HttpSession session = request.getSession();
        conn = db.openConnection();     //Create a DB connection
        try {
            accessManager = new AccessDBManager(conn);  //Creates an instance of AccessDBManager (from model.dao) and adds it to current session
        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        //export the DB manager to the view-session (JSPs)
        session.setAttribute("accessManager", accessManager);     //Add manager to the session
    }

    @Override //Destroy the servlet and release the resources of the application (terminate also the db connection)

    public void destroy() {
        try {
            db.closeConnection();   //closes the DB connection once the session is terminated
        } catch (SQLException ex) {
            Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
