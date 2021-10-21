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

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * The class store order in SQL server
 *
 * @author Le Dai Duong
 */
public class Order {

    private int id;                                // Id of order
    private String orderCode;                      // Code of order
    private Date orderDate;                        // Order date
    private Status status;                         // Status of order
    private int tableType;                         // Table type of order
    private int amountGuess;                       // Amount guess
    private Date dateTakesPlace;                   // Date take place
    private String note;                           // Note
    private ArrayList<ComboFood> comboFoods = new ArrayList<>();        // List combo food in order
    private ArrayList<Food> foods = new ArrayList<>();                  // List food in order
    private ArrayList<Service> serviceses = new ArrayList<>();          // List service in order
    private float totalComboFoodsMoney;            // Total combo food money
    private float totalFoodsMoney;                 // Total food money
    private float totalServicesesMoney;            // Total service money
    private float totalMoney;                      // Total money of order
    private float deposit;                         // Deposit of order

    /**
     * Constructor of <code> Order </code> class
     */
    public Order() {
    }

    /**
     * Constructor of <code> Order </code> class
     *
     * @param id is id of order
     * @param orderCode is order Code of order
     * @param orderDate is order date of order
     * @param status is status of order
     * @param tableType is table type of order
     * @param amountGuess is amount guess order
     * @param dateTakesPlace is date take place type of order
     * @param note is note guess of order
     */
    public Order(int id, String orderCode, Date orderDate, Status status, int tableType, int amountGuess, Date dateTakesPlace, String note) {
        this.id = id;
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.status = status;
        this.tableType = tableType;
        this.amountGuess = amountGuess;
        this.dateTakesPlace = dateTakesPlace;
        this.note = note;
    }

    /**
     * Constructor of <code> Order </code> class
     *
     * @param orderCode is order Code of order
     * @param orderDate is order date of order
     * @param status is status of order
     * @param tableType is table type of order
     * @param amountGuess is amount guess order
     * @param dateTakesPlace is date take place type of order
     * @param note is note guess of order
     */
    public Order(String orderCode, Date orderDate, Status status, int tableType, int amountGuess, Date dateTakesPlace, String note) {
        this.orderCode = orderCode;
        this.orderDate = orderDate;
        this.status = status;
        this.tableType = tableType;
        this.amountGuess = amountGuess;
        this.dateTakesPlace = dateTakesPlace;
        this.note = note;
    }

    /**
     * Get the id of <code>Order</code> object
     *
     * @return id of order. Type <code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * Set value to id attribute of <code>Order</code> object
     *
     * @param id is id of order
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the orderCode of <code>Order</code> object
     *
     * @return orderCode of order. Type <code>String</code>
     */
    public String getOrderCode() {
        return orderCode;
    }

    /**
     * Set value to orderCode attribute of <code>Order</code> object
     *
     * @param orderCode is order code of order
     */
    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    /**
     * Get the orderDate of <code>Order</code> object
     *
     * @return orderDate of order. Type <code>Date</code>
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Set value to orderDate attribute of <code>Order</code> object
     *
     * @param orderDate is order date of order
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * Get the status of <code>Order</code> object
     *
     * @return status of order. Type <code>String</code>
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Set value to setStatus attribute of <code>Order</code> object
     *
     * @param status is status of order
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Get the tableType of <code>Order</code> object
     *
     * @return tableType of order. Type <code>int</code>
     */
    public int getTableType() {
        return tableType;
    }

    /**
     * Set value to tableType attribute of <code>Order</code> object
     *
     * @param tableType is table type of order
     */
    public void setTableType(int tableType) {
        this.tableType = tableType;
    }

    /**
     * Get the amountGuess of <code>Order</code> object
     *
     * @return amountGuess of order. Type <code>int</code>
     */
    public int getAmountGuess() {
        return amountGuess;
    }

    /**
     * Set value to amountGuess attribute of <code>Order</code> object
     *
     * @param amountGuess is amount guess of order
     */
    public void setAmountGuess(int amountGuess) {
        this.amountGuess = amountGuess;
    }

    /**
     * Get the dateTakesPlace of <code>Order</code> object
     *
     * @return dateTakesPlace of order. Type <code>Date</code>
     */
    public Date getDateTakesPlace() {
        return dateTakesPlace;
    }

    /**
     * Set value to dateTakesPlace attribute of <code>Order</code> object
     *
     * @param dateTakesPlace is date takes place of order
     */
    public void setDateTakesPlace(Date dateTakesPlace) {
        this.dateTakesPlace = dateTakesPlace;
    }

    /**
     * @return note of order. Type <code>String</code>
     */
    public String getNote() {
        return note;
    }

    /**
     * Set value to note attribute of <code>Order</code> object
     *
     * @param note is note of order
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * Get the list <code>Service</code> of <code>Order</code> object
     *
     * @return list of <code>Service</code> objects. It's a
     * <code>java.util.List</code> object
     */
    public ArrayList<Service> getServiceses() {
        return serviceses;
    }

    /**
     * Set value to services attribute of <code>Order</code> object
     *
     * @param serviceses is list of <code>Service</code> objects. It's a
     * <code>java.util.List</code> object
     */
    public void setServiceses(ArrayList<Service> serviceses) {
        this.serviceses = serviceses;
    }

    /**
     * Get the list <code>ComboFood</code> of <code>Order</code> object
     *
     * @return list of <code>ComboFood</code> objects. It's a
     * <code>java.util.List</code> object
     */
    public ArrayList<ComboFood> getComboFoods() {
        return comboFoods;
    }

    /**
     * Set value to comboFoods attribute of <code>Order</code> object
     *
     * @param comboFoods is list of <code>ComboFood</code> objects. It's a
     * <code>java.util.List</code> object
     */
    public void setComboFoods(ArrayList<ComboFood> comboFoods) {
        this.comboFoods = comboFoods;
    }

    /**
     * Get the list <code>Food</code> of <code>Order</code> object
     *
     * @return list of <code>Food</code> objects. It's a
     * <code>java.util.List</code> object
     */
    public ArrayList<Food> getFoods() {
        return foods;
    }

    /**
     * Set value to foods attribute of <code>Order</code> object
     *
     * @param foods is list of <code>Food</code> objects. It's a
     * <code>java.util.List</code> object
     */
    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    /**
     * Get the totalMoney of <code>Order</code> object
     *
     * @return totalMoney of order that was formatted. Type <code>String</code>
     */
    public float getTotalMoney() {
        return totalMoney;
    }

    /**
     * Get the total money formatted of <code>Order</code> object
     *
     * @return total money formatted. Type <code>String</code>
     */
    public String getTotalMoneyFormatted() {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        return decimalFormat.format(totalMoney);
    }

    /**
     * Get the deposit of <code>Order</code> object
     *
     * @return deposit of order that was formatted. Type <code>String</code>
     */
    public float getDeposit() {
        return deposit;
    }

    /**
     * Get the deposit formatted of <code>Order</code> object
     *
     * @return deposit formatted. Type <code>String</code>
     */
    public String getDepositFormatted() {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        return decimalFormat.format(deposit);
    }

    /**
     * Get the combo food formatted of <code>Order</code> object
     *
     * @return total combo food formatted. Type <code>String</code>
     */
    public String getTotalComboFoodsMoneyFormatted() {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        return decimalFormat.format(totalComboFoodsMoney);
    }

    /**
     * Get the total service food formatted of <code>Order</code> object
     *
     * @return total service food formatted. Type <code>String</code>
     */
    public String getTotalServiceMoneyFormatted() {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        return decimalFormat.format(totalServicesesMoney);
    }

    /**
     * Get the total money food formatted of <code>Order</code> object
     *
     * @return total money food formatted. Type <code>String</code>
     */
    public String getTotalFoodsMoneyFormatted() {
        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setGroupingUsed(true);
        decimalFormat.setGroupingSize(3);
        return decimalFormat.format(totalFoodsMoney);
    }

    /**
     * Set value to totalMoney attribute of <code>Order</code> object
     *
     * @param totalMoney is total money of order
     */
    public void setTotalMoney(float totalMoney) {
        this.totalMoney = totalMoney;
    }

    /**
     * Set value to deposit attribute of <code>Order</code> object
     *
     * @param deposit is deposit of order
     */
    public void setDeposit(float deposit) {
        this.deposit = deposit;
    }

    /**
     * Get the total money food formatted of <code>Order</code> object
     *
     * @return totalComboFoodsMoney of order. Type <code>float</code>
     */
    public float getTotalComboFoodsMoney() {
        return totalComboFoodsMoney;
    }

    /**
     * Set value to totalComboFoodsMoney attribute of <code>Order</code> object
     *
     * @param totalComboFoodsMoney is total combo food Money of order
     */
    public void setTotalComboFoodsMoney(float totalComboFoodsMoney) {
        this.totalComboFoodsMoney = totalComboFoodsMoney;
    }

    /**
     * Get the totalFoodsMoney of <code>Order</code> object
     *
     * @return totalFoodsMoney of order. Type <code>float</code>
     */
    public float getTotalFoodsMoney() {
        return totalFoodsMoney;
    }

    /**
     * Set value to totalFoodMoney attribute of <code>Order</code> object
     *
     * @param totalFoodsMoney is total food Money of order
     */
    public void setTotalFoodsMoney(float totalFoodsMoney) {
        this.totalFoodsMoney = totalFoodsMoney;
    }

    /**
     * Get the totalServicesesMoney of <code>Order</code> object
     *
     * @return totalServicesesMoney of order. Type <code>float</code>
     */
    public float getTotalServicesesMoney() {
        return totalServicesesMoney;
    }

    /**
     * Set value to totalServicesesMoney attribute of <code>Order</code> object
     *
     * @param totalServicesesMoney is total service money of order
     */
    public void setTotalServicesesMoney(float totalServicesesMoney) {
        this.totalServicesesMoney = totalServicesesMoney;
    }

}
