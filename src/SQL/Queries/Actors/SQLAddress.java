package SQL.Queries.Actors;

import Actors.Address;
import SQL.DbConnection;

import java.sql.*;

public class SQLAddress {

//    Insert(s)
    /**
     * Used by backend to insert directly into Address table
     * @param address address object being inserted
     * @return address object with primary key set
     */
    public static Address insertAddressTable(Address address) {

        Connection con = DbConnection.getCon();
        assert con != null;

//        If the address is already in the database, use that address, if not, insert a new one
        Address retrievedAddress = getAddress(address);
        if (retrievedAddress != null){
            return retrievedAddress;
        }

        try{
            String sql = "INSERT INTO `team002`.`Address`(`houseNo`, `roadName`, `cityName`, `postCode`) VALUES (?, ?, ?, ?);";
            PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, address.getHouseNo());
            statement.setString(2, address.getRoadName());
            statement.setString(3, address.getCityName());
            statement.setString(4, address.getPostCode());
            statement.executeUpdate();
            int key = DbConnection.getPrimaryKey(statement);
            address.setAddressId(key);
            return address;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * gets the address if it is in the database, if it isn't in the database, it returns null
     * @param address address input
     * @return address or null
     */
    public static Address getAddress(Address address){
        Connection con = DbConnection.getCon();
        assert con != null;
        try{
            String getOrderSQL = "SELECT addressID, houseNo, roadName, cityName, postCode " +
                    "FROM Address WHERE Address.houseNo = ? AND Address.roadName = ? AND Address.cityName = ? AND Address.postCode = ?";

            PreparedStatement customerStatement = con.prepareStatement(getOrderSQL);
            customerStatement.setInt(1, address.getHouseNo());
            customerStatement.setString(2, address.getRoadName());
            customerStatement.setString(3, address.getCityName());
            customerStatement.setString(4, address.getPostCode());

            ResultSet getAddressRS = customerStatement.executeQuery();

            Address RSAddress = null ;
            if (getAddressRS.next()){
                RSAddress = new Address(getAddressRS.getInt(1),
                        getAddressRS.getInt(2),
                        getAddressRS.getString(3),
                        getAddressRS.getString(4),
                        getAddressRS.getString(5));
            }
            return RSAddress;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
