package SQL.Queries.Product;

import Product.Frame;
import SQL.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static SQL.Queries.Product.SQLProduct.insertProductTable;

public class SQLFrame {


//    Inserting frame
    /**
     * Used by backend to insert directly into Frame table
     * @param frame Frame object
     * @return frame object with the primary key set
     */
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
            statement.setInt(4, frame.getGears());
            statement.executeUpdate();
            frame.setPKey(productID);
            con.commit();
            return frame;
        } catch (SQLException e1){
//            If commit fails, rollback
            e1.printStackTrace();
            DbConnection.rollback(con);
        } finally{
            DbConnection.setAutoCommit(con, true);

        }
        return null;
    }

    /**
     *  Used by front end to insert Frame to database
     * @param frame frame object
     * @return frame object with the primary key set
     */
    public static Frame insertFrame(Frame frame) {
        return insertFrameTable(frame);
    }


//    Getting frame
    /**
     * Gets a frame by the productID
     * @param productId productID of the frame
     * @return frame object with primary key set
     */
    public static Frame getFrame(int productId) {
        Connection con = DbConnection.getCon();
        assert con != null;
        try {

            String getFrameSQL = "SELECT FrameSet.frameSize, FrameSet.gears, FrameSet.shocks, Product.productName, " +
                    "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock" +
                    " FROM (Product INNER JOIN FrameSet ON Product.productID = FrameSet.productID)" +
                    "WHERE Product.productID = ?";

            PreparedStatement frameStatement = DbConnection.getCon().prepareStatement(getFrameSQL);
            frameStatement.setInt(1, productId);

            ResultSet getFrameRS = frameStatement.executeQuery();
            getFrameRS.next();

            return new Frame(productId, getFrameRS.getInt(1),
                    getFrameRS.getInt(2),
                    getFrameRS.getBoolean(3),
                    getFrameRS.getString(4),
                    getFrameRS.getInt(5),
                    getFrameRS.getInt(6),
                    getFrameRS.getString(7),
                    getFrameRS.getInt(8));
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Gets all frames from the database
     * @return Arraylist of frames
     */
    public static ArrayList<Frame> getAllFrame() {
        return getFrame(-1, "ALL", "ALL");
    }

    /**
     * Gets the frames where the filters are true
     * @param frameSize if -1, gets all, else, gets specific size
     * @param gears if -1, gets all, else, gets specific number of gears
     * @param containsShocks if ALL, gets all, else, get boolean shocks
     * @return Arraylist of all the frames where the filter(s) are true
     */
    public static ArrayList<Frame> getFrame(int frameSize , String gears, String containsShocks) {

        Connection con = DbConnection.getCon();
        assert con != null;

        try {

            String FrameFrameSize = "FrameSet.frameSize = ? AND ";
            String FrameGears = "FrameSet.gears = ? AND ";
            String FrameContainsShocks = "FrameSet.containsShocks = ? AND ";
            String whereString = " WHERE ";

            if (frameSize != -1) {
                whereString += FrameFrameSize;
            }
            if (!gears.equals("ALL")) {
                whereString += FrameGears;
            }
            if (!containsShocks.equals("ALL")) {
                whereString += FrameContainsShocks;
            }

            String sqlWhere = "";
            if (whereString.length() > 8) {
                sqlWhere = whereString.substring(0, whereString.length() - 5);
            }

            String sql = "SELECT FrameSet.frameSize, FrameSet.gears, FrameSet.containsShocks, Product.productName, " +
                    "Product.serialNumber, Product.unitCost, Product.brandName, Product.Stock, Product.productID" +
                    " FROM (Product INNER JOIN FrameSet ON Product.productID = FrameSet.productID)" +
                    sqlWhere;

            PreparedStatement statement = DbConnection.getCon().prepareStatement(sql);
            int currentParameter = 1;
            if (frameSize != -1) {
                statement.setInt(currentParameter, frameSize);
            }
            if (!gears.equals("ALL")) {
                statement.setString(currentParameter, gears);
            }
            if (!containsShocks.equals("ALL")) {
                statement.setBoolean(currentParameter, Boolean.getBoolean(containsShocks));
            }

            ResultSet rs = statement.executeQuery();
            ArrayList<Frame> frames = new ArrayList<Frame>();
            if (rs.next()) {
                frames.add(new Frame(rs.getInt(9), rs.getInt(1),
                        rs.getInt(2),
                        rs.getBoolean(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getInt(8)));
            }
            rs.close();
            return frames;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


}
