/*
 * Coppy right(C) 2021, Le Dai Duong 
 * Meal Order: 
 * J3.L.P0061-SimpleApp-MealOrderList 
 * 
 * Record of change: 
 * DATE          Version     AUTHOR      DESCRIPTION 
 * 2021-09-06     1.0        DuongLD     First Implement
 */
package dao.impl;

import dao.OrderBaseDAO;
import config.Constants;
import context.DBContext;
import entity.Order;
import entity.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The class used to query, update data of services in SQL server
 *
 * @author Le Dai Duong
 */
public class OrderDAOImpl extends DBContext implements OrderBaseDAO {

    /**
     * Constructor of <code> OrderDAOImpl </code>
     *
     * @throws Exception
     */
    public OrderDAOImpl() throws Exception {
    }

    /**
     * Count total order searched by code in SQL server<br>
     *
     * @param code is order code
     * @return amount order
     * @throws Exception
     */
    @Override
    public int count(String code) throws Exception {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = "select count(*) from Orders where OrderCode like ?";

        try {
            conn = getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, "%" + code + "%");
            rs = st.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(st);
            closeConnection(conn);
        }
        return 0;
    }

    /**
     * Get list order in particular index page after searched by code<br>
     *
     * @param code is order code
     * @param index is index of page we want query
     * @param numberOrderEachPage is number order each page
     * @return list <code>Order</code>
     * @throws Exception
     */
    @Override
    public ArrayList<Order> search(String code, int index, int numberOrderEachPage) throws Exception {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        // range of orders will get
        int stopIndexOrders = index * numberOrderEachPage;
        int startIndexOrders = stopIndexOrders - (numberOrderEachPage - 1);

        ArrayList<Order> list = new ArrayList<>();
        String sql = "select * from\n"
                + " (select ROW_NUMBER() over (order by id asc) as r, * \n"
                + " from Orders where OrderCode like ?) as x \n"
                + " where r between ? and ?";

        try {
            conn = getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, "%" + code + "%");
            st.setInt(2, startIndexOrders);
            st.setInt(3, stopIndexOrders);

            rs = st.executeQuery();
            while (rs.next()) {
                String statusCode = rs.getString("Status");
                Order order = new Order(rs.getInt("ID"),
                        rs.getString("OrderCode"),
                        rs.getDate("OrderDate"),
                        // set status code and content of status
                        new Status(statusCode, Constants.HM_STATUS.get(statusCode)),
                        rs.getInt("TableType"),
                        rs.getInt("AmountGuess"),
                        rs.getDate("DateTakesPlace"),
                        rs.getString("Note"));
                list.add(order);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(st);
            closeConnection(conn);
        }
        return list;
    }

    /**
     * Update status of particular order by order id<br>
     *
     * @param id is order id
     * @param statusCode is status code of order
     * @throws Exception
     */
    @Override
    public void updateStatus(int id, String statusCode) throws Exception {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        String sql = "update Orders set Status = ? where ID = ?";
        try {
            conn = getConnection();
            st = conn.prepareStatement(sql);
            st.setNString(1, statusCode);
            st.setInt(2, id);

            st.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(st);
            closeConnection(conn);
        }
    }

}
