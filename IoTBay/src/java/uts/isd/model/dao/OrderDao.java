/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import uts.isd.model.Customer;
import uts.isd.model.Device;
import uts.isd.model.Order;

/**
 *
 * @author Qianhui Yin
 */
public class OrderDao {

    private Statement st;

    public OrderDao(Connection conn) throws SQLException {
        st = conn.createStatement();
    }

    public List<Order> findOrderByUserId() throws SQLException {
        String fetch = "select * from \"ORDER\"";
        ResultSet rs = st.executeQuery(fetch);
        return processResultList(rs);
    }
    
    public List<Order> searchOrder(String id, String from, String to) throws SQLException {
        String fetch = "select * from \"ORDER\" where id>0";
        if(id != null && !id.equals("")) {
            fetch = fetch + " and id="+id;
        }
        if(from != null && !from.equals("")) {
            fetch = fetch + " and \"DATE\">=TIMESTAMP('"+from+" 00:00:00')";
        }
        if(to != null && !to.equals("")) {
            fetch = fetch + " and \"DATE\"<=TIMESTAMP('"+to+" 00:00:00')";
        }
        ResultSet rs = st.executeQuery(fetch);
        return processResultList(rs);
    }
    
    public Order findOrderById(String id) throws SQLException {
        String fetch = "select * from \"ORDER\" where id=" + id;
        ResultSet rs = st.executeQuery(fetch);
        return processResultList(rs).get(0);
    }


    private List<Order> processResultList(ResultSet rs) throws SQLException{
        List<Order> orderList = new ArrayList();
        while (rs.next()) //goes through every row in the CUSTOMER table
        {
            orderList.add(new Order(rs.getInt(1), rs.getString(3), rs.getDouble(2), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getInt(7)));
        }
        return orderList;
    }
}
