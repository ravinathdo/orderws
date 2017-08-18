/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.order.ws;

import com.order.bean.Customer;
import com.order.bean.Order;
import com.order.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author 001343
 */
@WebService(serviceName = "OrderWebService")
public class OrderWebService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCustomerList")
    public List<Customer> getCustomerList() {
        //TODO write your implementation code here:
        List<Customer> custList = new ArrayList<Customer>();
        Connection con = null;
        try {
            con = new DBConnection().getConnection();
            String query = "SELECT * FROM customer";
            //SELECT * FROM customer
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("ps:" + ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setContact(rs.getString("contact"));
                c.setCust_address(rs.getString("cust_address"));
                c.setCust_name(rs.getString("cust_name"));
                c.setCust_no(rs.getString("cust_no"));
                c.setTrn(rs.getString("trn"));
                custList.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderWebService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return custList;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getOrderList")
    public  List<Order> getOrderList() {
        //TODO write your implementation code here:
        List<Order> oList = new ArrayList<Order>();
        Connection con = null;
        try {
            con = new DBConnection().getConnection();
            String query = "SELECT * FROM orders";
            //SELECT * FROM customer
            PreparedStatement ps = con.prepareStatement(query);
            System.out.println("ps:" + ps);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Order o = new Order();
                o.setCustomer_no(rs.getString("customer_no"));
                o.setOrder_date(rs.getString("order_date"));
                o.setOrder_no(rs.getInt("order_no"));
                o.setTotal_cost(rs.getString("total_cost"));
                oList.add(o);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(OrderWebService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        return oList;
    }
}
