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

import dao.FoodBaseDAO;
import context.DBContext;
import entity.Food;
import entity.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The class used to query data of combo food in SQL server
 *
 * @author Le Dai Duong
 */
public class FoodDAOImpl extends DBContext implements FoodBaseDAO {

    /**
     * Constructor of <code> FoodDAOImpl </code>
     *
     * @throws Exception
     */
    public FoodDAOImpl() throws Exception {
    }

    /**
     * Get data of <code>Order</code> from SQL server and set value total food
     * money and list <code>Food</code> to that <code>Order</code>
     * <br>
     *
     * @param order is <code>Order</code> object
     * @throws Exception
     */
    @Override
    public Order getFoodOrder(Order order) throws Exception {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Food> foods = new ArrayList<>();
        float total = 0;          // Total food money
        try {
            String query = "select * from OrdersFood where IdOrder = ?";
            conn = getConnection();
            st = conn.prepareStatement(query);
            st.setInt(1, order.getId());
            rs = st.executeQuery();
            while (rs.next()) {
                Food food = new Food(
                        rs.getInt("ID"),
                        rs.getNString("Name"),
                        rs.getInt("Price"),
                        rs.getInt("Amount"),
                        rs.getInt("IdOrder")
                );

                total += food.getPrice() * food.getAmount();
                foods.add(food);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(st);
            closeConnection(conn);
        }

        order.setFoods(foods);
        order.setTotalFoodsMoney(total);

        return order;
    }
}
