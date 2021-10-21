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
 * Store value of combo food in SQL server
 * 
 * @author Le Dai Duong
 */
public class ComboFood {

    private int id;                 // Id of combo food
    private String name;            // Name of combo food
    private int price;              // Price of combo food
    private int amount;             // Amount of combo food
    private int idOrder;            // Id of order 1111111111111111111111

    /**
     * Constructor of <code> ComboFood </code> class
     */
    public ComboFood() {
    }

    /**
     * Constructor of <code> ComboFood </code> class
     *
     * @param id is id of combo food
     * @param name is name of combo food
     * @param price is price of combo food
     * @param amount is amount of combo food
     * @param idOrder is id of order
     */
    public ComboFood(int id, String name, int price, int amount, int idOrder) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.idOrder = idOrder;
    }

    /**
     * Constructor of <code> ComboFood </code> class
     *
     * @param name is name of combo food
     * @param price is price of combo food
     * @param amount is amount of combo food
     * @param idOrder is id of order
     */
    public ComboFood(String name, int price, int amount, int idOrder) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.idOrder = idOrder;
    }

    /**
     * @return id of combo food. Type <code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * Set value to id attribute of <code>ComboFood</code> object
     *
     * @param id is id of combo food
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return name of combo food. Type <code>String</code>
     */
    public String getName() {
        return name;
    }

    /**
     * Set value to name attribute of <code>ComboFood</code> object
     *
     * @param name is name of combo food
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return price of combo food. Type <code>int</code>
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set value to price attribute of <code>ComboFood</code> object
     *
     * @param price is price of combo food
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @return amount of combo food. Type <code>int</code>
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Set value to amount attribute of <code>ComboFood</code> object
     *
     * @param amount is amount of combo food
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }

    /**
     * @return id order of combo food
     */
    public int getIdOrder() {
        return idOrder;
    }

    /**
     * Set value to idOrder attribute of <code>ComboFood</code> object
     *
     * @param idOrder is id order of combo food
     */
    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

}
