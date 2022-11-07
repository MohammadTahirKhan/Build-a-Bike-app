import java.sql.*;
import java.util.Arrays;

public class main {
    public static void main(String[] args) throws SQLException {
        String[] creds = Utils.getCredentials();
        Connection con = Utils.connect(creds[0], creds[1]);
        System.out.println(con.getSchema());
        Utils.closeConnection(con);
    }
}
