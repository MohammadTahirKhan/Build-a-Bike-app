package SQL.Queries.Product;

import Product.Bike;
import Product.Frame;
import Product.HandleBar;
import Product.Wheels;
import SQL.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static SQL.Queries.Product.SQLFrame.getFrame;
import static SQL.Queries.Product.SQLHandleBar.getHandleBar;
import static SQL.Queries.Product.SQLProduct.insertProductTable;
import static SQL.Queries.Product.SQLWheels.getWheels;

public class SQLBike {

//    Inserting bike
    /**
     * Used by backend to insert directly into Bike table
     * @param bike bike object
     * @return bike object but with the primary key set
     */
    public static Bike insertBikeTable(Bike bike){
        bike.setValues();
        try{
            int productID = insertProductTable(bike.getProduct()).getPKey();
            String sql = "INSERT INTO `team002`.`Bike` (`productID`, `wheelsID`, `handleBarID`, `frameSetID`) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
            statement.setInt(1, productID);
            statement.setInt(2, bike.getWheels().getPKey());
            statement.setInt(3, bike.getHandleBar().getPKey());
            statement.setInt(4, bike.getFrame().getPKey());
            statement.executeUpdate();
            bike.setPKey(productID);
            return bike;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


//    Getting bike
    /**
     * Used by backend to get bike from table
     * @param productId product ID of bike
     * @return Bike object from database or NULL if it doesnt exist
     */
    public static Bike getBike(int productId) {

        Connection con = DbConnection.getCon();
        assert con != null;

        try {
            String getBikeSQL = "SELECT Bike.wheelsID, Bike.handleBarID, Bike.frameSetID, Product.productName, " +
                    "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock " +
                    "FROM (Product INNER JOIN Bike ON Product.productID = Bike.productID) " +
                    "WHERE Product.ProductID = ?";

            PreparedStatement getBikeStatement = con.prepareStatement(getBikeSQL);
            getBikeStatement.setInt(1, productId);

            ResultSet getBikeRS = getBikeStatement.executeQuery();
            getBikeRS.next();

            Wheels wheels = getWheels(getBikeRS.getInt(1));
            HandleBar handleBar = getHandleBar(getBikeRS.getInt(2));
            Frame frame = getFrame(getBikeRS.getInt(3));
            String name = getBikeRS.getString(4);
            int serialNumber = getBikeRS.getInt(5);
            double unitCost = getBikeRS.getDouble(6);
            String brandName = getBikeRS.getString(7);
            int stock = getBikeRS.getInt(8);

            return new Bike(productId, wheels, frame, handleBar, name, serialNumber, unitCost, brandName, stock);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

}
