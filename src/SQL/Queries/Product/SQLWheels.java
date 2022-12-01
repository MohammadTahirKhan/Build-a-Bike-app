package SQL.Queries.Product;

import Product.Wheels;
import SQL.DbConnection;
import SQL.Queries.SQLUtils;
import SQL.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static SQL.Queries.Product.SQLProduct.insertProductTable;

public class SQLWheels {


//    Inserting wheels
    /**
     * Used by backend to insert directly into Wheels table
     * @param wheels wheels object
     * @return wheels object with primary key set
     */
    private static Wheels insertWheelTable(Wheels wheels) {
        //        Get connection, and set up transaction
        Connection con = DbConnection.getCon();
        assert con != null;
        try {
            con.setAutoCommit(false);
            int productID = insertProductTable(wheels.getProduct()).getPKey();
            String sql = "INSERT INTO `team002`.`Wheels` (`productID`,`diameter`,`style`,`brakeSystem`) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
            statement.setInt(1, productID);
            statement.setDouble(2, wheels.getDiameter());
            statement.setString(3, wheels.getStyle().name());
            statement.setString(4, wheels.getBrakeType().name());
            statement.executeUpdate();
            wheels.setPKey(productID);
            con.commit();
            return wheels;
//            Commit the queries
        } catch (SQLException e1){
//            If commit fails, rollback
            e1.printStackTrace();
            DbConnection.rollback(con);
        } finally{
            DbConnection.setAutoCommit(con, true);
        }
        return null;
    }

    /**
     * Used by front end to insert wheels to database
     * @param wheels wheels object
     * @return wheels object with primary key set
     */
    public static Wheels insertWheels(Wheels wheels) {
        return insertWheelTable(wheels);
    }


//    Getting wheels
    /**
     * Gets a set of wheels by the product key
     * @param productId productID of the wheels
     * @return a wheels object
     */
    public static Wheels getWheels(int productId) {

        Connection con = DbConnection.getCon();
        assert con != null;

        try {
            String getWheelSQL = "SELECT Wheels.diameter, Wheels.style, Wheels.brakeSystem, Product.productName, " +
                    "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock" +
                    " FROM (Product INNER JOIN Wheels ON Product.productID = Wheels.productID) " +
                    "WHERE Product.productID = ?";

            PreparedStatement wheelStatement = DbConnection.getCon().prepareStatement(getWheelSQL);
            wheelStatement.setInt(1, productId);

            ResultSet getWheelRS = wheelStatement.executeQuery();
            getWheelRS.next();

            return new Wheels(productId, getWheelRS.getDouble(1),
                    getWheelRS.getString(2),
                    getWheelRS.getString(3),
                    getWheelRS.getString(4),
                    getWheelRS.getInt(5),
                    getWheelRS.getDouble(6),
                    getWheelRS.getString(7),
                    getWheelRS.getInt(8));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets all wheels from the database
     * @return Arraylist of wheels
     */
    public static ArrayList<Wheels> getAllWheels() {
        return getWheels(-1, Wheels.Style.ALL, Wheels.BrakeType.ALL);
    }

    /**
     * Gets the wheels where the filters are true
     * @param diameter if -1, gets all, else,  get the specific diameter
     * @param style if Style is ALL, gets all, else, gets specific style
     * @param brakeSystem if BrakeSystem is ALL, gets all, else, get the specific brakeSystem
     * @return Array list of all the wheels where the filter(s) are true
     */
    public static ArrayList<Wheels> getWheels(double diameter, Wheels.Style style, Wheels.BrakeType brakeSystem) {

        Connection con = DbConnection.getCon();
        assert con != null;

        try {

            String wheelDiameter = "Wheels.diameter = ? AND ";
            String wheelStyle = "Wheels.style = ? AND ";
            String wheelBrakeSystem = "Wheels.brakeSystem = ? AND ";
            String whereString = " WHERE ";

            if (diameter != -1) {
                whereString += wheelDiameter;
            }
            if (!style.equals(Wheels.Style.ALL)) {
                whereString += wheelStyle;
            }
            if (!brakeSystem.equals(Wheels.BrakeType.ALL)) {
                whereString += wheelBrakeSystem;
            }

            String sqlWhere = "";
            if (whereString.length() > 8) {
                sqlWhere = whereString.substring(0, whereString.length() - 5);
            }

            String sql = "SELECT Wheels.diameter, Wheels.style, Wheels.brakeSystem, Product.productName, " +
                    "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock, Product.productID" +
                    " FROM (Product INNER JOIN Wheels ON Product.productID = Wheels.productID)" +
                    sqlWhere;

            PreparedStatement statement = con.prepareStatement(sql);
            int currentParameter = 1;
            if (diameter != -1) {
                statement.setDouble(currentParameter, diameter);
                currentParameter++;
            }
            if (!style.equals(Wheels.Style.ALL)) {
                statement.setString(currentParameter, style.name());
                currentParameter++;
            }
            if (!brakeSystem.equals(Wheels.BrakeType.ALL)) {
                statement.setString(currentParameter, brakeSystem.name());
            }

            ResultSet rs = statement.executeQuery();

            ArrayList<Wheels> wheels = new ArrayList<Wheels>();
            while (rs.next()) {
                wheels.add(new Wheels(rs.getInt(9), rs.getDouble(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
            rs.close();
            return wheels;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
