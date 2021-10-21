/*
 * Coppy right(C) 2021, Le Dai Duong 
 * Meal Order: 
 * J3.L.P0061-SimpleApp-MealOrderList 
 * 
 * Record of change: 
 * DATE          Version     AUTHOR      DESCRIPTION 
 * 2021-09-13    1.0        DuongLD     First Implement
 */
package entity;

/**
 *
 * The class store status of <code>Order</code> object
 *
 * @author Le Dai Duong
 */
public class Status {

    private String statusCode;              // Status code of order
    private String statusContent;           // Status content of order

    /**
     * Constructor of <code> Status </code> class
     */
    public Status() {
    }

    /**
     * Constructor of <code> Status </code> class
     *
     * @param statusCode is status code of order
     * @param statusContent is status content of order
     */
    public Status(String statusCode, String statusContent) {
        this.statusCode = statusCode;
        this.statusContent = statusContent;
    }

    /**
     * Get the statusCode of <code>Service</code> object
     *
     * @return status code of order. Type <code>String</code>
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Set value to statusCode attribute of <code>Status</code> object
     *
     * @param statusCode is status code of order
     */
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Get the statusCode of <code>Status</code> object
     *
     * @return status content of order. Type <code>String</code>
     */
    public String getStatusContent() {
        return statusContent;
    }

    /**
     * Set value to statusContent attribute of <code>Status</code> object
     *
     * @param statusContent is status content of order
     */
    public void setStatusContent(String statusContent) {
        this.statusContent = statusContent;
    }

}
