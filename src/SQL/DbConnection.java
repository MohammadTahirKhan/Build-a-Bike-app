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

    public static boolean isConnected(){
        if (con != null)
            return true;
        else
            return false;
    }

//    getter(s) and setter(s)
    protected static Connection getCon() throws SQLException {
        if (con == null){
            new DbConnection();
        }
        return con;
    }
    private void setCon(Connection con) {
        DbConnection.con = con;
    }

//
    private static String sanitiseInput(String unsafeQuery){
//        GO FOR PREPARED STATEMENTSSSS!!!!!!!!!
        String safeQuery = unsafeQuery;
        return safeQuery;
    }


//    public static ResultSet executeQuery(String unsafeQuery) throws SQLException {
//
//        String safeQuery = sanitiseInput(unsafeQuery);
//        Connection connection = getCon();
//
//        return results;
//    }

    public static int executeUpdate(String sql) throws SQLException {
        Statement statement = con.createStatement();
        return statement.executeUpdate(sql);
    }

    public static ResultSet executeQuery(String sql) throws SQLException {
        Statement statement = con.createStatement();
        statement.executeQuery(sql);
        return statement.executeQuery(sql);
    }



}
