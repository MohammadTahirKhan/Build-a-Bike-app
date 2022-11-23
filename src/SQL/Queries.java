package SQL;

import Actors.Address;
import Actors.Customer;
import Actors.Staff;
import Order.Order;
import Order.OrderDetails;
import Product.Bike;
import Product.Frame;
import Product.HandleBar;
import Product.Wheels;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Queries {

//    Database inserts
    private static int insertProductTable(String productName, double unitCost, String brandName, int serialNumber, int stock) throws SQLException {
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
    private static int insertWheelTable(String productName, double unitCost, String brandName, int serialNumber, int stock, double diameter, Wheels.Style style, Wheels.BrakeType brakeType) throws SQLException {
        int productID = insertProductTable(productName, unitCost, brandName, serialNumber, stock);
        String sql = "INSERT INTO `team002`.`Wheels` (`productID`,`diameter`,`style`,`brakeSystem`) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setInt(1, productID);
        statement.setDouble(2,diameter);
        statement.setString(3, style.name());
        statement.setString(4, brakeType.name());
        statement.executeUpdate();
        return productID;
    }
    private static int insertFrameTable(String productName, double unitCost, String brandName, int serialNumber, int stock, int frameSize, String gears, boolean containsShocks) throws SQLException {
        int productID = insertProductTable(productName, unitCost, brandName, serialNumber, stock);
        String sql = "INSERT INTO `team002`.`FrameSet` (`productID`,`frameSize`,`shocks`,`gears`) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setInt(1, productID);
        statement.setInt(2, frameSize);
        statement.setBoolean(3, containsShocks);
        statement.setString(4, gears);
        statement.executeUpdate();
        return productID;
    }
    private static int insertHandleBarTable(String productName, double unitCost, String brandName, int serialNumber, int stock, HandleBar.Style style) throws SQLException {
        int productID = insertProductTable(productName, unitCost, brandName, serialNumber, stock);
        String sql = "INSERT INTO `team002`.`Handlebar` (`productID`,`style`) VALUES (?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setInt(1, productID);
        statement.setString(2, style.name());
        statement.executeUpdate();
        return productID;
    }
    private static int insertBikeTable(String productName, double unitCost, String brandName, int serialNumber, int stock, int wheelsID, int handleBarID, int frameSetID) throws SQLException {
        int productID = insertProductTable(productName, unitCost, brandName, serialNumber, stock);
        String sql = "INSERT INTO `team002`.`Bike` (`productID`, `wheelsID`, `handleBarID`, `frameSetID`) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setInt(1, productID);
        statement.setInt(2, wheelsID);
        statement.setInt(3, handleBarID);
        statement.setInt(4, frameSetID);
        statement.executeUpdate();
        return productID;
    }
    private static int insertAddressTable(int houseNo, String roadName, String cityName, String postCode) throws SQLException {
        String sql = "INSERT INTO `team002`.`Address`(`houseNo`, `roadName`, `cityName`, `postCode`) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, houseNo);
        statement.setString(2, roadName);
        statement.setString(3, cityName);
        statement.setString(4, postCode);
        statement.executeUpdate();
        return DbConnection.getPrimaryKey(statement);
    }
    private static int insertOrderTable(Date date, double orderCost, Order.Status orderStatus, String orderContents, int customerID, int productID) throws SQLException {
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
    private static int insertCustomerTable(String forename, String surname, int addressID) throws SQLException {
        String sql = "INSERT INTO `team002`.`Customer` (`forename`, `surname`, `addressID`) VALUES (?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, forename);
        statement.setString(2, surname);
        statement.setInt(3, addressID);
        statement.executeUpdate();
        return DbConnection.getPrimaryKey(statement);
    }
    private static int insertStaffTable(String username, byte[][] hashSalt) throws SQLException {
//        INSECURE, UPDATE THE PASSWORD HASHING BOIIII
        String sql = "INSERT INTO `team002`.`Staff` (`username`, `hash`, `salt`) VALUES (?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, username);
        statement.setBytes(2, hashSalt[0]);
        statement.setBytes(3, hashSalt[1]);
        statement.executeUpdate();
        return DbConnection.getPrimaryKey(statement);
    }

//    Get order
    private static Order getOrder(int orderId) throws SQLException {

        Connection con = DbConnection.getCon();

        String getOrderSQL = "SELECT " +
                "Order.orderDate, Order.orderCost, Order.orderStatus, Order.orderContents, Order.customerID, Order.productID FROM team002.Order " +
                "WHERE Order.orderID = ?";
        PreparedStatement orderStatement = con.prepareStatement(getOrderSQL);
        orderStatement.setInt(1, orderId);

        ResultSet getOrderRS = orderStatement.executeQuery();
        getOrderRS.next();

        Date orderDate = getOrderRS.getDate(1);
        double orderCost = getOrderRS.getDouble(2);
        Order.Status orderStatus = Order.Status.valueOf(getOrderRS.getString(3));
//        Tahir, FIX THIS PLEASE :)
        OrderDetails orderDetails = null;
        Customer orderCustomer = getCustomer(getOrderRS.getInt(5));
        Bike orderBike = getBike(getOrderRS.getInt(6));

        return new Order(orderId, orderDate, orderCost, orderStatus, orderDetails, orderCustomer, orderBike);
    }
    private static ArrayList<Order> getOrder(String forename, String surname, Address address) throws SQLException {

        String getOrderSQL = "SELECT team002.Order.orderID " +
                "FROM (team002.Order INNER JOIN Customer ON team002.Order.customerID = Customer.customerID INNER JOIN Address ON Customer.addressID = Address.addressID) " +
                "WHERE Customer.forename = ? AND Customer.surname = ? AND Address.houseNo = ? AND Address.roadName = ? AND Address.cityName = ? AND Address.postCode = ?";

        PreparedStatement customerStatement = DbConnection.getCon().prepareStatement(getOrderSQL);
        customerStatement.setString(1, forename);
        customerStatement.setString(2, surname);
        customerStatement.setInt(3, address.getHouseNo());
        customerStatement.setString(4, address.getRoadName());
        customerStatement.setString(5, address.getCityName());
        customerStatement.setString(6, address.getPostCode());

        ResultSet getCustomerRS = customerStatement.executeQuery();

        ArrayList<Order> orders = new ArrayList<Order>();
        while (getCustomerRS.next()){
            orders.add(getOrder(getCustomerRS.getInt(1)));
        }
        return orders;
    }

//    Get Customer
    private static Customer getCustomer(int customerID) throws SQLException {

        String getCustomerSQL = "SELECT Customer.forename, Customer.surname, Customer.addressID, Address.houseNo, " +
                "Address.roadName, Address.cityName, Address.postCode " +
                "FROM (Customer INNER JOIN Address ON Address.addressID = Customer.addressID) " +
                "WHERE Customer.customerID = ?";

        PreparedStatement customerStatement = DbConnection.getCon().prepareStatement(getCustomerSQL);
        customerStatement.setInt(1, customerID);

        ResultSet getCustomerRS = customerStatement.executeQuery();
        getCustomerRS.next();

        Address address = new Address(getCustomerRS.getInt(3), getCustomerRS.getInt(4),
                getCustomerRS.getString(5), getCustomerRS.getString(6),
                getCustomerRS.getString(7));
        return new Customer(customerID, getCustomerRS.getString(1), getCustomerRS.getString(2), address);
    }

//    Get Bike
    private static Bike getBike(int productId) throws SQLException {

    Connection con = DbConnection.getCon();

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


    return new Bike(wheels, frame, handleBar, name, serialNumber, unitCost, brandName, stock);

}

//    Get Bike component
    private static Wheels getWheels(int productID) throws SQLException {

        String getWheelSQL = "SELECT Wheels.diameter, Wheels.style, Wheels.brakeSystem, Product.productName, " +
                "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock" +
                " FROM (Product INNER JOIN Wheels ON Product.productID = Wheels.productID) " +
                "WHERE Product.productID = ?";

        PreparedStatement wheelStatement = DbConnection.getCon().prepareStatement(getWheelSQL);
        wheelStatement.setInt(1, productID);

        ResultSet getWheelRS = wheelStatement.executeQuery();
        getWheelRS.next();

        return new Wheels(getWheelRS.getDouble(1),
                getWheelRS.getString(2),
                getWheelRS.getString(3),
                getWheelRS.getString(4),
                getWheelRS.getInt(5),
                getWheelRS.getDouble(6),
                getWheelRS.getString(7),
                getWheelRS.getInt(8));
    }
    private static HandleBar getHandleBar(int productID) throws SQLException {

        String getWheelSQL = "SELECT Handlebar.style, Product.productName, " +
                "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock" +
                " FROM (Product INNER JOIN Handlebar ON Product.productID = Handlebar.productID)" +
                "WHERE Product.productID = ?";

        PreparedStatement handleBarStatement = DbConnection.getCon().prepareStatement(getWheelSQL);
        handleBarStatement.setInt(1, productID);

        ResultSet handleBarRS = handleBarStatement.executeQuery();
        handleBarRS.next();

        return new HandleBar(handleBarRS.getString(1),
                handleBarRS.getString(2),
                handleBarRS.getInt(3),
                handleBarRS.getInt(4),
                handleBarRS.getString(5),
                handleBarRS.getInt(6));
    }
    private static Frame getFrame(int productID) throws SQLException {

        String getFrameSQL = "SELECT FrameSet.frameSize, FrameSet.gears, FrameSet.shocks, Product.productName, " +
                "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock" +
                " FROM (Product INNER JOIN FrameSet ON Product.productID = FrameSet.productID)" +
                "WHERE Product.productID = ?";

        PreparedStatement frameStatement = DbConnection.getCon().prepareStatement(getFrameSQL);
        frameStatement.setInt(1, productID);

        ResultSet getFrameRS = frameStatement.executeQuery();
        getFrameRS.next();

        return new Frame(getFrameRS.getInt(1),
                getFrameRS.getString(2),
                getFrameRS.getBoolean(3),
                getFrameRS.getString(4),
                getFrameRS.getInt(5),
                getFrameRS.getInt(6),
                getFrameRS.getString(7),
                getFrameRS.getInt(8));
    }
    private static ArrayList<Wheels> getWheels(double diameter, Wheels.Style style, Wheels.BrakeType brakeSystem) throws SQLException {

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

//    Set users
    public static void setUsers(){
        return;
    }

//    Hash password
    public static String hashPassword(String password){
        return password;
    }

//    Order queries
    public static void deleteOrder(int orderID) throws SQLException {
        Connection con = DbConnection.getCon();
        String sql = "DELETE FROM `team002`.`Order` WHERE Order.orderID = ? AND Order.orderStatus = ?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setInt(1, orderID);
        statement.setString(2, Order.Status.PENDING.name());
        statement.executeUpdate();
    }
    public static void updateOrderStatus(int orderID, Order.Status status) throws SQLException {
        String sql = "UPDATE `team002`.`Order` SET `orderStatus` = ? WHERE `orderID` = ?";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setString(1, status.name());
        statement.setInt(2, orderID);
        statement.executeUpdate();
    }

//    Gets staff member from username
    private static Staff getStaff(String staffUsername) throws SQLException {
        String sql = "SELECT Staff.hash, Staff.salt FROM `team002`.`Staff` WHERE Staff.username = ?";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setString(1, staffUsername);
        ResultSet rs = statement.executeQuery();

        rs.next();
        byte[] hash = rs.getBytes(1);
        byte[] salt = rs.getBytes(2);
        Staff staff = new Staff(staffUsername, hash, salt);
        return staff;
    }

//    Update customer details
    public static void updateCustomer(Customer customer) throws SQLException{


//        Get connection, and set up transaction
            Connection con = DbConnection.getCon();
        try {
            con.setAutoCommit(false);

//        Create the SQL syntax
            String addressUPDATE = "UPDATE `team002`.`Address` ";
            String addressSET = "SET Address.houseNo = ?, Address.roadName = ?, Address.cityName = ?, Address.postCode = ? ";
            String addressWHERE = "WHERE Address.addressID = ?; ";
            String customerUPDATE = "UPDATE `team002`.`Customer` ";
            String customerSET = "SET Customer.forename = ?, Customer.surname = ? ";
            String customerWHERE = "WHERE Customer.customerID = ?; ";

//        Create the prepared statements
            PreparedStatement updateAddress = DbConnection.getCon().prepareStatement(addressUPDATE + addressSET + addressWHERE);
            PreparedStatement updateCustomer = DbConnection.getCon().prepareStatement(customerUPDATE + customerSET + customerWHERE);

//        Set the variables
            Address address = customer.getAddress();
            updateAddress.setInt(1, address.getHouseNo());
            updateAddress.setString(2, address.getRoadName());
            updateAddress.setString(3, address.getCityName());
            updateAddress.setString(4, address.getPostCode());
            updateAddress.setInt(5, address.getAddressId());
            updateCustomer.setString(1, customer.getForename());
            updateCustomer.setString(2, customer.getSurname());
            updateCustomer.setInt(3, customer.getCustomerId());

//        Execute the queries
            updateAddress.executeUpdate();
            updateCustomer.executeUpdate();

//        Commit the queries
            con.commit();
        } catch (SQLException e){
//            If commit fails, rollback
            System.out.println(e);
            DbConnection.rollback(con);
        } finally{
            con.setAutoCommit(true);
        }
    }

//    Initialise database
    private static void setDatabase() throws SQLException {
        deleteDatabase();
        populateDatabase();
    }
    private static void populateDatabase() throws SQLException {
//        First insert all the components of a bike
        int wheelID = insertWheelTable("xyz", 5.99, "brand123", 678, 1, 7, Wheels.Style.ROAD, Wheels.BrakeType.RIM);
        int wheelID1 = insertWheelTable("fgh", 6.99, "brand1233", 978, 1, 8, Wheels.Style.MOUNTAIN, Wheels.BrakeType.DISKBRAKE);
        int wheelID2 = insertWheelTable("bnm", 9.99, "brand1223", 688, 1, 6, Wheels.Style.HYBRID, Wheels.BrakeType.RIM);
        int wheelID3 = insertWheelTable("rbm", 10.0, "brand1234", 888, 1, 8, Wheels.Style.HYBRID, Wheels.BrakeType.RIM);

        int frameID = insertFrameTable("pqr", 9, "brand123", 789, 1, 10, "ABC", true);
        int frameID1 = insertFrameTable("qsr", 10, "brand1234", 989, 1, 11, "ADC", false);
        int frameID2 = insertFrameTable("rst", 8, "brand1233", 739, 1, 12, "AKD", true);
        int frameID3 = insertFrameTable("ppt", 8, "brand1223", 659, 1, 12, "AVC", false);

        int handleBarID = insertHandleBarTable("klm", 3, "brand123", 345, 2, HandleBar.Style.STRAIGHT);
        int handleBarID1 = insertHandleBarTable("tgl", 4, "brand1523", 395, 1, HandleBar.Style.STRAIGHT);
        int handleBarID2 = insertHandleBarTable("ssm", 2.99, "brand1243", 3445, 1, HandleBar.Style.DROPPED);
        int handleBarID3 = insertHandleBarTable("prm", 3, "brand1234", 3455, 2, HandleBar.Style.HIGH);
//        bike requires the ID's from each component
        int bikeID = insertBikeTable("pqraa", 30, "brand123",567, 1, wheelID,handleBarID,frameID);
        int bikeID1 = insertBikeTable("aaa", 31, "brand123",5679, 1, wheelID1,handleBarID1,frameID1);
        int bikeID2 = insertBikeTable("pqv", 40, "brand123",5657, 1, wheelID2,handleBarID2,frameID2);
        int bikeID3 = insertBikeTable("rav", 35, "brand123",5667, 1, wheelID3,handleBarID3,frameID3);

//        Order requires customer ID, Customer requires the addressID
        int addressID = insertAddressTable(45, "St-georges", "Sheffield", "S37HB");
        int customerID = insertCustomerTable("abccc", "bcddd",addressID);
        int addressID1 = insertAddressTable(777, "Hawkins-St", "Sheffield", "KL4MN");
        int customerID1 = insertCustomerTable("qmn", "dfgh",addressID1);
        int addressID2 = insertAddressTable(901, "West-St", "Sheffield", "A3BFG");
        int customerID2 = insertCustomerTable("brp", "okd",addressID2);
        int customerID3 = insertCustomerTable("klmn", "pqrs",addressID2);

        insertOrderTable(Date.valueOf(LocalDate.now()), 69.99, Order.Status.PENDING, "Contains 1 Neon Pink Bike", customerID, bikeID);
        insertOrderTable(Date.valueOf(LocalDate.now()), 59.99, Order.Status.CONFIRMED, "Contains 1 Azure Blue Bike", customerID1, bikeID1);
        insertOrderTable(Date.valueOf(LocalDate.now()), 79.99, Order.Status.PENDING, "Contains 1 Vermilion Bike", customerID2, bikeID2);
        insertOrderTable(Date.valueOf(LocalDate.now()), 66.99, Order.Status.FULFILLED, "Contains 1 golden Bike", customerID3, bikeID3);

        //        Inserts staff
        byte[][] salts = new byte[4][4];
        Arrays.fill(salts, Password.getSalt());
        insertStaffTable("aksb", Objects.requireNonNull(Password.encryptPassword("Hello", salts[0])));
        insertStaffTable("roronoa", Objects.requireNonNull(Password.encryptPassword("Hello", salts[1])));
        insertStaffTable("bob", Objects.requireNonNull(Password.encryptPassword("Hello", salts[2])));
        insertStaffTable("vinsmoke", Objects.requireNonNull(Password.encryptPassword("Hello", salts[3])));
    }
    private static void deleteDatabase() throws SQLException {
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
//        setDatabase();
//        ArrayList<Wheels> wheels = getWheelsWhere(-1, Wheels.Style.ROAD, Wheels.BrakeType.RIM);
//        System.out.println(wheels);

//        Address address = new Address(81, 621, "ABC123", "Sheffield", "S37ABC");
//        Customer customer = new Customer(105, "Alex", "Chapman", address);
//        updateCustomer(customer);
//        Staff staff = getStaff("aksb");
//        Boolean isCorrect = Password.checkPassword(staff.getHash(), "Hello", staff.getSalt());
        Order order = getOrder(107);
        System.out.println(order.getCustomer().getForename() + " " + order.getCustomer().getSurname());
        ArrayList<Order> order2 = getOrder(order.getCustomer().getForename(), order.getCustomer().getSurname(), order.getCustomer()
                .getAddress());
        System.out.println(order2.get(0).getDate());
    }
}




