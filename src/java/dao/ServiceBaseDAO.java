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
 * The interface is used for implement<br>
 * Override method of this interface for data processing of <code>Service</code>
 * model
 *
 * @Le Dai Duong
 */
public interface ServiceBaseDAO {

    /**
     * Abstract method, implement it for query data of services
     * <code>Service</code>
     * <br>
     *
     * @param order is <code>Order</code> object
     * @return order
     * @throws Exception
     */
    Order getServiceOrder(Order order) throws Exception;
}
