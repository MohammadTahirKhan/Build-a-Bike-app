package Actors;

public class Staff {
//    variables
    private String username;
    private byte[] hash;
    private byte[] salt;

    /**
     * Constructor for a Staff
     * @param username staff username
     * @param hash hash
     * @param salt salt
     */
    public Staff(String username, byte[] hash, byte[] salt) {
        this.username = username;
        this.hash = hash;
        this.salt = salt;
    }

//    Getters
    public String getUsername() {
        return username;
    }
    public byte[] getHash() {
        return hash;
    }
    public byte[] getSalt() {
        return salt;
    }

//    Setters
    public void setUsername(String username) {
        this.username = username;
    }
    public void setHash(byte[] hash) {
        this.hash = hash;
    }
    public void setSalt(byte[] salt) {
        this.salt = salt;
    }
}
