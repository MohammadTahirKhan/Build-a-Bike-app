package SQL.Queries.Product;

import Order.Order;
import Product.Product;
import SQL.DbConnection;

import java.sql.*;

public class SQLProduct {

//    Inserting product
    /**
     * Used by backend to insert directly into Product table
     * @param product Product object being inserted
     * @return product object but with the primary key set
     */
    static Product insertProductTable(Product product) {
    try{
        String sql = "INSERT INTO `team002`.`Product` (`productName`,`unitCost`,`brandName`,`serialNumber`,`stock`) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, product.getName());
        statement.setDouble(2, product.getItemCost());
        statement.setString(3, product.getBrandName());
        statement.setInt(4, product.getSerialNumber());
        statement.setInt(5, product.getStock());

        statement = DbConnection.executeUpdate(statement);
        assert statement != null;
        ResultSet rs = statement.getGeneratedKeys();
        int productID = -1;
        if (rs.next()) {
            productID = rs.getInt(1);
            product.setPKey(productID);
            return product;
        }
    } catch (SQLException e){
        e.printStackTrace();
    }
    return null;
}


//    Handling stock
    /**
     * Subtracts 1 from the stock of all components in a bikes
     * @param order Order where stock is getting decremented
     */
    public static void decrementStock(Order order) {

//    Get connection, and set up transaction
        Connection con = DbConnection.getCon();
        assert con != null;
        try {

            con.setAutoCommit(false);
            decrementStock(order.getBike().getFrame());
            order.getBike().getFrame().decrementStock();
            decrementStock(order.getBike().getWheels());
            order.getBike().getWheels().decrementStock();
            decrementStock(order.getBike().getHandleBar());
            order.getBike().getHandleBar().decrementStock();

            //        Commit the queries
            con.commit();
        } catch (SQLException e){
//            If commit fails, rollback
            e.printStackTrace();
            DbConnection.rollback(con);
        } finally{
            DbConnection.setAutoCommit(con, true);
        }

    }

    /**
     * Used by backed to subtract 1 from the stock of a specific product
     * @param product Product where stock is getting decremented
     */
    private static void decrementStock(Product product) {
//        Have a decrement exception
        Connection con = DbConnection.getCon();
        assert con != null;

        try {
            String sql = "UPDATE `team002`.`Product` SET `stock` = `stock` - 1 WHERE `productID` = ?;";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, product.getPKey());
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Sets the stock of a specific product
     * @param product  product where you are setting the stock
     * @param quantity  Stock value you want it to be
     */
    public static void setStock(Product product, int quantity) {
        setStock(product.getPKey(), quantity);
    }

    /**
     * Sets the stock to a specific ammount based on serial number and brandName
     * @param serialNumber serialNumber of product
     * @param brandName brandName of product
     * @param stockNumber number of stock
     */
    public static void addStock(int serialNumber, String brandName, int stockNumber) {

//        Have a decrement exception
        Connection con = DbConnection.getCon();
        assert con != null;

        try {
            String sql = "UPDATE Product SET stock = stock + ? WHERE serialNumber = ? AND brandName = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, stockNumber);
            statement.setInt(2, serialNumber);
            statement.setString(3, brandName);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    /**
     * Used by backend to set the stock of a specific product
     * @param productID  the productID of the product
     * @param quantity  The stock the product is being set to
     */
    private static void setStock(int productID, int quantity) {
        Connection con = DbConnection.getCon();
        assert con != null;

        try {
            String sql = "UPDATE `team002`.`Product` SET `stock` = ? WHERE `productID` = ?;";
            PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
            statement.setInt(1, quantity);
            statement.setInt(2, productID);
            statement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
