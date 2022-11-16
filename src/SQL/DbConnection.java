package SQL;

import java.sql.*;

public class DbConnection {

//    Declaring variable(s)
    private static Connection con;

//    Returns a database connection with the credentials inputted
    public DbConnection() throws SQLException {
        Connection con = null; // a Connection object
        try {
            String[] creds = Utils.getCredentials();
            con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/" + creds[0], creds[0], creds[1]);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        setCon(con);
    }

    //    Closes database connection
    public static void closeConnection() throws SQLException {
        if (con != null)
            con.close();
    }

//    getter(s) and setter(s)
    public static Connection getCon() throws SQLException {
        if (con == null){
            new DbConnection();
        }
        return con;
    }
    private void setCon(Connection con) {
        DbConnection.con = con;
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
