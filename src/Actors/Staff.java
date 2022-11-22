package Actors;

public class Staff {
//    variables
    private String username;
    private String password;

    /**
     * Constructor for a Staff
     * @param username Username of the staff
     * @param password Password
     */
    public Staff (String username, String password){
        this.username = username;
        this.password = password;
    }

//    getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public boolean passwordIsCorrect(String password){
        boolean result = false;
        if (password.equals(this.password))
            result = true;
        return result;
    }
}
