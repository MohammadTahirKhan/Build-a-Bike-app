package SQL.Queries.Actors;

import Actors.Staff;
import SQL.DbConnection;
import SQL.Password;

import java.sql.*;

public class SQLStaff {

    /**
     * Used by backend to insert directly into Staff table
     * @param staff staff object
     * @return  staff object with primary key set
     */
    public static Staff insertStaffTable(Staff staff) {
        try{
            String sql = "INSERT INTO `team002`.`Staff` (`username`, `hash`, `salt`) VALUES (?, ?, ?);";
            PreparedStatement statement = DbConnection.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, staff.getUsername());
            statement.setBytes(2, staff.getHash());
            statement.setBytes(3, staff.getSalt());
            statement.executeUpdate();
            return staff;
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets a staff member by their username and password
     * @param staffUsername Staff member username
     * @param inputPassword Staff member password
     * @return  staff object
     */
    public static Staff getStaff(String staffUsername, String inputPassword) {
        Connection con = DbConnection.getCon();
        assert con != null;

        try{
            String sql = "SELECT Staff.hash, Staff.salt FROM `team002`.`Staff` WHERE Staff.username = ?";
            PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
            statement.setString(1, staffUsername);
            ResultSet rs = statement.executeQuery();

            if(rs.next()) {
                byte[] hash = rs.getBytes(1);
                byte[] salt = rs.getBytes(2);
                Staff staff = new Staff(staffUsername, hash, salt);
                boolean isCorrect = Password.checkPassword(inputPassword, staff.getSalt(), staff.getHash());
                if (isCorrect)
                    return staff;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
