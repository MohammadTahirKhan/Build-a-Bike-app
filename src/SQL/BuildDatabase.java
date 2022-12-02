package SQL;

import java.sql.SQLException;
import static SQL.Queries.SQLUtils.setDatabase;

public class BuildDatabase {


    /**
     * Running this will clear then populate the database
     * @param args Null
     * @throws SQLException If there is an issue deleting the database contents
     */
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


