package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector extends DB {

    //Credentials are used to connect to the database
    public DBConnector() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        conn = DriverManager.getConnection(URL+db, dbuser, dbpass);
    }

    //Open a connection to the database
    public Connection openConnection() {
        return this.conn;
    }

    //close the connection to the database
    public void closeConnection() throws SQLException {
        this.conn.close();
    }

}
