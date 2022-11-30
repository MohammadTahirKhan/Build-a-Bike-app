package SQL;

import java.sql.*;

public class DbConnection {

//    Declaring Connection
    private static Connection con;

    /**
     * Constructor for DBConnection
     * generates a connection when initiating class
     * @throws SQLException Exception if getting conenction
     */
    public DbConnection() throws SQLException {
        Connection con = null; // a Connection object
        try {
            getCon();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Used to close the connection
     * @throws SQLException Exception if cannot close conncetion
     */
    public static void closeConnection() throws SQLException {
        if (con != null)
            con.close();
    }

    /**
     * Gets the connection, if there is none, it makes one
     * @return Connection object
     */
    public static Connection getCon(){
        try{
            if (con == null){
                String[] creds = Utils.getCredentials();
                DbConnection.con = DriverManager.getConnection("jdbc:mysql://stusql.dcs.shef.ac.uk/" + creds[0], creds[0], creds[1]);
            }
            return con;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Used to get the primary key of a table where you have a statement
     * @param statement Insert statement where you want the primary key
     * @return primary key
     * @throws SQLException If it is unable to get the primary key
     */
    public static int getPrimaryKey(Statement statement) throws SQLException {
        int pKey = 0;
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            pKey = rs.getInt(1);
        }
        return pKey;
    }

    /**
     * Rolls back the transaction if there is an issue with the Insert or update statement
     * @param con Current connection
     */
    public static void rollback(Connection con){
        try {
            System.err.print("Transaction is being rolled back\n");
            con.rollback();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    /**
     * USed to execute update in database
     * @param statement statement where update is taking place
     * @return  The prepared statement of the update
     */
    public static PreparedStatement executeUpdate(PreparedStatement statement){
        try{
            statement.executeUpdate();
            return statement;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Used to set the boolean value of autocommit in the connection
     * @param con Current connection
     * @param isAutoCommit boolean value of autoCommit
     */
    public static void setAutoCommit(Connection con, boolean isAutoCommit){
        try{
            con.setAutoCommit(isAutoCommit);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
