package SQL;

import Actors.Address;
import Actors.Customer;
import Actors.Staff;
import Order.Order;
import Product.*;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Queries {

//    Database inserts
    private static Product insertProductTable(Product product) throws SQLException {
    String sql = "INSERT INTO `team002`.`Product` (`productName`,`unitCost`,`brandName`,`serialNumber`,`stock`) VALUES (?, ?, ?, ?, ?);";
    PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    statement.setString(1, product.getName());
    statement.setDouble(2, product.getItemCost());
    statement.setString(3, product.getBrandName());
    statement.setInt(4, product.getSerialNumber());
    statement.setInt(5, product.getStock());
    statement.executeUpdate();
    ResultSet rs = statement.getGeneratedKeys();
    int productID = 0;
    if (rs.next()) {
        productID = rs.getInt(1);
    }
    product.setPKey(productID);
    return product;
}
    private static Wheels insertWheelTable(Wheels wheels) throws SQLException {
        int productID = insertProductTable(wheels.getProduct()).getPKey();
        String sql = "INSERT INTO `team002`.`Wheels` (`productID`,`diameter`,`style`,`brakeSystem`) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setInt(1, productID);
        statement.setDouble(2, wheels.getDiameter());
        statement.setString(3, wheels.getStyle().name());
        statement.setString(4, wheels.getBrakeType().name());
        statement.executeUpdate();
        wheels.setPKey(productID);
        return wheels;
    }
    private static Frame insertFrameTable(Frame frame) throws SQLException {
        int productID = insertProductTable(frame.getProduct()).getPKey();
        String sql = "INSERT INTO `team002`.`FrameSet` (`productID`,`frameSize`,`shocks`,`gears`) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setInt(1, productID);
        statement.setInt(2, frame.getFrameSize());
        statement.setBoolean(3, frame.isContainsShocks());
        statement.setString(4, frame.getGears());
        statement.executeUpdate();
        frame.setPKey(productID);
        return frame;
    }
    private static HandleBar insertHandleBarTable(HandleBar handleBar) throws SQLException {
        int productID = insertProductTable(handleBar.getProduct()).getPKey();
        String sql = "INSERT INTO `team002`.`Handlebar` (`productID`,`style`) VALUES (?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setInt(1, productID);
        statement.setString(2, handleBar.getStyle().name());
        statement.executeUpdate();
        handleBar.setPKey(productID);
        return handleBar;
    }
    private static Bike insertBikeTable(Bike bike) throws SQLException {
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
    }
    private static Address insertAddressTable(Address address) throws SQLException {
        String sql = "INSERT INTO `team002`.`Address`(`houseNo`, `roadName`, `cityName`, `postCode`) VALUES (?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setInt(1, address.getHouseNo());
        statement.setString(2, address.getRoadName());
        statement.setString(3, address.getCityName());
        statement.setString(4, address.getPostCode());
        statement.executeUpdate();
        int key = DbConnection.getPrimaryKey(statement);
        address.setAddressId(key);
        return address;
    }
    private static Order insertOrderTable(Order order) throws SQLException {
        String sql = "INSERT INTO `team002`.`Order` (`orderDate`, `orderCost`, `orderStatus`, `customerID`, `productID`) VALUES (?, ?, ?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setDate(1, (Date) order.getDate());
        statement.setDouble(2, order.getCost());
        statement.setString(3, order.getStatus().name());
        statement.setInt(4, order.getCustomer().getCustomerId());
        statement.setInt(5, order.getBike().getPKey());
        statement.executeUpdate();
        int key = DbConnection.getPrimaryKey(statement);
        order.setID(key);
        return order;
    }
    private static Customer insertCustomerTable(Customer customer) throws SQLException {
        String sql = "INSERT INTO `team002`.`Customer` (`forename`, `surname`, `addressID`) VALUES (?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, customer.getForename());
        statement.setString(2, customer.getSurname());
        statement.setInt(3, customer.getAddress().getAddressId());
        statement.executeUpdate();
        int key = DbConnection.getPrimaryKey(statement);
        customer.setCustomerId(key);
        return customer;
    }
    private static Staff insertStaffTable(Staff staff) throws SQLException {
        String sql = "INSERT INTO `team002`.`Staff` (`username`, `hash`, `salt`) VALUES (?, ?, ?);";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, staff.getUsername());
        statement.setBytes(2, staff.getHash());
        statement.setBytes(3, staff.getSalt());
        statement.executeUpdate();
        return staff;
    }

//    Get order
    public static Order getOrder(int orderId) throws SQLException {

        Connection con = DbConnection.getCon();

        String getOrderSQL = "SELECT " +
                "Order.orderDate, Order.orderCost, Order.orderStatus, Order.customerID, Order.productID FROM team002.Order " +
                "WHERE Order.orderID = ?";
        PreparedStatement orderStatement = con.prepareStatement(getOrderSQL);
        orderStatement.setInt(1, orderId);

        ResultSet getOrderRS = orderStatement.executeQuery();
        if (getOrderRS.next()){
            Date orderDate = getOrderRS.getDate(1);
            Order.Status orderStatus = Order.Status.valueOf(getOrderRS.getString(3));
            Customer orderCustomer = getCustomer(getOrderRS.getInt(4));
            Bike orderBike = getBike(getOrderRS.getInt(5));

            return new Order(orderId, orderDate, orderStatus, orderCustomer, orderBike);
        } else {
            return null;
        }


    }
    public static ArrayList<Order> getOrder(String forename, String surname, Address address) throws SQLException {

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

        ArrayList<Order> orders = new ArrayList<>();
        while (getCustomerRS.next()){
            orders.add(getOrder(getCustomerRS.getInt(1)));
        }
        if (orders.isEmpty())
            return null;
        return orders;
    }
    public static ArrayList<Order> getOrder(Order.Status orderStatus) throws SQLException {

        String orderSQL = "";
        if (orderStatus != Order.Status.All){
            orderSQL = "WHERE Order.orderStatus = ?";
        }

        String getOrderSQL = "SELECT team002.Order.orderID " +
                "FROM (team002.Order INNER JOIN Customer ON team002.Order.customerID = Customer.customerID INNER JOIN Address ON Customer.addressID = Address.addressID) "
                + orderSQL;

        PreparedStatement customerStatement = DbConnection.getCon().prepareStatement(getOrderSQL);
        if (orderStatus != Order.Status.All){
            customerStatement.setString(1, orderStatus.name());
        }
        ResultSet getCustomerRS = customerStatement.executeQuery();

        ArrayList<Order> orders = new ArrayList<>();
        while (getCustomerRS.next()){
            orders.add(getOrder(getCustomerRS.getInt(1)));
        }
        return orders;
    }

//    Insert order
    public static Order insertOrder(Order order) throws SQLException {
        Connection con = DbConnection.getCon();
        try {
            con.setAutoCommit(false);

            order.getCustomer().setAddress(insertAddressTable(order.getCustomer().getAddress()));
            order.setCustomer(insertCustomerTable(order.getCustomer()));
            order.getBike().setWheels(insertWheelTable(order.getBike().getWheels()));
            order.getBike().setFrame(insertFrameTable(order.getBike().getFrame()));
            order.getBike().setHandleBar(insertHandleBarTable(order.getBike().getHandleBar()));
            order.setBike(insertBikeTable(order.getBike()));
            order = insertOrderTable(order);

            con.commit();
            return order;
//            Commit the queries
        } catch (SQLException e){
//            If commit fails, rollback
            System.out.println(e);
            DbConnection.rollback(con);
        } finally{
            con.setAutoCommit(true);
        }
        return null;
    }

//    Get Customer
    public static Customer getCustomer(int customerID) throws SQLException {

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
    public static Bike getBike(int productId) throws SQLException {

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

    return new Bike(productId, wheels, frame, handleBar, name, serialNumber, brandName, stock);

}

//    Get Bike component
    public static Wheels getWheels(int productId) throws SQLException {

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
    }
    public static HandleBar getHandleBar(int productId) throws SQLException {

        String getWheelSQL = "SELECT Handlebar.style, Product.productName, " +
                "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock" +
                " FROM (Product INNER JOIN Handlebar ON Product.productID = Handlebar.productID)" +
                "WHERE Product.productID = ?";

        PreparedStatement handleBarStatement = DbConnection.getCon().prepareStatement(getWheelSQL);
        handleBarStatement.setInt(1, productId);

        ResultSet handleBarRS = handleBarStatement.executeQuery();
        handleBarRS.next();

        return new HandleBar(productId, handleBarRS.getString(1),
                handleBarRS.getString(2),
                handleBarRS.getInt(3),
                handleBarRS.getInt(4),
                handleBarRS.getString(5),
                handleBarRS.getInt(6));
    }
    public static Frame getFrame(int productId) throws SQLException {

        String getFrameSQL = "SELECT FrameSet.frameSize, FrameSet.gears, FrameSet.shocks, Product.productName, " +
                "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock" +
                " FROM (Product INNER JOIN FrameSet ON Product.productID = FrameSet.productID)" +
                "WHERE Product.productID = ?";

        PreparedStatement frameStatement = DbConnection.getCon().prepareStatement(getFrameSQL);
        frameStatement.setInt(1, productId);

        ResultSet getFrameRS = frameStatement.executeQuery();
        getFrameRS.next();

        return new Frame(productId, getFrameRS.getInt(1),
                getFrameRS.getString(2),
                getFrameRS.getBoolean(3),
                getFrameRS.getString(4),
                getFrameRS.getInt(5),
                getFrameRS.getInt(6),
                getFrameRS.getString(7),
                getFrameRS.getInt(8));
    }
    public static ArrayList<Wheels> getAllWheels() throws SQLException {
        return getWheels(-1, Wheels.Style.ALL, Wheels.BrakeType.ALL);
    }
    public static ArrayList<HandleBar> getAllHandleBar() throws SQLException {
        return getHandleBar(HandleBar.Style.ALL);
    }
    public static ArrayList<Frame> getAllFrame() throws SQLException {
        return getFrame(-1, "ALL", "ALL");
    }
    public static ArrayList<Wheels> getWheels(double diameter, Wheels.Style style, Wheels.BrakeType brakeSystem) throws SQLException {

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
                "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock, Product.productID" +
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
    }
    public static ArrayList<HandleBar> getHandleBar(HandleBar.Style style) throws SQLException {

        String sqlWhere = "";
        if (style != HandleBar.Style.ALL){
            sqlWhere = " WHERE HandleBar.style = ?";
        }

        String sql = "SELECT HandleBar.style, Product.productName, " +
                "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock, Product.productID" +
                " FROM (Product INNER JOIN HandleBar ON Product.productID = HandleBar.productID)" +
                sqlWhere;
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);

        if (style != HandleBar.Style.ALL){
            statement.setString(1, Utils.isAllEnum(style));
        }

        ResultSet rs = statement.executeQuery();
        ArrayList<HandleBar> handleBars = new ArrayList<>();
        while (rs.next()) {
            handleBars.add(new HandleBar(rs.getInt(7), rs.getString(1),
                    rs.getString(2),
                    rs.getInt(3),
                    rs.getInt(4),
                    rs.getString(5),
                    rs.getInt(6)));
        }
        rs.close();
        return handleBars;
    }
    public static ArrayList<Frame> getFrame(int frameSize , String gears, String containsShocks) throws SQLException {

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
                "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock, Product.productID" +
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
            frames.add(new Frame(rs.getInt(9), rs.getInt(1),
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
    public static void decrementStock(int productID) throws SQLException {
//        Have a decerement exception
        String sql = "UPDATE `team002`.`Product` SET `stock` = `stock` - 1 WHERE `productID` = ?;";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setInt(1, productID);
        statement.executeUpdate();
    }
    public static void setStock(int productID, int quantity) throws SQLException {
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
    public static Order updateOrderStatus(Order order, Order.Status status) throws SQLException {
        String sql = "UPDATE `team002`.`Order` SET `orderStatus` = ? WHERE `orderID` = ?";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setString(1, status.name());
        statement.setInt(2, order.getID());
        statement.executeUpdate();
        order.setStatus(status);
        return order;
    }

//    Gets staff member from username
    public static Staff getStaff(String staffUsername) throws SQLException {
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
        Wheels wheels1 = new Wheels(5.99, Wheels.Style.ROAD, Wheels.BrakeType.RIM, "wheel1", 1, 6.88, "Brand1", 1);
        Wheels wheels2 = new Wheels(5.99, Wheels.Style.ROAD, Wheels.BrakeType.RIM, "wheel2", 1, 6.88, "Brand1", 1);
        Wheels wheels3 = new Wheels(5.99, Wheels.Style.ROAD, Wheels.BrakeType.RIM, "wheel3", 1, 6.88, "Brand1", 1);
        Wheels wheels4 = new Wheels(5.99, Wheels.Style.ROAD, Wheels.BrakeType.RIM, "wheel4", 1, 6.88, "Brand1", 1);

        Frame frame1 = new Frame(6, "Gears1", true, "Frame1", 69, 2.2, "BRandName", 42);
        Frame frame2 = new Frame(6, "Gears2", true, "Frame1", 69, 2.2, "BRandName", 42);
        Frame frame3 = new Frame(6, "Gears3", true, "Frame1", 69, 2.2, "BRandName", 42);
        Frame frame4 = new Frame(6, "Gears4", true, "Frame1", 69, 2.2, "BRandName", 42);

        HandleBar handleBar1 = new HandleBar(HandleBar.Style.DROPPED, "HandleBar1", 621, 53.77, "Brand1", 6);
        HandleBar handleBar2 = new HandleBar(HandleBar.Style.DROPPED, "HandleBar2", 621, 53.77, "Brand1", 6);
        HandleBar handleBar3 = new HandleBar(HandleBar.Style.DROPPED, "HandleBar3", 621, 53.77, "Brand1", 6);
        HandleBar handleBar4 = new HandleBar(HandleBar.Style.DROPPED, "HandleBar4", 621, 53.77, "Brand1", 6);

        Bike bike1 = new Bike(wheels1, frame1, handleBar1, "Bike1", 555, "brand1", 5);
        Bike bike2 = new Bike(wheels2, frame2, handleBar2, "Bike2", 444, "brand2", 5);
        Bike bike3 = new Bike(wheels3, frame3, handleBar3, "Bike3", 333, "brand3", 5);
        Bike bike4 = new Bike(wheels4, frame4, handleBar4, "Bike4", 222, "brand4", 5);

        Address address1 = new Address(10, "Roady", "Sheffield", "S10 4BY");
        Address address2 = new Address(9, "Roady", "Sheffield", "S10 4BY");
        Address address3 = new Address(8, "Roady", "Sheffield", "S10 4BY");
        Address address4 = new Address(7, "Roady", "Sheffield", "S10 4BY");

        Customer customer1 = new Customer("Alex", "Surname", address1);
        Customer customer2 = new Customer("Oscar", "Surname", address2);
        Customer customer3 = new Customer("Tahir", "Surname", address3);
        Customer customer4 = new Customer("Lea", "Surname", address4);

        Order order1 = new Order(Date.valueOf(LocalDate.now()), Order.Status.PENDING, customer1, bike1);
        Order order2 = new Order(Date.valueOf(LocalDate.now()), Order.Status.CONFIRMED, customer2, bike2);
        Order order3 = new Order(Date.valueOf(LocalDate.now()), Order.Status.PENDING, customer3, bike3);
        Order order4 = new Order(Date.valueOf(LocalDate.now()), Order.Status.PENDING, customer4, bike4);

        insertOrder(order1);
        insertOrder(order2);
        insertOrder(order3);
        insertOrder(order4);

        //        Inserts staff
        byte[][] salts = new byte[4][4];
        Arrays.fill(salts, Password.getSalt());
        insertStaffTable(new Staff("Staff1", Password.hashPassword("Hello", salts[0])[0], salts[0]));
        insertStaffTable(new Staff("Staff2", Password.hashPassword("Hello", salts[0])[0], salts[0]));
        insertStaffTable(new Staff("Staff3", Password.hashPassword("Hello", salts[0])[0], salts[0]));
        insertStaffTable(new Staff("Staff4", Password.hashPassword("Hello", salts[0])[0], salts[0]));
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

//    Main
    public static void main(String[] args) throws SQLException {
        System.out.println("Setting database...");
        setDatabase();
//        setDatabase();
//        ArrayList<Wheels> wheels = getWheelsWhere(-1, Wheels.Style.ROAD, Wheels.BrakeType.RIM);
//        System.out.println(wheels);

//        Address address = new Address(81, 621, "ABC123", "Sheffield", "S37ABC");
//        Customer customer = new Customer(105, "Alex", "Chapman", address);
//        updateCustomer(customer);
//        Staff staff = getStaff("aksb");
//        Boolean isCorrect = Password.checkPassword(staff.getHash(), "Hello", staff.getSalt());
        Order order = getOrder(-1);
        if (order != null){
            ArrayList<Order> order2 = getOrder(order.getCustomer().getForename(), order.getCustomer().getSurname(), order.getCustomer()
                    .getAddress());
            System.out.println(order2.get(0).getDate());
        }
        ArrayList<Order> order3 = getOrder(Order.Status.CONFIRMED);
        System.out.println(order3);
        updateOrderStatus(order3.get(0), Order.Status.FULFILLED);
        order3 = getOrder(Order.Status.All);
        for (Order odr: order3){
            System.out.println(odr.getStatus());
        }
    }
}


