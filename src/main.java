import java.sql.*;
import java.util.Arrays;

public class main {
    public static void main(String[] args) throws SQLException {

        System.out.println("Connecting to database...");
        Connection con = Utils.connect();
        System.out.println("Connected!");
        System.out.println(con.getSchema());
        Utils.closeConnection(con);
    }
}




