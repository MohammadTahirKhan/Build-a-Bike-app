package SQL;

import java.sql.SQLException;

import static SQL.Queries.Order.SQLOrder.getOrder;
import static SQL.Queries.SQLUtils.setDatabase;


public class BuildDatabase {

//    Main
    public static void main(String[] args) throws SQLException {
        System.out.println("Setting database...");
        try {
            setDatabase();
            System.out.println("Success!");
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Failure!");
        }



    }
}


