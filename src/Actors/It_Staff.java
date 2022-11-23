package Actors;

import SQL.Queries;
public class It_Staff extends Staff {

    public It_Staff(String username, byte[] hash, byte[] salt) {

        super(username, hash, salt);
    }


//    public static Staff[] pullStaff(){
//        return Queries.getStaff();
//    }
}
