import java.sql.*;
import java.util.*;

public class Utils {

    public static void main(String[] args) throws Exception {
        System.out.println("\nDrivers loaded as properties:");
        System.out.println(System.getProperty("jdbc.drivers"));
        System.out.println("\nDrivers loaded by DriverManager:");
        Enumeration<Driver> list = DriverManager.getDrivers();
        while (list.hasMoreElements())
            System.out.println(list.nextElement());
    }

    public Connection connect() throws SQLException {
        Connection con = null; // a Connection object
        try {
            con = DriverManager.getConnection("jdbc:mysql://server/dbname", "userID", "password");
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

//        Returns the connection
        return con;
    }

    public void closeConnection(Connection con) throws SQLException {
        if (con != null)
            con.close();
    }
}