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

import dao.ServiceBaseDAO;
import context.DBContext;
import entity.Order;
import entity.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The class used to query data of services in SQL server
 *
 * @author Le Dai Duong
 */
public class ServiceDAOImpl extends DBContext implements ServiceBaseDAO {

    /**
     * Constructor of <code> ServiceDAOImpl </code>
     *
     * @throws Exception
     */
    public ServiceDAOImpl() throws Exception {
    }

    /**
     * Get data of <code>Order</code> from SQL server and set value total
     * service money and list <code>Services</code> to that <code>Order</code>
     * <br>
     *
     * @param order is <code>Order</code> object
     * @throws Exception
     */
    @Override
    public Order getServiceOrder(Order order) throws Exception {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Service> serviceses = new ArrayList<>();
        float total = 0;                  // Total services money
        try {
            String query = "select * from Services where IdOrder = ?";
            conn = getConnection();
            st = conn.prepareStatement(query);
            st.setInt(1, order.getId());
            rs = st.executeQuery();
            while (rs.next()) {
                Service service = new Service(
                        rs.getInt("ID"),
                        rs.getNString("Name"),
                        rs.getInt("Price"),
                        rs.getInt("Amount"),
                        rs.getInt("IdOrder")
                );

                total += service.getPrice() * service.getAmount();
                serviceses.add(service);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(st);
            closeConnection(conn);
        }

        order.setServiceses(serviceses);
        order.setTotalServicesesMoney(total);

        return order;
    }
}
