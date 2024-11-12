package lib;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author penpen1112003
 */
public class DBUtils {

    public static Connection makeConnection() throws SQLException {
        Connection cn = null;
        String IP = "localhost"; // Your SQL Server IP address
        String port = "1433"; // Default port for SQL Server
        String uid = "sa"; // Your SQL Server username
        String pwd = "Ductuan2003"; // Your SQL Server password
        String db = "CoffeePuppyStore"; // Your database name
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // JDBC driver

        // Add useUnicode and characterEncoding to the URL
        String url = "jdbc:sqlserver://" + IP + ":" + port + ";databaseName=" + db 
                   + ";useUnicode=true;characterEncoding=UTF-8";

        try {
            // Load SQL Server JDBC driver
            Class.forName(driver);

            // Establish the connection
            cn = DriverManager.getConnection(url, uid, pwd);
            System.out.println("Connection established successfully.");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            throw new SQLException("Could not find the JDBC driver.", e);
        } catch (SQLException e) {
            System.err.println("Connection failed: " + e.getMessage());
            throw e; // Rethrow the exception for further handling
        }

        return cn; // Return the connection object
    }
}
