/*
 * Coppy right(C) 2021, Le Dai Duong 
 * Meal Order: 
 * J3.L.P0061-SimpleApp-MealOrderList 
 * 
 * Record of change: 
 * DATE          Version     AUTHOR      DESCRIPTION 
 * 2021-09-15     1.0        DuongLD     First Implement
 */
package dao;

import entity.Status;
import java.util.ArrayList;

/**
 * The interface is used for implement <br>
 * Override method of this interface for data processing of <code>Status</code>
 * model
 *
 * @Le Dai Duong
 */
public interface StatusBaseDAO {

    /**
     * Abstract method, implement it for get list status of order
     * <code>Service</code>
     *
     * @return list <code>Status</code>
     * @throws Exception
     */
    ArrayList<Status> getStatus() throws Exception;
}
