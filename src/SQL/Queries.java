package SQL;

import Order.Order;
import Product.HandleBar;
import Product.Wheels;

import java.sql.*;
import java.util.function.DoubleBinaryOperator;

public class Queries {

    public void subtractStockOrder(){

    }

    public void subtractItemStock(){

    }




//    public Wheels[] getWheels(int diameter, Wheels.Style style, Wheels.BrakeType brakeType){
//        String rawQuery ="SELECT asfasfas.grfom asdfasdfsdfsd?";
////        query=...
////        results = DbConnection.executeQuery(query);
////
//    }






//    Database inserts
    private static int insertProduct(String productName, double unitCost, String brandName, int serialNumber, int stock) throws SQLException {
    String sql = "INSERT INTO `team002`.`Product` (`productName`,`unitCost`,`brandName`,`serialNumber`,`stock`) VALUES (?, ?, ?, ?, ?);";
    PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    statement.setString(1, productName);
    statement.setDouble(2, unitCost);
    statement.setString(3, brandName);
    statement.setInt(4, serialNumber);
    statement.setInt(5, stock);
    statement.executeUpdate();
    ResultSet rs = statement.getGeneratedKeys();
    int productID = 0;
    if (rs.next()) {
        productID = rs.getInt(1);
    }
    return productID;
}
    private static int insertWheel(String productName, double unitCost, String brandName, int serialNumber, int stock, double diameter, Wheels.Style style, Wheels.BrakeType brakeType) throws SQLException {
        int productID = insertProduct(productName, unitCost, brandName, serialNumber, stock);
        String sql = "INSERT INTO `team002`.`Wheels` (`productID`,`diameter`,`style`,`brakeSystem`) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, productID);
        statement.setDouble(2,diameter);
        statement.setString(3, style.name());
        statement.setString(4, brakeType.name());
        statement.executeUpdate();
        return DbConnection.getPrimaryKey(statement);
    }
    private static int insertFrame(String productName, double unitCost, String brandName, int serialNumber, int stock, int frameSize, String gears, boolean containsShocks) throws SQLException {
        int productID = insertProduct(productName, unitCost, brandName, serialNumber, stock);
        String sql = "INSERT INTO `team002`.`FrameSet` (`productID`,`frameSize`,`shocks`,`gears`) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, productID);
        statement.setInt(2, frameSize);
        statement.setBoolean(3, containsShocks);
        statement.setString(4, gears);
        statement.executeUpdate();
        return DbConnection.getPrimaryKey(statement);
    }
    private static int insertHandleBar(String productName, double unitCost, String brandName, int serialNumber, int stock, HandleBar.Style style) throws SQLException {
        int productID = insertProduct(productName, unitCost, brandName, serialNumber, stock);
        String sql = "INSERT INTO `team002`.`Handlebar` (`productID`,`style`) VALUES (?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, productID);
        statement.setString(2, style.name());
        statement.executeUpdate();
        return DbConnection.getPrimaryKey(statement);
    }
    private static int insertBike(String productName, double unitCost, String brandName, int serialNumber, int stock, int wheelsID, int handleBarID, int frameSetID) throws SQLException {
        int productID = insertProduct(productName, unitCost, brandName, serialNumber, stock);
        String sql = "INSERT INTO `team002`.`Bike` (`productID`, `wheelsID`, `handleBarID`, `frameSetID`) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, productID);
        statement.setInt(2, wheelsID);
        statement.setInt(3, handleBarID);
        statement.setInt(4, frameSetID);
        statement.executeUpdate();
        return productID;
    }
    private static int insertAddress(int houseNo, String roadName, String cityName, String postCode) throws SQLException {
        String sql = "INSERT INTO `team002`.`Address`(`houseNo`, `roadName`, `cityName`, `postCode`) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, houseNo);
        statement.setString(2, roadName);
        statement.setString(3, cityName);
        statement.setString(4, postCode);
        statement.executeUpdate();
        return DbConnection.getPrimaryKey(statement);
    }
    private static int insertOrder(Date date, double orderCost, Order.Status orderStatus, String orderContents, int customerID, int productID) throws SQLException {
        String sql = "INSERT INTO `team002`.`Order` (`orderDate`, `orderCost`, `orderStatus`, `orderContents`, `customerID`, `productID`) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setDate(1, date);
        statement.setDouble(2, orderCost);
        statement.setString(3, orderStatus.name());
        statement.setString(4, orderContents);
        statement.setInt(5, customerID);
        statement.setInt(5, productID);
        statement.executeUpdate();
        return DbConnection.getPrimaryKey(statement);
    }
    private static int insertCustomer(String forename, String surname, int customerID) throws SQLException {
        String sql = "INSERT INTO `team002`.`Customer` (`forename`, `surname`, `addressID`) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, forename);
        statement.setString(2, surname);
        statement.setInt(3, customerID);
        statement.executeUpdate();
        return DbConnection.getPrimaryKey(statement);
    }
    private static int insertStaff(String username, String password) throws SQLException {
//        INSECURE, UPDATE THE PASSWORD HASHING BOIIII
        String sql = "INSERT INTO `team002`.`Staff` (`username`, `password`) VALUES (?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, username);
        statement.setString(2, password);
        statement.executeUpdate();
        return DbConnection.getPrimaryKey(statement);
    }

//    Getting order
    private static Order getOrder(int productID){
        return null;
    }
    private static Order getOrder(String forename, String surname, int houseNumber, String address){
        return null;
    }

    private static Wheels getWheelsWhere(double diameter, Wheels.Style style, Wheels.BrakeType brakeSystem) throws SQLException {

        String sql = "SELECT Wheels.diameter, Wheels.style, Wheels.brakeSystem, Product.productName, " +
                "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock" +
                    " FROM (Product INNER JOIN Wheels ON Product.productID = Wheels.productID)" +
                    " WHERE Wheels.diameter = ? AND Wheels.style = ? AND Wheels.brakeSystem = ?;";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        if (diameter == -1)
            statement.setString(1, "*");
        else
            statement.setDouble(1, diameter);
        statement.setString(2, Utils.isAllEnum(style));
        statement.setString(3, Utils.isAllEnum(brakeSystem));

        ResultSet rs = statement.executeQuery();
        System.out.println(statement);
        if (rs.next()) {
            Wheels wheels = new Wheels(rs.getDouble(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getDouble(6),
                    rs.getString(7),
                    rs.getInt(8));

            rs.close();
            return wheels;
        } else {
            rs.close();
            return null;
        }

//        SELECT FROM Wheels WHERE diameter = * AND type = *
//        GENIUS ENUM THING DO IT YES : )
    }

//    Stock handler
    private static void decrementStock(int productID) throws SQLException {
//        Have a decerement exception
        String sql = "UPDATE `team002`.`Product` SET `stock` = `stock` - 1 WHERE `productID` = ?;";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setInt(1, productID);
        statement.executeUpdate();
    }
    private static void setStock(int productID, int quantity) throws SQLException {
        String sql = "UPDATE `team002`.`Product` SET `stock` = ? WHERE `productID` = ?;";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setInt(1, quantity);
        statement.setInt(2, productID);
        statement.executeUpdate();
    }


//    Initialising database
    static void setDatabase() throws SQLException {
        deleteDatabase();
        populateDatabase();
    }
    static void populateDatabase(){
//        add all the dummy data
//        DbConnection.executeQuery(query);
    }
    static void deleteDatabase() throws SQLException {
        Connection con = DbConnection.getCon();
        con.prepareStatement("DELETE FROM `team002`.`Address;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Bike;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Customer;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`FrameSet;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Handlebar;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Order;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Product;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Staff;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Wheels;").executeUpdate();
    }



    public static void main(String[] args) throws SQLException {
        System.out.println("Setting database...");
//        setDatabase();
        insertWheel("CHECKHeels", 6.99, "CHECKNike", 696969, 1, 6.21, Wheels.Style.ROAD, Wheels.BrakeType.RIM);
//        insertFrame("framyMcFrame", 6.99F, "CHECKNike", 696969, 1, 12, "PHAT", true);
//        insertHandleBar("handyMcHandBar", 6.21F, "CHECKBAR", 345679, 200, HandleBar.Style.STRAIGHT);
//        setStock(33, 400);
//        deleteDatabase();
        Wheels wheel = getWheelsWhere(-1, Wheels.Style.ROAD, Wheels.BrakeType.RIM);
        System.out.println(wheel.getStyle());
        System.out.println("Successfull");
    }
}




