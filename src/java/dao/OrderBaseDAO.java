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
import java.util.ArrayList;

/**
 * The interface is used for implement <br>
 * Override method of this interface for data processing of <code>Order</code>
 * model
 *
 * @Le Dai Duong
 */
public interface OrderBaseDAO {

    /**
     * Abstract method, implement it for count total order searched by code<br>
     *
     * @param code is order code
     * @return amount order
     * @throws Exception
     */
    public int count(String code) throws Exception;

    /**
     * abstract method, implement it for get list order in particular index page
     * after searched by code<br>
     *
     * @param code is order code
     * @param index is index of page we want query
     * @param numberOrderEachPage is number order each page
     * @return list <code>Order</code>
     * @throws Exception
     */
    public ArrayList<Order> search(String code, int index, int numberOrderEachPage) throws Exception;

    /**
     * abstract method, implement it for update status of particular order by
     * order id<br>
     *
     * @param id is order id
     * @param status is new status of order
     * @throws Exception
     */
    public void updateStatus(int id, String status) throws Exception;
}
