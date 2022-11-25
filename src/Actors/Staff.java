package Actors;

public class Staff {
//    variables
    private String username;
    private byte[] hash;
    private byte[] salt;

    /**
     * Constructor for a Staff
     * @param username Username of the staff
     * @param password Password
     */
    public Staff(String username, byte[] hash, byte[] salt) {
        this.username = username;
        this.hash = hash;
        this.salt = salt;
    }

//    getters and setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public byte[] getHash() {
        return hash;
    }

    public void setHash(byte[] hash) {
        this.hash = hash;
    }

    public byte[] getSalt() {
        return salt;
    }

    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
