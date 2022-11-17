package SQL;

import Actors.Customer;
import Product.Wheels;

import java.sql.*;

public class Queries {


//    public Wheels[] getWheels(int diameter, Wheels.Style style, Wheels.BrakeType brakeType){
//
//
//        query=...
//        results = DbConnection.executeQuery(query);
//
//
////        return ;
//    }


    /**
     * Inserts values into a specific table in the database
     *
     * @param table             the table which you are inserting into
     * @param columnsWithCommas the columns you wish to insert into
     * @param valuesWithCommas  the data values separated by commas
     */
    public static void insert(String table, String columnsWithCommas, String valuesWithCommas) throws SQLException {
        if (DbConnection.isConnected()) {
            try {
                Statement statement = DbConnection.getCon().createStatement();
                String query = "INSERT INTO " + table + "(" + columnsWithCommas + ")"
                        + " VALUES (" + valuesWithCommas + ");";
                System.out.println(query);
                statement.executeUpdate(query);
            } catch (SQLIntegrityConstraintViolationException ex) {
                System.out.println("Unique column clash");
            } catch (SQLException ex) {
                System.out.println("failed to insert");
                ex.printStackTrace();
            }
        }
        DbConnection.closeConnection();
    }

    /**
     * Updates a specific column value in a given table filtering by primary key
     * value
     *
     * @param table       the table you are updating
     * @param primaryKey  the primary key column name
     * @param keyValue    the primary key value
     * @param columnName  the column name
     * @param columnValue the column value
     */
    public static void update(String table, String primaryKey, int keyValue, String columnName, String columnValue) throws SQLException {
        if (DbConnection.isConnected()) {
            try {
                Statement statement = DbConnection.getCon().createStatement();
                String query = "UPDATE " + table + " SET " + columnName + "= \"" + columnValue + "\" WHERE "
                        + primaryKey + " = " + keyValue + ";";
                statement.executeUpdate(query);
            } catch (SQLException ex) {
                System.out.println("failed to update");
                ex.printStackTrace();
            }
        }
        DbConnection.closeConnection();
    }

    public static void delete(String table, String columnName, String columnValue) throws SQLException {
        if (DbConnection.isConnected()) {
            try {
                Statement statement = DbConnection.getCon().createStatement();
                String query = "DELETE " + "*" + " FROM " + table;
                if (columnName!="" && columnValue !="")
                     query+= " WHERE " + columnName + "= " + columnValue + ";" ;
                statement.executeQuery(query);
            } catch (SQLException ex) {
                System.out.println("failed to update");
                ex.printStackTrace();
            }
        }
        DbConnection.closeConnection();
    }

    /**
     * Return all the rows of a table with indicated columns, including a where
     * filter
     *
     * @param table             the table you want to read from
     * @param columnsWithCommas the columns you want to include in the result set
     * @param where             for filtering the rows based on column values
     * @return
     */
    public static ResultSet readRows(String table, String columnsWithCommas, String where) throws SQLException {
        ResultSet result = null;
        if ((DbConnection.isConnected()) && (DbConnection.getCon() != null)) {
            try {
                Statement statement = DbConnection.getCon().createStatement();
                String query = "SELECT ";
                if (columnsWithCommas == "") {
                    query += "*";
                } else {
                    query += columnsWithCommas;
                }
                query += " FROM " + table;
                if (where != "") {
                    query += " WHERE " + where;
                }
                System.out.println(query);
                result = statement.executeQuery(query);
            } catch (SQLException e) {
                e.printStackTrace();
                result = null;
            }
        }
        return result;
    }



}
