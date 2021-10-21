/*
 * Coppy right(C) 2021, Le Dai Duong 
 * Meal Order: 
 * J3.L.P0061-SimpleApp-MealOrderList 
 * 
 * Record of change: 
 * DATE          Version     AUTHOR      DESCRIPTION 
 * 2021-09-06     1.0        DuongLD     First Implement
 */
package validator;

/**
 * This class used to validate data
 * 
 * @author LE DAI DUONG
 */
public class Validator {

    /**
     * Remove redundant space of <code>String</code>, return empty
     * <code>String</code> if input is null <br>
     *
     * @param str is <code>String</code> value want format
     * @return a <code>String</code> was formatted.
     */
    public static String formatString(String str) {
        if (str == null) {
            return "";
        }

        return str.trim();
    }
}
