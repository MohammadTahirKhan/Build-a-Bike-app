package SQL.Queries;

public class InvalidPrimaryKeyException extends Exception {
    public InvalidPrimaryKeyException(String exceptionDetails) {
        super(exceptionDetails + " is an invalid primary key");
    }
}
