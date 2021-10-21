/*
 * Coppy right(C) 2021, Le Dai Duong 
 * Meal Order: 
 * J3.L.P0061-SimpleApp-MealOrderList 
 * 
 * Record of change: 
 * DATE          Version     AUTHOR      DESCRIPTION 
 * 2021-09-06     1.0        DuongLD     First Implement
 */
package dao;

import entity.Order;

/**
 * The interface is used for implement <br>
 * Override method of this interface for data processing of
 * <code>Food</code> model
 *
 * @Le Dai Duong
 */
public interface FoodBaseDAO {

    /**
     * Abstract method, implement it for get list food <code>Food</code>
     * <br>
     *
     * @param order is <code>Order</code> object
     * @return order
     * @throws Exception
     */
    Order getFoodOrder(Order  order) throws Exception;
}
