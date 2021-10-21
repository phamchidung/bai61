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
 * Store value of food in SQL server
 * 
 * @author Le Dai Duong
 */
public class Food {

    private int id;                 // Id of food
    private String name;            // Name of food
    private int price;              // Price of food
    private int amount;             // Amount of food
    private int idOrder;            // Id of order

    /**
     * Constructor of <code> Food </code> class
     */
    public Food() {
    }

    /**
     * Constructor of <code> Food </code> class
     *
     * @param id is id of food
     * @param name is name of food
     * @param price is price of food
     * @param amount is amount of food
     * @param idOrder is id of order
     */
    public Food(int id, String name, int price, int amount, int idOrder) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.idOrder = idOrder;
    }

    /**
     * Constructor of <code> Food </code> class
     *
     * @param name is name of food
     * @param price is price of food
     * @param amount is amount of food
     * @param idOrder is id of order
     */
    public Food(String name, int price, int amount, int idOrder) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.idOrder = idOrder;
    }

    /**
     * @return id of food. Type <code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * Set value to id attribute of <code>Food</code> object
     *
     * @param id is id of food
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return name of food. Type <code>String</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Set value to name attribute of <code>Food</code> object
     *
     * @param name is name of food
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return price of food. Type <code>int</code>
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set value to price attribute of <code>Food</code> object
     *
     * @param price is price of food
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return amount of food. Type <code>int</code>
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Set value to amount attribute of <code>Food</code> object
     *
     * @param amount is amount of food
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return id order of food
     */
    public int getIdOrder() {
        return idOrder;
    }

    /**
     * Set value to idOrder attribute of <code>Food</code> object
     *
     * @param idOrder is id order of food
     */
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

}
