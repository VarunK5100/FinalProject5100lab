/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.*;
import java.util.ArrayList;
import model.CustomerManager;

/**
 *
 * @author varunkumar
 */
public class CustomerManagerDBC {
    private static final String URL = "jdbc:mysql://localhost:3307/test_database?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    /**
    * Privatized constructor so as to not allow object creation
    */
    private CustomerManagerDBC() {
    }
    /**
    * Insert given user to database
    * @see User
    * @param CustomerManager User object to be added
    */
   /* public static void addOrder(CustomerManager CustomerManager) {
    //add to database
        String query = "INSERT INTO Patient(NAME,AGE) VALUES(?,?)";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME,PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, CustomerManager.getProdName());
            stmt.setInt(2, CustomerManager.getOrderId());
            int rows = stmt.executeUpdate();
            System.out.println("Rows impacted : " + rows);      
//            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
    /**
    * Return lost of all users in database
    * @see Patient
    * @return list of Patient
    */
    public static ArrayList<CustomerManager> getAllOrders() {
        // return list of users from db
        ArrayList<CustomerManager> orderlist = new ArrayList<>();
        String query = "SELECT * FROM ORDERS";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME,PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CustomerManager order = new CustomerManager();
                order.setOrderId(rs.getInt("ORDERID"));
                order.setProdName(rs.getString("PRODUCTNAME"));
                order.setAddress(rs.getString("ADDRESS"));
                order.setCreatorId(rs.getString("CREATORID"));
                 order.setAgentId(rs.getString("AGENTID"));
                  order.setDate(rs.getString("PLACEDATE"));
                   order.setStatus(rs.getString("STATUS"));
                    order.setNotes(rs.getString("NOTES"));
                     //order.setCreatorId(rs.getString(""));
                  
                orderlist.add(order);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return orderlist;
        }
    public static ArrayList<CustomerManager> getAllRequests() {
        // return list of users from db
        ArrayList<CustomerManager> requestlist = new ArrayList<>();
        String query = "SELECT * FROM requests";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME,PASSWORD)) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CustomerManager request = new CustomerManager();
                request.setOrderId(rs.getInt("orderid"));
                request.setAddress(rs.getString("old_address"));
                request.setNewAddress(rs.getString("new_address"));
                request.setComments(rs.getString("comments"));
               
                     //order.setCreatorId(rs.getString(""));
                  
                requestlist.add(request);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
            }
        return requestlist;
        }
    
        /**
        * Delete given user from database
        * @see User
        * @param p User to be deleted
        *
        * 
        */
        /*public static void deleteEmployee(CustomerManager customerManager) {
            String query = "delete from Patient where id = ?";
                try (Connection conn = DriverManager.getConnection(URL, USERNAME,PASSWORD)) {
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setInt(1, customerManager.getOrderId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
            }
        }*/
        /**
        * Edit given user details in the database
        * @param oldPatient existing user in database
        * @param newPatient modified user details to be added
        */
        public static void updateRequest(CustomerManager oldOrderDetails, CustomerManager newOrderDetails) {
            String query = "UPDATE ORDERS SET STATUS=? WHERE ORDER_ID=?";
                try (Connection conn = DriverManager.getConnection(URL, USERNAME,PASSWORD)) {
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.setString(1, newOrderDetails.getStatus());
                    //stmt.setInt(2, newOrderDetails());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
        }
       }
        
        
         public static void updateAddress(CustomerManager newOrderDetails) {
             String address = newOrderDetails.getAddress();
             int ID = newOrderDetails.getOrderId();
            String query = "UPDATE ORDERS SET ADDRESS= 'hello' WHERE ORDERID="+ID;
                try (Connection conn = DriverManager.getConnection(URL, USERNAME,PASSWORD)) {
                    PreparedStatement stmt = conn.prepareStatement(query);
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
        }
       }
    }
