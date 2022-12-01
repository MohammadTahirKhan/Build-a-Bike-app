package SQL.Queries.Product;

import Product.HandleBar;
import SQL.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static SQL.Queries.Product.SQLProduct.insertProductTable;

public class SQLHandleBar {


//    Inserting handlebars
    /**
     * Used by backend to insert directly into Wheels table
     * @param handleBar HandleBar object
     * @return HandleBar object but with the primary key set
     */
    private static HandleBar insertHandleBarTable(HandleBar handleBar) {
//        Get connection, and set up transaction
        Connection con = DbConnection.getCon();
        assert con != null;
        try {
            con.setAutoCommit(false);
            int productID = insertProductTable(handleBar.getProduct()).getPKey();
            String sql = "INSERT INTO `team002`.`Handlebar` (`productID`,`style`) VALUES (?, ?);";
            PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
            statement.setInt(1, productID);
            statement.setString(2, handleBar.getStyle().name());
            statement.executeUpdate();
            handleBar.setPKey(productID);
//        commit queries
            con.commit();
            return handleBar;
        } catch (SQLException e1) {
//            If commit fails, rollback
            e1.printStackTrace();
            DbConnection.rollback(con);
        } finally {
            DbConnection.setAutoCommit(con, true);
        }
        return null;
    }

    /**
     * Used by front end to insert HandleBar to database
     * @param handleBar HandleBar object
     * @return HandleBar object but with the primary key set
     */
    public static HandleBar insertHandleBar(HandleBar handleBar) {
        return insertHandleBarTable(handleBar);
    }


//    Getting handlebars
    /**
     * Gets handleBar from productID
     * @param productId productID of handleBar
     * @return HandleBar object with primary key set
     */
    public static HandleBar getHandleBar(int productId) {

        Connection con = DbConnection.getCon();
        assert con != null;

        try {
            String getWheelSQL = "SELECT Handlebar.style, Product.productName, " +
                    "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock" +
                    " FROM (Product INNER JOIN Handlebar ON Product.productID = Handlebar.productID)" +
                    "WHERE Product.productID = ?";

            PreparedStatement handleBarStatement = con.prepareStatement(getWheelSQL);
            handleBarStatement.setInt(1, productId);

            ResultSet handleBarRS = handleBarStatement.executeQuery();
            handleBarRS.next();

            return new HandleBar(productId, HandleBar.Style.valueOf(handleBarRS.getString(1)),
                    handleBarRS.getString(2),
                    handleBarRS.getInt(3),
                    handleBarRS.getInt(4),
                    handleBarRS.getString(5),
                    handleBarRS.getInt(6));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets all HandleBars from the database
     * @return Arraylist of HandleBars
     */
    public static ArrayList<HandleBar> getAllHandleBar() {
        return getHandleBar(HandleBar.Style.ALL);
    }

    /**
     *Gets the HandleBar(s) where the filter is true
     * @param style if Style is ALL, then gets all, else, gets specific style
     * @return Arraylist of HandleBars
     */
    @SuppressWarnings("JpaQueryApiInspection")
    public static ArrayList<HandleBar> getHandleBar(HandleBar.Style style) {

        Connection con = DbConnection.getCon();
        assert con != null;

        try {
            String sqlWhere = "";
            if (style != HandleBar.Style.ALL) {
                sqlWhere = " WHERE HandleBar.style = ?";
            }

            String sql = "SELECT Handlebar.style, Product.productName, " +
                    "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock, Product.productID" +
                    " FROM (Product INNER JOIN Handlebar ON Product.productID = Handlebar.productID)" +
                    sqlWhere;
            PreparedStatement statement = con.prepareStatement(sql);

            if (style != HandleBar.Style.ALL) {
                statement.setString(1, style.name());
            }

            ResultSet rs = statement.executeQuery();
            ArrayList<HandleBar> handleBars = new ArrayList<>();
            while (rs.next()) {
                handleBars.add(new HandleBar(rs.getInt(7), HandleBar.Style.valueOf(rs.getString(1)),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getInt(6)));
            }
            rs.close();
            return handleBars;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
