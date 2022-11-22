package SQL;

import Order.Order;
import Product.Frame;
import Product.HandleBar;
import Product.Wheels;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.DoubleBinaryOperator;

public class Queries {

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
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setInt(1, productID);
        statement.setDouble(2,diameter);
        statement.setString(3, style.name());
        statement.setString(4, brakeType.name());
        statement.executeUpdate();
        return productID;
    }
    private static int insertFrame(String productName, double unitCost, String brandName, int serialNumber, int stock, int frameSize, String gears, boolean containsShocks) throws SQLException {
        int productID = insertProduct(productName, unitCost, brandName, serialNumber, stock);
        String sql = "INSERT INTO `team002`.`FrameSet` (`productID`,`frameSize`,`shocks`,`gears`) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setInt(1, productID);
        statement.setInt(2, frameSize);
        statement.setBoolean(3, containsShocks);
        statement.setString(4, gears);
        statement.executeUpdate();
        return productID;
    }
    private static int insertHandleBar(String productName, double unitCost, String brandName, int serialNumber, int stock, HandleBar.Style style) throws SQLException {
        int productID = insertProduct(productName, unitCost, brandName, serialNumber, stock);
        String sql = "INSERT INTO `team002`.`Handlebar` (`productID`,`style`) VALUES (?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setInt(1, productID);
        statement.setString(2, style.name());
        statement.executeUpdate();
        return productID;
    }
    private static int insertBike(String productName, double unitCost, String brandName, int serialNumber, int stock, int wheelsID, int handleBarID, int frameSetID) throws SQLException {
        int productID = insertProduct(productName, unitCost, brandName, serialNumber, stock);
        String sql = "INSERT INTO `team002`.`Bike` (`productID`, `wheelsID`, `handleBarID`, `frameSetID`) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
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
        statement.setInt(6, productID);
        statement.executeUpdate();
        return DbConnection.getPrimaryKey(statement);
    }
    private static int insertCustomer(String forename, String surname, int addressID) throws SQLException {
        String sql = "INSERT INTO `team002`.`Customer` (`forename`, `surname`, `addressID`) VALUES (?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, forename);
        statement.setString(2, surname);
        statement.setInt(3, addressID);
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

//    Get order
    private static Order getOrder(int productID){
        return null;
    }
    private static Order getOrder(String forename, String surname, int houseNumber, String address){
        return null;
    }

//    Get Bike component
    private static ArrayList<Wheels> getWheelsWhere(double diameter, Wheels.Style style, Wheels.BrakeType brakeSystem) throws SQLException {

        String wheelDiameter = "Wheels.diameter = ? AND ";
        String wheelStyle = "Wheels.style = ? AND ";
        String wheelBrakeSystem = "Wheels.brakeSystem = ? AND ";
        String whereString = " WHERE ";

        if (diameter != -1){
            whereString += wheelDiameter;
        }if (!style.equals(Wheels.Style.ALL)){
            whereString += wheelStyle;
        }if (!brakeSystem.equals(Wheels.BrakeType.ALL)){
            whereString += wheelBrakeSystem;
        }

        String sqlWhere = "";
        if (whereString.length() > 8){
            sqlWhere = whereString.substring(0, whereString.length() - 5);
        }

        String sql = "SELECT Wheels.diameter, Wheels.style, Wheels.brakeSystem, Product.productName, " +
                "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock" +
                    " FROM (Product INNER JOIN Wheels ON Product.productID = Wheels.productID)" +
                sqlWhere;

        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        int currentParameter = 1;
        if (diameter != -1){
            statement.setDouble(currentParameter, diameter);
            currentParameter ++;
        }if (!style.equals(Wheels.Style.ALL)){
            statement.setString(currentParameter, Utils.isAllEnum(style));
            currentParameter ++;
        }if (!brakeSystem.equals(Wheels.BrakeType.ALL)){
            statement.setString(currentParameter, Utils.isAllEnum(brakeSystem));
        }

        ResultSet rs = statement.executeQuery();
        System.out.println(statement);

        ArrayList<Wheels> wheels = new ArrayList<Wheels>();
        while (rs.next()) {
            wheels.add(new Wheels(rs.getDouble(1),
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
    }
    private static ArrayList<Frame> getFrame(int frameSize , String gears, String containsShocks) throws SQLException {

        String FrameFrameSize = "Frame.frameSize = ? AND ";
        String FrameGears = "Frame.gears = ? AND ";
        String FrameContainsShocks = "Frame.containsShocks = ? AND ";
        String whereString = " WHERE ";

        if (frameSize != -1){
            whereString += FrameFrameSize;
        }if (!gears.equals("ALL")){
            whereString += FrameGears;
        }if (!containsShocks.equals("ALL")){
            whereString += FrameContainsShocks;
        }

        String sqlWhere = "";
        if (whereString.length() > 8){
            sqlWhere = whereString.substring(0, whereString.length() - 5);
        }

        String sql = "SELECT Frame.frameSize, Frame.gears, Frame.containsShocks, Product.productName, " +
                "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock" +
                " FROM (Product INNER JOIN FrameSet ON Product.productID = FrameSet.productID)" +
                sqlWhere;

        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        int currentParameter = 1;
        if (frameSize != -1){
            statement.setInt(currentParameter, frameSize);
        }if (!gears.equals("ALL")){
            statement.setString(currentParameter, gears);
        }if (!containsShocks.equals("ALL")){
            statement.setBoolean(currentParameter, Boolean.getBoolean(containsShocks));
        }

        ResultSet rs = statement.executeQuery();
        ArrayList<Frame> frames = new ArrayList<Frame>();
        if (rs.next()) {
            frames.add(new Frame(rs.getInt(1),
                    rs.getString(2),
                    rs.getBoolean(3),
                    rs.getString(4),
                    rs.getInt(5),
                    rs.getInt(6),
                    rs.getString(7),
                    rs.getInt(8)));
        }
        rs.close();
        return frames;
    }
    private static ArrayList<HandleBar> getHandleBar(HandleBar.Style style) throws SQLException {

        String sqlWhere = "";
        if (style != HandleBar.Style.ALL){
            sqlWhere = " WHERE HandleBar.style = ?";
        }

        String sql = "SELECT HandleBar.style, Product.productName, " +
                "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock" +
                " FROM (Product INNER JOIN HandleBar ON Product.productID = HandleBar.productID)" +
                sqlWhere;
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);

        if (style != HandleBar.Style.ALL){
            statement.setString(1, Utils.isAllEnum(style));
        }

        ResultSet rs = statement.executeQuery();
        System.out.println(statement);
        ArrayList<HandleBar> handleBars = new ArrayList<>();
        while (rs.next()) {
            handleBars.add(new HandleBar(rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getInt(6)));
        }
        rs.close();
        return handleBars;
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
    static void populateDatabase() throws SQLException {
//        First insert all the components of a bike
        int wheelID = insertWheel("xyz", 5.99, "brand123", 678, 1, 7, Wheels.Style.ROAD, Wheels.BrakeType.RIM);
        int wheelID1 = insertWheel("fgh", 6.99, "brand1233", 978, 1, 8, Wheels.Style.MOUNTAIN, Wheels.BrakeType.DISKBRAKE);
        int wheelID2 = insertWheel("bnm", 9.99, "brand1223", 688, 1, 6, Wheels.Style.HYBRID, Wheels.BrakeType.DISKBRAKE);
        int wheelID3 = insertWheel("rbm", 10.0, "brand1234", 888, 1, 8, Wheels.Style.HYBRID, Wheels.BrakeType.RIM);

        int frameID = insertFrame("pqr", 9, "brand123", 789, 1, 10, "ABC", true);
        int frameID1 = insertFrame("qsr", 10, "brand1234", 989, 1, 11, "ADC", false);
        int frameID2 = insertFrame("rst", 8, "brand1233", 739, 1, 12, "AKD", true);
        int frameID3 = insertFrame("ppt", 8, "brand1223", 659, 1, 12, "AVC", false);

        int handleBarID = insertHandleBar("klm", 3, "brand123", 345, 2, HandleBar.Style.STRAIGHT);
        int handleBarID1 = insertHandleBar("tgl", 4, "brand1523", 395, 1, HandleBar.Style.STRAIGHT);
        int handleBarID2 = insertHandleBar("ssm", 2.99, "brand1243", 3445, 1, HandleBar.Style.DROPPED);
        int handleBarID3 = insertHandleBar("prm", 3, "brand1234", 3455, 2, HandleBar.Style.HIGH);
//        bike requires the ID's from each component
        int bikeID = insertBike("pqraa", 30, "brand123",567, 1, wheelID,handleBarID,frameID);
        int bikeID1 = insertBike("aaa", 31, "brand123",5679, 1, wheelID1,handleBarID1,frameID1);
        int bikeID2 = insertBike("pqv", 40, "brand123",5657, 1, wheelID2,handleBarID2,frameID2);
        int bikeID3 = insertBike("rav", 35, "brand123",5667, 1, wheelID3,handleBarID3,frameID3);

//        Order requires customer ID, Customer requires the addressID
        int addressID = insertAddress(45, "St-georges", "Sheffield", "S37HB");
        int customerID = insertCustomer("abccc", "bcddd",addressID);
        int addressID1 = insertAddress(777, "Hawkins-St", "Sheffield", "KL4MN");
        int customerID1 = insertCustomer("qmn", "dfgh",addressID1);
        int addressID2 = insertAddress(901, "West-St", "Sheffield", "A3BFG");
        int customerID2 = insertCustomer("brp", "okd",addressID2);
        int customerID3 = insertCustomer("klmn", "pqrs",addressID2);

        insertOrder(Date.valueOf(LocalDate.now()), 69.99, Order.Status.PENDING, "Contains 1 Neon Pink Bike", customerID, bikeID);
        insertOrder(Date.valueOf(LocalDate.now()), 59.99, Order.Status.CONFIRMED, "Contains 1 Azure Blue Bike", customerID1, bikeID1);
        insertOrder(Date.valueOf(LocalDate.now()), 79.99, Order.Status.PENDING, "Contains 1 Vermilion Bike", customerID2, bikeID2);
        insertOrder(Date.valueOf(LocalDate.now()), 66.99, Order.Status.FULFILLED, "Contains 1 golden Bike", customerID3, bikeID3);

//        Inserts staff
        insertStaff("aksb", "qbcnksx");
        insertStaff("roronoa", "zoro");
        insertStaff("bob", "marley");
        insertStaff("vinsmoke", "sanji");
    }
    static void deleteDatabase() throws SQLException {
        Connection con = DbConnection.getCon();
        con.prepareStatement("DELETE FROM `team002`.`Order`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Customer`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Bike`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Address`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Wheels`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`FrameSet`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Handlebar`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Product`;").executeUpdate();
        con.prepareStatement("DELETE FROM `team002`.`Staff`;").executeUpdate();

    }


    public static void main(String[] args) throws SQLException {
        System.out.println("Setting database...");
        setDatabase();
//        ArrayList<Wheels> wheels = getWheelsWhere(-1, Wheels.Style.ROAD, Wheels.BrakeType.RIM);
//        System.out.println(wheels);
        System.out.println("Successfull");
    }
}




