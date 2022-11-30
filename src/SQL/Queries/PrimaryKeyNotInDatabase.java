package SQL.Queries;

public class PrimaryKeyNotInDatabase extends Exception{
    public PrimaryKeyNotInDatabase(String objectName) {
        super(objectName + " is already in the database");
    }
}
