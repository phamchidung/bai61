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

import dao.ComboFoodBaseDAO;
import context.DBContext;
import entity.ComboFood;
import entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The class used to query data of combo food in database
 *
 * @author Le Dai Duong
 */
public class ComboFoodDAOImpl extends DBContext implements ComboFoodBaseDAO {

    /**
     * Constructor of <code> ComboFoodDAOImpl </code>
     *
     * @throws Exception
     */
    public ComboFoodDAOImpl() throws Exception {
    }

    /**
     * Get data of <code>Order</code> from SQL server and set value total combo
     * food money and list <code>ComboFood</code> to that <code>Order</code>
     * <br>
     *
     * @param order is <code>Order</code> object
     * @throws Exception
     */
    @Override
    public Order getComboFoodOrder(Order order) throws Exception {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<ComboFood> comboFoods = new ArrayList<>();
        float total = 0;                  // Total combo food money
        try {
            String query = "select * from OrdersComboFood where IdOrder = ?";
            conn = getConnection();
            st = conn.prepareStatement(query);
            st.setInt(1, order.getId());
            rs = st.executeQuery();
            while (rs.next()) {
                ComboFood comboFood = new ComboFood(
                        rs.getInt("ID"),
                        rs.getNString("Name"),
                        rs.getInt("Price"),
                        rs.getInt("Amount"),
                        rs.getInt("IdOrder")
                );

                total += comboFood.getPrice() * comboFood.getAmount();
                comboFoods.add(comboFood);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(st);
            closeConnection(conn);
        }

        order.setComboFoods(comboFoods);
        order.setTotalComboFoodsMoney(total);

        return order;
    }
}
