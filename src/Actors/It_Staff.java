package Actors;

import SQL.Queries;
public class It_Staff extends Staff {
    /**
     * Constructor for an IT Staff
     * @param username username of the IT Staff
     * @param password Password
     */
    public It_Staff(String username, String password) {
        super(username, password);
    }
//    public static Staff[] pullStaff(){
//        return Queries.getStaff();
//    }

}
