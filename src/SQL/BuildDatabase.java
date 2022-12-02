package SQL;

import static SQL.Queries.SQLUtils.setDatabase;

public class BuildDatabase {


    /**
     * Running this will clear then populate the database
     * @param args Null
     */
    public static void main(String[] args) {
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


