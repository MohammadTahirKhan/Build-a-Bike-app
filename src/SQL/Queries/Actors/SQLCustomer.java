package SQL.Queries.Actors;

import Actors.Address;
import Actors.Customer;
import SQL.DbConnection;

import java.sql.*;

public class SQLCustomer {

//    Insert(s)
    /**
     * Used by backend to insert directly into Customer table
     * @param customer customer object
     * @return  customer object with primary key set
     */
    public static Customer insertCustomerTable(Customer customer) {

        Connection con = DbConnection.getCon();
        assert con != null;

//        If the customer has already ordered a bike, return that object, if not, insert a new customer into the database
        Customer retrievedCustomer = getCustomer(customer);
        if (retrievedCustomer != null){
            return retrievedCustomer;
        }

        try{
            String sql = "INSERT INTO `team002`.`Customer` (`forename`, `surname`, `addressID`) VALUES (?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, customer.getForename());
            statement.setString(2, customer.getSurname());
            statement.setInt(3, customer.getAddress().getAddressId());
            statement.executeUpdate();
            int key = DbConnection.getPrimaryKey(statement);
            customer.setCustomerId(key);
            return customer;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


//    Getter(s)
    /**
     * Get a customer by customerID
     * @param customerID customer ID of customer
     * @return customer object
     */
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
            e.printStackTrace();
            DbConnection.rollback(con);
        } finally{
            DbConnection.setAutoCommit(con, true);
        }
        return null;
    }

    /**
     * Checks if a customer exists, if it does it returns them, if not, it returns null
     * @param customer input customer
     * @return customer or null
     */
    public static Customer getCustomer(Customer customer){

        Connection con = DbConnection.getCon();
        assert con != null;

        try{
            String getCustomerSQL = "SELECT Customer.forename, Customer.surname, Customer.addressID, Address.houseNo, " +
                    "Address.roadName, Address.cityName, Address.postCode, Customer.customerID " +
                    "FROM (Customer INNER JOIN Address ON Address.addressID = Customer.addressID) " +
                    "WHERE Customer.forename = ? AND Customer.surname = ? AND Customer.addressID = ?";

            PreparedStatement customerStatement = DbConnection.getCon().prepareStatement(getCustomerSQL);
            customerStatement.setString(1, customer.getForename());
            customerStatement.setString(2, customer.getSurname());
            customerStatement.setInt(3, customer.getAddress().getAddressId());

            ResultSet getCustomerRS = customerStatement.executeQuery();
            if (getCustomerRS.next()){
                Address address = new Address(getCustomerRS.getInt(3), getCustomerRS.getInt(4),
                        getCustomerRS.getString(5), getCustomerRS.getString(6),
                        getCustomerRS.getString(7));
                return new Customer(getCustomerRS.getInt(8), getCustomerRS.getString(1), getCustomerRS.getString(2), address);
            } else{
                return null;
            }

        } catch (SQLException e){
//            If commit fails, rollback
            e.printStackTrace();
            DbConnection.rollback(con);
        }
        return null;
    }


//    Update Customer
    /**
     * Used to update the customer in the database
     * @param customer Customer object that is being set into the database
     */
    public static void updateCustomer(Customer customer) {


//        Get connection, and set up transaction
        Connection con = DbConnection.getCon();
        assert con != null;

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
            e.printStackTrace();
            DbConnection.rollback(con);
        } finally{
            DbConnection.setAutoCommit(con, true);
        }
    }
}
