package SQL;

import java.sql.*;

public class DbConnection {

//    Declaring variable(s)
    private static Connection con;

//    Returns a database connection with the credentials inputted
    public DbConnection() throws SQLException {
        Connection con = null; // a Connection object
        try {
            getCon();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //    Closes database connection
    public static void closeConnection() throws SQLException {
        if (con != null)
            con.close();
    }

//    getter(s) and setter(s)
    public static Connection getCon() throws SQLException {
        if (con == null){
            String[] creds = Utils.getCredentials();
            DbConnection.con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/" + creds[0], creds[0], creds[1]);
        }
        return con;
    }

    public static int getPrimaryKey(Statement statement) throws SQLException {
        int pKey = 0;
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            pKey = rs.getInt(1);
        }
        return pKey;
    }

//    Do transaction at the end
//    public static ResultSet executeQuery(PreparedStatement query) throws SQLException {
//
//        Connection connection = getCon();
//
//        return results;
//    }
}
