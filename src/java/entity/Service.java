/*
 * Coppy right(C) 2021, Le Dai Duong 
 * Meal Order: 
 * J3.L.P0061-SimpleApp-MealOrderList 
 * 
 * Record of change: 
 * DATE          Version     AUTHOR      DESCRIPTION 
 * 2021-09-06     1.0        DuongLD     First Implement
 */
package entity;

/**
 * Store value of service in SQL server
 *
 * @author Le Dai Duong
 */
public class Service {

    private int id;                 // Id of service
    private String name;            // Name of service
    private int price;              // Price of service
    private int amount;             // Amount of service
    private int idOrder;            // Id of order

    /**
     * Constructor of <code> Service </code> class
     */
    public Service() {
    }

    /**
     * Constructor of <code> Service </code> class
     *
     * @param id is id of service
     * @param name is name of combo service
     * @param price is price of combo service
     * @param amount is amount of combo service
     * @param idOrder is id of service
     */
    public Service(int id, String name, int price, int amount, int idOrder) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.idOrder = idOrder;
    }

    /**
     * Constructor of <code> Service </code> class
     *
     * @param name is name of service
     * @param price is price of service
     * @param amount is amount of service
     * @param idOrder is id of service
     */
    public Service(String name, int price, int amount, int idOrder) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.idOrder = idOrder;
    }

    /**
     * Get the id of <code>Service</code> object
     *
     * @return id of service. Type <code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * Set value to id attribute of <code>Service</code> object
     *
     * @param id is id of service
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name of <code>Service</code> object
     *
     * @return name of service. Type <code>String</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Set value to name attribute of <code>Service</code> object
     *
     * @param name is name of service
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the price of <code>Service</code> object
     *
     * @return price of service. Type <code>int</code>
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set value to price attribute of <code>Service</code> object
     *
     * @param price is price of service
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Get the amount of <code>Service</code> object
     *
     * @return amount of service. Type <code>int</code>
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Set value to amount attribute of <code>Service</code> object
     *
     * @param amount is amount of service
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * Get the idOrder of <code>Service</code> object
     *
     * @return id order of service
     */
    public int getIdOrder() {
        return idOrder;
    }

    /**
     * Set value to idOrder attribute of <code>Service</code> object
     *
     * @param idOrder is id order of service
     */
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

}
