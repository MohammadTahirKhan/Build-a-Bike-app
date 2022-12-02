package SQL.Queries.Order;

import Actors.Customer;
import Order.Order;
import Product.Bike;
import SQL.DbConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

import static SQL.Queries.Actors.SQLAddress.insertAddressTable;
import static SQL.Queries.Actors.SQLCustomer.getCustomer;
import static SQL.Queries.Actors.SQLCustomer.insertCustomerTable;
import static SQL.Queries.Product.SQLBike.getBike;
import static SQL.Queries.Product.SQLBike.insertBikeTable;

public class SQLOrder {

//    Inserts into Database
    /**
     * Used by backend to insert directly into Order table
     * @param order Order object being inserted
     * @return order object with primary key set
     */
    private static Order insertOrderTable(Order order) {
        order.setCost();
        try{
            String sql = "INSERT INTO `team002`.`Order` (`orderDate`, `orderCost`, `orderStatus`, `customerID`, `productID`) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = Objects.requireNonNull(DbConnection.getCon()).prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, (Date) order.getDate());
            statement.setDouble(2, order.getCost());
            statement.setString(3, order.getStatus().name());
            statement.setInt(4, order.getCustomer().getCustomerId());
            statement.setInt(5, order.getBike().getPKey());
            statement.executeUpdate();
            int key = DbConnection.getPrimaryKey(statement);
            order.setID(key);
            return order;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Inserts order into database
     * @param order order wanting to be inserted
     * @return  Order object with the primary key set
     */
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
            DbConnection.setAutoCommit(con, true);
            return order;
//            Commit the queries
        } catch (SQLException e){
//            If commit fails, rollback
            System.out.println(e);
            DbConnection.rollback(con);
        }
        DbConnection.setAutoCommit(con, true);
        return null;
    }


//    Getting order
    /**
     * Get specific order from database
     * @param orderId  orderID of product wanted from the database
     * @return  Order object from database
     */
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
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * get order if productID is unknown
     * @param forename  forname of customer
     * @param surname   surname of customer
     * @param houseNum  houseNum of customer
     * @param postCode  postCode of customer
     * @return  Arraylist of Orders
     */
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
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;

    }

    /**
     * Get all orders where the order status is X
     * @param orderStatus   if status is ALL, gets all, else, gets where filter is true
     * @return  Arraylist of Orders
     */
    @SuppressWarnings("JpaQueryApiInspection")
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
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


//    Deleting order
    /**
     * used to delete an order from the database via order ID
     * @param orderID orderID of order
     */
    public static void deleteOrder(int orderID) {
        Connection con = DbConnection.getCon();
        assert con != null;
        try{
            String sql = "DELETE FROM `team002`.`Order` WHERE Order.orderID = ? AND Order.orderStatus = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, orderID);
            statement.setString(2, Order.Status.PENDING.name());
            statement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        }

    }


//    Updating Order
    /**
     * Used to update the order status of an order
     *
     * @param order  order where the status needs changing
     * @param status new status of order
     */
    public static void updateOrderStatus(Order order, Order.Status status) {
        Connection con = DbConnection.getCon();
        assert con != null;

        try {
            String sql = "UPDATE `team002`.`Order` SET `orderStatus` = ? WHERE `orderID` = ?";
            PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
            statement.setString(1, status.name());
            statement.setInt(2, order.getID());
            statement.executeUpdate();
            order.setStatus(status);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
