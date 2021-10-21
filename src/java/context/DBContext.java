/*
 * Coppy right(C) 2021, Le Dai Duong 
 * Meal Order: 
 * J3.L.P0061-SimpleApp-MealOrderList 
 * 
 * Record of change: 
 * DATE          Version     AUTHOR      DESCRIPTION 
 * 2021-09-20     1.1        DuongLD     First Implement
 */
package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * This class get info of server and create connection to that server
 *
 * @author Le Dai Duong
 */
public class DBContext {

    private InitialContext initial;         // Initial context variable
    private Context context;                // Context variable
    private String dbName;                  // Name of database
    private String serverName;              // Name of server
    private String portNumber;              // Port number
    private String image;                   // Image path

    /**
     * This constructor get data info of server from context file
     *
     * @throws Exception
     */
    public DBContext() throws Exception {
        try {
            initial = new InitialContext();
            Object obj = initial.lookup("java:comp/env");
            context = (Context) obj;
            serverName = context.lookup("serverName").toString();
            dbName = context.lookup("dbName").toString();
            portNumber = context.lookup("portNumber").toString();
            image = context.lookup("image").toString();
        } catch (NamingException e) {
            throw e;
        }
    }

    /**
     * This method used to get connection to server
     *
     * @return A connection to database. It is a
     * <code>java.sql.Connection</code> object
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection("jdbc:sqlserver://"
                + serverName + ":"
                + portNumber + ";databaseName="
                + dbName + ";integratedSecurity=true;");
        return conn;
    }

    /**
     * This method used to closing connection to server
     *
     * @param con is connection
     * @throws java.sql.SQLException
     */
    protected void closeConnection(Connection con) throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }

    /**
     * This method used to closing result set
     *
     * @param rs is result set
     * @throws java.sql.SQLException
     */
    protected void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
    }

    /**
     * This method used to closing prepared statement
     *
     * @param ps is prepared statement
     * @throws java.sql.SQLException
     */
    protected void closePreparedStatement(PreparedStatement ps) throws SQLException {
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
    }

    /**
     * This method used to get base image path from context file
     *
     * @return image path
     * @throws java.lang.Exception
     */
    protected String getImagePath() throws Exception {
        return image;
    }
}
