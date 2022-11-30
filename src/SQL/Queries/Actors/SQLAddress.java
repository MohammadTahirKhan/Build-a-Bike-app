package SQL.Queries.Actors;

import Actors.Address;
import SQL.DbConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLAddress {

    /**
     * Used by backend to insert directly into Address table
     * @param address address object being inserted
     * @return address object with primary key set
     */
    public static Address insertAddressTable(Address address) {
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
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


}
