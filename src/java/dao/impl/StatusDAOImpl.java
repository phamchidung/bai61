/*
 * Coppy right(C) 2021, Le Dai Duong 
 * Meal Order: 
 * J3.L.P0061-SimpleApp-MealOrderList 
 * 
 * Record of change: 
 * DATE          Version     AUTHOR      DESCRIPTION 
 * 2021-09-15     1.0        DuongLD     First Implement
 */
package dao.impl;

import dao.StatusBaseDAO;
import context.DBContext;
import entity.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * The class used to query data of status in SQL server
 *
 * @author Le Dai Duong
 */
public class StatusDAOImpl extends DBContext implements StatusBaseDAO {

    /**
     * Constructor of <code> StatusDAO </code>
     *
     * @throws Exception
     */
    public StatusDAOImpl() throws Exception {
    }

    /**
     * Get list <code>Status</code> of <code>Order</code> from SQL server
     * <code>Service</code>
     *
     * @return list <code>Status</code>
     * @throws Exception
     */
    @Override
    public ArrayList<Status> getStatus() throws Exception {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        ArrayList<Status> statusList = new ArrayList<>();
        try {
            String query = "select * from Status";
            conn = getConnection();
            st = conn.prepareStatement(query);
            rs = st.executeQuery();
            while (rs.next()) {
                Status status = new Status(
                        rs.getString("StatusCode"),
                        rs.getString("StatusContent"));

                statusList.add(status);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(st);
            closeConnection(conn);
        }
        return statusList;
    }

}
