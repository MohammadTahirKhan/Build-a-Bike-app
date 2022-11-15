package Actors;

public class Staff {
    private String username;
    private String password;

    public Staff (String username, String password){
        this.username = username;
        this.password = password;
    }

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