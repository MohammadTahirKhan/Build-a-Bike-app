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
    private static Product insertProductTable(Product product) {
        try{
            String sql = "INSERT INTO `team002`.`Product` (`productName`,`unitCost`,`brandName`,`serialNumber`,`stock`) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getItemCost());
            statement.setString(3, product.getBrandName());
            statement.setInt(4, product.getSerialNumber());
            statement.setInt(5, product.getStock());

            statement = DbConnection.executeUpdate(statement);
            ResultSet rs = statement.getGeneratedKeys();
            int productID = -1;
            if (rs.next()) {
                productID = rs.getInt(1);
                product.setPKey(productID);
                return product;
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
}
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
        } catch (Exception e1){
//            If commit fails, rollback
            e1.printStackTrace();
            DbConnection.rollback(con);
        } finally{
            DbConnection.setAutoCommit(con, true);
        }
        return null;
    }
    private static Frame insertFrameTable(Frame frame) {
//        Get connection, and set up transaction
        Connection con = DbConnection.getCon();
        assert con != null;
        try {
            con.setAutoCommit(false);
            int productID = insertProductTable(frame.getProduct()).getPKey();
            String sql = "INSERT INTO `team002`.`FrameSet` (`productID`,`frameSize`,`shocks`,`gears`) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
            statement.setInt(1, productID);
            statement.setInt(2, frame.getFrameSize());
            statement.setBoolean(3, frame.isContainsShocks());
            statement.setString(4, frame.getGears());
            statement.executeUpdate();
            frame.setPKey(productID);
            con.commit();
            return frame;
        } catch (Exception e1){
//            If commit fails, rollback
            e1.printStackTrace();
            DbConnection.rollback(con);
        } finally{
            DbConnection.setAutoCommit(con, true);

        }
        return null;
    }
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
        } catch (Exception e1) {
//            If commit fails, rollback
            e1.printStackTrace();
            DbConnection.rollback(con);
        } finally {
            DbConnection.setAutoCommit(con, true);
        }
        return null;
    }
    private static Bike insertBikeTable(Bike bike){
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
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private static Address insertAddressTable(Address address) {
        try{
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
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private static Order insertOrderTable(Order order) {
        try{
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
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private static Customer insertCustomerTable(Customer customer) {
        try{
            String sql = "INSERT INTO `team002`.`Customer` (`forename`, `surname`, `addressID`) VALUES (?, ?, ?);";
            PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getForename());
            statement.setString(2, customer.getSurname());
            statement.setInt(3, customer.getAddress().getAddressId());
            statement.executeUpdate();
            int key = DbConnection.getPrimaryKey(statement);
            customer.setCustomerId(key);
            return customer;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    private static Staff insertStaffTable(Staff staff) {
        try{
            String sql = "INSERT INTO `team002`.`Staff` (`username`, `hash`, `salt`) VALUES (?, ?, ?);";
            PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, staff.getUsername());
            statement.setBytes(2, staff.getHash());
            statement.setBytes(3, staff.getSalt());
            statement.executeUpdate();
            return staff;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

//    Get order
    public static Order getOrder(int orderId) {

        Connection con = DbConnection.getCon();
        assert con != null;
        try{
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
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;


    }
    public static ArrayList<Order> getOrder(String forename, String surname, int houseNum, String postCode) {

        Connection con = DbConnection.getCon();
        assert con != null;
        try{
            String getOrderSQL = "SELECT team002.Order.orderID " +
                    "FROM (team002.Order INNER JOIN Customer ON team002.Order.customerID = Customer.customerID INNER JOIN Address ON Customer.addressID = Address.addressID) " +
                    "WHERE Customer.forename = ? AND Customer.surname = ? AND Address.houseNo = ? AND Address.postCode = ?";

            PreparedStatement customerStatement = con.prepareStatement(getOrderSQL);
            customerStatement.setString(1, forename);
            customerStatement.setString(2, surname);
            customerStatement.setInt(3, houseNum);
            customerStatement.setString(4, postCode);

            ResultSet getCustomerRS = customerStatement.executeQuery();

            ArrayList<Order> orders = new ArrayList<>();
            while (getCustomerRS.next()){
                orders.add(getOrder(getCustomerRS.getInt(1)));
            }
            if (!orders.isEmpty())
                return orders;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }
    public static ArrayList<Order> getOrder(Order.Status orderStatus) {

        Connection con = DbConnection.getCon();
        assert con != null;
        try{

            String orderSQL = "";
            if (orderStatus != Order.Status.All){
                orderSQL = "WHERE Order.orderStatus = ?";
            }

            String getOrderSQL = "SELECT team002.Order.orderID " +
                    "FROM (team002.Order INNER JOIN Customer ON team002.Order.customerID = Customer.customerID INNER JOIN Address ON Customer.addressID = Address.addressID) "
                    + orderSQL;

            PreparedStatement customerStatement = con.prepareStatement(getOrderSQL);
            if (orderStatus != Order.Status.All){
                customerStatement.setString(1, orderStatus.name());
            }
            ResultSet getCustomerRS = customerStatement.executeQuery();

            ArrayList<Order> orders = new ArrayList<>();
            while (getCustomerRS.next()){
                orders.add(getOrder(getCustomerRS.getInt(1)));
            }
            return orders;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

//    Insert order
    public static Wheels insertWheels(Wheels wheel) {
        return insertWheelTable(wheel);
    }
    public static Frame insertFrame(Frame frame) {
        return insertFrameTable(frame);
    }
    public static HandleBar insertHandleBar(HandleBar handleBar) {
        return insertHandleBarTable(handleBar);
    }
    public static Order insertOrder(Order order) {
        Connection con = DbConnection.getCon();
        assert con != null;
        try {
            DbConnection.setAutoCommit(con, false);

            order.getCustomer().setAddress(insertAddressTable(order.getCustomer().getAddress()));
            order.setCustomer(insertCustomerTable(order.getCustomer()));
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
            DbConnection.setAutoCommit(con, true);
        }
        return null;
    }

//    Get Customer
    public static Customer getCustomer(int customerID) {

        Connection con = DbConnection.getCon();
        assert con != null;

        try{
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
        } catch (SQLException e){
//            If commit fails, rollback
            System.out.println(e);
            DbConnection.rollback(con);
        } finally{
            DbConnection.setAutoCommit(con, true);
        }
        return null;
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

        String FrameFrameSize = "FrameSet.frameSize = ? AND ";
        String FrameGears = "FrameSet.gears = ? AND ";
        String FrameContainsShocks = "FrameSet.containsShocks = ? AND ";
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

        String sql = "SELECT FrameSet.frameSize, FrameSet.gears, FrameSet.containsShocks, Product.productName, " +
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
    public static void decrementStock(Order order) throws SQLException {

//    Get connection, and set up transaction
    Connection con = DbConnection.getCon();
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
        System.out.println(e);
        DbConnection.rollback(con);
    } finally{
        con.setAutoCommit(true);
    }

    }
    private static void decrementStock(Product product) throws SQLException {
//        Have a decrement exception
        String sql = "UPDATE `team002`.`Product` SET `stock` = `stock` - 1 WHERE `productID` = ?;";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setInt(1, product.getPKey());
        statement.executeUpdate();
    }
    public static void setStock(Product product, int quantity) throws SQLException {
        setStock(product.getPKey(), quantity);
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
    public static Staff getStaff(String staffUsername, String inputPassword) throws SQLException {
        String sql = "SELECT Staff.hash, Staff.salt FROM `team002`.`Staff` WHERE Staff.username = ?";
        PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
        statement.setString(1, staffUsername);
        ResultSet rs = statement.executeQuery();

        if(rs.next()) {
            byte[] hash = rs.getBytes(1);
            byte[] salt = rs.getBytes(2);
            Staff staff = new Staff(staffUsername, hash, salt);
            boolean isCorrect = Password.checkPassword(staff.getHash(), inputPassword, staff.getSalt());
            if (isCorrect)
                return staff;
        }
        return null;
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
        Wheels wheels1 = insertWheels(new Wheels(24, Wheels.Style.HYBRID, Wheels.BrakeType.RIM, "HS127", 1, 21.49, "Schwalbe", 61));
        Wheels wheels2 = insertWheels(new Wheels(24, Wheels.Style.MOUNTAIN, Wheels.BrakeType.DISKBRAKE, "Land Cruiser", 2, 19.99, "Schwalbe", 12));
        Wheels wheels3 = insertWheels(new Wheels(24, Wheels.Style.ROAD, Wheels.BrakeType.RIM, "Wheelchair Rightrun", 3, 26.99, "Schwalbe", 46));
        Wheels wheels4 = insertWheels(new Wheels(24, Wheels.Style.HYBRID, Wheels.BrakeType.RIM, "Halfords Hybrid", 4, 13.00, "Halfords", 69));
        Wheels wheels5 = insertWheels(new Wheels(20, Wheels.Style.MOUNTAIN, Wheels.BrakeType.RIM, "BMX Tyre", 5, 12.00, "Halfords", 24));
        Wheels wheels6 = insertWheels(new Wheels(20, Wheels.Style.MOUNTAIN, Wheels.BrakeType.RIM, "Black Jack", 6, 9.99, "Bontrager", 69));
        Wheels wheels7 = insertWheels(new Wheels(18, Wheels.Style.HYBRID, Wheels.BrakeType.RIM, "Essentials Kids", 7, 12.00, "Halfords", 14));
        Wheels wheels8 = insertWheels(new Wheels(16, Wheels.Style.ROAD, Wheels.BrakeType.DISKBRAKE, "Marathon Plus", 8, 32.65, "Schwalbe", 23));

        Frame frame1 = insertFrame(new Frame(160, "Speed Disc Brake", false, "Superstar Caliper", 1, 1398.99, "Cinelli", 4));
        Frame frame2 = insertFrame(new Frame(166, "Hard Mountain brakes", true, "Mega 290 Carbon Mountain", 2, 1889.99, "Nukeproof", 1));
        Frame frame3 = insertFrame(new Frame(166, "Hard Mountain brakes", false, "Scout 290 Alloy MTB", 4, 349.99, "Nukeproof", 36));
        Frame frame4 = insertFrame(new Frame(155, "High quality road brakes", false, "Vitesse EVO", 5, 999.99, "Vitus", 17));
        Frame frame5 = insertFrame(new Frame(172, "Medium mountain brakes", true, "Giga 290 Carbon Frame", 6, 2799.99, "Nukeproof", 5));
        Frame frame6 = insertFrame(new Frame(172, "Medium road Brakes", false, "Mmmbop Hardtail", 7, 209.99, "Ragley", 89));

        HandleBar handleBar1 = insertHandleBar(new HandleBar(HandleBar.Style.STRAIGHT, "HB-M11 Pro Riser-Bar", 1, 26.43, "XLC", 120));
        HandleBar handleBar2 = insertHandleBar(new HandleBar(HandleBar.Style.HIGH, "HB-C08 Comp Ergo-Bar", 2, 18.00, "XLC", 74));
        HandleBar handleBar3 = insertHandleBar(new HandleBar(HandleBar.Style.HIGH, "HB-T03 Pro Tri-Bar", 3, 45.86, "XLC", 54));
        HandleBar handleBar4 = insertHandleBar(new HandleBar(HandleBar.Style.STRAIGHT, "HB-C02 Trekking Handlebar", 4, 15.89, "XLC", 28));
        HandleBar handleBar5 = insertHandleBar(new HandleBar(HandleBar.Style.DROPPED, "SL 70 XPLR", 5, 125.00, "ZIPP", 17));
        HandleBar handleBar6 = insertHandleBar(new HandleBar(HandleBar.Style.DROPPED, "Alumina Base Bar", 6, 79.00, "Vuka", 95));
        HandleBar handleBar7 = insertHandleBar(new HandleBar(HandleBar.Style.STRAIGHT, "Descendant Riser", 7, 75.00, "Truvative", 64));
        HandleBar handleBar8 = insertHandleBar(new HandleBar(HandleBar.Style.DROPPED, "Course 80 Ergonomic", 8, 60.00, "ZIPP", 28));

        Bike bike1 = new Bike(wheels1, frame3, handleBar4, "Bike1", 555, "brand1", 5);
        Bike bike2 = new Bike(wheels6, frame5, handleBar2, "Bike2", 444, "brand2", 5);
        Bike bike3 = new Bike(wheels1, frame4, handleBar1, "Bike3", 333, "brand3", 5);
        Bike bike4 = new Bike(wheels5, frame2, handleBar6, "Bike4", 222, "brand4", 5);
        Bike bike5 = new Bike(wheels5, frame3, handleBar5, "Bike4", 222, "brand4", 5);
        Bike bike6 = new Bike(wheels3, frame6, handleBar8, "Bike4", 222, "brand4", 5);
        Bike bike7 = new Bike(wheels8, frame1, handleBar3, "Bike4", 222, "brand4", 5);
        Bike bike8 = new Bike(wheels2, frame4, handleBar2, "Bike4", 222, "brand4", 5);


        Address address1 = new Address(14, "Mappin Steet", "Sheffield", "S1 4DT");
        Address address2 = new Address(6, "Blundell Road", "Hightown", "L38 9EQ");
        Address address3 = new Address(468, "Aberford Road", "Stanley", "WF3 4AG");
        Address address4 = new Address(3, "Meadowside", "Wendron", "TR13 0LT");
        Address address5 = new Address(3, "Woodlands Close", "Barrow-Upon-Humber", "DN19 7DX");
        Address address6 = new Address(4, "North Hall", "St Ishmaels", "SA62 3SW");
        Address address7 = new Address(35, "Luke Street", "London", "EC2A 4LH");
        Address address8 = new Address(153, "Kingsland Road", "Birmingham", "B44 9QA");

        Customer customer1 = new Customer("Alex", "Surname", address1);
        Customer customer2 = new Customer("Oscar", "Surname", address2);
        Customer customer3 = new Customer("Tahir", "Surname", address3);
        Customer customer4 = new Customer("Bryon", "Gallacher", address4);
        Customer customer5 = new Customer("Margot ", "Niles", address5);
        Customer customer6 = new Customer("Rachael ", "Marshall", address6);
        Customer customer7 = new Customer("Mike ", "Stuart", address7);
        Customer customer8 = new Customer("Josephine ", "Tyler", address8);

        Order order1 = new Order(Date.valueOf(LocalDate.now()), Order.Status.PENDING, customer1, bike1);
        Order order2 = new Order(Date.valueOf(LocalDate.now()), Order.Status.CONFIRMED, customer2, bike2);
        Order order3 = new Order(Date.valueOf(LocalDate.now()), Order.Status.PENDING, customer3, bike3);
        Order order4 = new Order(Date.valueOf(LocalDate.now()), Order.Status.PENDING, customer4, bike4);
        Order order5 = new Order(Date.valueOf(LocalDate.now()), Order.Status.PENDING, customer5, bike5);
        Order order6 = new Order(Date.valueOf(LocalDate.now()), Order.Status.CONFIRMED, customer6, bike6);
        Order order7 = new Order(Date.valueOf(LocalDate.now()), Order.Status.FULFILLED, customer7, bike7);
        Order order8 = new Order(Date.valueOf(LocalDate.now()), Order.Status.PENDING, customer8, bike8);

        insertOrder(order1);
        insertOrder(order2);
        insertOrder(order3);
        insertOrder(order4);
        insertOrder(order5);
        insertOrder(order6);
        insertOrder(order7);
        insertOrder(order8);

        //        Inserts staff
        byte[][] salts = new byte[4][4];
        Arrays.fill(salts, Password.getSalt());
        insertStaffTable(new Staff("Staff1", Password.hashPassword("Password", salts[0])[0], salts[0]));
        insertStaffTable(new Staff("Staff2", Password.hashPassword("RockYou", salts[1])[0], salts[1]));
        insertStaffTable(new Staff("Staff3", Password.hashPassword("Hello", salts[2])[0], salts[2]));
        insertStaffTable(new Staff("test", Password.hashPassword("test", salts[3])[0], salts[3]));
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
                    .getAddress().getHouseNo(), order.getCustomer()
                    .getAddress().getPostCode());
            System.out.println(order2.get(0).getDate());
        }
        ArrayList<Order> order3 = getOrder(Order.Status.CONFIRMED);
        System.out.println(order3);
        System.out.println(order3.get(0).getBike().getWheels().getStock());
        decrementStock(order3.get(0));
        order3 = getOrder(Order.Status.CONFIRMED);
        System.out.println(order3.get(0).getBike().getWheels().getStock());
    }
}


